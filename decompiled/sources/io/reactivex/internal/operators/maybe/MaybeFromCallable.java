package io.reactivex.internal.operators.maybe;

import defpackage.WrappingViewGroup;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    final Callable callable;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable disposableEmpty = Disposables.empty();
        maybeObserver.onSubscribe(disposableEmpty);
        if (disposableEmpty.isDisposed()) {
            return;
        }
        try {
            WrappingViewGroup wrappingViewGroup = (Object) this.callable.call();
            if (disposableEmpty.isDisposed()) {
                return;
            }
            if (wrappingViewGroup == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(wrappingViewGroup);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!disposableEmpty.isDisposed()) {
                maybeObserver.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.callable.call();
    }
}
