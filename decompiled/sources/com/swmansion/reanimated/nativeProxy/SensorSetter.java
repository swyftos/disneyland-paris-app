package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: classes4.dex */
public class SensorSetter {

    @DoNotStrip
    private final HybridData mHybridData;

    public native void sensorSetter(float[] fArr, int i);

    @DoNotStrip
    private SensorSetter(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
