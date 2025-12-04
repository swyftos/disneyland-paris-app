package com.disney.id.android;

import com.disney.id.android.tracker.TrackerEventKey;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/disney/id/android/OneIDInitializationCallbackHolder;", "Lcom/disney/id/android/InitializationCallbackHolder;", "()V", "currentState", "Lcom/disney/id/android/OneIDState;", "getCurrentState", "()Lcom/disney/id/android/OneIDState;", "setCurrentState", "(Lcom/disney/id/android/OneIDState;)V", "stateCallback", "Lcom/disney/id/android/OneIDStateCallback;", "getStateCallback", "()Lcom/disney/id/android/OneIDStateCallback;", "setStateCallback", "(Lcom/disney/id/android/OneIDStateCallback;)V", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "getTrackerEventKey", "()Lcom/disney/id/android/tracker/TrackerEventKey;", "setTrackerEventKey", "(Lcom/disney/id/android/tracker/TrackerEventKey;)V", "reportState", "", BluetoothManager.BLE_STATUS_PARAM, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDInitializationCallbackHolder implements InitializationCallbackHolder {
    private OneIDState currentState = OneIDState.Initializing;
    private OneIDStateCallback stateCallback;
    private TrackerEventKey trackerEventKey;

    @Override // com.disney.id.android.InitializationCallbackHolder
    @Nullable
    public OneIDStateCallback getStateCallback() {
        return this.stateCallback;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    public void setStateCallback(@Nullable OneIDStateCallback oneIDStateCallback) {
        this.stateCallback = oneIDStateCallback;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    @NotNull
    public OneIDState getCurrentState() {
        return this.currentState;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    public void setCurrentState(@NotNull OneIDState oneIDState) {
        Intrinsics.checkNotNullParameter(oneIDState, "<set-?>");
        this.currentState = oneIDState;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    @Nullable
    public TrackerEventKey getTrackerEventKey() {
        return this.trackerEventKey;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    public void setTrackerEventKey(@Nullable TrackerEventKey trackerEventKey) {
        this.trackerEventKey = trackerEventKey;
    }

    @Override // com.disney.id.android.InitializationCallbackHolder
    public void reportState(@NotNull OneIDState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        setCurrentState(state);
        OneIDStateCallback stateCallback = getStateCallback();
        if (stateCallback != null) {
            stateCallback.stateChange(state);
        }
        if (state == OneIDState.PermanentFailure || state == OneIDState.Ready) {
            setStateCallback(null);
        }
    }
}
