package com.contentsquare.android.core.features.http;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011J,\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J,\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011J4\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpConnection;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "eTag", "", "Lcom/contentsquare/android/core/features/http/HttpResponse;", "getETag", "(Lcom/contentsquare/android/core/features/http/HttpResponse;)Ljava/lang/String;", "logPublicError", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "exception", "", "performHttpGet", "headers", "", "performHttpPost", "requestData", "", "performPostWithJson", "jsonString", "performPostWithProto", "payload", "protoVersion", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHttpConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpConnection.kt\ncom/contentsquare/android/core/features/http/HttpConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpConnection {

    @NotNull
    private static final MutableSharedFlow<HttpResponse> internalResponseFlow;

    @NotNull
    private static final Flow<HttpResponse> responseFlow;

    @NotNull
    private final Logger logger = new Logger("HttpConnection");

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static HttpRequestHandler requestHandler = new HttpRequestHandlerDefault();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpConnection$Companion;", "", "()V", "internalResponseFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/contentsquare/android/core/features/http/HttpResponse;", "getInternalResponseFlow$core_release$annotations", "getInternalResponseFlow$core_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "requestHandler", "Lcom/contentsquare/android/core/features/http/HttpRequestHandler;", "getRequestHandler$core_release", "()Lcom/contentsquare/android/core/features/http/HttpRequestHandler;", "setRequestHandler$core_release", "(Lcom/contentsquare/android/core/features/http/HttpRequestHandler;)V", "responseFlow", "Lkotlinx/coroutines/flow/Flow;", "getResponseFlow", "()Lkotlinx/coroutines/flow/Flow;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getInternalResponseFlow$core_release$annotations() {
        }

        @NotNull
        public final MutableSharedFlow<HttpResponse> getInternalResponseFlow$core_release() {
            return HttpConnection.internalResponseFlow;
        }

        @NotNull
        public final HttpRequestHandler getRequestHandler$core_release() {
            return HttpConnection.requestHandler;
        }

        @NotNull
        public final Flow<HttpResponse> getResponseFlow() {
            return HttpConnection.responseFlow;
        }

        public final void setRequestHandler$core_release(HttpRequestHandler httpRequestHandler) {
            Intrinsics.checkNotNullParameter(httpRequestHandler, "<set-?>");
            HttpConnection.requestHandler = httpRequestHandler;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        MutableSharedFlow<HttpResponse> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(5, 0, null, 6, null);
        internalResponseFlow = mutableSharedFlowMutableSharedFlow$default;
        responseFlow = mutableSharedFlowMutableSharedFlow$default;
    }

    private final String getETag(HttpResponse httpResponse) {
        List<String> list = httpResponse.getHeaders().get("ETag");
        if (list != null) {
            return (String) CollectionsKt.firstOrNull((List) list);
        }
        return null;
    }

    private final void logPublicError(String endpoint, Throwable exception) {
        this.logger.p("[ERROR] Contentsquare failed to execute request with endpoint [" + endpoint + "]: " + exception.getMessage() + AbstractJsonLexerKt.END_LIST);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse performHttpGet$default(HttpConnection httpConnection, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return httpConnection.performHttpGet(str, map);
    }

    private final HttpResponse performHttpPost(String endpoint, byte[] requestData, Map<String, String> headers) {
        this.logger.d("Prepare HTTP POST for " + endpoint);
        RequestOptions requestOptions = new RequestOptions(endpoint, headers, 0, 0, 12, null);
        HttpResponse httpResponseHandlePost = requestHandler.handlePost(requestOptions, requestData);
        this.logger.d("Response HTTP POST: status " + httpResponseHandlePost.getStatus() + " for " + requestOptions.getEndpoint());
        int status = httpResponseHandlePost.getStatus();
        if ((400 <= status && status < 600) || httpResponseHandlePost.getStatus() == -1) {
            if (httpResponseHandlePost.getException() == null) {
                httpResponseHandlePost.setException(new UnsupportedOperationException("Exception while POST request: " + httpResponseHandlePost.getStatus()));
            }
            String endpoint2 = requestOptions.getEndpoint();
            Throwable exception = httpResponseHandlePost.getException();
            Intrinsics.checkNotNull(exception);
            logPublicError(endpoint2, exception);
        }
        internalResponseFlow.tryEmit(httpResponseHandlePost);
        return httpResponseHandlePost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse performPostWithJson$default(HttpConnection httpConnection, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return httpConnection.performPostWithJson(str, str2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse performPostWithProto$default(HttpConnection httpConnection, String str, byte[] bArr, String str2, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        return httpConnection.performPostWithProto(str, bArr, str2, map);
    }

    @NotNull
    public final HttpResponse performHttpGet(String endpoint, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.logger.d("Prepare HTTP GET for " + endpoint);
        RequestOptions requestOptions = new RequestOptions(endpoint, headers, 0, 0, 12, null);
        HttpResponse httpResponseHandleGet = requestHandler.handleGet(requestOptions);
        String eTag = getETag(httpResponseHandleGet);
        String strConcat = eTag != null ? "\n Http-not-modified: cached response still valid with ETag ".concat(eTag) : null;
        if (strConcat == null) {
            strConcat = "";
        }
        this.logger.d(httpResponseHandleGet.getStatus() + " HTTP response for " + requestOptions.getEndpoint() + ' ' + strConcat);
        int status = httpResponseHandleGet.getStatus();
        if ((400 <= status && status < 600) || httpResponseHandleGet.getStatus() == -1) {
            if (httpResponseHandleGet.getException() == null) {
                httpResponseHandleGet.setException(new UnsupportedOperationException("Exception while GET request: " + httpResponseHandleGet.getStatus()));
            }
            this.logger.e(httpResponseHandleGet.getException(), "Exception while processing Http GET request on $" + requestOptions.getEndpoint());
            String endpoint2 = requestOptions.getEndpoint();
            Throwable exception = httpResponseHandleGet.getException();
            Intrinsics.checkNotNull(exception);
            logPublicError(endpoint2, exception);
        }
        internalResponseFlow.tryEmit(httpResponseHandleGet);
        return httpResponseHandleGet;
    }

    @NotNull
    public final HttpResponse performPostWithJson(String endpoint, String jsonString, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Map<String, String> mutableMap = MapsKt.toMutableMap(headers);
        StringBuilder sb = new StringBuilder("application/json; charset=");
        Charset charset = Charsets.UTF_8;
        sb.append(charset.name());
        mutableMap.put("Content-Type", sb.toString());
        byte[] bytes = jsonString.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return performHttpPost(endpoint, bytes, mutableMap);
    }

    @NotNull
    public final HttpResponse performPostWithProto(String endpoint, byte[] payload, String protoVersion, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(protoVersion, "protoVersion");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Map<String, String> mutableMap = MapsKt.toMutableMap(headers);
        mutableMap.put("Content-Type", "application/x-protobuf");
        mutableMap.put("Content-Encoding", "gzip");
        mutableMap.put("X-Proto-Schema-Version", protoVersion);
        return performHttpPost(endpoint, payload, mutableMap);
    }
}
