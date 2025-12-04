package com.contentsquare.android.error.analysis.crash;

import androidx.annotation.WorkerThread;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.picocontainer.Characteristics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/CrashDataUploader;", "", "httpConnection", "Lcom/contentsquare/android/core/features/http/HttpConnection;", "(Lcom/contentsquare/android/core/features/http/HttpConnection;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "sendToBackend", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "data", "", "isLogVisualizerEnabled", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CrashDataUploader {

    @NotNull
    public static final String CRASH_EVENT_PROTOBUF_VERSION = "1";

    @NotNull
    private final HttpConnection httpConnection;

    @NotNull
    private final Logger logger;

    public CrashDataUploader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ boolean sendToBackend$default(CrashDataUploader crashDataUploader, String str, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return crashDataUploader.sendToBackend(str, bArr, z);
    }

    @WorkerThread
    public final boolean sendToBackend(String endpoint, byte[] data, boolean isLogVisualizerEnabled) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isLogVisualizerEnabled) {
            linkedHashMap.put("cs-log-request", Characteristics.TRUE);
        }
        Throwable exception = this.httpConnection.performPostWithProto(endpoint, data, "1", linkedHashMap).getException();
        if (exception == null) {
            return true;
        }
        this.logger.e(exception, "Failed to send the crash event data to: " + endpoint);
        return false;
    }

    public CrashDataUploader(HttpConnection httpConnection) {
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        this.httpConnection = httpConnection;
        this.logger = new Logger("CrashDataUploader");
    }

    public /* synthetic */ CrashDataUploader(HttpConnection httpConnection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HttpConnection() : httpConnection);
    }
}
