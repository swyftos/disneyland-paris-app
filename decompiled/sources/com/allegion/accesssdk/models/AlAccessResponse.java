package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlPayloadState;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/allegion/accesssdk/models/AlAccessResponse;", "", "", "toString", "()Ljava/lang/String;", "Lcom/allegion/accesssdk/enums/AlPayloadState;", "component1", "()Lcom/allegion/accesssdk/enums/AlPayloadState;", BluetoothManager.BLE_STATUS_PARAM, "copy", "(Lcom/allegion/accesssdk/enums/AlPayloadState;)Lcom/allegion/accesssdk/models/AlAccessResponse;", "", "hashCode", "()I", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Lcom/allegion/accesssdk/enums/AlPayloadState;", "getState", "<init>", "(Lcom/allegion/accesssdk/enums/AlPayloadState;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AlAccessResponse {

    @NotNull
    private final AlPayloadState state;

    public AlAccessResponse(@NotNull AlPayloadState state) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        this.state = state;
    }

    public static /* synthetic */ AlAccessResponse copy$default(AlAccessResponse alAccessResponse, AlPayloadState alPayloadState, int i, Object obj) {
        if ((i & 1) != 0) {
            alPayloadState = alAccessResponse.state;
        }
        return alAccessResponse.copy(alPayloadState);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AlPayloadState getState() {
        return this.state;
    }

    @NotNull
    public final AlAccessResponse copy(@NotNull AlPayloadState state) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        return new AlAccessResponse(state);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            return (other instanceof AlAccessResponse) && Intrinsics.areEqual(this.state, ((AlAccessResponse) other).state);
        }
        return true;
    }

    @NotNull
    public final AlPayloadState getState() {
        return this.state;
    }

    public int hashCode() {
        AlPayloadState alPayloadState = this.state;
        if (alPayloadState != null) {
            return alPayloadState.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return this.state.toString();
    }
}
