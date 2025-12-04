package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlPullRightsRequest;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
final class AlImmutableRightsPullRequest extends AlImmutableAuthenticatedRequest implements IAlImmutableRequestCacheable<AlPullRightsResponse> {
    private final boolean ignoreCache;

    public AlImmutableRightsPullRequest(AlPullRightsRequest alPullRightsRequest, UUID uuid, UUID uuid2) {
        super(uuid, uuid2);
        this.ignoreCache = alPullRightsRequest.getIgnoreCache();
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    public boolean equals(Object obj) {
        if (obj instanceof AlImmutableRightsPullRequest) {
            return super.equals((AlImmutableRightsPullRequest) obj);
        }
        return false;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return "access.rights." + this.accountId;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<AlPullRightsResponse> getResponseType() {
        return AlPullRightsResponse.class;
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.allegion.accesssdk.actions.AlImmutableAuthenticatedRequest
    @Nonnull
    public String toString() {
        return "AlRightsPullRequest {" + this.deviceId + ",  " + this.accountId + ",  " + this.ignoreCache + "}";
    }
}
