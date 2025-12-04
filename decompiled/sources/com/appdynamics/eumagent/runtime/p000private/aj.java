package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes2.dex */
public final class aj {
    public final ag a;
    public final BlockingDeque<h> b;
    private final int c;

    public aj(ag agVar, am amVar, int i) {
        this.a = agVar;
        this.c = i;
        this.b = new LinkedBlockingDeque(i);
        amVar.a(new am.d(new a(this, (byte) 0), 30000L, 30000L));
    }

    public final boolean a(h hVar) {
        if (this.b.offerLast(hVar)) {
            return true;
        }
        ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", this.b.removeFirst());
        if (this.b.offerLast(hVar)) {
            return true;
        }
        if (!ADLog.isInfoLoggingEnabled()) {
            return false;
        }
        ADLog.logAgentError(String.format("Beacon queue is still full; agent dropped new beacon [%s]", hVar));
        return false;
    }

    public final void a() {
        ADLog.logVerbose("Agent persisting beacon queue state");
        ArrayList arrayList = new ArrayList();
        this.b.drainTo(arrayList);
        ADLog.log(1, "Persisting %d beacons", arrayList.size());
        try {
            this.a.a(arrayList);
        } catch (Throwable th) {
            ADLog.logAgentError("Error writing beacons to database", th);
        }
    }

    private void c() throws InterruptedException {
        List<o> listEmptyList;
        ADLog.logVerbose("Loading persisted beacons into BeaconQueue");
        try {
            listEmptyList = this.a.a(this.c - this.b.size());
        } catch (Throwable th) {
            ADLog.logAgentError("Error reading beacons from database", th);
            listEmptyList = Collections.emptyList();
        }
        b();
        ListIterator<o> listIterator = listEmptyList.listIterator(listEmptyList.size());
        int i = 0;
        int i2 = 0;
        while (listIterator.hasPrevious()) {
            o oVarPrevious = listIterator.previous();
            if (this.b.offerFirst(oVarPrevious)) {
                i++;
            } else {
                ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", oVarPrevious);
                i2++;
            }
        }
        ADLog.log(1, "Finished loading %d persisted beacons into BeaconQueue (dropped %d)", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void a(List<h> list) {
        c();
        this.b.drainTo(list);
    }

    public final void b() throws InterruptedException {
        double dPow = Math.pow(100.0d, 0.5d);
        boolean z = false;
        Throwable th = null;
        double d = 1.0d;
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            try {
                ag agVar = this.a;
                ah.a(agVar.a, agVar.b);
                z = true;
                break;
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
                if (i == 2) {
                    break;
                }
                d *= dPow;
                try {
                    Thread.sleep((long) d);
                } catch (InterruptedException unused) {
                }
                i++;
            }
        }
        if (z) {
            return;
        }
        ADLog.logAgentError("Error clearing beacons from database", th);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(aj ajVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            aj.this.a();
        }

        public final String toString() {
            return "PersistQueueTask";
        }
    }
}
