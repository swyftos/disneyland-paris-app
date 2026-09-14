package com.urbanairship.http;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rBG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010&\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\\\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/2\u0006\u00103\u001a\u000204H\u0007J\t\u00105\u001a\u00020\u0004HÖ\u0001J*\u00106\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0004\b\u0001\u001072\u0016\u00108\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u0001H709J\t\u0010:\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006;"}, m1836d2 = {"Lcom/urbanairship/http/RequestResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "", "value", RateAppAction.BODY_KEY, "", "headers", "", "(ILjava/lang/Object;Ljava/lang/String;Ljava/util/Map;)V", "exception", "", "(Ljava/lang/Throwable;)V", "(Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)V", "getBody", "()Ljava/lang/String;", "getException", "()Ljava/lang/Throwable;", "getHeaders", "()Ljava/util/Map;", "isClientError", "", "()Z", "isServerError", "isSuccessful", "isTooManyRequestsError", "locationHeader", "Landroid/net/Uri;", "getLocationHeader", "()Landroid/net/Uri;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)Lcom/urbanairship/http/RequestResult;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "getRetryAfterHeader", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "defaultValue", "clock", "Lcom/urbanairship/util/Clock;", "hashCode", "map", "R", "mapper", "Lkotlin/Function1;", "toString", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class RequestResult<T> {
    private final String body;
    private final Throwable exception;
    private final Map headers;
    private final Integer status;
    private final Object value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestResult copy$default(RequestResult requestResult, Integer num, Object obj, String str, Map map, Throwable th, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = requestResult.status;
        }
        if ((i & 2) != 0) {
            obj = requestResult.value;
        }
        Object obj3 = obj;
        if ((i & 4) != 0) {
            str = requestResult.body;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            map = requestResult.headers;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            th = requestResult.exception;
        }
        return requestResult.copy(num, obj3, str2, map2, th);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final T component2() {
        return (T) this.value;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.headers;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }

    @NotNull
    public final RequestResult<T> copy(@Nullable Integer status, @Nullable T value, @Nullable String body, @Nullable Map<String, String> headers, @Nullable Throwable exception) {
        return new RequestResult<>(status, value, body, headers, exception);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestResult)) {
            return false;
        }
        RequestResult requestResult = (RequestResult) other;
        return Intrinsics.areEqual(this.status, requestResult.status) && Intrinsics.areEqual(this.value, requestResult.value) && Intrinsics.areEqual(this.body, requestResult.body) && Intrinsics.areEqual(this.headers, requestResult.headers) && Intrinsics.areEqual(this.exception, requestResult.exception);
    }

    public int hashCode() {
        Integer num = this.status;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Object obj = this.value;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        String str = this.body;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Map map = this.headers;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        Throwable th = this.exception;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RequestResult(status=" + this.status + ", value=" + this.value + ", body=" + this.body + ", headers=" + this.headers + ", exception=" + this.exception + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public RequestResult(@Nullable Integer num, @Nullable T t, @Nullable String str, @Nullable Map<String, String> map, @Nullable Throwable th) {
        this.status = num;
        this.value = t;
        this.body = str;
        this.headers = map;
        this.exception = th;
    }

    public /* synthetic */ RequestResult(Integer num, Object obj, String str, Map map, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : obj, str, map, th);
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final T getValue() {
        return (T) this.value;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public final Throwable getException() {
        return this.exception;
    }

    public RequestResult(int i, @Nullable T t, @Nullable String str, @Nullable Map<String, String> map) {
        this(Integer.valueOf(i), t, str, map, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestResult(@NotNull Throwable exception) {
        this(null, null, null, null, exception);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    @NotNull
    public final <R> RequestResult<R> map(@NotNull Function1<? super T, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new RequestResult<>(this.status, mapper.invoke((Object) this.value), this.body, this.headers, this.exception);
    }

    public final boolean isSuccessful() {
        Integer num = this.status;
        return num != null && UAHttpStatusUtil.inSuccessRange(num.intValue());
    }

    public final boolean isServerError() {
        Integer num = this.status;
        return num != null && UAHttpStatusUtil.inServerErrorRange(num.intValue());
    }

    public final boolean isClientError() {
        Integer num = this.status;
        return num != null && UAHttpStatusUtil.inClientErrorRange(num.intValue());
    }

    public final boolean isTooManyRequestsError() {
        Integer num = this.status;
        return (num == null || num == null || num.intValue() != 429) ? false : true;
    }

    @Nullable
    public final Uri getLocationHeader() {
        String str;
        Map map = this.headers;
        if (map == null || (str = (String) map.get("Location")) == null) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Exception unused) {
            UALog.m1744e("Failed to parse location header.", new Object[0]);
            return null;
        }
    }

    public final long getRetryAfterHeader(@NotNull TimeUnit timeUnit, long defaultValue) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        return getRetryAfterHeader(timeUnit, defaultValue, DEFAULT_CLOCK);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        r4 = (java.lang.String) r4.get(com.google.common.net.HttpHeaders.RETRY_AFTER);
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getRetryAfterHeader(@NotNull TimeUnit timeUnit, long defaultValue, @NotNull Clock clock) {
        String str;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Map map = this.headers;
        if (map != null && str != null) {
            try {
                try {
                    return timeUnit.convert(DateUtils.parseIso8601(str) - clock.currentTimeMillis(), TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                    UALog.m1744e("Invalid RetryAfter header %s", str);
                }
            } catch (ParseException unused2) {
                return timeUnit.convert(Long.parseLong(str), TimeUnit.SECONDS);
            }
        }
        return defaultValue;
    }
}
