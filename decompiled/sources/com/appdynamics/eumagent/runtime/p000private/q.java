package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.AgentConfiguration;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;

/* loaded from: classes2.dex */
public class q implements am.b {
    public final s a;
    public final AgentConfiguration b;
    private final r c;

    public q(r rVar, AgentConfiguration agentConfiguration, am amVar) {
        this.c = rVar;
        this.a = rVar.a();
        this.b = agentConfiguration;
        amVar.a.a(s.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) throws Throwable {
        if (obj instanceof s) {
            s sVar = (s) obj;
            Long l = sVar.d;
            if (l == null) {
                ADLog.logAgentError("Server-side AgentConfiguration has no timestamp!");
                return;
            }
            s sVar2 = this.a;
            sVar2.d = l;
            Boolean bool = sVar.c;
            if (bool != null) {
                sVar2.c = bool;
            }
            Boolean bool2 = sVar.a;
            if (bool2 != null) {
                sVar2.a = bool2;
            }
            Boolean bool3 = sVar.b;
            if (bool3 != null) {
                sVar2.b = bool3;
            }
            Boolean bool4 = sVar.e;
            if (bool4 != null) {
                sVar2.e = bool4;
            }
            Boolean bool5 = sVar.f;
            if (bool5 != null) {
                sVar2.f = bool5;
            }
            Boolean bool6 = sVar.g;
            if (bool6 != null) {
                sVar2.g = bool6;
            }
            Boolean bool7 = sVar.j;
            if (bool7 != null) {
                sVar2.j = bool7;
            }
            Boolean bool8 = sVar.k;
            if (bool8 != null) {
                sVar2.k = bool8;
            }
            Boolean bool9 = sVar.l;
            if (bool9 != null) {
                sVar2.l = bool9;
            }
            Integer num = sVar.m;
            if (num != null) {
                sVar2.m = num;
            }
            Integer num2 = sVar.n;
            if (num2 != null) {
                sVar2.n = num2;
            }
            Integer num3 = sVar.o;
            if (num3 != null) {
                sVar2.o = num3;
            }
            Integer num4 = sVar.p;
            if (num4 != null) {
                sVar2.p = num4;
            }
            Long l2 = sVar.i;
            if (l2 != null) {
                if (l2.longValue() > 100) {
                    this.a.i = sVar.i;
                } else {
                    this.a.i = 100L;
                }
            }
            s sVar3 = this.a;
            sVar3.h = sVar.h;
            this.c.a(sVar3);
        }
    }

    public final boolean a() {
        return this.b.screenshotsEnabled && this.a.a.booleanValue() && !Instrumentation.screenshotsBlocked();
    }
}
