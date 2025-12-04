package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.EventAutomationTriggerType;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEvent;", "", "()V", "eventData", "Lcom/urbanairship/json/JsonValue;", "getEventData$urbanairship_automation_release", "()Lcom/urbanairship/json/JsonValue;", "isStateEvent", "", "isStateEvent$urbanairship_automation_release", "()Z", "Event", "StateChanged", "Lcom/urbanairship/automation/engine/AutomationEvent$Event;", "Lcom/urbanairship/automation/engine/AutomationEvent$StateChanged;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class AutomationEvent {
    public /* synthetic */ AutomationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AutomationEvent() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEvent$Event;", "Lcom/urbanairship/automation/engine/AutomationEvent;", "triggerType", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "data", "Lcom/urbanairship/json/JsonValue;", "value", "", "(Lcom/urbanairship/automation/EventAutomationTriggerType;Lcom/urbanairship/json/JsonValue;D)V", "getData", "()Lcom/urbanairship/json/JsonValue;", "getTriggerType", "()Lcom/urbanairship/automation/EventAutomationTriggerType;", "getValue", "()D", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Event extends AutomationEvent {
        private final JsonValue data;
        private final EventAutomationTriggerType triggerType;
        private final double value;

        public static /* synthetic */ Event copy$default(Event event, EventAutomationTriggerType eventAutomationTriggerType, JsonValue jsonValue, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                eventAutomationTriggerType = event.triggerType;
            }
            if ((i & 2) != 0) {
                jsonValue = event.data;
            }
            if ((i & 4) != 0) {
                d = event.value;
            }
            return event.copy(eventAutomationTriggerType, jsonValue, d);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final EventAutomationTriggerType getTriggerType() {
            return this.triggerType;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getData() {
            return this.data;
        }

        /* renamed from: component3, reason: from getter */
        public final double getValue() {
            return this.value;
        }

        @NotNull
        public final Event copy(@NotNull EventAutomationTriggerType triggerType, @Nullable JsonValue data, double value) {
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return new Event(triggerType, data, value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return this.triggerType == event.triggerType && Intrinsics.areEqual(this.data, event.data) && Double.compare(this.value, event.value) == 0;
        }

        public int hashCode() {
            int iHashCode = this.triggerType.hashCode() * 31;
            JsonValue jsonValue = this.data;
            return ((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + Double.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "Event(triggerType=" + this.triggerType + ", data=" + this.data + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Event(EventAutomationTriggerType eventAutomationTriggerType, JsonValue jsonValue, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(eventAutomationTriggerType, (i & 2) != 0 ? null : jsonValue, (i & 4) != 0 ? 1.0d : d);
        }

        @NotNull
        public final EventAutomationTriggerType getTriggerType() {
            return this.triggerType;
        }

        @Nullable
        public final JsonValue getData() {
            return this.data;
        }

        public final double getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(@NotNull EventAutomationTriggerType triggerType, @Nullable JsonValue jsonValue, double d) {
            super(null);
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            this.triggerType = triggerType;
            this.data = jsonValue;
            this.value = d;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEvent$StateChanged;", "Lcom/urbanairship/automation/engine/AutomationEvent;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/automation/engine/TriggerableState;", "(Lcom/urbanairship/automation/engine/TriggerableState;)V", "getState", "()Lcom/urbanairship/automation/engine/TriggerableState;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StateChanged extends AutomationEvent {
        private final TriggerableState state;

        public static /* synthetic */ StateChanged copy$default(StateChanged stateChanged, TriggerableState triggerableState, int i, Object obj) {
            if ((i & 1) != 0) {
                triggerableState = stateChanged.state;
            }
            return stateChanged.copy(triggerableState);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final TriggerableState getState() {
            return this.state;
        }

        @NotNull
        public final StateChanged copy(@NotNull TriggerableState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new StateChanged(state);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StateChanged) && Intrinsics.areEqual(this.state, ((StateChanged) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        @NotNull
        public String toString() {
            return "StateChanged(state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final TriggerableState getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateChanged(@NotNull TriggerableState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    public final boolean isStateEvent$urbanairship_automation_release() {
        return this instanceof StateChanged;
    }

    @Nullable
    public final JsonValue getEventData$urbanairship_automation_release() {
        if (this instanceof StateChanged) {
            return null;
        }
        if (this instanceof Event) {
            return ((Event) this).getData();
        }
        throw new NoWhenBranchMatchedException();
    }
}
