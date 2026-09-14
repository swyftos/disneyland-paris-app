package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableBooleanSupplier<E extends Throwable> {
    boolean getAsBoolean() throws Throwable;
}
