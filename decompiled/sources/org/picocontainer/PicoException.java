package org.picocontainer;

/* loaded from: classes6.dex */
public abstract class PicoException extends RuntimeException {
    protected PicoException() {
    }

    protected PicoException(String str) {
        super(str);
    }

    protected PicoException(Throwable th) {
        super(th);
    }

    protected PicoException(String str, Throwable th) {
        super(str, th);
    }
}
