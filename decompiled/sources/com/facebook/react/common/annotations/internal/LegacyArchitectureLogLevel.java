package com.facebook.react.common.annotations.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/common/annotations/internal/LegacyArchitectureLogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LegacyArchitectureLogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LegacyArchitectureLogLevel[] $VALUES;
    public static final LegacyArchitectureLogLevel WARNING = new LegacyArchitectureLogLevel("WARNING", 0);
    public static final LegacyArchitectureLogLevel ERROR = new LegacyArchitectureLogLevel("ERROR", 1);

    private static final /* synthetic */ LegacyArchitectureLogLevel[] $values() {
        return new LegacyArchitectureLogLevel[]{WARNING, ERROR};
    }

    @NotNull
    public static EnumEntries<LegacyArchitectureLogLevel> getEntries() {
        return $ENTRIES;
    }

    private LegacyArchitectureLogLevel(String str, int i) {
    }

    static {
        LegacyArchitectureLogLevel[] legacyArchitectureLogLevelArr$values = $values();
        $VALUES = legacyArchitectureLogLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(legacyArchitectureLogLevelArr$values);
    }

    public static LegacyArchitectureLogLevel valueOf(String str) {
        return (LegacyArchitectureLogLevel) Enum.valueOf(LegacyArchitectureLogLevel.class, str);
    }

    public static LegacyArchitectureLogLevel[] values() {
        return (LegacyArchitectureLogLevel[]) $VALUES.clone();
    }
}
