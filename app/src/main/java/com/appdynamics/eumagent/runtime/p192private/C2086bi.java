package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p192private.C2084bg.b;
import com.appdynamics.eumagent.runtime.p192private.C2091bn.a;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bi */
/* JADX INFO: loaded from: classes2.dex */
public final class C2086bi implements C2063am.b {

    /* JADX INFO: renamed from: j */
    private static boolean f666j = false;

    /* JADX INFO: renamed from: a */
    private final C2084bg f667a;

    /* JADX INFO: renamed from: b */
    private final C2091bn f668b;

    /* JADX INFO: renamed from: c */
    private final C2063am f669c;

    /* JADX INFO: renamed from: d */
    private final C2138q f670d;

    /* JADX INFO: renamed from: e */
    private C2127f f671e;

    /* JADX INFO: renamed from: f */
    private View f672f = null;

    /* JADX INFO: renamed from: g */
    private C2083bf f673g;

    /* JADX INFO: renamed from: h */
    private C2123cs f674h;

    /* JADX INFO: renamed from: i */
    private C2123cs f675i;

    public C2086bi(C2063am c2063am, C2084bg c2084bg, C2091bn c2091bn, C2138q c2138q, C2127f c2127f) {
        this.f669c = c2063am;
        this.f667a = c2084bg;
        this.f668b = c2091bn;
        this.f670d = c2138q;
        this.f671e = c2127f;
        c2063am.f535a.m656a(C2088bk.class, this);
        c2063am.f535a.m656a(C2082be.class, this);
        c2063am.f535a.m656a(MotionEvent.class, this);
        c2063am.f535a.m656a(C2083bf.class, this);
        c2063am.f535a.m656a(C2140s.class, this);
        c2063am.m562a(new C2063am.d(new a(), 10000L, 10000L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m598b(boolean z) {
        C2123cs c2123cs;
        if (this.f672f == null) {
            ADLog.logVerbose("Tried to take screenshot, but rootView was null");
            return;
        }
        if (z && (c2123cs = this.f675i) != null && c2123cs.f817a + 10000 > SystemClock.uptimeMillis()) {
            ADLog.logVerbose("Skipping manual screenshot because not enough time has passed");
            return;
        }
        C2084bg c2084bg = this.f667a;
        View view = this.f672f;
        if (!c2084bg.f656e) {
            c2084bg.f656e = true;
            c2084bg.f653b.post(c2084bg.new b(view));
        }
        if (z) {
            this.f675i = new C2123cs();
        } else {
            this.f674h = new C2123cs();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m596a(boolean z) {
        f666j = z;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2088bk) {
            if (!this.f670d.m708a()) {
                ADLog.logInfo("Not taking screenshot from API call because capturing is disabled");
                return;
            }
            if (!this.f670d.f902a.f907b.booleanValue() && this.f671e.m690b()) {
                ADLog.logInfo("Not taking screenshot from API call because upload on cellular connection is disabledand device is on cellular mobile connection");
                return;
            } else if (f666j) {
                ADLog.logInfo("Not taking screenshot from API call because a text field is currently in focus");
                return;
            } else {
                ADLog.logInfo("Triggering screenshot from API call");
                m598b(true);
                return;
            }
        }
        if (obj instanceof C2082be) {
            this.f672f = ((C2082be) obj).f644a;
            return;
        }
        if (obj instanceof MotionEvent) {
            C2138q c2138q = this.f670d;
            if (c2138q.m708a() && c2138q.f902a.f908c.booleanValue()) {
                MotionEvent motionEvent = (MotionEvent) obj;
                C2081bd c2081bd = new C2081bd(motionEvent);
                if (motionEvent.getActionMasked() == 0) {
                    C2083bf c2083bf = this.f673g;
                    if (c2083bf != null) {
                        c2081bd.f643c = c2083bf.f645a;
                    }
                    if (f666j) {
                        ADLog.logInfo("Not taking screenshot from API call because a text field is currently in focus");
                        return;
                    }
                    m598b(false);
                    C2083bf c2083bf2 = this.f673g;
                    if (c2083bf2 != null) {
                        c2081bd.f642b = c2083bf2.f645a;
                    }
                }
                this.f669c.m562a(c2081bd);
                return;
            }
            return;
        }
        if (obj instanceof C2083bf) {
            C2083bf c2083bf3 = (C2083bf) obj;
            if (c2083bf3.equals(this.f673g)) {
                ADLog.logVerbose("Dropping screenshot because nothing changed from the previous");
                return;
            }
            C2091bn c2091bn = this.f668b;
            c2091bn.f688b.execute(c2091bn.new a(c2083bf3.f646b, c2083bf3.f648d));
            this.f669c.m562a(new C2085bh(c2083bf3.f645a, c2083bf3.f647c, c2083bf3.f649e, c2083bf3.f650f, c2083bf3.f646b, 4));
            this.f673g = c2083bf3;
            return;
        }
        if (obj instanceof C2140s) {
            C2138q c2138q2 = this.f670d;
            if (c2138q2.f903b.screenshotsEnabled && c2138q2.f902a.f906a.booleanValue()) {
                return;
            }
            this.f668b.f687a.m616b();
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bi$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2138q c2138q = C2086bi.this.f670d;
            if (c2138q.m708a() && c2138q.f902a.f908c.booleanValue()) {
                if ((C2086bi.this.f674h != null && C2086bi.this.f674h.f817a + 10000 > SystemClock.uptimeMillis()) || (C2086bi.this.f675i != null && C2086bi.this.f675i.f817a + 10000 > SystemClock.uptimeMillis())) {
                    ADLog.logVerbose("Skipping periodic screenshot because not enough time has passed");
                    return;
                } else {
                    ADLog.logVerbose("Triggering periodic screenshot");
                    C2086bi.this.m598b(false);
                    return;
                }
            }
            ADLog.logVerbose("Not taking periodic screenshot because auto screenshot is disabled");
        }

        public final String toString() {
            return "PeriodicScreenshotCapture";
        }
    }
}
