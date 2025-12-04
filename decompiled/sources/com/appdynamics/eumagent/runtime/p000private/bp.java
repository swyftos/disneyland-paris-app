package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class bp implements am.b {
    private final am c;
    private final q d;
    private int e;
    private int f;
    private final SparseArray<List<bo>> b = new SparseArray<>();
    private View g = null;
    private cs h = null;
    private String i = null;
    private String j = null;
    private long k = 0;
    long a = 0;

    public bp(am amVar, q qVar) {
        this.d = qVar;
        this.c = amVar;
        amVar.a.a(bd.class, this);
        amVar.a.a(be.class, this);
        amVar.a(new am.d(new a(), 30000L, 30000L));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    @Override // com.appdynamics.eumagent.runtime.private.am.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.p000private.bp.a(java.lang.Object):void");
    }

    final void a() {
        if (this.i == null && this.j == null) {
            ADLog.logVerbose("Current screenshot == null, no need to beaconize touches");
            return;
        }
        int size = this.b.size();
        if (size != 0) {
            ADLog.log(1, "Beaconizing %d tracks", size);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                List<bo> listValueAt = this.b.valueAt(i);
                arrayList.add(listValueAt);
                if (ADLog.isVerboseLoggingEnabled()) {
                    ADLog.log(1, "Track #%d has %d points", Integer.valueOf(i), Integer.valueOf(listValueAt.size()));
                }
            }
            this.c.a(new bq(this.h, arrayList, this.i, this.j));
        } else {
            ADLog.logVerbose("Not flushing touches because none recorded since last flush");
        }
        this.b.clear();
        this.h = null;
        this.a = SystemClock.uptimeMillis();
        this.k = 0L;
    }

    class a implements Runnable {
        a() {
        }

        public final String toString() {
            return "FlushTouchesRunnable";
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SystemClock.uptimeMillis() > bp.this.a + 30000) {
                ADLog.logVerbose("Triggering periodic touch flush");
                bp.this.a();
            } else {
                ADLog.logVerbose("Not triggering periodic touch flush, not enough time has passed");
            }
        }
    }
}
