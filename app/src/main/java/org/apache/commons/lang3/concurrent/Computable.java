package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface Computable<I, O> {
    O compute(I i) throws InterruptedException;
}
