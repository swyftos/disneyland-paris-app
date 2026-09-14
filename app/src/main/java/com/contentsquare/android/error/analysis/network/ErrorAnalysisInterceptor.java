package com.contentsquare.android.error.analysis.network;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\b\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lcom/contentsquare/android/error/analysis/network/ErrorAnalysisInterceptor;", "Lokhttp3/Interceptor;", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "errorAnalysis", "Lkotlin/Function0;", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "(Lcom/contentsquare/android/core/features/logging/Logger;Lkotlin/jvm/functions/Function0;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "error-analysis_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class ErrorAnalysisInterceptor implements Interceptor {

    @NotNull
    private final Function0<ErrorAnalysis> errorAnalysis;

    @NotNull
    private final Logger logger;

    /* JADX INFO: renamed from: com.contentsquare.android.error.analysis.network.ErrorAnalysisInterceptor$1 */
    @Metadata(m1837k = 3, m1838mv = {1, 8, 0}, m1840xi = 48)
    public /* synthetic */ class C24041 extends FunctionReferenceImpl implements Function0<ErrorAnalysis> {
        public C24041(Object obj) {
            super(0, obj, ErrorAnalysis.Companion.class, "getInstance", "getInstance()Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ErrorAnalysis invoke() {
            return ((ErrorAnalysis.Companion) this.receiver).getInstance();
        }
    }

    public ErrorAnalysisInterceptor() {
        this.errorAnalysis = new C24041(ErrorAnalysis.INSTANCE);
        this.logger = new Logger("ErrorAnalysisInterceptor");
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.logger.m827d("Sending request " + request.url());
        try {
            Response responseProceed = chain.proceed(request);
            ErrorAnalysisOkHttpClientKt.sendNetworkMetric(this.errorAnalysis.invoke(), responseProceed, jCurrentTimeMillis, System.currentTimeMillis());
            return responseProceed;
        } catch (IOException e) {
            this.logger.m827d("Exception received = " + e);
            throw e;
        }
    }

    @VisibleForTesting
    public ErrorAnalysisInterceptor(Logger logger, Function0<ErrorAnalysis> errorAnalysis) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(errorAnalysis, "errorAnalysis");
        this.logger = logger;
        this.errorAnalysis = errorAnalysis;
    }
}
