package com.appdynamics.eumagent.runtime.p000private;

import android.os.Handler;
import android.os.Looper;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.io.File;
import java.util.Date;

/* loaded from: classes2.dex */
public final class t implements am.b {
    volatile int a;
    final Handler b;
    final Thread c;
    public long d;
    public final am e;
    final w f;
    File g;
    int h;
    final Runnable i;
    public final Runnable j;

    public t(long j, am amVar, w wVar) {
        this(j, new Handler(Looper.getMainLooper()), amVar, wVar);
    }

    private t(long j, Handler handler, am amVar, w wVar) {
        this.a = 0;
        this.h = 0;
        this.i = new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.t.1
            @Override // java.lang.Runnable
            public final void run() {
                t.this.a++;
            }
        };
        this.j = new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.t.2
            private int a;
            private cs b;
            private int c = 0;
            private int d = -1;
            private boolean e = false;
            private boolean f = false;
            private cs g;
            private StackTraceElement[] h;

            @Override // java.lang.Runnable
            public final void run() {
                t tVar = t.this;
                if (tVar.h == 0) {
                    this.e = false;
                    return;
                }
                this.a = tVar.a;
                cs csVar = new cs();
                this.b = csVar;
                if (this.e) {
                    int i = this.c;
                    int i2 = this.a;
                    if (i != i2) {
                        if (this.f) {
                            long j2 = csVar.a;
                            cs csVar2 = this.g;
                            if (j2 - csVar2.a >= (t.this.d * 2) + 100) {
                                t.this.e.a(new u(csVar2, csVar, this.h));
                            }
                            t tVar2 = t.this;
                            try {
                                File file = tVar2.g;
                                if (file != null) {
                                    file.delete();
                                    tVar2.g = null;
                                }
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error trying to delete ANR crash file", th);
                            }
                            this.f = false;
                        }
                        t tVar3 = t.this;
                        tVar3.b.post(tVar3.i);
                        this.g = this.b;
                    } else if (i2 != this.d) {
                        if (ADLog.isInfoLoggingEnabled()) {
                            ADLog.logInfo("Application is not responsive since: " + new Date(this.g.b) + ". Creating ANR report.");
                        }
                        this.f = true;
                        StackTraceElement[] stackTrace = t.this.c.getStackTrace();
                        this.h = stackTrace;
                        this.d = this.a;
                        t tVar4 = t.this;
                        try {
                            cr crVar = new cr("AppNotResponding", "Application not responsive since: " + new Date(this.g.b));
                            crVar.setStackTrace(stackTrace);
                            tVar4.g = tVar4.f.a(tVar4.c, crVar);
                        } catch (Throwable th2) {
                            ADLog.logAgentError("Error trying to write ANR crash file", th2);
                        }
                    }
                } else {
                    t tVar5 = t.this;
                    tVar5.b.post(tVar5.i);
                    this.g = this.b;
                    this.e = true;
                }
                this.c = this.a;
            }

            public final String toString() {
                return "ANRCheckRunnable";
            }
        };
        if (j < 100) {
            throw new IllegalArgumentException("Detection period cannot be less than 100 ms.");
        }
        this.b = handler;
        this.d = j / 2;
        this.c = Looper.getMainLooper().getThread();
        this.e = amVar;
        this.f = wVar;
        amVar.a.a(by.class, this);
        amVar.a.a(cq.class, this);
        amVar.a.a(s.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        s sVar;
        Long l;
        if (obj instanceof by) {
            int i = ((by) obj).a;
            if (i == 2) {
                this.h++;
                return;
            } else {
                if (i != 3) {
                    return;
                }
                this.h--;
                return;
            }
        }
        if (!(obj instanceof cq)) {
            if (!(obj instanceof s) || (l = (sVar = (s) obj).i) == null || l.longValue() < 100) {
                return;
            }
            this.d = sVar.i.longValue() / 2;
            return;
        }
        try {
            File file = this.g;
            if (file != null) {
                file.delete();
                this.g = null;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Error trying to delete ANR crash file", th);
        }
    }
}
