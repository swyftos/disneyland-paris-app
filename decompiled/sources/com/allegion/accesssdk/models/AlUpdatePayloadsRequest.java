package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlPayloadType;

/* loaded from: classes2.dex */
public final class AlUpdatePayloadsRequest {
    private String accessToken;
    private AlPayloadType[] payloadTypes;
    private int[] rightIds;

    public String getAccessToken() {
        return this.accessToken;
    }

    public AlPayloadType[] getPayloadTypes() {
        return this.payloadTypes;
    }

    public int[] getRightIds() {
        return this.rightIds;
    }

    public AlUpdatePayloadsRequest setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AlUpdatePayloadsRequest setPayloadTypes(AlPayloadType[] alPayloadTypeArr) {
        this.payloadTypes = alPayloadTypeArr;
        return this;
    }

    public AlUpdatePayloadsRequest setRightIds(int[] iArr) {
        this.rightIds = iArr;
        return this;
    }
}
