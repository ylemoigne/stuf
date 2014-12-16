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

import fr.javatic.stuf.tuples.Tuple9
import spock.lang.Specification

class Consumer9Test extends Specification {
    def "Consumer9 Tuple"() {
        given:
        "A Consumer9"
        def res = "undefined"
        def cons = new Consumer9<Double, Integer, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g
            }
        };
        cons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple9"
        cons.accept(new Tuple9<Double, Integer, String, String, String, String, String, String, String>(4.5d, 3, "a", "b", "c", "d", "e", "f", "g"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4, _5, _6, _7, _8, _9)"
        res == expected
    }

    def "Consumer9 andThen"() {
        given:
        "A Consumer9 chained with andThen to another Consumer9"
        def res = ""
        def cons = new Consumer9<Double, Integer, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g
            }
        };
        def chainedCons = cons.andThen(new Consumer9<Double, Integer, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g) {
                res = res + g + f + e + d + c + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer9 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g")

        then:
        "Each consumer should be called in order"
        "4.53abcdefggfedcba34.5" == res
    }
}
