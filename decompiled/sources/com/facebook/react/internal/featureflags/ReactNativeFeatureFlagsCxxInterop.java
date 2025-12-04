package com.facebook.react.internal.featureflags;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0087 J\t\u0010\u0006\u001a\u00020\u0005H\u0087 J\t\u0010\u0007\u001a\u00020\u0005H\u0087 J\t\u0010\b\u001a\u00020\u0005H\u0087 J\t\u0010\t\u001a\u00020\u0005H\u0087 J\t\u0010\n\u001a\u00020\u0005H\u0087 J\t\u0010\u000b\u001a\u00020\u0005H\u0087 J\t\u0010\f\u001a\u00020\u0005H\u0087 J\t\u0010\r\u001a\u00020\u0005H\u0087 J\t\u0010\u000e\u001a\u00020\u0005H\u0087 J\t\u0010\u000f\u001a\u00020\u0005H\u0087 J\t\u0010\u0010\u001a\u00020\u0005H\u0087 J\t\u0010\u0011\u001a\u00020\u0005H\u0087 J\t\u0010\u0012\u001a\u00020\u0005H\u0087 J\t\u0010\u0013\u001a\u00020\u0005H\u0087 J\t\u0010\u0014\u001a\u00020\u0005H\u0087 J\t\u0010\u0015\u001a\u00020\u0005H\u0087 J\t\u0010\u0016\u001a\u00020\u0005H\u0087 J\t\u0010\u0017\u001a\u00020\u0005H\u0087 J\t\u0010\u0018\u001a\u00020\u0005H\u0087 J\t\u0010\u0019\u001a\u00020\u0005H\u0087 J\t\u0010\u001a\u001a\u00020\u0005H\u0087 J\t\u0010\u001b\u001a\u00020\u0005H\u0087 J\t\u0010\u001c\u001a\u00020\u0005H\u0087 J\t\u0010\u001d\u001a\u00020\u0005H\u0087 J\t\u0010\u001e\u001a\u00020\u0005H\u0087 J\t\u0010\u001f\u001a\u00020\u0005H\u0087 J\t\u0010 \u001a\u00020\u0005H\u0087 J\t\u0010!\u001a\u00020\u0005H\u0087 J\t\u0010\"\u001a\u00020\u0005H\u0087 J\t\u0010#\u001a\u00020\u0005H\u0087 J\t\u0010$\u001a\u00020\u0005H\u0087 J\t\u0010%\u001a\u00020\u0005H\u0087 J\t\u0010&\u001a\u00020\u0005H\u0087 J\t\u0010'\u001a\u00020\u0005H\u0087 J\t\u0010(\u001a\u00020\u0005H\u0087 J\t\u0010)\u001a\u00020\u0005H\u0087 J\t\u0010*\u001a\u00020\u0005H\u0087 J\t\u0010+\u001a\u00020\u0005H\u0087 J\t\u0010,\u001a\u00020\u0005H\u0087 J\t\u0010-\u001a\u00020\u0005H\u0087 J\t\u0010.\u001a\u00020\u0005H\u0087 J\t\u0010/\u001a\u00020\u0005H\u0087 J\t\u00100\u001a\u00020\u0005H\u0087 J\u0011\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0001H\u0087 J\t\u00104\u001a\u000202H\u0087 J\u0013\u00105\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u00020\u0001H\u0087 ¨\u00067"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsCxxInterop;", "", "<init>", "()V", "commonTestFlag", "", "disableMountItemReorderingAndroid", "enableAccumulatedUpdatesInRawPropsAndroid", "enableBridgelessArchitecture", "enableCppPropsIteratorSetter", "enableEagerRootViewAttachment", "enableFabricLogs", "enableFabricRenderer", "enableIOSViewClipToPaddingBox", "enableImagePrefetchingAndroid", "enableJSRuntimeGCOnMemoryPressureOnIOS", "enableLayoutAnimationsOnAndroid", "enableLayoutAnimationsOnIOS", "enableLongTaskAPI", "enableNativeCSSParsing", "enableNewBackgroundAndBorderDrawables", "enablePreciseSchedulingForPremountItemsOnAndroid", "enablePropsUpdateReconciliationAndroid", "enableReportEventPaintTime", "enableSynchronousStateUpdates", "enableUIConsistency", "enableViewCulling", "enableViewRecycling", "enableViewRecyclingForText", "enableViewRecyclingForView", "excludeYogaFromRawProps", "fixDifferentiatorEmittingUpdatesWithWrongParentTag", "fixMappingOfEventPrioritiesBetweenFabricAndReact", "fixMountingCoordinatorReportedPendingTransactionsOnAndroid", "fuseboxEnabledRelease", "fuseboxNetworkInspectionEnabled", "lazyAnimationCallbacks", "removeTurboModuleManagerDelegateMutex", "throwExceptionInsteadOfDeadlockOnTurboModuleSetupDuringSyncRenderIOS", "traceTurboModulePromiseRejectionsOnAndroid", "updateRuntimeShadowNodeReferencesOnCommit", "useAlwaysAvailableJSErrorHandling", "useFabricInterop", "useNativeViewConfigsInBridgelessMode", "useOptimizedEventBatchingOnAndroid", "useRawPropsJsiValue", "useShadowNodeStateOnClone", "useTurboModuleInterop", "useTurboModules", "override", "", "provider", "dangerouslyReset", "dangerouslyForceOverride", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactNativeFeatureFlagsCxxInterop {

    @NotNull
    public static final ReactNativeFeatureFlagsCxxInterop INSTANCE = new ReactNativeFeatureFlagsCxxInterop();

    @JvmStatic
    @DoNotStrip
    public static final native boolean commonTestFlag();

    @JvmStatic
    @DoNotStrip
    @Nullable
    public static final native String dangerouslyForceOverride(@NotNull Object provider);

    @JvmStatic
    @DoNotStrip
    public static final native void dangerouslyReset();

    @JvmStatic
    @DoNotStrip
    public static final native boolean disableMountItemReorderingAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableBridgelessArchitecture();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableCppPropsIteratorSetter();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableEagerRootViewAttachment();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableFabricLogs();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableFabricRenderer();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableIOSViewClipToPaddingBox();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableImagePrefetchingAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableJSRuntimeGCOnMemoryPressureOnIOS();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnIOS();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLongTaskAPI();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableNativeCSSParsing();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableNewBackgroundAndBorderDrawables();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enablePropsUpdateReconciliationAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableReportEventPaintTime();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableSynchronousStateUpdates();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableUIConsistency();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableViewCulling();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableViewRecycling();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableViewRecyclingForText();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableViewRecyclingForView();

    @JvmStatic
    @DoNotStrip
    public static final native boolean excludeYogaFromRawProps();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fuseboxEnabledRelease();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fuseboxNetworkInspectionEnabled();

    @JvmStatic
    @DoNotStrip
    public static final native boolean lazyAnimationCallbacks();

    @JvmStatic
    @DoNotStrip
    public static final native void override(@NotNull Object provider);

    @JvmStatic
    @DoNotStrip
    public static final native boolean removeTurboModuleManagerDelegateMutex();

    @JvmStatic
    @DoNotStrip
    public static final native boolean throwExceptionInsteadOfDeadlockOnTurboModuleSetupDuringSyncRenderIOS();

    @JvmStatic
    @DoNotStrip
    public static final native boolean traceTurboModulePromiseRejectionsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean updateRuntimeShadowNodeReferencesOnCommit();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useAlwaysAvailableJSErrorHandling();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useFabricInterop();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useNativeViewConfigsInBridgelessMode();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useOptimizedEventBatchingOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useRawPropsJsiValue();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useShadowNodeStateOnClone();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useTurboModuleInterop();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useTurboModules();

    private ReactNativeFeatureFlagsCxxInterop() {
    }

    static {
        SoLoader.loadLibrary("react_featureflagsjni");
    }
}
