package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream {
    final BiPredicate comparer;
    final Function keySelector;

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber<? super Object>) new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.keySelector, this.comparer));
        } else {
            this.source.subscribe((FlowableSubscriber<? super Object>) new DistinctUntilChangedSubscriber(subscriber, this.keySelector, this.comparer));
        }
    }

    static final class DistinctUntilChangedSubscriber extends BasicFuseableSubscriber implements ConditionalSubscriber {
        final BiPredicate comparer;
        boolean hasValue;
        final Function keySelector;
        Object last;

        DistinctUntilChangedSubscriber(Subscriber subscriber, Function function, BiPredicate biPredicate) {
            super(subscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (tryOnNext(obj)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(obj);
                return true;
            }
            try {
                Object objApply = this.keySelector.apply(obj);
                if (this.hasValue) {
                    boolean zTest = this.comparer.test(this.last, objApply);
                    this.last = objApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = objApply;
                }
                this.downstream.onNext(obj);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            while (true) {
                T tPoll = this.qs.poll();
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
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
        }
    }

    static final class DistinctUntilChangedConditionalSubscriber extends BasicFuseableConditionalSubscriber {
        final BiPredicate comparer;
        boolean hasValue;
        final Function keySelector;
        Object last;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Function function, BiPredicate biPredicate) {
            super(conditionalSubscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (tryOnNext(obj)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(obj);
            }
            try {
                Object objApply = this.keySelector.apply(obj);
                if (this.hasValue) {
                    boolean zTest = this.comparer.test(this.last, objApply);
                    this.last = objApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = objApply;
                }
                this.downstream.onNext(obj);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            while (true) {
                T tPoll = this.qs.poll();
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
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
        }
    }
}
