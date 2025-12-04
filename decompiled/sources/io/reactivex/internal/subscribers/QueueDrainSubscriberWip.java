package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
abstract class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}
