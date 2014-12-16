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

package fr.javatic.stuf.consumers

import fr.javatic.stuf.tuples.Tuple4
import spock.lang.Specification

class Consumer4Test extends Specification {
    def "Consumer4 Tuple"() {
        given:
        "A Consumer4"
        def res = "undefined"
        def cons = new Consumer4<Double, Integer, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b
            }
        };
        cons.accept(4.5d, 3, "a", "b")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple4"
        cons.accept(new Tuple4<Double, Integer, String, String>(4.5d, 3, "a", "b"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4)"
        res == expected
    }

    def "Consumer4 andThen"() {
        given:
        "A Consumer4 chained with andThen to another Consumer4"
        def res = ""
        def cons = new Consumer4<Double, Integer, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b
            }
        };
        def chainedCons = cons.andThen(new Consumer4<Double, Integer, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b) {
                res = res + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer4 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b")

        then:
        "Each consumer should be called in order"
        "4.53abba34.5" == res
    }
}
