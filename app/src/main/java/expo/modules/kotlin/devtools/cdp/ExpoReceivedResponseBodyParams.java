package expo.modules.kotlin.devtools.cdp;

import androidx.media3.common.MimeTypes;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\r\u0010\u0017\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/ExpoReceivedResponseBodyParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "requestId", "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", RateAppAction.BODY_KEY, "base64Encoded", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lokhttp3/ResponseBody;", "(Ljava/lang/String;Lokhttp3/ResponseBody;)V", "getRequestId", "()Ljava/lang/String;", "getBody", "setBody", "(Ljava/lang/String;)V", "getBase64Encoded", "()Z", "setBase64Encoded", "(Z)V", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class ExpoReceivedResponseBodyParams implements JsonSerializable {
    private boolean base64Encoded;
    private String body;
    private final String requestId;

    public static /* synthetic */ ExpoReceivedResponseBodyParams copy$default(ExpoReceivedResponseBodyParams expoReceivedResponseBodyParams, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expoReceivedResponseBodyParams.requestId;
        }
        if ((i & 2) != 0) {
            str2 = expoReceivedResponseBodyParams.body;
        }
        if ((i & 4) != 0) {
            z = expoReceivedResponseBodyParams.base64Encoded;
        }
        return expoReceivedResponseBodyParams.copy(str, str2, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getBase64Encoded() {
        return this.base64Encoded;
    }

    @NotNull
    public final ExpoReceivedResponseBodyParams copy(@NotNull String requestId, @NotNull String body, boolean base64Encoded) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(body, "body");
        return new ExpoReceivedResponseBodyParams(requestId, body, base64Encoded);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpoReceivedResponseBodyParams)) {
            return false;
        }
        ExpoReceivedResponseBodyParams expoReceivedResponseBodyParams = (ExpoReceivedResponseBodyParams) other;
        return Intrinsics.areEqual(this.requestId, expoReceivedResponseBodyParams.requestId) && Intrinsics.areEqual(this.body, expoReceivedResponseBodyParams.body) && this.base64Encoded == expoReceivedResponseBodyParams.base64Encoded;
    }

    public int hashCode() {
        return (((this.requestId.hashCode() * 31) + this.body.hashCode()) * 31) + Boolean.hashCode(this.base64Encoded);
    }

    @NotNull
    public String toString() {
        return "ExpoReceivedResponseBodyParams(requestId=" + this.requestId + ", body=" + this.body + ", base64Encoded=" + this.base64Encoded + ")";
    }

    public ExpoReceivedResponseBodyParams(@NotNull String requestId, @NotNull String body, boolean z) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(body, "body");
        this.requestId = requestId;
        this.body = body;
        this.base64Encoded = z;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getBody() {
        return this.body;
    }

    public final void setBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.body = str;
    }

    public final boolean getBase64Encoded() {
        return this.base64Encoded;
    }

    public final void setBase64Encoded(boolean z) {
        this.base64Encoded = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    public ExpoReceivedResponseBodyParams(@NotNull String requestId, @NotNull ResponseBody body) {
        this(requestId, "", false);
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(body, "body");
        boolean z = false;
        MediaType mediaType = body.get$contentType();
        if (Intrinsics.areEqual(mediaType != null ? mediaType.type() : null, "text")) {
            z = true;
        } else {
            if (Intrinsics.areEqual(mediaType != null ? mediaType.type() : null, MimeTypes.BASE_TYPE_APPLICATION) && Intrinsics.areEqual(mediaType.subtype(), "json")) {
                z = true;
            }
        }
        this.body = z ? body.string() : body.getSource().readByteString().base64();
        this.base64Encoded = !z;
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put(RateAppAction.BODY_KEY, this.body);
        jSONObject.put("base64Encoded", this.base64Encoded);
        return jSONObject;
    }
}
