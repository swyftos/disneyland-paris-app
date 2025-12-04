package com.facebook.react.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/common/ReleaseLevel;", "", "<init>", "(Ljava/lang/String;I)V", "EXPERIMENTAL", "CANARY", "STABLE", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReleaseLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReleaseLevel[] $VALUES;
    public static final ReleaseLevel EXPERIMENTAL = new ReleaseLevel("EXPERIMENTAL", 0);
    public static final ReleaseLevel CANARY = new ReleaseLevel("CANARY", 1);
    public static final ReleaseLevel STABLE = new ReleaseLevel("STABLE", 2);

    private static final /* synthetic */ ReleaseLevel[] $values() {
        return new ReleaseLevel[]{EXPERIMENTAL, CANARY, STABLE};
    }

    @NotNull
    public static EnumEntries<ReleaseLevel> getEntries() {
        return $ENTRIES;
    }

    private ReleaseLevel(String str, int i) {
    }

    static {
        ReleaseLevel[] releaseLevelArr$values = $values();
        $VALUES = releaseLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(releaseLevelArr$values);
    }

    public static ReleaseLevel valueOf(String str) {
        return (ReleaseLevel) Enum.valueOf(ReleaseLevel.class, str);
    }

    public static ReleaseLevel[] values() {
        return (ReleaseLevel[]) $VALUES.clone();
    }
}
