package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.utilities.Constants;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
class AlImmutableEnrollmentConnectedAccountRequest extends AlImmutableAuthenticatedRequest implements IAlImmutableRequestCacheable<CreateConnectedAccountMAHResponse> {
    private final AlImmutableEnrollmentRequest enrollmentRequest;

    public AlImmutableEnrollmentConnectedAccountRequest(UUID uuid, UUID uuid2, AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) {
        super(uuid, uuid2);
        this.enrollmentRequest = (AlImmutableEnrollmentRequest) AlObjects.requireNonNull(alImmutableEnrollmentRequest, "Enrollment request must not be null");
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    public boolean equals(Object obj) {
        if (!(obj instanceof AlImmutableEnrollmentConnectedAccountRequest)) {
            return false;
        }
        AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest = (AlImmutableEnrollmentConnectedAccountRequest) obj;
        return super.equals(alImmutableEnrollmentConnectedAccountRequest) && this.enrollmentRequest.equals(alImmutableEnrollmentConnectedAccountRequest.enrollmentRequest);
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return Constants.URI_CONNECTED_ACCOUNT_ID;
    }

    public AlImmutableEnrollmentRequest getEnrollmentRequest() {
        return this.enrollmentRequest;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.enrollmentRequest.getIgnoreCache();
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<CreateConnectedAccountMAHResponse> getResponseType() {
        return CreateConnectedAccountMAHResponse.class;
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    public int hashCode() {
        return this.enrollmentRequest.hashCode() ^ super.hashCode();
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    @Nonnull
    public String toString() {
        return "AlEnrollmentConnectedRequest {" + this.accountId + ",  " + this.deviceId + ", " + this.enrollmentRequest + ",  " + this.enrollmentRequest.getIgnoreCache() + "}";
    }
}
