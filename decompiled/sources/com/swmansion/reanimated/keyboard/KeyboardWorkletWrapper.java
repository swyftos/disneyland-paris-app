package com.swmansion.reanimated.keyboard;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: classes4.dex */
public class KeyboardWorkletWrapper {

    @DoNotStrip
    private final HybridData mHybridData;

    public native void invoke(int i, int i2);

    @DoNotStrip
    private KeyboardWorkletWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
