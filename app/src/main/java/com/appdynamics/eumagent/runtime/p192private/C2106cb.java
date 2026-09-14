package com.appdynamics.eumagent.runtime.p192private;

import android.view.View;
import android.widget.EditText;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cb */
/* JADX INFO: loaded from: classes2.dex */
public final class C2106cb {

    /* JADX INFO: renamed from: b */
    final C2063am f754b;

    /* JADX INFO: renamed from: c */
    public C2086bi f755c;

    /* JADX INFO: renamed from: a */
    public final Map<View, ArrayList<View.OnFocusChangeListener>> f753a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: d */
    private final View.OnFocusChangeListener f756d = new a(this, 0);

    /* JADX INFO: renamed from: e */
    private final ThreadLocal<Boolean> f757e = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.cb.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public C2106cb(C2063am c2063am, C2086bi c2086bi) {
        this.f754b = c2063am;
        this.f755c = c2086bi;
    }

    /* JADX INFO: renamed from: a */
    public final void m636a(View view, View.OnFocusChangeListener onFocusChangeListener) {
        if (!this.f757e.get().booleanValue()) {
            this.f757e.set(Boolean.TRUE);
            try {
                if (onFocusChangeListener == this.f756d) {
                    return;
                }
                if (view != null) {
                    if (!this.f753a.containsKey(view)) {
                        this.f753a.put(view, new ArrayList<>());
                    }
                    if (onFocusChangeListener != null) {
                        this.f753a.get(view).add(onFocusChangeListener);
                    }
                }
                view.setOnFocusChangeListener(this.f756d);
                return;
            } finally {
                this.f757e.set(Boolean.FALSE);
            }
        }
        ADLog.logWarning("setOnFocusChangeListener detected recursion.");
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cb$a */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a */
        private final ThreadLocal<Boolean> f758a;

        private a() {
            this.f758a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.cb.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(C2106cb c2106cb, byte b) {
            this();
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            ArrayList<View.OnFocusChangeListener> arrayList;
            Throwable th;
            if ((view instanceof EditText) && C2106cb.this.f755c != null) {
                if (z) {
                    C2086bi.m596a(true);
                } else {
                    C2086bi.m596a(false);
                }
            }
            if (!this.f758a.get().booleanValue()) {
                this.f758a.set(Boolean.TRUE);
                try {
                    arrayList = C2106cb.this.f753a.get(view);
                    try {
                        if (z) {
                            ADLog.logVerbose("UI event - edit text focused is created.");
                        } else {
                            ADLog.logVerbose("UI event - edit text unfocused is created.");
                        }
                        C2106cb.this.f754b.m562a(C2111cg.m642a((EditText) view, new C2123cs(), z));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ADLog.logAgentError("Exception in onFocusChange", th);
                        } finally {
                            this.f758a.set(Boolean.FALSE);
                        }
                    }
                } catch (Throwable th3) {
                    arrayList = null;
                    th = th3;
                }
                if (arrayList != null) {
                    for (View.OnFocusChangeListener onFocusChangeListener : arrayList) {
                        if (onFocusChangeListener != null) {
                            onFocusChangeListener.onFocusChange(view, z);
                        }
                    }
                }
                return;
            }
            ADLog.logWarning("onFocusChangeListenerWrapper detected recursion.");
        }
    }
}
