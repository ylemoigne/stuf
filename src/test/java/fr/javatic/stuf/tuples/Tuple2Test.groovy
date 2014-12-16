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

package fr.javatic.stuf.tuples

import fr.javatic.stuf.consumers.Consumer2
import fr.javatic.stuf.functions.Function2
import spock.lang.Shared
import spock.lang.Specification

class Tuple2Test extends Specification {
    @Shared
    def val = ["a", "b", null]

    def "Tuple2 equality"() {
        given:
        "Two Tuple2"
        def t1 = new Tuple2(content1A, content1B)
        def t2 = new Tuple2(content2A, content2B)

        expect:
        "Equality Should correspond the respective equality of value"
        (t1 == t2) == ((content1A == content2A) && (content1B == content2B))

        and:
        "Hashcode Equlity Should correspond to the respective equality of value"
        (t1.hashCode() == t2.hashCode()) == ((Objects.hashCode(content1A) == Objects.hashCode(content2A)) && (Objects.hashCode(content1B) == Objects.hashCode(content2B)))

        and:
        "Should not be equals to himself"
        t1.equals(t1)
        t2.equals(t2)

        and:
        "Should not be equals to null"
        t1.equals(null) == false
        t2.equals(null) == false

        and:
        "Should not be equals to another type"
        t1.equals("a") == false
        t2.equals("a") == false

        where:
        content1A << val
        content1B << val
        content2A << val
        content2B << val
    }

    def "Tuple2 values getter"() {
        given:
        "A Tuple2"
        def t = new Tuple2("a", "b")

        when:
        "I call _1()"
        def v1 = t._1()

        then:
        "I should get 1st element"
        v1 == "a"

        when:
        "I call _2()"
        def v2 = t._2()

        then:
        "I should get 2nd element"
        v2 == "b"
    }

    def "Tuple2 invoke on Function2"() {
        given:
        "A Tuple2"
        def t = new Tuple2("a", "b")

        when:
        "I call invoke"
        def r = t.invoke({ a, b -> a + b } as Function2)

        then:
        "I should get the returned value by the applied function"
        r == "ab"
    }

    def "Tuple2 invoke on Consumer2"() {
        given:
        "A Tuple2"
        def t = new Tuple2("a", "b")

        when:
        "I call invoke"
        def r = "foo"
        t.invoke({ a, b -> r = a + b } as Consumer2)

        then:
        "The consumer shoud be runned"
        r == "ab"
    }
}
