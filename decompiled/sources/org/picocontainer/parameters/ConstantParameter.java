package org.picocontainer.parameters;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoException;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public class ConstantParameter extends AbstractParameter implements Parameter, Serializable {
    private final Object value;

    public ConstantParameter(Object obj) {
        this.value = obj;
    }

    @Override // org.picocontainer.Parameter
    public Parameter.Resolver resolve(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        if (type instanceof Class) {
            return new Parameter.ValueResolver(isAssignable((Class) type), this.value, null);
        }
        if (type instanceof ParameterizedType) {
            return new Parameter.ValueResolver(isAssignable(((ParameterizedType) type).getRawType()), this.value, null);
        }
        return new Parameter.ValueResolver(true, this.value, null);
    }

    @Override // org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) throws PicoException {
        if (isAssignable(type)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        sb.append(" is not assignable from ");
        Object obj = this.value;
        sb.append(obj != null ? obj.getClass().getName() : "null");
        throw new PicoCompositionException(sb.toString());
    }

    protected boolean isAssignable(Type type) {
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        return checkPrimitive(cls) || cls.isInstance(this.value);
    }

    @Override // org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitParameter(this);
    }

    private boolean checkPrimitive(Class cls) {
        try {
            if (cls.isPrimitive()) {
                return cls.isAssignableFrom((Class) this.value.getClass().getField("TYPE").get(this.value));
            }
            return false;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }
}
