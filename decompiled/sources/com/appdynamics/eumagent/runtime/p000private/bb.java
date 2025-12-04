package com.appdynamics.eumagent.runtime.p000private;

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

/* loaded from: classes2.dex */
public final class bb {
    public final am a;
    final NetworkRequestCallback b;
    private final q c;
    private final WeakHashMap<HttpURLConnection, b> d = new WeakHashMap<>();

    public bb(am amVar, NetworkRequestCallback networkRequestCallback, q qVar) {
        this.a = amVar;
        this.b = networkRequestCallback;
        this.c = qVar;
    }

    final synchronized void a() {
        cs csVar = new cs();
        for (HttpURLConnection httpURLConnection : this.d.keySet()) {
            b bVar = this.d.get(httpURLConnection);
            if (bVar != null && bVar.d && !bVar.c && bVar.b.a + 10000 < csVar.a) {
                a(bVar, httpURLConnection, null);
            }
        }
    }

    class b {
        HttpRequestTracker a;
        cs b;
        boolean c;
        boolean d;

        /* synthetic */ b(bb bbVar, URL url, byte b) {
            this(bbVar, url);
        }

        private b(bb bbVar, URL url) {
            this.b = new cs();
            ba baVar = new ba(bbVar.a, url, bbVar.b);
            this.a = baVar;
            baVar.withInstrumentationSource("AppDynamics.URLConnection");
        }
    }

    public final synchronized void a(HttpURLConnection httpURLConnection) {
        b bVar = this.d.get(httpURLConnection);
        if (bVar != null) {
            bVar.d = true;
        }
    }

    public final synchronized void b(HttpURLConnection httpURLConnection) {
        try {
            if (this.d.get(httpURLConnection) == null) {
                b bVar = new b(this, httpURLConnection.getURL(), (byte) 0);
                this.d.put(httpURLConnection, bVar);
                if (Instrumentation.initializationStarted) {
                    try {
                        for (Map.Entry<String, List<String>> entry : ServerCorrelationHeaders.generate().entrySet()) {
                            Iterator<String> it = entry.getValue().iterator();
                            while (it.hasNext()) {
                                httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                            }
                        }
                        if (this.c.b.traceparentHeaderEnabled) {
                            for (String str : ServerCorrelationHeaders.generateTraceParentHeaderValue()) {
                                httpURLConnection.addRequestProperty(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, str);
                                String str2 = str.split("-")[1];
                                httpURLConnection.addRequestProperty(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, str2);
                                bVar.a.withUserData(ServerCorrelationHeaders.ADEUM_TRACE_PARENT_HEADER, str).withUserData(ServerCorrelationHeaders.ADEUM_TRACE_ID_HEADER, str2);
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

    public final synchronized void c(HttpURLConnection httpURLConnection) {
        b bVar = this.d.get(httpURLConnection);
        if (bVar != null) {
            bVar.b = new cs();
        }
    }

    public final synchronized void a(HttpURLConnection httpURLConnection, Throwable th) {
        b bVar = this.d.get(httpURLConnection);
        if (bVar != null) {
            a(bVar, httpURLConnection, th);
            return;
        }
        if (httpURLConnection != null) {
            ba baVar = new ba(this.a, httpURLConnection.getURL(), this.b);
            baVar.withThrowable(th);
            baVar.withInstrumentationSource("AppDynamics.URLConnection");
            baVar.reportDone();
        }
    }

    final synchronized void d(HttpURLConnection httpURLConnection) {
        b bVar = this.d.get(httpURLConnection);
        if (bVar != null) {
            a(bVar, httpURLConnection, null);
        }
    }

    public abstract class a {
        abstract InputStream a();

        private a() {
        }

        /* synthetic */ a(bb bbVar, byte b) {
            this();
        }

        public final InputStream a(final HttpURLConnection httpURLConnection) throws co {
            bb.this.b(httpURLConnection);
            try {
                final InputStream inputStreamA = a();
                if (inputStreamA == null) {
                    return null;
                }
                return new InputStream() { // from class: com.appdynamics.eumagent.runtime.private.bb.a.1
                    @Override // java.io.InputStream
                    public final int read() throws IOException {
                        try {
                            int i = inputStreamA.read();
                            try {
                                a(i);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i;
                        } catch (IOException e) {
                            try {
                                bb.this.a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] bArr) throws IOException {
                        try {
                            int i = inputStreamA.read(bArr);
                            try {
                                a(i);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i;
                        } catch (IOException e) {
                            try {
                                bb.this.a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] bArr, int i, int i2) throws IOException {
                        try {
                            int i3 = inputStreamA.read(bArr, i, i2);
                            try {
                                a(i3);
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error reporting read input stream", th);
                            }
                            return i3;
                        } catch (IOException e) {
                            try {
                                bb.this.a(httpURLConnection, e);
                            } catch (Throwable th2) {
                                ADLog.logAgentError("Error reporting read input stream", th2);
                            }
                            throw e;
                        }
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() throws IOException {
                        try {
                            bb.this.d(httpURLConnection);
                        } catch (Throwable th) {
                            ADLog.logAgentError("Error reporting close input stream", th);
                        }
                        inputStreamA.close();
                    }

                    private void a(int i) {
                        if (i == -1) {
                            bb.this.d(httpURLConnection);
                        } else {
                            bb.this.a(httpURLConnection);
                        }
                    }
                };
            } catch (Throwable th) {
                bb.this.a(httpURLConnection, th);
                throw new co(th);
            }
        }
    }

    private synchronized void a(b bVar, URLConnection uRLConnection, Throwable th) {
        if (!bVar.c) {
            bVar.a.withResponseCode(-1);
            if (th != null) {
                bVar.a.withThrowable(th);
            } else {
                try {
                    int responseCode = ((HttpURLConnection) uRLConnection).getResponseCode();
                    bVar.a.withResponseCode(responseCode);
                    if (responseCode >= 400) {
                        try {
                            bVar.a.withStatusLine(uRLConnection.getHeaderField(0));
                        } catch (NullPointerException e) {
                            ADLog.logAgentError("NullPointerException when fetching status line", e);
                        }
                    }
                    bVar.a.withResponseHeaderFields(uRLConnection.getHeaderFields());
                } catch (IOException e2) {
                    ADLog.logAgentError("Unexpected error fetching HTTP response code", e2);
                }
            }
            bVar.a.reportDone();
            bVar.c = true;
        }
    }
}
