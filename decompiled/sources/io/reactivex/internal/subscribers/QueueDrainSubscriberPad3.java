package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
abstract class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}
