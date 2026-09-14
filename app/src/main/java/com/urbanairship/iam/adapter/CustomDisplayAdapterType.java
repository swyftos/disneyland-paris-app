package com.urbanairship.iam.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1836d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "", "(Ljava/lang/String;I)V", "HTML", "MODAL", "FULLSCREEN", "BANNER", "CUSTOM", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum CustomDisplayAdapterType {
    HTML,
    MODAL,
    FULLSCREEN,
    BANNER,
    CUSTOM;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    @NotNull
    public static EnumEntries<CustomDisplayAdapterType> getEntries() {
        return $ENTRIES;
    }
}
