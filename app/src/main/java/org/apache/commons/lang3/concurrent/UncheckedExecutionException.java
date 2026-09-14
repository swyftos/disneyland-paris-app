package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: loaded from: classes6.dex */
public class UncheckedExecutionException extends UncheckedException {
    private static final long serialVersionUID = 1;

    public UncheckedExecutionException(Throwable th) {
        super(th);
    }
}
