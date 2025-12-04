package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Queue;

/* loaded from: classes4.dex */
final class ConsumingQueueIterator extends AbstractIterator {
    private final Queue queue;

    ConsumingQueueIterator(Queue queue) {
        this.queue = (Queue) Preconditions.checkNotNull(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    protected Object computeNext() {
        if (this.queue.isEmpty()) {
            return endOfData();
        }
        return this.queue.remove();
    }
}
