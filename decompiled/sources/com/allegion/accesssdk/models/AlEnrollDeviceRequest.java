package com.allegion.accesssdk.models;

import java.util.UUID;

/* loaded from: classes2.dex */
public final class AlEnrollDeviceRequest {
    private String idToken;
    private UUID integrationId;

    public String getIdToken() {
        return this.idToken;
    }

    public UUID getIntegrationId() {
        return this.integrationId;
    }

    public AlEnrollDeviceRequest setIdToken(String str) {
        this.idToken = str;
        return this;
    }

    public AlEnrollDeviceRequest setIntegrationId(UUID uuid) {
        this.integrationId = uuid;
        return this;
    }
}
