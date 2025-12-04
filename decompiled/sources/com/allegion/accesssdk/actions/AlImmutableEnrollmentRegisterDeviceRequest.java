package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.utilities.Constants;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
class AlImmutableEnrollmentRegisterDeviceRequest implements IAlImmutableRequestCacheable<RegisterDeviceMAHResponse> {
    private final boolean cacheOnly;
    private final UUID deviceId;
    private final boolean ignoreCache;

    AlImmutableEnrollmentRegisterDeviceRequest(boolean z) {
        this.deviceId = UUID.fromString("88888888-4444-4444-4444-CCCCCCCCCCCC");
        this.ignoreCache = z;
        this.cacheOnly = false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AlImmutableEnrollmentRegisterDeviceRequest) {
            return this.deviceId.equals(((AlImmutableEnrollmentRegisterDeviceRequest) obj).deviceId);
        }
        return false;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return Constants.URI_DEVICE_ID;
    }

    public boolean getCacheOnly() {
        return this.cacheOnly;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<RegisterDeviceMAHResponse> getResponseType() {
        return RegisterDeviceMAHResponse.class;
    }

    public int hashCode() {
        return this.deviceId.hashCode();
    }

    @Nonnull
    public String toString() {
        return "AlEnrollmentRegisterRequest {" + this.deviceId + ",  " + this.ignoreCache + "}";
    }

    AlImmutableEnrollmentRegisterDeviceRequest(boolean z, boolean z2) {
        this.deviceId = UUID.fromString("88888888-4444-4444-4444-CCCCCCCCCCCC");
        this.ignoreCache = z;
        this.cacheOnly = z2;
    }
}
