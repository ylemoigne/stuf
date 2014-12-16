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

package fr.javatic.stuf.functions

import fr.javatic.stuf.tuples.Tuple2
import spock.lang.Specification

class Function2Test extends Specification {
    def "Function2 Tuple"() {
        given:
        "A Function2"
        def fun = new Function2<Double, Integer, String>() {
            @Override
            String apply(Double a, Integer b) {
                return String.valueOf(a) + String.valueOf(b)
            }
        };
        def expected = fun.apply(4.5d, 3)

        when:
        "I apply a with a Tuple2"
        def result = fun.apply(new Tuple2<Double, Integer>(4.5d, 3))

        then:
        "I get the same result as if I called the apply(_1, _2)"
        result == expected
    }
}
