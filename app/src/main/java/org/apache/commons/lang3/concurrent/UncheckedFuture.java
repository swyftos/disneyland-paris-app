package org.apache.commons.lang3.concurrent;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes6.dex */
public interface UncheckedFuture<V> extends Future<V> {
    @Override // java.util.concurrent.Future
    V get();

    @Override // java.util.concurrent.Future
    V get(long j, TimeUnit timeUnit);

    static <T> Stream<UncheckedFuture<T>> map(Collection<Future<T>> collection) {
        return (Stream<UncheckedFuture<T>>) collection.stream().map(new Function() { // from class: org.apache.commons.lang3.concurrent.UncheckedFuture$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UncheckedFuture.m1959on((Future) obj);
            }
        });
    }

    /* JADX INFO: renamed from: on */
    static <T> Collection<UncheckedFuture<T>> m1958on(Collection<Future<T>> collection) {
        return (Collection) map(collection).collect(Collectors.toList());
    }

    /* JADX INFO: renamed from: on */
    static <T> UncheckedFuture<T> m1959on(Future<T> future) {
        return new UncheckedFutureImpl(future);
    }
}
