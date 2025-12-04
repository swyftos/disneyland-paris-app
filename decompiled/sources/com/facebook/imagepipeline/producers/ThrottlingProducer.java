package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class ThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "ThrottlingProducer";
    private final Executor mExecutor;
    private final Producer mInputProducer;
    private final int mMaxSimultaneousRequests;
    private final ConcurrentLinkedQueue mPendingRequests = new ConcurrentLinkedQueue();
    private int mNumCurrentRequests = 0;

    public ThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            try {
                int i = this.mNumCurrentRequests;
                z = true;
                if (i >= this.mMaxSimultaneousRequests) {
                    this.mPendingRequests.add(Pair.create(consumer, producerContext));
                } else {
                    this.mNumCurrentRequests = i + 1;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        produceResultsInternal(consumer, producerContext);
    }

    void produceResultsInternal(Consumer consumer, ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(consumer), producerContext);
    }

    private class ThrottlerConsumer extends DelegatingConsumer {
        private ThrottlerConsumer(Consumer consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        protected void onNewResultImpl(Object obj, int i) {
            getConsumer().onNewResult(obj, i);
            if (BaseConsumer.isLast(i)) {
                onRequestFinished();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        private void onRequestFinished() {
            final Pair pair;
            synchronized (ThrottlingProducer.this) {
                try {
                    pair = (Pair) ThrottlingProducer.this.mPendingRequests.poll();
                    if (pair == null) {
                        ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                        throttlingProducer.mNumCurrentRequests--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (pair != null) {
                ThrottlingProducer.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ThrottlingProducer throttlingProducer2 = ThrottlingProducer.this;
                        Pair pair2 = pair;
                        throttlingProducer2.produceResultsInternal((Consumer) pair2.first, (ProducerContext) pair2.second);
                    }
                });
            }
        }
    }
}
