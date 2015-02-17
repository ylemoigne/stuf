/*
 * Copyright 2015 Yann Le Moigne
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

package fr.javatic.stuf;

import fr.javatic.stuf.tuples.Tuple2;

import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterators;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams {
    private Streams() {
    }

    /**
     * Generate a possibly finite <code>Stream</code>.
     * <p>
     * The stream finish when the supplier throw <code>NoSuchElementException</code>.
     *
     * @param s the supplier.
     * @param <A> Type of stream.
     * @return the stream.
     */
    public static <A> Stream<A> from(Supplier<A> s) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<A>() {
            private boolean hasNext = false;
            private A nextElement;

            @Override
            public boolean hasNext() {
                try {
                    nextElement = s.get();
                    hasNext = true;
                } catch (NoSuchElementException e) {
                    nextElement = null;
                    hasNext = false;
                }
                return hasNext;
            }

            @Override
            public A next() {
                return nextElement;
            }
        }, 0), false);
    }

    public static <A> Stream<A> from(Iterable<A> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <A> Stream<A> from(Iterator<A> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false);
    }

    public static <A, B> Stream<Tuple2<A, B>> zip(Stream<A> streamA, Stream<B> streamB) {
        final Iterator<A> itA = streamA.iterator();
        final Iterator<B> itB = streamB.iterator();

        return from(new Iterator<Tuple2<A, B>>() {
            @Override
            public boolean hasNext() {
                return itA.hasNext() && itB.hasNext();
            }

            @Override
            public Tuple2<A, B> next() {
                return new Tuple2<>(itA.next(), itB.next());
            }
        });
    }

    public static <A> Stream<Tuple2<Integer, A>> zipWithIndex(Stream<A> streamA) {
        return zip(Stream.iterate(0, s -> s + 1), streamA);
    }

    /**
     * Split a stream of Tuple2.
     * <p>
     * Warning : Consuming one of returned Stream bufferize element for the other stream.
     * This mean that if only one of the returned stream is consumed, memory will be filled with element from the other stream.
     * <p>
     * If you want to consume only one the stream, simply map it : <code>input.map(Tuple2::_1)</code>.
     *
     * @param input Stream of Tuple2.
     * @param <A> The A type.
     * @param <B> The B type.
     * @return A Tuple2 of Stream.
     */
    public static <A, B> Tuple2<Stream<A>, Stream<B>> unzip(Stream<Tuple2<A, B>> input) {
        final Iterator<Tuple2<A, B>> it = input.iterator();

        final Deque<A> streamABuffer = new ConcurrentLinkedDeque<>();
        final Deque<B> streamBBuffer = new ConcurrentLinkedDeque<>();

        Stream<A> streamA = from(new Iterator<A>() {
            @Override
            public boolean hasNext() {
                return !streamABuffer.isEmpty() || it.hasNext();
            }

            @Override
            public A next() {
                if (streamABuffer.isEmpty()) {
                    Tuple2<A, B> next = it.next();
                    streamBBuffer.addLast(next._2);
                    return next._1;
                }

                return streamABuffer.pollFirst();
            }
        });

        Stream<B> streamB = from(new Iterator<B>() {
            @Override
            public boolean hasNext() {
                return !streamBBuffer.isEmpty() || it.hasNext();
            }

            @Override
            public B next() {
                if (streamBBuffer.isEmpty()) {
                    Tuple2<A, B> next = it.next();
                    streamABuffer.addLast(next._1);
                    return next._2;
                }

                return streamBBuffer.pollFirst();
            }
        });

        return new Tuple2<>(streamA, streamB);
    }
}
