package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aj */
/* JADX INFO: loaded from: classes2.dex */
public final class C2060aj {

    /* JADX INFO: renamed from: a */
    public final C2057ag f516a;

    /* JADX INFO: renamed from: b */
    public final BlockingDeque<AbstractC2129h> f517b;

    /* JADX INFO: renamed from: c */
    private final int f518c;

    public C2060aj(C2057ag c2057ag, C2063am c2063am, int i) {
        this.f516a = c2057ag;
        this.f518c = i;
        this.f517b = new LinkedBlockingDeque(i);
        c2063am.m562a(new C2063am.d(new a(this, (byte) 0), 30000L, 30000L));
    }

    /* JADX INFO: renamed from: a */
    public final boolean m547a(AbstractC2129h abstractC2129h) {
        if (this.f517b.offerLast(abstractC2129h)) {
            return true;
        }
        ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", this.f517b.removeFirst());
        if (this.f517b.offerLast(abstractC2129h)) {
            return true;
        }
        if (!ADLog.isInfoLoggingEnabled()) {
            return false;
        }
        ADLog.logAgentError(String.format("Beacon queue is still full; agent dropped new beacon [%s]", abstractC2129h));
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m545a() {
        ADLog.logVerbose("Agent persisting beacon queue state");
        ArrayList arrayList = new ArrayList();
        this.f517b.drainTo(arrayList);
        ADLog.log(1, "Persisting %d beacons", arrayList.size());
        try {
            this.f516a.m538a(arrayList);
        } catch (Throwable th) {
            ADLog.logAgentError("Error writing beacons to database", th);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m544c() {
        List<C2136o> listEmptyList;
        ADLog.logVerbose("Loading persisted beacons into BeaconQueue");
        try {
            listEmptyList = this.f516a.m537a(this.f518c - this.f517b.size());
        } catch (Throwable th) {
            ADLog.logAgentError("Error reading beacons from database", th);
            listEmptyList = Collections.emptyList();
        }
        m548b();
        ListIterator<C2136o> listIterator = listEmptyList.listIterator(listEmptyList.size());
        int i = 0;
        int i2 = 0;
        while (listIterator.hasPrevious()) {
            C2136o c2136oPrevious = listIterator.previous();
            if (this.f517b.offerFirst(c2136oPrevious)) {
                i++;
            } else {
                ADLog.log(2, "Beacon queue is full; agent dropped old beacon [%s]", c2136oPrevious);
                i2++;
            }
        }
        ADLog.log(1, "Finished loading %d persisted beacons into BeaconQueue (dropped %d)", Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: a */
    public final void m546a(List<AbstractC2129h> list) {
        m544c();
        this.f517b.drainTo(list);
    }

    /* JADX INFO: renamed from: b */
    public final void m548b() {
        double dPow = Math.pow(100.0d, 0.5d);
        boolean z = false;
        Throwable th = null;
        double d = 1.0d;
        for (int i = 0; i < 3; i++) {
            try {
                C2057ag c2057ag = this.f516a;
                C2058ah.m540a(c2057ag.f511a, c2057ag.f512b);
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
            }
        }
        if (z) {
            return;
        }
        ADLog.logAgentError("Error clearing beacons from database", th);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aj$a */
    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(C2060aj c2060aj, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2060aj.this.m545a();
        }

        public final String toString() {
            return "PersistQueueTask";
        }
    }
}
