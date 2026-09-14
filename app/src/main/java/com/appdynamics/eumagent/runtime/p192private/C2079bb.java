package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.NetworkRequestCallback;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bb */
/* JADX INFO: loaded from: classes2.dex */
public final class C2079bb {

    /* JADX INFO: renamed from: a */
    public final C2063am f617a;

    /* JADX INFO: renamed from: b */
    final NetworkRequestCallback f618b;

    /* JADX INFO: renamed from: c */
    private final C2138q f619c;

    /* JADX INFO: renamed from: d */
    private final WeakHashMap<HttpURLConnection, b> f620d = new WeakHashMap<>();

    public C2079bb(C2063am c2063am, NetworkRequestCallback networkRequestCallback, C2138q c2138q) {
        this.f617a = c2063am;
        this.f618b = networkRequestCallback;
        this.f619c = c2138q;
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m585a() {
        C2123cs c2123cs = new C2123cs();
        for (HttpURLConnection httpURLConnection : this.f620d.keySet()) {
            b bVar = this.f620d.get(httpURLConnection);
            if (bVar != null && bVar.f631d && !bVar.f630c && bVar.f629b.f817a + 10000 < c2123cs.f817a) {
                m584a(bVar, httpURLConnection, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bb$b */
    class b {

        /* JADX INFO: renamed from: a */
        HttpRequestTracker f628a;

        /* JADX INFO: renamed from: b */
        C2123cs f629b;

        /* JADX INFO: renamed from: c */
        boolean f630c;

        /* JADX INFO: renamed from: d */
        boolean f631d;

        /* synthetic */ b(C2079bb c2079bb, URL url, byte b) {
            this(c2079bb, url);
        }

        private b(C2079bb c2079bb, URL url) {
            this.f629b = new C2123cs();
            C2078ba c2078ba = new C2078ba(c2079bb.f617a, url, c2079bb.f618b);
            this.f628a = c2078ba;
            c2078ba.withInstrumentationSource("AppDynamics.URLConnection");
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m586a(HttpURLConnection httpURLConnection) {
        b bVar = this.f620d.get(httpURLConnection);
        if (bVar != null) {
            bVar.f631d = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m588b(HttpURLConnection httpURLConnection) {
        try {
            if (this.f620d.get(httpURLConnection) == null) {
                b bVar = new b(this, httpURLConnection.getURL(), (byte) 0);
                this.f620d.put(httpURLConnection, bVar);
                if (Instrumentation.initializationStarted) {
                    try {
                        for (Map.Entry<String, List<String>> entry : ServerCorrelationHeaders.generate().entrySet()) {
                            Iterator<String> it = entry.getValue().iterator();
                            while (it.hasNext()) {
                                httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                            }
                        }
                        if (this.f619c.f903b.traceparentHeaderEnabled) {
                            for (String str : ServerCorrelationHeaders.generateTraceParentHeaderValue()) {
                                httpURLConnection.addRequestProperty(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, str);
                                String str2 = str.split("-")[1];
                                httpURLConnection.addRequestProperty(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, str2);
                                bVar.f628a.withUserData(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, str).withUserData(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, str2);
                            }
                        }
                        ADLog.log(1, "Agent added server correlation header to request: %s", httpURLConnection.getURL());
                    } catch (IllegalStateException unused) {
                        ADLog.logInfo("Agent couldn't add server correlation header because headers have already been sent.");
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public final synchronized void m589c(HttpURLConnection httpURLConnection) {
        b bVar = this.f620d.get(httpURLConnection);
        if (bVar != null) {
            bVar.f629b = new C2123cs();
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m587a(HttpURLConnection httpURLConnection, Throwable th) {
        b bVar = this.f620d.get(httpURLConnection);
        if (bVar != null) {
            m584a(bVar, httpURLConnection, th);
            return;
        }
        if (httpURLConnection != null) {
            C2078ba c2078ba = new C2078ba(this.f617a, httpURLConnection.getURL(), this.f618b);
            c2078ba.withThrowable(th);
            c2078ba.withInstrumentationSource("AppDynamics.URLConnection");
            c2078ba.reportDone();
        }
    }

    /* JADX INFO: renamed from: d */
    final synchronized void m590d(HttpURLConnection httpURLConnection) {
        b bVar = this.f620d.get(httpURLConnection);
        if (bVar != null) {
            m584a(bVar, httpURLConnection, null);
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bb$a */
    public abstract class a {
        /* JADX INFO: renamed from: a */
        abstract InputStream mo591a();

        private a() {
        }

        /* synthetic */ a(C2079bb c2079bb, byte b) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final InputStream m592a(final HttpURLConnection httpURLConnection) throws C2119co {
            C2079bb.this.m588b(httpURLConnection);
            try {
                final InputStream inputStreamMo591a = mo591a();
                if (inputStreamMo591a == null) {
                    return null;
                }
                return new InputStream() { // from class: com.appdynamics.eumagent.runtime.private.bb.a.1
                    @Override // java.io.InputStream
                    public final int read() throws IOException {
                        try {
                            int i = inputStreamMo591a.read();
                            try {
                                m593a(i);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i;
                        } catch (IOException e) {
                            try {
                                C2079bb.this.m587a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] bArr) throws IOException {
                        try {
                            int i = inputStreamMo591a.read(bArr);
                            try {
                                m593a(i);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i;
                        } catch (IOException e) {
                            try {
                                C2079bb.this.m587a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] bArr, int i, int i2) throws IOException {
                        try {
                            int i3 = inputStreamMo591a.read(bArr, i, i2);
                            try {
                                m593a(i3);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i3;
                        } catch (IOException e) {
                            try {
                                C2079bb.this.m587a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() throws IOException {
                        try {
                            C2079bb.this.m590d(httpURLConnection);
                        } catch (Throwable th) {
                            ADLog.logAgentError("Error reporting close input stream", th);
                        }
                        inputStreamMo591a.close();
                    }

                    /* JADX INFO: renamed from: a */
                    private void m593a(int i) {
                        if (i == -1) {
                            C2079bb.this.m590d(httpURLConnection);
                        } else {
                            C2079bb.this.m586a(httpURLConnection);
                        }
                    }
                };
            } catch (Throwable th) {
                C2079bb.this.m587a(httpURLConnection, th);
                throw new C2119co(th);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m584a(b bVar, URLConnection uRLConnection, Throwable th) {
        if (!bVar.f630c) {
            bVar.f628a.withResponseCode(-1);
            if (th != null) {
                bVar.f628a.withThrowable(th);
            } else {
                try {
                    int responseCode = ((HttpURLConnection) uRLConnection).getResponseCode();
                    bVar.f628a.withResponseCode(responseCode);
                    if (responseCode >= 400) {
                        try {
                            bVar.f628a.withStatusLine(uRLConnection.getHeaderField(0));
                        } catch (NullPointerException e) {
                            ADLog.logAgentError("NullPointerException when fetching status line", e);
                        }
                    }
                    bVar.f628a.withResponseHeaderFields(uRLConnection.getHeaderFields());
                } catch (IOException e2) {
                    ADLog.logAgentError("Unexpected error fetching HTTP response code", e2);
                }
            }
            bVar.f628a.reportDone();
            bVar.f630c = true;
        }
    }
}
