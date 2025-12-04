package com.disney.id.android;

import com.disney.id.android.tracker.TrackerEventKey;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/InitializationCallbackHolder;", "", "currentState", "Lcom/disney/id/android/OneIDState;", "getCurrentState", "()Lcom/disney/id/android/OneIDState;", "setCurrentState", "(Lcom/disney/id/android/OneIDState;)V", "stateCallback", "Lcom/disney/id/android/OneIDStateCallback;", "getStateCallback", "()Lcom/disney/id/android/OneIDStateCallback;", "setStateCallback", "(Lcom/disney/id/android/OneIDStateCallback;)V", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "getTrackerEventKey", "()Lcom/disney/id/android/tracker/TrackerEventKey;", "setTrackerEventKey", "(Lcom/disney/id/android/tracker/TrackerEventKey;)V", "reportState", "", BluetoothManager.BLE_STATUS_PARAM, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InitializationCallbackHolder {
    @NotNull
    OneIDState getCurrentState();

    @Nullable
    OneIDStateCallback getStateCallback();

    @Nullable
    TrackerEventKey getTrackerEventKey();

    void reportState(@NotNull OneIDState state);

    void setCurrentState(@NotNull OneIDState oneIDState);

    void setStateCallback(@Nullable OneIDStateCallback oneIDStateCallback);

    void setTrackerEventKey(@Nullable TrackerEventKey trackerEventKey);
}
