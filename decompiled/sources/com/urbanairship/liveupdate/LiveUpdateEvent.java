package com.urbanairship.liveupdate;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "", "(Ljava/lang/String;I)V", "START", "END", "UPDATE", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LiveUpdateEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LiveUpdateEvent[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final LiveUpdateEvent START = new LiveUpdateEvent("START", 0);
    public static final LiveUpdateEvent END = new LiveUpdateEvent("END", 1);
    public static final LiveUpdateEvent UPDATE = new LiveUpdateEvent("UPDATE", 2);

    private static final /* synthetic */ LiveUpdateEvent[] $values() {
        return new LiveUpdateEvent[]{START, END, UPDATE};
    }

    @NotNull
    public static EnumEntries<LiveUpdateEvent> getEntries() {
        return $ENTRIES;
    }

    public static LiveUpdateEvent valueOf(String str) {
        return (LiveUpdateEvent) Enum.valueOf(LiveUpdateEvent.class, str);
    }

    public static LiveUpdateEvent[] values() {
        return (LiveUpdateEvent[]) $VALUES.clone();
    }

    private LiveUpdateEvent(String str, int i) {
    }

    static {
        LiveUpdateEvent[] liveUpdateEventArr$values = $values();
        $VALUES = liveUpdateEventArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(liveUpdateEventArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateEvent$Companion;", "", "()V", "from", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "value", "", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final LiveUpdateEvent from(@NotNull String value) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (LiveUpdateEvent liveUpdateEvent : LiveUpdateEvent.getEntries()) {
                if (StringsKt.equals(liveUpdateEvent.name(), value, true)) {
                    return liveUpdateEvent;
                }
            }
            throw new IllegalArgumentException("Invalid Live Update event: " + value);
        }
    }
}
