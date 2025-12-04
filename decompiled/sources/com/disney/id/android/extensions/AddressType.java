package com.disney.id.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/disney/id/android/extensions/AddressType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "BILLING", "HOME", "SCHOOL", "SHIPPING", "WORK", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AddressType[] $VALUES;
    public static final AddressType BILLING = new AddressType("BILLING", 0, "BILLING");
    public static final AddressType HOME = new AddressType("HOME", 1, "HOME");
    public static final AddressType SCHOOL = new AddressType("SCHOOL", 2, "SCHOOL");
    public static final AddressType SHIPPING = new AddressType("SHIPPING", 3, "SHIPPING");
    public static final AddressType WORK = new AddressType("WORK", 4, "WORK");
    private final String type;

    private static final /* synthetic */ AddressType[] $values() {
        return new AddressType[]{BILLING, HOME, SCHOOL, SHIPPING, WORK};
    }

    @NotNull
    public static EnumEntries<AddressType> getEntries() {
        return $ENTRIES;
    }

    public static AddressType valueOf(String str) {
        return (AddressType) Enum.valueOf(AddressType.class, str);
    }

    public static AddressType[] values() {
        return (AddressType[]) $VALUES.clone();
    }

    private AddressType(String str, int i, String str2) {
        this.type = str2;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    static {
        AddressType[] addressTypeArr$values = $values();
        $VALUES = addressTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(addressTypeArr$values);
    }
}
