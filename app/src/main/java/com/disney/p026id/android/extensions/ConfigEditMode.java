package com.disney.p026id.android.extensions;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
enum ConfigEditMode {
    CREATE("CREATE"),
    UPDATE("UPDATE");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    ConfigEditMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
