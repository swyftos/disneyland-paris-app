package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.event.ProgressListener;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.mobileconnectors.s3.transfermanager.PersistableTransfer;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class S3ProgressPublisher extends ProgressListenerCallbackExecutor {
    public static Future<?> publishTransferPersistable(ProgressListener progressListener, final PersistableTransfer persistableTransfer) {
        if (persistableTransfer == null || !(progressListener instanceof S3ProgressListener)) {
            return null;
        }
        final S3ProgressListener s3ProgressListener = (S3ProgressListener) progressListener;
        return ProgressListenerCallbackExecutor.getExecutorService().submit(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.S3ProgressPublisher.1
            @Override // java.lang.Runnable
            public void run() {
                s3ProgressListener.onPersistableTransfer(persistableTransfer);
            }
        });
    }
}
