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

package fr.javatic.stuf.tuples

import fr.javatic.stuf.consumers.Consumer4
import fr.javatic.stuf.functions.Function4
import spock.lang.Shared
import spock.lang.Specification

class Tuple4Test extends Specification {
    @Shared
    def val = ["a", "b", "c", "d", null]

    def "Tuple4 equality"() {
        given:
        "Two Tuple4 Try"
        def t1 = new Tuple4(content1A, content1B, content1C, content1D)
        def t2 = new Tuple4(content2A, content2B, content2C, content2D)

        expect:
        "Equality Should correspond the respective equality of value"
        (t1 == t2) == (
                (content1A == content2A) &&
                        (content1B == content2B) &&
                        (content1C == content2C) &&
                        (content1D == content2D)
        )

        and:
        "Hashcode Equlity Should correspond to the respective equality of value"
        (t1.hashCode() == t2.hashCode()) == (
                (Objects.hashCode(content1A) == Objects.hashCode(content2A)) &&
                        (Objects.hashCode(content1B) == Objects.hashCode(content2B)) &&
                        (Objects.hashCode(content1C) == Objects.hashCode(content2C)) &&
                        (Objects.hashCode(content1D) == Objects.hashCode(content2D))
        )

        and:
        "Should not be equals to himself"
        t1.equals(t1)
        t2.equals(t2)

        and:
        "Should not be equals to null"
        t1.equals(null) == false
        t2.equals(null) == false

        and:
        "Should not be equals to another type"
        t1.equals("a") == false
        t2.equals("a") == false

        where:
        content1A << val
        content1B << val
        content1C << val
        content1D << val

        content2A << val
        content2B << val
        content2C << val
        content2D << val
    }

    def "Tuple4 values getter"() {
        given:
        "A Tuple4"
        def t = new Tuple4("a", "b", "c", "d")

        when:
        "I call _1()"
        def v1 = t._1()
        then:
        "I should get 1st element"
        v1 == "a"

        when:
        "I call _2()"
        def v2 = t._2()
        then:
        "I should get 2nd element"
        v2 == "b"

        when:
        "I call _3()"
        def v3 = t._3()
        then:
        "I should get 3rd element"
        v3 == "c"

        when:
        "I call _4()"
        def v4 = t._4()
        then:
        "I should get 4th element"
        v4 == "d"
    }

    def "Tuple4 invoke on Function4"() {
        given:
        "A Tuple4"
        def tu = new Tuple4("a", "b", "c", "d")

        when:
        "I call invoke"
        def ru = tu.invoke({ a, b, c, d -> a + b + c + d } as Function4)

        then:
        "I should get the returned value by the applied function"
        ru == "abcd"
    }

    def "Tuple4 invoke on Consumer4"() {
        given:
        "A Tuple2"
        def tu = new Tuple4("a", "b", "c", "d")

        when:
        "I call invoke"
        def ru = "foo"
        tu.invoke({ a, b, c, d -> ru = a + b + c + d } as Consumer4)

        then:
        "The consumer shoud be runned"
        ru == "abcd"
    }
}
