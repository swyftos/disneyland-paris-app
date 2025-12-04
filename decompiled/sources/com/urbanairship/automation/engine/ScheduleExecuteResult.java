package com.urbanairship.automation.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "", "(Ljava/lang/String;I)V", "CANCEL", "FINISHED", "RETRY", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScheduleExecuteResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScheduleExecuteResult[] $VALUES;
    public static final ScheduleExecuteResult CANCEL = new ScheduleExecuteResult("CANCEL", 0);
    public static final ScheduleExecuteResult FINISHED = new ScheduleExecuteResult("FINISHED", 1);
    public static final ScheduleExecuteResult RETRY = new ScheduleExecuteResult("RETRY", 2);

    private static final /* synthetic */ ScheduleExecuteResult[] $values() {
        return new ScheduleExecuteResult[]{CANCEL, FINISHED, RETRY};
    }

    @NotNull
    public static EnumEntries<ScheduleExecuteResult> getEntries() {
        return $ENTRIES;
    }

    public static ScheduleExecuteResult valueOf(String str) {
        return (ScheduleExecuteResult) Enum.valueOf(ScheduleExecuteResult.class, str);
    }

    public static ScheduleExecuteResult[] values() {
        return (ScheduleExecuteResult[]) $VALUES.clone();
    }

    private ScheduleExecuteResult(String str, int i) {
    }

    static {
        ScheduleExecuteResult[] scheduleExecuteResultArr$values = $values();
        $VALUES = scheduleExecuteResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scheduleExecuteResultArr$values);
    }
}
