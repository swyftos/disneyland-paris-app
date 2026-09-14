package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ServerListener<T extends Client> extends Closeable {
    T acceptClient() throws InterruptedException, IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
