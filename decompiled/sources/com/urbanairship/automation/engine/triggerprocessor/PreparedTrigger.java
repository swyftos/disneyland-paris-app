package com.urbanairship.automation.engine.triggerprocessor;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.automation.engine.TriggeringInfo;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.deferred.DeferredTriggerContext;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u00014BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020%H\u0000¢\u0006\u0002\b(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u000200H\u0000¢\u0006\u0002\b1J4\u00102\u001a\u00020%2\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0002\b3R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR(\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/PreparedTrigger;", "", "scheduleId", "", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "triggerData", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", DeferredApiClient.KEY_TRIGGER_CONTEXT, "Lcom/urbanairship/automation/AutomationTrigger;", "isActive", "", "startDate", "Lkotlin/ULong;", "endDate", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "clock", "Lcom/urbanairship/util/Clock;", "(Ljava/lang/String;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;Lcom/urbanairship/automation/AutomationTrigger;ZLkotlin/ULong;Lkotlin/ULong;ILcom/urbanairship/util/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getEndDate-6VbMDqA$urbanairship_automation_release", "()Lkotlin/ULong;", "getExecutionType$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "isActive$urbanairship_automation_release", "()Z", "getPriority$urbanairship_automation_release", "()I", "getScheduleId$urbanairship_automation_release", "()Ljava/lang/String;", "getStartDate-6VbMDqA$urbanairship_automation_release", "getTrigger$urbanairship_automation_release", "()Lcom/urbanairship/automation/AutomationTrigger;", "getTriggerData$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "activate", "", "activate$urbanairship_automation_release", "disable", "disable$urbanairship_automation_release", "generateTriggerResult", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", "event", "Lcom/urbanairship/json/JsonValue;", "isWithinDateRange", "process", "Lcom/urbanairship/automation/engine/triggerprocessor/PreparedTrigger$EventProcessResult;", "Lcom/urbanairship/automation/engine/AutomationEvent;", "process$urbanairship_automation_release", "update", "update-s3EXWrA$urbanairship_automation_release", "EventProcessResult", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreparedTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreparedTrigger.kt\ncom/urbanairship/automation/engine/triggerprocessor/PreparedTrigger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
/* loaded from: classes5.dex */
public final class PreparedTrigger {
    private final Clock clock;
    private ULong endDate;
    private final TriggerExecutionType executionType;
    private boolean isActive;
    private int priority;
    private final String scheduleId;
    private ULong startDate;
    private AutomationTrigger trigger;
    private TriggerData triggerData;

    public /* synthetic */ PreparedTrigger(String str, TriggerExecutionType triggerExecutionType, TriggerData triggerData, AutomationTrigger automationTrigger, boolean z, ULong uLong, ULong uLong2, int i, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, triggerExecutionType, triggerData, automationTrigger, z, uLong, uLong2, i, clock);
    }

    private PreparedTrigger(String scheduleId, TriggerExecutionType executionType, TriggerData triggerData, AutomationTrigger trigger, boolean z, ULong uLong, ULong uLong2, int i, Clock clock) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(executionType, "executionType");
        Intrinsics.checkNotNullParameter(triggerData, "triggerData");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.scheduleId = scheduleId;
        this.executionType = executionType;
        this.clock = clock;
        this.triggerData = triggerData;
        this.trigger = trigger;
        this.isActive = z;
        this.startDate = uLong;
        this.endDate = uLong2;
        this.priority = i;
        trigger.removeStaleChildData$urbanairship_automation_release(triggerData);
    }

    @NotNull
    /* renamed from: getScheduleId$urbanairship_automation_release, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    /* renamed from: getExecutionType$urbanairship_automation_release, reason: from getter */
    public final TriggerExecutionType getExecutionType() {
        return this.executionType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PreparedTrigger(String str, TriggerExecutionType triggerExecutionType, TriggerData triggerData, AutomationTrigger automationTrigger, boolean z, ULong uLong, ULong uLong2, int i, Clock clock, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        boolean z2 = (i2 & 16) != 0 ? false : z;
        if ((i2 & 256) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(str, triggerExecutionType, triggerData, automationTrigger, z2, uLong, uLong2, i, clock2, null);
    }

    @NotNull
    /* renamed from: getTriggerData$urbanairship_automation_release, reason: from getter */
    public final TriggerData getTriggerData() {
        return this.triggerData;
    }

    @NotNull
    /* renamed from: getTrigger$urbanairship_automation_release, reason: from getter */
    public final AutomationTrigger getTrigger() {
        return this.trigger;
    }

    /* renamed from: isActive$urbanairship_automation_release, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    @Nullable
    /* renamed from: getStartDate-6VbMDqA$urbanairship_automation_release, reason: not valid java name and from getter */
    public final ULong getStartDate() {
        return this.startDate;
    }

    @Nullable
    /* renamed from: getEndDate-6VbMDqA$urbanairship_automation_release, reason: not valid java name and from getter */
    public final ULong getEndDate() {
        return this.endDate;
    }

    /* renamed from: getPriority$urbanairship_automation_release, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/PreparedTrigger$EventProcessResult;", "", "triggerData", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggerResult", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "(Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;I)V", "getPriority", "()I", "getTriggerData", "()Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "getTriggerResult", "()Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EventProcessResult {
        private final int priority;
        private final TriggerData triggerData;
        private final TriggerResult triggerResult;

        public static /* synthetic */ EventProcessResult copy$default(EventProcessResult eventProcessResult, TriggerData triggerData, TriggerResult triggerResult, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                triggerData = eventProcessResult.triggerData;
            }
            if ((i2 & 2) != 0) {
                triggerResult = eventProcessResult.triggerResult;
            }
            if ((i2 & 4) != 0) {
                i = eventProcessResult.priority;
            }
            return eventProcessResult.copy(triggerData, triggerResult, i);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final TriggerData getTriggerData() {
            return this.triggerData;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final TriggerResult getTriggerResult() {
            return this.triggerResult;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        @NotNull
        public final EventProcessResult copy(@NotNull TriggerData triggerData, @Nullable TriggerResult triggerResult, int priority) {
            Intrinsics.checkNotNullParameter(triggerData, "triggerData");
            return new EventProcessResult(triggerData, triggerResult, priority);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EventProcessResult)) {
                return false;
            }
            EventProcessResult eventProcessResult = (EventProcessResult) other;
            return Intrinsics.areEqual(this.triggerData, eventProcessResult.triggerData) && Intrinsics.areEqual(this.triggerResult, eventProcessResult.triggerResult) && this.priority == eventProcessResult.priority;
        }

        public int hashCode() {
            int iHashCode = this.triggerData.hashCode() * 31;
            TriggerResult triggerResult = this.triggerResult;
            return ((iHashCode + (triggerResult == null ? 0 : triggerResult.hashCode())) * 31) + Integer.hashCode(this.priority);
        }

        @NotNull
        public String toString() {
            return "EventProcessResult(triggerData=" + this.triggerData + ", triggerResult=" + this.triggerResult + ", priority=" + this.priority + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public EventProcessResult(@NotNull TriggerData triggerData, @Nullable TriggerResult triggerResult, int i) {
            Intrinsics.checkNotNullParameter(triggerData, "triggerData");
            this.triggerData = triggerData;
            this.triggerResult = triggerResult;
            this.priority = i;
        }

        @NotNull
        public final TriggerData getTriggerData() {
            return this.triggerData;
        }

        @Nullable
        public final TriggerResult getTriggerResult() {
            return this.triggerResult;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    @Nullable
    public final EventProcessResult process$urbanairship_automation_release(@NotNull AutomationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TriggerResult triggerResultGenerateTriggerResult = null;
        if (!this.isActive || !isWithinDateRange()) {
            return null;
        }
        TriggerData triggerDataCopy$urbanairship_automation_release = this.triggerData.copy$urbanairship_automation_release();
        MatchResult matchResultMatchEvent$urbanairship_automation_release = this.trigger.matchEvent$urbanairship_automation_release(event, triggerDataCopy$urbanairship_automation_release, true);
        if (Intrinsics.areEqual(triggerDataCopy$urbanairship_automation_release, this.triggerData) && (matchResultMatchEvent$urbanairship_automation_release == null || !matchResultMatchEvent$urbanairship_automation_release.isTriggered())) {
            return null;
        }
        this.triggerData = triggerDataCopy$urbanairship_automation_release;
        if (matchResultMatchEvent$urbanairship_automation_release != null && matchResultMatchEvent$urbanairship_automation_release.isTriggered()) {
            JsonValue NULL = event.getEventData$urbanairship_automation_release();
            if (NULL == null) {
                NULL = JsonValue.NULL;
                Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
            }
            triggerResultGenerateTriggerResult = generateTriggerResult(NULL);
        }
        return new EventProcessResult(triggerDataCopy$urbanairship_automation_release, triggerResultGenerateTriggerResult, this.priority);
    }

    /* renamed from: update-s3EXWrA$urbanairship_automation_release, reason: not valid java name */
    public final void m2809updates3EXWrA$urbanairship_automation_release(@NotNull AutomationTrigger trigger, @Nullable ULong startDate, @Nullable ULong endDate, int priority) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        trigger.removeStaleChildData$urbanairship_automation_release(this.triggerData);
    }

    public final void activate$urbanairship_automation_release() {
        if (this.isActive) {
            return;
        }
        this.isActive = true;
        if (this.executionType == TriggerExecutionType.DELAY_CANCELLATION) {
            this.triggerData.resetCounter$urbanairship_automation_release();
        }
    }

    public final void disable$urbanairship_automation_release() {
        this.isActive = false;
    }

    private final TriggerResult generateTriggerResult(JsonValue event) {
        return new TriggerResult(this.scheduleId, this.executionType, new TriggeringInfo(new DeferredTriggerContext(this.trigger.getType(), this.trigger.getGoal(), event), this.clock.currentTimeMillis()));
    }

    private final boolean isWithinDateRange() {
        long jM3028constructorimpl = ULong.m3028constructorimpl(this.clock.currentTimeMillis());
        ULong uLong = this.startDate;
        if (uLong != null && Long.compareUnsigned(uLong.getData(), jM3028constructorimpl) > 0) {
            return false;
        }
        ULong uLong2 = this.endDate;
        return uLong2 == null || Long.compareUnsigned(uLong2.getData(), jM3028constructorimpl) >= 0;
    }
}
