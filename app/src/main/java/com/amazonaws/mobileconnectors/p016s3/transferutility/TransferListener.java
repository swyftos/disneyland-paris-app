package com.amazonaws.mobileconnectors.p016s3.transferutility;

/* JADX INFO: loaded from: classes2.dex */
public interface TransferListener {
    void onError(int i, Exception exc);

    void onProgressChanged(int i, long j, long j2);

    void onStateChanged(int i, TransferState transferState);
}
