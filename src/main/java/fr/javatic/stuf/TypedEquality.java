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

package fr.javatic.stuf;

public interface TypedEquality<T> {
    public enum Mode {
        ALLOW_ONLY_SAME,
        ALLOW_SUBCLASS
    }

    default boolean equals(T t, Object o) {
        return equals(t, o, Mode.ALLOW_SUBCLASS);
    }

    default boolean equals(T t, Object o, Mode mode) {
        if (o == null) {
            return false;
        }

        if (t == o) {
            return true;
        }

        boolean typeMatch = false;
        switch (mode) {
            case ALLOW_ONLY_SAME:
                typeMatch = o.getClass().equals(t.getClass());
                break;
            case ALLOW_SUBCLASS:
                typeMatch = o.getClass().isAssignableFrom(t.getClass());
                break;
        }

        if (!typeMatch) {
            return false;
        }

        @SuppressWarnings("unchecked")
        T that = (T) o;

        return isEquals(that);
    }

    boolean isEquals(T t);
}
