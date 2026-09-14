package org.apache.commons.lang3.builder;

import java.lang.Throwable;
import org.apache.commons.lang3.builder.AbstractSupplier;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSupplier<T, B extends AbstractSupplier<T, B, E>, E extends Throwable> implements FailableSupplier<T, E> {
    protected B asThis() {
        return this;
    }
}
