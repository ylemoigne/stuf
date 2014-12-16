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

import fr.javatic.stuf.consumers.Consumer16;
import fr.javatic.stuf.functions.Function16;

import java.util.Objects;

public class Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> {
    public final A _1;
    public final B _2;
    public final C _3;
    public final D _4;
    public final E _5;
    public final F _6;
    public final G _7;
    public final H _8;
    public final I _9;
    public final J _10;
    public final K _11;
    public final L _12;
    public final M _13;
    public final N _14;
    public final O _15;
    public final P _16;

    public Tuple16(A _1,
                   B _2,
                   C _3,
                   D _4,
                   E _5,
                   F _6,
                   G _7,
                   H _8,
                   I _9,
                   J _10,
                   K _11,
                   L _12,
                   M _13,
                   N _14,
                   O _15,
                   P _16) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        this._11 = _11;
        this._12 = _12;
        this._13 = _13;
        this._14 = _14;
        this._15 = _15;
        this._16 = _16;
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

    public F _6() {
        return _6;
    }

    public G _7() {
        return _7;
    }

    public H _8() {
        return _8;
    }

    public I _9() {
        return _9;
    }

    public J _10() {
        return _10;
    }

    public K _11() {
        return _11;
    }

    public L _12() {
        return _12;
    }

    public M _13() {
        return _13;
    }

    public N _14() {
        return _14;
    }

    public O _15() {
        return _15;
    }

    public P _16() {
        return _16;
    }

    public <ZZZ> ZZZ invoke(Function16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, ZZZ> f) {
        return f.apply(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16);
    }

    public void invoke(Consumer16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> c) {
        c.accept(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16);
    }

    @Override
    public String toString() {
        return "Tuple16{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                ", _4=" + _4 +
                ", _5=" + _5 +
                ", _6=" + _6 +
                ", _7=" + _7 +
                ", _8=" + _8 +
                ", _9=" + _9 +
                ", _10=" + _10 +
                ", _11=" + _11 +
                ", _12=" + _12 +
                ", _13=" + _13 +
                ", _14=" + _14 +
                ", _15=" + _15 +
                ", _16=" + _16 +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Tuple16)) {
            return false;
        }

        Tuple16 that = (Tuple16) obj;

        return Objects.equals(this._1, that._1) &&
                Objects.equals(this._2, that._2) &&
                Objects.equals(this._3, that._3) &&
                Objects.equals(this._4, that._4) &&
                Objects.equals(this._5, that._5) &&
                Objects.equals(this._6, that._6) &&
                Objects.equals(this._7, that._7) &&
                Objects.equals(this._8, that._8) &&
                Objects.equals(this._9, that._9) &&
                Objects.equals(this._10, that._10) &&
                Objects.equals(this._11, that._11) &&
                Objects.equals(this._12, that._12) &&
                Objects.equals(this._13, that._13) &&
                Objects.equals(this._14, that._14) &&
                Objects.equals(this._15, that._15) &&
                Objects.equals(this._16, that._16);
    }
}
