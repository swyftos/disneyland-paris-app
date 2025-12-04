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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/PasswordStrength;", "", "(Ljava/lang/String;I)V", "NONE", "LOW", "MEDIUM", "STRONG", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PasswordStrength {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PasswordStrength[] $VALUES;
    public static final PasswordStrength NONE = new PasswordStrength("NONE", 0);
    public static final PasswordStrength LOW = new PasswordStrength("LOW", 1);
    public static final PasswordStrength MEDIUM = new PasswordStrength("MEDIUM", 2);
    public static final PasswordStrength STRONG = new PasswordStrength("STRONG", 3);

    private static final /* synthetic */ PasswordStrength[] $values() {
        return new PasswordStrength[]{NONE, LOW, MEDIUM, STRONG};
    }

    @NotNull
    public static EnumEntries<PasswordStrength> getEntries() {
        return $ENTRIES;
    }

    public static PasswordStrength valueOf(String str) {
        return (PasswordStrength) Enum.valueOf(PasswordStrength.class, str);
    }

    public static PasswordStrength[] values() {
        return (PasswordStrength[]) $VALUES.clone();
    }

    private PasswordStrength(String str, int i) {
    }

    static {
        PasswordStrength[] passwordStrengthArr$values = $values();
        $VALUES = passwordStrengthArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(passwordStrengthArr$values);
    }
}
