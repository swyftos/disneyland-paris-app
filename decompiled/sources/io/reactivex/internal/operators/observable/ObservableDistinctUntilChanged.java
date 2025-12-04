package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes5.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream {
    final BiPredicate comparer;
    final Function keySelector;

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.keySelector, this.comparer));
    }

    static final class DistinctUntilChangedObserver extends BasicFuseableObserver {
        final BiPredicate comparer;
        boolean hasValue;
        final Function keySelector;
        Object last;

        DistinctUntilChangedObserver(Observer observer, Function function, BiPredicate biPredicate) {
            super(observer);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(obj);
                return;
            }
            try {
                Object objApply = this.keySelector.apply(obj);
                if (this.hasValue) {
                    boolean zTest = this.comparer.test(this.last, objApply);
                    this.last = objApply;
                    if (zTest) {
                        return;
                    }
                } else {
                    this.hasValue = true;
                    this.last = objApply;
                }
                this.downstream.onNext(obj);
            } catch (Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            while (true) {
                T tPoll = this.qd.poll();
                if (tPoll == null) {
                    return null;
                }
                Object objApply = this.keySelector.apply(tPoll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = objApply;
                    return tPoll;
                }
                if (!this.comparer.test(this.last, objApply)) {
                    this.last = objApply;
                    return tPoll;
                }
                this.last = objApply;
            }
        }
    }
}
