package com.appdynamics.eumagent.runtime.p000private;

import android.widget.AdapterView;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class bx {
    final am b;
    public final Map<AdapterView, AdapterView.OnItemClickListener> a = Collections.synchronizedMap(new WeakHashMap());
    private final AdapterView.OnItemClickListener c = new a(this, 0);
    private final ThreadLocal<Boolean> d = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.bx.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public bx(am amVar) {
        this.b = amVar;
    }

    public final void a(AdapterView adapterView, AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.d.get().booleanValue()) {
            this.d.set(Boolean.TRUE);
            try {
                if (onItemClickListener == this.c) {
                    this.d.set(Boolean.FALSE);
                    return;
                }
                if (onItemClickListener == null) {
                    this.a.remove(adapterView);
                    adapterView.setOnItemClickListener(null);
                } else {
                    this.a.put(adapterView, onItemClickListener);
                    adapterView.setOnItemClickListener(this.c);
                }
                this.d.set(Boolean.FALSE);
                return;
            } catch (Throwable th) {
                this.d.set(Boolean.FALSE);
                throw th;
            }
        }
        ADLog.logWarning("SetOnItemClickListener detected recursion.");
    }

    class a implements AdapterView.OnItemClickListener {
        private final ThreadLocal<Boolean> a;

        private a() {
            this.a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.bx.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(bx bxVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #2 {all -> 0x006c, blocks: (B:16:0x0064, B:14:0x005c), top: B:31:0x005c }] */
        @Override // android.widget.AdapterView.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onItemClick(android.widget.AdapterView r11, android.view.View r12, int r13, long r14) {
            /*
                r10 = this;
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r10.a
                java.lang.Object r0 = r0.get()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L7e
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r10.a
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.set(r1)
                r0 = 0
                com.appdynamics.eumagent.runtime.private.bx r1 = com.appdynamics.eumagent.runtime.p000private.bx.this     // Catch: java.lang.Throwable -> L58
                java.util.Map<android.widget.AdapterView, android.widget.AdapterView$OnItemClickListener> r1 = r1.a     // Catch: java.lang.Throwable -> L58
                java.lang.Object r1 = r1.get(r11)     // Catch: java.lang.Throwable -> L58
                android.widget.AdapterView$OnItemClickListener r1 = (android.widget.AdapterView.OnItemClickListener) r1     // Catch: java.lang.Throwable -> L58
                if (r1 == 0) goto L3d
                java.lang.Class r0 = r1.getClass()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L3b
                com.appdynamics.eumagent.runtime.private.cs r2 = new com.appdynamics.eumagent.runtime.private.cs     // Catch: java.lang.Throwable -> L3b
                r2.<init>()     // Catch: java.lang.Throwable -> L3b
                com.appdynamics.eumagent.runtime.private.cg r0 = com.appdynamics.eumagent.runtime.p000private.cg.a(r11, r12, r13, r0, r2)     // Catch: java.lang.Throwable -> L3b
                com.appdynamics.eumagent.runtime.private.bx r2 = com.appdynamics.eumagent.runtime.p000private.bx.this     // Catch: java.lang.Throwable -> L3b
                com.appdynamics.eumagent.runtime.private.am r2 = r2.b     // Catch: java.lang.Throwable -> L3b
                r2.a(r0)     // Catch: java.lang.Throwable -> L3b
                goto L56
            L3b:
                r0 = move-exception
                goto L5c
            L3d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = "Cannot find original item click listener for view: "
                r0.<init>(r2)     // Catch: java.lang.Throwable -> L3b
                java.lang.Class r2 = r12.getClass()     // Catch: java.lang.Throwable -> L3b
                java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L3b
                r0.append(r2)     // Catch: java.lang.Throwable -> L3b
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L3b
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r0)     // Catch: java.lang.Throwable -> L3b
            L56:
                r3 = r1
                goto L62
            L58:
                r1 = move-exception
                r9 = r1
                r1 = r0
                r0 = r9
            L5c:
                java.lang.String r2 = "Exception in onItemClick"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r2, r0)     // Catch: java.lang.Throwable -> L6c
                goto L56
            L62:
                if (r3 == 0) goto L6e
                r4 = r11
                r5 = r12
                r6 = r13
                r7 = r14
                r3.onItemClick(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6c
                goto L6e
            L6c:
                r11 = move-exception
                goto L76
            L6e:
                java.lang.ThreadLocal<java.lang.Boolean> r10 = r10.a
                java.lang.Boolean r11 = java.lang.Boolean.FALSE
                r10.set(r11)
                return
            L76:
                java.lang.ThreadLocal<java.lang.Boolean> r10 = r10.a
                java.lang.Boolean r12 = java.lang.Boolean.FALSE
                r10.set(r12)
                throw r11
            L7e:
                java.lang.String r10 = "OnItemClickListenerWrapper detected recursion."
                com.appdynamics.eumagent.runtime.logging.ADLog.logWarning(r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.private.bx.a.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
        }
    }
}
