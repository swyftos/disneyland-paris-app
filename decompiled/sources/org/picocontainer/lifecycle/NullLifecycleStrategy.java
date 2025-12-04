package org.picocontainer.lifecycle;

import java.io.Serializable;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;

/* loaded from: classes6.dex */
public class NullLifecycleStrategy implements LifecycleStrategy, Serializable {
    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) {
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        return false;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        return false;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) {
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
    }
}
