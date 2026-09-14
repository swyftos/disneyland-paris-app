package com.disney.p026id.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1836d2 = {"Lcom/disney/id/android/GuestFlow;", "", "flow", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFlow", "()Ljava/lang/String;", "LOGIN", "REGISTER", "RECOVERY", "CONTACT_CSR", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum GuestFlow {
    LOGIN("LOGIN_FLOW"),
    REGISTER("REGISTRATION_FLOW"),
    RECOVERY("RECOVERY_FLOW"),
    CONTACT_CSR("CONTACT_CSR_FLOW");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String flow;

    @NotNull
    public static EnumEntries<GuestFlow> getEntries() {
        return $ENTRIES;
    }

    GuestFlow(String str) {
        this.flow = str;
    }

    @NotNull
    public final String getFlow() {
        return this.flow;
    }
}
