package com.urbanairship.automation.engine;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.dlp.BluetoothManager;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001:\u0001dBQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00072\u0006\u0010/\u001a\u00020'H\u0000¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\tH\u0016J\u0015\u0010:\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?J\u001b\u0010@\u001a\u00020'2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0000¢\u0006\u0002\bCJ\r\u0010D\u001a\u00020'H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\bGJ\u001d\u0010H\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00072\u0006\u0010I\u001a\u00020'H\u0000¢\u0006\u0002\bJJ\u0015\u0010K\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\bLJ\u001d\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\tH\u0001¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020\rH\u0001¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0018\u0010Y\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0015\u0010Z\u001a\u00020Q2\u0006\u0010N\u001a\u00020\u000bH\u0001¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b]J\b\u0010^\u001a\u00020\u0011H\u0016J\u001d\u0010_\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u0007H\u0000¢\u0006\u0002\bcR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006e"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationScheduleData;", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "scheduleState", "Lcom/urbanairship/automation/engine/AutomationScheduleState;", "scheduleStateChangeDate", "", "executionCount", "", "triggerInfo", "Lcom/urbanairship/automation/engine/TriggeringInfo;", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "associatedData", "Lcom/urbanairship/json/JsonValue;", "triggerSessionId", "", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/AutomationScheduleState;JILcom/urbanairship/automation/engine/TriggeringInfo;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;)V", "getAssociatedData", "()Lcom/urbanairship/json/JsonValue;", "setAssociatedData", "(Lcom/urbanairship/json/JsonValue;)V", "<set-?>", "getExecutionCount", "()I", "getPreparedScheduleInfo", "()Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "getSchedule", "()Lcom/urbanairship/automation/AutomationSchedule;", "getScheduleState", "()Lcom/urbanairship/automation/engine/AutomationScheduleState;", "getScheduleStateChangeDate", "()J", "getTriggerInfo", "()Lcom/urbanairship/automation/engine/TriggeringInfo;", "getTriggerSessionId", "()Ljava/lang/String;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "executing", "date", "executing$urbanairship_automation_release", "executionCancelled", "executionCancelled$urbanairship_automation_release", "executionInterrupted", "retry", "executionInterrupted$urbanairship_automation_release", "executionInvalidated", "executionInvalidated$urbanairship_automation_release", "executionSkipped", "executionSkipped$urbanairship_automation_release", "finished", "finished$urbanairship_automation_release", "finishedExecuting", "finishedExecuting$urbanairship_automation_release", "hashCode", "idle", "idle$urbanairship_automation_release", "isActive", "isActive$urbanairship_automation_release", "isExpired", "isExpired$urbanairship_automation_release", "isInState", BluetoothManager.BLE_STATUS_PARAM, "", "isInState$urbanairship_automation_release", "isOverLimit", "isOverLimit$urbanairship_automation_release", "paused", "paused$urbanairship_automation_release", "prepareCancelled", "penalize", "prepareCancelled$urbanairship_automation_release", "prepareInterrupted", "prepareInterrupted$urbanairship_automation_release", "prepared", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "prepared$urbanairship_automation_release", "setExecutionCount", "", "count", "setExecutionCount$urbanairship_automation_release", "setPreparedScheduleInfo", "data", "setPreparedScheduleInfo$urbanairship_automation_release", "setSchedule", "setSchedule$urbanairship_automation_release", "setState", "setTriggeringInfo", "setTriggeringInfo$urbanairship_automation_release", "shouldDelete", "shouldDelete$urbanairship_automation_release", "toString", "triggered", "triggered$urbanairship_automation_release", "updateState", "timeStamp", "updateState$urbanairship_automation_release", "Comparator", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationScheduleData {
    private JsonValue associatedData;
    private int executionCount;
    private PreparedScheduleInfo preparedScheduleInfo;
    private AutomationSchedule schedule;
    private AutomationScheduleState scheduleState;
    private long scheduleStateChangeDate;
    private TriggeringInfo triggerInfo;
    private String triggerSessionId;

    public AutomationScheduleData(@NotNull AutomationSchedule schedule, @NotNull AutomationScheduleState scheduleState, long j, int i, @Nullable TriggeringInfo triggeringInfo, @Nullable PreparedScheduleInfo preparedScheduleInfo, @Nullable JsonValue jsonValue, @NotNull String triggerSessionId) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Intrinsics.checkNotNullParameter(scheduleState, "scheduleState");
        Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
        this.associatedData = jsonValue;
        this.schedule = schedule;
        this.scheduleState = scheduleState;
        this.scheduleStateChangeDate = j;
        this.executionCount = i;
        this.triggerInfo = triggeringInfo;
        this.preparedScheduleInfo = preparedScheduleInfo;
        this.triggerSessionId = triggerSessionId;
    }

    public /* synthetic */ AutomationScheduleData(AutomationSchedule automationSchedule, AutomationScheduleState automationScheduleState, long j, int i, TriggeringInfo triggeringInfo, PreparedScheduleInfo preparedScheduleInfo, JsonValue jsonValue, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(automationSchedule, automationScheduleState, j, i, (i2 & 16) != 0 ? null : triggeringInfo, (i2 & 32) != 0 ? null : preparedScheduleInfo, (i2 & 64) != 0 ? null : jsonValue, str);
    }

    @Nullable
    public final JsonValue getAssociatedData() {
        return this.associatedData;
    }

    public final void setAssociatedData(@Nullable JsonValue jsonValue) {
        this.associatedData = jsonValue;
    }

    @NotNull
    public final AutomationSchedule getSchedule() {
        return this.schedule;
    }

    @NotNull
    public final AutomationScheduleState getScheduleState() {
        return this.scheduleState;
    }

    public final long getScheduleStateChangeDate() {
        return this.scheduleStateChangeDate;
    }

    public final int getExecutionCount() {
        return this.executionCount;
    }

    @Nullable
    public final TriggeringInfo getTriggerInfo() {
        return this.triggerInfo;
    }

    @Nullable
    public final PreparedScheduleInfo getPreparedScheduleInfo() {
        return this.preparedScheduleInfo;
    }

    @NotNull
    public final String getTriggerSessionId() {
        return this.triggerSessionId;
    }

    @NotNull
    public final AutomationScheduleData setSchedule$urbanairship_automation_release(@NotNull AutomationSchedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        this.schedule = schedule;
        return this;
    }

    private final AutomationScheduleData setState(AutomationScheduleState state, long date) {
        if (this.scheduleState == state) {
            return this;
        }
        this.scheduleState = state;
        this.scheduleStateChangeDate = date;
        return this;
    }

    @NotNull
    public final AutomationScheduleData finished$urbanairship_automation_release(long date) {
        setState(AutomationScheduleState.FINISHED, date);
        this.preparedScheduleInfo = null;
        this.triggerInfo = null;
        return this;
    }

    @NotNull
    public final AutomationScheduleData idle$urbanairship_automation_release(long date) {
        setState(AutomationScheduleState.IDLE, date);
        this.preparedScheduleInfo = null;
        this.triggerInfo = null;
        return this;
    }

    @NotNull
    public final AutomationScheduleData paused$urbanairship_automation_release(long date) {
        setState(AutomationScheduleState.PAUSED, date);
        this.preparedScheduleInfo = null;
        this.triggerInfo = null;
        return this;
    }

    @NotNull
    public final AutomationScheduleData triggered$urbanairship_automation_release(@NotNull TriggeringInfo triggerInfo, long date) {
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        if (this.scheduleState != AutomationScheduleState.IDLE) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        this.preparedScheduleInfo = null;
        this.triggerInfo = triggerInfo;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.triggerSessionId = string;
        return setState(AutomationScheduleState.TRIGGERED, date);
    }

    @NotNull
    public final AutomationScheduleData prepared$urbanairship_automation_release(@NotNull PreparedScheduleInfo info, long date) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.TRIGGERED))) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        this.preparedScheduleInfo = info;
        return setState(AutomationScheduleState.PREPARED, date);
    }

    @NotNull
    public final AutomationScheduleData executing$urbanairship_automation_release(long date) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.PREPARED))) {
            return this;
        }
        this.scheduleState = AutomationScheduleState.EXECUTING;
        this.scheduleStateChangeDate = date;
        return this;
    }

    @NotNull
    public final AutomationScheduleData executionInterrupted$urbanairship_automation_release(long date, boolean retry) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.EXECUTING))) {
            return this;
        }
        if (!retry) {
            return finishedExecuting$urbanairship_automation_release(date);
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        this.preparedScheduleInfo = null;
        return setState(AutomationScheduleState.TRIGGERED, date);
    }

    @NotNull
    public final AutomationScheduleData executionCancelled$urbanairship_automation_release(long date) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.PREPARED))) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        return idle$urbanairship_automation_release(date);
    }

    @NotNull
    public final AutomationScheduleData executionInvalidated$urbanairship_automation_release(long date) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.PREPARED))) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        this.preparedScheduleInfo = null;
        return setState(AutomationScheduleState.TRIGGERED, date);
    }

    @NotNull
    public final AutomationScheduleData executionSkipped$urbanairship_automation_release(long date) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.PREPARED))) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        if (this.schedule.getInterval() != null) {
            return paused$urbanairship_automation_release(date);
        }
        return idle$urbanairship_automation_release(date);
    }

    @NotNull
    public final AutomationScheduleData prepareCancelled$urbanairship_automation_release(long date, boolean penalize) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.TRIGGERED))) {
            return this;
        }
        if (penalize) {
            this.executionCount++;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        return idle$urbanairship_automation_release(date);
    }

    @NotNull
    public final AutomationScheduleData prepareInterrupted$urbanairship_automation_release(long date) {
        AutomationScheduleState automationScheduleState = AutomationScheduleState.PREPARED;
        AutomationScheduleState automationScheduleState2 = AutomationScheduleState.TRIGGERED;
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf((Object[]) new AutomationScheduleState[]{automationScheduleState, automationScheduleState2}))) {
            return this;
        }
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            return finished$urbanairship_automation_release(date);
        }
        return setState(automationScheduleState2, date);
    }

    @NotNull
    public final AutomationScheduleData finishedExecuting$urbanairship_automation_release(long date) {
        if (!isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.EXECUTING))) {
            return this;
        }
        this.executionCount++;
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(date)) {
            finished$urbanairship_automation_release(date);
            return this;
        }
        if (this.schedule.getInterval() == null) {
            return idle$urbanairship_automation_release(date);
        }
        return paused$urbanairship_automation_release(date);
    }

    @NotNull
    public final AutomationScheduleData updateState$urbanairship_automation_release(long timeStamp) {
        if (isOverLimit$urbanairship_automation_release() || isExpired$urbanairship_automation_release(timeStamp)) {
            return finished$urbanairship_automation_release(timeStamp);
        }
        return isInState$urbanairship_automation_release(CollectionsKt.listOf(AutomationScheduleState.FINISHED)) ? idle$urbanairship_automation_release(timeStamp) : this;
    }

    public final boolean shouldDelete$urbanairship_automation_release(long date) {
        if (this.scheduleState != AutomationScheduleState.FINISHED) {
            return false;
        }
        ULong uLongM2774getEditGracePeriodDays6VbMDqA = this.schedule.getEditGracePeriodDays();
        if (uLongM2774getEditGracePeriodDays6VbMDqA != null) {
            return date - this.scheduleStateChangeDate >= TimeUnit.DAYS.toMillis(uLongM2774getEditGracePeriodDays6VbMDqA.getData());
        }
        return true;
    }

    public final boolean isExpired$urbanairship_automation_release(long date) {
        ULong uLongM2775getEndDate6VbMDqA = this.schedule.getEndDate();
        return uLongM2775getEndDate6VbMDqA != null && Long.compareUnsigned(uLongM2775getEndDate6VbMDqA.getData(), ULong.m3028constructorimpl(date)) <= 0;
    }

    public final boolean isActive$urbanairship_automation_release(long date) {
        if (isExpired$urbanairship_automation_release(date)) {
            return false;
        }
        ULong uLongM2778getStartDate6VbMDqA = this.schedule.getStartDate();
        return uLongM2778getStartDate6VbMDqA == null || date >= uLongM2778getStartDate6VbMDqA.getData();
    }

    public final boolean isOverLimit$urbanairship_automation_release() {
        UInt uIntM2777getLimit0hXNFcg = this.schedule.getLimit();
        int data = uIntM2777getLimit0hXNFcg != null ? uIntM2777getLimit0hXNFcg.getData() : 1;
        return data != 0 && Integer.compareUnsigned(data, UInt.m3003constructorimpl(this.executionCount)) <= 0;
    }

    public final boolean isInState$urbanairship_automation_release(@NotNull List<? extends AutomationScheduleState> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state.contains(this.scheduleState);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationScheduleData$Comparator;", "Ljava/util/Comparator;", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "date", "", "(J)V", "getDate", "()J", "compare", "", ViewProps.LEFT, ViewProps.RIGHT, "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Comparator implements java.util.Comparator<AutomationScheduleData> {
        private final long date;

        public Comparator(long j) {
            this.date = j;
        }

        public final long getDate() {
            return this.date;
        }

        @Override // java.util.Comparator
        public int compare(@NotNull AutomationScheduleData left, @NotNull AutomationScheduleData right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            Integer priority = left.getSchedule().getPriority();
            int iIntValue = priority != null ? priority.intValue() : 0;
            Integer priority2 = right.getSchedule().getPriority();
            int iIntValue2 = priority2 != null ? priority2.intValue() : 0;
            if (iIntValue != iIntValue2) {
                return Intrinsics.compare(iIntValue, iIntValue2);
            }
            TriggeringInfo triggerInfo = left.getTriggerInfo();
            long date = triggerInfo != null ? triggerInfo.getDate() : this.date;
            TriggeringInfo triggerInfo2 = right.getTriggerInfo();
            return Intrinsics.compare(date, triggerInfo2 != null ? triggerInfo2.getDate() : this.date);
        }
    }

    @VisibleForTesting
    public final void setExecutionCount$urbanairship_automation_release(int count) {
        this.executionCount = count;
    }

    @VisibleForTesting
    public final void setTriggeringInfo$urbanairship_automation_release(@NotNull TriggeringInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.triggerInfo = info;
    }

    @VisibleForTesting
    public final void setPreparedScheduleInfo$urbanairship_automation_release(@NotNull PreparedScheduleInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.preparedScheduleInfo = data;
    }

    public int hashCode() {
        return Objects.hash(this.schedule, this.scheduleState, Long.valueOf(this.scheduleStateChangeDate), Integer.valueOf(this.executionCount), this.triggerInfo, this.preparedScheduleInfo);
    }

    @NotNull
    public String toString() {
        return "AutomationScheduleData(scheduleId=" + this.schedule.getIdentifier() + ", scheduleState=" + this.scheduleState + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AutomationScheduleData.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.engine.AutomationScheduleData");
        AutomationScheduleData automationScheduleData = (AutomationScheduleData) other;
        return Intrinsics.areEqual(this.schedule, automationScheduleData.schedule) && this.scheduleState == automationScheduleData.scheduleState && this.scheduleStateChangeDate == automationScheduleData.scheduleStateChangeDate && this.executionCount == automationScheduleData.executionCount && Intrinsics.areEqual(this.triggerInfo, automationScheduleData.triggerInfo) && Intrinsics.areEqual(this.preparedScheduleInfo, automationScheduleData.preparedScheduleInfo);
    }
}
