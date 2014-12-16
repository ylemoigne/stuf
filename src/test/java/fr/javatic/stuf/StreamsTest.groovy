/*
 * Copyright 2014 Yann Le Moigne
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.javatic.stuf

import fr.javatic.stuf.tuples.Tuple2
import spock.lang.Specification

import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream

class StreamsTest extends Specification {
    def "Streams.from(Iterable)"() {
        given:
        "An Iterable of 5 elements"
        def it = [2, 3, 4, 5, 6]

        when:
        "I get a stream from Streams.from(iterable)"
        def stream = Streams.from(it);

        then:
        "I should be able to get 5 elements from the stream then it finish normally"
        stream.collect(Collectors.toList()) == [2, 3, 4, 5, 6]
    }

    def "Streams.from(Iterator)"() {
        given:
        "An Iterator give 5 elements"
        def it = new Iterator<Integer>() {
            def current = 2;

            @Override
            boolean hasNext() {
                return !(current > 6)
            }

            @Override
            Integer next() {
                if (current > 6) {
                    throw new NoSuchElementException();
                }
                return current++;
            }
        }

        when:
        "I get a stream from Streams.from(iterator)"
        def stream = Streams.from(it);

        then:
        "I should be able to get 5 elements from the stream then it finish normally"
        stream.collect(Collectors.toList()) == [2, 3, 4, 5, 6]
    }

    def "Streams.from(Supplier)"() {
        given:
        "A supplier which give 5 elements then throw NoSuchElementException"
        def supp = new Supplier<Integer>() {
            def current = 2;

            @Override
            Integer get() {
                if (current > 6) {
                    throw new NoSuchElementException();
                }
                return current++;
            }
        }

        when:
        "I get a stream from Streams.from(supplier)"
        def stream = Streams.from(supp);

        then:
        "I should be able to get 5 elements from the stream then it finish normally"
        stream.collect(Collectors.toList()) == [2, 3, 4, 5, 6]
    }

    def "Streams.zip(StreamA,StreamB) of same size"() {
        given:
        "A streamA of 2,3,4,5,6"
        "A streamB of b,c,d,e,f"
        def streamA = Stream.of(2, 3, 4, 5, 6)
        def streamB = Stream.of("b", "c", "d", "e", "f")

        when:
        "I get a stream from Streams.zip(streamA, streamB)"
        def stream = Streams.zip(streamA, streamB);

        then:
        "I should get a stream of tuple 2b,3c,4d,5e,6e"
        stream.collect(Collectors.toList()) == [new Tuple2(2, "b"), new Tuple2(3, "c"), new Tuple2(4, "d"), new Tuple2(5, "e"), new Tuple2(6, "f")]
    }

    def "Streams.zip(StreamA,StreamB) of different size"() {
        given:
        "A streamA of 2,3,4,5,6,7,8,9"
        "A streamB of b,c,d,e,f"
        def streamA = Stream.of(2, 3, 4, 5, 6, 7, 8, 9)
        def streamB = Stream.of("b", "c", "d", "e", "f")

        when:
        "I get a stream from Streams.zip(streamA, streamB)"
        def stream = Streams.zip(streamA, streamB);

        then:
        "I should get a stream of tuple 2b,3c,4d,5e,6e"
        stream.collect(Collectors.toList()) == [new Tuple2(2, "b"), new Tuple2(3, "c"), new Tuple2(4, "d"), new Tuple2(5, "e"), new Tuple2(6, "f")]
    }

    def "Streams.zipWithIndex(StreamA)"() {
        given:
        "A streamA of b,c,d,e,f"
        def streamA = Stream.of("b", "c", "d", "e", "f")

        when:
        "I get a stream from Streams.zipWithIndex(streamA)"
        def stream = Streams.zipWithIndex(streamA);

        then:
        "I should get a stream of tuple 0b,1c,2d,3e,4e"
        stream.collect(Collectors.toList()) == [new Tuple2(0, "b"), new Tuple2(1, "c"), new Tuple2(2, "d"), new Tuple2(3, "e"), new Tuple2(4, "f")]
    }

    def "Streams.unzip(StreamA) and collect _1 then _2"() {
        given:
        "A streamA of 2b,3c,4d,5e,6f"
        def streamA = Stream.of(new Tuple2(2, "b"), new Tuple2(3, "c"), new Tuple2(4, "d"), new Tuple2(5, "e"), new Tuple2(6, "f"))

        when:
        "I get a stream from Streams.unzip(streamA)"
        def streamTuple = Streams.unzip(streamA);

        then:
        "I should get a stream of 2,3,4,5,6"
        streamTuple._1.collect(Collectors.toList()) == [2, 3, 4, 5, 6]
        "And a stream of b,c,d,e,f"
        streamTuple._2.collect(Collectors.toList()) == ["b", "c", "d", "e", "f"]
    }

    def "Streams.unzip(StreamA) and collect _2 then _1"() {
        given:
        "A streamA of 2b,3c,4d,5e,6f"
        def streamA = Stream.of(new Tuple2(2, "b"), new Tuple2(3, "c"), new Tuple2(4, "d"), new Tuple2(5, "e"), new Tuple2(6, "f"))

        when:
        "I get a stream from Streams.unzip(streamA)"
        def streamTuple = Streams.unzip(streamA);

        then:
        "I should get a stream of 2,3,4,5,6"
        streamTuple._2.collect(Collectors.toList()) == ["b", "c", "d", "e", "f"]
        "And a stream of b,c,d,e,f"
        streamTuple._1.collect(Collectors.toList()) == [2, 3, 4, 5, 6]
    }

    def "Streams.unzip(StreamA) and interleave read"() {
        given:
        "A streamA of 2b,3c,4d,5e,6f"
        def streamA = Stream.of(new Tuple2(2, "b"), new Tuple2(3, "c"), new Tuple2(4, "d"), new Tuple2(5, "e"), new Tuple2(6, "f"))

        when:
        "I get a stream from Streams.unzip(streamA)"
        def streamTuple = Streams.unzip(streamA);

        then:
        "I should get a stream of 2,3,4,5,6"
        "And a stream of b,c,d,e,f"
        def l1 = new ArrayList()
        def l2 = new ArrayList()
        Iterator<Integer> it1 = streamTuple._1.iterator();
        Iterator<String> it2 = streamTuple._2.iterator();
        l1.add(it1.next())
        l1.add(it1.next())
        l2.add(it2.next())
        l1.add(it1.next())
        l2.add(it2.next())
        l2.add(it2.next())
        l1.add(it1.next())
        l2.add(it2.next())
        l2.add(it2.next())
        l1.add(it1.next())
        it1.hasNext() == false
        it2.hasNext() == false
        l1 == [2, 3, 4, 5, 6]
        l2 == ["b", "c", "d", "e", "f"]
    }
}
