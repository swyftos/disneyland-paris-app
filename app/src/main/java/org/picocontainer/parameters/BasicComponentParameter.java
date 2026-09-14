package org.picocontainer.parameters;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.picocontainer.Behavior;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.Converters;
import org.picocontainer.Converting;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.adapters.InstanceAdapter;
import org.picocontainer.injectors.AbstractInjector;
import org.picocontainer.injectors.InjectInto;
import org.picocontainer.injectors.Provider;

/* JADX INFO: loaded from: classes5.dex */
public class BasicComponentParameter extends AbstractParameter implements Parameter, Serializable {
    public static final BasicComponentParameter BASIC_DEFAULT = new BasicComponentParameter();
    private Object componentKey;

    private static ComponentAdapter typeComponentAdapter(ComponentAdapter componentAdapter) {
        return componentAdapter;
    }

    public BasicComponentParameter(Object obj) {
        this.componentKey = obj;
    }

    public BasicComponentParameter() {
    }

    @Override // org.picocontainer.Parameter
    public Parameter.Resolver resolve(final PicoContainer picoContainer, final ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, final Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        Class cls;
        if (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                cls = (Class) ((ParameterizedType) type).getRawType();
            } else {
                return new Parameter.NotResolved();
            }
        } else {
            cls = (Class) type;
        }
        Class cls2 = cls;
        if (componentAdapter2 == null) {
            componentAdapter2 = resolveAdapter(picoContainer, componentAdapter, cls2, nameBinding, z, annotation);
        }
        final ComponentAdapter<?> componentAdapter3 = componentAdapter2;
        return new Parameter.Resolver() { // from class: org.picocontainer.parameters.BasicComponentParameter.1
            @Override // org.picocontainer.Parameter.Resolver
            public boolean isResolved() {
                return componentAdapter3 != null;
            }

            @Override // org.picocontainer.Parameter.Resolver
            public Object resolveInstance() {
                ComponentAdapter componentAdapter4 = componentAdapter3;
                if (componentAdapter4 == null) {
                    return null;
                }
                return componentAdapter4 instanceof DefaultPicoContainer.LateInstance ? BasicComponentParameter.convert(BasicComponentParameter.this.getConverters(picoContainer), ((DefaultPicoContainer.LateInstance) componentAdapter3).getComponentInstance(), type) : BasicComponentParameter.convert(BasicComponentParameter.this.getConverters(picoContainer), picoContainer.getComponent(componentAdapter3.getComponentKey(), BasicComponentParameter.makeInjectInto(componentAdapter)), type);
            }

            @Override // org.picocontainer.Parameter.Resolver
            public ComponentAdapter getComponentAdapter() {
                return componentAdapter3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Converters getConverters(PicoContainer picoContainer) {
        if (picoContainer instanceof Converting) {
            return ((Converting) picoContainer).getConverters();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InjectInto makeInjectInto(ComponentAdapter componentAdapter) {
        return new InjectInto(componentAdapter.getComponentImplementation(), componentAdapter.getComponentKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object convert(Converters converters, Object obj, Type type) {
        return (!(obj instanceof String) || type == String.class) ? obj : converters.convert((String) obj, type);
    }

    @Override // org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        ComponentAdapter componentAdapterResolveAdapter = resolveAdapter(picoContainer, componentAdapter, (Class) type, nameBinding, z, annotation);
        if (componentAdapterResolveAdapter == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(type);
            throw new AbstractInjector.UnsatisfiableDependenciesException(componentAdapter.getComponentImplementation().getName() + " has unsatisfied dependencies: " + hashSet + " from " + picoContainer);
        }
        componentAdapterResolveAdapter.verify(picoContainer);
    }

    @Override // org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitParameter(this);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0042  */
    /* JADX WARN: Multi-variable type inference failed */
    protected <T> ComponentAdapter<T> resolveAdapter(PicoContainer picoContainer, ComponentAdapter componentAdapter, Class<T> cls, NameBinding nameBinding, boolean z, Annotation annotation) {
        Class cls2;
        ComponentAdapter componentAdapterNoMatchingAdaptersFound;
        ComponentAdapter<?> componentAdapter2;
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name == "int") {
                cls2 = Integer.class;
            } else if (name == LongTypedProperty.TYPE) {
                cls2 = Long.class;
            } else if (name == TypedValues.Custom.S_FLOAT) {
                cls2 = Float.class;
            } else if (name == DoubleTypedProperty.TYPE) {
                cls2 = Double.class;
            } else if (name == "boolean") {
                cls2 = Boolean.class;
            } else if (name == "char") {
                cls2 = Character.class;
            } else if (name == "short") {
                cls2 = Short.class;
            } else if (name == "byte") {
                cls2 = Byte.class;
            } else {
                cls2 = cls;
            }
        } else {
            cls2 = cls;
        }
        Object obj = this.componentKey;
        if (obj != null) {
            componentAdapterNoMatchingAdaptersFound = typeComponentAdapter(picoContainer.getComponentAdapter(obj));
        } else if (componentAdapter == null) {
            componentAdapterNoMatchingAdaptersFound = picoContainer.getComponentAdapter(cls2, (NameBinding) null);
        } else {
            Object componentKey = componentAdapter.getComponentKey();
            ComponentAdapter<?> componentAdapter3 = picoContainer.getComponentAdapter(cls);
            ComponentAdapter componentAdapterTypeComponentAdapter = (componentAdapter3 == null || componentKey.equals(componentAdapter3.getComponentKey())) ? null : typeComponentAdapter(componentAdapter3);
            componentAdapterNoMatchingAdaptersFound = (componentAdapterTypeComponentAdapter == null && z && (componentAdapter2 = picoContainer.getComponentAdapter(nameBinding.getName())) != null && areCompatible(picoContainer, cls, componentAdapter2) && componentAdapter2 != componentAdapter) ? componentAdapter2 : componentAdapterTypeComponentAdapter;
            if (componentAdapterNoMatchingAdaptersFound == null) {
                List componentAdapters = annotation == null ? picoContainer.getComponentAdapters(cls) : picoContainer.getComponentAdapters(cls, annotation.annotationType());
                removeExcludedAdapterIfApplicable(componentKey, componentAdapters);
                if (componentAdapters.size() == 0) {
                    componentAdapterNoMatchingAdaptersFound = noMatchingAdaptersFound(picoContainer, cls, nameBinding, annotation);
                } else if (componentAdapters.size() == 1) {
                    componentAdapterNoMatchingAdaptersFound = (ComponentAdapter) componentAdapters.get(0);
                } else {
                    throw tooManyMatchingAdaptersFound(cls, componentAdapters);
                }
            }
        }
        if (componentAdapterNoMatchingAdaptersFound == null) {
            return null;
        }
        if (cls2.isAssignableFrom(componentAdapterNoMatchingAdaptersFound.getComponentImplementation()) || (componentAdapterNoMatchingAdaptersFound.getComponentImplementation() == String.class && getConverters(picoContainer).canConvert(cls2))) {
            return componentAdapterNoMatchingAdaptersFound;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComponentAdapter noMatchingAdaptersFound(PicoContainer picoContainer, Class cls, NameBinding nameBinding, Annotation annotation) {
        if (picoContainer.getParent() == null) {
            return null;
        }
        if (annotation != null) {
            return picoContainer.getParent().getComponentAdapter(cls, (Class<? extends Annotation>) annotation.getClass());
        }
        return picoContainer.getParent().getComponentAdapter(cls, nameBinding);
    }

    private AbstractInjector.AmbiguousComponentResolutionException tooManyMatchingAdaptersFound(Class cls, List list) {
        return new AbstractInjector.AmbiguousComponentResolutionException(cls, makeFoundAmbiguousStrings(list));
    }

    public static <T> String[] makeFoundAmbiguousStrings(Collection<ComponentAdapter<T>> collection) {
        String[] strArr = new String[collection.size()];
        Iterator<ComponentAdapter<T>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = findInjectorOrInstanceAdapter(it.next()).toString();
            i++;
        }
        return strArr;
    }

    public static ComponentAdapter<?> findInjectorOrInstanceAdapter(ComponentAdapter<?> componentAdapter) {
        while (true) {
            if (!(componentAdapter instanceof Behavior) && (!(componentAdapter instanceof LifecycleStrategy) || (componentAdapter instanceof InstanceAdapter) || (componentAdapter instanceof Provider))) {
                break;
            }
            componentAdapter = componentAdapter.getDelegate();
        }
        return componentAdapter;
    }

    private void removeExcludedAdapterIfApplicable(Object obj, List list) {
        ComponentAdapter componentAdapter;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            componentAdapter = (ComponentAdapter) it.next();
            if (componentAdapter.getComponentKey().equals(obj)) {
                list.remove(componentAdapter);
            }
        }
        componentAdapter = null;
        list.remove(componentAdapter);
    }

    private boolean areCompatible(PicoContainer picoContainer, Class cls, ComponentAdapter componentAdapter) {
        Class<?> componentImplementation = componentAdapter.getComponentImplementation();
        return cls.isAssignableFrom(componentImplementation) || (componentImplementation == String.class && getConverters(picoContainer) != null && getConverters(picoContainer).canConvert(cls));
    }
}
