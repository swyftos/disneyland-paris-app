package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import com.amazonaws.services.s3.model.LegacyS3ProgressListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public abstract class AbstractTransfer implements Transfer {
    private final String description;
    protected TransferMonitor monitor;
    protected final ProgressListenerChain progressListenerChain;
    protected volatile Transfer.TransferState state;
    protected final Collection<TransferStateChangeListener> stateChangeListeners;
    private final TransferProgress transferProgress;

    AbstractTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain) {
        this(str, transferProgress, progressListenerChain, null);
    }

    AbstractTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, TransferStateChangeListener transferStateChangeListener) {
        this.state = Transfer.TransferState.Waiting;
        this.stateChangeListeners = new LinkedList();
        this.description = str;
        this.progressListenerChain = progressListenerChain;
        this.transferProgress = transferProgress;
        addStateChangeListener(transferStateChangeListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r0 = r2.state     // Catch: java.lang.Throwable -> L16
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r1 = com.amazonaws.mobileconnectors.s3.transfermanager.Transfer.TransferState.Failed     // Catch: java.lang.Throwable -> L16
            if (r0 == r1) goto L18
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r0 = r2.state     // Catch: java.lang.Throwable -> L16
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r1 = com.amazonaws.mobileconnectors.s3.transfermanager.Transfer.TransferState.Completed     // Catch: java.lang.Throwable -> L16
            if (r0 == r1) goto L18
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r0 = r2.state     // Catch: java.lang.Throwable -> L16
            com.amazonaws.mobileconnectors.s3.transfermanager.Transfer$TransferState r1 = com.amazonaws.mobileconnectors.s3.transfermanager.Transfer.TransferState.Canceled     // Catch: java.lang.Throwable -> L16
            if (r0 != r1) goto L14
            goto L18
        L14:
            r0 = 0
            goto L19
        L16:
            r0 = move-exception
            goto L1b
        L18:
            r0 = 1
        L19:
            monitor-exit(r2)
            return r0
        L1b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transfermanager.internal.AbstractTransfer.isDone():boolean");
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public void waitForCompletion() throws ExecutionException, InterruptedException, AmazonClientException {
        Object obj = null;
        while (true) {
            try {
                if (this.monitor.isDone() && obj != null) {
                    return;
                } else {
                    obj = this.monitor.getFuture().get();
                }
            } catch (ExecutionException e) {
                rethrowExecutionException(e);
                return;
            }
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public AmazonClientException waitForException() throws ExecutionException, InterruptedException {
        while (!this.monitor.isDone()) {
            try {
                this.monitor.getFuture().get();
            } catch (ExecutionException e) {
                return unwrapExecutionException(e);
            }
        }
        this.monitor.getFuture().get();
        return null;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public String getDescription() {
        return this.description;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized Transfer.TransferState getState() {
        return this.state;
    }

    public void setState(Transfer.TransferState transferState) {
        synchronized (this) {
            this.state = transferState;
        }
        Iterator<TransferStateChangeListener> it = this.stateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().transferStateChanged(this, transferState);
        }
    }

    public void notifyStateChangeListeners(Transfer.TransferState transferState) {
        Iterator<TransferStateChangeListener> it = this.stateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().transferStateChanged(this, transferState);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized void addProgressListener(ProgressListener progressListener) {
        this.progressListenerChain.addProgressListener(progressListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public synchronized void removeProgressListener(ProgressListener progressListener) {
        this.progressListenerChain.removeProgressListener(progressListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    @Deprecated
    public synchronized void addProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener) {
        this.progressListenerChain.addProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    @Deprecated
    public synchronized void removeProgressListener(com.amazonaws.services.s3.model.ProgressListener progressListener) {
        this.progressListenerChain.removeProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    public synchronized void addStateChangeListener(TransferStateChangeListener transferStateChangeListener) {
        if (transferStateChangeListener != null) {
            this.stateChangeListeners.add(transferStateChangeListener);
        }
    }

    public synchronized void removeStateChangeListener(TransferStateChangeListener transferStateChangeListener) {
        if (transferStateChangeListener != null) {
            this.stateChangeListeners.remove(transferStateChangeListener);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public TransferProgress getProgress() {
        return this.transferProgress;
    }

    public void setMonitor(TransferMonitor transferMonitor) {
        this.monitor = transferMonitor;
    }

    public TransferMonitor getMonitor() {
        return this.monitor;
    }

    protected void fireProgressEvent(int i) {
        ProgressListenerCallbackExecutor.progressChanged(this.progressListenerChain, new ProgressEvent(i, 0L));
    }

    protected void rethrowExecutionException(ExecutionException executionException) {
        throw unwrapExecutionException(executionException);
    }

    protected AmazonClientException unwrapExecutionException(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause instanceof AmazonClientException) {
            return (AmazonClientException) cause;
        }
        return new AmazonClientException("Unable to complete transfer: " + cause.getMessage(), cause);
    }
}
