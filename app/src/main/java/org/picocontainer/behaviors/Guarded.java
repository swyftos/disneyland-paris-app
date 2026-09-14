package org.picocontainer.behaviors;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* JADX INFO: loaded from: classes5.dex */
public class Guarded<T> extends AbstractBehavior<T> {
    private final String guard;

    public Guarded(ComponentAdapter componentAdapter, String str) {
        super(componentAdapter);
        this.guard = str;
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        picoContainer.getComponent(this.guard);
        return (T) super.getComponentInstance(picoContainer, type);
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Guarded(with " + this.guard + ")";
    }
}
