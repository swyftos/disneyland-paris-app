package com.allegion.accesssdk.listeners;

/* loaded from: classes2.dex */
public interface IAlObserver<R> {

    @FunctionalInterface
    public interface Complete {
        void onComplete(boolean z);
    }

    @FunctionalInterface
    public interface Error<E extends Throwable> {
        void onError(E e);
    }

    @FunctionalInterface
    public interface Next<R> {
        void onNext(R r);
    }

    void onComplete();

    void onError(Throwable th);

    void onNext(R r);
}
