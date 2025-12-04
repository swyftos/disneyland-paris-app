package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlAccessRequest;
import com.allegion.accesssdk.models.AlPayload;

/* loaded from: classes2.dex */
final class AlImmutableDeviceAccessRequest {
    private final AlPayload payload;

    public AlImmutableDeviceAccessRequest(AlAccessRequest alAccessRequest) {
        this.payload = (AlPayload) AlObjects.requireNonNull(alAccessRequest.getPayload(), "Request must not be null");
    }

    public AlPayload getPayload() {
        return this.payload;
    }
}
