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

package fr.javatic.stuf.functions;

import fr.javatic.stuf.tuples.Tuple2;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface Function2<A, B, ZZ> extends BiFunction<A, B, ZZ> {
    default ZZ apply(Tuple2<A, B> t) {
        return apply(t._1, t._2);
    }

    default Function<B, ZZ> curry(A a) {
        return b -> apply(a, b);
    }

    default Function2<B, A, ZZ> flip() {
        return (b, a) -> apply(a, b);
    }
}
