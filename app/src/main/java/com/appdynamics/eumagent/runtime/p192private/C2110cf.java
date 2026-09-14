package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.HashMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cf */
/* JADX INFO: loaded from: classes2.dex */
public final class C2110cf implements C2063am.b {

    /* JADX INFO: renamed from: a */
    private static final Integer f771a = 1;

    /* JADX INFO: renamed from: b */
    private static final Integer f772b = 2;

    /* JADX INFO: renamed from: c */
    private static final Integer f773c = 3;

    /* JADX INFO: renamed from: d */
    private final C2063am f774d;

    /* JADX INFO: renamed from: f */
    private final HashMap<String, Integer> f776f = new HashMap<>(2);

    /* JADX INFO: renamed from: g */
    private a f777g = null;

    /* JADX INFO: renamed from: e */
    private C2123cs f775e = new C2123cs();

    public C2110cf(C2063am c2063am) {
        this.f774d = c2063am;
        c2063am.f535a.m656a(C2102by.class, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m639a(String str, String str2, C2123cs c2123cs) {
        C2111cg c2111cg;
        C2123cs c2123cs2 = this.f775e;
        if (c2123cs2 != null) {
            c2111cg = new C2111cg(str, str2, c2123cs2, c2123cs);
            this.f775e = null;
        } else {
            c2111cg = new C2111cg(str, str2);
        }
        this.f774d.m562a(c2111cg);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2102by) {
            C2102by c2102by = (C2102by) obj;
            int i = c2102by.f740a;
            if (i == 0) {
                C2123cs c2123cs = c2102by.f742c;
                if (this.f776f.isEmpty()) {
                    this.f775e = c2123cs;
                    return;
                }
                return;
            }
            if (i == 1) {
                String str = c2102by.f741b;
                HashMap<String, Integer> map = this.f776f;
                Integer num = f771a;
                Integer numPut = map.put(str, num);
                a aVar = this.f777g;
                if (aVar != null) {
                    aVar.f778a = true;
                }
                if (numPut != null) {
                    ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut, num, str);
                    return;
                }
                return;
            }
            if (i == 2) {
                String str2 = c2102by.f741b;
                C2123cs c2123cs2 = c2102by.f742c;
                HashMap<String, Integer> map2 = this.f776f;
                Integer num2 = f772b;
                Integer numPut2 = map2.put(str2, num2);
                int size = this.f776f.size();
                if (this.f777g != null) {
                    this.f777g = null;
                    ADLog.logVerbose("Lifecycle: Skipping App Stop/Start");
                    return;
                }
                if (!f771a.equals(numPut2) && !f773c.equals(numPut2)) {
                    ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut2, num2, str2);
                    return;
                }
                if (size == 1) {
                    ADLog.logVerbose("Lifecycle: App Start");
                    m639a(str2, "App Start", c2123cs2);
                    return;
                } else {
                    if (size > 1) {
                        ADLog.logVerbose("Lifecycle: Activity Change");
                        m639a(str2, "Activity Change", c2123cs2);
                        return;
                    }
                    return;
                }
            }
            if (i == 3) {
                String str3 = c2102by.f741b;
                HashMap<String, Integer> map3 = this.f776f;
                Integer num3 = f773c;
                Integer numPut3 = map3.put(str3, num3);
                this.f775e = new C2123cs();
                if (f772b.equals(numPut3)) {
                    return;
                }
                ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut3, num3, str3);
                return;
            }
            if (i != 4) {
                return;
            }
            String str4 = c2102by.f741b;
            C2123cs c2123cs3 = c2102by.f742c;
            Integer numRemove = this.f776f.remove(str4);
            if (f773c.equals(numRemove)) {
                if (this.f776f.isEmpty()) {
                    ADLog.logVerbose("Lifecycle: Possible App Stop");
                    a aVar2 = new a(str4, c2123cs3);
                    this.f777g = aVar2;
                    this.f774d.m562a(new C2063am.d(aVar2, 1000L, -1L));
                    return;
                }
                return;
            }
            ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numRemove, null, str4);
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cf$a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a */
        boolean f778a = false;

        /* JADX INFO: renamed from: b */
        private final String f779b;

        /* JADX INFO: renamed from: c */
        private final C2123cs f780c;

        a(String str, C2123cs c2123cs) {
            this.f779b = str;
            this.f780c = c2123cs;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2110cf.this.f777g = null;
            if (this.f778a) {
                return;
            }
            ADLog.logVerbose("Lifecycle: App Stop");
            C2110cf.this.m639a(this.f779b, "App Stop", this.f780c);
        }

        public final String toString() {
            return "DelayedOnStop(" + this.f779b + ")";
        }
    }
}
