package com.contentsquare.android.api.bridge.xpf;

import com.dlp.BluetoothManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeInterface;", "", "bridgeType", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeType;", "getBridgeType", "()Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeType;", "notifyCsInAppEnabled", "", "enabled", "", "notifySDKStateChanges", "type", "Lcom/contentsquare/android/api/bridge/xpf/SDKStateChangeType;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/contentsquare/android/api/bridge/xpf/SDKState;", "notifySessionReplayEnabled", "enable", "notifySrMaskingHasChanged", "setSessionReplayCapture", "capture", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeSessionReplayCapture;", "updateBridgeConfig", "bridgeConfig", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExternalBridgeInterface {
    @NotNull
    ExternalBridgeType getBridgeType();

    void notifyCsInAppEnabled(boolean enabled);

    void notifySDKStateChanges(@NotNull SDKStateChangeType type, @NotNull SDKState state);

    void notifySessionReplayEnabled(boolean enable);

    void notifySrMaskingHasChanged(boolean enabled);

    void setSessionReplayCapture(@Nullable ExternalBridgeSessionReplayCapture capture);

    void updateBridgeConfig(@NotNull String bridgeConfig);
}
