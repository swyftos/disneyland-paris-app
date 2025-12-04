package com.contentsquare.android.error.analysis.apierror.v2;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J,\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/EventProcessorPerformanceManager;", "", "msTimer", "Lkotlin/Function0;", "", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "(Lkotlin/jvm/functions/Function0;Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;)V", "isBodyAttributeCollectionEnabled", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "onProcessingTimeTooLong", "", "event", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "processedEvent", "processingTime", "processEvent", "process", "Lkotlin/Function2;", "metricLevel", "", "", "threshold", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EventProcessorPerformanceManager {
    private static final long BODY_SIZE_THRESHOLD = 20000;

    @NotNull
    public static final String LOG_EVENT_DURATION_LEVEL = "durationLevel";

    @NotNull
    public static final String LOG_EVENT_ENDPOINT = "endpoint";

    @NotNull
    public static final String LOG_EVENT_PROCESS_DURATION = "processDuration";

    @NotNull
    public static final String LOG_EVENT_REQUEST_BODY_SIZE = "requestBodySize";

    @NotNull
    public static final String LOG_EVENT_RESPONSE_BODY_SIZE = "responseBodySize";
    private static final int METRIC_LEVEL_0 = 0;
    private static final int METRIC_LEVEL_1 = 1;
    private static final int METRIC_LEVEL_2 = 2;
    private static final int METRIC_LEVEL_3 = 3;
    public static final long PROCESSING_TIME_THRESHOLD_MS = 50;
    private boolean isBodyAttributeCollectionEnabled;

    @NotNull
    private final Logger logger;

    @NotNull
    private final Function0<Long> msTimer;

    @NotNull
    private final ApiErrorTelemetrySender telemetrySender;

    @NotNull
    private static final ClosedFloatingPointRange<Double> METRIC_RANGE_1 = RangesKt.rangeTo(Double.NEGATIVE_INFINITY, 1.0d);

    @NotNull
    private static final ClosedFloatingPointRange<Double> METRIC_RANGE_2 = RangesKt.rangeTo(1.0d, 2.0d);

    @NotNull
    private static final ClosedFloatingPointRange<Double> METRIC_RANGE_3 = RangesKt.rangeTo(2.0d, 4.0d);

    public EventProcessorPerformanceManager(Function0<Long> msTimer, ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(msTimer, "msTimer");
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        this.msTimer = msTimer;
        this.telemetrySender = telemetrySender;
        this.isBodyAttributeCollectionEnabled = true;
        this.logger = new Logger("EventProcessorPerformanceManager");
    }

    private final int metricLevel(Number number, long j) {
        double dDoubleValue = j == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : number.doubleValue() / j;
        if (METRIC_RANGE_1.contains(Double.valueOf(dDoubleValue))) {
            return 0;
        }
        if (METRIC_RANGE_2.contains(Double.valueOf(dDoubleValue))) {
            return 1;
        }
        return METRIC_RANGE_3.contains(Double.valueOf(dDoubleValue)) ? 2 : 3;
    }

    private final void onProcessingTimeTooLong(NetworkEvent event, NetworkEvent processedEvent, long processingTime) {
        Integer responseBodySize;
        Integer requestBodySize;
        if (this.isBodyAttributeCollectionEnabled) {
            this.isBodyAttributeCollectionEnabled = false;
            this.logger.i("API Processing disabling body attribute collection");
            this.telemetrySender.sendLogMonitor(event, processingTime);
        }
        this.telemetrySender.sendCollectionDuration(new ApiErrorCollectionDuration(processingTime, metricLevel(Long.valueOf(processingTime), 50L), (processedEvent == null || (requestBodySize = processedEvent.getRequestBodySize()) == null) ? null : Integer.valueOf(metricLevel(requestBodySize, 20000L)), (processedEvent == null || (responseBodySize = processedEvent.getResponseBodySize()) == null) ? null : Integer.valueOf(metricLevel(responseBodySize, 20000L))));
    }

    @Nullable
    public final NetworkEvent processEvent(NetworkEvent event, Function2<? super NetworkEvent, ? super Boolean, NetworkEvent> process) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(process, "process");
        long jLongValue = this.msTimer.invoke().longValue();
        NetworkEvent networkEventInvoke = process.invoke(event, Boolean.valueOf(this.isBodyAttributeCollectionEnabled));
        long jLongValue2 = this.msTimer.invoke().longValue() - jLongValue;
        this.logger.i("API Processing took " + jLongValue2 + "ms");
        if (jLongValue2 > 50) {
            onProcessingTimeTooLong(event, networkEventInvoke, jLongValue2);
        }
        return networkEventInvoke;
    }
}
