package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableShortSupplier<E extends Throwable> {
    short getAsShort() throws Throwable;
}
