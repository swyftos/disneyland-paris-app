package com.allegion.accesssdk.models;

/* loaded from: classes2.dex */
public final class AlDeleteRightsRequest {
    private String accessToken;
    private int[] rightIds;

    public String getAccessToken() {
        return this.accessToken;
    }

    public int[] getRightIds() {
        return this.rightIds;
    }

    public AlDeleteRightsRequest setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AlDeleteRightsRequest setRightIds(int[] iArr) {
        this.rightIds = iArr;
        return this;
    }
}
