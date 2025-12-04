package com.mrousavy.camera.frameprocessors;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import dalvik.annotation.optimization.FastNative;

/* loaded from: classes4.dex */
public final class FrameProcessor {

    @DoNotStrip
    @Keep
    private final HybridData mHybridData;

    @FastNative
    public native void call(Frame frame);

    @DoNotStrip
    @Keep
    public FrameProcessor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
