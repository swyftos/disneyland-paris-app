package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ce */
/* JADX INFO: loaded from: classes2.dex */
public final class C2109ce implements C2063am.b {

    /* JADX INFO: renamed from: a */
    private final C2063am f767a;

    /* JADX INFO: renamed from: b */
    private final Map<String, a> f768b = new HashMap();

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ce$a */
    class a {

        /* JADX INFO: renamed from: a */
        UUID f769a;

        /* JADX INFO: renamed from: b */
        C2123cs f770b;

        public a(UUID uuid, C2123cs c2123cs) {
            this.f769a = uuid;
            this.f770b = c2123cs;
        }
    }

    public C2109ce(C2063am c2063am) {
        this.f767a = c2063am;
        c2063am.f535a.m656a(C2108cd.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2108cd) {
            C2108cd c2108cd = (C2108cd) obj;
            int i = c2108cd.f765c;
            if (i == 0) {
                String str = c2108cd.f763a + " " + c2108cd.f764b;
                if (this.f768b.containsKey(str)) {
                    ADLog.logAgentError("A fragment has started twice without stopping");
                    return;
                }
                UUID uuidRandomUUID = UUID.randomUUID();
                this.f768b.put(str, new a(uuidRandomUUID, c2108cd.f766d));
                this.f767a.m562a(new C2107cc(c2108cd.f763a, "Fragment Start", uuidRandomUUID, c2108cd.f766d, null));
                return;
            }
            if (i == 1) {
                a aVarRemove = this.f768b.remove(c2108cd.f763a + " " + c2108cd.f764b);
                if (aVarRemove == null) {
                    ADLog.logAgentError("A fragment has stopped without starting");
                    return;
                } else {
                    this.f767a.m562a(new C2107cc(c2108cd.f763a, "Fragment End", aVarRemove.f769a, aVarRemove.f770b, c2108cd.f766d));
                    return;
                }
            }
            if (i == 2) {
                a aVar = this.f768b.get(c2108cd.f763a + " " + c2108cd.f764b);
                if (aVar == null) {
                    ADLog.logAgentError("A fragment has paused without starting");
                    return;
                } else {
                    this.f767a.m562a(new C2107cc(c2108cd.f763a, "Fragment Pause", aVar.f769a, aVar.f770b, c2108cd.f766d));
                    return;
                }
            }
            if (i == 3) {
                String str2 = c2108cd.f763a + " " + c2108cd.f764b;
                if (!this.f768b.containsKey(str2)) {
                    ADLog.logAgentError("A fragment has resumed without starting");
                } else {
                    this.f767a.m562a(new C2107cc(c2108cd.f763a, "Fragment Resume", this.f768b.get(str2).f769a, c2108cd.f766d, null));
                }
            }
        }
    }
}
