package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlDeviceSearchRequest;

/* loaded from: classes2.dex */
final class AlImmutableDeviceSearchRequest {
    private final long searchTime;

    public AlImmutableDeviceSearchRequest(AlDeviceSearchRequest alDeviceSearchRequest) {
        this.searchTime = alDeviceSearchRequest.getSearchTime();
    }

    public long getSearchTime() {
        return this.searchTime;
    }
}
