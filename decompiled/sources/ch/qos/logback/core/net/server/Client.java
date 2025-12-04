package ch.qos.logback.core.net.server;

import java.io.Closeable;

/* loaded from: classes2.dex */
public interface Client extends Runnable, Closeable {
    void close();
}
