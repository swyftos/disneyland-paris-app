package com.appdynamics.eumagent.runtime.p000private;

import android.app.Activity;
import android.os.SystemClock;
import android.view.Window;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class i implements am.b {
    public final k a;
    public boolean b;
    private final l c;
    private final af d;
    private final f e;
    private final a f = new a(0);

    public i(am amVar, k kVar, l lVar, af afVar, f fVar) {
        this.a = kVar;
        this.c = lVar;
        this.d = afVar;
        this.e = fVar;
        amVar.a.a(p.class, this);
        amVar.a.a(bu.class, this);
        amVar.a.a(at.class, this);
        amVar.a.a(bc.class, this);
        amVar.a.a(cg.class, this);
        amVar.a.a(u.class, this);
        amVar.a.a(ao.class, this);
        amVar.a.a(ar.class, this);
        amVar.a.a(ad.class, this);
        amVar.a.a(y.class, this);
        amVar.a.a(g.class, this);
        amVar.a.a(c.class, this);
        amVar.a.a(bh.class, this);
        amVar.a.a(bq.class, this);
        amVar.a.a(al.class, this);
        amVar.a.a(bs.class, this);
        amVar.a.a(cc.class, this);
        amVar.a.a(br.class, this);
        amVar.a.a(ak.class, this);
        this.b = true;
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        Boolean boolValueOf;
        a aVar;
        if (this.b) {
            if ((obj instanceof cg) && (aVar = this.f) != null) {
                cg cgVar = (cg) obj;
                if ("App Start".equals(cgVar.i)) {
                    aVar.a = cgVar.g;
                    aVar.c = false;
                } else if ("App Stop".equals(cgVar.i)) {
                    aVar.b = cgVar.g;
                    aVar.c = true;
                }
            }
            Boolean boolValueOf2 = null;
            if (obj instanceof ak) {
                ak akVar = (ak) obj;
                int i = akVar.j != null ? 1 : 0;
                if (akVar.i != null) {
                    i++;
                }
                if (akVar.k != null) {
                    i++;
                }
                if (akVar.l != null) {
                    i++;
                }
                if (akVar.m != null) {
                    i++;
                }
                if (i == 0) {
                    ADLog.logInfo("No reportable Device Resource Consumption Metrics");
                    return;
                }
                j jVar = (j) obj;
                a aVar2 = this.f;
                if (aVar2 != null) {
                    cs csVar = jVar.g;
                    if (csVar == null) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(aVar2.c && csVar.a >= aVar2.b.a);
                    }
                    if (boolValueOf.booleanValue()) {
                        return;
                    }
                }
                ADLog.logInfo("Reporting " + i + " Device Resource Consumption Metrics");
            }
            if (obj instanceof h) {
                if (obj instanceof j) {
                    j jVar2 = (j) obj;
                    af afVar = this.d;
                    long andIncrement = afVar.b.getAndIncrement();
                    if (andIncrement % 100 == 0) {
                        afVar.a.a("event_counter", andIncrement);
                    }
                    jVar2.b = andIncrement;
                    jVar2.e = this.d.c.get();
                    if (jVar2.c == null) {
                        jVar2.c = this.e.a();
                    }
                    a aVar3 = this.f;
                    if (aVar3 != null) {
                        cs csVar2 = jVar2.g;
                        cs csVar3 = jVar2.h;
                        if (csVar3 != null && csVar2 != null) {
                            if (aVar3.c) {
                                boolValueOf2 = Boolean.valueOf(csVar3.a > aVar3.b.a);
                            } else {
                                cs csVar4 = aVar3.b;
                                cs csVar5 = aVar3.a;
                                if (csVar3.a >= csVar4.a && csVar5.a >= csVar2.a) {
                                    z = true;
                                }
                                boolValueOf2 = Boolean.valueOf(z);
                            }
                        }
                        jVar2.d = boolValueOf2;
                    }
                }
                k kVar = this.a;
                h hVar = (h) obj;
                if ((hVar instanceof ad) || (hVar instanceof v) || (hVar instanceof y)) {
                    q qVar = kVar.c;
                    if (qVar.a.h.isEmpty() ? true : qVar.a.h.contains("crashes")) {
                        ADLog.log(1, "Adding new beacon [%s] to Crash BeaconQueue", hVar);
                        kVar.b.a(hVar);
                    }
                } else if (kVar.c.a.h.isEmpty()) {
                    ADLog.log(1, "Adding new beacon [%s] to BeaconQueue", hVar);
                    kVar.a.a(hVar);
                } else {
                    q qVar2 = kVar.c;
                    if ((qVar2.a.h.isEmpty() ? true : qVar2.a.h.contains("crashes")) && (hVar instanceof cg)) {
                        cg cgVar2 = (cg) hVar;
                        if ("App Start".equals(cgVar2.i) || "App Stop".equals(cgVar2.i)) {
                            ADLog.log(1, "Adding new beacon [%s] to BeaconQueue", hVar);
                            kVar.a.a(hVar);
                        }
                    }
                }
                if (b(obj)) {
                    this.c.a(0L);
                    return;
                } else {
                    if (obj instanceof bc) {
                        this.c.a(5L);
                        return;
                    }
                    return;
                }
            }
            if (obj instanceof br) {
                af afVar2 = this.d;
                afVar2.a.a("session_counter", afVar2.c.incrementAndGet());
            } else {
                ADLog.logAgentError("BeaconDispatcher doesn't know how to handle events of class " + obj.getClass());
            }
        }
    }

    private static boolean b(Object obj) {
        try {
            if (obj instanceof bc) {
                String string = ((bc) obj).i.toString();
                if (string.equals("http://send-beacons.com") || string.equals("http://after.start")) {
                    return true;
                }
            } else if (obj instanceof cg) {
                if ("App Start".equals(((cg) obj).i)) {
                    return true;
                }
            } else if ((obj instanceof u) || (obj instanceof ad) || (obj instanceof y) || (obj instanceof c)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            ADLog.logAgentError("Agent encountered error during beacon dispatch: " + e.toString());
            return false;
        }
    }

    static class a {
        cs a;
        cs b;
        boolean c;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
            Activity activity;
            Window window;
            this.a = new cs(0L, System.currentTimeMillis() - SystemClock.uptimeMillis());
            this.b = new cs(0L, System.currentTimeMillis() - SystemClock.uptimeMillis());
            WeakReference<Activity> weakReference = InstrumentationCallbacks.currentActivity;
            boolean z = true;
            if (weakReference != null && (activity = weakReference.get()) != null && (window = activity.getWindow()) != null && window.isActive()) {
                z = false;
            }
            this.c = z;
        }
    }
}
