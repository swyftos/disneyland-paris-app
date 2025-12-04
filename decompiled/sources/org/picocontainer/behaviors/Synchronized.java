package org.picocontainer.behaviors;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class Synchronized<T> extends AbstractBehavior<T> {
    public Synchronized(ComponentAdapter<T> componentAdapter) {
        super(componentAdapter);
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public synchronized T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        return (T) super.getComponentInstance(picoContainer, type);
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Synchronized";
    }
}
