package com.urbanairship.featureflag;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
enum VariableType {
    FIXED("fixed"),
    VARIANTS("variant");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsonValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    VariableType(String str) {
        this.jsonValue = str;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }
}
