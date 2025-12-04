package com.urbanairship.http;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/http/RequestBody;", "", "content", "", CMSAttributeTableGenerator.CONTENT_TYPE, "compress", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCompress", "()Z", "getContent", "()Ljava/lang/String;", "getContentType", "GzippedJson", "Json", "Lcom/urbanairship/http/RequestBody$GzippedJson;", "Lcom/urbanairship/http/RequestBody$Json;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RequestBody {
    private final boolean compress;
    private final String content;
    private final String contentType;

    public /* synthetic */ RequestBody(String str, String str2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z);
    }

    private RequestBody(String str, String str2, boolean z) {
        this.content = str;
        this.contentType = str2;
        this.compress = z;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getContentType() {
        return this.contentType;
    }

    public final boolean getCompress() {
        return this.compress;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0007HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/http/RequestBody$Json;", "Lcom/urbanairship/http/RequestBody;", "json", "Lcom/urbanairship/json/JsonSerializable;", "(Lcom/urbanairship/json/JsonSerializable;)V", "", "(Ljava/lang/String;)V", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "getJson", "()Lcom/urbanairship/json/JsonValue;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Json extends RequestBody {
        private final JsonValue json;

        public static /* synthetic */ Json copy$default(Json json, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonValue = json.json;
            }
            return json.copy(jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final JsonValue getJson() {
            return this.json;
        }

        @NotNull
        public final Json copy(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new Json(json);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Json) && Intrinsics.areEqual(this.json, ((Json) other).json);
        }

        public int hashCode() {
            return this.json.hashCode();
        }

        @NotNull
        public String toString() {
            return "Json(json=" + this.json + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final JsonValue getJson() {
            return this.json;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Json(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String string = json.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            super(string, "application/json", false, null);
            this.json = json;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Json(@NotNull JsonSerializable json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            this(jsonValue);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Json(@NotNull String json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue string = JsonValue.parseString(json);
            Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
            this(string);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0007HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/http/RequestBody$GzippedJson;", "Lcom/urbanairship/http/RequestBody;", "json", "Lcom/urbanairship/json/JsonSerializable;", "(Lcom/urbanairship/json/JsonSerializable;)V", "", "(Ljava/lang/String;)V", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "getJson", "()Lcom/urbanairship/json/JsonValue;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GzippedJson extends RequestBody {
        private final JsonValue json;

        public static /* synthetic */ GzippedJson copy$default(GzippedJson gzippedJson, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonValue = gzippedJson.json;
            }
            return gzippedJson.copy(jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final JsonValue getJson() {
            return this.json;
        }

        @NotNull
        public final GzippedJson copy(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new GzippedJson(json);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GzippedJson) && Intrinsics.areEqual(this.json, ((GzippedJson) other).json);
        }

        public int hashCode() {
            return this.json.hashCode();
        }

        @NotNull
        public String toString() {
            return "GzippedJson(json=" + this.json + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final JsonValue getJson() {
            return this.json;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GzippedJson(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String string = json.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            super(string, "application/json", true, null);
            this.json = json;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GzippedJson(@NotNull JsonSerializable json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            this(jsonValue);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GzippedJson(@NotNull String json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue string = JsonValue.parseString(json);
            Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
            this(string);
        }
    }
}
