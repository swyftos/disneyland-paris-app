package com.urbanairship.featureflag;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
enum FeatureFlagPayloadType {
    DEFERRED("deferred"),
    STATIC("static");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsonValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    FeatureFlagPayloadType(String str) {
        this.jsonValue = str;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }
}
