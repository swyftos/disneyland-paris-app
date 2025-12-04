package com.disney.id.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/GuestFlow;", "", "flow", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFlow", "()Ljava/lang/String;", "LOGIN", "REGISTER", "RECOVERY", "CONTACT_CSR", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuestFlow {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GuestFlow[] $VALUES;
    private final String flow;
    public static final GuestFlow LOGIN = new GuestFlow("LOGIN", 0, "LOGIN_FLOW");
    public static final GuestFlow REGISTER = new GuestFlow("REGISTER", 1, "REGISTRATION_FLOW");
    public static final GuestFlow RECOVERY = new GuestFlow("RECOVERY", 2, "RECOVERY_FLOW");
    public static final GuestFlow CONTACT_CSR = new GuestFlow("CONTACT_CSR", 3, "CONTACT_CSR_FLOW");

    private static final /* synthetic */ GuestFlow[] $values() {
        return new GuestFlow[]{LOGIN, REGISTER, RECOVERY, CONTACT_CSR};
    }

    @NotNull
    public static EnumEntries<GuestFlow> getEntries() {
        return $ENTRIES;
    }

    public static GuestFlow valueOf(String str) {
        return (GuestFlow) Enum.valueOf(GuestFlow.class, str);
    }

    public static GuestFlow[] values() {
        return (GuestFlow[]) $VALUES.clone();
    }

    private GuestFlow(String str, int i, String str2) {
        this.flow = str2;
    }

    @NotNull
    public final String getFlow() {
        return this.flow;
    }

    static {
        GuestFlow[] guestFlowArr$values = $values();
        $VALUES = guestFlowArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(guestFlowArr$values);
    }
}
