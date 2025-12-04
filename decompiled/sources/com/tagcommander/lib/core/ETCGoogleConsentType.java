package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
public enum ETCGoogleConsentType {
    GRANTED("granted"),
    DENIED("denied");

    private final String value;

    ETCGoogleConsentType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
