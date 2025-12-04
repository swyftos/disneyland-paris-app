package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;

/* loaded from: classes2.dex */
public final class co extends Throwable {
    public co(Throwable th) {
        super(th);
    }

    public final void a() {
        Throwable cause = getCause();
        if (cause == null) {
            ADLog.logAgentError("Somehow a ClientCausedThrowable doesn't have a caused by", this);
            return;
        }
        if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        ADLog.logAgentError("Tried to rethrow a client throwable", new RuntimeException("Unhandled Exception Type: " + getCause().getClass()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Throwable */
    public final <T extends Throwable> void a(Class<T> cls) throws T {
        Throwable cause = getCause();
        if (cause == null) {
            ADLog.logAgentError("Somehow a ClientCausedThrowable doesn't have a caused by", this);
        } else {
            if (cls.isInstance(cause)) {
                throw cls.cast(cause);
            }
            a();
        }
    }
}
