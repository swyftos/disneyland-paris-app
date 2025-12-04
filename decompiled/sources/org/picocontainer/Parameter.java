package org.picocontainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.picocontainer.parameters.ComponentParameter;
import org.picocontainer.parameters.DefaultConstructorParameter;

/* loaded from: classes6.dex */
public interface Parameter {
    public static final Parameter[] ZERO = {DefaultConstructorParameter.INSTANCE};
    public static final Parameter[] DEFAULT = {ComponentParameter.DEFAULT};

    public static class NotResolved implements Resolver {
        @Override // org.picocontainer.Parameter.Resolver
        public ComponentAdapter<?> getComponentAdapter() {
            return null;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public boolean isResolved() {
            return false;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public Object resolveInstance() {
            return null;
        }
    }

    public interface Resolver {
        ComponentAdapter<?> getComponentAdapter();

        boolean isResolved();

        Object resolveInstance();
    }

    void accept(PicoVisitor picoVisitor);

    @Deprecated
    boolean isResolvable(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation);

    Resolver resolve(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, Type type, NameBinding nameBinding, boolean z, Annotation annotation);

    @Deprecated
    Object resolveInstance(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation);

    void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation);

    public static abstract class DelegateResolver implements Resolver {
        private final Resolver delegate;

        public DelegateResolver(Resolver resolver) {
            this.delegate = resolver;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public boolean isResolved() {
            return this.delegate.isResolved();
        }

        @Override // org.picocontainer.Parameter.Resolver
        public Object resolveInstance() {
            return this.delegate.resolveInstance();
        }

        @Override // org.picocontainer.Parameter.Resolver
        public ComponentAdapter<?> getComponentAdapter() {
            return this.delegate.getComponentAdapter();
        }
    }

    public static class ValueResolver implements Resolver {
        private final ComponentAdapter adapter;
        private final boolean resolvable;
        private final Object value;

        public ValueResolver(boolean z, Object obj, ComponentAdapter<?> componentAdapter) {
            this.resolvable = z;
            this.value = obj;
            this.adapter = componentAdapter;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public boolean isResolved() {
            return this.resolvable;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public Object resolveInstance() {
            return this.value;
        }

        @Override // org.picocontainer.Parameter.Resolver
        public ComponentAdapter<?> getComponentAdapter() {
            return this.adapter;
        }
    }
}
