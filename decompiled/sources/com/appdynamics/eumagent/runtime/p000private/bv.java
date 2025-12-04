package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class bv implements am.b {
    private final am a;
    private final Map<String, cs> b;
    private final int c;

    private bv(am amVar, byte b) {
        this.b = new HashMap();
        this.a = amVar;
        this.c = 50;
        amVar.a.a(bw.class, this);
    }

    public bv(am amVar) {
        this(amVar, (byte) 0);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof bw) {
            bw bwVar = (bw) obj;
            if (!bwVar.b) {
                String str = bwVar.a;
                cs csVar = bwVar.c;
                if (!this.b.containsKey(str) && this.b.size() >= 50) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.log(2, "Reached maximum number of #%d pending timers. Dropping %s", Integer.valueOf(this.b.size()), str);
                        return;
                    }
                    return;
                }
                this.b.put(str, csVar);
                return;
            }
            String str2 = bwVar.a;
            cs csVar2 = bwVar.c;
            cs csVarRemove = this.b.remove(str2);
            if (csVarRemove != null) {
                this.a.a(new bu(str2, csVarRemove, csVar2));
            }
        }
    }
}
