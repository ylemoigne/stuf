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

import fr.javatic.stuf.tuples.Tuple2
import spock.lang.Specification

class Consumer2Test extends Specification {
    def "Consumer2 Tuple"() {
        given:
        "A Consumer2"
        def res = "undefined"
        def cons = new Consumer2<Double, Integer>() {
            @Override
            void accept(Double a, Integer b) {
                res = String.valueOf(a) + String.valueOf(b)
            }
        };
        cons.accept(4.5d, 3)
        def expected = res;
        res = "undefined"

        when:
        "I call accept a with a Tuple2"
        cons.accept(new Tuple2<Double, Integer>(4.5d, 3))

        then:
        "I get the same result as if I called the accept(_1, _2)"
        res == expected
    }
}
