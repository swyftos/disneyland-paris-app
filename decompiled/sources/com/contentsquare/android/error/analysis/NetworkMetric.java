package com.contentsquare.android.error.analysis;

import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010!\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0011J\u001a\u0010$\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013J\u000e\u0010%\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/contentsquare/android/error/analysis/NetworkMetric;", "", "url", "", "httpMethod", "source", "timer", "Lkotlin/Function0;", "", TCVideoEventPropertiesNames.TCV_PUBLISHER, "Lkotlin/Function1;", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "requestBody", "", "requestHeaders", "", "requestTime", "Ljava/lang/Long;", "responseBody", "responseHeaders", "responseTime", "statusCode", "", "Ljava/lang/Integer;", "timestampMs", "checkHttpMethod", "value", "checkSource", "setRequestBody", "setRequestHeaders", "setRequestTime", "setResponseBody", "setResponseHeaders", "setResponseTime", "setStatusCode", ViewProps.START, "stop", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkMetric {

    @NotNull
    private final String httpMethod;

    @NotNull
    private final Logger logger;

    @NotNull
    private final Function1<NetworkEvent, Unit> publisher;

    @Nullable
    private byte[] requestBody;

    @Nullable
    private Map<String, String> requestHeaders;

    @Nullable
    private Long requestTime;

    @Nullable
    private byte[] responseBody;

    @Nullable
    private Map<String, String> responseHeaders;

    @Nullable
    private Long responseTime;

    @NotNull
    private final String source;

    @Nullable
    private Integer statusCode;

    @NotNull
    private final Function0<Long> timer;

    @Nullable
    private Long timestampMs;

    @NotNull
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkMetric(String url, String httpMethod, String source, Function0<Long> timer, Function1<? super NetworkEvent, Unit> publisher) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(publisher, "publisher");
        this.url = url;
        this.httpMethod = httpMethod;
        this.source = source;
        this.timer = timer;
        this.publisher = publisher;
        this.logger = new Logger("NetworkMetric");
    }

    private final String checkHttpMethod(String value) {
        if (ErrorAnalysis.HttpMethod.INSTANCE.getAll$error_analysis_release().contains(value)) {
            return value;
        }
        throw new IllegalArgumentException("Invalid http method: " + value);
    }

    private final String checkSource(String value) {
        if (ErrorAnalysisInterface.NetworkEventSource.INSTANCE.getAll().contains(value)) {
            return value;
        }
        throw new IllegalArgumentException("Invalid API Source: " + value);
    }

    public final void setRequestBody(byte[] requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        this.requestBody = requestBody;
    }

    public final void setRequestHeaders(Map<String, String> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.requestHeaders = requestHeaders;
    }

    public final void setRequestTime(long requestTime) {
        this.requestTime = Long.valueOf(requestTime);
    }

    public final void setResponseBody(byte[] responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.responseBody = responseBody;
    }

    public final void setResponseHeaders(Map<String, String> responseHeaders) {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        this.responseHeaders = responseHeaders;
    }

    public final void setResponseTime(long responseTime) {
        this.responseTime = Long.valueOf(responseTime);
    }

    public final void setStatusCode(int statusCode) {
        this.statusCode = Integer.valueOf(statusCode);
    }

    public final void start() {
        long jLongValue = this.timer.invoke().longValue();
        this.timestampMs = Long.valueOf(jLongValue);
        this.requestTime = Long.valueOf(jLongValue);
    }

    public final void stop() {
        if (this.responseTime == null) {
            this.responseTime = this.timer.invoke();
        }
        try {
            String str = this.url;
            String strCheckHttpMethod = checkHttpMethod(this.httpMethod);
            String strCheckSource = checkSource(this.source);
            Long l = this.timestampMs;
            if (l == null) {
                throw new IllegalArgumentException("Timestamp cannot be null, start method needs to be called");
            }
            long jLongValue = l.longValue();
            Integer num = this.statusCode;
            if (num == null) {
                throw new IllegalArgumentException("Status code cannot be null, setStatusCode method needs to be called");
            }
            int iIntValue = num.intValue();
            Long l2 = this.requestTime;
            if (l2 == null) {
                throw new IllegalArgumentException("Request time cannot be null, start method needs to be called");
            }
            long jLongValue2 = l2.longValue();
            Long l3 = this.responseTime;
            if (l3 == null) {
                throw new IllegalArgumentException("Response time cannot be null, start method needs to be called");
            }
            this.publisher.invoke(new NetworkEvent(jLongValue, strCheckHttpMethod, str, iIntValue, jLongValue2, l3.longValue(), this.requestBody, null, this.responseBody, null, null, null, null, null, null, null, null, null, this.requestHeaders, this.responseHeaders, strCheckSource, null, null, null, null, null, null, null, 266600064, null));
        } catch (IllegalArgumentException e) {
            this.logger.w(e, "Cannot create NetworkEvent");
        }
    }
}
