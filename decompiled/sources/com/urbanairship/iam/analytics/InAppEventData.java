package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.analytics.events.InAppEvent;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventData;", "", "event", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "context", "Lcom/urbanairship/iam/analytics/InAppEventContext;", "source", "Lcom/urbanairship/iam/analytics/InAppEventSource;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "renderedLocale", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/iam/analytics/events/InAppEvent;Lcom/urbanairship/iam/analytics/InAppEventContext;Lcom/urbanairship/iam/analytics/InAppEventSource;Lcom/urbanairship/iam/analytics/InAppEventMessageId;Lcom/urbanairship/json/JsonValue;)V", "getContext", "()Lcom/urbanairship/iam/analytics/InAppEventContext;", "getEvent", "()Lcom/urbanairship/iam/analytics/events/InAppEvent;", "getMessageId", "()Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "getRenderedLocale", "()Lcom/urbanairship/json/JsonValue;", "getSource", "()Lcom/urbanairship/iam/analytics/InAppEventSource;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InAppEventData {
    private final InAppEventContext context;
    private final InAppEvent event;
    private final InAppEventMessageId messageId;
    private final JsonValue renderedLocale;
    private final InAppEventSource source;

    public static /* synthetic */ InAppEventData copy$default(InAppEventData inAppEventData, InAppEvent inAppEvent, InAppEventContext inAppEventContext, InAppEventSource inAppEventSource, InAppEventMessageId inAppEventMessageId, JsonValue jsonValue, int i, Object obj) {
        if ((i & 1) != 0) {
            inAppEvent = inAppEventData.event;
        }
        if ((i & 2) != 0) {
            inAppEventContext = inAppEventData.context;
        }
        InAppEventContext inAppEventContext2 = inAppEventContext;
        if ((i & 4) != 0) {
            inAppEventSource = inAppEventData.source;
        }
        InAppEventSource inAppEventSource2 = inAppEventSource;
        if ((i & 8) != 0) {
            inAppEventMessageId = inAppEventData.messageId;
        }
        InAppEventMessageId inAppEventMessageId2 = inAppEventMessageId;
        if ((i & 16) != 0) {
            jsonValue = inAppEventData.renderedLocale;
        }
        return inAppEventData.copy(inAppEvent, inAppEventContext2, inAppEventSource2, inAppEventMessageId2, jsonValue);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final InAppEvent getEvent() {
        return this.event;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final InAppEventContext getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final InAppEventSource getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final InAppEventMessageId getMessageId() {
        return this.messageId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonValue getRenderedLocale() {
        return this.renderedLocale;
    }

    @NotNull
    public final InAppEventData copy(@NotNull InAppEvent event, @Nullable InAppEventContext context, @NotNull InAppEventSource source, @NotNull InAppEventMessageId messageId, @Nullable JsonValue renderedLocale) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return new InAppEventData(event, context, source, messageId, renderedLocale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppEventData)) {
            return false;
        }
        InAppEventData inAppEventData = (InAppEventData) other;
        return Intrinsics.areEqual(this.event, inAppEventData.event) && Intrinsics.areEqual(this.context, inAppEventData.context) && this.source == inAppEventData.source && Intrinsics.areEqual(this.messageId, inAppEventData.messageId) && Intrinsics.areEqual(this.renderedLocale, inAppEventData.renderedLocale);
    }

    public int hashCode() {
        int iHashCode = this.event.hashCode() * 31;
        InAppEventContext inAppEventContext = this.context;
        int iHashCode2 = (((((iHashCode + (inAppEventContext == null ? 0 : inAppEventContext.hashCode())) * 31) + this.source.hashCode()) * 31) + this.messageId.hashCode()) * 31;
        JsonValue jsonValue = this.renderedLocale;
        return iHashCode2 + (jsonValue != null ? jsonValue.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "InAppEventData(event=" + this.event + ", context=" + this.context + ", source=" + this.source + ", messageId=" + this.messageId + ", renderedLocale=" + this.renderedLocale + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public InAppEventData(@NotNull InAppEvent event, @Nullable InAppEventContext inAppEventContext, @NotNull InAppEventSource source, @NotNull InAppEventMessageId messageId, @Nullable JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        this.event = event;
        this.context = inAppEventContext;
        this.source = source;
        this.messageId = messageId;
        this.renderedLocale = jsonValue;
    }

    @NotNull
    public final InAppEvent getEvent() {
        return this.event;
    }

    @Nullable
    public final InAppEventContext getContext() {
        return this.context;
    }

    @NotNull
    public final InAppEventSource getSource() {
        return this.source;
    }

    @NotNull
    public final InAppEventMessageId getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final JsonValue getRenderedLocale() {
        return this.renderedLocale;
    }
}
