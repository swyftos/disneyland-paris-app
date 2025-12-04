package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.NetworkRequestCallback;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.av;
import com.appdynamics.eumagent.runtime.p000private.aw;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class ba extends au implements HttpRequestTracker {
    private final am q;
    private final NetworkRequestCallback r;
    private cs s;
    private boolean t;

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ String getError() {
        return super.getError();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Exception getException() {
        return super.getException();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ String getInstrumentationSource() {
        return super.getInstrumentationSource();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Long getRequestContentLength() {
        return super.getRequestContentLength();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Map getRequestHeaderFields() {
        return super.getRequestHeaderFields();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ int getResponseCode() {
        return super.getResponseCode();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Long getResponseContentLength() {
        return super.getResponseContentLength();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Map getResponseHeaderFields() {
        return super.getResponseHeaderFields();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ Throwable getThrowable() {
        return super.getThrowable();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ URL getURL() {
        return super.getURL();
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withError(String str) {
        return super.withError(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withException(Exception exc) {
        return super.withException(exc);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withInstrumentationSource(String str) {
        return super.withInstrumentationSource(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withRequestContentLength(Long l) {
        return super.withRequestContentLength(l);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withRequestHeaderFields(Map map) {
        return super.withRequestHeaderFields(map);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseCode(int i) {
        return super.withResponseCode(i);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseContentLength(Long l) {
        return super.withResponseContentLength(l);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withResponseHeaderFields(Map map) {
        return super.withResponseHeaderFields(map);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withStatusLine(String str) {
        return super.withStatusLine(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withThrowable(Throwable th) {
        return super.withThrowable(th);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final /* bridge */ /* synthetic */ HttpRequestTracker withURL(URL url) {
        return super.withURL(url);
    }

    public ba(am amVar, URL url, NetworkRequestCallback networkRequestCallback) {
        this.q = amVar;
        this.c = url;
        this.r = networkRequestCallback;
        this.t = false;
        this.s = new cs();
        this.i = new HashMap();
        this.j = new HashMap();
        this.m = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
    }

    @Override // com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final void reportDone() {
        bc bcVar;
        List<String> list;
        try {
            boolean z = this.t;
            if (z || this.c == null || (this.e == null && this.d == null && this.a == null && this.b == null)) {
                if (z) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logAppError("Request already reported; it will not be reported to the AppDynamics collector.\nDo not reuse instances of HttpRequestTracker.\nRequest details: url = '" + this.c + "', statusCode = '" + this.e + "', error = '" + this.d + "', exception = '" + this.a + "', throwable = '" + this.b + "'");
                        return;
                    }
                    return;
                }
                if (ADLog.isInfoLoggingEnabled()) {
                    ADLog.logAppError("Not enough information provided for HTTP request; it will not be reported to the AppDynamics collector.\nRequest details: url = '" + this.c + "', statusCode = '" + this.e + "', error = '" + this.d + "', exception = '" + this.a + "', throwable = '" + this.b + "'");
                    return;
                }
                return;
            }
            cs csVar = new cs();
            boolean z2 = true;
            this.t = true;
            NetworkRequestCallback networkRequestCallback = this.r;
            if (networkRequestCallback != null ? networkRequestCallback.onNetworkRequest(this) : true) {
                HashMap map = new HashMap();
                map.put(String.class, this.i);
                map.put(Long.class, this.j);
                map.put(Boolean.class, this.l);
                map.put(Double.class, this.k);
                map.put(Date.class, this.m);
                Map<String, List<String>> map2 = this.h;
                if (map2 != null) {
                    String str = "X-ADEUM-GRAPHQL-OPERATION";
                    boolean zContainsKey = map2.containsKey("X-ADEUM-GRAPHQL-OPERATION");
                    if (this.h.containsKey("graphql-operation")) {
                        str = "graphql-operation";
                    } else {
                        z2 = zContainsKey;
                    }
                    if (z2 && (list = this.h.get(str)) != null && !list.isEmpty()) {
                        String str2 = list.get(0);
                        String string = this.c.toString();
                        if (!string.endsWith("/")) {
                            string = string + "/";
                        }
                        try {
                            this.c = new URL(string + str2);
                        } catch (Exception e) {
                            ADLog.logAgentError("Exception while converting string to URL", e);
                        }
                    }
                }
                Throwable th = this.b;
                if (th != null) {
                    bcVar = new bc(this.c, this.s, csVar, this.p, th, map);
                } else {
                    Exception exc = this.a;
                    if (exc != null) {
                        bcVar = new bc(this.c, this.s, csVar, this.p, exc, map);
                    } else {
                        String str3 = this.d;
                        if (str3 != null) {
                            bcVar = new bc(this.c, this.s, csVar, this.p, str3, map);
                        } else {
                            URL url = this.c;
                            cs csVar2 = this.s;
                            int iIntValue = this.e.intValue();
                            String str4 = this.f;
                            av avVarA = a();
                            Long l = this.n;
                            long jLongValue = l != null ? l.longValue() : a(this.h);
                            Long l2 = this.o;
                            bcVar = new bc(url, csVar2, csVar, iIntValue, str4, avVarA, jLongValue, l2 != null ? l2.longValue() : a(this.g), this.p, map);
                        }
                    }
                }
                this.q.a(bcVar);
            }
        } catch (Throwable th2) {
            ADLog.logAgentError("Exception while reporting HTTP request", th2);
        }
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserData(String str, String str2) {
        ADLog.log(1, "withUserData(key='%s', value='%s') called", str, str2);
        try {
            this.i.put(ct.d(str), ct.e(str2));
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataLong(String str, Long l) {
        ADLog.log(1, "withUserDataLong(key='%s', value='%s') called", str, l);
        try {
            this.j.put(ct.d(str), l);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataDouble(String str, Double d) {
        ADLog.log(1, "withUserDataDouble(key='%s', value='%s') called", str, d);
        try {
            String strD = ct.d(str);
            if (d != null) {
                if (d.isNaN()) {
                    ADLog.log(1, "Illegal value NaN for user data key '%s', clearing user data for key", strD);
                } else if (d.isInfinite()) {
                    ADLog.log(1, "Illegal infinite value for user data key '%s', clearing user data for key", strD);
                }
                d = null;
            }
            this.k.put(strD, d);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataBoolean(String str, Boolean bool) {
        ADLog.log(1, "withUserDataBoolean(key='%s', value='%s') called", str, bool);
        try {
            this.l.put(ct.d(str), bool);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.au, com.appdynamics.eumagent.runtime.HttpRequestTracker
    public final HttpRequestTracker withUserDataDate(String str, Date date) {
        ADLog.log(1, "setUserDataDate(key='%s') called", str, date);
        try {
            this.m.put(ct.d(str), date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting user data in network request", th);
        }
        return this;
    }

    private av a() {
        String str;
        Long lA;
        aw awVar = new aw();
        Map<String, List<String>> map = this.g;
        int i = 2;
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (key != null) {
                        String[] strArrSplit = key.split("_");
                        if (strArrSplit.length == 2 && "ADRUM".equalsIgnoreCase(strArrSplit[0]) && (lA = aw.a(strArrSplit[1])) != null) {
                            Iterator<String> it = value.iterator();
                            while (it.hasNext()) {
                                awVar.a.add(new aw.a(lA, aw.b(it.next()), (byte) 0));
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(awVar.a);
        ArrayList arrayList = new ArrayList();
        Iterator<aw.a> it2 = awVar.a.iterator();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        long jLongValue = -1;
        long jLongValue2 = -1;
        while (it2.hasNext()) {
            String[] strArrSplit2 = it2.next().b.split(":");
            if (strArrSplit2.length == i && (str = strArrSplit2[0]) != null && strArrSplit2[1] != null) {
                if ("btERT".equalsIgnoreCase(str)) {
                    jLongValue = aw.a(strArrSplit2[1]).longValue();
                } else if ("btDuration".equalsIgnoreCase(strArrSplit2[0])) {
                    jLongValue2 = aw.a(strArrSplit2[1]).longValue();
                } else if ("btId".equalsIgnoreCase(strArrSplit2[0])) {
                    if (str2 != null) {
                        arrayList.add(new av.a(str2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2)));
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
            arrayList.add(new av.a(str2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2)));
        }
        return new av(str3 == null ? UUID.randomUUID().toString() : str3, str4, arrayList, str5, z);
    }

    private static long a(Map<String, List<String>> map) {
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
        this.s = new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j);
    }
}
