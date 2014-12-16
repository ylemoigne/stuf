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

import fr.javatic.stuf.consumers.Consumer3
import fr.javatic.stuf.functions.Function3
import spock.lang.Shared
import spock.lang.Specification

class Tuple3Test extends Specification {
    @Shared
    def val = ["a", "b", "c", null]

    def "Tuple3 equality"() {
        given:
        "Two Tuple3 Try"
        def t1 = new Tuple3(content1A, content1B, content1C)
        def t2 = new Tuple3(content2A, content2B, content2C)

        expect:
        "Equality Should correspond the respective equality of value"
        (t1 == t2) == (
                (content1A == content2A) &&
                        (content1B == content2B) &&
                        (content1C == content2C)
        )

        and:
        "Hashcode Equlity Should correspond to the respective equality of value"
        (t1.hashCode() == t2.hashCode()) == (
                (Objects.hashCode(content1A) == Objects.hashCode(content2A)) &&
                        (Objects.hashCode(content1B) == Objects.hashCode(content2B)) &&
                        (Objects.hashCode(content1C) == Objects.hashCode(content2C))
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

        content2A << val
        content2B << val
        content2C << val
    }

    def "Tuple3 values getter"() {
        given:
        "A Tuple3"
        def t = new Tuple3("a", "b", "c")

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
    }

    def "Tuple3 invoke on Function3"() {
        given:
        "A Tuple3"
        def tu = new Tuple3("a", "b", "c")

        when:
        "I call invoke"
        def ru = tu.invoke({ a, b, c -> a + b + c } as Function3)

        then:
        "I should get the returned value by the applied function"
        ru == "abc"
    }

    def "Tuple3 invoke on Consumer3"() {
        given:
        "A Tuple2"
        def tu = new Tuple3("a", "b", "c")

        when:
        "I call invoke"
        def ru = "foo"
        tu.invoke({ a, b, c -> ru = a + b + c } as Consumer3)

        then:
        "The consumer shoud be runned"
        ru == "abc"
    }
}
