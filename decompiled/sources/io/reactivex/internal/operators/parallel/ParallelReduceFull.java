package io.reactivex.internal.operators.parallel;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {
    final BiFunction reducer;
    final ParallelFlowable source;

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.source = parallelFlowable;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.source.parallelism(), this.reducer);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.source.subscribe(parallelReduceFullMainSubscriber.subscribers);
    }

    static final class ParallelReduceFullMainSubscriber extends DeferredScalarSubscription {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference current;
        final AtomicReference error;
        final BiFunction reducer;
        final AtomicInteger remaining;
        final ParallelReduceFullInnerSubscriber[] subscribers;

        ParallelReduceFullMainSubscriber(Subscriber subscriber, int i, BiFunction biFunction) {
            super(subscriber);
            this.current = new AtomicReference();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            ParallelReduceFullInnerSubscriber[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelReduceFullInnerSubscriberArr[i2] = new ParallelReduceFullInnerSubscriber(this, biFunction);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = biFunction;
            this.remaining.lazySet(i);
        }

        SlotPair addValue(Object obj) {
            SlotPair slotPair;
            int iTryAcquireSlot;
            while (true) {
                slotPair = (SlotPair) this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair();
                    if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.current, null, slotPair)) {
                        continue;
                    }
                }
                iTryAcquireSlot = slotPair.tryAcquireSlot();
                if (iTryAcquireSlot >= 0) {
                    break;
                }
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.current, slotPair, null);
            }
            if (iTryAcquireSlot == 0) {
                slotPair.first = obj;
            } else {
                slotPair.second = obj;
            }
            if (!slotPair.releaseSlot()) {
                return null;
            }
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.current, slotPair, null);
            return slotPair;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.cancel();
            }
        }

        void innerError(Throwable th) {
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.error, null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void innerComplete(Object obj) {
            if (obj != null) {
                while (true) {
                    SlotPair slotPairAddValue = addValue(obj);
                    if (slotPairAddValue == null) {
                        break;
                    }
                    try {
                        obj = ObjectHelper.requireNonNull(this.reducer.apply(slotPairAddValue.first, slotPairAddValue.second), "The reducer returned a null value");
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair slotPair = (SlotPair) this.current.get();
                this.current.lazySet(null);
                if (slotPair != null) {
                    complete(slotPair.first);
                } else {
                    this.downstream.onComplete();
                }
            }
        }
    }

    static final class ParallelReduceFullInnerSubscriber extends AtomicReference implements FlowableSubscriber {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final ParallelReduceFullMainSubscriber parent;
        final BiFunction reducer;
        Object value;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber, BiFunction biFunction) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (this.done) {
                return;
            }
            Object obj2 = this.value;
            if (obj2 == null) {
                this.value = obj;
                return;
            }
            try {
                this.value = ObjectHelper.requireNonNull(this.reducer.apply(obj2, obj), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    static final class SlotPair extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        Object first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        Object second;

        SlotPair() {
        }

        int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }
    }
}
