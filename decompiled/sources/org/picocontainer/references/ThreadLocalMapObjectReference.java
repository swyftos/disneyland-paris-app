package org.picocontainer.references;

import java.util.Map;
import org.picocontainer.ObjectReference;

/* loaded from: classes6.dex */
public class ThreadLocalMapObjectReference<T> implements ObjectReference<T> {
    private final Object componentKey;
    private final ThreadLocal threadLocal;

    public ThreadLocalMapObjectReference(ThreadLocal<Map<Object, T>> threadLocal, Object obj) {
        this.threadLocal = threadLocal;
        this.componentKey = obj;
    }

    @Override // org.picocontainer.ObjectReference
    public T get() {
        return (T) ((Map) this.threadLocal.get()).get(this.componentKey);
    }

    @Override // org.picocontainer.ObjectReference
    public void set(T t) {
        ((Map) this.threadLocal.get()).put(this.componentKey, t);
    }
}
