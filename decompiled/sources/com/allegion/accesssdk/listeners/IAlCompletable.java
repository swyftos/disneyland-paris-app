package com.allegion.accesssdk.listeners;

/* loaded from: classes2.dex */
public interface IAlCompletable {

    @FunctionalInterface
    public interface Complete {
        void onComplete();
    }

    @FunctionalInterface
    public interface Error<E extends Throwable> {
        void onError(E e);
    }

    void onComplete();

    void onError(Throwable th);
}
