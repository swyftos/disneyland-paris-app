package com.allegion.accesssdk.listeners;

/* loaded from: classes2.dex */
public interface IAlListener<R> {

    @FunctionalInterface
    public interface Error<E extends Throwable> {
        void onError(E e);
    }

    @FunctionalInterface
    public interface Success<R> {
        void onSuccess(R r);
    }

    void onError(Throwable th);

    void onSuccess(R r);
}
