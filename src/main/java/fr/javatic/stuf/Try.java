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

import fr.javatic.stuf.functions.Function1;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Try<A, Z> {
    public static <T> Try<T, Throwable> create(SupplierWithThrowable<T> supplier) {
        try {
            return success(supplier.get());
        } catch (Throwable e) {
            return failure(e);
        }
    }

    public static <T, Z> Try<T, Z> success(T value) {
        return new Success<>(value);
    }

    public static <T, Z> Try<T, Z> failure(Z t) {
        return new Failure<>(t);
    }

    public abstract Try<A, Z> onSuccess(Consumer<A> consumer);

    public abstract Try<A, Z> onFailure(Consumer<Z> consumer);

    public abstract boolean isSuccess();

    public abstract boolean isFailure();

    public abstract <B> Try<B, Z> map(Function1<A, B> f);

    public abstract <B> Try<B, Z> flatMap(Function1<A, Try<B, Z>> f);

    public abstract Try<A, Z> orElse(A b);

    public abstract Try<A, Z> orElse(Supplier<A> b);

    public abstract Try<A, Z> recoverWith(Function<Z, A> f);

    public abstract void forEach(Consumer<? super A> action);

    public abstract A getSuccess();

    public abstract Z getFailure();

    public abstract <Y> Try<A, Y> mapFailure(Function1<Z, Y> failureMapper);

    public abstract <R> R resolve(Function1<A, R> onSuccess, Function1<Z, R> onFailure);

    public <R> SuccessResolver<A, Z, R> resolveSuccess(Function1<A, R> successMapper) {
        return new SuccessResolver<>(this, successMapper);
    }

    public <R> SuccessResolver<A, Z, R> resolveSuccess(R r) {
        return new SuccessResolver<>(this, osef -> r);
    }

    public <R> FailureResolver<A, Z, R> resolveFailure(Function1<Z, R> failureMapper) {
        return new FailureResolver<>(this, failureMapper);
    }

    public <R> FailureResolver<A, Z, R> resolveFailure(R r) {
        return new FailureResolver<>(this, osef -> r);
    }

    public static class SuccessResolver<G, H, I> {
        private final Try<G, H> t;
        private final Function1<G, I> successMapper;

        public SuccessResolver(Try<G, H> t, Function1<G, I> successMapper) {
            this.t = t;
            this.successMapper = successMapper;
        }

        public I resolveFailure(Function1<H, I> failureMapper) {
            return this.t.resolve(successMapper, failureMapper);
        }

        public I resolveFailure(I i) {
            return this.t.resolve(successMapper, osef -> i);
        }
    }

    public static class FailureResolver<G, H, I> {
        private final Try<G, H> t;
        private final Function1<H, I> failureMapper;

        public FailureResolver(Try<G, H> t, Function1<H, I> failureMapper) {
            this.t = t;
            this.failureMapper = failureMapper;
        }

        public I resolveSuccess(Function1<G, I> successMapper) {
            return this.t.resolve(successMapper, failureMapper);
        }

        public I resolveSuccess(I i) {
            return this.t.resolve(osef -> i, failureMapper);
        }
    }

    private static class Success<T, Z> extends Try<T, Z> {
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
        public Try<T, Z> onSuccess(Consumer<T> consumer) {
            consumer.accept(t);
            return this;
        }

        @Override
        public Try<T, Z> onFailure(Consumer<Z> consumer) {
            return this;
        }

        @Override
        public <B> Try<B, Z> map(Function1<T, B> f) {
            return Try.success(f.apply(t));
        }

        @Override
        public <B> Try<B, Z> flatMap(Function1<T, Try<B, Z>> f) {
            return f.apply(t);
        }

        @Override
        public Try<T, Z> orElse(T b) {
            return this;
        }

        @Override
        public Try<T, Z> orElse(Supplier<T> b) {
            return this;
        }

        @Override
        public Try<T, Z> recoverWith(Function<Z, T> f) {
            return this;
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            action.accept(t);
        }

        @Override
        public T getSuccess() {
            return t;
        }

        @Override
        public Z getFailure() {
            throw new IllegalStateException("Can't get failure on successfull Try");
        }

        @Override
        public <Y> Try<T, Y> mapFailure(Function1<Z, Y> failureMapper) {
            return Try.success(t);
        }

        @Override
        public <R> R resolve(Function1<T, R> onSuccess, Function1<Z, R> onFailure) {
            return onSuccess.apply(t);
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

    private static class Failure<T, Z> extends Try<T, Z> {
        private Z t;

        public Failure(Z t) {
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
        public Try<T, Z> onSuccess(Consumer<T> consumer) {
            return this;
        }

        @Override
        public Try<T, Z> onFailure(Consumer<Z> consumer) {
            consumer.accept(t);
            return this;
        }

        @Override
        public <B> Try<B, Z> map(Function1<T, B> f) {
            return failure(t);
        }

        @Override
        public <B> Try<B, Z> flatMap(Function1<T, Try<B, Z>> f) {
            return failure(t);
        }

        @Override
        public Try<T, Z> orElse(T b) {
            return success(b);
        }

        @Override
        public Try<T, Z> orElse(Supplier<T> b) {
            return success(b.get());
        }

        @Override
        public Try<T, Z> recoverWith(Function<Z, T> f) {
            return success(f.apply(t));
        }

        @Override
        public void forEach(Consumer<? super T> action) {
        }

        @Override
        public T getSuccess() {
            throw new IllegalStateException("Can't get success on failure Try");
        }

        @Override
        public Z getFailure() {
            return t;
        }

        @Override
        public <R> R resolve(Function1<T, R> onSuccess, Function1<Z, R> onFailure) {
            return onFailure.apply(t);
        }

        @Override
        public <Y> Try<T, Y> mapFailure(Function1<Z, Y> failureMapper) {
            return Try.failure(failureMapper.apply(t));
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
}
