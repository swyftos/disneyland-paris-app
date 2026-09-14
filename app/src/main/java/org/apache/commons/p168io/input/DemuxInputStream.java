package org.apache.commons.p168io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class DemuxInputStream extends InputStream {
    private final InheritableThreadLocal m_streams = new InheritableThreadLocal();

    public InputStream bindStream(InputStream inputStream) {
        InputStream inputStream2 = (InputStream) this.m_streams.get();
        this.m_streams.set(inputStream);
        return inputStream2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = (InputStream) this.m_streams.get();
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = (InputStream) this.m_streams.get();
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}
