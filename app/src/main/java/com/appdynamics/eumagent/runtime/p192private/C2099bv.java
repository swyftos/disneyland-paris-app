package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bv */
/* JADX INFO: loaded from: classes2.dex */
public final class C2099bv implements C2063am.b {

    /* JADX INFO: renamed from: a */
    private final C2063am f728a;

    /* JADX INFO: renamed from: b */
    private final Map<String, C2123cs> f729b;

    /* JADX INFO: renamed from: c */
    private final int f730c;

    private C2099bv(C2063am c2063am, byte b) {
        this.f729b = new HashMap();
        this.f728a = c2063am;
        this.f730c = 50;
        c2063am.f535a.m656a(C2100bw.class, this);
    }

    public C2099bv(C2063am c2063am) {
        this(c2063am, (byte) 0);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2100bw) {
            C2100bw c2100bw = (C2100bw) obj;
            if (!c2100bw.f732b) {
                String str = c2100bw.f731a;
                C2123cs c2123cs = c2100bw.f733c;
                if (!this.f729b.containsKey(str) && this.f729b.size() >= 50) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.log(2, "Reached maximum number of #%d pending timers. Dropping %s", Integer.valueOf(this.f729b.size()), str);
                        return;
                    }
                    return;
                }
                this.f729b.put(str, c2123cs);
                return;
            }
            String str2 = c2100bw.f731a;
            C2123cs c2123cs2 = c2100bw.f733c;
            C2123cs c2123csRemove = this.f729b.remove(str2);
            if (c2123csRemove != null) {
                this.f728a.m562a(new C2098bu(str2, c2123csRemove, c2123cs2));
            }
        }
    }
}
