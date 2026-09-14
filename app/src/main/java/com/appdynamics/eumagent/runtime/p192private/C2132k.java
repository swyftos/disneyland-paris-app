package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.k */
/* JADX INFO: loaded from: classes2.dex */
public final class C2132k implements C2063am.b {

    /* JADX INFO: renamed from: a */
    public final C2060aj f878a;

    /* JADX INFO: renamed from: b */
    public final C2060aj f879b;

    /* JADX INFO: renamed from: c */
    final C2138q f880c;

    public C2132k(C2060aj c2060aj, C2060aj c2060aj2, C2063am c2063am, C2138q c2138q) {
        this.f878a = c2060aj;
        this.f879b = c2060aj2;
        this.f880c = c2138q;
        c2063am.f535a.m656a(C2121cq.class, this);
        c2063am.f535a.m656a(C2125d.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2121cq) {
            this.f878a.m545a();
            this.f879b.m545a();
            this.f878a.f516a.f511a.close();
            this.f879b.f516a.f511a.close();
            return;
        }
        if (obj instanceof C2125d) {
            ADLog.logInfo("App key has changed, dropping older beacons.");
            C2060aj c2060aj = this.f878a;
            c2060aj.f517b.clear();
            c2060aj.m548b();
            C2060aj c2060aj2 = this.f879b;
            c2060aj2.f517b.clear();
            c2060aj2.m548b();
        }
    }
}
