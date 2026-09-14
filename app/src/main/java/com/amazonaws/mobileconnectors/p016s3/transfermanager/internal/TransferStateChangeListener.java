package com.amazonaws.mobileconnectors.p016s3.transfermanager.internal;

import com.amazonaws.mobileconnectors.p016s3.transfermanager.Transfer;

/* JADX INFO: loaded from: classes2.dex */
public interface TransferStateChangeListener {
    void transferStateChanged(Transfer transfer, Transfer.TransferState transferState);
}
