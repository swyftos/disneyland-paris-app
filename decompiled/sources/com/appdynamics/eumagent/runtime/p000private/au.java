package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class au implements HttpRequestTracker {
    protected Exception a;
    protected Throwable b;
    protected URL c;
    protected String d;
    protected Integer e;
    protected String f;
    protected Map<String, List<String>> g;
    protected Map<String, List<String>> h;
    protected Map<String, Object> i;
    protected Map<String, Object> j;
    protected Map<String, Object> k;
    protected Map<String, Object> l;
    protected Map<String, Object> m;
    protected Long n;
    protected Long o;
    protected String p = "Manual HttpTracker";

    au() {
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Exception getException() {
        return this.a;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withException(Exception exc) {
        this.a = exc;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public URL getURL() {
        return this.c;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withURL(URL url) {
        this.c = url;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Throwable getThrowable() {
        return this.b;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withThrowable(Throwable th) {
        this.b = th;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public String getError() {
        return this.d;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withError(String str) {
        this.d = str;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public int getResponseCode() {
        return this.e.intValue();
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseCode(int i) {
        this.e = Integer.valueOf(i);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withStatusLine(String str) {
        this.f = str;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.g;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseHeaderFields(Map<String, List<String>> map) {
        this.g = map;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Map<String, List<String>> getRequestHeaderFields() {
        return this.h;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withRequestHeaderFields(Map<String, List<String>> map) {
        this.h = map;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Long getResponseContentLength() {
        return this.o;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseContentLength(Long l) {
        this.o = l;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Long getRequestContentLength() {
        return this.n;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withRequestContentLength(Long l) {
        this.n = l;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public String getInstrumentationSource() {
        return this.p;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withInstrumentationSource(String str) {
        this.p = str;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withUserData(String str, String str2) {
        Instrumentation.setUserData(str, str2);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withUserDataLong(String str, Long l) {
        Instrumentation.setUserDataLong(str, l);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withUserDataDouble(String str, Double d) {
        Instrumentation.setUserDataDouble(str, d);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withUserDataBoolean(String str, Boolean bool) {
        Instrumentation.setUserDataBoolean(str, bool);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withUserDataDate(String str, Date date) {
        Instrumentation.setUserDataDate(str, date);
        return this;
    }
}
