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

import fr.javatic.stuf.tuples.Tuple6
import spock.lang.Specification

class Consumer6Test extends Specification {
    def "Consumer6 Tuple"() {
        given:
        "A Consumer6"
        def res = "undefined"
        def cons = new Consumer6<Double, Integer, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b + c + d
            }
        };
        cons.accept(4.5d, 3, "a", "b", "c", "d")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple6"
        cons.accept(new Tuple6<Double, Integer, String, String, String, String>(4.5d, 3, "a", "b", "c", "d"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4, _5, _6, _6)"
        res == expected
    }

    def "Consumer6 andThen"() {
        given:
        "A Consumer6 chained with andThen to another Consumer6"
        def res = ""
        def cons = new Consumer6<Double, Integer, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b + c + d
            }
        };
        def chainedCons = cons.andThen(new Consumer6<Double, Integer, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d) {
                res = res + d + c + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer6 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b", "c", "d")

        then:
        "Each consumer should be called in order"
        "4.53abcddcba34.5" == res
    }
}
