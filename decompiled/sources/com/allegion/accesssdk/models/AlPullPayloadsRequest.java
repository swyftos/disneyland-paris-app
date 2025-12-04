package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlRequestCacheable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class AlPullPayloadsRequest implements IAlRequestCacheable {
    private String accessToken;
    private boolean ignoreCache;
    private ArrayList<AlPayloadsRequest> payloadRequests = new ArrayList<>();
    private UUID rightId;

    public AlPullPayloadsRequest addPayloadRequests(AlPayloadsRequest alPayloadsRequest) {
        this.payloadRequests.add((AlPayloadsRequest) AlObjects.requireNonNull(alPayloadsRequest, AlErrorCode.SDK_NULL_VALUE_ERROR));
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    public List<AlPayloadsRequest> getPayloadRequests() {
        return Collections.unmodifiableList(this.payloadRequests);
    }

    public UUID getRightId() {
        return this.rightId;
    }

    public AlPullPayloadsRequest setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AlPullPayloadsRequest setIgnoreCache(boolean z) {
        this.ignoreCache = z;
        return this;
    }

    public AlPullPayloadsRequest setPayloadRequests(List<AlPayloadsRequest> list) {
        this.payloadRequests = new ArrayList<>((Collection) AlObjects.requireNonNull(list, AlErrorCode.SDK_NULL_VALUE_ERROR));
        return this;
    }

    public AlPullPayloadsRequest setRightId(UUID uuid) {
        this.rightId = uuid;
        return this;
    }
}
