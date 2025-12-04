package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class ce implements am.b {
    private final am a;
    private final Map<String, a> b = new HashMap();

    class a {
        UUID a;
        cs b;

        public a(UUID uuid, cs csVar) {
            this.a = uuid;
            this.b = csVar;
        }
    }

    public ce(am amVar) {
        this.a = amVar;
        amVar.a.a(cd.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof cd) {
            cd cdVar = (cd) obj;
            int i = cdVar.c;
            if (i == 0) {
                String str = cdVar.a + " " + cdVar.b;
                if (this.b.containsKey(str)) {
                    ADLog.logAgentError("A fragment has started twice without stopping");
                    return;
                }
                UUID uuidRandomUUID = UUID.randomUUID();
                this.b.put(str, new a(uuidRandomUUID, cdVar.d));
                this.a.a(new cc(cdVar.a, "Fragment Start", uuidRandomUUID, cdVar.d, null));
                return;
            }
            if (i == 1) {
                a aVarRemove = this.b.remove(cdVar.a + " " + cdVar.b);
                if (aVarRemove == null) {
                    ADLog.logAgentError("A fragment has stopped without starting");
                    return;
                } else {
                    this.a.a(new cc(cdVar.a, "Fragment End", aVarRemove.a, aVarRemove.b, cdVar.d));
                    return;
                }
            }
            if (i == 2) {
                a aVar = this.b.get(cdVar.a + " " + cdVar.b);
                if (aVar == null) {
                    ADLog.logAgentError("A fragment has paused without starting");
                    return;
                } else {
                    this.a.a(new cc(cdVar.a, "Fragment Pause", aVar.a, aVar.b, cdVar.d));
                    return;
                }
            }
            if (i == 3) {
                String str2 = cdVar.a + " " + cdVar.b;
                if (!this.b.containsKey(str2)) {
                    ADLog.logAgentError("A fragment has resumed without starting");
                } else {
                    this.a.a(new cc(cdVar.a, "Fragment Resume", this.b.get(str2).a, cdVar.d, null));
                }
            }
        }
    }
}
