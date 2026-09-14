package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public interface SingleConverter<T, R> {
    @NonNull
    R apply(@NonNull Single<T> single);
}
