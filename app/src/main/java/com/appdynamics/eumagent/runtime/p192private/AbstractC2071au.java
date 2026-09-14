package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.au */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2071au implements HttpRequestTracker {

    /* JADX INFO: renamed from: a */
    protected Exception f579a;

    /* JADX INFO: renamed from: b */
    protected Throwable f580b;

    /* JADX INFO: renamed from: c */
    protected URL f581c;

    /* JADX INFO: renamed from: d */
    protected String f582d;

    /* JADX INFO: renamed from: e */
    protected Integer f583e;

    /* JADX INFO: renamed from: f */
    protected String f584f;

    /* JADX INFO: renamed from: g */
    protected Map<String, List<String>> f585g;

    /* JADX INFO: renamed from: h */
    protected Map<String, List<String>> f586h;

    /* JADX INFO: renamed from: i */
    protected Map<String, Object> f587i;

    /* JADX INFO: renamed from: j */
    protected Map<String, Object> f588j;

    /* JADX INFO: renamed from: k */
    protected Map<String, Object> f589k;

    /* JADX INFO: renamed from: l */
    protected Map<String, Object> f590l;

    /* JADX INFO: renamed from: m */
    protected Map<String, Object> f591m;

    /* JADX INFO: renamed from: n */
    protected Long f592n;

    /* JADX INFO: renamed from: o */
    protected Long f593o;

    /* JADX INFO: renamed from: p */
    protected String f594p = "Manual HttpTracker";

    AbstractC2071au() {
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Exception getException() {
        return this.f579a;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withException(Exception exc) {
        this.f579a = exc;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public URL getURL() {
        return this.f581c;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withURL(URL url) {
        this.f581c = url;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Throwable getThrowable() {
        return this.f580b;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withThrowable(Throwable th) {
        this.f580b = th;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public String getError() {
        return this.f582d;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withError(String str) {
        this.f582d = str;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public int getResponseCode() {
        return this.f583e.intValue();
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseCode(int i) {
        this.f583e = Integer.valueOf(i);
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withStatusLine(String str) {
        this.f584f = str;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.f585g;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseHeaderFields(Map<String, List<String>> map) {
        this.f585g = map;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Map<String, List<String>> getRequestHeaderFields() {
        return this.f586h;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withRequestHeaderFields(Map<String, List<String>> map) {
        this.f586h = map;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Long getResponseContentLength() {
        return this.f593o;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withResponseContentLength(Long l) {
        this.f593o = l;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public Long getRequestContentLength() {
        return this.f592n;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withRequestContentLength(Long l) {
        this.f592n = l;
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public String getInstrumentationSource() {
        return this.f594p;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public HttpRequestTracker withInstrumentationSource(String str) {
        this.f594p = str;
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
