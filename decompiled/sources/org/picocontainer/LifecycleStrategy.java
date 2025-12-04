package org.picocontainer;

/* loaded from: classes6.dex */
public interface LifecycleStrategy {
    void dispose(Object obj);

    boolean hasLifecycle(Class<?> cls);

    boolean isLazy(ComponentAdapter<?> componentAdapter);

    void start(Object obj);

    void stop(Object obj);
}
