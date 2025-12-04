package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppCustomEventContext;", "Lcom/urbanairship/json/JsonSerializable;", "id", "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "context", "Lcom/urbanairship/iam/analytics/InAppEventContext;", "(Lcom/urbanairship/iam/analytics/InAppEventMessageId;Lcom/urbanairship/iam/analytics/InAppEventContext;)V", "getContext", "()Lcom/urbanairship/iam/analytics/InAppEventContext;", "getId", "()Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InAppCustomEventContext implements JsonSerializable {
    private final InAppEventContext context;
    private final InAppEventMessageId id;

    public static /* synthetic */ InAppCustomEventContext copy$default(InAppCustomEventContext inAppCustomEventContext, InAppEventMessageId inAppEventMessageId, InAppEventContext inAppEventContext, int i, Object obj) {
        if ((i & 1) != 0) {
            inAppEventMessageId = inAppCustomEventContext.id;
        }
        if ((i & 2) != 0) {
            inAppEventContext = inAppCustomEventContext.context;
        }
        return inAppCustomEventContext.copy(inAppEventMessageId, inAppEventContext);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final InAppEventMessageId getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final InAppEventContext getContext() {
        return this.context;
    }

    @NotNull
    public final InAppCustomEventContext copy(@NotNull InAppEventMessageId id, @Nullable InAppEventContext context) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new InAppCustomEventContext(id, context);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppCustomEventContext)) {
            return false;
        }
        InAppCustomEventContext inAppCustomEventContext = (InAppCustomEventContext) other;
        return Intrinsics.areEqual(this.id, inAppCustomEventContext.id) && Intrinsics.areEqual(this.context, inAppCustomEventContext.context);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        InAppEventContext inAppEventContext = this.context;
        return iHashCode + (inAppEventContext == null ? 0 : inAppEventContext.hashCode());
    }

    @NotNull
    public String toString() {
        return "InAppCustomEventContext(id=" + this.id + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public InAppCustomEventContext(@NotNull InAppEventMessageId id, @Nullable InAppEventContext inAppEventContext) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.context = inAppEventContext;
    }

    @NotNull
    public final InAppEventMessageId getId() {
        return this.id;
    }

    @Nullable
    public final InAppEventContext getContext() {
        return this.context;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("context", this.context)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
