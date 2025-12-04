package com.facebook.react.internal.featureflags;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsOverrides_RNOSS_Stable_Android;", "Lcom/facebook/react/internal/featureflags/ReactNativeNewArchitectureFeatureFlagsDefaults;", "fabricEnabled", "", "bridgelessEnabled", "turboModulesEnabled", "<init>", "(ZZZ)V", "useFabricInterop", "enableFabricRenderer", "useTurboModules", "useShadowNodeStateOnClone", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactNativeFeatureFlagsOverrides_RNOSS_Stable_Android extends ReactNativeNewArchitectureFeatureFlagsDefaults {
    private final boolean bridgelessEnabled;
    private final boolean fabricEnabled;
    private final boolean turboModulesEnabled;

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useShadowNodeStateOnClone() {
        return true;
    }

    public ReactNativeFeatureFlagsOverrides_RNOSS_Stable_Android(boolean z, boolean z2, boolean z3) {
        super(z2);
        this.fabricEnabled = z;
        this.bridgelessEnabled = z2;
        this.turboModulesEnabled = z3;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        return this.bridgelessEnabled || this.fabricEnabled;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        return this.bridgelessEnabled || this.fabricEnabled;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        return this.bridgelessEnabled || this.turboModulesEnabled;
    }
}
