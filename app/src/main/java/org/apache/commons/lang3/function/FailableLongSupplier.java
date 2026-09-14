package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableLongSupplier<E extends Throwable> {
    long getAsLong() throws Throwable;
}
