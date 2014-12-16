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

package fr.javatic.stuf.consumers;

import fr.javatic.stuf.tuples.Tuple12;

import java.util.Objects;

@FunctionalInterface
public interface Consumer12<A, B, C, D, E, F, G, H, I, J, K, L> {
    void accept(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l);

    default void accept(Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> t) {
        accept(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12);
    }

    default Consumer12<A, B, C, D, E, F, G, H, I, J, K, L> andThen(
            Consumer12<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, ? super J, ? super K, ? super L> after) {
        Objects.requireNonNull(after);

        return (a, b, c, d, e, f, g, h, i, j, k, l) -> {
            accept(a, b, c, d, e, f, g, h, i, j, k, l);
            after.accept(a, b, c, d, e, f, g, h, i, j, k, l);
        };
    }
}
