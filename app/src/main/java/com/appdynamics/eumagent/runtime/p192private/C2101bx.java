package com.appdynamics.eumagent.runtime.p192private;

import android.view.View;
import android.widget.AdapterView;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bx */
/* JADX INFO: loaded from: classes2.dex */
public final class C2101bx {

    /* JADX INFO: renamed from: b */
    final C2063am f735b;

    /* JADX INFO: renamed from: a */
    public final Map<AdapterView, AdapterView.OnItemClickListener> f734a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: c */
    private final AdapterView.OnItemClickListener f736c = new a(this, 0);

    /* JADX INFO: renamed from: d */
    private final ThreadLocal<Boolean> f737d = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.bx.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public C2101bx(C2063am c2063am) {
        this.f735b = c2063am;
    }

    /* JADX INFO: renamed from: a */
    public final void m621a(AdapterView adapterView, AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.f737d.get().booleanValue()) {
            this.f737d.set(Boolean.TRUE);
            try {
                if (onItemClickListener == this.f736c) {
                    return;
                }
                if (onItemClickListener == null) {
                    this.f734a.remove(adapterView);
                    adapterView.setOnItemClickListener(null);
                } else {
                    this.f734a.put(adapterView, onItemClickListener);
                    adapterView.setOnItemClickListener(this.f736c);
                }
                return;
            } finally {
                this.f737d.set(Boolean.FALSE);
            }
        }
        ADLog.logWarning("SetOnItemClickListener detected recursion.");
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bx$a */
    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a */
        private final ThreadLocal<Boolean> f738a;

        private a() {
            this.f738a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.bx.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(C2101bx c2101bx, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener;
            Throwable th;
            if (!this.f738a.get().booleanValue()) {
                this.f738a.set(Boolean.TRUE);
                try {
                    onItemClickListener = C2101bx.this.f734a.get(adapterView);
                    try {
                        if (onItemClickListener != null) {
                            C2101bx.this.f735b.m562a(C2111cg.m640a(adapterView, view, i, onItemClickListener.getClass().getName(), new C2123cs()));
                        } else {
                            ADLog.logAgentError("Cannot find original item click listener for view: " + view.getClass().getSimpleName());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ADLog.logAgentError("Exception in onItemClick", th);
                        } finally {
                            this.f738a.set(Boolean.FALSE);
                        }
                    }
                } catch (Throwable th3) {
                    onItemClickListener = null;
                    th = th3;
                }
                AdapterView.OnItemClickListener onItemClickListener2 = onItemClickListener;
                if (onItemClickListener2 != null) {
                    onItemClickListener2.onItemClick(adapterView, view, i, j);
                }
                return;
            }
            ADLog.logWarning("OnItemClickListenerWrapper detected recursion.");
        }
    }
}
