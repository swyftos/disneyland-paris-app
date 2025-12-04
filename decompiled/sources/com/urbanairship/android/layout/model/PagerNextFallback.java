package com.urbanairship.android.layout.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerNextFallback;", "", "(Ljava/lang/String;I)V", "NONE", "DISMISS", "FIRST", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PagerNextFallback {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PagerNextFallback[] $VALUES;
    public static final PagerNextFallback NONE = new PagerNextFallback("NONE", 0);
    public static final PagerNextFallback DISMISS = new PagerNextFallback("DISMISS", 1);
    public static final PagerNextFallback FIRST = new PagerNextFallback("FIRST", 2);

    private static final /* synthetic */ PagerNextFallback[] $values() {
        return new PagerNextFallback[]{NONE, DISMISS, FIRST};
    }

    @NotNull
    public static EnumEntries<PagerNextFallback> getEntries() {
        return $ENTRIES;
    }

    public static PagerNextFallback valueOf(String str) {
        return (PagerNextFallback) Enum.valueOf(PagerNextFallback.class, str);
    }

    public static PagerNextFallback[] values() {
        return (PagerNextFallback[]) $VALUES.clone();
    }

    private PagerNextFallback(String str, int i) {
    }

    static {
        PagerNextFallback[] pagerNextFallbackArr$values = $values();
        $VALUES = pagerNextFallbackArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pagerNextFallbackArr$values);
    }
}
