package com.urbanairship.featureflag;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
final class VariableType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VariableType[] $VALUES;
    public static final VariableType FIXED = new VariableType("FIXED", 0, "fixed");
    public static final VariableType VARIANTS = new VariableType("VARIANTS", 1, "variant");
    private final String jsonValue;

    private static final /* synthetic */ VariableType[] $values() {
        return new VariableType[]{FIXED, VARIANTS};
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static VariableType valueOf(String str) {
        return (VariableType) Enum.valueOf(VariableType.class, str);
    }

    public static VariableType[] values() {
        return (VariableType[]) $VALUES.clone();
    }

    private VariableType(String str, int i, String str2) {
        this.jsonValue = str2;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }

    static {
        VariableType[] variableTypeArr$values = $values();
        $VALUES = variableTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(variableTypeArr$values);
    }
}
