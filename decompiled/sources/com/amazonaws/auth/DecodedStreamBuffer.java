package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes2.dex */
class DecodedStreamBuffer {
    private static final Log log = LogFactory.getLog(DecodedStreamBuffer.class);
    private byte[] bufferArray;
    private boolean bufferSizeOverflow;
    private int byteBuffered;
    private int maxBufferSize;
    private int pos = -1;

    public DecodedStreamBuffer(int i) {
        this.bufferArray = new byte[i];
        this.maxBufferSize = i;
    }

    public void buffer(byte[] bArr, int i, int i2) {
        this.pos = -1;
        int i3 = this.byteBuffered;
        if (i3 + i2 > this.maxBufferSize) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Buffer size " + this.maxBufferSize + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
            }
            this.bufferSizeOverflow = true;
            return;
        }
        System.arraycopy(bArr, i, this.bufferArray, i3, i2);
        this.byteBuffered += i2;
    }

    public boolean hasNext() {
        int i = this.pos;
        return i != -1 && i < this.byteBuffered;
    }

    public byte next() {
        byte[] bArr = this.bufferArray;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public void startReadBuffer() {
        if (this.bufferSizeOverflow) {
            throw new AmazonClientException("The input stream is not repeatable since the buffer size " + this.maxBufferSize + " has been exceeded.");
        }
        this.pos = 0;
    }
}
