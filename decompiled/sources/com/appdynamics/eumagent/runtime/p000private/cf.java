package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class cf implements am.b {
    private static final Integer a = 1;
    private static final Integer b = 2;
    private static final Integer c = 3;
    private final am d;
    private final HashMap<String, Integer> f = new HashMap<>(2);
    private a g = null;
    private cs e = new cs();

    public cf(am amVar) {
        this.d = amVar;
        amVar.a.a(by.class, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, cs csVar) {
        cg cgVar;
        cs csVar2 = this.e;
        if (csVar2 != null) {
            cgVar = new cg(str, str2, csVar2, csVar);
            this.e = null;
        } else {
            cgVar = new cg(str, str2);
        }
        this.d.a(cgVar);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof by) {
            by byVar = (by) obj;
            int i = byVar.a;
            if (i == 0) {
                cs csVar = byVar.c;
                if (this.f.isEmpty()) {
                    this.e = csVar;
                    return;
                }
                return;
            }
            if (i == 1) {
                String str = byVar.b;
                HashMap<String, Integer> map = this.f;
                Integer num = a;
                Integer numPut = map.put(str, num);
                a aVar = this.g;
                if (aVar != null) {
                    aVar.a = true;
                }
                if (numPut != null) {
                    ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut, num, str);
                    return;
                }
                return;
            }
            if (i == 2) {
                String str2 = byVar.b;
                cs csVar2 = byVar.c;
                HashMap<String, Integer> map2 = this.f;
                Integer num2 = b;
                Integer numPut2 = map2.put(str2, num2);
                int size = this.f.size();
                if (this.g != null) {
                    this.g = null;
                    ADLog.logVerbose("Lifecycle: Skipping App Stop/Start");
                    return;
                }
                if (!a.equals(numPut2) && !c.equals(numPut2)) {
                    ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut2, num2, str2);
                    return;
                }
                if (size == 1) {
                    ADLog.logVerbose("Lifecycle: App Start");
                    a(str2, "App Start", csVar2);
                    return;
                } else {
                    if (size > 1) {
                        ADLog.logVerbose("Lifecycle: Activity Change");
                        a(str2, "Activity Change", csVar2);
                        return;
                    }
                    return;
                }
            }
            if (i == 3) {
                String str3 = byVar.b;
                HashMap<String, Integer> map3 = this.f;
                Integer num3 = c;
                Integer numPut3 = map3.put(str3, num3);
                this.e = new cs();
                if (b.equals(numPut3)) {
                    return;
                }
                ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numPut3, num3, str3);
                return;
            }
            if (i != 4) {
                return;
            }
            String str4 = byVar.b;
            cs csVar3 = byVar.c;
            Integer numRemove = this.f.remove(str4);
            if (c.equals(numRemove)) {
                if (this.f.isEmpty()) {
                    ADLog.logVerbose("Lifecycle: Possible App Stop");
                    a aVar2 = new a(str4, csVar3);
                    this.g = aVar2;
                    this.d.a(new am.d(aVar2, 1000L, -1L));
                    return;
                }
                return;
            }
            ADLog.log(2, "WARNING: UIDetector detected strange transition from state %s to %s in activity %s", numRemove, null, str4);
        }
    }

    class a implements Runnable {
        boolean a = false;
        private final String b;
        private final cs c;

        a(String str, cs csVar) {
            this.b = str;
            this.c = csVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cf.this.g = null;
            if (this.a) {
                return;
            }
            ADLog.logVerbose("Lifecycle: App Stop");
            cf.this.a(this.b, "App Stop", this.c);
        }

        public final String toString() {
            return "DelayedOnStop(" + this.b + ")";
        }
    }
}
