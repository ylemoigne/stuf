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

import fr.javatic.stuf.consumers.Consumer14
import fr.javatic.stuf.functions.Function14
import spock.lang.Shared
import spock.lang.Specification

class Tuple14Test extends Specification {
    @Shared
    def val = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", null]

    def "Tuple14 equality"() {
        given:
        "Two Tuple14 Try"
        def t1 = new Tuple14(content1A, content1B, content1C, content1D, content1E, content1F, content1G, content1H, content1I, content1J, content1K, content1L, content1M, content1N)
        def t2 = new Tuple14(content2A, content2B, content2C, content2D, content2E, content2F, content2G, content2H, content2I, content2J, content2K, content2L, content2M, content2N)

        expect:
        "Equality Should correspond the respective equality of value"
        (t1 == t2) == (
                (content1A == content2A) &&
                        (content1B == content2B) &&
                        (content1C == content2C) &&
                        (content1D == content2D) &&
                        (content1E == content2E) &&
                        (content1F == content2F) &&
                        (content1G == content2G) &&
                        (content1H == content2H) &&
                        (content1I == content2I) &&
                        (content1J == content2J) &&
                        (content1K == content2K) &&
                        (content1L == content2L) &&
                        (content1M == content2M) &&
                        (content1N == content2N)
        )

        and:
        "Hashcode Equlity Should correspond to the respective equality of value"
        (t1.hashCode() == t2.hashCode()) == (
                (Objects.hashCode(content1A) == Objects.hashCode(content2A)) &&
                        (Objects.hashCode(content1B) == Objects.hashCode(content2B)) &&
                        (Objects.hashCode(content1C) == Objects.hashCode(content2C)) &&
                        (Objects.hashCode(content1D) == Objects.hashCode(content2D)) &&
                        (Objects.hashCode(content1E) == Objects.hashCode(content2E)) &&
                        (Objects.hashCode(content1F) == Objects.hashCode(content2F)) &&
                        (Objects.hashCode(content1G) == Objects.hashCode(content2G)) &&
                        (Objects.hashCode(content1H) == Objects.hashCode(content2H)) &&
                        (Objects.hashCode(content1I) == Objects.hashCode(content2I)) &&
                        (Objects.hashCode(content1J) == Objects.hashCode(content2J)) &&
                        (Objects.hashCode(content1K) == Objects.hashCode(content2K)) &&
                        (Objects.hashCode(content1L) == Objects.hashCode(content2L)) &&
                        (Objects.hashCode(content1M) == Objects.hashCode(content2M)) &&
                        (Objects.hashCode(content1N) == Objects.hashCode(content2N))
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
        content1F << val
        content1G << val
        content1H << val
        content1I << val
        content1J << val
        content1K << val
        content1L << val
        content1M << val
        content1N << val

        content2A << val
        content2B << val
        content2C << val
        content2D << val
        content2E << val
        content2F << val
        content2G << val
        content2H << val
        content2I << val
        content2J << val
        content2K << val
        content2L << val
        content2M << val
        content2N << val
    }

    def "Tuple14 values getter"() {
        given:
        "A Tuple14"
        def t = new Tuple14("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n")

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

        when:
        "I call _6()"
        def v6 = t._6()
        then:
        "I should get 6th element"
        v6 == "f"

        when:
        "I call _7()"
        def v7 = t._7()
        then:
        "I should get 7th element"
        v7 == "g"

        when:
        "I call _8()"
        def v8 = t._8()
        then:
        "I should get 8th element"
        v8 == "h"

        when:
        "I call _9()"
        def v9 = t._9()
        then:
        "I should get 9th element"
        v9 == "i"

        when:
        "I call _10()"
        def v10 = t._10()
        then:
        "I should get 10th element"
        v10 == "j"

        when:
        "I call _11()"
        def v11 = t._11()
        then:
        "I should get 11th element"
        v11 == "k"

        when:
        "I call _12()"
        def v12 = t._12()
        then:
        "I should get 12th element"
        v12 == "l"

        when:
        "I call _13()"
        def v13 = t._13()
        then:
        "I should get 13th element"
        v13 == "m"

        when:
        "I call _14()"
        def v14 = t._14()
        then:
        "I should get 14th element"
        v14 == "n"
    }

    def "Tuple14 invoke on Function14"() {
        given:
        "A Tuple14"
        def tu = new Tuple14("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n")

        when:
        "I call invoke"
        def ru = tu.invoke({ a, b, c, d, e, f, g, h, i, j, k, l, m, n -> a + b + c + d + e + f + g + h + i + j + k + l + m + n } as Function14)

        then:
        "I should get the returned value by the applied function"
        ru == "abcdefghijklmn"
    }

    def "Tuple14 invoke on Consumer14"() {
        given:
        "A Tuple2"
        def tu = new Tuple14("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n")

        when:
        "I call invoke"
        def ru = "foo"
        tu.invoke({ a, b, c, d, e, f, g, h, i, j, k, l, m, n -> ru = a + b + c + d + e + f + g + h + i + j + k + l + m + n } as Consumer14)

        then:
        "The consumer shoud be runned"
        ru == "abcdefghijklmn"
    }
}
