package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressListener;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Transfer {

    public enum TransferState {
        Waiting,
        InProgress,
        Completed,
        Canceled,
        Failed
    }

    void addProgressListener(ProgressListener progressListener);

    @Deprecated
    void addProgressListener(com.amazonaws.services.p017s3.model.ProgressListener progressListener);

    String getDescription();

    TransferProgress getProgress();

    TransferState getState();

    boolean isDone();

    void removeProgressListener(ProgressListener progressListener);

    @Deprecated
    void removeProgressListener(com.amazonaws.services.p017s3.model.ProgressListener progressListener);

    void waitForCompletion() throws InterruptedException, AmazonClientException;

    AmazonClientException waitForException() throws InterruptedException;
}
