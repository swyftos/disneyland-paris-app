package com.urbanairship.analytics;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.OneIDRecoveryContext;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/analytics/AirshipEventData;", "", "id", "", OneIDRecoveryContext.SESSION_ID, RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonValue;", "type", "Lcom/urbanairship/analytics/EventType;", "timeMs", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/analytics/EventType;J)V", "getBody", "()Lcom/urbanairship/json/JsonValue;", "setBody", "(Lcom/urbanairship/json/JsonValue;)V", "fullEventPayload", "getFullEventPayload", "getId", "()Ljava/lang/String;", "getSessionId", "getTimeMs", "()J", "getType", "()Lcom/urbanairship/analytics/EventType;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AirshipEventData {
    private JsonValue body;
    private final JsonValue fullEventPayload;
    private final String id;
    private final String sessionId;
    private final long timeMs;
    private final EventType type;

    public AirshipEventData(@NotNull String id, @NotNull String sessionId, @NotNull JsonValue body, @NotNull EventType type, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.sessionId = sessionId;
        this.body = body;
        this.type = type;
        this.timeMs = j;
        Pair pair = TuplesKt.to("type", type.getReportingName());
        Pair pair2 = TuplesKt.to(TCEventPropertiesNames.TCE_EVENTID, id);
        Pair pair3 = TuplesKt.to("time", Event.millisecondsToSecondsString(j));
        JsonMap jsonMapOptMap = this.body.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, TuplesKt.to("data", JsonExtensionsKt.extend(jsonMapOptMap, TuplesKt.to(TCEventPropertiesNames.TCL_SESSION_ID, sessionId)))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        this.fullEventPayload = jsonValue;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final JsonValue getBody() {
        return this.body;
    }

    public final void setBody(@NotNull JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(jsonValue, "<set-?>");
        this.body = jsonValue;
    }

    @NotNull
    public final EventType getType() {
        return this.type;
    }

    public final long getTimeMs() {
        return this.timeMs;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AirshipEventData.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.analytics.AirshipEventData");
        AirshipEventData airshipEventData = (AirshipEventData) other;
        return Intrinsics.areEqual(this.id, airshipEventData.id) && Intrinsics.areEqual(this.body, airshipEventData.body) && this.type == airshipEventData.type && this.timeMs == airshipEventData.timeMs;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.body.hashCode()) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.timeMs);
    }

    @NotNull
    public String toString() {
        return "AirshipEventData(id='" + this.id + "', sessionId='" + this.sessionId + "', body=" + this.body + ", type=" + this.type + ", timeMs=" + this.timeMs + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final JsonValue getFullEventPayload() {
        return this.fullEventPayload;
    }
}
