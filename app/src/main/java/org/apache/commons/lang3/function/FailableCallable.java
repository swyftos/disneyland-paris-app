package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableCallable<R, E extends Throwable> {
    R call() throws Throwable;
}
