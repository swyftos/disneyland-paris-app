package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
public class SensorSetter {

    @DoNotStrip
    private final HybridData mHybridData;

    public native void sensorSetter(float[] fArr, int i);

    @DoNotStrip
    private SensorSetter(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
