package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.logging.AlLog;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.UUID;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AlPayload implements Serializable {
    private final byte[] credential;
    private final String deviceId;
    private final UUID rightId;
    private final AlPayloadType type;

    @JsonCreator
    public AlPayload(@JsonProperty("rightId") UUID uuid, @JsonProperty("type") AlPayloadType alPayloadType, @JsonProperty("credential") byte[] bArr, @JsonProperty("deviceId") @Nullable String str) {
        AlLog.d("Alpayload: rightId " + uuid.toString() + " deviceId " + str, new Object[0]);
        this.rightId = uuid;
        this.deviceId = str;
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("Credential cannot be empty or null");
        }
        this.credential = bArr;
        this.type = (AlPayloadType) AlObjects.requireNonNull(alPayloadType, "Type must not be null", AlErrorCode.SDK_NULL_VALUE_ERROR);
    }

    public final byte[] getCredential() {
        return this.credential;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final UUID getRightId() {
        return this.rightId;
    }

    public final AlPayloadType getType() {
        return this.type;
    }
}
