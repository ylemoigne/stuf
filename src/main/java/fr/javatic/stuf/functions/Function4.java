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

package fr.javatic.stuf.functions;

import fr.javatic.stuf.tuples.Tuple4;

import java.util.Objects;

@FunctionalInterface
public interface Function4<A, B, C, D, ZZ> {
    ZZ apply(A a, B b, C c, D d);

    default ZZ apply(Tuple4<A, B, C, D> t) {
        return apply(t._1, t._2, t._3, t._4);
    }

    default <AA> Function4<A, B, C, D, AA> andThen(Function1<? super ZZ, ? extends AA> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c, D d) -> after.apply(apply(a, b, c, d));
    }
}
