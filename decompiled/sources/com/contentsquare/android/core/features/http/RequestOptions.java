package com.contentsquare.android.core.features.http;

import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/features/http/RequestOptions;", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "headers", "", "timeoutConnect", "", "timeoutRead", "(Ljava/lang/String;Ljava/util/Map;II)V", "getEndpoint", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getTimeoutConnect", "()I", "getTimeoutRead", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestOptions {

    @NotNull
    private final String endpoint;

    @NotNull
    private final Map<String, String> headers;
    private final int timeoutConnect;
    private final int timeoutRead;

    public RequestOptions(String endpoint, Map<String, String> headers, int i, int i2) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.endpoint = endpoint;
        this.headers = headers;
        this.timeoutConnect = i;
        this.timeoutRead = i2;
    }

    @NotNull
    public final String getEndpoint() {
        return this.endpoint;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getTimeoutConnect() {
        return this.timeoutConnect;
    }

    public final int getTimeoutRead() {
        return this.timeoutRead;
    }

    public /* synthetic */ RequestOptions(String str, Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? MapsKt.emptyMap() : map, (i3 & 4) != 0 ? 1000 : i, (i3 & 8) != 0 ? 10000 : i2);
    }
}
