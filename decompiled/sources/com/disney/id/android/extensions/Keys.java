package com.disney.id.android.extensions;

import com.disney.id.android.Profile;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class Keys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Keys[] $VALUES;
    public static final Keys ADDRESSES = new Keys("ADDRESSES", 0, Profile.ADDRESSES);
    public static final Keys AGE_BANDS = new Keys("AGE_BANDS", 1, "ageBands");
    public static final Keys COMPLIANCE = new Keys("COMPLIANCE", 2, "compliance");
    public static final Keys DATA = new Keys("DATA", 3, "data");
    public static final Keys DEFAULT = new Keys("DEFAULT", 4, "DEFAULT");
    public static final Keys EDITABLE = new Keys("EDITABLE", 5, "editable");
    public static final Keys PHONES = new Keys("PHONES", 6, Profile.PHONES);
    public static final Keys PROFILE = new Keys("PROFILE", 7, "profile");
    public static final Keys REQUIRED = new Keys("REQUIRED", 8, "required");
    public static final Keys SITE_CONFIG = new Keys("SITE_CONFIG", 9, "siteConfig");
    public static final Keys TYPE = new Keys("TYPE", 10, "type");
    private final String value;

    private static final /* synthetic */ Keys[] $values() {
        return new Keys[]{ADDRESSES, AGE_BANDS, COMPLIANCE, DATA, DEFAULT, EDITABLE, PHONES, PROFILE, REQUIRED, SITE_CONFIG, TYPE};
    }

    public static Keys valueOf(String str) {
        return (Keys) Enum.valueOf(Keys.class, str);
    }

    public static Keys[] values() {
        return (Keys[]) $VALUES.clone();
    }

    private Keys(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        Keys[] keysArr$values = $values();
        $VALUES = keysArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(keysArr$values);
    }
}
