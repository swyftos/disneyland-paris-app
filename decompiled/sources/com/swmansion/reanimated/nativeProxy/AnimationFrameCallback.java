package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.swmansion.reanimated.NodesManager;

@DoNotStrip
/* loaded from: classes4.dex */
public class AnimationFrameCallback implements NodesManager.OnAnimationFrame {

    @DoNotStrip
    private final HybridData mHybridData;

    @Override // com.swmansion.reanimated.NodesManager.OnAnimationFrame
    public native void onAnimationFrame(double d);

    @DoNotStrip
    private AnimationFrameCallback(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
