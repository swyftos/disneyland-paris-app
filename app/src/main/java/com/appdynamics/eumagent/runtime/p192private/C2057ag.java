package com.appdynamics.eumagent.runtime.p192private;

import android.database.sqlite.SQLiteDatabase;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ag */
/* JADX INFO: loaded from: classes2.dex */
public final class C2057ag {

    /* JADX INFO: renamed from: a */
    public final SQLiteDatabase f511a;

    /* JADX INFO: renamed from: b */
    final String f512b;

    /* JADX INFO: renamed from: c */
    private final int f513c;

    /* JADX INFO: renamed from: d */
    private final C2136o.a f514d;

    public C2057ag(C2058ah c2058ah, String str, C2136o.a aVar, int i) {
        this.f514d = aVar;
        this.f511a = c2058ah.getWritableDatabase();
        this.f513c = i;
        this.f512b = str;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m538a(List<AbstractC2129h> list) {
        if (list.isEmpty()) {
            return true;
        }
        Iterator<AbstractC2129h> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (C2058ah.m542a(this.f511a, this.f512b, it.next())) {
                z = true;
            }
        }
        if (z) {
            C2058ah.m541a(this.f511a, this.f512b, this.f513c);
        }
        return list.isEmpty() || z;
    }

    /* JADX INFO: renamed from: a */
    public final List<C2136o> m537a(int i) {
        try {
            return C2058ah.m539a(this.f511a, this.f512b, i, this.f514d);
        } catch (IllegalStateException e) {
            ADLog.logAgentError("Failed to read persisted beacons", e);
            C2058ah.m540a(this.f511a, this.f512b);
            return new ArrayList();
        }
    }
}
