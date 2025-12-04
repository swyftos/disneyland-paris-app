package com.facebook.soloader;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public class NoBaseApkException extends RuntimeException {
    public NoBaseApkException(Throwable th) {
        super(th);
    }

    public NoBaseApkException(String str, Throwable th) {
        super(str, th);
    }
}
