package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.NetworkRequestCallback;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ay */
/* JADX INFO: loaded from: classes2.dex */
public final class C2075ay {

    /* JADX INFO: renamed from: a */
    private final C2063am f606a;

    /* JADX INFO: renamed from: b */
    private final NetworkRequestCallback f607b;

    public C2075ay(C2063am c2063am, NetworkRequestCallback networkRequestCallback) {
        this.f606a = c2063am;
        this.f607b = networkRequestCallback;
    }

    /* JADX INFO: renamed from: a */
    private HttpRequestTracker m569a(URL url, HttpRequest httpRequest) {
        if (url == null) {
            ADLog.logVerbose("Created DummyHttpRequestTracker since url is null");
            return new C2074ax();
        }
        C2078ba c2078ba = new C2078ba(this.f606a, url, this.f607b);
        c2078ba.withInstrumentationSource("AppDynamics.HttpClient");
        ADLog.log(1, "Created HttpRequestTracker for [%s]", url);
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity == null) {
                c2078ba.withRequestContentLength(0L);
            } else {
                long contentLength = entity.getContentLength();
                Long lValueOf = contentLength >= 0 ? Long.valueOf(contentLength) : null;
                if (lValueOf != null) {
                    c2078ba.withRequestContentLength(lValueOf);
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
        return c2078ba;
    }

    /* JADX INFO: renamed from: a */
    private static URL m571a(HttpUriRequest httpUriRequest) {
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

    /* JADX INFO: renamed from: a */
    private static void m572a(HttpRequestTracker httpRequestTracker, HttpResponse httpResponse) {
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

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ay$a */
    static class a implements ResponseHandler {

        /* JADX INFO: renamed from: a */
        HttpResponse f608a;

        /* JADX INFO: renamed from: b */
        private final ResponseHandler f609b;

        a(ResponseHandler responseHandler) {
            this.f609b = responseHandler;
        }

        @Override // org.apache.http.client.ResponseHandler
        public final Object handleResponse(HttpResponse httpResponse) {
            this.f608a = httpResponse;
            return this.f609b.handleResponse(httpResponse);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0018 A[Catch: MalformedURLException -> 0x0010, URISyntaxException -> 0x0013, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x0010, blocks: (B:4:0x0005, B:6:0x000b, B:13:0x0018, B:21:0x0035, B:23:0x003b, B:24:0x0045), top: B:36:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0023 A[Catch: URISyntaxException -> 0x0013, MalformedURLException -> 0x0031, TRY_LEAVE, TryCatch #1 {MalformedURLException -> 0x0031, blocks: (B:14:0x001d, B:16:0x0023, B:27:0x004d), top: B:37:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[Catch: MalformedURLException -> 0x0010, URISyntaxException -> 0x0013, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x0010, blocks: (B:4:0x0005, B:6:0x000b, B:13:0x0018, B:21:0x0035, B:23:0x003b, B:24:0x0045), top: B:36:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x004d A[Catch: URISyntaxException -> 0x0013, MalformedURLException -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #1 {MalformedURLException -> 0x0031, blocks: (B:14:0x001d, B:16:0x0023, B:27:0x004d), top: B:37:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    private static URL m570a(HttpHost httpHost, HttpRequest httpRequest) {
        URI uri;
        String uri2;
        if (httpRequest == null) {
            uri2 = null;
            if (uri2 != null) {
                uri = new URI(uri2);
                if (!uri.isAbsolute()) {
                    uri = new URI(httpHost.toURI()).resolve(uri);
                }
            } else if (httpHost == null) {
                ADLog.logAppError("No URI found");
                uri = null;
            } else {
                ADLog.logAppError("No URI found");
                uri = null;
            }
            if (uri != null) {
                return uri.toURL();
            }
            return null;
        }
        try {
            try {
                RequestLine requestLine = httpRequest.getRequestLine();
                if (requestLine != null) {
                    uri2 = requestLine.getUri();
                } else {
                    uri2 = null;
                }
                if (uri2 != null) {
                    uri = new URI(uri2);
                    try {
                        if (!uri.isAbsolute()) {
                            uri = new URI(httpHost.toURI()).resolve(uri);
                        }
                    } catch (MalformedURLException e) {
                        e = e;
                    }
                } else if (httpHost == null && httpHost.toURI() != null) {
                    uri = new URI(httpHost.toURI());
                } else {
                    ADLog.logAppError("No URI found");
                    uri = null;
                }
                if (uri != null) {
                    return uri.toURL();
                }
                return null;
            } catch (URISyntaxException e2) {
                if (!ADLog.isInfoLoggingEnabled()) {
                    return null;
                }
                ADLog.logAppError("Error constructing URL from host (" + httpHost + ") and request (" + httpRequest + ")", e2);
                return null;
            }
        } catch (MalformedURLException e3) {
            e = e3;
            uri = null;
        }
        if (!ADLog.isInfoLoggingEnabled()) {
            return null;
        }
        ADLog.logAppError("Error constructing URL from URI (" + uri + ")", e);
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final HttpResponse m579a(HttpClient httpClient, HttpUriRequest httpUriRequest) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m571a(httpUriRequest), httpUriRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
            m572a(httpRequestTrackerM569a, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final HttpResponse m580a(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m571a(httpUriRequest), httpUriRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest, httpContext);
            m572a(httpRequestTrackerM569a, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final HttpResponse m577a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m570a(httpHost, httpRequest), httpRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest);
            m572a(httpRequestTrackerM569a, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final HttpResponse m578a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m570a(httpHost, httpRequest), httpRequest);
        try {
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest, httpContext);
            m572a(httpRequestTrackerM569a, httpResponseExecute);
            return httpResponseExecute;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m575a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m571a(httpUriRequest), httpUriRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpUriRequest, aVar);
            m572a(httpRequestTrackerM569a, aVar.f608a);
            return aVar.f608a;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m576a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m571a(httpUriRequest), httpUriRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpUriRequest, aVar, httpContext);
            m572a(httpRequestTrackerM569a, aVar.f608a);
            return aVar.f608a;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m573a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m570a(httpHost, httpRequest), httpRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpHost, httpRequest, aVar);
            m572a(httpRequestTrackerM569a, aVar.f608a);
            return aVar.f608a;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m574a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws C2119co {
        HttpRequestTracker httpRequestTrackerM569a = m569a(m570a(httpHost, httpRequest), httpRequest);
        a aVar = new a(responseHandler);
        try {
            httpClient.execute(httpHost, httpRequest, aVar, httpContext);
            m572a(httpRequestTrackerM569a, aVar.f608a);
            return aVar.f608a;
        } catch (Throwable th) {
            httpRequestTrackerM569a.withThrowable(th).reportDone();
            throw new C2119co(th);
        }
    }
}
