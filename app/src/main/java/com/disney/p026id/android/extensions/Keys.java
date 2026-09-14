package com.disney.p026id.android.extensions;

import com.disney.p026id.android.Profile;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
enum Keys {
    ADDRESSES(Profile.ADDRESSES),
    AGE_BANDS("ageBands"),
    COMPLIANCE("compliance"),
    DATA("data"),
    DEFAULT("DEFAULT"),
    EDITABLE("editable"),
    PHONES(Profile.PHONES),
    PROFILE("profile"),
    REQUIRED("required"),
    SITE_CONFIG("siteConfig"),
    TYPE("type");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    Keys(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
