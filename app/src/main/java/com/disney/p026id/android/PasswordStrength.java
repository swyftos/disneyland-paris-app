package com.disney.p026id.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/disney/id/android/PasswordStrength;", "", "(Ljava/lang/String;I)V", "NONE", "LOW", "MEDIUM", "STRONG", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum PasswordStrength {
    NONE,
    LOW,
    MEDIUM,
    STRONG;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    @NotNull
    public static EnumEntries<PasswordStrength> getEntries() {
        return $ENTRIES;
    }
}
