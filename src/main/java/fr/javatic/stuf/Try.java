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

package fr.javatic.stuf;

import fr.javatic.stuf.functions.Function1;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Try<A> {
    public static <T> Try<T> create(Supplier<T> supplier) {
        try {
            return success(supplier.get());
        } catch (RuntimeException e) {
            return failure(e);
        }
    }

    public static <T> Try<T> success(T value) {
        return new Success<>(value);
    }

    public static <T> Try<T> failure(RuntimeException t) {
        return new Failure<>(t);
    }

    public abstract boolean isSuccess();

    public abstract boolean isFailure();

    public abstract <B> Try<B> map(Function1<A, B> f);

    public abstract <B> Try<B> flatMap(Function1<A, Try<B>> f);

    public abstract Try<A> orElse(A b);

    public abstract Try<A> orElse(Supplier<A> b);

    public abstract Try<A> recoverWith(Function<Throwable, A> f);

    public abstract Try<A> filter(Predicate<A> p);

    public abstract void forEach(Consumer<? super A> action);

    public abstract A get();

    public abstract Optional<A> toOptional();

    private static class Success<T> extends Try<T> {
        private T t;

        public Success(T t) {
            this.t = t;
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        @Override
        public <B> Try<B> map(Function1<T, B> f) {
            return Try.create(() -> f.apply(t));
        }

        @Override
        public <B> Try<B> flatMap(Function1<T, Try<B>> f) {
            return f.apply(t);
        }

        @Override
        public Try<T> filter(Predicate<T> p) {
            if (p.test(t)) {
                return this;
            }

            return failure(new PredicateFailed());
        }

        @Override
        public Try<T> orElse(T b) {
            return this;
        }

        @Override
        public Try<T> orElse(Supplier<T> b) {
            return this;
        }

        @Override
        public Try<T> recoverWith(Function<Throwable, T> f) {
            return this;
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            action.accept(t);
        }

        @Override
        public T get() {
            return t;
        }

        @Override
        public Optional<T> toOptional() {
            return Optional.of(t);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(t);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (!(obj instanceof Success)) {
                return false;
            }

            Success that = (Success) obj;
            return Objects.equals(this.t, that.t);
        }

        @Override
        public String toString() {
            return "Success{" +
                    "t=" + t +
                    '}';
        }
    }

    private static class Failure<T> extends Try<T> {
        private RuntimeException t;

        public Failure(RuntimeException t) {
            this.t = t;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        @Override
        public <B> Try<B> map(Function1<T, B> f) {
            return failure(t);
        }

        @Override
        public <B> Try<B> flatMap(Function1<T, Try<B>> f) {
            return failure(t);
        }

        @Override
        public Try<T> filter(Predicate<T> p) {
            return failure(t);
        }

        @Override
        public Try<T> orElse(T b) {
            return success(b);
        }

        @Override
        public Try<T> orElse(Supplier<T> b) {
            return success(b.get());
        }

        @Override
        public Try<T> recoverWith(Function<Throwable, T> f) {
            return create(() -> f.apply(t));
        }

        @Override
        public void forEach(Consumer<? super T> action) {
        }

        @Override
        public T get() {
            throw t;
        }

        @Override
        public Optional<T> toOptional() {
            return Optional.empty();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(t);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (!(obj instanceof Failure)) {
                return false;
            }

            Failure that = (Failure) obj;
            return Objects.equals(this.t, that.t);
        }

        @Override
        public String toString() {
            return "Failure{" +
                    "t=" + t +
                    '}';
        }
    }

    public static class PredicateFailed extends RuntimeException {
    }
}
