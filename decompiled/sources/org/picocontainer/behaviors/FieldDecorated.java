package org.picocontainer.behaviors;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class FieldDecorated extends AbstractBehavior {
    private final Decorator decorator;
    private final Class fieldClass;

    public interface Decorator {
        Object decorate(Object obj);
    }

    public FieldDecorated(ComponentAdapter componentAdapter, Class<?> cls, Decorator decorator) {
        super(componentAdapter);
        this.fieldClass = cls;
        this.decorator = decorator;
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public Object getComponentInstance(PicoContainer picoContainer, Type type) throws IllegalAccessException, SecurityException, IllegalArgumentException, PicoCompositionException {
        Object componentInstance = super.getComponentInstance(picoContainer, type);
        for (Field field : componentInstance.getClass().getDeclaredFields()) {
            if (field.getType() == this.fieldClass) {
                Object objDecorate = this.decorator.decorate(componentInstance);
                field.setAccessible(true);
                try {
                    field.set(componentInstance, objDecorate);
                } catch (IllegalAccessException e) {
                    throw new PicoCompositionException(e);
                }
            }
        }
        return componentInstance;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "FieldDecorated";
    }
}
