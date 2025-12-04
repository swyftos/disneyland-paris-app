package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Download;
import com.amazonaws.mobileconnectors.s3.transfermanager.PersistableDownload;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import com.amazonaws.mobileconnectors.s3.transfermanager.exception.PauseException;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DownloadImpl extends AbstractTransfer implements Download {
    private final PersistableDownload persistableDownload;
    S3Object s3Object;

    public DownloadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, S3Object s3Object, TransferStateChangeListener transferStateChangeListener, GetObjectRequest getObjectRequest, File file) {
        super(str, transferProgress, progressListenerChain, transferStateChangeListener);
        this.s3Object = s3Object;
        PersistableDownload persistableDownloadCaptureDownloadState = captureDownloadState(getObjectRequest, file);
        this.persistableDownload = persistableDownloadCaptureDownloadState;
        S3ProgressPublisher.publishTransferPersistable(progressListenerChain, persistableDownloadCaptureDownloadState);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Download
    public ObjectMetadata getObjectMetadata() {
        return this.s3Object.getObjectMetadata();
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Download
    public String getBucketName() {
        return this.s3Object.getBucketName();
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Download
    public String getKey() {
        return this.s3Object.getKey();
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Download
    public synchronized void abort() throws IOException {
        try {
            this.monitor.getFuture().cancel(true);
            S3Object s3Object = this.s3Object;
            if (s3Object != null) {
                s3Object.getObjectContent().abort();
            }
            setState(Transfer.TransferState.Canceled);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void abortWithoutNotifyingStateChangeListener() throws IOException {
        this.monitor.getFuture().cancel(true);
        synchronized (this) {
            this.state = Transfer.TransferState.Canceled;
        }
    }

    public synchronized void setS3Object(S3Object s3Object) {
        this.s3Object = s3Object;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.AbstractTransfer
    public void setState(Transfer.TransferState transferState) {
        super.setState(transferState);
        if (transferState == Transfer.TransferState.Completed) {
            fireProgressEvent(4);
        }
    }

    private PersistableDownload captureDownloadState(GetObjectRequest getObjectRequest, File file) {
        if (getObjectRequest.getSSECustomerKey() == null) {
            return new PersistableDownload(getObjectRequest.getBucketName(), getObjectRequest.getKey(), getObjectRequest.getVersionId(), getObjectRequest.getRange(), getObjectRequest.getResponseHeaders(), getObjectRequest.isRequesterPays(), file.getAbsolutePath());
        }
        return null;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Download
    public PersistableDownload pause() throws PauseException {
        Transfer.TransferState state = getState();
        this.monitor.getFuture().cancel(true);
        PersistableDownload persistableDownload = this.persistableDownload;
        if (persistableDownload != null) {
            return persistableDownload;
        }
        throw new PauseException(TransferManagerUtils.determinePauseStatus(state, true));
    }
}
