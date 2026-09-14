package com.appdynamics.eumagent.runtime.p192private;

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

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ch */
/* JADX INFO: loaded from: classes2.dex */
public final class C2112ch {

    /* JADX INFO: renamed from: d */
    private static Field f790d;

    /* JADX INFO: renamed from: a */
    public final Map<View, ViewGroup.OnHierarchyChangeListener> f791a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    public final ViewGroup.OnHierarchyChangeListener f792b = new a(this, 0);

    /* JADX INFO: renamed from: c */
    public final ThreadLocal<Boolean> f793c = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ch.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    /* JADX INFO: renamed from: e */
    private C2105ca f794e;

    /* JADX INFO: renamed from: f */
    private C2101bx f795f;

    /* JADX INFO: renamed from: g */
    private C2106cb f796g;

    static {
        try {
            Field declaredField = ViewGroup.class.getDeclaredField("mOnHierarchyChangeListener");
            f790d = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            ADLog.logAgentError("Can't find mOnHierarchyChangeListener field in ViewGroup class.", th);
        }
    }

    public C2112ch(C2105ca c2105ca, C2101bx c2101bx, C2106cb c2106cb) {
        this.f794e = c2105ca;
        this.f795f = c2101bx;
        this.f796g = c2106cb;
    }

    /* JADX INFO: renamed from: a */
    public final void m647a(View view) {
        if (view == null) {
            ADLog.logWarning("View observer shouldn't watch a null view.");
            return;
        }
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.logVerbose("UI instrumentation starts to watch view: " + view.getClass().getSimpleName());
        }
        m646b(view.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m646b(View view) {
        if (view instanceof Button) {
            C2105ca c2105ca = this.f794e;
            if (c2105ca != null) {
                try {
                    c2105ca.m635a(view, (View.OnClickListener) C2113ci.m648a(view, "mOnClickListener"));
                    return;
                } catch (Throwable th) {
                    ADLog.logAgentError("Fail to get click listener from view.", th);
                    return;
                }
            }
            return;
        }
        if (view instanceof AdapterView) {
            C2101bx c2101bx = this.f795f;
            if (c2101bx != null) {
                AdapterView adapterView = (AdapterView) view;
                try {
                    c2101bx.m621a(adapterView, (AdapterView.OnItemClickListener) C2103bz.m624a(adapterView, "mOnItemClickListener"));
                    return;
                } catch (Throwable th2) {
                    ADLog.logAgentError("Fail to get click listener from view.", th2);
                    return;
                }
            }
            return;
        }
        if (view instanceof EditText) {
            C2106cb c2106cb = this.f796g;
            if (c2106cb != null) {
                try {
                    c2106cb.m636a(view, (View.OnFocusChangeListener) C2113ci.m648a(view, "mOnFocusChangeListener"));
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
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) f790d.get(viewGroup);
                if (onHierarchyChangeListener == this.f792b) {
                    return;
                }
                this.f791a.put(viewGroup, onHierarchyChangeListener);
                viewGroup.setOnHierarchyChangeListener(this.f792b);
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m646b(viewGroup.getChildAt(i));
                }
            } catch (IllegalAccessException e) {
                ADLog.logAgentError("Can't reflect mOnHierarchyChangeListener field properly. Stop instrumenting view group and its children: " + view.getClass().getSimpleName(), e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m645a() {
        return f790d != null;
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ch$a */
    class a implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a */
        private final ThreadLocal<Boolean> f797a;

        private a() {
            this.f797a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ch.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(C2112ch c2112ch, byte b) {
            this();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            Throwable th;
            if (!this.f797a.get().booleanValue()) {
                this.f797a.set(Boolean.TRUE);
                try {
                    onHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) C2112ch.this.f791a.get(view);
                    try {
                        C2112ch.this.m646b(view2);
                    } catch (Throwable th2) {
                        th = th2;
                        ADLog.logAgentError("Exception in onChildViewAdded", th);
                    }
                } catch (Throwable th3) {
                    onHierarchyChangeListener = null;
                    th = th3;
                }
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewAdded(view, view2);
                }
                this.f797a.set(Boolean.FALSE);
                return;
            }
            ADLog.logWarning("OnHierarchyChangeListenerWrapper - onChildViewAdded detected recursion.");
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            if (!this.f797a.get().booleanValue()) {
                this.f797a.set(Boolean.TRUE);
                try {
                    onHierarchyChangeListener = (ViewGroup.OnHierarchyChangeListener) C2112ch.this.f791a.get(view);
                } catch (Throwable th) {
                    ADLog.logAgentError("Exception in onChildViewRemoved", th);
                    onHierarchyChangeListener = null;
                }
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view, view2);
                }
                this.f797a.set(Boolean.FALSE);
                return;
            }
            ADLog.logWarning("OnHierarchyChangeListenerWrapper - onChildViewRemoved detected recursion.");
        }
    }
}
