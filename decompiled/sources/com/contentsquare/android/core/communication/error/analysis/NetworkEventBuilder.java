package com.contentsquare.android.core.communication.error.analysis;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010!\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u001a\u0010%\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u001c\u0010'\u001a\u00020\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\u001c\u0010(\u001a\u00020\u00002\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\b\u0010-\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "", "()V", "code", "", "customRequestHeaders", "", "customResponseHeaders", "method", "requestBody", "", "requestHeaders", "", "requestStartTimeMillis", "", "responseBody", "responseHeaders", "source", "getSource$annotations", "standardRequestHeaders", "standardResponseHeaders", "timeToRequestCompletedMillis", "timeToResponseCompletedMillis", "timeToResponseInitiatedMillis", "url", "build", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "getTimeToResponseInitiatedMillis", "setCustomRequestHeaders", "setCustomResponseHeaders", "setHttpMethod", "setHttpResponseCode", "setRequestBody", "setRequestHeaders", "setRequestStartTimeMillis", "time", "setResponseBody", "setResponseHeaders", "setSource", "setStandardRequestHeaders", "setStandardResponseHeaders", "setTimeToRequestCompletedMillis", "setTimeToResponseCompletedMillis", "setTimeToResponseInitiatedMillis", "setUrl", "toString", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkEventBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int code;

    @Nullable
    private String customRequestHeaders;

    @Nullable
    private String customResponseHeaders;

    @Nullable
    private String method;

    @Nullable
    private byte[] requestBody;

    @Nullable
    private Map<String, String> requestHeaders;
    private long requestStartTimeMillis;

    @Nullable
    private byte[] responseBody;

    @Nullable
    private Map<String, String> responseHeaders;

    @NotNull
    private String source = "native";

    @Nullable
    private Map<String, String> standardRequestHeaders;

    @Nullable
    private Map<String, String> standardResponseHeaders;
    private long timeToRequestCompletedMillis;
    private long timeToResponseCompletedMillis;
    private long timeToResponseInitiatedMillis;

    @Nullable
    private String url;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder$Companion;", "", "()V", "builder", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEventBuilder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final NetworkEventBuilder builder() {
            return new NetworkEventBuilder();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @NotNull
    public static final NetworkEventBuilder builder() {
        return INSTANCE.builder();
    }

    private static /* synthetic */ void getSource$annotations() {
    }

    @Nullable
    public final NetworkEvent build() {
        byte[] bArr;
        byte[] bArr2;
        String str = this.method;
        String str2 = this.url;
        if (str == null || str2 == null) {
            return null;
        }
        long j = this.requestStartTimeMillis;
        int i = this.code;
        long j2 = this.timeToResponseCompletedMillis;
        String str3 = this.source;
        byte[] bArr3 = this.requestBody;
        Integer numValueOf = bArr3 != null ? Integer.valueOf(bArr3.length) : null;
        byte[] bArr4 = this.responseBody;
        Integer numValueOf2 = bArr4 != null ? Integer.valueOf(bArr4.length) : null;
        Map<String, String> map = this.requestHeaders;
        Map<String, String> map2 = this.responseHeaders;
        Map<String, String> map3 = this.standardRequestHeaders;
        Map<String, String> map4 = this.standardResponseHeaders;
        String str4 = this.customResponseHeaders;
        if (str4 != null) {
            byte[] bytes = str4.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr = bytes;
        } else {
            bArr = null;
        }
        String str5 = this.customRequestHeaders;
        if (str5 != null) {
            byte[] bytes2 = str5.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            bArr2 = bytes2;
        } else {
            bArr2 = null;
        }
        return new NetworkEvent(j, str, str2, i, j, j2, bArr3, numValueOf, bArr4, numValueOf2, map3, map4, bArr2, bArr, null, null, null, null, map, map2, str3, null, null, null, null, null, null, null, 266584064, null);
    }

    public final long getTimeToResponseInitiatedMillis() {
        return this.timeToResponseInitiatedMillis;
    }

    @NotNull
    public final NetworkEventBuilder setCustomRequestHeaders(String customRequestHeaders) {
        this.customRequestHeaders = customRequestHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setCustomResponseHeaders(String customResponseHeaders) {
        this.customResponseHeaders = customResponseHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setHttpMethod(String method) {
        this.method = method;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setHttpResponseCode(int code) {
        this.code = code;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setRequestBody(byte[] requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setRequestHeaders(Map<String, String> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.requestHeaders = requestHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setRequestStartTimeMillis(long time) {
        this.requestStartTimeMillis = time;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setResponseBody(byte[] responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.responseBody = responseBody;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setResponseHeaders(Map<String, String> responseHeaders) {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        this.responseHeaders = responseHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setSource(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setStandardRequestHeaders(Map<String, String> standardRequestHeaders) {
        this.standardRequestHeaders = standardRequestHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setStandardResponseHeaders(Map<String, String> standardResponseHeaders) {
        this.standardResponseHeaders = standardResponseHeaders;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setTimeToRequestCompletedMillis(long time) {
        this.timeToRequestCompletedMillis = time;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setTimeToResponseCompletedMillis(long time) {
        this.timeToResponseCompletedMillis = time;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setTimeToResponseInitiatedMillis(long time) {
        this.timeToResponseInitiatedMillis = time;
        return this;
    }

    @NotNull
    public final NetworkEventBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @NotNull
    public String toString() {
        return "NetworkEventBuilder{url='" + this.url + "', method='" + this.method + "', code=" + this.code + ", requestStartTimeMicros=" + this.requestStartTimeMillis + ", timeToRequestCompletedMicros=" + this.timeToRequestCompletedMillis + ", timeToResponseInitiatedMicros=" + this.timeToResponseInitiatedMillis + ", timeToResponseCompletedMicros=" + this.timeToResponseCompletedMillis + ", source=" + this.source + ", requestBody=" + this.requestBody + ", responseBody=" + this.responseBody + ", requestHeaders=" + this.requestHeaders + ", responseHeaders=" + this.responseHeaders + '}';
    }
}
