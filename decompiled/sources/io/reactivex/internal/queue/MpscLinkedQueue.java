package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference producerNode = new AtomicReference();
    private final AtomicReference consumerNode = new AtomicReference();

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
        xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        LinkedQueueNode linkedQueueNodeLvNext;
        LinkedQueueNode linkedQueueNodeLpConsumerNode = lpConsumerNode();
        LinkedQueueNode linkedQueueNodeLvNext2 = linkedQueueNodeLpConsumerNode.lvNext();
        if (linkedQueueNodeLvNext2 != null) {
            T t = (T) linkedQueueNodeLvNext2.getAndNullValue();
            spConsumerNode(linkedQueueNodeLvNext2);
            return t;
        }
        if (linkedQueueNodeLpConsumerNode == lvProducerNode()) {
            return null;
        }
        do {
            linkedQueueNodeLvNext = linkedQueueNodeLpConsumerNode.lvNext();
        } while (linkedQueueNodeLvNext == null);
        T t2 = (T) linkedQueueNodeLvNext.getAndNullValue();
        spConsumerNode(linkedQueueNodeLvNext);
        return t2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    LinkedQueueNode lvProducerNode() {
        return (LinkedQueueNode) this.producerNode.get();
    }

    LinkedQueueNode xchgProducerNode(LinkedQueueNode linkedQueueNode) {
        return (LinkedQueueNode) this.producerNode.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode lvConsumerNode() {
        return (LinkedQueueNode) this.consumerNode.get();
    }

    LinkedQueueNode lpConsumerNode() {
        return (LinkedQueueNode) this.consumerNode.get();
    }

    void spConsumerNode(LinkedQueueNode linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    static final class LinkedQueueNode extends AtomicReference {
        private static final long serialVersionUID = 2404266111789071508L;
        private Object value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(Object obj) {
            spValue(obj);
        }

        public Object getAndNullValue() {
            Object objLpValue = lpValue();
            spValue(null);
            return objLpValue;
        }

        public Object lpValue() {
            return this.value;
        }

        public void spValue(Object obj) {
            this.value = obj;
        }

        public void soNext(LinkedQueueNode linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public LinkedQueueNode lvNext() {
            return (LinkedQueueNode) get();
        }
    }
}
