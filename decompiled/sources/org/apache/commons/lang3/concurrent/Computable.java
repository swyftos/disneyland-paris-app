package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public interface Computable<I, O> {
    O compute(I i) throws InterruptedException;
}
