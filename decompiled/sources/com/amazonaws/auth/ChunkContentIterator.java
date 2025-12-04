package com.amazonaws.auth;

/* loaded from: classes2.dex */
class ChunkContentIterator {
    private int pos;
    private final byte[] signedChunk;

    public ChunkContentIterator(byte[] bArr) {
        this.signedChunk = bArr;
    }

    public boolean hasNext() {
        return this.pos < this.signedChunk.length;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (!hasNext()) {
            return -1;
        }
        int iMin = Math.min(this.signedChunk.length - this.pos, i2);
        System.arraycopy(this.signedChunk, this.pos, bArr, i, iMin);
        this.pos += iMin;
        return iMin;
    }
}
