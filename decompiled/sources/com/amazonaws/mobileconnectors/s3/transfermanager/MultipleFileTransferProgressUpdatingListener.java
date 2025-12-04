package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferProgressUpdatingListener;

/* loaded from: classes2.dex */
final class MultipleFileTransferProgressUpdatingListener extends TransferProgressUpdatingListener {
    private final ProgressListenerChain progressListenerChain;

    public MultipleFileTransferProgressUpdatingListener(TransferProgress transferProgress, ProgressListenerChain progressListenerChain) {
        super(transferProgress);
        this.progressListenerChain = progressListenerChain;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferProgressUpdatingListener, com.amazonaws.event.ProgressListener
    public void progressChanged(ProgressEvent progressEvent) {
        super.progressChanged(progressEvent);
        this.progressListenerChain.progressChanged(progressEvent);
    }
}
