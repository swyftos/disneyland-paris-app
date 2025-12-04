package com.appdynamics.eumagent.runtime.p000private;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class ch {
    private static Field d;
    public final Map<View, ViewGroup.OnHierarchyChangeListener> a = Collections.synchronizedMap(new WeakHashMap());
    public final ViewGroup.OnHierarchyChangeListener b = new a(this, 0);
    public final ThreadLocal<Boolean> c = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ch.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private ca e;
    private bx f;
    private cb g;

    static {
        try {
            Field declaredField = ViewGroup.class.getDeclaredField("mOnHierarchyChangeListener");
            d = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            ADLog.logAgentError("Can't find mOnHierarchyChangeListener field in ViewGroup class.", th);
        }
    }

    public ch(ca caVar, bx bxVar, cb cbVar) {
        this.e = caVar;
        this.f = bxVar;
        this.g = cbVar;
    }

    public final void a(View view) {
        if (view == null) {
            ADLog.logWarning("View observer shouldn't watch a null view.");
            return;
        }
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.logVerbose("UI instrumentation starts to watch view: " + view.getClass().getSimpleName());
        }
        b(view.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view instanceof Button) {
            ca caVar = this.e;
            if (caVar != null) {
                try {
                    caVar.a(view, (View.OnClickListener) ci.a(view, "mOnClickListener"));
                    return;
                } catch (Throwable th) {
                    ADLog.logAgentError("Fail to get click listener from view.", th);
                    return;
                }
            }
            return;
        }
        if (view instanceof AdapterView) {
            bx bxVar = this.f;
            if (bxVar != null) {
                AdapterView adapterView = (AdapterView) view;
                try {
                    bxVar.a(adapterView, (AdapterView.OnItemClickListener) bz.a(adapterView, "mOnItemClickListener"));
                    return;
                } catch (Throwable th2) {
                    ADLog.logAgentError("Fail to get click listener from view.", th2);
                    return;
                }
            }
            return;
        }
        if (view instanceof EditText) {
            cb cbVar = this.g;
            if (cbVar != null) {
                try {
                    cbVar.a(view, (View.OnFocusChangeListener) ci.a(view, "mOnFocusChangeListener"));
                    return;
                } catch (Throwable th3) {
                    ADLog.logAgentError("Fail to get focus change listener from view.", th3);
                    throw new RuntimeException(th3);
                }
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            try {
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) d.get(viewGroup);
                if (onHierarchyChangeListener == this.b) {
                    return;
                }
                this.a.put(viewGroup, onHierarchyChangeListener);
                viewGroup.setOnHierarchyChangeListener(this.b);
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    b(viewGroup.getChildAt(i));
                }
            } catch (IllegalAccessException e) {
                ADLog.logAgentError("Can't reflect mOnHierarchyChangeListener field properly. Stop instrumenting view group and its children: " + view.getClass().getSimpleName(), e);
            }
        }
    }

    public static boolean a() {
        return d != null;
    }

    class a implements ViewGroup.OnHierarchyChangeListener {
        private final ThreadLocal<Boolean> a;

        private a() {
            this.a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ch.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(ch chVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onChildViewAdded(android.view.View r5, android.view.View r6) {
            /*
                r4 = this;
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r4.a
                java.lang.Object r0 = r0.get()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L40
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r4.a
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r0.set(r1)
                r0 = 0
                com.appdynamics.eumagent.runtime.private.ch r1 = com.appdynamics.eumagent.runtime.p000private.ch.this     // Catch: java.lang.Throwable -> L2a
                java.util.Map r1 = com.appdynamics.eumagent.runtime.p000private.ch.a(r1)     // Catch: java.lang.Throwable -> L2a
                java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L2a
                android.view.ViewGroup$OnHierarchyChangeListener r1 = (android.view.ViewGroup.OnHierarchyChangeListener) r1     // Catch: java.lang.Throwable -> L2a
                com.appdynamics.eumagent.runtime.private.ch r0 = com.appdynamics.eumagent.runtime.p000private.ch.this     // Catch: java.lang.Throwable -> L28
                com.appdynamics.eumagent.runtime.p000private.ch.a(r0, r6)     // Catch: java.lang.Throwable -> L28
                goto L33
            L28:
                r0 = move-exception
                goto L2e
            L2a:
                r1 = move-exception
                r3 = r1
                r1 = r0
                r0 = r3
            L2e:
                java.lang.String r2 = "Exception in onChildViewAdded"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r2, r0)
            L33:
                if (r1 == 0) goto L38
                r1.onChildViewAdded(r5, r6)
            L38:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r4.a
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                r4.set(r5)
                return
            L40:
                java.lang.String r4 = "OnHierarchyChangeListenerWrapper - onChildViewAdded detected recursion."
                com.appdynamics.eumagent.runtime.logging.ADLog.logWarning(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.private.ch.a.onChildViewAdded(android.view.View, android.view.View):void");
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            if (!this.a.get().booleanValue()) {
                this.a.set(Boolean.TRUE);
                try {
                    onHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) ch.this.a.get(view);
                } catch (Throwable th) {
                    ADLog.logAgentError("Exception in onChildViewRemoved", th);
                    onHierarchyChangeListener = null;
                }
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view, view2);
                }
                this.a.set(Boolean.FALSE);
                return;
            }
            ADLog.logWarning("OnHierarchyChangeListenerWrapper - onChildViewRemoved detected recursion.");
        }
    }
}
