package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlObjects;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
class AlImmutableAuthenticatedRequest {
    protected final UUID accountId;
    protected final UUID deviceId;

    public AlImmutableAuthenticatedRequest(UUID uuid, UUID uuid2) {
        this.accountId = (UUID) AlObjects.requireNonNull(uuid2, "Account Id must not be null");
        this.deviceId = (UUID) AlObjects.requireNonNull(uuid, "Device Id must not be null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AlImmutableAuthenticatedRequest)) {
            return false;
        }
        AlImmutableAuthenticatedRequest alImmutableAuthenticatedRequest = (AlImmutableAuthenticatedRequest) obj;
        return this.accountId.equals(alImmutableAuthenticatedRequest.accountId) && this.deviceId.equals(alImmutableAuthenticatedRequest.deviceId);
    }

    public int hashCode() {
        return this.deviceId.hashCode() ^ this.accountId.hashCode();
    }

    @Nonnull
    public String toString() {
        return "AlAuthenticatedRequest {" + this.accountId + ",  " + this.deviceId + "}";
    }
}
