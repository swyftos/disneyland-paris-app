package com.urbanairship.automation.engine;

import androidx.room.Entity;
import androidx.room.TypeConverters;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TypeConverters({JsonTypeConverters.class})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 /2\u00020\u0001:\u0001/B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\b\u0010-\u001a\u0004\u0018\u00010.R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001c¨\u00060"}, d2 = {"Lcom/urbanairship/automation/engine/ScheduleEntity;", "", "scheduleId", "", "group", "executionCount", "", "preparedScheduleInfo", "Lcom/urbanairship/json/JsonValue;", "schedule", "scheduleState", "scheduleStateChangeDate", "", "triggerInfo", "triggerSessionId", "associatedData", "(Ljava/lang/String;Ljava/lang/String;ILcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;JLcom/urbanairship/json/JsonValue;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getAssociatedData", "()Lcom/urbanairship/json/JsonValue;", "setAssociatedData", "(Lcom/urbanairship/json/JsonValue;)V", "getExecutionCount", "()I", "setExecutionCount", "(I)V", "getGroup", "()Ljava/lang/String;", "setGroup", "(Ljava/lang/String;)V", "getPreparedScheduleInfo", "setPreparedScheduleInfo", "getSchedule", "setSchedule", "getScheduleId", "setScheduleId", "getScheduleState", "setScheduleState", "getScheduleStateChangeDate", "()J", "setScheduleStateChangeDate", "(J)V", "getTriggerInfo", "setTriggerInfo", "getTriggerSessionId", "setTriggerSessionId", "toScheduleData", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = "schedules")
@SourceDebugExtension({"SMAP\nAutomationStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationStore.kt\ncom/urbanairship/automation/engine/ScheduleEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,419:1\n1#2:420\n*E\n"})
/* loaded from: classes5.dex */
public final class ScheduleEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private JsonValue associatedData;
    private int executionCount;
    private String group;
    private JsonValue preparedScheduleInfo;
    private JsonValue schedule;
    private String scheduleId;
    private String scheduleState;
    private long scheduleStateChangeDate;
    private JsonValue triggerInfo;
    private String triggerSessionId;

    public ScheduleEntity(@NotNull String scheduleId, @Nullable String str, int i, @Nullable JsonValue jsonValue, @NotNull JsonValue schedule, @NotNull String scheduleState, long j, @Nullable JsonValue jsonValue2, @Nullable String str2, @Nullable JsonValue jsonValue3) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Intrinsics.checkNotNullParameter(scheduleState, "scheduleState");
        this.scheduleId = scheduleId;
        this.group = str;
        this.executionCount = i;
        this.preparedScheduleInfo = jsonValue;
        this.schedule = schedule;
        this.scheduleState = scheduleState;
        this.scheduleStateChangeDate = j;
        this.triggerInfo = jsonValue2;
        this.triggerSessionId = str2;
        this.associatedData = jsonValue3;
    }

    @NotNull
    public final String getScheduleId() {
        return this.scheduleId;
    }

    public final void setScheduleId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheduleId = str;
    }

    @Nullable
    public final String getGroup() {
        return this.group;
    }

    public final void setGroup(@Nullable String str) {
        this.group = str;
    }

    public final int getExecutionCount() {
        return this.executionCount;
    }

    public final void setExecutionCount(int i) {
        this.executionCount = i;
    }

    @Nullable
    public final JsonValue getPreparedScheduleInfo() {
        return this.preparedScheduleInfo;
    }

    public final void setPreparedScheduleInfo(@Nullable JsonValue jsonValue) {
        this.preparedScheduleInfo = jsonValue;
    }

    @NotNull
    public final JsonValue getSchedule() {
        return this.schedule;
    }

    public final void setSchedule(@NotNull JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(jsonValue, "<set-?>");
        this.schedule = jsonValue;
    }

    @NotNull
    public final String getScheduleState() {
        return this.scheduleState;
    }

    public final void setScheduleState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheduleState = str;
    }

    public final long getScheduleStateChangeDate() {
        return this.scheduleStateChangeDate;
    }

    public final void setScheduleStateChangeDate(long j) {
        this.scheduleStateChangeDate = j;
    }

    @Nullable
    public final JsonValue getTriggerInfo() {
        return this.triggerInfo;
    }

    public final void setTriggerInfo(@Nullable JsonValue jsonValue) {
        this.triggerInfo = jsonValue;
    }

    @Nullable
    public final String getTriggerSessionId() {
        return this.triggerSessionId;
    }

    public final void setTriggerSessionId(@Nullable String str) {
        this.triggerSessionId = str;
    }

    @Nullable
    public final JsonValue getAssociatedData() {
        return this.associatedData;
    }

    public final void setAssociatedData(@Nullable JsonValue jsonValue) {
        this.associatedData = jsonValue;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/engine/ScheduleEntity$Companion;", "", "()V", "fromScheduleData", "Lcom/urbanairship/automation/engine/ScheduleEntity;", "data", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ScheduleEntity fromScheduleData(@NotNull AutomationScheduleData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String identifier = data.getSchedule().getIdentifier();
            String group = data.getSchedule().getGroup();
            int executionCount = data.getExecutionCount();
            PreparedScheduleInfo preparedScheduleInfo = data.getPreparedScheduleInfo();
            JsonValue jsonValue = preparedScheduleInfo != null ? preparedScheduleInfo.getJsonValue() : null;
            JsonValue jsonValue2 = data.getSchedule().getJsonValue();
            String string = data.getScheduleState().toString();
            long scheduleStateChangeDate = data.getScheduleStateChangeDate();
            TriggeringInfo triggerInfo = data.getTriggerInfo();
            return new ScheduleEntity(identifier, group, executionCount, jsonValue, jsonValue2, string, scheduleStateChangeDate, triggerInfo != null ? triggerInfo.getJsonValue() : null, data.getTriggerSessionId(), data.getAssociatedData());
        }
    }

    @Nullable
    public final AutomationScheduleData toScheduleData() {
        try {
            AutomationSchedule automationScheduleFromJson = AutomationSchedule.INSTANCE.fromJson(this.schedule);
            AutomationScheduleState automationScheduleStateFromString = AutomationScheduleState.INSTANCE.fromString(this.scheduleState);
            long j = this.scheduleStateChangeDate;
            int i = this.executionCount;
            JsonValue jsonValue = this.triggerInfo;
            TriggeringInfo triggeringInfoFromJson = jsonValue != null ? TriggeringInfo.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue2 = this.preparedScheduleInfo;
            PreparedScheduleInfo preparedScheduleInfoFromJson = jsonValue2 != null ? PreparedScheduleInfo.INSTANCE.fromJson(jsonValue2) : null;
            String string = this.triggerSessionId;
            if (string == null) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            }
            return new AutomationScheduleData(automationScheduleFromJson, automationScheduleStateFromString, j, i, triggeringInfoFromJson, preparedScheduleInfoFromJson, this.associatedData, string);
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.ScheduleEntity.toScheduleData.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to convert schedule entity to schedule data " + ScheduleEntity.this;
                }
            });
            return null;
        }
    }
}
