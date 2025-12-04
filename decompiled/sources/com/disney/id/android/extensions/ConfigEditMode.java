package com.disney.id.android.extensions;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class ConfigEditMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfigEditMode[] $VALUES;
    public static final ConfigEditMode CREATE = new ConfigEditMode("CREATE", 0, "CREATE");
    public static final ConfigEditMode UPDATE = new ConfigEditMode("UPDATE", 1, "UPDATE");
    private final String value;

    private static final /* synthetic */ ConfigEditMode[] $values() {
        return new ConfigEditMode[]{CREATE, UPDATE};
    }

    public static ConfigEditMode valueOf(String str) {
        return (ConfigEditMode) Enum.valueOf(ConfigEditMode.class, str);
    }

    public static ConfigEditMode[] values() {
        return (ConfigEditMode[]) $VALUES.clone();
    }

    private ConfigEditMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        ConfigEditMode[] configEditModeArr$values = $values();
        $VALUES = configEditModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(configEditModeArr$values);
    }
}
