package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.SessionFrame;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class bt implements SessionFrame {
    public static final SessionFrame a = new SessionFrame() { // from class: com.appdynamics.eumagent.runtime.private.bt.1
        @Override // com.appdynamics.eumagent.runtime.SessionFrame
        public final void end() {
        }

        @Override // com.appdynamics.eumagent.runtime.SessionFrame
        public final void updateName(String str) {
        }
    };
    private final am b;
    private String f;
    private cs e = null;
    private boolean g = false;
    private final UUID c = UUID.randomUUID();
    private final cs d = new cs();

    public bt(am amVar, String str) {
        this.b = amVar;
        this.f = str;
        a("Session Frame Start");
    }

    @Override // com.appdynamics.eumagent.runtime.SessionFrame
    public final synchronized void updateName(String str) {
        if (!this.g) {
            this.f = str;
            a("Session Frame Update");
        } else {
            ADLog.logAppError("Session Frame has already ended. Cannot receive update.");
        }
    }

    @Override // com.appdynamics.eumagent.runtime.SessionFrame
    public final synchronized void end() {
        if (!this.g) {
            this.e = new cs();
            this.g = true;
            a("Session Frame End");
            return;
        }
        ADLog.logAppError("Session Frame has already ended. Cannot end twice.");
    }

    private void a(String str) {
        this.b.a(new bs(this.f, this.d, this.e, this.c, str));
    }
}
