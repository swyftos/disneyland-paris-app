package expo.modules.kotlin.devtools.cdp;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.devtools.OkHttpExtensionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u0002`\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u0002`\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/Response;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "url", "", "status", "", "statusText", "headers", "", "Lexpo/modules/kotlin/devtools/cdp/Headers;", "mimeType", "encodedDataLength", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;J)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "getUrl", "()Ljava/lang/String;", "getStatus", "()I", "getStatusText", "getHeaders", "()Ljava/util/Map;", "getMimeType", "getEncodedDataLength", "()J", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class Response implements JsonSerializable {
    private final long encodedDataLength;
    private final Map headers;
    private final String mimeType;
    private final int status;
    private final String statusText;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, String str, int i, String str2, Map map, String str3, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = response.url;
        }
        if ((i2 & 2) != 0) {
            i = response.status;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = response.statusText;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            map = response.headers;
        }
        Map map2 = map;
        if ((i2 & 16) != 0) {
            str3 = response.mimeType;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            j = response.encodedDataLength;
        }
        return response.copy(str, i3, str4, map2, str5, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    @NotNull
    public final Map<String, String> component4() {
        return this.headers;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    @NotNull
    public final Response copy(@NotNull String url, int status, @NotNull String statusText, @NotNull Map<String, String> headers, @NotNull String mimeType, long encodedDataLength) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new Response(url, status, statusText, headers, mimeType, encodedDataLength);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return Intrinsics.areEqual(this.url, response.url) && this.status == response.status && Intrinsics.areEqual(this.statusText, response.statusText) && Intrinsics.areEqual(this.headers, response.headers) && Intrinsics.areEqual(this.mimeType, response.mimeType) && this.encodedDataLength == response.encodedDataLength;
    }

    public int hashCode() {
        return (((((((((this.url.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + this.statusText.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + Long.hashCode(this.encodedDataLength);
    }

    @NotNull
    public String toString() {
        return "Response(url=" + this.url + ", status=" + this.status + ", statusText=" + this.statusText + ", headers=" + this.headers + ", mimeType=" + this.mimeType + ", encodedDataLength=" + this.encodedDataLength + ")";
    }

    public Response(@NotNull String url, int i, @NotNull String statusText, @NotNull Map<String, String> headers, @NotNull String mimeType, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.url = url;
        this.status = i;
        this.statusText = statusText;
        this.headers = headers;
        this.mimeType = mimeType;
        this.encodedDataLength = j;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getStatusText() {
        return this.statusText;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final String getMimeType() {
        return this.mimeType;
    }

    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Response(@NotNull okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String url = response.request().url().getUrl();
        int iCode = response.code();
        String strMessage = response.message();
        Map<String, String> singleMap = OkHttpExtensionsKt.toSingleMap(response.headers());
        String strHeader = response.header("Content-Type", "");
        String str = strHeader == null ? "" : strHeader;
        ResponseBody responseBodyBody = response.body();
        this(url, iCode, strMessage, singleMap, str, responseBodyBody != null ? responseBodyBody.get$contentLength() : 0L);
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", this.url);
        jSONObject.put("status", this.status);
        jSONObject.put("statusText", this.statusText);
        jSONObject.put("headers", new JSONObject(this.headers));
        jSONObject.put("mimeType", this.mimeType);
        jSONObject.put("encodedDataLength", this.encodedDataLength);
        return jSONObject;
    }
}
