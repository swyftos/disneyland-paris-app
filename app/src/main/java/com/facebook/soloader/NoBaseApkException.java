package com.facebook.soloader;

import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class NoBaseApkException extends RuntimeException {
    public NoBaseApkException(Throwable th) {
        super(th);
    }

    public NoBaseApkException(String str, Throwable th) {
        super(str, th);
    }
}
