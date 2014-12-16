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

package fr.javatic.stuf.tuples;

import fr.javatic.stuf.consumers.Consumer5;
import fr.javatic.stuf.functions.Function5;

import java.util.Objects;

public class Tuple5<A, B, C, D, E> {
    public final A _1;
    public final B _2;
    public final C _3;
    public final D _4;
    public final E _5;

    public Tuple5(A _1,
                  B _2,
                  C _3,
                  D _4,
                  E _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
    }

    public A _1() {
        return _1;
    }

    public B _2() {
        return _2;
    }

    public C _3() {
        return _3;
    }

    public D _4() {
        return _4;
    }

    public E _5() {
        return _5;
    }

    public <ZZZ> ZZZ invoke(Function5<A, B, C, D, E, ZZZ> f) {
        return f.apply(_1, _2, _3, _4, _5);
    }

    public void invoke(Consumer5<A, B, C, D, E> c) {
        c.accept(_1, _2, _3, _4, _5);
    }

    @Override
    public String toString() {
        return "Tuple5{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                ", _4=" + _4 +
                ", _5=" + _5 +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3, _4, _5);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Tuple5)) {
            return false;
        }

        Tuple5 that = (Tuple5) obj;

        return Objects.equals(this._1, that._1) &&
                Objects.equals(this._2, that._2) &&
                Objects.equals(this._3, that._3) &&
                Objects.equals(this._4, that._4) &&
                Objects.equals(this._5, that._5);
    }
}
