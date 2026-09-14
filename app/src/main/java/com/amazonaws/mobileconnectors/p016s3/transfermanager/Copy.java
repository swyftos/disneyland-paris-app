package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.model.CopyResult;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Copy extends Transfer {
    CopyResult waitForCopyResult() throws InterruptedException, AmazonClientException;
}
