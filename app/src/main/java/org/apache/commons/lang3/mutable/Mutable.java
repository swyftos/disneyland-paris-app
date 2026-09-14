package org.apache.commons.lang3.mutable;

import java.util.function.Supplier;

/* JADX INFO: loaded from: classes6.dex */
public interface Mutable<T> extends Supplier<T> {
    @Deprecated
    T getValue();

    void setValue(T t);

    @Override // java.util.function.Supplier
    default T get() {
        return getValue();
    }
}
