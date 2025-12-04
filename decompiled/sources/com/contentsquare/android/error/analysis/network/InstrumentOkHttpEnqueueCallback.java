package com.contentsquare.android.error.analysis.network;

import androidx.core.app.NotificationCompat;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/InstrumentOkHttpEnqueueCallback;", "Lokhttp3/Callback;", "callback", "startTimeMillis", "", "(Lokhttp3/Callback;J)V", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InstrumentOkHttpEnqueueCallback implements Callback {

    @NotNull
    private static final Logger logger = new Logger("InstrumentOkHttpEnqueueCallback");

    @NotNull
    private final Callback callback;
    private final long startTimeMillis;

    public InstrumentOkHttpEnqueueCallback(Callback callback, long j) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.startTimeMillis = j;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        logger.d(e, "Exception received");
        this.callback.onFailure(call, e);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ErrorAnalysisOkHttpClientKt.sendNetworkMetric(ErrorAnalysis.INSTANCE.getInstance(), response, this.startTimeMillis, System.currentTimeMillis());
        this.callback.onResponse(call, response);
    }
}
