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

import fr.javatic.stuf.tuples.Tuple10
import spock.lang.Specification

class Consumer10Test extends Specification {
    def "Consumer10 Tuple"() {
        given:
        "A Consumer10"
        def res = "undefined"
        def cons = new Consumer10<Double, Integer, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g + h
            }
        };
        cons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple10"
        cons.accept(new Tuple10<Double, Integer, String, String, String, String, String, String, String, String>(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10)"
        res == expected
    }

    def "Consumer10 andThen"() {
        given:
        "A Consumer10 chained with andThen to another Consumer10"
        def res = ""
        def cons = new Consumer10<Double, Integer, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g + h
            }
        };
        def chainedCons = cons.andThen(new Consumer10<Double, Integer, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h) {
                res = res + h + g + f + e + d + c + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer10 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h")

        then:
        "Each consumer should be called in order"
        "4.53abcdefghhgfedcba34.5" == res
    }
}
