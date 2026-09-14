package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.NetworkRequestCallback;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ba */
/* JADX INFO: loaded from: classes2.dex */
public final class C2078ba extends AbstractC2071au implements HttpRequestTracker {

    /* JADX INFO: renamed from: q */
    private final C2063am f613q;

    /* JADX INFO: renamed from: r */
    private final NetworkRequestCallback f614r;

    /* JADX INFO: renamed from: s */
    private C2123cs f615s;

    /* JADX INFO: renamed from: t */
    private boolean f616t;

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ String getError() {
        return super.getError();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Exception getException() {
        return super.getException();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ String getInstrumentationSource() {
        return super.getInstrumentationSource();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Long getRequestContentLength() {
        return super.getRequestContentLength();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Map getRequestHeaderFields() {
        return super.getRequestHeaderFields();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ int getResponseCode() {
        return super.getResponseCode();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Long getResponseContentLength() {
        return super.getResponseContentLength();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Map getResponseHeaderFields() {
        return super.getResponseHeaderFields();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Throwable getThrowable() {
        return super.getThrowable();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ URL getURL() {
        return super.getURL();
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withError(String str) {
        return super.withError(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withException(Exception exc) {
        return super.withException(exc);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withInstrumentationSource(String str) {
        return super.withInstrumentationSource(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withRequestContentLength(Long l) {
        return super.withRequestContentLength(l);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withRequestHeaderFields(Map map) {
        return super.withRequestHeaderFields(map);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseCode(int i) {
        return super.withResponseCode(i);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseContentLength(Long l) {
        return super.withResponseContentLength(l);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseHeaderFields(Map map) {
        return super.withResponseHeaderFields(map);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withStatusLine(String str) {
        return super.withStatusLine(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withThrowable(Throwable th) {
        return super.withThrowable(th);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withURL(URL url) {
        return super.withURL(url);
    }

    public C2078ba(C2063am c2063am, URL url, NetworkRequestCallback networkRequestCallback) {
        this.f613q = c2063am;
        this.f581c = url;
        this.f614r = networkRequestCallback;
        this.f616t = false;
        this.f615s = new C2123cs();
        this.f587i = new HashMap();
        this.f588j = new HashMap();
        this.f591m = new HashMap();
        this.f589k = new HashMap();
        this.f590l = new HashMap();
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final void reportDone() {
        C2080bc c2080bc;
        List<String> list;
        try {
            boolean z = this.f616t;
            if (z || this.f581c == null || (this.f583e == null && this.f582d == null && this.f579a == null && this.f580b == null)) {
                if (z) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logAppError("Request already reported; it will not be reported to the AppDynamics collector.\nDo not reuse instances of HttpRequestTracker.\nRequest details: url = '" + this.f581c + "', statusCode = '" + this.f583e + "', error = '" + this.f582d + "', exception = '" + this.f579a + "', throwable = '" + this.f580b + "'");
                        return;
                    }
                    return;
                }
                if (ADLog.isInfoLoggingEnabled()) {
                    ADLog.logAppError("Not enough information provided for HTTP request; it will not be reported to the AppDynamics collector.\nRequest details: url = '" + this.f581c + "', statusCode = '" + this.f583e + "', error = '" + this.f582d + "', exception = '" + this.f579a + "', throwable = '" + this.f580b + "'");
                    return;
                }
                return;
            }
            C2123cs c2123cs = new C2123cs();
            boolean z2 = true;
            this.f616t = true;
            NetworkRequestCallback networkRequestCallback = this.f614r;
            if (networkRequestCallback != null ? networkRequestCallback.onNetworkRequest(this) : true) {
                HashMap map = new HashMap();
                map.put(String.class, this.f587i);
                map.put(Long.class, this.f588j);
                map.put(Boolean.class, this.f590l);
                map.put(Double.class, this.f589k);
                map.put(Date.class, this.f591m);
                Map<String, List<String>> map2 = this.f586h;
                if (map2 != null) {
                    String str = "X-ADEUM-GRAPHQL-OPERATION";
                    boolean zContainsKey = map2.containsKey("X-ADEUM-GRAPHQL-OPERATION");
                    if (this.f586h.containsKey("graphql-operation")) {
                        str = "graphql-operation";
                    } else {
                        z2 = zContainsKey;
                    }
                    if (z2 && (list = this.f586h.get(str)) != null && !list.isEmpty()) {
                        String str2 = list.get(0);
                        String string = this.f581c.toString();
                        if (!string.endsWith("/")) {
                            string = string + "/";
                        }
                        try {
                            this.f581c = new URL(string + str2);
                        } catch (Exception e) {
                            ADLog.logAgentError("Exception while converting string to URL", e);
                        }
                    }
                }
                Throwable th = this.f580b;
                if (th != null) {
                    c2080bc = new C2080bc(this.f581c, this.f615s, c2123cs, this.f594p, th, map);
                } else {
                    Exception exc = this.f579a;
                    if (exc != null) {
                        c2080bc = new C2080bc(this.f581c, this.f615s, c2123cs, this.f594p, exc, map);
                    } else {
                        String str3 = this.f582d;
                        if (str3 != null) {
                            c2080bc = new C2080bc(this.f581c, this.f615s, c2123cs, this.f594p, str3, map);
                        } else {
                            URL url = this.f581c;
                            C2123cs c2123cs2 = this.f615s;
                            int iIntValue = this.f583e.intValue();
                            String str4 = this.f584f;
                            C2072av c2072avM583a = m583a();
                            Long l = this.f592n;
                            long jLongValue = l != null ? l.longValue() : m582a(this.f586h);
                            Long l2 = this.f593o;
                            c2080bc = new C2080bc(url, c2123cs2, c2123cs, iIntValue, str4, c2072avM583a, jLongValue, l2 != null ? l2.longValue() : m582a(this.f585g), this.f594p, map);
                        }
                    }
                }
                this.f613q.m562a(c2080bc);
            }
        } catch (Throwable th2) {
            ADLog.logAgentError("Exception while reporting HTTP request", th2);
        }
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserData(String str, String str2) {
        ADLog.log(1, "withUserData(key='%s', value='%s') called", str, str2);
        try {
            this.f587i.put(C2124ct.m672d(str), C2124ct.m673e(str2));
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataLong(String str, Long l) {
        ADLog.log(1, "withUserDataLong(key='%s', value='%s') called", str, l);
        try {
            this.f588j.put(C2124ct.m672d(str), l);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataDouble(String str, Double d) {
        ADLog.log(1, "withUserDataDouble(key='%s', value='%s') called", str, d);
        try {
            String strM672d = C2124ct.m672d(str);
            if (d != null) {
                if (d.isNaN()) {
                    ADLog.log(1, "Illegal value NaN for user data key '%s', clearing user data for key", strM672d);
                } else if (d.isInfinite()) {
                    ADLog.log(1, "Illegal infinite value for user data key '%s', clearing user data for key", strM672d);
                }
                d = null;
            }
            this.f589k.put(strM672d, d);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataBoolean(String str, Boolean bool) {
        ADLog.log(1, "withUserDataBoolean(key='%s', value='%s') called", str, bool);
        try {
            this.f590l.put(C2124ct.m672d(str), bool);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2071au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataDate(String str, Date date) {
        ADLog.log(1, "setUserDataDate(key='%s') called", str, date);
        try {
            this.f591m.put(C2124ct.m672d(str), date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    private C2072av m583a() {
        String str;
        Long lM566a;
        C2073aw c2073aw = new C2073aw();
        Map<String, List<String>> map = this.f585g;
        int i = 2;
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (key != null) {
                        String[] strArrSplit = key.split("_");
                        if (strArrSplit.length == 2 && "ADRUM".equalsIgnoreCase(strArrSplit[0]) && (lM566a = C2073aw.m566a(strArrSplit[1])) != null) {
                            Iterator<String> it = value.iterator();
                            while (it.hasNext()) {
                                c2073aw.f603a.add(new C2073aw.a(lM566a, C2073aw.m567b(it.next()), (byte) 0));
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(c2073aw.f603a);
        ArrayList arrayList = new ArrayList();
        Iterator<C2073aw.a> it2 = c2073aw.f603a.iterator();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        long jLongValue = -1;
        long jLongValue2 = -1;
        while (it2.hasNext()) {
            String[] strArrSplit2 = it2.next().f605b.split(":");
            if (strArrSplit2.length == i && (str = strArrSplit2[0]) != null && strArrSplit2[1] != null) {
                if ("btERT".equalsIgnoreCase(str)) {
                    jLongValue = C2073aw.m566a(strArrSplit2[1]).longValue();
                } else if ("btDuration".equalsIgnoreCase(strArrSplit2[0])) {
                    jLongValue2 = C2073aw.m566a(strArrSplit2[1]).longValue();
                } else if ("btId".equalsIgnoreCase(strArrSplit2[0])) {
                    if (str2 != null) {
                        arrayList.add(new C2072av.a(str2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2)));
                        jLongValue = -1;
                        jLongValue2 = -1;
                    }
                    str2 = strArrSplit2[1];
                } else if ("clientRequestGUID".equalsIgnoreCase(strArrSplit2[0])) {
                    str3 = strArrSplit2[1];
                } else if ("serverSnapshotType".equalsIgnoreCase(strArrSplit2[0])) {
                    str4 = strArrSplit2[1];
                } else if ("globalAccountName".equalsIgnoreCase(strArrSplit2[0])) {
                    str5 = strArrSplit2[1];
                } else if ("hasEntryPointErrors".equalsIgnoreCase(strArrSplit2[0])) {
                    z = true;
                }
            }
            i = 2;
        }
        if (str2 != null) {
            arrayList.add(new C2072av.a(str2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2)));
        }
        return new C2072av(str3 == null ? UUID.randomUUID().toString() : str3, str4, arrayList, str5, z);
    }

    /* JADX INFO: renamed from: a */
    private static long m582a(Map<String, List<String>> map) {
        if (map == null) {
            return -1L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("content-length".equalsIgnoreCase(entry.getKey())) {
                List<String> value = entry.getValue();
                if (value == null || value.isEmpty()) {
                    return -1L;
                }
                try {
                    return Long.valueOf(value.get(0)).longValue();
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
        }
        return -1L;
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final void setStartTime(long j) {
        this.f615s = new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j);
    }
}
