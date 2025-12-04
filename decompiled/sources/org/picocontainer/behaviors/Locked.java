package org.picocontainer.behaviors;

import java.lang.reflect.Type;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class Locked<T> extends AbstractBehavior<T> {
    private Lock lock;

    public Locked(ComponentAdapter<T> componentAdapter) {
        super(componentAdapter);
        this.lock = new ReentrantLock();
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        this.lock.lock();
        try {
            return (T) super.getComponentInstance(picoContainer, type);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Locked";
    }
}
