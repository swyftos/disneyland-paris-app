package com.disney.id.android;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/disney/id/android/AgeBand;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADULT", "TEEN", "CHILD", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgeBand {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AgeBand[] $VALUES;
    private final String value;
    public static final AgeBand ADULT = new AgeBand("ADULT", 0, "ADULT");
    public static final AgeBand TEEN = new AgeBand("TEEN", 1, "TEEN");
    public static final AgeBand CHILD = new AgeBand("CHILD", 2, "CHILD");

    private static final /* synthetic */ AgeBand[] $values() {
        return new AgeBand[]{ADULT, TEEN, CHILD};
    }

    @NotNull
    public static EnumEntries<AgeBand> getEntries() {
        return $ENTRIES;
    }

    public static AgeBand valueOf(String str) {
        return (AgeBand) Enum.valueOf(AgeBand.class, str);
    }

    public static AgeBand[] values() {
        return (AgeBand[]) $VALUES.clone();
    }

    private AgeBand(String str, int i, String str2) {
        this.value = str2;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    static {
        AgeBand[] ageBandArr$values = $values();
        $VALUES = ageBandArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(ageBandArr$values);
    }
}
