package org.junit.internal.runners;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    private final List fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public InitializationError(Throwable... thArr) {
        this((List<Throwable>) Arrays.asList(thArr));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }
}
