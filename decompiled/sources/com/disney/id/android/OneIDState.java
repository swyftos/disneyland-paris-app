package com.disney.id.android;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/OneIDState;", "", "(Ljava/lang/String;I)V", "Initializing", "Ready", "Renewing", "PermanentFailure", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OneIDState[] $VALUES;
    public static final OneIDState Initializing = new OneIDState("Initializing", 0);
    public static final OneIDState Ready = new OneIDState("Ready", 1);
    public static final OneIDState Renewing = new OneIDState("Renewing", 2);
    public static final OneIDState PermanentFailure = new OneIDState("PermanentFailure", 3);

    private static final /* synthetic */ OneIDState[] $values() {
        return new OneIDState[]{Initializing, Ready, Renewing, PermanentFailure};
    }

    @NotNull
    public static EnumEntries<OneIDState> getEntries() {
        return $ENTRIES;
    }

    public static OneIDState valueOf(String str) {
        return (OneIDState) Enum.valueOf(OneIDState.class, str);
    }

    public static OneIDState[] values() {
        return (OneIDState[]) $VALUES.clone();
    }

    private OneIDState(String str, int i) {
    }

    static {
        OneIDState[] oneIDStateArr$values = $values();
        $VALUES = oneIDStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(oneIDStateArr$values);
    }
}
