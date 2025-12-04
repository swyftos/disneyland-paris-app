package com.urbanairship.http;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bBQ\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JW\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/urbanairship/http/Request;", "", "url", "Landroid/net/Uri;", "method", "", "followRedirects", "", "(Landroid/net/Uri;Ljava/lang/String;Z)V", "auth", "Lcom/urbanairship/http/RequestAuth;", RateAppAction.BODY_KEY, "Lcom/urbanairship/http/RequestBody;", "headers", "", "(Landroid/net/Uri;Ljava/lang/String;Lcom/urbanairship/http/RequestAuth;Lcom/urbanairship/http/RequestBody;Ljava/util/Map;Z)V", "getAuth", "()Lcom/urbanairship/http/RequestAuth;", "getBody", "()Lcom/urbanairship/http/RequestBody;", "getFollowRedirects", "()Z", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Ljava/lang/String;", "getUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class Request {
    private final RequestAuth auth;
    private final RequestBody body;
    private final boolean followRedirects;
    private final Map headers;
    private final String method;
    private final Uri url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Request(@Nullable Uri uri, @NotNull String method) {
        this(uri, method, null, null, null, false, 60, null);
        Intrinsics.checkNotNullParameter(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Request(@Nullable Uri uri, @NotNull String method, @Nullable RequestAuth requestAuth) {
        this(uri, method, requestAuth, null, null, false, 56, null);
        Intrinsics.checkNotNullParameter(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Request(@Nullable Uri uri, @NotNull String method, @Nullable RequestAuth requestAuth, @Nullable RequestBody requestBody) {
        this(uri, method, requestAuth, requestBody, null, false, 48, null);
        Intrinsics.checkNotNullParameter(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Request(@Nullable Uri uri, @NotNull String method, @Nullable RequestAuth requestAuth, @Nullable RequestBody requestBody, @NotNull Map<String, String> headers) {
        this(uri, method, requestAuth, requestBody, headers, false, 32, null);
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
    }

    public static /* synthetic */ Request copy$default(Request request, Uri uri, String str, RequestAuth requestAuth, RequestBody requestBody, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = request.url;
        }
        if ((i & 2) != 0) {
            str = request.method;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            requestAuth = request.auth;
        }
        RequestAuth requestAuth2 = requestAuth;
        if ((i & 8) != 0) {
            requestBody = request.body;
        }
        RequestBody requestBody2 = requestBody;
        if ((i & 16) != 0) {
            map = request.headers;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            z = request.followRedirects;
        }
        return request.copy(uri, str2, requestAuth2, requestBody2, map2, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Uri getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final RequestAuth getAuth() {
        return this.auth;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final RequestBody getBody() {
        return this.body;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.headers;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    @NotNull
    public final Request copy(@Nullable Uri url, @NotNull String method, @Nullable RequestAuth auth, @Nullable RequestBody body, @NotNull Map<String, String> headers, boolean followRedirects) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new Request(url, method, auth, body, headers, followRedirects);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request request = (Request) other;
        return Intrinsics.areEqual(this.url, request.url) && Intrinsics.areEqual(this.method, request.method) && Intrinsics.areEqual(this.auth, request.auth) && Intrinsics.areEqual(this.body, request.body) && Intrinsics.areEqual(this.headers, request.headers) && this.followRedirects == request.followRedirects;
    }

    public int hashCode() {
        Uri uri = this.url;
        int iHashCode = (((uri == null ? 0 : uri.hashCode()) * 31) + this.method.hashCode()) * 31;
        RequestAuth requestAuth = this.auth;
        int iHashCode2 = (iHashCode + (requestAuth == null ? 0 : requestAuth.hashCode())) * 31;
        RequestBody requestBody = this.body;
        return ((((iHashCode2 + (requestBody != null ? requestBody.hashCode() : 0)) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.followRedirects);
    }

    @NotNull
    public String toString() {
        return "Request(url=" + this.url + ", method=" + this.method + ", auth=" + this.auth + ", body=" + this.body + ", headers=" + this.headers + ", followRedirects=" + this.followRedirects + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public Request(@Nullable Uri uri, @NotNull String method, @Nullable RequestAuth requestAuth, @Nullable RequestBody requestBody, @NotNull Map<String, String> headers, boolean z) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = uri;
        this.method = method;
        this.auth = requestAuth;
        this.body = requestBody;
        this.headers = headers;
        this.followRedirects = z;
    }

    @Nullable
    public final Uri getUrl() {
        return this.url;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @Nullable
    public final RequestAuth getAuth() {
        return this.auth;
    }

    @Nullable
    public final RequestBody getBody() {
        return this.body;
    }

    public /* synthetic */ Request(Uri uri, String str, RequestAuth requestAuth, RequestBody requestBody, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? null : requestAuth, (i & 8) != 0 ? null : requestBody, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? true : z);
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(@Nullable Uri uri, @NotNull String method, boolean z) {
        this(uri, method, null, null, MapsKt.emptyMap(), z);
        Intrinsics.checkNotNullParameter(method, "method");
    }
}
