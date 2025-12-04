package com.appdynamics.eumagent.runtime.networkrequests;

import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: classes2.dex */
public class OkHttp3 {
    public static final String OKHTTP3_INSTRUMENTATION_SOURCE = "AppDynamics.OkHttp3Client";

    public static class OkHttpClient {

        public static class Constructor {

            public static class INIT {
                public static OkHttpClient.Builder WrapLastArg(OkHttpClient.Builder builder) {
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
                        Request.Builder builder = (Request.Builder) obj;
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
        /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:40|3)|(2:38|4)|44|11|12|(4:42|(1:19)(1:(1:23)(3:24|(1:26)|27))|28|(1:30))|(1:(1:35)(1:36))(1:37)) */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        
            r9 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        
            r4 = r9;
            r9 = null;
            r5 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        
            r9 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        
            r4 = null;
            r5 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Interceptor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) throws java.io.IOException {
            /*
                r8 = this;
                java.lang.String r8 = "trace-id"
                java.lang.String r0 = "traceparent"
                okhttp3.Request r1 = r9.request()
                r2 = 0
                okhttp3.HttpUrl r3 = r1.url()     // Catch: java.lang.Throwable -> L29
                java.net.URL r3 = r3.url()     // Catch: java.lang.Throwable -> L29
                com.appdynamics.eumagent.runtime.HttpRequestTracker r3 = com.appdynamics.eumagent.runtime.Instrumentation.beginHttpRequest(r3)     // Catch: java.lang.Throwable -> L29
                java.lang.String r4 = "AppDynamics.OkHttp3Client"
                com.appdynamics.eumagent.runtime.HttpRequestTracker r4 = r3.withInstrumentationSource(r4)     // Catch: java.lang.Throwable -> L27
                okhttp3.Headers r5 = r1.headers()     // Catch: java.lang.Throwable -> L27
                java.util.Map r5 = r5.toMultimap()     // Catch: java.lang.Throwable -> L27
                r4.withRequestHeaderFields(r5)     // Catch: java.lang.Throwable -> L27
                goto L30
            L27:
                r4 = move-exception
                goto L2b
            L29:
                r4 = move-exception
                r3 = r2
            L2b:
                java.lang.String r5 = "Failed to create a OkHttp3 tracker"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r5, r4)
            L30:
                okhttp3.Response r9 = r9.proceed(r1)     // Catch: java.lang.RuntimeException -> L38 java.io.IOException -> L3d
                r5 = r9
                r9 = r2
                r4 = r9
                goto L40
            L38:
                r9 = move-exception
                r4 = r9
                r9 = r2
                r5 = r9
                goto L40
            L3d:
                r9 = move-exception
                r4 = r2
                r5 = r4
            L40:
                if (r3 == 0) goto L94
                if (r9 == 0) goto L4e
                com.appdynamics.eumagent.runtime.HttpRequestTracker r2 = r3.withException(r9)     // Catch: java.lang.Throwable -> L4c
                r2.reportDone()     // Catch: java.lang.Throwable -> L4c
                goto L7b
            L4c:
                r8 = move-exception
                goto L8f
            L4e:
                if (r4 == 0) goto L58
                com.appdynamics.eumagent.runtime.HttpRequestTracker r2 = r3.withException(r4)     // Catch: java.lang.Throwable -> L4c
                r2.reportDone()     // Catch: java.lang.Throwable -> L4c
                goto L7b
            L58:
                int r6 = r5.code()     // Catch: java.lang.Throwable -> L4c
                r7 = 400(0x190, float:5.6E-43)
                if (r6 < r7) goto L64
                java.lang.String r2 = r5.message()     // Catch: java.lang.Throwable -> L4c
            L64:
                com.appdynamics.eumagent.runtime.HttpRequestTracker r6 = r3.withResponseCode(r6)     // Catch: java.lang.Throwable -> L4c
                com.appdynamics.eumagent.runtime.HttpRequestTracker r2 = r6.withStatusLine(r2)     // Catch: java.lang.Throwable -> L4c
                okhttp3.Headers r6 = r5.headers()     // Catch: java.lang.Throwable -> L4c
                java.util.Map r6 = r6.toMultimap()     // Catch: java.lang.Throwable -> L4c
                com.appdynamics.eumagent.runtime.HttpRequestTracker r2 = r2.withResponseHeaderFields(r6)     // Catch: java.lang.Throwable -> L4c
                r2.reportDone()     // Catch: java.lang.Throwable -> L4c
            L7b:
                boolean r2 = com.appdynamics.eumagent.runtime.Instrumentation.isTraceparentHeaderEnabled     // Catch: java.lang.Throwable -> L4c
                if (r2 == 0) goto L94
                java.lang.String r2 = r1.header(r0)     // Catch: java.lang.Throwable -> L4c
                com.appdynamics.eumagent.runtime.HttpRequestTracker r0 = r3.withUserData(r0, r2)     // Catch: java.lang.Throwable -> L4c
                java.lang.String r1 = r1.header(r8)     // Catch: java.lang.Throwable -> L4c
                r0.withUserData(r8, r1)     // Catch: java.lang.Throwable -> L4c
                goto L94
            L8f:
                java.lang.String r0 = "Failed to report OkHttp3 tracker"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r0, r8)
            L94:
                if (r9 != 0) goto L9a
                if (r4 != 0) goto L99
                return r5
            L99:
                throw r4
            L9a:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.networkrequests.OkHttp3.AppDynamicsInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
        }
    }
}
