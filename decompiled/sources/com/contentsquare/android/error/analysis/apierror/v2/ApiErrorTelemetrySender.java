package com.contentsquare.android.error.analysis.apierror.v2;

import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "", "errorAnalysisLibraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;)V", "sendCollectionDuration", "", "data", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorCollectionDuration;", "sendLogMonitor", "event", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "processingTime", "", "sendTelemetry", "name", "", TCEventPropertiesNames.TCP_SIZE, "maxSize", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiErrorTelemetrySender {

    @NotNull
    public static final String API_ERROR_COLLECTION_DURATION = "api_error_collection_duration";
    public static final int DURATION_LEVEL_1 = 1;
    public static final int DURATION_LEVEL_1_THRESHOLD = 70;
    public static final int DURATION_LEVEL_2 = 2;
    public static final int DURATION_LEVEL_2_THRESHOLD = 100;
    public static final int DURATION_LEVEL_3 = 3;

    @NotNull
    public static final String ENCRYPTED_REQUEST_HEADERS_TOO_LARGE = "encrypted_request_headers_max_size_exceeded";

    @NotNull
    public static final String ENCRYPTED_RESPONSE_HEADERS_TOO_LARGE = "encrypted_response_headers_max_size_exceeded";

    @NotNull
    public static final String PLAIN_REQUEST_HEADERS_TOO_LARGE = "plain_request_headers_max_size_exceeded";

    @NotNull
    public static final String PLAIN_RESPONSE_HEADERS_TOO_LARGE = "plain_response_headers_max_size_exceeded";

    @NotNull
    public static final String QUERY_PARAMS_TOO_LARGE = "query_params_max_size_exceeded";
    public static final int RANGE_1_VALUE = 1;
    public static final int RANGE_2_VALUE = 2;
    public static final int RANGE_3_VALUE = 3;

    @NotNull
    public static final String REQUEST_BODY_ATTR_TOO_LARGE = "request_body_attribute_max_size_exceeded";

    @NotNull
    public static final String REQUEST_BODY_ATTR_VALUE_TOO_LARGE = "request_body_attribute_value_max_size_exceeded";

    @NotNull
    public static final String REQUEST_BODY_TOO_LARGE = "request_body_max_size_exceeded";

    @NotNull
    public static final String RESPONSE_BODY_ATTR_TOO_LARGE = "response_body_attribute_max_size_exceeded";

    @NotNull
    public static final String RESPONSE_BODY_ATTR_VALUE_TOO_LARGE = "response_body_attribute_value_max_size_exceeded";

    @NotNull
    public static final String RESPONSE_BODY_TOO_LARGE = "response_body_max_size_exceeded";

    @NotNull
    private final ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ClosedFloatingPointRange<Double> RANGE_1 = RangesKt.rangeTo(Double.NEGATIVE_INFINITY, 0.4d);

    @NotNull
    private static final ClosedFloatingPointRange<Double> RANGE_2 = RangesKt.rangeTo(0.4d, 1.0d);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender$Companion;", "", "()V", "API_ERROR_COLLECTION_DURATION", "", "DURATION_LEVEL_1", "", "DURATION_LEVEL_1_THRESHOLD", "DURATION_LEVEL_2", "DURATION_LEVEL_2_THRESHOLD", "DURATION_LEVEL_3", "ENCRYPTED_REQUEST_HEADERS_TOO_LARGE", "ENCRYPTED_RESPONSE_HEADERS_TOO_LARGE", "PLAIN_REQUEST_HEADERS_TOO_LARGE", "PLAIN_RESPONSE_HEADERS_TOO_LARGE", "QUERY_PARAMS_TOO_LARGE", "RANGE_1", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getRANGE_1", "()Lkotlin/ranges/ClosedFloatingPointRange;", "RANGE_1_VALUE", "RANGE_2", "getRANGE_2", "RANGE_2_VALUE", "RANGE_3_VALUE", "REQUEST_BODY_ATTR_TOO_LARGE", "REQUEST_BODY_ATTR_VALUE_TOO_LARGE", "REQUEST_BODY_TOO_LARGE", "RESPONSE_BODY_ATTR_TOO_LARGE", "RESPONSE_BODY_ATTR_VALUE_TOO_LARGE", "RESPONSE_BODY_TOO_LARGE", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ClosedFloatingPointRange<Double> getRANGE_1() {
            return ApiErrorTelemetrySender.RANGE_1;
        }

        @NotNull
        public final ClosedFloatingPointRange<Double> getRANGE_2() {
            return ApiErrorTelemetrySender.RANGE_2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ApiErrorTelemetrySender(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface) {
        Intrinsics.checkNotNullParameter(errorAnalysisLibraryInterface, "errorAnalysisLibraryInterface");
        this.errorAnalysisLibraryInterface = errorAnalysisLibraryInterface;
    }

    public final void sendCollectionDuration(ApiErrorCollectionDuration data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.errorAnalysisLibraryInterface.telemetryCollect(API_ERROR_COLLECTION_DURATION, data);
    }

    public final void sendLogMonitor(NetworkEvent event, long processingTime) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = processingTime < 70 ? 1 : processingTime < 100 ? 2 : 3;
        ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface = this.errorAnalysisLibraryInterface;
        ErrorAnalysisLibraryInterface.LogLevel logLevel = ErrorAnalysisLibraryInterface.LogLevel.WARN;
        Pair pair = TuplesKt.to(EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, event.getUrl());
        Pair pair2 = TuplesKt.to(EventProcessorPerformanceManager.LOG_EVENT_PROCESS_DURATION, Long.valueOf(processingTime));
        byte[] requestBody = event.getRequestBody();
        Pair pair3 = TuplesKt.to(EventProcessorPerformanceManager.LOG_EVENT_REQUEST_BODY_SIZE, Integer.valueOf(requestBody != null ? requestBody.length : 0));
        byte[] responseBody = event.getResponseBody();
        ErrorAnalysisLibraryInterface.DefaultImpls.storeLogEvent$default(errorAnalysisLibraryInterface, logLevel, "Disabling body attributes collection due to high impact", null, null, null, MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to(EventProcessorPerformanceManager.LOG_EVENT_RESPONSE_BODY_SIZE, Integer.valueOf(responseBody != null ? responseBody.length : 0)), TuplesKt.to(EventProcessorPerformanceManager.LOG_EVENT_DURATION_LEVEL, Integer.valueOf(i))), 28, null);
    }

    public final void sendTelemetry(String name, long size, long maxSize) {
        Intrinsics.checkNotNullParameter(name, "name");
        float f = maxSize == 0 ? BitmapDescriptorFactory.HUE_RED : (size - maxSize) / maxSize;
        this.errorAnalysisLibraryInterface.telemetryCollect(name, Integer.valueOf(RangesKt.doubleRangeContains(RANGE_1, f) ? 1 : RangesKt.doubleRangeContains(RANGE_2, f) ? 2 : 3));
    }
}
