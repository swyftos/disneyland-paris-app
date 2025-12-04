package com.appdynamics.eumagent.runtime.p000private;

import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class cb {
    final am b;
    public bi c;
    public final Map<View, ArrayList<View.OnFocusChangeListener>> a = Collections.synchronizedMap(new WeakHashMap());
    private final View.OnFocusChangeListener d = new a(this, 0);
    private final ThreadLocal<Boolean> e = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.cb.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public cb(am amVar, bi biVar) {
        this.b = amVar;
        this.c = biVar;
    }

    public final void a(View view, View.OnFocusChangeListener onFocusChangeListener) {
        if (!this.e.get().booleanValue()) {
            this.e.set(Boolean.TRUE);
            try {
                if (onFocusChangeListener != this.d) {
                    if (view != null) {
                        if (!this.a.containsKey(view)) {
                            this.a.put(view, new ArrayList<>());
                        }
                        if (onFocusChangeListener != null) {
                            this.a.get(view).add(onFocusChangeListener);
                        }
                    }
                    view.setOnFocusChangeListener(this.d);
                    this.e.set(Boolean.FALSE);
                    return;
                }
                this.e.set(Boolean.FALSE);
                return;
            } catch (Throwable th) {
                this.e.set(Boolean.FALSE);
                throw th;
            }
        }
        ADLog.logWarning("setOnFocusChangeListener detected recursion.");
    }

    class a implements View.OnFocusChangeListener {
        private final ThreadLocal<Boolean> a;

        private a() {
            this.a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.cb.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(cb cbVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:24:0x0063, B:25:0x0067, B:27:0x006d, B:29:0x0075, B:22:0x005c), top: B:41:0x005c }] */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onFocusChange(android.view.View r5, boolean r6) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof android.widget.EditText
                if (r0 == 0) goto L15
                com.appdynamics.eumagent.runtime.private.cb r0 = com.appdynamics.eumagent.runtime.p000private.cb.this
                com.appdynamics.eumagent.runtime.private.bi r0 = r0.c
                if (r0 == 0) goto L15
                if (r6 == 0) goto L11
                r0 = 1
                com.appdynamics.eumagent.runtime.p000private.bi.a(r0)
                goto L15
            L11:
                r0 = 0
                com.appdynamics.eumagent.runtime.p000private.bi.a(r0)
            L15:
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r4.a
                java.lang.Object r0 = r0.get()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L8b
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r4.a
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.set(r1)
                r0 = 0
                com.appdynamics.eumagent.runtime.private.cb r1 = com.appdynamics.eumagent.runtime.p000private.cb.this     // Catch: java.lang.Throwable -> L58
                java.util.Map<android.view.View, java.util.ArrayList<android.view.View$OnFocusChangeListener>> r1 = r1.a     // Catch: java.lang.Throwable -> L58
                java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L58
                java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> L58
                if (r6 == 0) goto L3f
                java.lang.String r0 = "UI event - edit text focused is created."
                com.appdynamics.eumagent.runtime.logging.ADLog.logVerbose(r0)     // Catch: java.lang.Throwable -> L3d
                goto L44
            L3d:
                r0 = move-exception
                goto L5c
            L3f:
                java.lang.String r0 = "UI event - edit text unfocused is created."
                com.appdynamics.eumagent.runtime.logging.ADLog.logVerbose(r0)     // Catch: java.lang.Throwable -> L3d
            L44:
                r0 = r5
                android.widget.EditText r0 = (android.widget.EditText) r0     // Catch: java.lang.Throwable -> L3d
                com.appdynamics.eumagent.runtime.private.cs r2 = new com.appdynamics.eumagent.runtime.private.cs     // Catch: java.lang.Throwable -> L3d
                r2.<init>()     // Catch: java.lang.Throwable -> L3d
                com.appdynamics.eumagent.runtime.private.cg r0 = com.appdynamics.eumagent.runtime.p000private.cg.a(r0, r2, r6)     // Catch: java.lang.Throwable -> L3d
                com.appdynamics.eumagent.runtime.private.cb r2 = com.appdynamics.eumagent.runtime.p000private.cb.this     // Catch: java.lang.Throwable -> L3d
                com.appdynamics.eumagent.runtime.private.am r2 = r2.b     // Catch: java.lang.Throwable -> L3d
                r2.a(r0)     // Catch: java.lang.Throwable -> L3d
                goto L61
            L58:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
            L5c:
                java.lang.String r2 = "Exception in onFocusChange"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r2, r0)     // Catch: java.lang.Throwable -> L79
            L61:
                if (r1 == 0) goto L7b
                java.util.Iterator r0 = r1.iterator()     // Catch: java.lang.Throwable -> L79
            L67:
                boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L79
                if (r1 == 0) goto L7b
                java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L79
                android.view.View$OnFocusChangeListener r1 = (android.view.View.OnFocusChangeListener) r1     // Catch: java.lang.Throwable -> L79
                if (r1 == 0) goto L67
                r1.onFocusChange(r5, r6)     // Catch: java.lang.Throwable -> L79
                goto L67
            L79:
                r5 = move-exception
                goto L83
            L7b:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r4.a
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                r4.set(r5)
                return
            L83:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r4.a
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r4.set(r6)
                throw r5
            L8b:
                java.lang.String r4 = "onFocusChangeListenerWrapper detected recursion."
                com.appdynamics.eumagent.runtime.logging.ADLog.logWarning(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.private.cb.a.onFocusChange(android.view.View, boolean):void");
        }
    }
}
