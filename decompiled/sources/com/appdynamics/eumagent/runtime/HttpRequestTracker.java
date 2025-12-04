package com.appdynamics.eumagent.runtime;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

@DontObfuscate
/* loaded from: classes2.dex */
public interface HttpRequestTracker {
    String getError();

    Exception getException();

    String getInstrumentationSource();

    Long getRequestContentLength();

    Map<String, List<String>> getRequestHeaderFields();

    int getResponseCode();

    Long getResponseContentLength();

    Map<String, List<String>> getResponseHeaderFields();

    Throwable getThrowable();

    URL getURL();

    void reportDone();

    void setStartTime(long j);

    HttpRequestTracker withError(String str);

    @Deprecated
    HttpRequestTracker withException(Exception exc);

    HttpRequestTracker withInstrumentationSource(String str);

    HttpRequestTracker withRequestContentLength(Long l);

    HttpRequestTracker withRequestHeaderFields(Map<String, List<String>> map);

    HttpRequestTracker withResponseCode(int i);

    HttpRequestTracker withResponseContentLength(Long l);

    HttpRequestTracker withResponseHeaderFields(Map<String, List<String>> map);

    HttpRequestTracker withStatusLine(String str);

    HttpRequestTracker withThrowable(Throwable th);

    HttpRequestTracker withURL(URL url);

    HttpRequestTracker withUserData(String str, String str2);

    HttpRequestTracker withUserDataBoolean(String str, Boolean bool);

    HttpRequestTracker withUserDataDate(String str, Date date);

    HttpRequestTracker withUserDataDouble(String str, Double d);

    HttpRequestTracker withUserDataLong(String str, Long l);
}
