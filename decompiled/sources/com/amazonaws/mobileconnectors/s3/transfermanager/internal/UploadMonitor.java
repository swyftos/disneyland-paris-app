package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.PauseResult;
import com.amazonaws.mobileconnectors.s3.transfermanager.PauseStatus;
import com.amazonaws.mobileconnectors.s3.transfermanager.PersistableUpload;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManagerConfiguration;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.UploadResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class UploadMonitor implements Callable<UploadResult>, TransferMonitor {
    private static final Log log = LogFactory.getLog(UploadMonitor.class);
    private final TransferManagerConfiguration configuration;
    private final UploadCallable multipartUploadCallable;
    private Future nextFuture;
    private final ProgressListenerCallbackExecutor progressListenerChainCallbackExecutor;
    private final PutObjectRequest putObjectRequest;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private ScheduledExecutorService timedThreadPool;
    private final UploadImpl transfer;
    private String uploadId;
    private final List futures = new ArrayList();
    private boolean isUploadDone = false;
    private int pollInterval = 5000;

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized Future<UploadResult> getFuture() {
        return this.nextFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNextFuture(Future future) {
        this.nextFuture = future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized boolean isDone() {
        return this.isUploadDone;
    }

    private synchronized void markAllDone() {
        this.isUploadDone = true;
    }

    public UploadMonitor(TransferManager transferManager, UploadImpl uploadImpl, ExecutorService executorService, UploadCallable uploadCallable, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain) {
        this.s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.multipartUploadCallable = uploadCallable;
        this.threadPool = executorService;
        this.putObjectRequest = putObjectRequest;
        this.progressListenerChainCallbackExecutor = ProgressListenerCallbackExecutor.wrapListener(progressListenerChain);
        this.transfer = uploadImpl;
        setNextFuture(executorService.submit(this));
    }

    public void setTimedThreadPool(ScheduledExecutorService scheduledExecutorService) {
        this.timedThreadPool = scheduledExecutorService;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public UploadResult call() throws Exception {
        try {
            if (this.uploadId == null) {
                return upload();
            }
            return poll();
        } catch (CancellationException unused) {
            this.transfer.setState(Transfer.TransferState.Canceled);
            fireProgressEvent(16);
            throw new AmazonClientException("Upload canceled");
        } catch (Exception e) {
            this.transfer.setState(Transfer.TransferState.Failed);
            fireProgressEvent(8);
            throw e;
        }
    }

    private UploadResult poll() {
        Iterator it = this.futures.iterator();
        while (it.hasNext()) {
            if (!((Future) it.next()).isDone()) {
                reschedule();
                return null;
            }
        }
        Iterator it2 = this.futures.iterator();
        while (it2.hasNext()) {
            if (((Future) it2.next()).isCancelled()) {
                throw new CancellationException();
            }
        }
        return completeMultipartUpload();
    }

    private UploadResult upload() throws Exception {
        UploadResult uploadResultCall = this.multipartUploadCallable.call();
        if (uploadResultCall != null) {
            uploadComplete();
        } else {
            this.uploadId = this.multipartUploadCallable.getMultipartUploadId();
            this.futures.addAll(this.multipartUploadCallable.getFutures());
            reschedule();
        }
        return uploadResultCall;
    }

    private void uploadComplete() {
        markAllDone();
        this.transfer.setState(Transfer.TransferState.Completed);
        if (this.multipartUploadCallable.isMultipartUpload()) {
            fireProgressEvent(4);
        }
    }

    private void reschedule() {
        setNextFuture(this.timedThreadPool.schedule(new Callable<UploadResult>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UploadResult call() {
                UploadMonitor uploadMonitor = UploadMonitor.this;
                uploadMonitor.setNextFuture(uploadMonitor.threadPool.submit(UploadMonitor.this));
                return null;
            }
        }, this.pollInterval, TimeUnit.MILLISECONDS));
    }

    private void fireProgressEvent(int i) {
        if (this.progressListenerChainCallbackExecutor == null) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.setEventCode(i);
        this.progressListenerChainCallbackExecutor.progressChanged(progressEvent);
    }

    private UploadResult completeMultipartUpload() throws AmazonClientException {
        CompleteMultipartUploadResult completeMultipartUploadResultCompleteMultipartUpload = this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.uploadId, collectPartETags()));
        uploadComplete();
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(completeMultipartUploadResultCompleteMultipartUpload.getBucketName());
        uploadResult.setKey(completeMultipartUploadResultCompleteMultipartUpload.getKey());
        uploadResult.setETag(completeMultipartUploadResultCompleteMultipartUpload.getETag());
        uploadResult.setVersionId(completeMultipartUploadResultCompleteMultipartUpload.getVersionId());
        return uploadResult;
    }

    private List collectPartETags() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.multipartUploadCallable.getETags());
        Iterator it = this.futures.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((Future) it.next()).get());
            } catch (Exception e) {
                throw new AmazonClientException("Unable to upload part: " + e.getCause().getMessage(), e.getCause());
            }
        }
        return arrayList;
    }

    PauseResult pause(boolean z) {
        PersistableUpload persistableUpload = this.multipartUploadCallable.getPersistableUpload();
        if (persistableUpload == null) {
            PauseStatus pauseStatusDeterminePauseStatus = TransferManagerUtils.determinePauseStatus(this.transfer.getState(), z);
            if (z) {
                cancelFutures();
                this.multipartUploadCallable.performAbortMultipartUpload();
            }
            return new PauseResult(pauseStatusDeterminePauseStatus);
        }
        cancelFutures();
        return new PauseResult(PauseStatus.SUCCESS, persistableUpload);
    }

    private void cancelFutures() {
        this.nextFuture.cancel(true);
        Iterator it = this.futures.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.multipartUploadCallable.getFutures().clear();
        this.futures.clear();
    }

    void performAbort() {
        cancelFutures();
        this.multipartUploadCallable.performAbortMultipartUpload();
    }
}
