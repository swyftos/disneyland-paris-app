package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlEnrollDeviceRequest;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.utilities.Constants;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
final class AlImmutableEnrollmentRequest implements IAlImmutableRequestCacheable<AlEnrollDeviceResponse> {
    private final String idToken;
    private final boolean ignoreCache = true;
    private final UUID integrationId;

    public AlImmutableEnrollmentRequest(AlEnrollDeviceRequest alEnrollDeviceRequest) {
        this.integrationId = (UUID) AlObjects.requireNonNull(alEnrollDeviceRequest.getIntegrationId(), "Integration ID must not be null", AlErrorCode.ENROLLMENT_INVALID_INTEGRATION_ID);
        this.idToken = (String) AlObjects.requireNonNull(alEnrollDeviceRequest.getIdToken(), "Id Token must not be null", AlErrorCode.ENROLLMENT_INVALID_TOKEN);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AlImmutableEnrollmentRequest)) {
            return false;
        }
        AlImmutableEnrollmentRequest alImmutableEnrollmentRequest = (AlImmutableEnrollmentRequest) obj;
        return this.integrationId.equals(alImmutableEnrollmentRequest.integrationId) && this.idToken.equals(alImmutableEnrollmentRequest.idToken);
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return Constants.URI_ENROLL;
    }

    public String getIdToken() {
        return this.idToken;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    public UUID getIntegrationId() {
        return this.integrationId;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<AlEnrollDeviceResponse> getResponseType() {
        return AlEnrollDeviceResponse.class;
    }

    public int hashCode() {
        return this.idToken.hashCode() ^ this.integrationId.hashCode();
    }

    @Nonnull
    public String toString() {
        return "AlEnrollmentRequest {" + this.integrationId + ",  " + this.idToken + ",  " + this.ignoreCache + "}";
    }
}
