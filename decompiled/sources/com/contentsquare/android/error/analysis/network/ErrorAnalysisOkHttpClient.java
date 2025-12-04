package com.contentsquare.android.error.analysis.network;

import androidx.core.app.NotificationCompat;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/ErrorAnalysisOkHttpClient;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "enqueue", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "callback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorAnalysisOkHttpClient {

    @NotNull
    public static final ErrorAnalysisOkHttpClient INSTANCE = new ErrorAnalysisOkHttpClient();

    @NotNull
    private static final Logger logger = new Logger("ErrorAnalysisOkHttpClient");

    private ErrorAnalysisOkHttpClient() {
    }

    @JvmStatic
    public static final void enqueue(Call call, Callback callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (ErrorAnalysis.INSTANCE.getInstance().isEnabled()) {
            call.enqueue(new InstrumentOkHttpEnqueueCallback(callback, System.currentTimeMillis()));
        } else {
            call.enqueue(callback);
        }
    }

    @JvmStatic
    @NotNull
    public static final Response execute(Call call) throws IOException {
        Intrinsics.checkNotNullParameter(call, "call");
        ErrorAnalysis.Companion companion = ErrorAnalysis.INSTANCE;
        if (!companion.getInstance().isEnabled()) {
            return call.execute();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Response responseExecute = call.execute();
            ErrorAnalysisOkHttpClientKt.sendNetworkMetric(companion.getInstance(), responseExecute, jCurrentTimeMillis, System.currentTimeMillis());
            return responseExecute;
        } catch (IOException e) {
            logger.d(e, "Exception received");
            throw e;
        }
    }
}
