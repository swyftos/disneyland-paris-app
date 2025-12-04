package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \t2\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "AirshipId", "AppDefined", "Companion", "Legacy", "Lcom/urbanairship/iam/analytics/InAppEventMessageId$AirshipId;", "Lcom/urbanairship/iam/analytics/InAppEventMessageId$AppDefined;", "Lcom/urbanairship/iam/analytics/InAppEventMessageId$Legacy;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InAppEventMessageId implements JsonSerializable {
    public /* synthetic */ InAppEventMessageId(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String getIdentifier();

    private InAppEventMessageId() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventMessageId$Legacy;", "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Legacy extends InAppEventMessageId {
        private final String identifier;

        public static /* synthetic */ Legacy copy$default(Legacy legacy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = legacy.identifier;
            }
            return legacy.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final Legacy copy(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Legacy(identifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Legacy) && Intrinsics.areEqual(this.identifier, ((Legacy) other).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "Legacy(identifier=" + this.identifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Legacy(@NotNull String identifier) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        @Override // com.urbanairship.iam.analytics.InAppEventMessageId
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(getIdentifier());
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventMessageId$AppDefined;", "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AppDefined extends InAppEventMessageId {
        private final String identifier;

        public static /* synthetic */ AppDefined copy$default(AppDefined appDefined, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appDefined.identifier;
            }
            return appDefined.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final AppDefined copy(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new AppDefined(identifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AppDefined) && Intrinsics.areEqual(this.identifier, ((AppDefined) other).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "AppDefined(identifier=" + this.identifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppDefined(@NotNull String identifier) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        @Override // com.urbanairship.iam.analytics.InAppEventMessageId
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("message_id", getIdentifier())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventMessageId$AirshipId;", "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "identifier", "", "campaigns", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getCampaigns", "()Lcom/urbanairship/json/JsonValue;", "getIdentifier", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AirshipId extends InAppEventMessageId {
        private final JsonValue campaigns;
        private final String identifier;

        public static /* synthetic */ AirshipId copy$default(AirshipId airshipId, String str, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = airshipId.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = airshipId.campaigns;
            }
            return airshipId.copy(str, jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getCampaigns() {
            return this.campaigns;
        }

        @NotNull
        public final AirshipId copy(@NotNull String identifier, @Nullable JsonValue campaigns) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new AirshipId(identifier, campaigns);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AirshipId)) {
                return false;
            }
            AirshipId airshipId = (AirshipId) other;
            return Intrinsics.areEqual(this.identifier, airshipId.identifier) && Intrinsics.areEqual(this.campaigns, airshipId.campaigns);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.campaigns;
            return iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode());
        }

        @NotNull
        public String toString() {
            return "AirshipId(identifier=" + this.identifier + ", campaigns=" + this.campaigns + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.iam.analytics.InAppEventMessageId
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final JsonValue getCampaigns() {
            return this.campaigns;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AirshipId(@NotNull String identifier, @Nullable JsonValue jsonValue) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.campaigns = jsonValue;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("message_id", getIdentifier()), TuplesKt.to("campaigns", this.campaigns)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
