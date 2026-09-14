package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class DefaultCloseableImage extends BaseCloseableImage {
    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        FLog.m1333w("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
