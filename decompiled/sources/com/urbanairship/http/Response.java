package com.urbanairship.http;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.google.common.net.HttpHeaders;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.Clock;
import com.urbanairship.util.DateUtils;
import com.urbanairship.util.UAHttpStatusUtil;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u001f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003JJ\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0007J\t\u0010-\u001a\u00020\u0004HÖ\u0001J&\u0010.\u001a\b\u0012\u0004\u0012\u0002H/0\u0000\"\u0004\b\u0001\u0010/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H/01J\t\u00102\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lcom/urbanairship/http/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "", "result", RateAppAction.BODY_KEY, "", "headers", "", "(ILjava/lang/Object;Ljava/lang/String;Ljava/util/Map;)V", "getBody", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "isClientError", "", "()Z", "isServerError", "isSuccessful", "isTooManyRequestsError", "locationHeader", "Landroid/net/Uri;", "getLocationHeader", "()Landroid/net/Uri;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Object;Ljava/lang/String;Ljava/util/Map;)Lcom/urbanairship/http/Response;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "getRetryAfterHeader", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "defaultValue", "clock", "Lcom/urbanairship/util/Clock;", "hashCode", "map", "R", "mapper", "Lkotlin/Function1;", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class Response<T> {
    private final String body;
    private final Map headers;
    private final Object result;
    private final int status;

    @JvmOverloads
    public Response(int i, T t) {
        this(i, t, null, null, 12, null);
    }

    @JvmOverloads
    public Response(int i, T t, @Nullable String str) {
        this(i, t, str, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, int i, Object obj, String str, Map map, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = response.status;
        }
        if ((i2 & 2) != 0) {
            obj = response.result;
        }
        if ((i2 & 4) != 0) {
            str = response.body;
        }
        if ((i2 & 8) != 0) {
            map = response.headers;
        }
        return response.copy(i, obj, str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final T component2() {
        return (T) this.result;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    @NotNull
    public final Map<String, String> component4() {
        return this.headers;
    }

    @NotNull
    public final Response<T> copy(int status, T result, @Nullable String body, @NotNull Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new Response<>(status, result, body, headers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return this.status == response.status && Intrinsics.areEqual(this.result, response.result) && Intrinsics.areEqual(this.body, response.body) && Intrinsics.areEqual(this.headers, response.headers);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.status) * 31;
        Object obj = this.result;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        String str = this.body;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.headers.hashCode();
    }

    @NotNull
    public String toString() {
        return "Response(status=" + this.status + ", result=" + this.result + ", body=" + this.body + ", headers=" + this.headers + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public Response(int i, T t, @Nullable String str, @NotNull Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.status = i;
        this.result = t;
        this.body = str;
        this.headers = headers;
    }

    public final int getStatus() {
        return this.status;
    }

    public final T getResult() {
        return (T) this.result;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    public /* synthetic */ Response(int i, Object obj, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final <R> Response<R> map(@NotNull Function1<? super T, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new Response<>(this.status, mapper.invoke((Object) this.result), this.body, this.headers);
    }

    public final boolean isSuccessful() {
        return UAHttpStatusUtil.inSuccessRange(this.status);
    }

    public final boolean isServerError() {
        return UAHttpStatusUtil.inServerErrorRange(this.status);
    }

    public final boolean isClientError() {
        return UAHttpStatusUtil.inClientErrorRange(this.status);
    }

    public final boolean isTooManyRequestsError() {
        return this.status == 429;
    }

    @Nullable
    public final Uri getLocationHeader() {
        String str = (String) this.headers.get("Location");
        if (str == null) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Exception unused) {
            UALog.e("Failed to parse location header.", new Object[0]);
            return null;
        }
    }

    public final long getRetryAfterHeader(@NotNull TimeUnit timeUnit, long defaultValue) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        return getRetryAfterHeader(timeUnit, defaultValue, DEFAULT_CLOCK);
    }

    @VisibleForTesting
    public final long getRetryAfterHeader(@NotNull TimeUnit timeUnit, long defaultValue, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(clock, "clock");
        String str = (String) this.headers.get(HttpHeaders.RETRY_AFTER);
        if (str == null) {
            return defaultValue;
        }
        try {
            try {
                return timeUnit.convert(DateUtils.parseIso8601(str) - clock.currentTimeMillis(), TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                UALog.e("Invalid RetryAfter header %s", str);
                return defaultValue;
            }
        } catch (ParseException unused2) {
            return timeUnit.convert(Long.parseLong(str), TimeUnit.SECONDS);
        }
    }
}
