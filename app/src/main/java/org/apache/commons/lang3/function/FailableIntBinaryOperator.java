package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableIntBinaryOperator<E extends Throwable> {
    int applyAsInt(int i, int i2) throws Throwable;
}
