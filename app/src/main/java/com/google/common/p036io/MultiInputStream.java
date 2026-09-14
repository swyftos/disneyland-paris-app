package com.google.common.p036io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class MultiInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private InputStream f3560in;

    /* JADX INFO: renamed from: it */
    private Iterator f3561it;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator it) {
        this.f3561it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.f3560in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f3560in = null;
            }
        }
    }

    private void advance() {
        close();
        if (this.f3561it.hasNext()) {
            this.f3560in = ((ByteSource) this.f3561it.next()).openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.f3560in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f3560in;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f3560in;
            if (inputStream == null) {
                return -1;
            }
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 != -1) {
                return i3;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.f3560in;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f3560in.skip(j - 1) + 1;
    }
}
