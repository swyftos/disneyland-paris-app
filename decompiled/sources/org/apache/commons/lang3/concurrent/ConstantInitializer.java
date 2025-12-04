package org.apache.commons.lang3.concurrent;

import java.util.Objects;

/* loaded from: classes6.dex */
public class ConstantInitializer<T> implements ConcurrentInitializer<T> {
    private final Object object;

    public ConstantInitializer(T t) {
        this.object = t;
    }

    public final T getObject() {
        return (T) this.object;
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        return getObject();
    }

    public int hashCode() {
        if (getObject() != null) {
            return getObject().hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstantInitializer) {
            return Objects.equals(getObject(), ((ConstantInitializer) obj).getObject());
        }
        return false;
    }

    public String toString() {
        return String.format("ConstantInitializer@%d [ object = %s ]", Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject()));
    }
}
