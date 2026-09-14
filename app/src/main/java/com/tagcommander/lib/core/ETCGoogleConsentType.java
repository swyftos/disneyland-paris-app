package com.tagcommander.lib.core;

import expo.modules.interfaces.permissions.PermissionsResponse;

/* JADX INFO: loaded from: classes4.dex */
public enum ETCGoogleConsentType {
    GRANTED(PermissionsResponse.GRANTED_KEY),
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
