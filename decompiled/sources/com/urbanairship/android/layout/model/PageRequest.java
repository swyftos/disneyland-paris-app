package com.urbanairship.android.layout.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/model/PageRequest;", "", "(Ljava/lang/String;I)V", "NEXT", "BACK", "FIRST", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PageRequest {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PageRequest[] $VALUES;
    public static final PageRequest NEXT = new PageRequest("NEXT", 0);
    public static final PageRequest BACK = new PageRequest("BACK", 1);
    public static final PageRequest FIRST = new PageRequest("FIRST", 2);

    private static final /* synthetic */ PageRequest[] $values() {
        return new PageRequest[]{NEXT, BACK, FIRST};
    }

    @NotNull
    public static EnumEntries<PageRequest> getEntries() {
        return $ENTRIES;
    }

    public static PageRequest valueOf(String str) {
        return (PageRequest) Enum.valueOf(PageRequest.class, str);
    }

    public static PageRequest[] values() {
        return (PageRequest[]) $VALUES.clone();
    }

    private PageRequest(String str, int i) {
    }

    static {
        PageRequest[] pageRequestArr$values = $values();
        $VALUES = pageRequestArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pageRequestArr$values);
    }
}
