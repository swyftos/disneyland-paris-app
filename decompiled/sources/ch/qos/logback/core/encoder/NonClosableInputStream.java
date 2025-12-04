package ch.qos.logback.core.encoder;

import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class NonClosableInputStream extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void realClose() throws IOException {
        super.close();
    }
}
