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

import fr.javatic.stuf.tuples.*;

import java.util.Optional;

public class Optionals {
    private Optionals() {
    }

    public static <A, B> Optional<Tuple2<A, B>> zip(
            Optional<A> optA,
            Optional<B> optB
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> Optional.of(new Tuple2<>(a, b))
                )
        );
    }

    public static <A, B, C> Optional<Tuple3<A, B, C>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> Optional.of(new Tuple3<>(a, b, c))
                        )
                )
        );
    }

    public static <A, B, C, D> Optional<Tuple4<A, B, C, D>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> Optional.of(new Tuple4<>(a, b, c, d))
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E> Optional<Tuple5<A, B, C, D, E>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> Optional.of(new Tuple5<>(a, b, c, d, e))
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F> Optional<Tuple6<A, B, C, D, E, F>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> Optional.of(new Tuple6<>(a, b, c, d, e, f))
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G> Optional<Tuple7<A, B, C, D, E, F, G>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> Optional.of(new Tuple7<>(a, b, c, d, e, f, g))
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H> Optional<Tuple8<A, B, C, D, E, F, G, H>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> Optional.of(new Tuple8<>(a, b, c, d, e, f, g, h))
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I> Optional<Tuple9<A, B, C, D, E, F, G, H, I>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> Optional.of(new Tuple9<>(a, b, c, d, e, f, g, h, i))
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J> Optional<Tuple10<A, B, C, D, E, F, G, H, I, J>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> Optional.of(new Tuple10<>(a, b, c, d, e, f, g, h, i, j))
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K> Optional<Tuple11<A, B, C, D, E, F, G, H, I, J, K>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> Optional.of(new Tuple11<>(a, b, c, d, e, f, g, h, i, j, k))
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L> Optional<Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> Optional.of(new Tuple12<>(a, b, c, d, e, f, g, h, i, j, k, l))
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M> Optional<Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> Optional.of(new Tuple13<>(a, b, c, d, e, f, g, h, i, j, k, l, m))
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N> Optional<Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> Optional.of(new Tuple14<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n))
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> Optional<Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> Optional.of(new Tuple15<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o))
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Optional<Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> Optional.of(new Tuple16<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p))
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Optional<Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> Optional.of(new Tuple17<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q))
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Optional<Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> Optional.of(new Tuple18<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r))
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Optional<Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> Optional.of(new Tuple19<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s))
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Optional<Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> Optional.of(new Tuple20<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t))
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Optional<Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> Optional.of(new Tuple21<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u))
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Optional<Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU,
            Optional<V> optV
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> optV.flatMap(
                                                                                                                                                                                        v -> Optional.of(new Tuple22<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v))
                                                                                                                                                                                )
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Optional<Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU,
            Optional<V> optV,
            Optional<W> optW
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> optV.flatMap(
                                                                                                                                                                                        v -> optW.flatMap(
                                                                                                                                                                                                w -> Optional.of(new Tuple23<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w))
                                                                                                                                                                                        )
                                                                                                                                                                                )
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Optional<Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU,
            Optional<V> optV,
            Optional<W> optW,
            Optional<X> optX
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> optV.flatMap(
                                                                                                                                                                                        v -> optW.flatMap(
                                                                                                                                                                                                w -> optX.flatMap(
                                                                                                                                                                                                        x -> Optional.of(new Tuple24<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x))
                                                                                                                                                                                                )
                                                                                                                                                                                        )
                                                                                                                                                                                )
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Optional<Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU,
            Optional<V> optV,
            Optional<W> optW,
            Optional<X> optX,
            Optional<Y> optY
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> optV.flatMap(
                                                                                                                                                                                        v -> optW.flatMap(
                                                                                                                                                                                                w -> optX.flatMap(
                                                                                                                                                                                                        x -> optY.flatMap(
                                                                                                                                                                                                                y -> Optional.of(new Tuple25<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y))
                                                                                                                                                                                                        )
                                                                                                                                                                                                )
                                                                                                                                                                                        )
                                                                                                                                                                                )
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Optional<Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z>> zip(
            Optional<A> optA,
            Optional<B> optB,
            Optional<C> optC,
            Optional<D> optD,
            Optional<E> optE,
            Optional<F> optF,
            Optional<G> optG,
            Optional<H> optH,
            Optional<I> optI,
            Optional<J> optJ,
            Optional<K> optK,
            Optional<L> optL,
            Optional<M> optM,
            Optional<N> optN,
            Optional<O> optO,
            Optional<P> optP,
            Optional<Q> optQ,
            Optional<R> optR,
            Optional<S> optS,
            Optional<T> optT,
            Optional<U> optU,
            Optional<V> optV,
            Optional<W> optW,
            Optional<X> optX,
            Optional<Y> optY,
            Optional<Z> optZ
    ) {
        return optA.flatMap(
                a -> optB.flatMap(
                        b -> optC.flatMap(
                                c -> optD.flatMap(
                                        d -> optE.flatMap(
                                                e -> optF.flatMap(
                                                        f -> optG.flatMap(
                                                                g -> optH.flatMap(
                                                                        h -> optI.flatMap(
                                                                                i -> optJ.flatMap(
                                                                                        j -> optK.flatMap(
                                                                                                k -> optL.flatMap(
                                                                                                        l -> optM.flatMap(
                                                                                                                m -> optN.flatMap(
                                                                                                                        n -> optO.flatMap(
                                                                                                                                o -> optP.flatMap(
                                                                                                                                        p -> optQ.flatMap(
                                                                                                                                                q -> optR.flatMap(
                                                                                                                                                        r -> optS.flatMap(
                                                                                                                                                                s -> optT.flatMap(
                                                                                                                                                                        t -> optU.flatMap(
                                                                                                                                                                                u -> optV.flatMap(
                                                                                                                                                                                        v -> optW.flatMap(
                                                                                                                                                                                                w -> optX.flatMap(
                                                                                                                                                                                                        x -> optY.flatMap(
                                                                                                                                                                                                                y -> optZ.flatMap(
                                                                                                                                                                                                                        z -> Optional.of(new Tuple26<>(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z))
                                                                                                                                                                                                                )
                                                                                                                                                                                                        )
                                                                                                                                                                                                )
                                                                                                                                                                                        )
                                                                                                                                                                                )
                                                                                                                                                                        )
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
