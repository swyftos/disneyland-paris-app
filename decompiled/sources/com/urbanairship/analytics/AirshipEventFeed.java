package com.urbanairship.analytics;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.utils.UriBuilder;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.PrivacyManager;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/analytics/AirshipEventFeed;", "", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "isAnalyticsEnabled", "", "(Lcom/urbanairship/PrivacyManager;Z)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/analytics/AirshipEventFeed$Event;", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "emit", "", "event", "emit$urbanairship_core_release", "Event", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class AirshipEventFeed {
    private final MutableSharedFlow _events;
    private final SharedFlow events;
    private final boolean isAnalyticsEnabled;
    private final PrivacyManager privacyManager;

    public AirshipEventFeed(@NotNull PrivacyManager privacyManager, boolean z) {
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        this.privacyManager = privacyManager;
        this.isAnalyticsEnabled = z;
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST, 1, null);
        this._events = mutableSharedFlowMutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/analytics/AirshipEventFeed$Event;", "", "()V", "Analytics", "Screen", "Lcom/urbanairship/analytics/AirshipEventFeed$Event$Analytics;", "Lcom/urbanairship/analytics/AirshipEventFeed$Event$Screen;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/analytics/AirshipEventFeed$Event$Analytics;", "Lcom/urbanairship/analytics/AirshipEventFeed$Event;", "eventType", "Lcom/urbanairship/analytics/EventType;", "data", "Lcom/urbanairship/json/JsonValue;", "value", "", "(Lcom/urbanairship/analytics/EventType;Lcom/urbanairship/json/JsonValue;Ljava/lang/Double;)V", "getData", "()Lcom/urbanairship/json/JsonValue;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "getValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Lcom/urbanairship/analytics/EventType;Lcom/urbanairship/json/JsonValue;Ljava/lang/Double;)Lcom/urbanairship/analytics/AirshipEventFeed$Event$Analytics;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Analytics extends Event {
            private final JsonValue data;
            private final EventType eventType;
            private final Double value;

            public static /* synthetic */ Analytics copy$default(Analytics analytics, EventType eventType, JsonValue jsonValue, Double d, int i, Object obj) {
                if ((i & 1) != 0) {
                    eventType = analytics.eventType;
                }
                if ((i & 2) != 0) {
                    jsonValue = analytics.data;
                }
                if ((i & 4) != 0) {
                    d = analytics.value;
                }
                return analytics.copy(eventType, jsonValue, d);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final EventType getEventType() {
                return this.eventType;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final JsonValue getData() {
                return this.data;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final Double getValue() {
                return this.value;
            }

            @NotNull
            public final Analytics copy(@NotNull EventType eventType, @NotNull JsonValue data, @Nullable Double value) {
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                Intrinsics.checkNotNullParameter(data, "data");
                return new Analytics(eventType, data, value);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Analytics)) {
                    return false;
                }
                Analytics analytics = (Analytics) other;
                return this.eventType == analytics.eventType && Intrinsics.areEqual(this.data, analytics.data) && Intrinsics.areEqual((Object) this.value, (Object) analytics.value);
            }

            public int hashCode() {
                int iHashCode = ((this.eventType.hashCode() * 31) + this.data.hashCode()) * 31;
                Double d = this.value;
                return iHashCode + (d == null ? 0 : d.hashCode());
            }

            @NotNull
            public String toString() {
                return "Analytics(eventType=" + this.eventType + ", data=" + this.data + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Analytics(EventType eventType, JsonValue jsonValue, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(eventType, jsonValue, (i & 4) != 0 ? null : d);
            }

            @NotNull
            public final EventType getEventType() {
                return this.eventType;
            }

            @NotNull
            public final JsonValue getData() {
                return this.data;
            }

            @Nullable
            public final Double getValue() {
                return this.value;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Analytics(@NotNull EventType eventType, @NotNull JsonValue data, @Nullable Double d) {
                super(null);
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                Intrinsics.checkNotNullParameter(data, "data");
                this.eventType = eventType;
                this.data = data;
                this.value = d;
            }
        }

        private Event() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/analytics/AirshipEventFeed$Event$Screen;", "Lcom/urbanairship/analytics/AirshipEventFeed$Event;", TCEventPropertiesNames.TCD_SCREEN, "", "(Ljava/lang/String;)V", "getScreen", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Screen extends Event {
            private final String screen;

            public static /* synthetic */ Screen copy$default(Screen screen, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = screen.screen;
                }
                return screen.copy(str);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getScreen() {
                return this.screen;
            }

            @NotNull
            public final Screen copy(@NotNull String screen) {
                Intrinsics.checkNotNullParameter(screen, "screen");
                return new Screen(screen);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Screen) && Intrinsics.areEqual(this.screen, ((Screen) other).screen);
            }

            public int hashCode() {
                return this.screen.hashCode();
            }

            @NotNull
            public String toString() {
                return "Screen(screen=" + this.screen + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final String getScreen() {
                return this.screen;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Screen(@NotNull String screen) {
                super(null);
                Intrinsics.checkNotNullParameter(screen, "screen");
                this.screen = screen;
            }
        }
    }

    @NotNull
    public final SharedFlow<Event> getEvents() {
        return this.events;
    }

    public final void emit$urbanairship_core_release(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isAnalyticsEnabled && this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS)) {
            this._events.tryEmit(event);
        }
    }
}
