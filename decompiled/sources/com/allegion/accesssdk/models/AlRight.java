package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AlRight implements Serializable {
    private final Map<String, String> attributes;
    private final UUID id;
    private final AlPayloadType[] payloadTypes;

    @JsonCreator
    public AlRight(@JsonProperty("id") UUID uuid, @JsonProperty("payloadTypes") AlPayloadType[] alPayloadTypeArr, @JsonProperty("attributes") @Nullable Map<String, String> map) {
        this.id = (UUID) AlObjects.requireNonNull(uuid, "Id must not be null");
        this.payloadTypes = (AlPayloadType[]) AlObjects.requireNonNull(alPayloadTypeArr, "Payload Types must not be null");
        this.attributes = map;
    }

    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    public final UUID getId() {
        return this.id;
    }

    public final AlPayloadType[] getPayloadTypes() {
        return this.payloadTypes;
    }
}
