package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleMap<T, R> extends Single<R> {
    final Function mapper;
    final SingleSource source;

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new MapSingleObserver(singleObserver, this.mapper));
    }

    static final class MapSingleObserver implements SingleObserver {
        final Function mapper;

        /* JADX INFO: renamed from: t */
        final SingleObserver f3909t;

        MapSingleObserver(SingleObserver singleObserver, Function function) {
            this.f3909t = singleObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.f3909t.onSubscribe(disposable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                this.f3909t.onSuccess(ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f3909t.onError(th);
        }
    }
}
