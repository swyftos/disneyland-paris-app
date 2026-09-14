package com.amazonaws.mobileconnectors.p016s3.transfermanager.internal;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public interface TransferMonitor {
    Future<?> getFuture();

    boolean isDone();
}
