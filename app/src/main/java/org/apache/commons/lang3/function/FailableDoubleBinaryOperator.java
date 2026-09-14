package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface FailableDoubleBinaryOperator<E extends Throwable> {
    double applyAsDouble(double d, double d2) throws Throwable;
}
