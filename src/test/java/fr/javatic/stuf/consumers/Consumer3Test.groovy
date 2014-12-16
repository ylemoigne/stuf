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

import fr.javatic.stuf.tuples.Tuple3
import spock.lang.Specification

class Consumer3Test extends Specification {
    def "Consumer3 Tuple"() {
        given:
        "A Consumer3"
        def res = "undefined"
        def cons = new Consumer3<Double, Integer, String>() {
            @Override
            void accept(Double dd, Integer ii, String a) {
                res = String.valueOf(dd) + String.valueOf(ii) + a
            }
        };
        cons.accept(4.5d, 3, "a")
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple3"
        cons.accept(new Tuple3<Double, Integer, String>(4.5d, 3, "a"))

        then:
        "I get the same result as if I called the accept(_1, _2, _3)"
        res == expected
    }

    def "Consumer3 andThen"() {
        given:
        "A Consumer3 chained with andThen to another Consumer3"
        def res = ""
        def cons = new Consumer3<Double, Integer, String>() {
            @Override
            void accept(Double dd, Integer ii, String a) {
                res = res + String.valueOf(dd) + String.valueOf(ii) + a
            }
        };
        def chainedCons = cons.andThen(new Consumer3<Double, Integer, String>() {
            @Override
            void accept(Double dd, Integer ii, String a) {
                res = res + a + String.valueOf(ii) + String.valueOf(dd)
            }
        })

        when:
        "I call the Consumer3 returned by andThen"
        chainedCons.accept(4.5d, 3, "a")

        then:
        "Each consumer should be called in order"
        "4.53aa34.5" == res
    }
}
