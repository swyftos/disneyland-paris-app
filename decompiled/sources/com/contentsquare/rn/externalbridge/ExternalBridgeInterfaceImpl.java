package com.contentsquare.rn.externalbridge;

import com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeSessionReplayCapture;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeType;
import com.contentsquare.android.api.bridge.xpf.SDKState;
import com.contentsquare.android.api.bridge.xpf.SDKStateChangeType;
import com.contentsquare.rn.ContentsquareModule;
import com.contentsquare.rn.eventEmitter.CSEventEmitter;
import com.contentsquare.rn.utils.ExponentialBackoff;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/rn/externalbridge/ExternalBridgeInterfaceImpl;", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeInterface;", "contentsquareModule", "Lcom/contentsquare/rn/ContentsquareModule;", "mCSEventEmitter", "Lcom/contentsquare/rn/eventEmitter/CSEventEmitter;", "bridgeType", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeType;", "<init>", "(Lcom/contentsquare/rn/ContentsquareModule;Lcom/contentsquare/rn/eventEmitter/CSEventEmitter;Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeType;)V", "getBridgeType", "()Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeType;", "notifyCsInAppEnabled", "", "enabled", "", "notifySDKStateChanges", "type", "Lcom/contentsquare/android/api/bridge/xpf/SDKStateChangeType;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/contentsquare/android/api/bridge/xpf/SDKState;", "notifySessionReplayEnabled", "enable", "notifySrMaskingHasChanged", "setSessionReplayCapture", "capture", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeSessionReplayCapture;", "updateBridgeConfig", "bridgeConfig", "", "notifyFeatureFlagChange", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExternalBridgeInterfaceImpl implements ExternalBridgeInterface {

    @NotNull
    private final ExternalBridgeType bridgeType;

    @NotNull
    private final ContentsquareModule contentsquareModule;

    @NotNull
    private final CSEventEmitter mCSEventEmitter;

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void notifyCsInAppEnabled(boolean enabled) {
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void notifySDKStateChanges(@NotNull SDKStateChangeType type, @NotNull SDKState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void notifySessionReplayEnabled(boolean enable) {
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void notifySrMaskingHasChanged(boolean enabled) {
    }

    public ExternalBridgeInterfaceImpl(@NotNull ContentsquareModule contentsquareModule, @NotNull CSEventEmitter mCSEventEmitter, @NotNull ExternalBridgeType bridgeType) {
        Intrinsics.checkNotNullParameter(contentsquareModule, "contentsquareModule");
        Intrinsics.checkNotNullParameter(mCSEventEmitter, "mCSEventEmitter");
        Intrinsics.checkNotNullParameter(bridgeType, "bridgeType");
        this.contentsquareModule = contentsquareModule;
        this.mCSEventEmitter = mCSEventEmitter;
        this.bridgeType = bridgeType;
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    @NotNull
    public ExternalBridgeType getBridgeType() {
        return this.bridgeType;
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void setSessionReplayCapture(@Nullable ExternalBridgeSessionReplayCapture capture) {
        this.contentsquareModule.setExternalBridgeSessionReplayCapture(capture);
    }

    @Override // com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface
    public void updateBridgeConfig(@NotNull String bridgeConfig) {
        Intrinsics.checkNotNullParameter(bridgeConfig, "bridgeConfig");
        notifyFeatureFlagChange(bridgeConfig);
    }

    private final void notifyFeatureFlagChange(final String bridgeConfig) {
        new ExponentialBackoff(10, 0.1d, new ExponentialBackoff.Task() { // from class: com.contentsquare.rn.externalbridge.ExternalBridgeInterfaceImpl$$ExternalSyntheticLambda0
            @Override // com.contentsquare.rn.utils.ExponentialBackoff.Task
            public final void run(ExponentialBackoff.TaskCompletionCallback taskCompletionCallback) {
                ExternalBridgeInterfaceImpl.notifyFeatureFlagChange$lambda$0(this.f$0, bridgeConfig, taskCompletionCallback);
            }
        }, new ExponentialBackoff.FailureCallback() { // from class: com.contentsquare.rn.externalbridge.ExternalBridgeInterfaceImpl$$ExternalSyntheticLambda1
            @Override // com.contentsquare.rn.utils.ExponentialBackoff.FailureCallback
            public final void onFailure() {
                ExternalBridgeInterfaceImpl.notifyFeatureFlagChange$lambda$1();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFeatureFlagChange$lambda$0(ExternalBridgeInterfaceImpl externalBridgeInterfaceImpl, String str, ExponentialBackoff.TaskCompletionCallback completionCallback) {
        Intrinsics.checkNotNullParameter(completionCallback, "completionCallback");
        completionCallback.onComplete(externalBridgeInterfaceImpl.mCSEventEmitter.sendFeatureFlags(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFeatureFlagChange$lambda$1() {
        System.out.println((Object) "All retries failed.");
    }
}
