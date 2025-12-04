package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import com.appdynamics.eumagent.runtime.private.bg.b;
import com.appdynamics.eumagent.runtime.private.bn.a;

/* loaded from: classes2.dex */
public final class bi implements am.b {
    private static boolean j = false;
    private final bg a;
    private final bn b;
    private final am c;
    private final q d;
    private f e;
    private View f = null;
    private bf g;
    private cs h;
    private cs i;

    public bi(am amVar, bg bgVar, bn bnVar, q qVar, f fVar) {
        this.c = amVar;
        this.a = bgVar;
        this.b = bnVar;
        this.d = qVar;
        this.e = fVar;
        amVar.a.a(bk.class, this);
        amVar.a.a(be.class, this);
        amVar.a.a(MotionEvent.class, this);
        amVar.a.a(bf.class, this);
        amVar.a.a(s.class, this);
        amVar.a(new am.d(new a(), 10000L, 10000L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        cs csVar;
        if (this.f == null) {
            ADLog.logVerbose("Tried to take screenshot, but rootView was null");
            return;
        }
        if (z && (csVar = this.i) != null && csVar.a + 10000 > SystemClock.uptimeMillis()) {
            ADLog.logVerbose("Skipping manual screenshot because not enough time has passed");
            return;
        }
        bg bgVar = this.a;
        View view = this.f;
        if (!bgVar.e) {
            bgVar.e = true;
            bgVar.b.post(bgVar.new b(view));
        }
        if (z) {
            this.i = new cs();
        } else {
            this.h = new cs();
        }
    }

    public static void a(boolean z) {
        j = z;
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof bk) {
            if (!this.d.a()) {
                ADLog.logInfo("Not taking screenshot from API call because capturing is disabled");
                return;
            }
            if (!this.d.a.b.booleanValue() && this.e.b()) {
                ADLog.logInfo("Not taking screenshot from API call because upload on cellular connection is disabledand device is on cellular mobile connection");
                return;
            } else if (j) {
                ADLog.logInfo("Not taking screenshot from API call because a text field is currently in focus");
                return;
            } else {
                ADLog.logInfo("Triggering screenshot from API call");
                b(true);
                return;
            }
        }
        if (obj instanceof be) {
            this.f = ((be) obj).a;
            return;
        }
        if (obj instanceof MotionEvent) {
            q qVar = this.d;
            if (qVar.a() && qVar.a.c.booleanValue()) {
                MotionEvent motionEvent = (MotionEvent) obj;
                bd bdVar = new bd(motionEvent);
                if (motionEvent.getActionMasked() == 0) {
                    bf bfVar = this.g;
                    if (bfVar != null) {
                        bdVar.c = bfVar.a;
                    }
                    if (j) {
                        ADLog.logInfo("Not taking screenshot from API call because a text field is currently in focus");
                        return;
                    }
                    b(false);
                    bf bfVar2 = this.g;
                    if (bfVar2 != null) {
                        bdVar.b = bfVar2.a;
                    }
                }
                this.c.a(bdVar);
                return;
            }
            return;
        }
        if (obj instanceof bf) {
            bf bfVar3 = (bf) obj;
            if (bfVar3.equals(this.g)) {
                ADLog.logVerbose("Dropping screenshot because nothing changed from the previous");
                return;
            }
            bn bnVar = this.b;
            bnVar.b.execute(bnVar.new a(bfVar3.b, bfVar3.d));
            this.c.a(new bh(bfVar3.a, bfVar3.c, bfVar3.e, bfVar3.f, bfVar3.b, 4));
            this.g = bfVar3;
            return;
        }
        if (obj instanceof s) {
            q qVar2 = this.d;
            if (qVar2.b.screenshotsEnabled && qVar2.a.a.booleanValue()) {
                return;
            }
            this.b.a.b();
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q qVar = bi.this.d;
            if (qVar.a() && qVar.a.c.booleanValue()) {
                if ((bi.this.h != null && bi.this.h.a + 10000 > SystemClock.uptimeMillis()) || (bi.this.i != null && bi.this.i.a + 10000 > SystemClock.uptimeMillis())) {
                    ADLog.logVerbose("Skipping periodic screenshot because not enough time has passed");
                    return;
                } else {
                    ADLog.logVerbose("Triggering periodic screenshot");
                    bi.this.b(false);
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
