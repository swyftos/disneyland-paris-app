package com.urbanairship.automation;

import androidx.media3.exoplayer.offline.DownloadService;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.CompoundAutomationTriggerType;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.automation.engine.triggerprocessor.MatchResult;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.UAStringUtil;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J'\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0002#$¨\u0006%"}, d2 = {"Lcom/urbanairship/automation/AutomationTrigger;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "goal", "", "type", "(Ljava/lang/String;DLjava/lang/String;)V", "getGoal", "()D", "getId", "()Ljava/lang/String;", "getType", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "isTriggered", "data", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "isTriggered$urbanairship_automation_release", "matchEvent", "Lcom/urbanairship/automation/engine/triggerprocessor/MatchResult;", "event", "Lcom/urbanairship/automation/engine/AutomationEvent;", "resetOnTrigger", "matchEvent$urbanairship_automation_release", "removeStaleChildData", "", "removeStaleChildData$urbanairship_automation_release", "Companion", "Compound", "Event", "Lcom/urbanairship/automation/AutomationTrigger$Compound;", "Lcom/urbanairship/automation/AutomationTrigger$Event;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AutomationTrigger implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final double goal;
    private final String id;
    private final String type;

    public /* synthetic */ AutomationTrigger(String str, double d, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, str2);
    }

    private AutomationTrigger(String str, double d, String str2) {
        this.id = str;
        this.goal = d;
        this.type = str2;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final double getGoal() {
        return this.goal;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/urbanairship/automation/AutomationTrigger$Event;", "Lcom/urbanairship/automation/AutomationTrigger;", DeferredApiClient.KEY_TRIGGER_CONTEXT, "Lcom/urbanairship/automation/EventAutomationTrigger;", "(Lcom/urbanairship/automation/EventAutomationTrigger;)V", "getTrigger$urbanairship_automation_release", "()Lcom/urbanairship/automation/EventAutomationTrigger;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Event extends AutomationTrigger {
        private final EventAutomationTrigger trigger;

        @NotNull
        /* renamed from: getTrigger$urbanairship_automation_release, reason: from getter */
        public final EventAutomationTrigger getTrigger() {
            return this.trigger;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(@NotNull EventAutomationTrigger trigger) {
            super(trigger.getId(), trigger.getGoal(), trigger.getType().getValue(), null);
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            this.trigger = trigger;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.trigger.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/urbanairship/automation/AutomationTrigger$Compound;", "Lcom/urbanairship/automation/AutomationTrigger;", DeferredApiClient.KEY_TRIGGER_CONTEXT, "Lcom/urbanairship/automation/CompoundAutomationTrigger;", "(Lcom/urbanairship/automation/CompoundAutomationTrigger;)V", "getTrigger$urbanairship_automation_release", "()Lcom/urbanairship/automation/CompoundAutomationTrigger;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Compound extends AutomationTrigger {
        private final CompoundAutomationTrigger trigger;

        @NotNull
        /* renamed from: getTrigger$urbanairship_automation_release, reason: from getter */
        public final CompoundAutomationTrigger getTrigger() {
            return this.trigger;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Compound(@NotNull CompoundAutomationTrigger trigger) {
            super(trigger.getId(), trigger.getGoal(), trigger.getType().getValue(), null);
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            this.trigger = trigger;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.trigger.getJsonValue();
        }
    }

    @Nullable
    public final MatchResult matchEvent$urbanairship_automation_release(@NotNull AutomationEvent event, @NotNull TriggerData data, boolean resetOnTrigger) {
        MatchResult matchResultMatchEvent$urbanairship_automation_release;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        if (this instanceof Compound) {
            matchResultMatchEvent$urbanairship_automation_release = ((Compound) this).getTrigger().matchEvent$urbanairship_automation_release(event, data);
        } else {
            if (!(this instanceof Event)) {
                throw new NoWhenBranchMatchedException();
            }
            matchResultMatchEvent$urbanairship_automation_release = ((Event) this).getTrigger().matchEvent$urbanairship_automation_release(event, data);
        }
        if (resetOnTrigger && matchResultMatchEvent$urbanairship_automation_release != null && matchResultMatchEvent$urbanairship_automation_release.isTriggered()) {
            data.resetCounter$urbanairship_automation_release();
        }
        return matchResultMatchEvent$urbanairship_automation_release;
    }

    public final boolean isTriggered$urbanairship_automation_release(@NotNull TriggerData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getTriggerCount() >= this.goal;
    }

    public final void removeStaleChildData$urbanairship_automation_release(@NotNull TriggerData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this instanceof Compound) {
            ((Compound) this).getTrigger().removeStaleChildData$urbanairship_automation_release(data);
        } else {
            boolean z = this instanceof Event;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J1\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/AutomationTrigger$Companion;", "", "()V", "KEY_TYPE", "", "activeSession", "Lcom/urbanairship/automation/AutomationTrigger;", "count", "Lkotlin/UInt;", "activeSession-WZ4Q5Ns", "(I)Lcom/urbanairship/automation/AutomationTrigger;", DownloadService.KEY_FOREGROUND, "foreground-WZ4Q5Ns", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "generateStableId", "type", "goal", "", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "generateStableId$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationTrigger fromJson(@NotNull JsonValue value, @NotNull TriggerExecutionType executionType) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(executionType, "executionType");
            CompoundAutomationTriggerType.Companion companion = CompoundAutomationTriggerType.INSTANCE;
            JsonValue jsonValueRequire = value.requireMap().require("type");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            if (companion.fromJson(jsonValueRequire) != null) {
                return new Compound(CompoundAutomationTrigger.INSTANCE.fromJson(value, executionType));
            }
            return new Event(EventAutomationTrigger.INSTANCE.fromJson(value, executionType));
        }

        @NotNull
        /* renamed from: activeSession-WZ4Q5Ns, reason: not valid java name */
        public final AutomationTrigger m2779activeSessionWZ4Q5Ns(int count) {
            return new Event(new EventAutomationTrigger(EventAutomationTriggerType.ACTIVE_SESSION, UnsignedKt.uintToDouble(count), null, 4, null));
        }

        @NotNull
        /* renamed from: foreground-WZ4Q5Ns, reason: not valid java name */
        public final AutomationTrigger m2780foregroundWZ4Q5Ns(int count) {
            return new Event(new EventAutomationTrigger(EventAutomationTriggerType.FOREGROUND, UnsignedKt.uintToDouble(count), null, 4, null));
        }

        public static /* synthetic */ String generateStableId$urbanairship_automation_release$default(Companion companion, String str, double d, JsonPredicate jsonPredicate, TriggerExecutionType triggerExecutionType, int i, Object obj) {
            if ((i & 4) != 0) {
                jsonPredicate = null;
            }
            return companion.generateStableId$urbanairship_automation_release(str, d, jsonPredicate, triggerExecutionType);
        }

        @NotNull
        public final String generateStableId$urbanairship_automation_release(@NotNull String type, double goal, @Nullable JsonPredicate predicate, @NotNull TriggerExecutionType executionType) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(executionType, "executionType");
            List listMutableListOf = CollectionsKt.mutableListOf(type, String.valueOf(goal), executionType.getValue());
            if (predicate != null) {
                String string = predicate.getJsonValue().toString(Boolean.TRUE);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                listMutableListOf.add(string);
            }
            String strSha256 = UAStringUtil.sha256(CollectionsKt.joinToString$default(listMutableListOf, ":", null, null, 0, null, null, 62, null));
            if (strSha256 != null) {
                return strSha256;
            }
            throw new RuntimeException("failed to generate sha256 hash");
        }
    }

    public int hashCode() {
        return Objects.hash(this.id, Double.valueOf(this.goal), this.type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.AutomationTrigger");
        AutomationTrigger automationTrigger = (AutomationTrigger) other;
        return Intrinsics.areEqual(this.id, automationTrigger.id) && this.goal == automationTrigger.goal && Intrinsics.areEqual(this.type, automationTrigger.type);
    }
}
