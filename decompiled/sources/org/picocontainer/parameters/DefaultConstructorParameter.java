package org.picocontainer.parameters;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public final class DefaultConstructorParameter extends AbstractParameter implements Parameter, Serializable {
    public static final DefaultConstructorParameter INSTANCE = new DefaultConstructorParameter();

    @Override // org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitParameter(this);
    }

    @Override // org.picocontainer.Parameter
    public Parameter.Resolver resolve(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        return new Parameter.NotResolved();
    }

    @Override // org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) throws NoSuchMethodException, SecurityException {
        if (!(type instanceof Class)) {
            throw new ClassCastException("Unable to use except for class types.  Offending type: " + type);
        }
        try {
            ((Class) type).getConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No default constructor for type " + type, e);
        }
    }

    public String toString() {
        return "Force Default Constructor Parameter";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().getName().equals(DefaultConstructorParameter.class.getName());
    }
}
