package com.appdynamics.eumagent.runtime.p000private;

import android.net.TrafficStats;
import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
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
import org.picocontainer.Characteristics;

/* loaded from: classes2.dex */
public final class l {
    private static final int a = (int) TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES);
    private final ci b;
    private final af c;
    private final ScheduledExecutorService d;
    private final k e;
    private final am f;
    private final q g;
    private f h;
    private long i = 30000;
    private int j = 0;
    private long k = -1;
    private boolean l = false;
    private boolean m = false;

    public l(ci ciVar, af afVar, am amVar, k kVar, ScheduledExecutorService scheduledExecutorService, q qVar, f fVar) {
        this.c = afVar;
        this.b = ciVar;
        this.e = kVar;
        this.f = amVar;
        this.d = scheduledExecutorService;
        this.g = qVar;
        this.h = fVar;
        a aVar = new a();
        long j = a;
        amVar.a(new am.d(aVar, j, j));
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ADLog.logVerbose("Running Beacon Queue Flusher to remove stale beacons from memory.");
            l.this.a(0L);
        }

        public final String toString() {
            return "BeaconQueueFlusher";
        }
    }

    final void a(long j) {
        synchronized (this) {
            try {
                this.m = true;
                if (this.l) {
                    ADLog.logInfo("Beacon flush requested, deferring flush until after current flush completes");
                    return;
                }
                if (this.k == Long.MAX_VALUE) {
                    ADLog.logInfo("Beacon flush requested, but not sending because of too many previous network errors");
                    return;
                }
                f fVar = this.h;
                if (fVar.a != null ? "offline".equals(fVar.a(fVar.c())) : false) {
                    ADLog.logInfo("Beacon flush requested, but not sending because connection is offline");
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j2 = this.k;
                if (jUptimeMillis < j2) {
                    ADLog.log(2, "Beacon flush requested, but not sending for at least %d milliseconds longer, because of a previous network error.", Long.valueOf(j2 - jUptimeMillis));
                    return;
                }
                if (j == 0) {
                    ADLog.logInfo("Beacon flush requested, scheduling beacons flush to collector immediately");
                    this.d.schedule(new b(), j, TimeUnit.SECONDS);
                } else if (j == 5) {
                    ADLog.logInfo("Beacon flush requested, scheduling beacons flush to collector in five seconds");
                    this.d.schedule(new b(), j, TimeUnit.SECONDS);
                }
                this.l = true;
                this.k = SystemClock.uptimeMillis() + this.i;
                this.m = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    class b implements Runnable {
        private List<h> a = null;

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
            synchronized (l.this.e) {
                k kVar = l.this.e;
                arrayList = new ArrayList();
                kVar.a.a(arrayList);
                kVar.b.a(arrayList);
                this.a = arrayList;
            }
            if (arrayList.isEmpty()) {
                ADLog.logInfo("Not sending empty beacon payload");
                l.b(l.this);
                return;
            }
            if (ADLog.isInfoLoggingEnabled()) {
                ADLog.logInfo("[" + ct.a() + "] Agent sending beacons to collector (" + l.this.b.b + ") [" + l.this.b.a.b + "]:");
                StringWriter stringWriter = new StringWriter();
                try {
                    l.a(stringWriter, this.a);
                    string = stringWriter.toString();
                } catch (Exception e) {
                    ADLog.logAgentError("Failed to serialize beacons: ", e);
                    string = this.a.toString();
                }
                ADLog.logInfo(string);
                ADLog.logInfo("-----------------------------------");
            }
            try {
                try {
                    ci ciVar = l.this.b;
                    CollectorChannel collectorChannelNewCollectorChannel = ciVar.d.newCollectorChannel();
                    collectorChannelNewCollectorChannel.setURL(ciVar.b);
                    collectorChannelNewCollectorChannel.setRequestMethod("POST");
                    collectorChannelNewCollectorChannel.setConnectTimeout(30000);
                    collectorChannelNewCollectorChannel.setReadTimeout(30000);
                    ciVar.a.a(collectorChannelNewCollectorChannel);
                    collectorChannelNewCollectorChannel.addRequestProperty("gzip", "false");
                    collectorChannelNewCollectorChannel.addRequestProperty("Content-Encoding", "gzip");
                    collectorChannelNewCollectorChannel.addRequestProperty("Content-Type", "application/json");
                    collectorChannelNewCollectorChannel.addRequestProperty("mat", l.this.c.a.b("mobileAgentToken", "-1"));
                    collectorChannelNewCollectorChannel.addRequestProperty("di", l.this.c.a());
                    ?? inputStream = "adrum_request_config";
                    Long l = l.this.g.a.d;
                    try {
                        collectorChannelNewCollectorChannel.addRequestProperty("adrum_request_config", Long.toString(l != null ? l.longValue() : 0L));
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(collectorChannelNewCollectorChannel.getOutputStream());
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gZIPOutputStream);
                        l.a(outputStreamWriter, this.a);
                        outputStreamWriter.flush();
                        gZIPOutputStream.close();
                        inputStream = collectorChannelNewCollectorChannel.getInputStream();
                        try {
                            int responseCode = collectorChannelNewCollectorChannel.getResponseCode();
                            if (ADLog.isInfoLoggingEnabled()) {
                                ADLog.logInfo("Agent received response code: ".concat(String.valueOf(responseCode)));
                            }
                            if (responseCode == 200) {
                                l.a(l.this, l.b((InputStream) inputStream));
                                l.b(l.this);
                            } else {
                                l.a(l.this, this.a);
                            }
                        } catch (Exception e2) {
                            ADLog.logAgentError("Error processing JSON", e2);
                            l.a(l.this, this.a);
                            if (inputStream != 0) {
                            }
                        }
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                        if (ADLog.isInfoLoggingEnabled()) {
                            ADLog.logInfo("[" + ct.a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
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
                    l.a(l.this, this.a);
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logInfo("[" + ct.a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
                    }
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable th2) {
                if (ADLog.isInfoLoggingEnabled()) {
                    ADLog.logInfo("[" + ct.a() + "] Total time taken to complete request is " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms.");
                }
                TrafficStats.clearThreadStatsTag();
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static bz b(InputStream inputStream) throws IOException {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        if (ADLog.isVerboseLoggingEnabled()) {
            try {
                String string = ct.a(bufferedInputStream).toString();
                ADLog.log(1, "Collector Response JSON: %s", string);
                bufferedInputStream.close();
                bufferedInputStream = new ByteArrayInputStream(string.getBytes());
            } catch (IOException unused) {
                ADLog.logVerbose("Tried to log response content, but had IO exception");
            }
        }
        try {
            bzVarA = ct.b(bufferedInputStream) ? bz.a(new JsonReader(new InputStreamReader(bufferedInputStream))) : null;
            bufferedInputStream.close();
        } catch (IOException e) {
            ADLog.logAgentError("Failed to read response from server:", e);
        }
        return bzVarA;
    }

    static /* synthetic */ void b(l lVar) {
        synchronized (lVar) {
            try {
                lVar.k = -1L;
                lVar.l = false;
                lVar.j = 0;
                lVar.i = 30000L;
                if (lVar.m) {
                    ADLog.logInfo("Successful flush, and an outstanding flush was requested");
                    lVar.a(0L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void a(Writer writer, List list) throws IOException {
        writer.write(91);
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (z) {
                writer.write(44);
            }
            hVar.a(writer);
            z = true;
        }
        writer.write(93);
    }

    static /* synthetic */ void a(l lVar, bz bzVar) throws IOException {
        ADLog.log(1, "Collector response = [%s]", bzVar);
        if (bzVar != null) {
            if ("disable-agent".equals(bzVar.a)) {
                Long l = bzVar.b;
                lVar.f.a(new cq(l == null ? -1L : l.longValue()));
                return;
            }
            String str = bzVar.c;
            if (str != null) {
                lVar.c.a.a("mobileAgentToken", str);
                ADLog.log(2, "Calling [%s] to register agent.", lVar.b.c);
                InputStream inputStream = null;
                try {
                    try {
                        ci ciVar = lVar.b;
                        CollectorChannel collectorChannelNewCollectorChannel = ciVar.d.newCollectorChannel();
                        collectorChannelNewCollectorChannel.setURL(ciVar.c);
                        collectorChannelNewCollectorChannel.setRequestMethod("POST");
                        collectorChannelNewCollectorChannel.setConnectTimeout(30000);
                        collectorChannelNewCollectorChannel.setReadTimeout(30000);
                        ciVar.a.a(collectorChannelNewCollectorChannel);
                        collectorChannelNewCollectorChannel.setRequestMethod("POST");
                        collectorChannelNewCollectorChannel.addRequestProperty("sr", Characteristics.TRUE);
                        inputStream = collectorChannelNewCollectorChannel.getInputStream();
                        ct.a(inputStream);
                        ADLog.logInfo("Finished registering agent with collector.");
                    } catch (IOException e) {
                        ADLog.logAgentError("Exception while trying to register with collector", e);
                    }
                } finally {
                    ct.a((Closeable) inputStream);
                }
            }
            s sVar = bzVar.d;
            if (sVar != null) {
                lVar.f.a(sVar);
            }
        }
    }

    static /* synthetic */ void a(l lVar, List list) {
        aj ajVar;
        k kVar = lVar.e;
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            h hVar = (h) listIterator.previous();
            if ((hVar instanceof ad) || (hVar instanceof v) || (hVar instanceof y)) {
                ajVar = kVar.b;
                ADLog.log(1, "Adding old beacon [%s] to Crash BeaconQueue", hVar);
            } else {
                ajVar = kVar.a;
                ADLog.log(1, "Adding old beacon [%s] to BeaconQueue", hVar);
            }
            if (!ajVar.b.offerFirst(hVar)) {
                ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", hVar);
            }
        }
        synchronized (lVar) {
            try {
                int i = lVar.j + 1;
                lVar.j = i;
                lVar.l = false;
                if (i <= 3) {
                    ADLog.log(2, "Detected network error sending beacons to collector; trying again in %d ms", Long.valueOf(lVar.i));
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    long j = lVar.i;
                    lVar.k = jUptimeMillis + j;
                    lVar.i = (long) Math.pow(j, 1.2d);
                } else {
                    ADLog.log(2, "Detected %d failures in a row; queuing messages until next start up", i);
                    lVar.k = Long.MAX_VALUE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
