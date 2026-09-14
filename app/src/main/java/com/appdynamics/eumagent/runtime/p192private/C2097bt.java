package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.SessionFrame;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bt */
/* JADX INFO: loaded from: classes2.dex */
public final class C2097bt implements SessionFrame {

    /* JADX INFO: renamed from: a */
    public static final SessionFrame f720a = new SessionFrame() { // from class: com.appdynamics.eumagent.runtime.private.bt.1
        @Override // com.appdynamics.eumagent.runtime.SessionFrame
        public final void end() {
        }

        @Override // com.appdynamics.eumagent.runtime.SessionFrame
        public final void updateName(String str) {
        }
    };

    /* JADX INFO: renamed from: b */
    private final C2063am f721b;

    /* JADX INFO: renamed from: f */
    private String f725f;

    /* JADX INFO: renamed from: e */
    private C2123cs f724e = null;

    /* JADX INFO: renamed from: g */
    private boolean f726g = false;

    /* JADX INFO: renamed from: c */
    private final UUID f722c = UUID.randomUUID();

    /* JADX INFO: renamed from: d */
    private final C2123cs f723d = new C2123cs();

    public C2097bt(C2063am c2063am, String str) {
        this.f721b = c2063am;
        this.f725f = str;
        m620a("Session Frame Start");
    }

    @Override // com.appdynamics.eumagent.runtime.SessionFrame
    public final synchronized void updateName(String str) {
        if (!this.f726g) {
            this.f725f = str;
            m620a("Session Frame Update");
        } else {
            ADLog.logAppError("Session Frame has already ended. Cannot receive update.");
        }
    }

    @Override // com.appdynamics.eumagent.runtime.SessionFrame
    public final synchronized void end() {
        if (!this.f726g) {
            this.f724e = new C2123cs();
            this.f726g = true;
            m620a("Session Frame End");
            return;
        }
        ADLog.logAppError("Session Frame has already ended. Cannot end twice.");
    }

    /* JADX INFO: renamed from: a */
    private void m620a(String str) {
        this.f721b.m562a(new C2096bs(this.f725f, this.f723d, this.f724e, this.f722c, str));
    }
}
