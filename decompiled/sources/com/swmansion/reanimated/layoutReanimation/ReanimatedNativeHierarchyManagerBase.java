package com.swmansion.reanimated.layoutReanimation;

import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaDirection;

/* loaded from: classes4.dex */
public abstract class ReanimatedNativeHierarchyManagerBase extends NativeViewHierarchyManager {
    public abstract void updateLayoutCommon(int i, int i2, int i3, int i4, int i5, int i6);

    public ReanimatedNativeHierarchyManagerBase(ViewManagerRegistry viewManagerRegistry) {
        super(viewManagerRegistry);
    }

    @Override // com.facebook.react.uimanager.NativeViewHierarchyManager
    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, YogaDirection yogaDirection) {
        super.updateLayout(i, i2, i3, i4, i5, i6, yogaDirection);
        updateLayoutCommon(i, i2, i3, i4, i5, i6);
    }
}
