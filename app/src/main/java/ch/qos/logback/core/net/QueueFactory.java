package ch.qos.logback.core.net;

import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class QueueFactory {
    public <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int i) {
        if (i < 1) {
            i = 1;
        }
        return new LinkedBlockingDeque<>(i);
    }
}
