package com.appdynamics.eumagent.runtime.p192private;

import android.net.TrafficStats;
import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.l */
/* JADX INFO: loaded from: classes2.dex */
public final class C2133l {

    /* JADX INFO: renamed from: a */
    private static final int f881a = (int) TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: b */
    private final C2113ci f882b;

    /* JADX INFO: renamed from: c */
    private final C2056af f883c;

    /* JADX INFO: renamed from: d */
    private final ScheduledExecutorService f884d;

    /* JADX INFO: renamed from: e */
    private final C2132k f885e;

    /* JADX INFO: renamed from: f */
    private final C2063am f886f;

    /* JADX INFO: renamed from: g */
    private final C2138q f887g;

    /* JADX INFO: renamed from: h */
    private C2127f f888h;

    /* JADX INFO: renamed from: i */
    private long f889i = 30000;

    /* JADX INFO: renamed from: j */
    private int f890j = 0;

    /* JADX INFO: renamed from: k */
    private long f891k = -1;

    /* JADX INFO: renamed from: l */
    private boolean f892l = false;

    /* JADX INFO: renamed from: m */
    private boolean f893m = false;

    public C2133l(C2113ci c2113ci, C2056af c2056af, C2063am c2063am, C2132k c2132k, ScheduledExecutorService scheduledExecutorService, C2138q c2138q, C2127f c2127f) {
        this.f883c = c2056af;
        this.f882b = c2113ci;
        this.f885e = c2132k;
        this.f886f = c2063am;
        this.f884d = scheduledExecutorService;
        this.f887g = c2138q;
        this.f888h = c2127f;
        a aVar = new a();
        long j = f881a;
        c2063am.m562a(new C2063am.d(aVar, j, j));
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.l$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ADLog.logVerbose("Running Beacon Queue Flusher to remove stale beacons from memory.");
            C2133l.this.m706a(0L);
        }

