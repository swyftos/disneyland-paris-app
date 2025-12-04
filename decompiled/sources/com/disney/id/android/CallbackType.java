package com.disney.id.android;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/disney/id/android/CallbackType;", "", "(Ljava/lang/String;I)V", "EMAIL_VERIFICATION", "EXPIRED_SESSION", "LOGIN", "NEWSLETTERS", "PPU", "PROFILE", "REGISTER", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallbackType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CallbackType[] $VALUES;
    public static final CallbackType EMAIL_VERIFICATION = new CallbackType("EMAIL_VERIFICATION", 0);
    public static final CallbackType EXPIRED_SESSION = new CallbackType("EXPIRED_SESSION", 1);
    public static final CallbackType LOGIN = new CallbackType("LOGIN", 2);
    public static final CallbackType NEWSLETTERS = new CallbackType("NEWSLETTERS", 3);
    public static final CallbackType PPU = new CallbackType("PPU", 4);
    public static final CallbackType PROFILE = new CallbackType("PROFILE", 5);
    public static final CallbackType REGISTER = new CallbackType("REGISTER", 6);

    private static final /* synthetic */ CallbackType[] $values() {
        return new CallbackType[]{EMAIL_VERIFICATION, EXPIRED_SESSION, LOGIN, NEWSLETTERS, PPU, PROFILE, REGISTER};
    }

    @NotNull
    public static EnumEntries<CallbackType> getEntries() {
        return $ENTRIES;
    }

    public static CallbackType valueOf(String str) {
        return (CallbackType) Enum.valueOf(CallbackType.class, str);
    }

    public static CallbackType[] values() {
        return (CallbackType[]) $VALUES.clone();
    }

    private CallbackType(String str, int i) {
    }

    static {
        CallbackType[] callbackTypeArr$values = $values();
        $VALUES = callbackTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(callbackTypeArr$values);
    }
}
