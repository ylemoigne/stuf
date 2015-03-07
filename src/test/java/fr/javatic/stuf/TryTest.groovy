/*
 * Copyright 2015 Yann Le Moigne
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

package fr.javatic.stuf

import fr.javatic.stuf.consumers.Consumer1
import fr.javatic.stuf.functions.Function1
import spock.lang.Specification

import java.util.function.Supplier

class TryTest extends Specification {
    def "Equality of Try between success and failure"() {
        given:
        "A success and a failure"
        def success = Try.success(contentA)
        def failure = Try.failure(contentB)

        expect:
        "It should not be equals"
        success != failure

        where:
        contentA << [new IllegalArgumentException("a"), new IllegalArgumentException("b"), null]
        contentB << [new IllegalArgumentException("a"), new IllegalArgumentException("b"), null]
    }

    def "Equality of Try between success"() {
        given:
        "Two success Try"
        def successA = Try.success(contentA)
        def successB = Try.success(contentB)

        expect:
        "Equality Should correspond to content equality"
        (successA == successB) == (contentA == contentB)

        and:
        "Hashcode Equlity Should correspond to content equality"
        (successA.hashCode() == successB.hashCode()) == (Objects.hashCode(contentA) == Objects.hashCode(contentB))

        and:
        "Should not be equals to null"
        successA.equals(null) == false

        and:
        "Should not be equals to another type"
        successA.equals("a") == false

        where:
        contentA << ["a", "b", null]
        contentB << ["a", "b", null]
    }

    def "Equality of Try between failure"() {
        given:
        "Two failure Try"
        def successA = Try.failure(contentA)
        def successB = Try.failure(contentB)

        expect:
        "Equality Should correspond to error equality"
        (successA == successB) == (contentA == contentB)

        and:
        "Hashcode Equlity Should correspond to error equality"
        (successA.hashCode() == successB.hashCode()) == (Objects.hashCode(contentA) == Objects.hashCode(contentB))

        and:
        "Should not be equals to null"
        successA.equals(null) == false

        and:
        "Should not be equals to another type"
        successA.equals("a") == false


        where:
        contentA                  | contentB
        new RuntimeException("a") | new RuntimeException("a")
        new RuntimeException("a") | new RuntimeException("b")
        new RuntimeException("b") | new RuntimeException("a")
        new RuntimeException("a") | null
        null                      | new RuntimeException("a")
        null                      | null
    }

    static def e1 = new IllegalArgumentException()
    static def e2 = new RuntimeException("bar")
    static def e3 = new IndexOutOfBoundsException()

    def "Try construction as a Failure"() {
        given:
        "Try constructed as Failure"

        when:
        "I check if it's a success"
        def s = r.isSuccess()
        then:
        "It should be false"
        s == false

        when:
        "I check if it's a failure"
        def f = r.isFailure()
        then:
        "It should be true"
        f == true

        when:
        "I use getFailure"
        def f1 = r.getFailure()
        then:
        "the contained exception is the constructed exception"
        f1.get() == type

        when:
        "I use map"
        def r1 = r.map({ String i -> i + i } as Function1)
        then:
        "it should return a itself"
        r1 == r

        when:
        "I use flatMap"
        def r2 = r.flatMap({ String i -> Try.success(i + i) } as Function1)
        then:
        "it should return a itself"
        r2 == r

        when:
        "I use toOptional"
        def o = r.getSuccess();
        then:
        "it should return an empty Optional"
        o.isPresent() == false

        when:
        "I use orElse(value)"
        def r4 = r.orElse("pouet");
        def r5 = r.orElse({ "pouet" } as Supplier);
        then:
        "it should return a success Try with this value"
        r4.isSuccess() == true
        r4.getSuccess().get() == "pouet"
        r5.isSuccess() == true
        r5.getSuccess().get() == "pouet"


        when:
        "I use recoverWith with a function which return a value"
        def r7 = r.recoverWith({ RuntimeException e -> "tagada" } as Function1);
        then:
        "it should return a success Try with this exception"
        r7.isSuccess() == true
        r7.getSuccess().get() == "tagada"

        when:
        "I use forEach"
        String v = "pouet"
        r.forEach({ v = "tagada" } as Consumer1);
        then:
        "it should not be called"
        v == "pouet"

        where:
        type | r
        e1   | Try.failure(e1)
        e2   | Try.create({ throw e2 } as Supplier)
    }

    def "Try construction as a Success"() {
        given:
        "Try constructed as Success"

        when:
        "I check if it's a success"
        def s = r.isSuccess()
        then:
        "It should be true"
        s == true

        when:
        "I check if it's a failure"
        def f = r.isFailure()
        then:
        "It should be false"
        f == false

        when:
        "I use getSuccess"
        def v = r.getSuccess()
        then:
        "the contained value is returned"
        v.get() == val

        when:
        "I use map"
        def r1 = r.map({ String i -> i + i } as Function1)
        then:
        "it should return a Try with the new value"
        r1 == Try.success(val + val)

        when:
        "I use flatMap"
        def r2 = r.flatMap({ String i -> Try.success(i + i) } as Function1)
        then:
        "it should return a Try with the new value"
        r2 == Try.success(val + val)

        when:
        "I use getFailure"
        def o = r.getFailure();
        then:
        "it should return an empty Optional"
        o.isPresent() == false

        when:
        "I use orElse(value)"
        def r4 = r.orElse("pouet");
        def r5 = r.orElse({ "pouet" } as Supplier);
        then:
        "it should return itself"
        r4 == r
        r5 == r

        when:
        "I use recoverWith"
        def r7 = r.recoverWith({ RuntimeException e -> "tagada" } as Function1);
        then:
        "it should return a failure Try with this exception"
        r7 == r

        when:
        "I use forEach"
        String out = "pouet"
        r.forEach({ out = "tagada" } as Consumer1);
        then:
        "it should be called"
        out == "tagada"

        where:
        val | r
        "a" | Try.success("a")
        "b" | Try.create({ "b" } as Supplier)
    }

//    @Unroll
//    def "A sample spec with x = #x and y = #y"() {
//        when: "x = #x and y = #y" // new feature! unrolls #x and #y in the report
//        then: "#x + #y = #z"
//        x + y == z
//        where:
//        x | y | z
//        1 | 1 | 2
//        0 | 5 | 5
//    }
}
