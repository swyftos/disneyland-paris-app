package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;

@Deprecated
/* loaded from: classes2.dex */
public interface Copy extends Transfer {
    CopyResult waitForCopyResult() throws InterruptedException, AmazonClientException;
}
