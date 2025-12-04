package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Copy;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class CopyImpl extends AbstractTransfer implements Copy {
    public CopyImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, TransferStateChangeListener transferStateChangeListener) {
        super(str, transferProgress, progressListenerChain, transferStateChangeListener);
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.Copy
    public CopyResult waitForCopyResult() throws InterruptedException, AmazonClientException {
        CopyResult copyResult = null;
        while (true) {
            try {
                if (this.monitor.isDone() && copyResult != null) {
                    return copyResult;
                }
                copyResult = (CopyResult) this.monitor.getFuture().get();
            } catch (ExecutionException e) {
                rethrowExecutionException(e);
                return null;
            }
        }
    }
}
