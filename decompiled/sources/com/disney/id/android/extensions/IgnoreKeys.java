package com.disney.id.android.extensions;

import androidx.autofill.HintConstants;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class IgnoreKeys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IgnoreKeys[] $VALUES;
    public static final IgnoreKeys EMAIL = new IgnoreKeys("EMAIL", 0, "email");
    public static final IgnoreKeys PASSWORD = new IgnoreKeys("PASSWORD", 1, HintConstants.AUTOFILL_HINT_PASSWORD);
    public static final IgnoreKeys REGION = new IgnoreKeys("REGION", 2, "region");
    public static final IgnoreKeys USERNAME = new IgnoreKeys("USERNAME", 3, "username");
    private final String value;

    private static final /* synthetic */ IgnoreKeys[] $values() {
        return new IgnoreKeys[]{EMAIL, PASSWORD, REGION, USERNAME};
    }

    public static IgnoreKeys valueOf(String str) {
        return (IgnoreKeys) Enum.valueOf(IgnoreKeys.class, str);
    }

    public static IgnoreKeys[] values() {
        return (IgnoreKeys[]) $VALUES.clone();
    }

    private IgnoreKeys(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        IgnoreKeys[] ignoreKeysArr$values = $values();
        $VALUES = ignoreKeysArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(ignoreKeysArr$values);
    }
}
