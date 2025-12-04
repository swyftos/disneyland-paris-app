package com.urbanairship.iam.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "", "(Ljava/lang/String;I)V", "HTML", "MODAL", "FULLSCREEN", "BANNER", "CUSTOM", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDisplayAdapterType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomDisplayAdapterType[] $VALUES;
    public static final CustomDisplayAdapterType HTML = new CustomDisplayAdapterType("HTML", 0);
    public static final CustomDisplayAdapterType MODAL = new CustomDisplayAdapterType("MODAL", 1);
    public static final CustomDisplayAdapterType FULLSCREEN = new CustomDisplayAdapterType("FULLSCREEN", 2);
    public static final CustomDisplayAdapterType BANNER = new CustomDisplayAdapterType("BANNER", 3);
    public static final CustomDisplayAdapterType CUSTOM = new CustomDisplayAdapterType("CUSTOM", 4);

    private static final /* synthetic */ CustomDisplayAdapterType[] $values() {
        return new CustomDisplayAdapterType[]{HTML, MODAL, FULLSCREEN, BANNER, CUSTOM};
    }

    @NotNull
    public static EnumEntries<CustomDisplayAdapterType> getEntries() {
        return $ENTRIES;
    }

    public static CustomDisplayAdapterType valueOf(String str) {
        return (CustomDisplayAdapterType) Enum.valueOf(CustomDisplayAdapterType.class, str);
    }

    public static CustomDisplayAdapterType[] values() {
        return (CustomDisplayAdapterType[]) $VALUES.clone();
    }

    private CustomDisplayAdapterType(String str, int i) {
    }

    static {
        CustomDisplayAdapterType[] customDisplayAdapterTypeArr$values = $values();
        $VALUES = customDisplayAdapterTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(customDisplayAdapterTypeArr$values);
    }
}
