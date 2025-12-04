package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressListener;

@Deprecated
/* loaded from: classes2.dex */
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
    void addProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener);

    String getDescription();

    TransferProgress getProgress();

    TransferState getState();

    boolean isDone();

    void removeProgressListener(ProgressListener progressListener);

    @Deprecated
    void removeProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener);

    void waitForCompletion() throws InterruptedException, AmazonClientException;

    AmazonClientException waitForException() throws InterruptedException;
}
