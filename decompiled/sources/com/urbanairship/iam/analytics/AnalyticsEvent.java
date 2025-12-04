package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.analytics.ConversionData;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.analytics.Event;
import com.urbanairship.analytics.EventType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class AnalyticsEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final JsonSerializable baseData;
    private final InAppEventContext context;
    private final EventType eventType;
    private final InAppEventMessageId identifier;
    private final JsonValue renderedLocale;
    private final InAppEventSource source;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsEvent)) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        return this.eventType == analyticsEvent.eventType && Intrinsics.areEqual(this.identifier, analyticsEvent.identifier) && this.source == analyticsEvent.source && Intrinsics.areEqual(this.context, analyticsEvent.context) && Intrinsics.areEqual(this.renderedLocale, analyticsEvent.renderedLocale) && Intrinsics.areEqual(this.baseData, analyticsEvent.baseData);
    }

    public int hashCode() {
        int iHashCode = ((((this.eventType.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.source.hashCode()) * 31;
        InAppEventContext inAppEventContext = this.context;
        int iHashCode2 = (iHashCode + (inAppEventContext == null ? 0 : inAppEventContext.hashCode())) * 31;
        JsonValue jsonValue = this.renderedLocale;
        int iHashCode3 = (iHashCode2 + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        JsonSerializable jsonSerializable = this.baseData;
        return iHashCode3 + (jsonSerializable != null ? jsonSerializable.hashCode() : 0);
    }

    public String toString() {
        return "AnalyticsEvent(eventType=" + this.eventType + ", identifier=" + this.identifier + ", source=" + this.source + ", context=" + this.context + ", renderedLocale=" + this.renderedLocale + ", baseData=" + this.baseData + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AnalyticsEvent(EventType eventType, InAppEventMessageId identifier, InAppEventSource source, InAppEventContext inAppEventContext, JsonValue jsonValue, JsonSerializable jsonSerializable) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(source, "source");
        this.eventType = eventType;
        this.identifier = identifier;
        this.source = source;
        this.context = inAppEventContext;
        this.renderedLocale = jsonValue;
        this.baseData = jsonSerializable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnalyticsEvent(InAppEventData eventData) {
        this(eventData.getEvent().getEventType(), eventData.getMessageId(), eventData.getSource(), eventData.getContext(), eventData.getRenderedLocale(), eventData.getEvent().getData());
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/iam/analytics/AnalyticsEvent$Companion;", "", "()V", "CONTEXT", "", "CONVERSION_PUSH_METADATA", "CONVERSION_SEND_ID", "IDENTIFIER", "RENDERED_LOCALE", "SOURCE", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.urbanairship.analytics.Event
    public EventType getType() {
        return this.eventType;
    }

    @Override // com.urbanairship.analytics.Event
    public JsonMap getEventData(ConversionData conversionData) throws JsonException {
        JsonMap jsonMapJsonMapOf;
        JsonValue jsonValue;
        Intrinsics.checkNotNullParameter(conversionData, "conversionData");
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        JsonSerializable jsonSerializable = this.baseData;
        if (jsonSerializable == null || (jsonValue = jsonSerializable.getJsonValue()) == null || (jsonMapJsonMapOf = jsonValue.requireMap()) == null) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(new Pair[0]);
        }
        JsonMap jsonMapBuild = builderNewBuilder.putAll(jsonMapJsonMapOf).put("id", this.identifier).put("source", this.source).putOpt("context", this.context).putOpt(CustomEvent.CONVERSION_SEND_ID, conversionData.getConversionSendId()).putOpt(CustomEvent.CONVERSION_METADATA, conversionData.getConversionMetadata()).putOpt("rendered_locale", this.renderedLocale).build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }
}
