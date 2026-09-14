package com.appdynamics.eumagent.runtime.networkrequests;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttp3 {
    public static final String OKHTTP3_INSTRUMENTATION_SOURCE = "AppDynamics.OkHttp3Client";

    public static class OkHttpClient {

        public static class Constructor {

            public static class INIT {
                public static okhttp3.OkHttpClient.Builder WrapLastArg(okhttp3.OkHttpClient.Builder builder) {
                    try {
                        Iterator<Interceptor> it = builder.interceptors().iterator();
                        while (it.hasNext()) {
                            if (it.next() instanceof AppDynamicsInterceptor) {
                                return builder;
                            }
                        }
                        builder.addInterceptor(new AppDynamicsInterceptor());
                    } catch (Throwable th) {
                        ADLog.logAgentError("Failed to add our OkHttp3 interceptor", th);
                    }
                    return builder;
                }
            }
        }
    }

    public static class Request {

        public static class Builder {

            public static class build {
                public static Object Enter(Object obj) {
                    if (!Instrumentation.initializationStarted) {
                        return null;
                    }
                    try {
                        okhttp3.Request.Builder builder = (okhttp3.Request.Builder) obj;
                        for (Map.Entry<String, List<String>> entry : ServerCorrelationHeaders.generate().entrySet()) {
                            Iterator<String> it = entry.getValue().iterator();
                            while (it.hasNext()) {
                                builder.header(entry.getKey(), it.next());
                            }
                        }
                        if (!Instrumentation.isTraceparentHeaderEnabled) {
                            return null;
                        }
                        for (String str : ServerCorrelationHeaders.generateTraceParentHeaderValue()) {
                            builder.header(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, str);
                            builder.addHeader(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, str.split("-")[1]);
                        }
                        return null;
                    } catch (Throwable th) {
                        ADLog.logAgentError("Failed to add correlation headers.", th);
                        return null;
                    }
                }
            }
        }
    }

    public static class AppDynamicsInterceptor implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            HttpRequestTracker httpRequestTrackerBeginHttpRequest;
            RuntimeException runtimeException;
            IOException e;
            Response responseProceed;
            okhttp3.Request request = chain.request();
            try {
                httpRequestTrackerBeginHttpRequest = Instrumentation.beginHttpRequest(request.url().url());
                try {
                    httpRequestTrackerBeginHttpRequest.withInstrumentationSource(OkHttp3.OKHTTP3_INSTRUMENTATION_SOURCE).withRequestHeaderFields(request.headers().toMultimap());
                } catch (Throwable th) {
                    th = th;
                    ADLog.logAgentError("Failed to create a OkHttp3 tracker", th);
                }
            } catch (Throwable th2) {
                th = th2;
                httpRequestTrackerBeginHttpRequest = null;
            }
            try {
                responseProceed = chain.proceed(request);
                e = null;
                runtimeException = null;
            } catch (IOException e2) {
                e = e2;
                runtimeException = null;
                responseProceed = null;
            } catch (RuntimeException e3) {
                runtimeException = e3;
                e = null;
                responseProceed = null;
            }
            if (httpRequestTrackerBeginHttpRequest != null) {
                try {
                    if (e != null) {
                        httpRequestTrackerBeginHttpRequest.withException(e).reportDone();
                    } else if (runtimeException != null) {
                        httpRequestTrackerBeginHttpRequest.withException(runtimeException).reportDone();
                    } else {
                        int iCode = responseProceed.code();
                        httpRequestTrackerBeginHttpRequest.withResponseCode(iCode).withStatusLine(iCode >= 400 ? responseProceed.message() : null).withResponseHeaderFields(responseProceed.headers().toMultimap()).reportDone();
                    }
                    if (Instrumentation.isTraceparentHeaderEnabled) {
                        httpRequestTrackerBeginHttpRequest.withUserData(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, request.header(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER)).withUserData(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, request.header(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER));
                    }
                } catch (Throwable th3) {
                    ADLog.logAgentError("Failed to report OkHttp3 tracker", th3);
                }
            }
            if (e != null) {
                throw e;
            }
            if (runtimeException == null) {
                return responseProceed;
            }
            throw runtimeException;
        }
    }
}
