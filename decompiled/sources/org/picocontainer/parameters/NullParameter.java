package org.picocontainer.parameters;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public class NullParameter extends AbstractParameter implements Serializable {
    public static final NullParameter INSTANCE = new NullParameter();

    protected NullParameter() {
    }

    @Override // org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitParameter(this);
    }

    @Override // org.picocontainer.Parameter
    public Parameter.Resolver resolve(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        return new Parameter.ValueResolver(isAssignable(type), null, null);
    }

    @Override // org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        if (isAssignable(type)) {
            return;
        }
        throw new PicoCompositionException(type + " cannot be assigned a null value");
    }

    protected boolean isAssignable(Type type) {
        return ((type instanceof Class) && ((Class) Class.class.cast(type)).isPrimitive()) ? false : true;
    }
}
