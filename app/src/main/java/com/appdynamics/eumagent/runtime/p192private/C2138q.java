package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.AgentConfiguration;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.logging.ADLog;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.q */
/* JADX INFO: loaded from: classes2.dex */
public class C2138q implements C2063am.b {

    /* JADX INFO: renamed from: a */
    public final C2140s f902a;

    /* JADX INFO: renamed from: b */
    public final AgentConfiguration f903b;

    /* JADX INFO: renamed from: c */
    private final C2139r f904c;

    public C2138q(C2139r c2139r, AgentConfiguration agentConfiguration, C2063am c2063am) {
        this.f904c = c2139r;
        this.f902a = c2139r.m709a();
        this.f903b = agentConfiguration;
        c2063am.f535a.m656a(C2140s.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2140s) {
            C2140s c2140s = (C2140s) obj;
            Long l = c2140s.f909d;
            if (l == null) {
                ADLog.logAgentError("Server-side AgentConfiguration has no timestamp!");
                return;
            }
            C2140s c2140s2 = this.f902a;
            c2140s2.f909d = l;
            Boolean bool = c2140s.f908c;
            if (bool != null) {
                c2140s2.f908c = bool;
            }
            Boolean bool2 = c2140s.f906a;
            if (bool2 != null) {
                c2140s2.f906a = bool2;
            }
            Boolean bool3 = c2140s.f907b;
            if (bool3 != null) {
                c2140s2.f907b = bool3;
            }
            Boolean bool4 = c2140s.f910e;
            if (bool4 != null) {
                c2140s2.f910e = bool4;
            }
            Boolean bool5 = c2140s.f911f;
            if (bool5 != null) {
                c2140s2.f911f = bool5;
            }
            Boolean bool6 = c2140s.f912g;
            if (bool6 != null) {
                c2140s2.f912g = bool6;
            }
            Boolean bool7 = c2140s.f915j;
            if (bool7 != null) {
                c2140s2.f915j = bool7;
            }
            Boolean bool8 = c2140s.f916k;
            if (bool8 != null) {
                c2140s2.f916k = bool8;
            }
            Boolean bool9 = c2140s.f917l;
            if (bool9 != null) {
                c2140s2.f917l = bool9;
            }
            Integer num = c2140s.f918m;
            if (num != null) {
                c2140s2.f918m = num;
            }
            Integer num2 = c2140s.f919n;
            if (num2 != null) {
                c2140s2.f919n = num2;
            }
            Integer num3 = c2140s.f920o;
            if (num3 != null) {
                c2140s2.f920o = num3;
            }
            Integer num4 = c2140s.f921p;
            if (num4 != null) {
                c2140s2.f921p = num4;
            }
            Long l2 = c2140s.f914i;
            if (l2 != null) {
                if (l2.longValue() > 100) {
                    this.f902a.f914i = c2140s.f914i;
                } else {
                    this.f902a.f914i = 100L;
                }
            }
            C2140s c2140s3 = this.f902a;
            c2140s3.f913h = c2140s.f913h;
            this.f904c.m710a(c2140s3);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m708a() {
        return this.f903b.screenshotsEnabled && this.f902a.f906a.booleanValue() && !Instrumentation.screenshotsBlocked();
    }
}
