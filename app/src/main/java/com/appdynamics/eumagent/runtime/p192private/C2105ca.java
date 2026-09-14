package com.appdynamics.eumagent.runtime.p192private;

import android.view.View;
import android.widget.Button;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ca */
/* JADX INFO: loaded from: classes2.dex */
public final class C2105ca {

    /* JADX INFO: renamed from: b */
    final C2063am f748b;

    /* JADX INFO: renamed from: a */
    public final Map<View, LinkedHashSet<View.OnClickListener>> f747a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: c */
    private final View.OnClickListener f749c = new a(this, 0);

    /* JADX INFO: renamed from: d */
    private final ThreadLocal<Boolean> f750d = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ca.1
        @Override // java.lang.ThreadLocal
        protected final /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public C2105ca(C2063am c2063am) {
        this.f748b = c2063am;
    }

    /* JADX INFO: renamed from: a */
    public final void m635a(View view, View.OnClickListener onClickListener) {
        if (!this.f750d.get().booleanValue()) {
            this.f750d.set(Boolean.TRUE);
            try {
                if (onClickListener == this.f749c) {
                    return;
                }
                if (onClickListener == null) {
                    this.f747a.remove(view);
                    view.setOnClickListener(null);
                } else {
                    if (view != null) {
                        if (!this.f747a.containsKey(view)) {
                            this.f747a.put(view, new LinkedHashSet<>());
                        }
                        this.f747a.get(view).add(onClickListener);
                    }
                    view.setOnClickListener(this.f749c);
                }
                return;
            } finally {
                this.f750d.set(Boolean.FALSE);
            }
        }
        ADLog.logWarning("SetOnClickListener detected recursion.");
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ca$a */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        private final ThreadLocal<Boolean> f751a;

        private a() {
            this.f751a = new ThreadLocal<Boolean>() { // from class: com.appdynamics.eumagent.runtime.private.ca.a.1
                @Override // java.lang.ThreadLocal
                protected final /* bridge */ /* synthetic */ Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* synthetic */ a(C2105ca c2105ca, byte b) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.f751a.get().booleanValue()) {
                this.f751a.set(Boolean.TRUE);
                Object[] array = null;
                try {
                    try {
                        array = C2105ca.this.f747a.get(view).toArray();
                        if (array != null && view.isPressed()) {
                            ADLog.logVerbose("UI event - button click is created.");
                            Button button = (Button) view;
                            for (Object obj : array) {
                                C2105ca.this.f748b.m562a(C2111cg.m641a(button, obj.getClass().getName(), new C2123cs()));
                            }
                        }
                    } catch (Throwable th) {
                        ADLog.logAgentError("Exception in onClick", th);
                    }
                    if (array != null) {
                        for (Object obj2 : array) {
                            if (obj2 instanceof View.OnClickListener) {
                                ((View.OnClickListener) obj2).onClick(view);
                            }
                        }
                    }
                    return;
                } finally {
                    this.f751a.set(Boolean.FALSE);
                }
            }
            ADLog.logWarning("OnClickListenerWrapper detected recursion.");
        }
    }
}
