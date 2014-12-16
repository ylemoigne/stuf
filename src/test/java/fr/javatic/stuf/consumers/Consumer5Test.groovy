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

import fr.javatic.stuf.tuples.Tuple5
import spock.lang.Specification

class Consumer5Test extends Specification {
    def "Consumer5 Tuple"() {
        given:
        "A Consumer5"
        def res = "undefined"
        def cons = new Consumer5<Double, Integer, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b + c
            }
        };
        cons.accept(4.5d, 3, "a", "b", "c")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple5"
        cons.accept(new Tuple5<Double, Integer, String, String, String>(4.5d, 3, "a", "b", "c"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4, _5)"
        res == expected
    }

    def "Consumer5 andThen"() {
        given:
        "A Consumer5 chained with andThen to another Consumer5"
        def res = ""
        def cons = new Consumer5<Double, Integer, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b + c
            }
        };
        def chainedCons = cons.andThen(new Consumer5<Double, Integer, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c) {
                res = res + c + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer5 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b", "c")

        then:
        "Each consumer should be called in order"
        "4.53abccba34.5" == res
    }
}
