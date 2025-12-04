package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ByteRangeCapturingInputStream extends SdkFilterInputStream {
    private final byte[] block;
    private int blockPosition;
    private final long endingPosition;
    private int markedBlockPosition;
    private long markedStreamPosition;
    private final long startingPosition;
    private long streamPosition;

    public ByteRangeCapturingInputStream(InputStream inputStream, long j, long j2) {
        super(inputStream);
        this.blockPosition = 0;
        if (j >= j2) {
            throw new IllegalArgumentException("Invalid byte range specified: the starting position must be less than the ending position");
        }
        this.startingPosition = j;
        this.endingPosition = j2;
        this.block = new byte[(int) (j2 - j)];
    }

    public byte[] getBlock() {
        return this.block;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i == -1) {
            return -1;
        }
        long j = this.streamPosition;
        if (j >= this.startingPosition && j <= this.endingPosition) {
            byte[] bArr = this.block;
            int i2 = this.blockPosition;
            this.blockPosition = i2 + 1;
            bArr[i2] = (byte) i;
        }
        this.streamPosition = j + 1;
        return i;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        if (markSupported()) {
            this.markedStreamPosition = this.streamPosition;
            this.markedBlockPosition = this.blockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        if (markSupported()) {
            this.streamPosition = this.markedStreamPosition;
            this.blockPosition = this.markedBlockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j = this.streamPosition;
        long j2 = i3;
        if (j + j2 >= this.startingPosition && j <= this.endingPosition) {
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = this.streamPosition;
                long j4 = i4;
                if (j3 + j4 >= this.startingPosition && j3 + j4 < this.endingPosition) {
                    byte[] bArr2 = this.block;
                    int i5 = this.blockPosition;
                    this.blockPosition = i5 + 1;
                    bArr2[i5] = bArr[i + i4];
                }
            }
        }
        this.streamPosition += j2;
        return i3;
    }
}
