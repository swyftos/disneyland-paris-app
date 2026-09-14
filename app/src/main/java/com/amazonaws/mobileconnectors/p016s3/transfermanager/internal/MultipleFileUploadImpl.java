package com.amazonaws.mobileconnectors.p016s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.MultipleFileUpload;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.TransferProgress;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.Upload;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class MultipleFileUploadImpl extends MultipleFileTransfer<Upload> implements MultipleFileUpload {
    private final String bucketName;
    private final String keyPrefix;

    public MultipleFileUploadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String str2, String str3, Collection<? extends Upload> collection) {
        super(str, transferProgress, progressListenerChain, collection);
        this.keyPrefix = str2;
        this.bucketName = str3;
    }

    @Override // com.amazonaws.mobileconnectors.p016s3.transfermanager.MultipleFileUpload
    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    @Override // com.amazonaws.mobileconnectors.p016s3.transfermanager.MultipleFileUpload
    public String getBucketName() {
        return this.bucketName;
    }

    @Override // com.amazonaws.mobileconnectors.p016s3.transfermanager.internal.AbstractTransfer, com.amazonaws.mobileconnectors.p016s3.transfermanager.Transfer
    public void waitForCompletion() throws InterruptedException, AmazonClientException {
        if (this.subTransfers.isEmpty()) {
            return;
        }
        super.waitForCompletion();
    }

    @Override // com.amazonaws.mobileconnectors.p016s3.transfermanager.MultipleFileUpload
    public Collection<? extends Upload> getSubTransfers() {
        return Collections.unmodifiableCollection(this.subTransfers);
    }
}
