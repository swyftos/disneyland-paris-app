package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlDeviceType;

/* loaded from: classes2.dex */
public final class AlDeviceSearchRequest {
    private AlDeviceType[] deviceTypes;
    private long searchTime;

    public AlDeviceType[] getDeviceTypes() {
        return this.deviceTypes;
    }

    public long getSearchTime() {
        return this.searchTime;
    }

    public AlDeviceSearchRequest setDeviceTypes(AlDeviceType[] alDeviceTypeArr) {
        this.deviceTypes = alDeviceTypeArr;
        return this;
    }

    public AlDeviceSearchRequest setSearchTime(long j) {
        this.searchTime = j;
        return this;
    }
}
