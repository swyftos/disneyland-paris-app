package com.urbanairship.channel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/channel/RegistrationResult;", "", "(Ljava/lang/String;I)V", "FAILED", "SUCCESS", "NEEDS_UPDATE", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationResult[] $VALUES;
    public static final RegistrationResult FAILED = new RegistrationResult("FAILED", 0);
    public static final RegistrationResult SUCCESS = new RegistrationResult("SUCCESS", 1);
    public static final RegistrationResult NEEDS_UPDATE = new RegistrationResult("NEEDS_UPDATE", 2);

    private static final /* synthetic */ RegistrationResult[] $values() {
        return new RegistrationResult[]{FAILED, SUCCESS, NEEDS_UPDATE};
    }

    @NotNull
    public static EnumEntries<RegistrationResult> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationResult valueOf(String str) {
        return (RegistrationResult) Enum.valueOf(RegistrationResult.class, str);
    }

    public static RegistrationResult[] values() {
        return (RegistrationResult[]) $VALUES.clone();
    }

    private RegistrationResult(String str, int i) {
    }

    static {
        RegistrationResult[] registrationResultArr$values = $values();
        $VALUES = registrationResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(registrationResultArr$values);
    }
}
