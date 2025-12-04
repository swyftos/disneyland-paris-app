package com.allegion.accesssdk.models;

import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class AlEnrollDeviceResponse implements Serializable {
    private final UUID accountId;
    private final UUID connectedAccountId;
    private final UUID deviceId;

    public AlEnrollDeviceResponse(UUID uuid, UUID uuid2, UUID uuid3) {
        this.deviceId = uuid;
        this.accountId = uuid2;
        this.connectedAccountId = uuid3;
    }

    public UUID getAccountId() {
        return this.accountId;
    }

    public UUID getConnectedAccountId() {
        return this.connectedAccountId;
    }

    public UUID getDeviceId() {
        return this.deviceId;
    }
}
