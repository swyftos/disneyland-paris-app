package expo.modules.kotlin.devtools.cdp;

import com.google.common.net.HttpHeaders;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u00060\nj\u0002`\u000b\u0012\n\u0010\f\u001a\u00060\nj\u0002`\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018B/\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u001a\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\b\u0010/\u001a\u000200H\u0016J\r\u00101\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\r\u00105\u001a\u00060\nj\u0002`\u000bHÆ\u0003J\r\u00106\u001a\u00060\nj\u0002`\rHÆ\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0011HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0016HÆ\u0003J\u0091\u0001\u0010<\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\b\u0002\u0010\t\u001a\u00060\nj\u0002`\u000b2\f\b\u0002\u0010\f\u001a\u00060\nj\u0002`\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\t\u001a\u00060\nj\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\f\u001a\u00060\nj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006C"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/RequestWillBeSentParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "requestId", "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", "loaderId", "documentURL", "request", "Lexpo/modules/kotlin/devtools/cdp/Request;", "timestamp", "Ljava/math/BigDecimal;", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "wallTime", "Lexpo/modules/kotlin/devtools/cdp/TimeSinceEpoch;", "initiator", "", "redirectHasExtraInfo", "", "redirectResponse", "Lexpo/modules/kotlin/devtools/cdp/Response;", "referrerPolicy", "type", "Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lexpo/modules/kotlin/devtools/cdp/Request;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/util/Map;ZLexpo/modules/kotlin/devtools/cdp/Response;Ljava/lang/String;Lexpo/modules/kotlin/devtools/cdp/ResourceType;)V", "now", "Lokhttp3/Request;", "Lokhttp3/Response;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Request;Lokhttp3/Response;)V", "getRequestId", "()Ljava/lang/String;", "getLoaderId", "getDocumentURL", "getRequest", "()Lexpo/modules/kotlin/devtools/cdp/Request;", "getTimestamp", "()Ljava/math/BigDecimal;", "getWallTime", "getInitiator", "()Ljava/util/Map;", "getRedirectHasExtraInfo", "()Z", "getRedirectResponse", "()Lexpo/modules/kotlin/devtools/cdp/Response;", "getReferrerPolicy", "getType", "()Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nCdpNetworkTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CdpNetworkTypes.kt\nexpo/modules/kotlin/devtools/cdp/RequestWillBeSentParams\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n1#2:270\n*E\n"})
public final /* data */ class RequestWillBeSentParams implements JsonSerializable {
    private final String documentURL;
    private final Map initiator;
    private final String loaderId;
    private final boolean redirectHasExtraInfo;
    private final Response redirectResponse;
    private final String referrerPolicy;
    private final Request request;
    private final String requestId;
    private final BigDecimal timestamp;
    private final ResourceType type;
    private final BigDecimal wallTime;

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getReferrerPolicy() {
        return this.referrerPolicy;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ResourceType getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLoaderId() {
        return this.loaderId;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDocumentURL() {
        return this.documentURL;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BigDecimal getWallTime() {
        return this.wallTime;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.initiator;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getRedirectHasExtraInfo() {
        return this.redirectHasExtraInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Response getRedirectResponse() {
        return this.redirectResponse;
    }

    @NotNull
    public final RequestWillBeSentParams copy(@NotNull String requestId, @NotNull String loaderId, @NotNull String documentURL, @NotNull Request request, @NotNull BigDecimal timestamp, @NotNull BigDecimal wallTime, @NotNull Map<String, String> initiator, boolean redirectHasExtraInfo, @Nullable Response redirectResponse, @NotNull String referrerPolicy, @NotNull ResourceType type) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(documentURL, "documentURL");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(wallTime, "wallTime");
        Intrinsics.checkNotNullParameter(initiator, "initiator");
        Intrinsics.checkNotNullParameter(referrerPolicy, "referrerPolicy");
        Intrinsics.checkNotNullParameter(type, "type");
        return new RequestWillBeSentParams(requestId, loaderId, documentURL, request, timestamp, wallTime, initiator, redirectHasExtraInfo, redirectResponse, referrerPolicy, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestWillBeSentParams)) {
            return false;
        }
        RequestWillBeSentParams requestWillBeSentParams = (RequestWillBeSentParams) other;
        return Intrinsics.areEqual(this.requestId, requestWillBeSentParams.requestId) && Intrinsics.areEqual(this.loaderId, requestWillBeSentParams.loaderId) && Intrinsics.areEqual(this.documentURL, requestWillBeSentParams.documentURL) && Intrinsics.areEqual(this.request, requestWillBeSentParams.request) && Intrinsics.areEqual(this.timestamp, requestWillBeSentParams.timestamp) && Intrinsics.areEqual(this.wallTime, requestWillBeSentParams.wallTime) && Intrinsics.areEqual(this.initiator, requestWillBeSentParams.initiator) && this.redirectHasExtraInfo == requestWillBeSentParams.redirectHasExtraInfo && Intrinsics.areEqual(this.redirectResponse, requestWillBeSentParams.redirectResponse) && Intrinsics.areEqual(this.referrerPolicy, requestWillBeSentParams.referrerPolicy) && this.type == requestWillBeSentParams.type;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.requestId.hashCode() * 31) + this.loaderId.hashCode()) * 31) + this.documentURL.hashCode()) * 31) + this.request.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.wallTime.hashCode()) * 31) + this.initiator.hashCode()) * 31) + Boolean.hashCode(this.redirectHasExtraInfo)) * 31;
        Response response = this.redirectResponse;
        return ((((iHashCode + (response == null ? 0 : response.hashCode())) * 31) + this.referrerPolicy.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "RequestWillBeSentParams(requestId=" + this.requestId + ", loaderId=" + this.loaderId + ", documentURL=" + this.documentURL + ", request=" + this.request + ", timestamp=" + this.timestamp + ", wallTime=" + this.wallTime + ", initiator=" + this.initiator + ", redirectHasExtraInfo=" + this.redirectHasExtraInfo + ", redirectResponse=" + this.redirectResponse + ", referrerPolicy=" + this.referrerPolicy + ", type=" + this.type + ")";
    }

    public RequestWillBeSentParams(@NotNull String requestId, @NotNull String loaderId, @NotNull String documentURL, @NotNull Request request, @NotNull BigDecimal timestamp, @NotNull BigDecimal wallTime, @NotNull Map<String, String> initiator, boolean z, @Nullable Response response, @NotNull String referrerPolicy, @NotNull ResourceType type) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(documentURL, "documentURL");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(wallTime, "wallTime");
        Intrinsics.checkNotNullParameter(initiator, "initiator");
        Intrinsics.checkNotNullParameter(referrerPolicy, "referrerPolicy");
        Intrinsics.checkNotNullParameter(type, "type");
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.documentURL = documentURL;
        this.request = request;
        this.timestamp = timestamp;
        this.wallTime = wallTime;
        this.initiator = initiator;
        this.redirectHasExtraInfo = z;
        this.redirectResponse = response;
        this.referrerPolicy = referrerPolicy;
        this.type = type;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ RequestWillBeSentParams(String str, String str2, String str3, Request request, BigDecimal bigDecimal, BigDecimal bigDecimal2, Map map, boolean z, Response response, String str4, ResourceType resourceType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "mobile" : str3, request, bigDecimal, bigDecimal2, (i & 64) != 0 ? MapsKt.mapOf(TuplesKt.m1842to("type", "script")) : map, z, response, (i & 512) != 0 ? HttpHeaders.ReferrerPolicyValues.NO_REFERRER : str4, resourceType);
    }

    @NotNull
    public final String getLoaderId() {
        return this.loaderId;
    }

    @NotNull
    public final String getDocumentURL() {
        return this.documentURL;
    }

    @NotNull
    public final Request getRequest() {
        return this.request;
    }

    @NotNull
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final BigDecimal getWallTime() {
        return this.wallTime;
    }

    @NotNull
    public final Map<String, String> getInitiator() {
        return this.initiator;
    }

    public final boolean getRedirectHasExtraInfo() {
        return this.redirectHasExtraInfo;
    }

    @Nullable
    public final Response getRedirectResponse() {
        return this.redirectResponse;
    }

    @NotNull
    public final String getReferrerPolicy() {
        return this.referrerPolicy;
    }

    @NotNull
    public final ResourceType getType() {
        return this.type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestWillBeSentParams(@NotNull BigDecimal now, @NotNull String requestId, @NotNull okhttp3.Request request, @Nullable okhttp3.Response response) {
        this(requestId, null, null, new Request(request), now, now, null, response != null, response != null ? new Response(response) : null, null, ResourceType.OTHER, 582, null);
        Intrinsics.checkNotNullParameter(now, "now");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("loaderId", this.loaderId);
        jSONObject.put("documentURL", this.documentURL);
        jSONObject.put("request", this.request.toJSONObject());
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("wallTime", this.wallTime);
        jSONObject.put("initiator", new JSONObject(this.initiator));
        jSONObject.put("redirectHasExtraInfo", this.redirectHasExtraInfo);
        Response response = this.redirectResponse;
        if (response != null) {
            jSONObject.put("redirectResponse", response.toJSONObject());
        }
        jSONObject.put("referrerPolicy", this.referrerPolicy);
        jSONObject.put("type", this.type.getValue());
        return jSONObject;
    }
}
