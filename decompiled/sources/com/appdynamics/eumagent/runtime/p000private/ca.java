package com.appdynamics.eumagent.runtime.p000private;

import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class ca {
    final am b;
    public final Map<View, LinkedHashSet<View.OnClickListener>> a = Collections.synchronizedMap(new WeakHashMap());
    private final View.OnClickListener c = new a(this, 0);
    private final ThreadLocal<Boolean> d = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ca.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public ca(am amVar) {
        this.b = amVar;
    }

    public final void a(View view, View.OnClickListener onClickListener) {
        if (!this.d.get().booleanValue()) {
            this.d.set(Boolean.TRUE);
            try {
                if (onClickListener == this.c) {
                    this.d.set(Boolean.FALSE);
                    return;
                }
                if (onClickListener == null) {
                    this.a.remove(view);
                    view.setOnClickListener(null);
                } else {
                    if (view != null) {
                        if (!this.a.containsKey(view)) {
                            this.a.put(view, new LinkedHashSet<>());
                        }
                        this.a.get(view).add(onClickListener);
                    }
                    view.setOnClickListener(this.c);
                }
                this.d.set(Boolean.FALSE);
                return;
            } catch (Throwable th) {
                this.d.set(Boolean.FALSE);
                throw th;
            }
        }
        ADLog.logWarning("SetOnClickListener detected recursion.");
    }

    class a implements View.OnClickListener {
        private final ThreadLocal<Boolean> a;

        private a() {
            this.a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ca.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(ca caVar, byte b) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        
            throw r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, all -> 0x0056, blocks: (B:16:0x005e, B:18:0x0061, B:20:0x0067, B:14:0x0057, B:5:0x0017, B:7:0x0027, B:9:0x002d, B:11:0x0039), top: B:31:0x0017 }] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onClick(android.view.View r8) {
            /*
                r7 = this;
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r7.a
                java.lang.Object r0 = r0.get()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L82
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r7.a
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.set(r1)
                r0 = 0
                r1 = 0
                com.appdynamics.eumagent.runtime.private.ca r2 = com.appdynamics.eumagent.runtime.p000private.ca.this     // Catch: java.lang.Throwable -> L56
                java.util.Map<android.view.View, java.util.LinkedHashSet<android.view.View$OnClickListener>> r2 = r2.a     // Catch: java.lang.Throwable -> L56
                java.lang.Object r2 = r2.get(r8)     // Catch: java.lang.Throwable -> L56
                java.util.LinkedHashSet r2 = (java.util.LinkedHashSet) r2     // Catch: java.lang.Throwable -> L56
                java.lang.Object[] r1 = r2.toArray()     // Catch: java.lang.Throwable -> L56
                if (r1 == 0) goto L5c
                boolean r2 = r8.isPressed()     // Catch: java.lang.Throwable -> L56
                if (r2 == 0) goto L5c
                java.lang.String r2 = "UI event - button click is created."
                com.appdynamics.eumagent.runtime.logging.ADLog.logVerbose(r2)     // Catch: java.lang.Throwable -> L56
                r2 = r8
                android.widget.Button r2 = (android.widget.Button) r2     // Catch: java.lang.Throwable -> L56
                int r3 = r1.length     // Catch: java.lang.Throwable -> L56
                r4 = r0
            L37:
                if (r4 >= r3) goto L5c
                r5 = r1[r4]     // Catch: java.lang.Throwable -> L56
                java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L56
                java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L56
                com.appdynamics.eumagent.runtime.private.cs r6 = new com.appdynamics.eumagent.runtime.private.cs     // Catch: java.lang.Throwable -> L56
                r6.<init>()     // Catch: java.lang.Throwable -> L56
                com.appdynamics.eumagent.runtime.private.cg r5 = com.appdynamics.eumagent.runtime.p000private.cg.a(r2, r5, r6)     // Catch: java.lang.Throwable -> L56
                com.appdynamics.eumagent.runtime.private.ca r6 = com.appdynamics.eumagent.runtime.p000private.ca.this     // Catch: java.lang.Throwable -> L56
                com.appdynamics.eumagent.runtime.private.am r6 = r6.b     // Catch: java.lang.Throwable -> L56
                r6.a(r5)     // Catch: java.lang.Throwable -> L56
                int r4 = r4 + 1
                goto L37
            L56:
                r2 = move-exception
                java.lang.String r3 = "Exception in onClick"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r3, r2)     // Catch: java.lang.Throwable -> L6d
            L5c:
                if (r1 == 0) goto L72
                int r2 = r1.length     // Catch: java.lang.Throwable -> L6d
            L5f:
                if (r0 >= r2) goto L72
                r3 = r1[r0]     // Catch: java.lang.Throwable -> L6d
                boolean r4 = r3 instanceof android.view.View.OnClickListener     // Catch: java.lang.Throwable -> L6d
                if (r4 == 0) goto L6f
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch: java.lang.Throwable -> L6d
                r3.onClick(r8)     // Catch: java.lang.Throwable -> L6d
                goto L6f
            L6d:
                r8 = move-exception
                goto L7a
            L6f:
                int r0 = r0 + 1
                goto L5f
            L72:
                java.lang.ThreadLocal<java.lang.Boolean> r7 = r7.a
                java.lang.Boolean r8 = java.lang.Boolean.FALSE
                r7.set(r8)
                return
            L7a:
                java.lang.ThreadLocal<java.lang.Boolean> r7 = r7.a
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r7.set(r0)
                throw r8
            L82:
                java.lang.String r7 = "OnClickListenerWrapper detected recursion."
                com.appdynamics.eumagent.runtime.logging.ADLog.logWarning(r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.private.ca.a.onClick(android.view.View):void");
        }
    }
}
