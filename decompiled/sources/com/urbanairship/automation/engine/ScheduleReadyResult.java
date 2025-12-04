package com.urbanairship.automation.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "", "(Ljava/lang/String;I)V", "READY", "INVALIDATE", "NOT_READY", "SKIP", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScheduleReadyResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScheduleReadyResult[] $VALUES;
    public static final ScheduleReadyResult READY = new ScheduleReadyResult("READY", 0);
    public static final ScheduleReadyResult INVALIDATE = new ScheduleReadyResult("INVALIDATE", 1);
    public static final ScheduleReadyResult NOT_READY = new ScheduleReadyResult("NOT_READY", 2);
    public static final ScheduleReadyResult SKIP = new ScheduleReadyResult("SKIP", 3);

    private static final /* synthetic */ ScheduleReadyResult[] $values() {
        return new ScheduleReadyResult[]{READY, INVALIDATE, NOT_READY, SKIP};
    }

    @NotNull
    public static EnumEntries<ScheduleReadyResult> getEntries() {
        return $ENTRIES;
    }

    public static ScheduleReadyResult valueOf(String str) {
        return (ScheduleReadyResult) Enum.valueOf(ScheduleReadyResult.class, str);
    }

    public static ScheduleReadyResult[] values() {
        return (ScheduleReadyResult[]) $VALUES.clone();
    }

    private ScheduleReadyResult(String str, int i) {
    }

    static {
        ScheduleReadyResult[] scheduleReadyResultArr$values = $values();
        $VALUES = scheduleReadyResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scheduleReadyResultArr$values);
    }
}
