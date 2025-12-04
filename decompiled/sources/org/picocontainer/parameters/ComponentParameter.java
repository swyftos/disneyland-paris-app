package org.picocontainer.parameters;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.injectors.AbstractInjector;

/* loaded from: classes6.dex */
public class ComponentParameter extends BasicComponentParameter {
    private final Parameter collectionParameter;
    public static final ComponentParameter DEFAULT = new ComponentParameter();
    public static final ComponentParameter ARRAY = new ComponentParameter(false);
    public static final ComponentParameter ARRAY_ALLOW_EMPTY = new ComponentParameter(true);

    public ComponentParameter(Object obj) {
        this(obj, (Parameter) null);
    }

    public ComponentParameter() {
        this(false);
    }

    public ComponentParameter(boolean z) {
        this((Object) null, z ? CollectionComponentParameter.ARRAY_ALLOW_EMPTY : CollectionComponentParameter.ARRAY);
    }

    public ComponentParameter(Class cls, boolean z) {
        this((Object) null, new CollectionComponentParameter(cls, z));
    }

    public ComponentParameter(Class cls, Class cls2, boolean z) {
        this((Object) null, new CollectionComponentParameter(cls, cls2, z));
    }

    private ComponentParameter(Object obj, Parameter parameter) {
        super(obj);
        this.collectionParameter = parameter;
    }

    @Override // org.picocontainer.parameters.BasicComponentParameter, org.picocontainer.Parameter
    public Parameter.Resolver resolve(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        return new Parameter.Resolver(picoContainer, componentAdapter, componentAdapter2, type, nameBinding, z, annotation) { // from class: org.picocontainer.parameters.ComponentParameter.1
            final Parameter.Resolver resolver;
            final /* synthetic */ Annotation val$binding;
            final /* synthetic */ PicoContainer val$container;
            final /* synthetic */ NameBinding val$expectedNameBinding;
            final /* synthetic */ Type val$expectedType;
            final /* synthetic */ ComponentAdapter val$forAdapter;
            final /* synthetic */ ComponentAdapter val$injecteeAdapter;
            final /* synthetic */ boolean val$useNames;

            {
                this.val$container = picoContainer;
                this.val$forAdapter = componentAdapter;
                this.val$injecteeAdapter = componentAdapter2;
                this.val$expectedType = type;
                this.val$expectedNameBinding = nameBinding;
                this.val$useNames = z;
                this.val$binding = annotation;
                this.resolver = ComponentParameter.super.resolve(picoContainer, componentAdapter, componentAdapter2, type, nameBinding, z, annotation);
            }

            @Override // org.picocontainer.Parameter.Resolver
            public boolean isResolved() {
                boolean zIsResolved = this.resolver.isResolved();
                if (zIsResolved) {
                    return zIsResolved;
                }
                if (ComponentParameter.this.collectionParameter != null) {
                    return ComponentParameter.this.collectionParameter.resolve(this.val$container, this.val$forAdapter, null, this.val$expectedType, this.val$expectedNameBinding, this.val$useNames, this.val$binding).isResolved();
                }
                return false;
            }

            @Override // org.picocontainer.Parameter.Resolver
            public Object resolveInstance() {
                Object objResolveInstance;
                Type type2 = this.val$expectedType;
                if (type2 instanceof Class) {
                    objResolveInstance = ComponentParameter.super.resolve(this.val$container, this.val$forAdapter, this.val$injecteeAdapter, type2, this.val$expectedNameBinding, this.val$useNames, this.val$binding).resolveInstance();
                } else {
                    objResolveInstance = type2 instanceof ParameterizedType ? ComponentParameter.super.resolve(this.val$container, this.val$forAdapter, this.val$injecteeAdapter, ((ParameterizedType) type2).getRawType(), this.val$expectedNameBinding, this.val$useNames, this.val$binding).resolveInstance() : null;
                }
                return (objResolveInstance != null || ComponentParameter.this.collectionParameter == null) ? objResolveInstance : ComponentParameter.this.collectionParameter.resolve(this.val$container, this.val$forAdapter, this.val$injecteeAdapter, this.val$expectedType, this.val$expectedNameBinding, this.val$useNames, this.val$binding).resolveInstance();
            }

            @Override // org.picocontainer.Parameter.Resolver
            public ComponentAdapter getComponentAdapter() {
                return this.resolver.getComponentAdapter();
            }
        };
    }

    @Override // org.picocontainer.parameters.BasicComponentParameter, org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        try {
            super.verify(picoContainer, componentAdapter, type, nameBinding, z, annotation);
        } catch (AbstractInjector.UnsatisfiableDependenciesException e) {
            if (this.collectionParameter != null) {
                this.collectionParameter.verify(picoContainer, componentAdapter, type, nameBinding, z, annotation);
                return;
            }
            throw e;
        }
    }

    @Override // org.picocontainer.parameters.BasicComponentParameter, org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        super.accept(picoVisitor);
        Parameter parameter = this.collectionParameter;
        if (parameter != null) {
            parameter.accept(picoVisitor);
        }
    }
}
