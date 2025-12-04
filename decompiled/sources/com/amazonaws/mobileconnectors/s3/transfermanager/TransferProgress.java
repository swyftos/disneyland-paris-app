package com.amazonaws.mobileconnectors.s3.transfermanager;

import androidx.camera.video.AudioStats;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

@Deprecated
/* loaded from: classes2.dex */
public final class TransferProgress {
    private static final Log log = LogFactory.getLog(TransferProgress.class);
    protected volatile long bytesTransferred = 0;
    protected volatile long totalBytesToTransfer = -1;

    @Deprecated
    public long getBytesTransfered() {
        return getBytesTransferred();
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public long getTotalBytesToTransfer() {
        return this.totalBytesToTransfer;
    }

    @Deprecated
    public synchronized double getPercentTransfered() {
        return getPercentTransferred();
    }

    public synchronized double getPercentTransferred() {
        double d;
        if (getBytesTransferred() < 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (this.totalBytesToTransfer < 0) {
            d = -1.0d;
        } else {
            d = (this.bytesTransferred / this.totalBytesToTransfer) * 100.0d;
        }
        return d;
    }

    public synchronized void updateProgress(long j) {
        this.bytesTransferred += j;
        if (this.totalBytesToTransfer > -1 && this.bytesTransferred > this.totalBytesToTransfer) {
            this.bytesTransferred = this.totalBytesToTransfer;
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Number of bytes transfered is more than the actual total bytes to transfer. Total number of bytes to Transfer : " + this.totalBytesToTransfer + ". Bytes Transferred : " + (this.bytesTransferred + j));
            }
        }
    }

    public void setTotalBytesToTransfer(long j) {
        this.totalBytesToTransfer = j;
    }
}
