package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class AdjustedRangeInputStream extends SdkInputStream {
    private boolean closed = false;
    private InputStream decryptedContents;
    private long virtualAvailable;

    public AdjustedRangeInputStream(InputStream inputStream, long j, long j2) throws IOException {
        this.decryptedContents = inputStream;
        initializeForRead(j, j2);
    }

    private void initializeForRead(long j, long j2) throws IOException {
        int i = j < 16 ? (int) j : ((int) (j % 16)) + 16;
        if (i != 0) {
            while (i > 0) {
                this.decryptedContents.read();
                i--;
            }
        }
        this.virtualAvailable = (j2 - j) + 1;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        int i = this.virtualAvailable <= 0 ? -1 : this.decryptedContents.read();
        if (i != -1) {
            this.virtualAvailable--;
        } else {
            close();
            this.virtualAvailable = 0L;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        abortIfNeeded();
        long j = this.virtualAvailable;
        if (j <= 0) {
            i3 = -1;
        } else {
            if (i2 > j) {
                i2 = j < 2147483647L ? (int) j : Integer.MAX_VALUE;
            }
            i3 = this.decryptedContents.read(bArr, i, i2);
        }
        if (i3 != -1) {
            this.virtualAvailable -= i3;
        } else {
            close();
            this.virtualAvailable = 0L;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        abortIfNeeded();
        int iAvailable = this.decryptedContents.available();
        long j = iAvailable;
        long j2 = this.virtualAvailable;
        return j < j2 ? iAvailable : (int) j2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.decryptedContents.close();
        }
        abortIfNeeded();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    protected InputStream getWrappedInputStream() {
        return this.decryptedContents;
    }
}
