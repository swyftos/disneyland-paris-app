package org.picocontainer.behaviors;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class Decorated<T> extends AbstractBehavior<T> {
    private final Decorator decorator;

    interface Decorator {
        void decorate(Object obj);
    }

    public Decorated(ComponentAdapter<T> componentAdapter, Decorator decorator) {
        super(componentAdapter);
        this.decorator = decorator;
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        T t = (T) super.getComponentInstance(picoContainer, type);
        this.decorator.decorate(t);
        return t;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "FieldDecorated";
    }
}
