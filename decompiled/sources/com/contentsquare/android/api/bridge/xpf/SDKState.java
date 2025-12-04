package com.contentsquare.android.api.bridge.xpf;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/SDKState;", "", "isOptIn", "", "isTracking", "(ZZ)V", "()Z", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SDKState {
    private final boolean isOptIn;
    private final boolean isTracking;

    public SDKState(boolean z, boolean z2) {
        this.isOptIn = z;
        this.isTracking = z2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(SDKState.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.contentsquare.android.api.bridge.xpf.SDKState");
        SDKState sDKState = (SDKState) other;
        return this.isOptIn == sDKState.isOptIn && this.isTracking == sDKState.isTracking;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isTracking) + (Boolean.hashCode(this.isOptIn) * 31);
    }

    /* renamed from: isOptIn, reason: from getter */
    public final boolean getIsOptIn() {
        return this.isOptIn;
    }

    /* renamed from: isTracking, reason: from getter */
    public final boolean getIsTracking() {
        return this.isTracking;
    }
}
