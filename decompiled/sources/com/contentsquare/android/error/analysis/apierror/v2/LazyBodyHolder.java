package com.contentsquare.android.error.analysis.apierror.v2;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.util.JSONBody;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/LazyBodyHolder;", "", "event", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "(Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;)V", "requestBodyJSON", "Lcom/contentsquare/android/error/analysis/util/JSONBody;", "getRequestBodyJSON", "()Lcom/contentsquare/android/error/analysis/util/JSONBody;", "requestBodyJSON$delegate", "Lkotlin/Lazy;", "responseBodyJSON", "getResponseBodyJSON", "responseBodyJSON$delegate", "responseBodyString", "", "getResponseBodyString", "()Ljava/lang/String;", "responseBodyString$delegate", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LazyBodyHolder {

    /* renamed from: requestBodyJSON$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy requestBodyJSON;

    /* renamed from: responseBodyJSON$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy responseBodyJSON;

    /* renamed from: responseBodyString$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy responseBodyString;

    public LazyBodyHolder(final NetworkEvent event, final ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        this.responseBodyString = LazyKt.lazy(new Function0<String>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.LazyBodyHolder$responseBodyString$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                byte[] responseBody = event.getResponseBody();
                if (responseBody != null) {
                    return new String(responseBody, Charsets.UTF_8);
                }
                return null;
            }
        });
        this.responseBodyJSON = LazyKt.lazy(new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.LazyBodyHolder$responseBodyJSON$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                if (event.getResponseBody() == null) {
                    return null;
                }
                LazyBodyHolder lazyBodyHolder = this;
                ApiErrorTelemetrySender apiErrorTelemetrySender = telemetrySender;
                NetworkEvent networkEvent = event;
                if (r0.length < 64000) {
                    return new JSONBody(lazyBodyHolder.getResponseBodyString());
                }
                apiErrorTelemetrySender.sendTelemetry(ApiErrorTelemetrySender.RESPONSE_BODY_ATTR_TOO_LARGE, networkEvent.getRequestBodySize() != null ? r9.intValue() : r0.length, 64000L);
                return null;
            }
        });
        this.requestBodyJSON = LazyKt.lazy(new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.LazyBodyHolder$requestBodyJSON$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                if (event.getRequestBody() == null) {
                    return null;
                }
                NetworkEvent networkEvent = event;
                ApiErrorTelemetrySender apiErrorTelemetrySender = telemetrySender;
                if (r0.length < 64000) {
                    byte[] requestBody = networkEvent.getRequestBody();
                    return new JSONBody(requestBody != null ? new String(requestBody, Charsets.UTF_8) : null);
                }
                apiErrorTelemetrySender.sendTelemetry(ApiErrorTelemetrySender.REQUEST_BODY_ATTR_TOO_LARGE, networkEvent.getRequestBodySize() != null ? r9.intValue() : r0.length, 64000L);
                return null;
            }
        });
    }

    @Nullable
    public final JSONBody getRequestBodyJSON() {
        return (JSONBody) this.requestBodyJSON.getValue();
    }

    @Nullable
    public final JSONBody getResponseBodyJSON() {
        return (JSONBody) this.responseBodyJSON.getValue();
    }

    @Nullable
    public final String getResponseBodyString() {
        return (String) this.responseBodyString.getValue();
    }
}
