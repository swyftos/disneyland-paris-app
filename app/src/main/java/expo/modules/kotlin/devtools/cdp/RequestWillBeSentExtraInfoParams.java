package expo.modules.kotlin.devtools.cdp;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.devtools.OkHttpExtensionsKt;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB%\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\r\u0010\u001b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/RequestWillBeSentExtraInfoParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "requestId", "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", "associatedCookies", "", "headers", "Lexpo/modules/kotlin/devtools/cdp/Headers;", "connectTiming", "Lexpo/modules/kotlin/devtools/cdp/ConnectTiming;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lexpo/modules/kotlin/devtools/cdp/ConnectTiming;)V", "now", "Ljava/math/BigDecimal;", "request", "Lokhttp3/Request;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Request;)V", "getRequestId", "()Ljava/lang/String;", "getAssociatedCookies", "()Ljava/util/Map;", "getHeaders", "getConnectTiming", "()Lexpo/modules/kotlin/devtools/cdp/ConnectTiming;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class RequestWillBeSentExtraInfoParams implements JsonSerializable {
    private final Map associatedCookies;
    private final ConnectTiming connectTiming;
    private final Map headers;
    private final String requestId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestWillBeSentExtraInfoParams copy$default(RequestWillBeSentExtraInfoParams requestWillBeSentExtraInfoParams, String str, Map map, Map map2, ConnectTiming connectTiming, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestWillBeSentExtraInfoParams.requestId;
        }
        if ((i & 2) != 0) {
            map = requestWillBeSentExtraInfoParams.associatedCookies;
        }
        if ((i & 4) != 0) {
            map2 = requestWillBeSentExtraInfoParams.headers;
        }
        if ((i & 8) != 0) {
            connectTiming = requestWillBeSentExtraInfoParams.connectTiming;
        }
        return requestWillBeSentExtraInfoParams.copy(str, map, map2, connectTiming);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.associatedCookies;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.headers;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConnectTiming getConnectTiming() {
        return this.connectTiming;
    }

    @NotNull
    public final RequestWillBeSentExtraInfoParams copy(@NotNull String requestId, @NotNull Map<String, String> associatedCookies, @NotNull Map<String, String> headers, @NotNull ConnectTiming connectTiming) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(associatedCookies, "associatedCookies");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(connectTiming, "connectTiming");
        return new RequestWillBeSentExtraInfoParams(requestId, associatedCookies, headers, connectTiming);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestWillBeSentExtraInfoParams)) {
            return false;
        }
        RequestWillBeSentExtraInfoParams requestWillBeSentExtraInfoParams = (RequestWillBeSentExtraInfoParams) other;
        return Intrinsics.areEqual(this.requestId, requestWillBeSentExtraInfoParams.requestId) && Intrinsics.areEqual(this.associatedCookies, requestWillBeSentExtraInfoParams.associatedCookies) && Intrinsics.areEqual(this.headers, requestWillBeSentExtraInfoParams.headers) && Intrinsics.areEqual(this.connectTiming, requestWillBeSentExtraInfoParams.connectTiming);
    }

    public int hashCode() {
        return (((((this.requestId.hashCode() * 31) + this.associatedCookies.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.connectTiming.hashCode();
    }

    @NotNull
    public String toString() {
        return "RequestWillBeSentExtraInfoParams(requestId=" + this.requestId + ", associatedCookies=" + this.associatedCookies + ", headers=" + this.headers + ", connectTiming=" + this.connectTiming + ")";
    }

    public RequestWillBeSentExtraInfoParams(@NotNull String requestId, @NotNull Map<String, String> associatedCookies, @NotNull Map<String, String> headers, @NotNull ConnectTiming connectTiming) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(associatedCookies, "associatedCookies");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(connectTiming, "connectTiming");
        this.requestId = requestId;
        this.associatedCookies = associatedCookies;
        this.headers = headers;
        this.connectTiming = connectTiming;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ RequestWillBeSentExtraInfoParams(String str, Map map, Map map2, ConnectTiming connectTiming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, map2, connectTiming);
    }

    @NotNull
    public final Map<String, String> getAssociatedCookies() {
        return this.associatedCookies;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final ConnectTiming getConnectTiming() {
        return this.connectTiming;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestWillBeSentExtraInfoParams(@NotNull BigDecimal now, @NotNull String requestId, @NotNull okhttp3.Request request) {
        this(requestId, null, OkHttpExtensionsKt.toSingleMap(request.headers()), new ConnectTiming(now), 2, null);
        Intrinsics.checkNotNullParameter(now, "now");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("associatedCookies", new JSONObject(this.associatedCookies));
        jSONObject.put("headers", new JSONObject(this.headers));
        jSONObject.put("connectTiming", this.connectTiming.toJSONObject());
        return jSONObject;
    }
}
