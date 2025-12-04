package com.urbanairship.featureflag;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
final class FeatureFlagPayloadType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureFlagPayloadType[] $VALUES;
    public static final FeatureFlagPayloadType DEFERRED = new FeatureFlagPayloadType("DEFERRED", 0, "deferred");
    public static final FeatureFlagPayloadType STATIC = new FeatureFlagPayloadType("STATIC", 1, "static");
    private final String jsonValue;

    private static final /* synthetic */ FeatureFlagPayloadType[] $values() {
        return new FeatureFlagPayloadType[]{DEFERRED, STATIC};
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static FeatureFlagPayloadType valueOf(String str) {
        return (FeatureFlagPayloadType) Enum.valueOf(FeatureFlagPayloadType.class, str);
    }

    public static FeatureFlagPayloadType[] values() {
        return (FeatureFlagPayloadType[]) $VALUES.clone();
    }

    private FeatureFlagPayloadType(String str, int i, String str2) {
        this.jsonValue = str2;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }

    static {
        FeatureFlagPayloadType[] featureFlagPayloadTypeArr$values = $values();
        $VALUES = featureFlagPayloadTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(featureFlagPayloadTypeArr$values);
    }
}
