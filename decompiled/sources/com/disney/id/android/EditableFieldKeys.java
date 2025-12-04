package com.disney.id.android;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class EditableFieldKeys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EditableFieldKeys[] $VALUES;
    private final String key;
    public static final EditableFieldKeys ID = new EditableFieldKeys("ID", 0, "id");
    public static final EditableFieldKeys VALUE = new EditableFieldKeys("VALUE", 1, "value");
    public static final EditableFieldKeys REQUIRED = new EditableFieldKeys("REQUIRED", 2, "required");

    private static final /* synthetic */ EditableFieldKeys[] $values() {
        return new EditableFieldKeys[]{ID, VALUE, REQUIRED};
    }

    public static EditableFieldKeys valueOf(String str) {
        return (EditableFieldKeys) Enum.valueOf(EditableFieldKeys.class, str);
    }

    public static EditableFieldKeys[] values() {
        return (EditableFieldKeys[]) $VALUES.clone();
    }

    private EditableFieldKeys(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        EditableFieldKeys[] editableFieldKeysArr$values = $values();
        $VALUES = editableFieldKeysArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(editableFieldKeysArr$values);
    }
}
