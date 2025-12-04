package io.reactivex.internal.operators.maybe;

import defpackage.WrappingViewGroup;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        WrappingViewGroup wrappingViewGroup;
        Disposable disposableEmpty = Disposables.empty();
        maybeObserver.onSubscribe(disposableEmpty);
        if (disposableEmpty.isDisposed()) {
            return;
        }
        try {
            long j = this.timeout;
            if (j <= 0) {
                wrappingViewGroup = (Object) this.future.get();
            } else {
                wrappingViewGroup = (Object) this.future.get(j, this.unit);
            }
            if (disposableEmpty.isDisposed()) {
                return;
            }
            if (wrappingViewGroup == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(wrappingViewGroup);
            }
        } catch (Throwable th) {
            th = th;
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            Exceptions.throwIfFatal(th);
            if (disposableEmpty.isDisposed()) {
                return;
            }
            maybeObserver.onError(th);
        }
    }
}
