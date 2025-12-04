package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;

/* loaded from: classes2.dex */
public enum Throwables {
    ;

    public static Throwable getRootCause(Throwable th) {
        if (th == null) {
            return th;
        }
        int i = 0;
        Throwable th2 = th;
        while (i < 1000) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            i++;
            th2 = cause;
        }
        LogFactory.getLog(Throwables.class).debug("Possible circular reference detected on " + th.getClass() + ": [" + th + "]");
        return th;
    }
}
