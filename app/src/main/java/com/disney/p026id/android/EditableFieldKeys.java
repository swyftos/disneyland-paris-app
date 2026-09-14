package com.disney.p026id.android;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
enum EditableFieldKeys {
    ID("id"),
    VALUE("value"),
    REQUIRED("required");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String key;

    EditableFieldKeys(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
