package com.contentsquare.android.core.features.http;

import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\n¨\u0006,"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpResponse;", "", "()V", "dataReceivedBytes", "", "getDataReceivedBytes", "()J", "dataSentBytes", "getDataSentBytes", "setDataSentBytes", "(J)V", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "getEndpoint", "()Ljava/lang/String;", "setEndpoint", "(Ljava/lang/String;)V", "exception", "", "getException", "()Ljava/lang/Throwable;", "setException", "(Ljava/lang/Throwable;)V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "stringResponse", "getStringResponse", "setStringResponse", "timeSpentMsec", "getTimeSpentMsec", "setTimeSpentMsec", "success", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HttpResponse {
    private long dataSentBytes;

    @Nullable
    private Throwable exception;

    @Nullable
    private String stringResponse;
    private long timeSpentMsec;

    @NotNull
    private String endpoint = "";

    @NotNull
    private Map<String, ? extends List<String>> headers = MapsKt.emptyMap();
    private int status = -1;

    public final long getDataReceivedBytes() {
        String str = this.stringResponse;
        if (str != null) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            if (bytes != null) {
                return bytes.length;
            }
        }
        return 0L;
    }

    public final long getDataSentBytes() {
        return this.dataSentBytes;
    }

    @NotNull
    public final String getEndpoint() {
        return this.endpoint;
    }

    @Nullable
    public final Throwable getException() {
        return this.exception;
    }

    @NotNull
    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final String getStringResponse() {
        return this.stringResponse;
    }

    public final long getTimeSpentMsec() {
        return this.timeSpentMsec;
    }

    public final void setDataSentBytes(long j) {
        this.dataSentBytes = j;
    }

    public final void setEndpoint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endpoint = str;
    }

    public final void setException(Throwable th) {
        this.exception = th;
    }

    public final void setHeaders(Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setStringResponse(String str) {
        this.stringResponse = str;
    }

    public final void setTimeSpentMsec(long j) {
        this.timeSpentMsec = j;
    }

    public final boolean success() {
        return HttpStatusCode.INSTANCE.checkStatus(this.status) == HttpStatusCodeCategory.SUCCESS;
    }
}
