package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlAccessRequest;

/* loaded from: classes2.dex */
final class AlImmutableProvider {
    static AlImmutableDeviceAccessRequest build(AlAccessRequest alAccessRequest) {
        return new AlImmutableDeviceAccessRequest(alAccessRequest);
    }
}
