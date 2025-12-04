package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.NetworkRequestCallback;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public final class ay {
    private final am a;
    private final NetworkRequestCallback b;

    public ay(am amVar, NetworkRequestCallback networkRequestCallback) {
        this.a = amVar;
        this.b = networkRequestCallback;
    }

    private HttpRequestTracker a(URL url, HttpRequest httpRequest) {
        if (url == null) {
            ADLog.logVerbose("Created DummyHttpRequestTracker since url is null");
            return new ax();
        }
        ba baVar = new ba(this.a, url, this.b);
        baVar.withInstrumentationSource("AppDynamics.HttpClient");
        ADLog.log(1, "Created HttpRequestTracker for [%s]", url);
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity == null) {
                baVar.withRequestContentLength(0L);
            } else {
                long contentLength = entity.getContentLength();
                Long lValueOf = contentLength >= 0 ? Long.valueOf(contentLength) : null;
                if (lValueOf != null) {
                    baVar.withRequestContentLength(lValueOf);
                }
            }
        }
        if (Instrumentation.initializationStarted) {
            for (Map.Entry<String, List<String>> entry : ServerCorrelationHeaders.generate().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    httpRequest.addHeader(entry.getKey(), it.next());
                }
            }
        }
        return baVar;
    }

    private static URL a(HttpUriRequest httpUriRequest) {
        try {
            URI uri = httpUriRequest.getURI();
            if (uri == null) {
                ADLog.logAppError("HttpUriRequest has null url, not tracking");
                return null;
            }
            return uri.toURL();
        } catch (MalformedURLException e) {
            if (ADLog.isInfoLoggingEnabled()) {
                ADLog.logAppError("Error constructing URL from URI (" + httpUriRequest.getURI() + ")", e);
            }
            return null;
        }
    }

    private static void a(HttpRequestTracker httpRequestTracker, HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode >= 400) {
            httpRequestTracker.withStatusLine(statusLine.getReasonPhrase());
        }
        httpRequestTracker.withResponseCode(statusCode);
        Header[] allHeaders = httpResponse.getAllHeaders();
        if (allHeaders != null) {
            HashMap map = new HashMap();
            for (Header header : allHeaders) {
                map.put(header.getName(), Collections.singletonList(header.getValue()));
            }
            httpRequestTracker.withResponseHeaderFields(map);
        }
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            httpRequestTracker.withResponseContentLength(0L);
        } else {
            long contentLength = entity.getContentLength();
            Long lValueOf = contentLength >= 0 ? Long.valueOf(contentLength) : null;
            if (lValueOf != null) {
                httpRequestTracker.withResponseContentLength(lValueOf);
            }
        }
        httpRequestTracker.reportDone();
    }

    static class a implements ResponseHandler {
        HttpResponse a;
        private final ResponseHandler b;

        a(ResponseHandler responseHandler) {
            this.b = responseHandler;
        }

        @Override // org.apache.http.client.ResponseHandler
        public final Object handleResponse(HttpResponse httpResponse) {
            this.a = httpResponse;
            return this.b.handleResponse(httpResponse);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.URL a(org.apache.http.HttpHost r5, org.apache.http.HttpRequest r6) {
        /*
            java.lang.String r0 = ")"
            r1 = 0
            if (r6 == 0) goto L15
            org.apache.http.RequestLine r2 = r6.getRequestLine()     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            if (r2 == 0) goto L15
            java.lang.String r2 = r2.getUri()     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            goto L16
        L10:
            r5 = move-exception
            r3 = r1
            goto L52
        L13:
            r2 = move-exception
            goto L6d
        L15:
            r2 = r1
        L16:
            if (r2 == 0) goto L33
            java.net.URI r3 = new java.net.URI     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            r3.<init>(r2)     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            boolean r2 = r3.isAbsolute()     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            if (r2 != 0) goto L4b
            java.net.URI r2 = new java.net.URI     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            java.lang.String r4 = r5.toURI()     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            r2.<init>(r4)     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            java.net.URI r3 = r2.resolve(r3)     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            goto L4b
        L31:
            r5 = move-exception
            goto L52
        L33:
            if (r5 == 0) goto L45
            java.lang.String r2 = r5.toURI()     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            if (r2 == 0) goto L45
            java.net.URI r3 = new java.net.URI     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            java.lang.String r2 = r5.toURI()     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            r3.<init>(r2)     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            goto L4b
        L45:
            java.lang.String r2 = "No URI found"
            com.appdynamics.eumagent.runtime.logging.ADLog.logAppError(r2)     // Catch: java.net.MalformedURLException -> L10 java.net.URISyntaxException -> L13
            r3 = r1
        L4b:
            if (r3 == 0) goto L8f
            java.net.URL r1 = r3.toURL()     // Catch: java.net.URISyntaxException -> L13 java.net.MalformedURLException -> L31
            goto L8f
        L52:
            boolean r6 = com.appdynamics.eumagent.runtime.logging.ADLog.isInfoLoggingEnabled()
            if (r6 == 0) goto L8f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Error constructing URL from URI ("
            r6.<init>(r2)
            r6.append(r3)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.appdynamics.eumagent.runtime.logging.ADLog.logAppError(r6, r5)
            goto L8f
        L6d:
            boolean r3 = com.appdynamics.eumagent.runtime.logging.ADLog.isInfoLoggingEnabled()
            if (r3 == 0) goto L8f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error constructing URL from host ("
            r3.<init>(r4)
            r3.append(r5)
            java.lang.String r5 = ") and request ("
            r3.append(r5)
            r3.append(r6)
            r3.append(r0)
            java.lang.String r5 = r3.toString()
            com.appdynamics.eumagent.runtime.logging.ADLog.logAppError(r5, r2)
        L8f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.p000private.ay.a(org.apache.http.HttpHost, org.apache.http.HttpRequest):java.net.URL");
    }

    public final HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpUriRequest), httpUriRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
            a(httpRequestTrackerA, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpUriRequest), httpUriRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest, httpContext);
            a(httpRequestTrackerA, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpHost, httpRequest), httpRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest);
            a(httpRequestTrackerA, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpHost, httpRequest), httpRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest, httpContext);
            a(httpRequestTrackerA, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final Object a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpUriRequest), httpUriRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpUriRequest, aVar);
            a(httpRequestTrackerA, aVar.a);
            return aVar.a;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final Object a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpUriRequest), httpUriRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpUriRequest, aVar, httpContext);
            a(httpRequestTrackerA, aVar.a);
            return aVar.a;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final Object a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpHost, httpRequest), httpRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpHost, httpRequest, aVar);
            a(httpRequestTrackerA, aVar.a);
            return aVar.a;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }

    public final Object a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws co {
        HttpRequestTracker httpRequestTrackerA = a(a(httpHost, httpRequest), httpRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpHost, httpRequest, aVar, httpContext);
            a(httpRequestTrackerA, aVar.a);
            return aVar.a;
        } catch (Throwable th) {
            httpRequestTrackerA.withThrowable(th).reportDone();
            throw new co(th);
        }
    }
}
