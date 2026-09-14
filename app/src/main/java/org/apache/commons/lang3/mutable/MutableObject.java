package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private Object value;

    public MutableObject() {
    }

    public MutableObject(T t) {
        this.value = t;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return Objects.equals(this.value, ((MutableObject) obj).value);
        }
        return false;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    @Deprecated
    /* JADX INFO: renamed from: getValue */
    public T getValue2() {
        return (T) this.value;
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        return Objects.toString(this.value);
    }
}
