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

import fr.javatic.stuf.tuples.Tuple26
import spock.lang.Specification

class Consumer26Test extends Specification {
    def "Consumer26 Tuple"() {
        given:
        "A Consumer26"
        def res = "undefined"
        def cons = new Consumer26<Double, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x) {
                res = String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t + u + v + w + x
            }
        };
        cons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple26"
        cons.accept(new Tuple26<Double, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String>(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22, _23, _24, _25, _26)"
        res == expected
    }

    def "Consumer26 andThen"() {
        given:
        "A Consumer26 chained with andThen to another Consumer26"
        def res = ""
        def cons = new Consumer26<Double, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t + u + v + w + x
            }
        };
        def chainedCons = cons.andThen(new Consumer26<Double, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String>() {
            @Override
            void accept(Double dd, Integer ii, String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x) {
                res = res + x + w + v + u + t + s + r + q + p + o + n + m + l + k + j + i + h + g + f + e + d + c + b + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer26 returned by andThen"
        chainedCons.accept(4.5d, 3, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x")

        then:
        "Each consumer should be called in order"
        "4.53abcdefghijklmnopqrstuvwxxwvutsrqponmlkjihgfedcba34.5" == res
    }
}
