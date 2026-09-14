package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.CallTracker;
import java.util.Arrays;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ap */
/* JADX INFO: loaded from: classes2.dex */
public final class C2066ap implements CallTracker {

    /* JADX INFO: renamed from: a */
    public static final CallTracker f555a = new CallTracker() { // from class: com.appdynamics.eumagent.runtime.private.ap.1
        @Override // com.appdynamics.eumagent.runtime.CallTracker
        public final void reportCallEnded() {
        }

        @Override // com.appdynamics.eumagent.runtime.CallTracker
        public final void reportCallEndedWithException(Exception exc) {
        }

        @Override // com.appdynamics.eumagent.runtime.CallTracker
        public final void reportCallEndedWithReturnValue(Object obj) {
        }

        @Override // com.appdynamics.eumagent.runtime.CallTracker
        public final void setStartTime(long j) {
        }

        @Override // com.appdynamics.eumagent.runtime.CallTracker
        public final CallTracker withArguments(Object... objArr) {
            return this;
        }
    };

    /* JADX INFO: renamed from: b */
    private final C2063am f556b;

    /* JADX INFO: renamed from: c */
    private boolean f557c;

    /* JADX INFO: renamed from: d */
    private String f558d;

    /* JADX INFO: renamed from: e */
    private String f559e;

    /* JADX INFO: renamed from: f */
    private C2123cs f560f = new C2123cs();

    /* JADX INFO: renamed from: g */
    private boolean f561g = false;

    /* JADX INFO: renamed from: h */
    private C2123cs f562h = null;

    /* JADX INFO: renamed from: i */
    private Object f563i;

    /* JADX INFO: renamed from: j */
    private Object[] f564j;

    /* JADX INFO: renamed from: k */
    private Throwable f565k;

    public C2066ap(C2063am c2063am, String str, String str2, boolean z) {
        this.f556b = c2063am;
        this.f558d = str;
        this.f559e = str2;
        this.f557c = z;
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final CallTracker withArguments(Object... objArr) {
        if (!this.f561g && objArr != null && objArr.length > 0) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (m565a(obj)) {
                    objArr2[i] = obj;
                } else {
                    objArr2[i] = "not-evaluated";
                }
            }
            this.f564j = objArr2;
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEndedWithReturnValue(Object obj) {
        if (this.f561g) {
            return;
        }
        this.f562h = new C2123cs();
        if (m565a(obj)) {
            this.f563i = obj;
        } else {
            this.f563i = "not-evaluated";
        }
        m564a();
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEndedWithException(Exception exc) {
        if (this.f561g) {
            return;
        }
        this.f565k = exc;
        this.f562h = new C2123cs();
        m564a();
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEnded() {
        if (this.f561g) {
            return;
        }
        this.f562h = new C2123cs();
        m564a();
    }

    /* JADX INFO: renamed from: a */
    private void m564a() {
        this.f561g = true;
        this.f556b.m562a(new C2065ao(this.f558d, this.f559e, this.f557c, this.f564j, this.f563i, this.f565k, this.f560f, this.f562h));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m565a(Object obj) {
        return obj == null || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Character) || (obj instanceof String);
    }

    public final String toString() {
        return "InfoPointTracker{start=" + this.f560f + ", staticMethod=" + this.f557c + ", end=" + this.f562h + ", clazz='" + this.f558d + CoreConstants.SINGLE_QUOTE_CHAR + ", methodName='" + this.f559e + CoreConstants.SINGLE_QUOTE_CHAR + ", returnValue=" + this.f563i + ", args=" + Arrays.toString(this.f564j) + ", ex=" + this.f565k + '}';
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void setStartTime(long j) {
        this.f560f = new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j);
    }
}
