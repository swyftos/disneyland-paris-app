package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    public static final String EXTRAS_STARTED_AS_PREFETCH = "started_as_prefetch";
    private final String mDedupedRequestsCountKey;
    private final Producer mInputProducer;
    private final boolean mKeepCancelledFetchAsLowPriority;
    final Map mMultiplexers;
    private final String mProducerName;

    @Nullable
    protected abstract T cloneOrNull(@Nullable T t);

    protected abstract K getKey(ProducerContext producerContext);

    protected MultiplexProducer(Producer<T> producer, String str, String str2) {
        this(producer, str, str2, false);
    }

    protected MultiplexProducer(Producer<T> producer, String str, String str2, boolean z) {
        this.mInputProducer = producer;
        this.mMultiplexers = new HashMap();
        this.mKeepCancelledFetchAsLowPriority = z;
        this.mProducerName = str;
        this.mDedupedRequestsCountKey = str2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        MultiplexProducer<K, T>.Multiplexer existingMultiplexer;
        boolean z;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("MultiplexProducer#produceResults");
            }
            producerContext.getProducerListener().onProducerStart(producerContext, this.mProducerName);
            K key = getKey(producerContext);
            do {
                synchronized (this) {
                    try {
                        existingMultiplexer = getExistingMultiplexer(key);
                        if (existingMultiplexer == null) {
                            existingMultiplexer = createAndPutNewMultiplexer(key);
                            z = true;
                        } else {
                            z = false;
                        }
                    } finally {
                    }
                }
            } while (!existingMultiplexer.addNewConsumer(consumer, producerContext));
            if (z) {
                existingMultiplexer.startInputProducerIfHasAttachedConsumers(TriState.valueOf(producerContext.isPrefetch()));
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    @Nullable
    protected synchronized MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K k) {
        return (Multiplexer) this.mMultiplexers.get(k);
    }

    private synchronized Multiplexer createAndPutNewMultiplexer(Object obj) {
        Multiplexer multiplexer;
        multiplexer = new Multiplexer(obj);
        this.mMultiplexers.put(obj, multiplexer);
        return multiplexer;
    }

    protected synchronized void removeMultiplexer(K k, MultiplexProducer<K, T>.Multiplexer multiplexer) {
        if (this.mMultiplexers.get(k) == multiplexer) {
            this.mMultiplexers.remove(k);
        }
    }

    class Multiplexer {
        private final CopyOnWriteArraySet mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
        private ForwardingConsumer mForwardingConsumer;
        private final Object mKey;
        private Closeable mLastIntermediateResult;
        private float mLastProgress;
        private int mLastStatus;
        private BaseProducerContext mMultiplexProducerContext;

        public Multiplexer(Object obj) {
            this.mKey = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean addNewConsumer(Consumer consumer, ProducerContext producerContext) {
            Pair pairCreate = Pair.create(consumer, producerContext);
            synchronized (this) {
                try {
                    if (MultiplexProducer.this.getExistingMultiplexer(this.mKey) != this) {
                        return false;
                    }
                    this.mConsumerContextPairs.add(pairCreate);
                    List listUpdateIsPrefetch = updateIsPrefetch();
                    List listUpdatePriority = updatePriority();
                    List listUpdateIsIntermediateResultExpected = updateIsIntermediateResultExpected();
                    Closeable closeableCloneOrNull = this.mLastIntermediateResult;
                    float f = this.mLastProgress;
                    int i = this.mLastStatus;
                    BaseProducerContext.callOnIsPrefetchChanged(listUpdateIsPrefetch);
                    BaseProducerContext.callOnPriorityChanged(listUpdatePriority);
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(listUpdateIsIntermediateResultExpected);
                    synchronized (pairCreate) {
                        try {
                            synchronized (this) {
                                if (closeableCloneOrNull != this.mLastIntermediateResult) {
                                    closeableCloneOrNull = null;
                                } else if (closeableCloneOrNull != null) {
                                    closeableCloneOrNull = MultiplexProducer.this.cloneOrNull(closeableCloneOrNull);
                                }
                            }
                            if (closeableCloneOrNull != null) {
                                if (f > BitmapDescriptorFactory.HUE_RED) {
                                    consumer.onProgressUpdate(f);
                                }
                                consumer.onNewResult(closeableCloneOrNull, i);
                                closeSafely(closeableCloneOrNull);
                            }
                        } catch (Throwable th) {
                            throw th;
                        } finally {
                        }
                    }
                    addCallbacks(pairCreate, producerContext);
                    return true;
                } finally {
                }
            }
        }

        private void addCallbacks(final Pair pair, ProducerContext producerContext) {
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    boolean zRemove;
                    List list;
                    BaseProducerContext baseProducerContext;
                    List listUpdatePriority;
                    List listUpdateIsIntermediateResultExpected;
                    synchronized (Multiplexer.this) {
                        try {
                            zRemove = Multiplexer.this.mConsumerContextPairs.remove(pair);
                            list = null;
                            if (!zRemove) {
                                baseProducerContext = null;
                                listUpdatePriority = null;
                            } else if (Multiplexer.this.mConsumerContextPairs.isEmpty()) {
                                baseProducerContext = Multiplexer.this.mMultiplexProducerContext;
                                listUpdatePriority = null;
                            } else {
                                List listUpdateIsPrefetch = Multiplexer.this.updateIsPrefetch();
                                listUpdatePriority = Multiplexer.this.updatePriority();
                                listUpdateIsIntermediateResultExpected = Multiplexer.this.updateIsIntermediateResultExpected();
                                baseProducerContext = null;
                                list = listUpdateIsPrefetch;
                            }
                            listUpdateIsIntermediateResultExpected = listUpdatePriority;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    BaseProducerContext.callOnIsPrefetchChanged(list);
                    BaseProducerContext.callOnPriorityChanged(listUpdatePriority);
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(listUpdateIsIntermediateResultExpected);
                    if (baseProducerContext != null) {
                        if (MultiplexProducer.this.mKeepCancelledFetchAsLowPriority && !baseProducerContext.isPrefetch()) {
                            BaseProducerContext.callOnPriorityChanged(baseProducerContext.setPriorityNoCallbacks(Priority.LOW));
                        } else {
                            baseProducerContext.cancel();
                        }
                    }
                    if (zRemove) {
                        ((Consumer) pair.first).onCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsPrefetchChanged() {
                    BaseProducerContext.callOnIsPrefetchChanged(Multiplexer.this.updateIsPrefetch());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(Multiplexer.this.updateIsIntermediateResultExpected());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onPriorityChanged() {
                    BaseProducerContext.callOnPriorityChanged(Multiplexer.this.updatePriority());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void startInputProducerIfHasAttachedConsumers(TriState triState) {
            synchronized (this) {
                try {
                    Preconditions.checkArgument(Boolean.valueOf(this.mMultiplexProducerContext == null));
                    Preconditions.checkArgument(Boolean.valueOf(this.mForwardingConsumer == null));
                    if (this.mConsumerContextPairs.isEmpty()) {
                        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                        return;
                    }
                    ProducerContext producerContext = (ProducerContext) ((Pair) this.mConsumerContextPairs.iterator().next()).second;
                    BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority(), producerContext.getImagePipelineConfig());
                    this.mMultiplexProducerContext = baseProducerContext;
                    baseProducerContext.putExtras(producerContext.getExtras());
                    if (triState.isSet()) {
                        this.mMultiplexProducerContext.putExtra(MultiplexProducer.EXTRAS_STARTED_AS_PREFETCH, Boolean.valueOf(triState.asBoolean()));
                    }
                    ForwardingConsumer forwardingConsumer = new ForwardingConsumer();
                    this.mForwardingConsumer = forwardingConsumer;
                    MultiplexProducer.this.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List updateIsPrefetch() {
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        }

        private synchronized boolean computeIsPrefetch() {
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) ((Pair) it.next()).second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List updateIsIntermediateResultExpected() {
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) ((Pair) it.next()).second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized List updatePriority() {
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setPriorityNoCallbacks(computePriority());
        }

        private synchronized Priority computePriority() {
            Priority higherPriority;
            higherPriority = Priority.LOW;
            Iterator it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                higherPriority = Priority.getHigherPriority(higherPriority, ((ProducerContext) ((Pair) it.next()).second).getPriority());
            }
            return higherPriority;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onFailure(ForwardingConsumer forwardingConsumer, Throwable th) {
            synchronized (this) {
                try {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    Iterator it = this.mConsumerContextPairs.iterator();
                    this.mConsumerContextPairs.clear();
                    MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            try {
                                ((ProducerContext) pair.second).getProducerListener().onProducerFinishWithFailure((ProducerContext) pair.second, MultiplexProducer.this.mProducerName, th, null);
                                BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
                                if (baseProducerContext != null) {
                                    ((ProducerContext) pair.second).putExtras(baseProducerContext.getExtras());
                                }
                                ((Consumer) pair.first).onFailure(th);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNextResult(ForwardingConsumer forwardingConsumer, Closeable closeable, int i) {
            synchronized (this) {
                try {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    Iterator it = this.mConsumerContextPairs.iterator();
                    int size = this.mConsumerContextPairs.size();
                    if (BaseConsumer.isNotLast(i)) {
                        this.mLastIntermediateResult = MultiplexProducer.this.cloneOrNull(closeable);
                        this.mLastStatus = i;
                    } else {
                        this.mConsumerContextPairs.clear();
                        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                    }
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            try {
                                if (BaseConsumer.isLast(i)) {
                                    ((ProducerContext) pair.second).getProducerListener().onProducerFinishWithSuccess((ProducerContext) pair.second, MultiplexProducer.this.mProducerName, null);
                                    BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
                                    if (baseProducerContext != null) {
                                        ((ProducerContext) pair.second).putExtras(baseProducerContext.getExtras());
                                    }
                                    ((ProducerContext) pair.second).putExtra(MultiplexProducer.this.mDedupedRequestsCountKey, Integer.valueOf(size));
                                }
                                ((Consumer) pair.first).onNewResult(closeable, i);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void onCancelled(ForwardingConsumer forwardingConsumer) {
            synchronized (this) {
                try {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    this.mForwardingConsumer = null;
                    this.mMultiplexProducerContext = null;
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    startInputProducerIfHasAttachedConsumers(TriState.UNSET);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onProgressUpdate(ForwardingConsumer forwardingConsumer, float f) {
            synchronized (this) {
                try {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    this.mLastProgress = f;
                    Iterator it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            ((Consumer) pair.first).onProgressUpdate(f);
                        }
                    }
                } finally {
                }
            }
        }

        private void closeSafely(Closeable closeable) throws IOException {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private class ForwardingConsumer extends BaseConsumer {
            private ForwardingConsumer() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(Closeable closeable, int i) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                    }
                    Multiplexer.this.onNextResult(this, closeable, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th;
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onFailureImpl(Throwable th) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onFailure");
                    }
                    Multiplexer.this.onFailure(this, th);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th2) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th2;
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onCancellationImpl() {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
                    }
                    Multiplexer.this.onCancelled(this);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th;
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onProgressUpdateImpl(float f) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                    }
                    Multiplexer.this.onProgressUpdate(this, f);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th;
                }
            }
        }
    }
}
