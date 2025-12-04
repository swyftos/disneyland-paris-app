package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.AccessPayloadsMAHWebRequestData;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlPayloadsRequest;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
final class AlImmutablePayloadsRequest extends AccessPayloadsMAHWebRequestData {
    public AlImmutablePayloadsRequest(AlPayloadsRequest alPayloadsRequest) {
        super(((AlPayloadType) AlObjects.requireNonNull(alPayloadsRequest.getPayloadType(), "Payload type must not be null")).toString(), alPayloadsRequest.getPropertyBag(), (Map) AlObjects.requireNonNull(alPayloadsRequest.getPayloadArgs(), "Payload args must not be null"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AlImmutablePayloadsRequest)) {
            return false;
        }
        AlImmutablePayloadsRequest alImmutablePayloadsRequest = (AlImmutablePayloadsRequest) obj;
        if ((getMobileDevicePropertyBag() != null || alImmutablePayloadsRequest.getMobileDevicePropertyBag() == null) && ((getMobileDevicePropertyBag() == null || alImmutablePayloadsRequest.getMobileDevicePropertyBag() != null) && getPayloadArgs().equals(alImmutablePayloadsRequest.getPayloadArgs()) && getPayloadType().equals(alImmutablePayloadsRequest.getPayloadType()))) {
            return getMobileDevicePropertyBag() == null || getMobileDevicePropertyBag().equals(alImmutablePayloadsRequest.getMobileDevicePropertyBag());
        }
        return false;
    }

    public int hashCode() {
        return getPayloadType().hashCode() ^ ((getMobileDevicePropertyBag() == null ? 0 : getMobileDevicePropertyBag().hashCode()) ^ getPayloadArgs().hashCode());
    }

    @Nonnull
    public String toString() {
        return "AlPayloadsRequest {" + getPayloadType() + ",  " + getMobileDevicePropertyBag() + ", " + getPayloadArgs() + "}";
    }
}
