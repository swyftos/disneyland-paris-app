package com.disney.p026id.android.extensions;

import androidx.autofill.HintConstants;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
enum IgnoreKeys {
    EMAIL("email"),
    PASSWORD(HintConstants.AUTOFILL_HINT_PASSWORD),
    REGION("region"),
    USERNAME("username");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    IgnoreKeys(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
