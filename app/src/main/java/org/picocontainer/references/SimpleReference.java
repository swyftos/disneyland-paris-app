package org.picocontainer.references;

import java.io.Serializable;
import org.picocontainer.ObjectReference;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleReference<T> implements ObjectReference<T>, Serializable {
    private Object instance;

    @Override // org.picocontainer.ObjectReference
    public T get() {
        return (T) this.instance;
    }

    @Override // org.picocontainer.ObjectReference
    public void set(T t) {
        this.instance = t;
    }
}
