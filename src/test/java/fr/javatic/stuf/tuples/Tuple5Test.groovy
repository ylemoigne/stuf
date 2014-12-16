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

import fr.javatic.stuf.consumers.Consumer5
import fr.javatic.stuf.functions.Function5
import spock.lang.Shared
import spock.lang.Specification

class Tuple5Test extends Specification {
    @Shared
    def val = ["a", "b", "c", "d", "e", null]

    def "Tuple5 equality"() {
        given:
        "Two Tuple5 Try"
        def t1 = new Tuple5(content1A, content1B, content1C, content1D, content1E)
        def t2 = new Tuple5(content2A, content2B, content2C, content2D, content2E)

        expect:
        "Equality Should correspond the respective equality of value"
        (t1 == t2) == (
                (content1A == content2A) &&
                        (content1B == content2B) &&
                        (content1C == content2C) &&
                        (content1D == content2D) &&
                        (content1E == content2E)
        )

        and:
        "Hashcode Equlity Should correspond to the respective equality of value"
        (t1.hashCode() == t2.hashCode()) == (
                (Objects.hashCode(content1A) == Objects.hashCode(content2A)) &&
                        (Objects.hashCode(content1B) == Objects.hashCode(content2B)) &&
                        (Objects.hashCode(content1C) == Objects.hashCode(content2C)) &&
                        (Objects.hashCode(content1D) == Objects.hashCode(content2D)) &&
                        (Objects.hashCode(content1E) == Objects.hashCode(content2E))
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
        content1E << val

        content2A << val
        content2B << val
        content2C << val
        content2D << val
        content2E << val
    }

    def "Tuple5 values getter"() {
        given:
        "A Tuple5"
        def t = new Tuple5("a", "b", "c", "d", "e")

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

        when:
        "I call _5()"
        def v5 = t._5()
        then:
        "I should get 5th element"
        v5 == "e"
    }

    def "Tuple5 invoke on Function5"() {
        given:
        "A Tuple5"
        def tu = new Tuple5("a", "b", "c", "d", "e")

        when:
        "I call invoke"
        def ru = tu.invoke({ a, b, c, d, e -> a + b + c + d + e } as Function5)

        then:
        "I should get the returned value by the applied function"
        ru == "abcde"
    }

    def "Tuple5 invoke on Consumer5"() {
        given:
        "A Tuple2"
        def tu = new Tuple5("a", "b", "c", "d", "e")

        when:
        "I call invoke"
        def ru = "foo"
        tu.invoke({ a, b, c, d, e -> ru = a + b + c + d + e } as Consumer5)

        then:
        "The consumer shoud be runned"
        ru == "abcde"
    }
}
