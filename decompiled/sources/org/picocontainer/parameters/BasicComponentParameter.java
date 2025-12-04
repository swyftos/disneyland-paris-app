package org.picocontainer.parameters;

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

/* loaded from: classes6.dex */
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> org.picocontainer.ComponentAdapter<T> resolveAdapter(org.picocontainer.PicoContainer r6, org.picocontainer.ComponentAdapter r7, java.lang.Class<T> r8, org.picocontainer.NameBinding r9, boolean r10, java.lang.annotation.Annotation r11) {
        /*
            r5 = this;
            boolean r0 = r8.isPrimitive()
            if (r0 == 0) goto L42
            java.lang.String r0 = r8.getName()
            java.lang.String r1 = "int"
            if (r0 != r1) goto L11
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            goto L43
        L11:
            java.lang.String r1 = "long"
            if (r0 != r1) goto L18
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            goto L43
        L18:
            java.lang.String r1 = "float"
            if (r0 != r1) goto L1f
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            goto L43
        L1f:
            java.lang.String r1 = "double"
            if (r0 != r1) goto L26
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            goto L43
        L26:
            java.lang.String r1 = "boolean"
            if (r0 != r1) goto L2d
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            goto L43
        L2d:
            java.lang.String r1 = "char"
            if (r0 != r1) goto L34
            java.lang.Class<java.lang.Character> r0 = java.lang.Character.class
            goto L43
        L34:
            java.lang.String r1 = "short"
            if (r0 != r1) goto L3b
            java.lang.Class<java.lang.Short> r0 = java.lang.Short.class
            goto L43
        L3b:
            java.lang.String r1 = "byte"
            if (r0 != r1) goto L42
            java.lang.Class<java.lang.Byte> r0 = java.lang.Byte.class
            goto L43
        L42:
            r0 = r8
        L43:
            java.lang.Object r1 = r5.componentKey
            r2 = 0
            if (r1 == 0) goto L52
            org.picocontainer.ComponentAdapter r7 = r6.getComponentAdapter(r1)
            org.picocontainer.ComponentAdapter r7 = typeComponentAdapter(r7)
            goto Lc0
        L52:
            if (r7 != 0) goto L5a
            org.picocontainer.ComponentAdapter r7 = r6.getComponentAdapter(r0, r2)
            goto Lc0
        L5a:
            java.lang.Object r1 = r7.getComponentKey()
            org.picocontainer.ComponentAdapter r3 = r6.getComponentAdapter(r8)
            if (r3 == 0) goto L73
            java.lang.Object r4 = r3.getComponentKey()
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L73
            org.picocontainer.ComponentAdapter r3 = typeComponentAdapter(r3)
            goto L74
        L73:
            r3 = r2
        L74:
            if (r3 != 0) goto L8c
            if (r10 == 0) goto L8c
            java.lang.String r10 = r9.getName()
            org.picocontainer.ComponentAdapter r10 = r6.getComponentAdapter(r10)
            if (r10 == 0) goto L8c
            boolean r4 = r5.areCompatible(r6, r8, r10)
            if (r4 == 0) goto L8c
            if (r10 == r7) goto L8c
            r7 = r10
            goto L8d
        L8c:
            r7 = r3
        L8d:
            if (r7 != 0) goto Lc0
            if (r11 != 0) goto L96
            java.util.List r7 = r6.getComponentAdapters(r8)
            goto L9e
        L96:
            java.lang.Class r7 = r11.annotationType()
            java.util.List r7 = r6.getComponentAdapters(r8, r7)
        L9e:
            r5.removeExcludedAdapterIfApplicable(r1, r7)
            int r10 = r7.size()
            if (r10 != 0) goto Lac
            org.picocontainer.ComponentAdapter r7 = r5.noMatchingAdaptersFound(r6, r8, r9, r11)
            goto Lc0
        Lac:
            int r9 = r7.size()
            r10 = 1
            if (r9 != r10) goto Lbb
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            org.picocontainer.ComponentAdapter r7 = (org.picocontainer.ComponentAdapter) r7
            goto Lc0
        Lbb:
            org.picocontainer.injectors.AbstractInjector$AmbiguousComponentResolutionException r5 = r5.tooManyMatchingAdaptersFound(r8, r7)
            throw r5
        Lc0:
            if (r7 != 0) goto Lc3
            return r2
        Lc3:
            java.lang.Class r8 = r7.getComponentImplementation()
            boolean r8 = r0.isAssignableFrom(r8)
            if (r8 != 0) goto Le0
            java.lang.Class r8 = r7.getComponentImplementation()
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            if (r8 != r9) goto Ldf
            org.picocontainer.Converters r5 = r5.getConverters(r6)
            boolean r5 = r5.canConvert(r0)
            if (r5 != 0) goto Le0
        Ldf:
            return r2
        Le0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.picocontainer.parameters.BasicComponentParameter.resolveAdapter(org.picocontainer.PicoContainer, org.picocontainer.ComponentAdapter, java.lang.Class, org.picocontainer.NameBinding, boolean, java.lang.annotation.Annotation):org.picocontainer.ComponentAdapter");
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
        while (true) {
            if (!it.hasNext()) {
                componentAdapter = null;
                break;
            } else {
                componentAdapter = (ComponentAdapter) it.next();
                if (componentAdapter.getComponentKey().equals(obj)) {
                    break;
                }
            }
        }
        list.remove(componentAdapter);
    }

    private boolean areCompatible(PicoContainer picoContainer, Class cls, ComponentAdapter componentAdapter) {
        Class<?> componentImplementation = componentAdapter.getComponentImplementation();
        return cls.isAssignableFrom(componentImplementation) || (componentImplementation == String.class && getConverters(picoContainer) != null && getConverters(picoContainer).canConvert(cls));
    }
}
