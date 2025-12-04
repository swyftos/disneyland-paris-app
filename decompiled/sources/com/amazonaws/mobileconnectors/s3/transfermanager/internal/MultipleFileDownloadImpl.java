package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Download;
import com.amazonaws.mobileconnectors.s3.transfermanager.MultipleFileDownload;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class MultipleFileDownloadImpl extends MultipleFileTransfer<Download> implements MultipleFileDownload {
    private final String bucketName;
    private final String keyPrefix;

    public MultipleFileDownloadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String str2, String str3, Collection<? extends Download> collection) {
        super(str, transferProgress, progressListenerChain, collection);
        this.keyPrefix = str2;
        this.bucketName = str3;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.MultipleFileDownload
    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.MultipleFileDownload
    public String getBucketName() {
        return this.bucketName;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.AbstractTransfer, com.amazonaws.mobileconnectors.s3.transfermanager.Transfer
    public void waitForCompletion() throws ExecutionException, InterruptedException, AmazonClientException {
        if (this.subTransfers.isEmpty()) {
            return;
        }
        super.waitForCompletion();
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.MultipleFileDownload
    public void abort() throws IOException {
        Iterator it = this.subTransfers.iterator();
        while (it.hasNext()) {
            ((DownloadImpl) ((Transfer) it.next())).abortWithoutNotifyingStateChangeListener();
        }
        Iterator it2 = this.subTransfers.iterator();
        while (it2.hasNext()) {
            ((DownloadImpl) ((Transfer) it2.next())).notifyStateChangeListeners(Transfer.TransferState.Canceled);
        }
    }
}
