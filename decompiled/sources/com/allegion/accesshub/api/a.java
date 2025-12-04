package com.allegion.accesshub.api;

import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.exceptions.AlNetworkException;
import com.allegion.accesshub.interfaces.IAlConfig;
import com.allegion.logging.AlLog;
import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: classes2.dex */
final class a implements Interceptor {
    final /* synthetic */ IAlConfig a;

    a(IAlConfig iAlConfig) {
        this.a = iAlConfig;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws AlMAHException, IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        OkHttp3.Request.Builder.build.Enter(builderNewBuilder);
        Request request = builderNewBuilder.build();
        Request.Builder builderNewBuilder2 = request.newBuilder();
        OkHttp3.Request.Builder.build.Enter(builderNewBuilder2);
        RequestBody requestBodyBody = builderNewBuilder2.build().body();
        Buffer buffer = new Buffer();
        if (requestBodyBody != null) {
            requestBodyBody.writeTo(buffer);
        }
        builder.removeHeader("AlHeader");
        try {
            AlMAHHeaderBuilder alMAHHeaderBuilder = AlMAHHeaderBuilder.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            AlMAHApiService alMAHApiService = AlMAHApiService.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(request, "request");
            alMAHHeaderBuilder.headerBuilder(builder, alMAHApiService.determineHeaders$AccessHub_prodRelease(request), requestBodyBody == null ? null : buffer.readUtf8(), this.a);
            OkHttp3.Request.Builder.build.Enter(builder);
            Response response = chain.proceed(builder.build());
            Intrinsics.checkExpressionValueIsNotNull(response, "response");
            alMAHApiService.a(response, this.a);
            return response;
        } catch (AlMAHException e) {
            AlLog.e(e);
            throw new AlNetworkException(e);
        }
    }
}
