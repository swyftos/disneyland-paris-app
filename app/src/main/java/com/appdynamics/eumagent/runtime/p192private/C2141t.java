package com.appdynamics.eumagent.runtime.p192private;

import android.os.Handler;
import android.os.Looper;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.File;
import java.util.Date;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.t */
/* JADX INFO: loaded from: classes2.dex */
public final class C2141t implements C2063am.b {

    /* JADX INFO: renamed from: a */
    volatile int f922a;

    /* JADX INFO: renamed from: b */
    final Handler f923b;

    /* JADX INFO: renamed from: c */
    final Thread f924c;

    /* JADX INFO: renamed from: d */
    public long f925d;

    /* JADX INFO: renamed from: e */
    public final C2063am f926e;

    /* JADX INFO: renamed from: f */
    final C2144w f927f;

    /* JADX INFO: renamed from: g */
    File f928g;

    /* JADX INFO: renamed from: h */
    int f929h;

    /* JADX INFO: renamed from: i */
    final Runnable f930i;

    /* JADX INFO: renamed from: j */
    public final Runnable f931j;

    public C2141t(long j, C2063am c2063am, C2144w c2144w) {
        this(j, new Handler(Looper.getMainLooper()), c2063am, c2144w);
    }

    private C2141t(long j, Handler handler, C2063am c2063am, C2144w c2144w) {
        this.f922a = 0;
        this.f929h = 0;
        this.f930i = new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.t.1
            @Override // java.lang.Runnable
            public final void run() {
                C2141t.this.f922a++;
            }
        };
        this.f931j = new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.t.2

            /* JADX INFO: renamed from: a */
            private int f933a;

            /* JADX INFO: renamed from: b */
            private C2123cs f934b;

            /* JADX INFO: renamed from: c */
            private int f935c = 0;

            /* JADX INFO: renamed from: d */
            private int f936d = -1;

            /* JADX INFO: renamed from: e */
            private boolean f937e = false;

            /* JADX INFO: renamed from: f */
            private boolean f938f = false;

            /* JADX INFO: renamed from: g */
            private C2123cs f939g;

            /* JADX INFO: renamed from: h */
            private StackTraceElement[] f940h;

            @Override // java.lang.Runnable
            public final void run() {
                C2141t c2141t = C2141t.this;
                if (c2141t.f929h == 0) {
                    this.f937e = false;
                    return;
                }
                this.f933a = c2141t.f922a;
                C2123cs c2123cs = new C2123cs();
                this.f934b = c2123cs;
                if (this.f937e) {
                    int i = this.f935c;
                    int i2 = this.f933a;
                    if (i != i2) {
                        if (this.f938f) {
                            long j2 = c2123cs.f817a;
                            C2123cs c2123cs2 = this.f939g;
                            if (j2 - c2123cs2.f817a >= (C2141t.this.f925d * 2) + 100) {
                                C2141t.this.f926e.m562a(new C2142u(c2123cs2, c2123cs, this.f940h));
                            }
                            C2141t c2141t2 = C2141t.this;
                            try {
                                File file = c2141t2.f928g;
                                if (file != null) {
                                    file.delete();
                                    c2141t2.f928g = null;
                                }
                            } catch (Throwable th) {
                                ADLog.logAgentError("Error trying to delete ANR crash file", th);
                            }
                            this.f938f = false;
                        }
                        C2141t c2141t3 = C2141t.this;
                        c2141t3.f923b.post(c2141t3.f930i);
                        this.f939g = this.f934b;
                    } else if (i2 != this.f936d) {
                        if (ADLog.isInfoLoggingEnabled()) {
                            ADLog.logInfo("Application is not responsive since: " + new Date(this.f939g.f818b) + ". Creating ANR report.");
                        }
                        this.f938f = true;
                        StackTraceElement[] stackTrace = C2141t.this.f924c.getStackTrace();
                        this.f940h = stackTrace;
                        this.f936d = this.f933a;
                        C2141t c2141t4 = C2141t.this;
                        try {
                            C2122cr c2122cr = new C2122cr("AppNotResponding", "Application not responsive since: " + new Date(this.f939g.f818b));
                            c2122cr.setStackTrace(stackTrace);
                            c2141t4.f928g = c2141t4.f927f.m717a(c2141t4.f924c, c2122cr);
                        } catch (Throwable th2) {
                            ADLog.logAgentError("Error trying to write ANR crash file", th2);
                        }
                    }
                } else {
                    C2141t c2141t5 = C2141t.this;
                    c2141t5.f923b.post(c2141t5.f930i);
                    this.f939g = this.f934b;
                    this.f937e = true;
                }
                this.f935c = this.f933a;
            }

            public final String toString() {
                return "ANRCheckRunnable";
            }
        };
        if (j < 100) {
            throw new IllegalArgumentException("Detection period cannot be less than 100 ms.");
        }
        this.f923b = handler;
        this.f925d = j / 2;
        this.f924c = Looper.getMainLooper().getThread();
        this.f926e = c2063am;
        this.f927f = c2144w;
        c2063am.f535a.m656a(C2102by.class, this);
        c2063am.f535a.m656a(C2121cq.class, this);
        c2063am.f535a.m656a(C2140s.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        C2140s c2140s;
        Long l;
        if (obj instanceof C2102by) {
            int i = ((C2102by) obj).f740a;
            if (i == 2) {
                this.f929h++;
                return;
            } else {
                if (i != 3) {
                    return;
                }
                this.f929h--;
                return;
            }
        }
        if (!(obj instanceof C2121cq)) {
            if (!(obj instanceof C2140s) || (l = (c2140s = (C2140s) obj).f914i) == null || l.longValue() < 100) {
                return;
            }
            this.f925d = c2140s.f914i.longValue() / 2;
            return;
        }
        try {
            File file = this.f928g;
            if (file != null) {
                file.delete();
                this.f928g = null;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Error trying to delete ANR crash file", th);
        }
    }
}
