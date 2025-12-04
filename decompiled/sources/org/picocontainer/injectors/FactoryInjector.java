package org.picocontainer.injectors;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public abstract class FactoryInjector<T> implements org.picocontainer.Injector<T> {
    private Class key;

    public static class CantWorkItOut {
    }

    public boolean componentHasLifecycle() {
        return false;
    }

    @Override // org.picocontainer.Injector
    public Object decorateComponentInstance(PicoContainer picoContainer, Type type, T t) {
        return null;
    }

    public void dispose(PicoContainer picoContainer) {
    }

    @Override // org.picocontainer.ComponentAdapter
    public <U extends ComponentAdapter> U findAdapterOfType(Class<U> cls) {
        return null;
    }

    @Override // org.picocontainer.ComponentAdapter
    public abstract T getComponentInstance(PicoContainer picoContainer, Type type);

    @Override // org.picocontainer.ComponentAdapter
    public ComponentAdapter<T> getDelegate() {
        return null;
    }

    public void start(PicoContainer picoContainer) {
    }

    public void stop(PicoContainer picoContainer) {
    }

    @Override // org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) {
    }

    public FactoryInjector() throws PicoCompositionException {
        Class<?> cls = getTypeArguments(FactoryInjector.class, getClass()).get(0);
        this.key = cls;
        if (cls == null) {
            this.key = CantWorkItOut.class;
        }
    }

    public FactoryInjector(Class<T> cls) {
        this.key = cls;
    }

    public static Class<?> getClass(Type type) {
        Class<?> cls;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof GenericArrayType) || (cls = getClass(((GenericArrayType) type).getGenericComponentType())) == null) {
            return null;
        }
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<Class<?>> getTypeArguments(Class<FactoryInjector> cls, Class<? extends Object> cls2) {
        int i;
        Type[] actualTypeArguments;
        HashMap map = new HashMap();
        while (true) {
            i = 0;
            if (getClass(cls2).equals(cls)) {
                break;
            }
            if (cls2 instanceof Class) {
                cls2 = ((Class) cls2).getGenericSuperclass();
            } else {
                ParameterizedType parameterizedType = cls2;
                Class cls3 = (Class) parameterizedType.getRawType();
                Type[] actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                TypeVariable<Class<T>>[] typeParameters = cls3.getTypeParameters();
                while (i < actualTypeArguments2.length) {
                    map.put(typeParameters[i], actualTypeArguments2[i]);
                    i++;
                }
                if (!cls3.equals(cls)) {
                    cls2 = cls3.getGenericSuperclass();
                }
            }
        }
        if (cls2 instanceof Class) {
            actualTypeArguments = ((Class) cls2).getTypeParameters();
        } else {
            actualTypeArguments = ((ParameterizedType) cls2).getActualTypeArguments();
        }
        ArrayList arrayList = new ArrayList();
        int length = actualTypeArguments.length;
        while (i < length) {
            Type type = actualTypeArguments[i];
            while (map.containsKey(type)) {
                type = (Type) map.get(type);
            }
            arrayList.add(getClass(type));
            i++;
        }
        return arrayList;
    }

    @Override // org.picocontainer.ComponentAdapter
    public Object getComponentKey() {
        return this.key;
    }

    @Override // org.picocontainer.ComponentAdapter
    public Class<? extends T> getComponentImplementation() {
        return this.key;
    }

    @Override // org.picocontainer.ComponentAdapter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentAdapter(this);
    }

    @Override // org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer) {
        throw new UnsupportedOperationException();
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "FactoryInjector-";
    }
}
