package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.CallTracker;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class ap implements CallTracker {
    public static final CallTracker a = new CallTracker() { // from class: com.appdynamics.eumagent.runtime.private.ap.1
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
    private final am b;
    private boolean c;
    private String d;
    private String e;
    private cs f = new cs();
    private boolean g = false;
    private cs h = null;
    private Object i;
    private Object[] j;
    private Throwable k;

    public ap(am amVar, String str, String str2, boolean z) {
        this.b = amVar;
        this.d = str;
        this.e = str2;
        this.c = z;
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final CallTracker withArguments(Object... objArr) {
        if (!this.g && objArr != null && objArr.length > 0) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (a(obj)) {
                    objArr2[i] = obj;
                } else {
                    objArr2[i] = "not-evaluated";
                }
            }
            this.j = objArr2;
        }
        return this;
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEndedWithReturnValue(Object obj) {
        if (this.g) {
            return;
        }
        this.h = new cs();
        if (a(obj)) {
            this.i = obj;
        } else {
            this.i = "not-evaluated";
        }
        a();
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEndedWithException(Exception exc) {
        if (this.g) {
            return;
        }
        this.k = exc;
        this.h = new cs();
        a();
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void reportCallEnded() {
        if (this.g) {
            return;
        }
        this.h = new cs();
        a();
    }

    private void a() {
        this.g = true;
        this.b.a(new ao(this.d, this.e, this.c, this.j, this.i, this.k, this.f, this.h));
    }

    private static boolean a(Object obj) {
        return obj == null || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Character) || (obj instanceof String);
    }

    public final String toString() {
        return "InfoPointTracker{start=" + this.f + ", staticMethod=" + this.c + ", end=" + this.h + ", clazz='" + this.d + CoreConstants.SINGLE_QUOTE_CHAR + ", methodName='" + this.e + CoreConstants.SINGLE_QUOTE_CHAR + ", returnValue=" + this.i + ", args=" + Arrays.toString(this.j) + ", ex=" + this.k + '}';
    }

    @Override // com.appdynamics.eumagent.runtime.CallTracker
    public final void setStartTime(long j) {
        this.f = new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j);
    }
}
