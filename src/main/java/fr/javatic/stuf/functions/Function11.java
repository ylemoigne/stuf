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

import fr.javatic.stuf.tuples.Tuple11;

import java.util.Objects;

@FunctionalInterface
public interface Function11<A, B, C, D, E, F, G, H, I, J, K, ZZ> {
    ZZ apply(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k);

    default ZZ apply(Tuple11<A, B, C, D, E, F, G, H, I, J, K> t) {
        return apply(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11);
    }

    default <AA> Function11<A, B, C, D, E, F, G, H, I, J, K, AA> andThen(Function1<? super ZZ, ? extends AA> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) -> after.apply(apply(a, b, c, d, e, f, g, h, i, j, k));
    }
}
