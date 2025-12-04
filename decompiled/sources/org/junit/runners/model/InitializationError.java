package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    private final List fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public InitializationError(Throwable th) {
        this((List<Throwable>) Arrays.asList(th));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }
}
