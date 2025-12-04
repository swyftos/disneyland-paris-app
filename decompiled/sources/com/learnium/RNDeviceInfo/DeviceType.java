package com.learnium.RNDeviceInfo;

/* loaded from: classes4.dex */
public enum DeviceType {
    HANDSET("Handset"),
    TABLET("Tablet"),
    TV("Tv"),
    UNKNOWN("unknown");

    private final String value;

    DeviceType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
