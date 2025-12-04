package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class AlPullRightsResponse implements Serializable {
    private final AlRight[] rights;

    public AlPullRightsResponse(@JsonProperty("rights") AlRight[] alRightArr) {
        this.rights = (AlRight[]) AlObjects.requireNonNull(alRightArr, "Rights must not be null", AlErrorCode.SDK_NULL_VALUE_ERROR);
    }

    public final AlRight[] getRights() {
        return this.rights;
    }
}
