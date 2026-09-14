package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.exception.PauseException;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.model.UploadResult;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Upload extends Transfer {
    void abort();

    PersistableUpload pause() throws PauseException;

    PauseResult<PersistableUpload> tryPause(boolean z);

    UploadResult waitForUploadResult() throws InterruptedException, AmazonClientException;
}
