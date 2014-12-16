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

import fr.javatic.stuf.consumers.Consumer2;
import fr.javatic.stuf.functions.Function2;

import java.util.Objects;

public class Tuple2<A, B> {
    public final A _1;
    public final B _2;

    public Tuple2(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public A _1() {
        return _1;
    }

    public B _2() {
        return _2;
    }

    public <ZZZ> ZZZ invoke(Function2<A, B, ZZZ> f) {
        return f.apply(_1, _2);
    }

    public void invoke(Consumer2<A, B> c) {
        c.accept(_1, _2);
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Tuple2)) {
            return false;
        }

        Tuple2 that = (Tuple2) obj;

        return Objects.equals(this._1, that._1) &&
                Objects.equals(this._2, that._2);
    }
}
