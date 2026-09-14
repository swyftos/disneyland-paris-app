package expo.modules.kotlin.devtools.cdp;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\r\u0010\u000b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/ConnectTiming;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "requestTime", "Ljava/math/BigDecimal;", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "<init>", "(Ljava/math/BigDecimal;)V", "getRequestTime", "()Ljava/math/BigDecimal;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class ConnectTiming implements JsonSerializable {
    private final BigDecimal requestTime;

    public static /* synthetic */ ConnectTiming copy$default(ConnectTiming connectTiming, BigDecimal bigDecimal, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = connectTiming.requestTime;
        }
        return connectTiming.copy(bigDecimal);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BigDecimal getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    public final ConnectTiming copy(@NotNull BigDecimal requestTime) {
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        return new ConnectTiming(requestTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConnectTiming) && Intrinsics.areEqual(this.requestTime, ((ConnectTiming) other).requestTime);
    }

    public int hashCode() {
        return this.requestTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConnectTiming(requestTime=" + this.requestTime + ")";
    }

    public ConnectTiming(@NotNull BigDecimal requestTime) {
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        this.requestTime = requestTime;
    }

    @NotNull
    public final BigDecimal getRequestTime() {
        return this.requestTime;
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    @NotNull
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestTime", this.requestTime);
        return jSONObject;
    }
}
