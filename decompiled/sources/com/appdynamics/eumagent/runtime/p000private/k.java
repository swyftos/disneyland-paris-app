package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;

/* loaded from: classes2.dex */
public final class k implements am.b {
    public final aj a;
    public final aj b;
    final q c;

    public k(aj ajVar, aj ajVar2, am amVar, q qVar) {
        this.a = ajVar;
        this.b = ajVar2;
        this.c = qVar;
        amVar.a.a(cq.class, this);
        amVar.a.a(d.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) throws InterruptedException {
        if (obj instanceof cq) {
            this.a.a();
            this.b.a();
            this.a.a.a.close();
            this.b.a.a.close();
            return;
        }
        if (obj instanceof d) {
            ADLog.logInfo("App key has changed, dropping older beacons.");
            aj ajVar = this.a;
            ajVar.b.clear();
            ajVar.b();
            aj ajVar2 = this.b;
            ajVar2.b.clear();
            ajVar2.b();
        }
    }
}
