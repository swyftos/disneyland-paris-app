package com.facebook.react.internal.featureflags;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;

@DoNotStrip
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'J\b\u0010\b\u001a\u00020\u0003H'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'J\b\u0010\u000b\u001a\u00020\u0003H'J\b\u0010\f\u001a\u00020\u0003H'J\b\u0010\r\u001a\u00020\u0003H'J\b\u0010\u000e\u001a\u00020\u0003H'J\b\u0010\u000f\u001a\u00020\u0003H'J\b\u0010\u0010\u001a\u00020\u0003H'J\b\u0010\u0011\u001a\u00020\u0003H'J\b\u0010\u0012\u001a\u00020\u0003H'J\b\u0010\u0013\u001a\u00020\u0003H'J\b\u0010\u0014\u001a\u00020\u0003H'J\b\u0010\u0015\u001a\u00020\u0003H'J\b\u0010\u0016\u001a\u00020\u0003H'J\b\u0010\u0017\u001a\u00020\u0003H'J\b\u0010\u0018\u001a\u00020\u0003H'J\b\u0010\u0019\u001a\u00020\u0003H'J\b\u0010\u001a\u001a\u00020\u0003H'J\b\u0010\u001b\u001a\u00020\u0003H'J\b\u0010\u001c\u001a\u00020\u0003H'J\b\u0010\u001d\u001a\u00020\u0003H'J\b\u0010\u001e\u001a\u00020\u0003H'J\b\u0010\u001f\u001a\u00020\u0003H'J\b\u0010 \u001a\u00020\u0003H'J\b\u0010!\u001a\u00020\u0003H'J\b\u0010\"\u001a\u00020\u0003H'J\b\u0010#\u001a\u00020\u0003H'J\b\u0010$\u001a\u00020\u0003H'J\b\u0010%\u001a\u00020\u0003H'J\b\u0010&\u001a\u00020\u0003H'J\b\u0010'\u001a\u00020\u0003H'J\b\u0010(\u001a\u00020\u0003H'J\b\u0010)\u001a\u00020\u0003H'J\b\u0010*\u001a\u00020\u0003H'J\b\u0010+\u001a\u00020\u0003H'J\b\u0010,\u001a\u00020\u0003H'J\b\u0010-\u001a\u00020\u0003H'J\b\u0010.\u001a\u00020\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "", "commonTestFlag", "", "disableMountItemReorderingAndroid", "enableAccumulatedUpdatesInRawPropsAndroid", "enableBridgelessArchitecture", "enableCppPropsIteratorSetter", "enableEagerRootViewAttachment", "enableFabricLogs", "enableFabricRenderer", "enableIOSViewClipToPaddingBox", "enableImagePrefetchingAndroid", "enableJSRuntimeGCOnMemoryPressureOnIOS", "enableLayoutAnimationsOnAndroid", "enableLayoutAnimationsOnIOS", "enableLongTaskAPI", "enableNativeCSSParsing", "enableNewBackgroundAndBorderDrawables", "enablePreciseSchedulingForPremountItemsOnAndroid", "enablePropsUpdateReconciliationAndroid", "enableReportEventPaintTime", "enableSynchronousStateUpdates", "enableUIConsistency", "enableViewCulling", "enableViewRecycling", "enableViewRecyclingForText", "enableViewRecyclingForView", "excludeYogaFromRawProps", "fixDifferentiatorEmittingUpdatesWithWrongParentTag", "fixMappingOfEventPrioritiesBetweenFabricAndReact", "fixMountingCoordinatorReportedPendingTransactionsOnAndroid", "fuseboxEnabledRelease", "fuseboxNetworkInspectionEnabled", "lazyAnimationCallbacks", "removeTurboModuleManagerDelegateMutex", "throwExceptionInsteadOfDeadlockOnTurboModuleSetupDuringSyncRenderIOS", "traceTurboModulePromiseRejectionsOnAndroid", "updateRuntimeShadowNodeReferencesOnCommit", "useAlwaysAvailableJSErrorHandling", "useFabricInterop", "useNativeViewConfigsInBridgelessMode", "useOptimizedEventBatchingOnAndroid", "useRawPropsJsiValue", "useShadowNodeStateOnClone", "useTurboModuleInterop", "useTurboModules", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ReactNativeFeatureFlagsProvider {
    @DoNotStrip
    boolean commonTestFlag();

    @DoNotStrip
    boolean disableMountItemReorderingAndroid();

    @DoNotStrip
    boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @DoNotStrip
    boolean enableBridgelessArchitecture();

    @DoNotStrip
    boolean enableCppPropsIteratorSetter();

    @DoNotStrip
    boolean enableEagerRootViewAttachment();

    @DoNotStrip
    boolean enableFabricLogs();

    @DoNotStrip
    boolean enableFabricRenderer();

    @DoNotStrip
    boolean enableIOSViewClipToPaddingBox();

    @DoNotStrip
    boolean enableImagePrefetchingAndroid();

    @DoNotStrip
    boolean enableJSRuntimeGCOnMemoryPressureOnIOS();

    @DoNotStrip
    boolean enableLayoutAnimationsOnAndroid();

    @DoNotStrip
    boolean enableLayoutAnimationsOnIOS();

    @DoNotStrip
    boolean enableLongTaskAPI();

    @DoNotStrip
    boolean enableNativeCSSParsing();

    @DoNotStrip
    boolean enableNewBackgroundAndBorderDrawables();

    @DoNotStrip
    boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    @DoNotStrip
    boolean enablePropsUpdateReconciliationAndroid();

    @DoNotStrip
    boolean enableReportEventPaintTime();

    @DoNotStrip
    boolean enableSynchronousStateUpdates();

    @DoNotStrip
    boolean enableUIConsistency();

    @DoNotStrip
    boolean enableViewCulling();

    @DoNotStrip
    boolean enableViewRecycling();

    @DoNotStrip
    boolean enableViewRecyclingForText();

    @DoNotStrip
    boolean enableViewRecyclingForView();

    @DoNotStrip
    boolean excludeYogaFromRawProps();

    @DoNotStrip
    boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    @DoNotStrip
    boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @DoNotStrip
    boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    @DoNotStrip
    boolean fuseboxEnabledRelease();

    @DoNotStrip
    boolean fuseboxNetworkInspectionEnabled();

    @DoNotStrip
    boolean lazyAnimationCallbacks();

    @DoNotStrip
    boolean removeTurboModuleManagerDelegateMutex();

    @DoNotStrip
    boolean throwExceptionInsteadOfDeadlockOnTurboModuleSetupDuringSyncRenderIOS();

    @DoNotStrip
    boolean traceTurboModulePromiseRejectionsOnAndroid();

    @DoNotStrip
    boolean updateRuntimeShadowNodeReferencesOnCommit();

    @DoNotStrip
    boolean useAlwaysAvailableJSErrorHandling();

    @DoNotStrip
    boolean useFabricInterop();

    @DoNotStrip
    boolean useNativeViewConfigsInBridgelessMode();

    @DoNotStrip
    boolean useOptimizedEventBatchingOnAndroid();

    @DoNotStrip
    boolean useRawPropsJsiValue();

    @DoNotStrip
    boolean useShadowNodeStateOnClone();

    @DoNotStrip
    boolean useTurboModuleInterop();

    @DoNotStrip
    boolean useTurboModules();
}
