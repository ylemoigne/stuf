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

import fr.javatic.stuf.tuples.Tuple6
import spock.lang.Shared
import spock.lang.Specification

class Function6Test extends Specification {
    @Shared
    def fun = new Function6<Double, Integer, String, String, String, String, String>() {
        @Override
        String apply(Double dd, Integer ii, String a, String b, String c, String d) {
            return String.valueOf(dd) + String.valueOf(ii) + a + b + c + d
        }
    };


    def "Function6 Tuple"() {
        given:
        "A Function6"

        when:
        "I apply a with a Tuple6"
        def result = fun.apply(new Tuple6<Double, Integer, String, String, String, String>(4.5d, 3, "a", "b", "c", "d"))

        then:
        "I get the same result as if I called the apply(_1, _2, _3, _4, _5, _6)"
        result == fun.apply(4.5d, 3, "a", "b", "c", "d")
    }

    def "Function6 Then"() {
        given:
        "A Function6 chained with andThen to a Function1"
        def chainedFun = fun.andThen({ a -> a + a } as Function1)

        when:
        "I call the function returned by andThen"
        def result = chainedFun.apply(4.5d, 3, "a", "b", "c", "d")

        then:
        "I get the result to be equals to f1(f6(... params ...)"
        "4.53abcd4.53abcd" == result
    }
}
