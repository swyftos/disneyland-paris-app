package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlObjects;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class AlPayloadsRequest {
    private Map<String, Serializable> payloadArgs = new HashMap();
    private AlPayloadType payloadType;

    @Nullable
    private String propertyBag;

    public AlPayloadsRequest addPayloadArgs(String str, Serializable serializable) {
        Map<String, Serializable> map = this.payloadArgs;
        AlErrorCode alErrorCode = AlErrorCode.SDK_NULL_VALUE_ERROR;
        map.put((String) AlObjects.requireNonNull(str, alErrorCode), (Serializable) AlObjects.requireNonNull(serializable, alErrorCode));
        return this;
    }

    public Map<String, Serializable> getPayloadArgs() {
        return Collections.unmodifiableMap(this.payloadArgs);
    }

    public AlPayloadType getPayloadType() {
        return this.payloadType;
    }

    @Nullable
    public String getPropertyBag() {
        return this.propertyBag;
    }

    public AlPayloadsRequest setPayloadArgs(Map<String, Serializable> map) {
        this.payloadArgs = new HashMap((Map) AlObjects.requireNonNull(map, AlErrorCode.SDK_NULL_VALUE_ERROR));
        return this;
    }

    public AlPayloadsRequest setPayloadType(AlPayloadType alPayloadType) {
        this.payloadType = alPayloadType;
        return this;
    }

    public AlPayloadsRequest setPropertyBag(@Nullable String str) {
        this.propertyBag = str;
        return this;
    }
}
