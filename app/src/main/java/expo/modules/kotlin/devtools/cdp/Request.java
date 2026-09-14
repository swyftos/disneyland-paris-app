package expo.modules.kotlin.devtools.cdp;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.devtools.OkHttpExtensionsKt;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.RequestBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/Request;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "url", "", TCEventPropertiesNames.TCE_METHOD, "headers", "", "Lexpo/modules/kotlin/devtools/cdp/Headers;", "postData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "getHeaders", "()Ljava/util/Map;", "getPostData", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class Request implements JsonSerializable {
    private final Map headers;
    private final String method;
    private final String postData;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Request copy$default(Request request, String str, String str2, Map map, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = request.url;
        }
        if ((i & 2) != 0) {
            str2 = request.method;
        }
        if ((i & 4) != 0) {
            map = request.headers;
        }
        if ((i & 8) != 0) {
            str3 = request.postData;
        }
        return request.copy(str, str2, map, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.headers;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPostData() {
        return this.postData;
    }

    @NotNull
    public final Request copy(@NotNull String url, @NotNull String method, @NotNull Map<String, String> headers, @Nullable String postData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new Request(url, method, headers, postData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request request = (Request) other;
        return Intrinsics.areEqual(this.url, request.url) && Intrinsics.areEqual(this.method, request.method) && Intrinsics.areEqual(this.headers, request.headers) && Intrinsics.areEqual(this.postData, request.postData);
    }

    public int hashCode() {
        int iHashCode = ((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.headers.hashCode()) * 31;
        String str = this.postData;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "Request(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", postData=" + this.postData + ")";
    }

    public Request(@NotNull String url, @NotNull String method, @NotNull Map<String, String> headers, @Nullable String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.postData = str;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public final String getPostData() {
        return this.postData;
    }

    public Request(@NotNull okhttp3.Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        String url = request.url().getUrl();
        String strMethod = request.method();
        Map<String, String> singleMap = OkHttpExtensionsKt.toSingleMap(request.headers());
        RequestBody requestBodyBody = request.body();
        String utf8 = null;
        if (requestBodyBody != null && requestBodyBody.contentLength() < 1048576) {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            utf8 = buffer.readUtf8(RangesKt.coerceAtMost(buffer.size(), 1048576L));
        }
        this(url, strMethod, singleMap, utf8);
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", this.url);
        jSONObject.put(TCEventPropertiesNames.TCE_METHOD, this.method);
        jSONObject.put("headers", new JSONObject(this.headers));
        String str = this.postData;
        if (str != null) {
            jSONObject.put("postData", str);
        }
        return jSONObject;
    }
}
