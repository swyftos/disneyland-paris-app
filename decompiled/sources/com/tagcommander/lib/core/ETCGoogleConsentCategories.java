package com.tagcommander.lib.core;

/* loaded from: classes4.dex */
public enum ETCGoogleConsentCategories {
    AD_STORAGE("ad_storage"),
    ANALYTICS_STORAGE("analytics_storage"),
    AD_USER_DATA("ad_user_data"),
    AD_PERSONALIZATION("ad_personalization");

    private final String value;

    ETCGoogleConsentCategories(String str) {
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
