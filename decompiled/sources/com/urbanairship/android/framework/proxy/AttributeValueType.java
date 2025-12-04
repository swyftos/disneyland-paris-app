package com.urbanairship.android.framework.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AttributeValueType;", "", "(Ljava/lang/String;I)V", "STRING", "NUMBER", "DATE", "JSON", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AttributeValueType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AttributeValueType[] $VALUES;
    public static final AttributeValueType STRING = new AttributeValueType("STRING", 0);
    public static final AttributeValueType NUMBER = new AttributeValueType("NUMBER", 1);
    public static final AttributeValueType DATE = new AttributeValueType("DATE", 2);
    public static final AttributeValueType JSON = new AttributeValueType("JSON", 3);

    private static final /* synthetic */ AttributeValueType[] $values() {
        return new AttributeValueType[]{STRING, NUMBER, DATE, JSON};
    }

    @NotNull
    public static EnumEntries<AttributeValueType> getEntries() {
        return $ENTRIES;
    }

    public static AttributeValueType valueOf(String str) {
        return (AttributeValueType) Enum.valueOf(AttributeValueType.class, str);
    }

    public static AttributeValueType[] values() {
        return (AttributeValueType[]) $VALUES.clone();
    }

    private AttributeValueType(String str, int i) {
    }

    static {
        AttributeValueType[] attributeValueTypeArr$values = $values();
        $VALUES = attributeValueTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(attributeValueTypeArr$values);
    }
}
