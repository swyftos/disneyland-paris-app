package com.contentsquare.android.error.analysis.network;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.contentsquare.android.error.analysis.util.OkHttpExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"sendNetworkMetric", "", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "response", "Lokhttp3/Response;", "requestStartTime", "", "responseEndTime", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorAnalysisOkHttpClientKt {
    public static final void sendNetworkMetric(ErrorAnalysis errorAnalysis, Response response, long j, long j2) {
        Intrinsics.checkNotNullParameter(errorAnalysis, "<this>");
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            Request request = response.request();
            String strMethod = request.method();
            String url = request.url().getUrl();
            int iCode = response.code();
            byte[] bArrBodyToBytes = OkHttpExtensionsKt.bodyToBytes(request);
            RequestBody requestBodyBody = request.body();
            Integer numValueOf = requestBodyBody != null ? Integer.valueOf((int) requestBodyBody.contentLength()) : null;
            byte[] bArrBodyToBytes2 = OkHttpExtensionsKt.bodyToBytes(response);
            ResponseBody responseBodyBody = response.body();
            errorAnalysis.sendEvent(new NetworkEvent(j, strMethod, url, iCode, j, j2, bArrBodyToBytes, numValueOf, bArrBodyToBytes2, responseBodyBody != null ? Integer.valueOf((int) responseBodyBody.getContentLength()) : null, null, null, null, null, null, null, null, null, request.headers().size() > 0 ? MapsKt.toMap(request.headers()) : null, response.headers().size() > 0 ? MapsKt.toMap(response.headers()) : null, "native", null, null, null, null, null, null, null, 266599424, null));
        } catch (Throwable th) {
            new Logger("ErrorAnalysis").d(th, "Exception received while collecting and sending network metric");
        }
    }
}
