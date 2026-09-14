package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeRunnable implements Runnable {
    private final HybridData mHybridData;

    @Override // java.lang.Runnable
    public native void run();

    private NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