        public final String toString() {
            return "BeaconQueueFlusher";
        }
    }

    /* JADX INFO: renamed from: a */
    final void m706a(long j) {
        synchronized (this) {
            try {
                this.f893m = true;
                if (this.f892l) {
                    ADLog.logInfo("Beacon flush requested, deferring flush until after current flush completes");
                    return;
                }
                if (this.f891k == Long.MAX_VALUE) {
                    ADLog.logInfo("Beacon flush requested, but not sending because of too many previous network errors");
                    return;
                }
                C2127f c2127f = this.f888h;
                if (c2127f.f844a != null ? "offline".equals(c2127f.m688a(c2127f.m691c())) : false) {
                    ADLog.logInfo("Beacon flush requested, but not sending because connection is offline");
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j2 = this.f891k;
                if (jUptimeMillis < j2) {
                    ADLog.log(2, "Beacon flush requested, but not sending for at least %d milliseconds longer, because of a previous network error.", Long.valueOf(j2 - jUptimeMillis));
                    return;
                }
                if (j == 0) {
                    ADLog.logInfo("Beacon flush requested, scheduling beacons flush to collector immediately");
                    this.f884d.schedule(new b(), j, TimeUnit.SECONDS);
                } else if (j == 5) {
                    ADLog.logInfo("Beacon flush requested, scheduling beacons flush to collector in five seconds");
                    this.f884d.schedule(new b(), j, TimeUnit.SECONDS);
                }
                this.f892l = true;
                this.f891k = SystemClock.uptimeMillis() + this.f889i;
                this.f893m = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.l$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a */
        private List<AbstractC2129h> f895a = null;

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v22, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v24, types: [java.io.InputStream] */
        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            String string;
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (C2133l.this.f885e) {
                C2132k c2132k = C2133l.this.f885e;
                arrayList = new ArrayList();
                c2132k.f878a.m546a(arrayList);
                c2132k.f879b.m546a(arrayList);
                this.f895a = arrayList;
            }
            if (arrayList.isEmpty()) {
                ADLog.logInfo("Not sending empty beacon payload");
                C2133l.m702b(C2133l.this);
                return;
            }
            if (ADLog.isInfoLoggingEnabled()) {
                ADLog.logInfo("[" + C2124ct.m657a() + "] Agent sending beacons to collector (" + C2133l.this.f882b.f800b + ") [" + C2133l.this.f882b.f799a.f845b + "]:");
                StringWriter stringWriter = new StringWriter();
                try {
                    C2133l.m700a(stringWriter, this.f895a);
                    string = stringWriter.toString();
                } catch (Exception e) {
                    ADLog.logAgentError("Failed to serialize beacons: ", e);
                    string = this.f895a.toString();
                }
                ADLog.logInfo(string);
                ADLog.logInfo("-----------------------------------");
            }
            try {
                try {
                    C2113ci c2113ci = C2133l.this.f882b;
                    CollectorChannel collectorChannelNewCollectorChannel = c2113ci.f802d.newCollectorChannel();
                    collectorChannelNewCollectorChannel.setURL(c2113ci.f800b);
                    collectorChannelNewCollectorChannel.setRequestMethod("POST");
                    collectorChannelNewCollectorChannel.setConnectTimeout(30000);
                    collectorChannelNewCollectorChannel.setReadTimeout(30000);
                    c2113ci.f799a.m689a(collectorChannelNewCollectorChannel);
                    collectorChannelNewCollectorChannel.addRequestProperty("gzip", "false");
                    collectorChannelNewCollectorChannel.addRequestProperty("Content-Encoding", "gzip");
                    collectorChannelNewCollectorChannel.addRequestProperty("Content-Type", "application/json");
                    collectorChannelNewCollectorChannel.addRequestProperty("mat", C2133l.this.f883c.f505a.mo535b("mobileAgentToken", "-1"));
                    collectorChannelNewCollectorChannel.addRequestProperty("di", C2133l.this.f883c.m530a());
                    ?? inputStream = "adrum_request_config";
                    Long l = C2133l.this.f887g.f902a.f909d;
                    try {
                        collectorChannelNewCollectorChannel.addRequestProperty("adrum_request_config", Long.toString(l != null ? l.longValue() : 0L));
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(collectorChannelNewCollectorChannel.getOutputStream());
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gZIPOutputStream);
                        C2133l.m700a(outputStreamWriter, this.f895a);
                        outputStreamWriter.flush();
                        gZIPOutputStream.close();
                        inputStream = collectorChannelNewCollectorChannel.getInputStream();
                        try {
                            int responseCode = collectorChannelNewCollectorChannel.getResponseCode();
                            if (ADLog.isInfoLoggingEnabled()) {
                                ADLog.logInfo("Agent received response code: ".concat(String.valueOf(responseCode)));
                            }
                            if (responseCode == 200) {
                                C2133l.m698a(C2133l.this, C2133l.m701b((InputStream) inputStream));
                                C2133l.m702b(C2133l.this);
                            } else {
                                C2133l.m699a(C2133l.this, this.f895a);
                            }
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e2) {
                            ADLog.logAgentError("Error processing JSON", e2);
                            C2133l.m699a(C2133l.this, this.f895a);
                            if (inputStream != 0) {
                            }
                        }
                        if (ADLog.isInfoLoggingEnabled()) {
                            ADLog.logInfo("[" + C2124ct.m657a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
                        }
                        TrafficStats.clearThreadStatsTag();
                    } catch (Throwable th) {
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    ADLog.logAgentError("Error sending message to collector", e3);
                    C2133l.m699a(C2133l.this, this.f895a);
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logInfo("[" + C2124ct.m657a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
                    }
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable th2) {
                if (ADLog.isInfoLoggingEnabled()) {
                    ADLog.logInfo("[" + C2124ct.m657a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
                }
                TrafficStats.clearThreadStatsTag();
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static C2103bz m701b(InputStream inputStream) {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        if (ADLog.isVerboseLoggingEnabled()) {
            try {
                String string = C2124ct.m660a(bufferedInputStream).toString();
                ADLog.log(1, "Collector Response JSON: %s", string);
                bufferedInputStream.close();
                bufferedInputStream = new ByteArrayInputStream(string.getBytes());
            } catch (IOException unused) {
                ADLog.logVerbose("Tried to log response content, but had IO exception");
            }
        }
        C2103bz c2103bzM623a = null;
        try {
            c2103bzM623a = C2124ct.m670b(bufferedInputStream) ? C2103bz.m623a(new JsonReader(new InputStreamReader(bufferedInputStream))) : null;
            bufferedInputStream.close();
        } catch (IOException e) {
            ADLog.logAgentError("Failed to read response from server:", e);
        }
        return c2103bzM623a;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m702b(C2133l c2133l) {
        synchronized (c2133l) {
            try {
                c2133l.f891k = -1L;
                c2133l.f892l = false;
                c2133l.f890j = 0;
                c2133l.f889i = 30000L;
                if (c2133l.f893m) {
                    ADLog.logInfo("Successful flush, and an outstanding flush was requested");
                    c2133l.m706a(0L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m700a(Writer writer, List list) throws IOException {
        writer.write(91);
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            AbstractC2129h abstractC2129h = (AbstractC2129h) it.next();
            if (z) {
                writer.write(44);
            }
            abstractC2129h.mo693a(writer);
            z = true;
        }
        writer.write(93);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m698a(C2133l c2133l, C2103bz c2103bz) {
        ADLog.log(1, "Collector response = [%s]", c2103bz);
        if (c2103bz != null) {
            if ("disable-agent".equals(c2103bz.f743a)) {
                Long l = c2103bz.f744b;
                c2133l.f886f.m562a(new C2121cq(l == null ? -1L : l.longValue()));
                return;
            }
            String str = c2103bz.f745c;
            if (str != null) {
                c2133l.f883c.f505a.mo533a("mobileAgentToken", str);
                ADLog.log(2, "Calling [%s] to register agent.", c2133l.f882b.f801c);
                InputStream inputStream = null;
                try {
                    try {
                        C2113ci c2113ci = c2133l.f882b;
                        CollectorChannel collectorChannelNewCollectorChannel = c2113ci.f802d.newCollectorChannel();
                        collectorChannelNewCollectorChannel.setURL(c2113ci.f801c);
                        collectorChannelNewCollectorChannel.setRequestMethod("POST");
                        collectorChannelNewCollectorChannel.setConnectTimeout(30000);
                        collectorChannelNewCollectorChannel.setReadTimeout(30000);
                        c2113ci.f799a.m689a(collectorChannelNewCollectorChannel);
                        collectorChannelNewCollectorChannel.setRequestMethod("POST");
                        collectorChannelNewCollectorChannel.addRequestProperty("sr", "true");
                        inputStream = collectorChannelNewCollectorChannel.getInputStream();
                        C2124ct.m660a(inputStream);
                        ADLog.logInfo("Finished registering agent with collector.");
                    } catch (IOException e) {
                        ADLog.logAgentError("Exception while trying to register with collector", e);
                    }
                    C2124ct.m663a((Closeable) inputStream);
                } catch (Throwable th) {
                    C2124ct.m663a((Closeable) inputStream);
                    throw th;
                }
            }
            C2140s c2140s = c2103bz.f746d;
            if (c2140s != null) {
                c2133l.f886f.m562a(c2140s);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m699a(C2133l c2133l, List list) {
        C2060aj c2060aj;
        C2132k c2132k = c2133l.f885e;
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            AbstractC2129h abstractC2129h = (AbstractC2129h) listIterator.previous();
            if ((abstractC2129h instanceof C2054ad) || (abstractC2129h instanceof C2143v) || (abstractC2129h instanceof C2146y)) {
                c2060aj = c2132k.f879b;
                ADLog.log(1, "Adding old beacon [%s] to Crash BeaconQueue", abstractC2129h);
            } else {
                c2060aj = c2132k.f878a;
                ADLog.log(1, "Adding old beacon [%s] to BeaconQueue", abstractC2129h);
            }
            if (!c2060aj.f517b.offerFirst(abstractC2129h)) {
                ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", abstractC2129h);
            }
        }
        synchronized (c2133l) {
            try {
                int i = c2133l.f890j + 1;
                c2133l.f890j = i;
                c2133l.f892l = false;
                if (i <= 3) {
                    ADLog.log(2, "Detected network error sending beacons to collector; trying again in %d ms", Long.valueOf(c2133l.f889i));
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    long j = c2133l.f889i;
                    c2133l.f891k = jUptimeMillis + j;
                    c2133l.f889i = (long) Math.pow(j, 1.2d);
                } else {
                    ADLog.log(2, "Detected %d failures in a row; queuing messages until next start up", i);
                    c2133l.f891k = Long.MAX_VALUE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
