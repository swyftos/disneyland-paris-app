package com.disney.id.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/disney/id/android/extensions/PhoneType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DAY", "MOBILE", "NIGHT", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PhoneType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PhoneType[] $VALUES;
    public static final PhoneType DAY = new PhoneType("DAY", 0, "DAY");
    public static final PhoneType MOBILE = new PhoneType("MOBILE", 1, "MOBILE");
    public static final PhoneType NIGHT = new PhoneType("NIGHT", 2, "NIGHT");
    private final String type;

    private static final /* synthetic */ PhoneType[] $values() {
        return new PhoneType[]{DAY, MOBILE, NIGHT};
    }

    @NotNull
    public static EnumEntries<PhoneType> getEntries() {
        return $ENTRIES;
    }

    public static PhoneType valueOf(String str) {
        return (PhoneType) Enum.valueOf(PhoneType.class, str);
    }

    public static PhoneType[] values() {
        return (PhoneType[]) $VALUES.clone();
    }

    private PhoneType(String str, int i, String str2) {
        this.type = str2;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    static {
        PhoneType[] phoneTypeArr$values = $values();
        $VALUES = phoneTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(phoneTypeArr$values);
    }
}
