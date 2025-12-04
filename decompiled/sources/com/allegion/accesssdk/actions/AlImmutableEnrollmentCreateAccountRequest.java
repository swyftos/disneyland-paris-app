package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.utilities.Constants;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
class AlImmutableEnrollmentCreateAccountRequest implements IAlImmutableRequestCacheable<CreateAccountMAHResponse> {
    private final boolean cacheOnly;
    protected final UUID deviceId;
    private final boolean ignoreCache;

    public AlImmutableEnrollmentCreateAccountRequest(UUID uuid, boolean z) {
        this.deviceId = (UUID) AlObjects.requireNonNull(uuid, "Device Id must not be null");
        this.ignoreCache = z;
        this.cacheOnly = false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AlImmutableEnrollmentCreateAccountRequest) {
            return this.deviceId.equals(((AlImmutableEnrollmentCreateAccountRequest) obj).deviceId);
        }
        return false;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return Constants.URI_ACCOUNT_ID;
    }

    public boolean getCacheOnly() {
        return this.cacheOnly;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<CreateAccountMAHResponse> getResponseType() {
        return CreateAccountMAHResponse.class;
    }

    public int hashCode() {
        return this.deviceId.hashCode();
    }

    @Nonnull
    public String toString() {
        return "AlEnrollmentCreateRequest {" + this.deviceId + ",  " + this.ignoreCache + "}";
    }

    public AlImmutableEnrollmentCreateAccountRequest(UUID uuid, boolean z, boolean z2) {
        this.deviceId = (UUID) AlObjects.requireNonNull(uuid, "Device Id must not be null");
        this.ignoreCache = z;
        this.cacheOnly = z2;
    }
}
