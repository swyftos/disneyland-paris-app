package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    static final class CompletableFromObservableObserver implements Observer {

        /* JADX INFO: renamed from: co */
        final CompletableObserver f3845co;

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f3845co = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f3845co.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f3845co.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f3845co.onComplete();
        }
    }
}
