package org.picocontainer.parameters;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public class CollectionComponentParameter extends AbstractParameter implements Parameter, Serializable {
    public static final CollectionComponentParameter ARRAY = new CollectionComponentParameter();
    public static final CollectionComponentParameter ARRAY_ALLOW_EMPTY = new CollectionComponentParameter(true);
    private final Class componentKeyType;
    private final Class componentValueType;
    private final boolean emptyCollection;

    protected boolean evaluate(ComponentAdapter componentAdapter) {
        return componentAdapter != null;
    }

    public CollectionComponentParameter() {
        this(false);
    }

    public CollectionComponentParameter(boolean z) {
        this(Void.TYPE, z);
    }

    public CollectionComponentParameter(Class cls, boolean z) {
        this(Object.class, cls, z);
    }

    public CollectionComponentParameter(Class cls, Class cls2, boolean z) {
        this.emptyCollection = z;
        this.componentKeyType = cls;
        this.componentValueType = cls2;
    }

    @Override // org.picocontainer.Parameter
    public Parameter.Resolver resolve(final PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, ComponentAdapter<?> componentAdapter2, final Type type, final NameBinding nameBinding, final boolean z, Annotation annotation) {
        final Class collectionType = getCollectionType(type);
        if (collectionType != null) {
            final Map<Object, ComponentAdapter<?>> matchingComponentAdapters = getMatchingComponentAdapters(picoContainer, componentAdapter, this.componentKeyType, getValueType(type));
            return new Parameter.Resolver() { // from class: org.picocontainer.parameters.CollectionComponentParameter.1
                @Override // org.picocontainer.Parameter.Resolver
                public ComponentAdapter getComponentAdapter() {
                    return null;
                }

                @Override // org.picocontainer.Parameter.Resolver
                public boolean isResolved() {
                    return CollectionComponentParameter.this.emptyCollection || matchingComponentAdapters.size() > 0;
                }

                @Override // org.picocontainer.Parameter.Resolver
                public Object resolveInstance() {
                    if (collectionType.isArray()) {
                        return CollectionComponentParameter.this.getArrayInstance(picoContainer, collectionType, matchingComponentAdapters);
                    }
                    if (Map.class.isAssignableFrom(collectionType)) {
                        return CollectionComponentParameter.this.getMapInstance(picoContainer, collectionType, matchingComponentAdapters);
                    }
                    if (Collection.class.isAssignableFrom(collectionType)) {
                        return CollectionComponentParameter.this.getCollectionInstance(picoContainer, collectionType, matchingComponentAdapters, nameBinding, z);
                    }
                    throw new PicoCompositionException(type + " is not a collective type");
                }
            };
        }
        return new Parameter.NotResolved();
    }

    private Class getCollectionType(Type type) {
        if (type instanceof Class) {
            return getCollectionType((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return getCollectionType(((ParameterizedType) type).getRawType());
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) getGenericArrayBaseType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        throw new IllegalArgumentException("Unable to get collection type from " + type);
    }

    private Class getGenericArrayBaseType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getGenericArrayBaseType(((ParameterizedType) type).getRawType());
        }
        throw new IllegalArgumentException("Unable to get collection type from " + type);
    }

    @Override // org.picocontainer.Parameter
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) throws PicoCompositionException {
        if (getCollectionType(type) != null) {
            Class valueType = getValueType(type);
            Collection<ComponentAdapter<?>> collectionValues = getMatchingComponentAdapters(picoContainer, componentAdapter, this.componentKeyType, valueType).values();
            if (collectionValues.isEmpty()) {
                if (this.emptyCollection) {
                    return;
                }
                throw new PicoCompositionException(type + " not resolvable, no components of type " + valueType.getName() + " available");
            }
            Iterator<ComponentAdapter<?>> it = collectionValues.iterator();
            while (it.hasNext()) {
                it.next().verify(picoContainer);
            }
            return;
        }
        throw new PicoCompositionException(type + " is not a collective type");
    }

    @Override // org.picocontainer.Parameter
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitParameter(this);
    }

    protected Map<Object, ComponentAdapter<?>> getMatchingComponentAdapters(PicoContainer picoContainer, ComponentAdapter componentAdapter, Class cls, Class cls2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PicoContainer parent = picoContainer.getParent();
        if (parent != null) {
            linkedHashMap.putAll(getMatchingComponentAdapters(parent, componentAdapter, cls, cls2));
        }
        Iterator<ComponentAdapter<?>> it = picoContainer.getComponentAdapters().iterator();
        while (it.hasNext()) {
            linkedHashMap.remove(it.next().getComponentKey());
        }
        for (ComponentAdapter componentAdapter2 : (List) List.class.cast(picoContainer.getComponentAdapters(cls2))) {
            Object componentKey = componentAdapter2.getComponentKey();
            if (componentAdapter == null || !componentKey.equals(componentAdapter.getComponentKey())) {
                if (cls.isAssignableFrom(componentKey.getClass()) && evaluate(componentAdapter2)) {
                    linkedHashMap.put(componentKey, componentAdapter2);
                }
            }
        }
        return linkedHashMap;
    }

    private Class getCollectionType(Class cls) {
        if (cls.isArray() || Map.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    private Class getValueType(Type type) {
        if (type instanceof Class) {
            return getValueType((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return getValueType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return getGenericArrayBaseType(((GenericArrayType) type).getGenericComponentType());
        }
        throw new IllegalArgumentException("Unable to determine collection type from " + type);
    }

    private Class getValueType(Class cls) {
        return cls.isArray() ? cls.getComponentType() : this.componentValueType;
    }

    private Class getValueType(ParameterizedType parameterizedType) {
        Class<?> cls = this.componentValueType;
        if (!Collection.class.isAssignableFrom((Class) parameterizedType.getRawType())) {
            return cls;
        }
        Type type = parameterizedType.getActualTypeArguments()[0];
        if (!(type instanceof Class)) {
            return cls;
        }
        Class cls2 = (Class) type;
        return cls2.isAssignableFrom(cls) ? cls : cls2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getArrayInstance(PicoContainer picoContainer, Class cls, Map map) {
        Object[] objArr = (Object[]) Array.newInstance(cls.getComponentType(), map.size());
        Iterator it = map.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = picoContainer.getComponent(((ComponentAdapter) it.next()).getComponentKey());
            i++;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection getCollectionInstance(org.picocontainer.PicoContainer r2, java.lang.Class r3, java.util.Map r4, org.picocontainer.NameBinding r5, boolean r6) {
        /*
            r1 = this;
            boolean r1 = r3.isInterface()
            if (r1 == 0) goto L31
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r1 = r1.isAssignableFrom(r3)
            java.lang.Class<java.util.ArrayList> r0 = java.util.ArrayList.class
            if (r1 == 0) goto L12
        L10:
            r3 = r0
            goto L31
        L12:
            java.lang.Class<java.util.SortedSet> r1 = java.util.SortedSet.class
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L1d
            java.lang.Class<java.util.TreeSet> r3 = java.util.TreeSet.class
            goto L31
        L1d:
            java.lang.Class<java.util.Set> r1 = java.util.Set.class
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L28
            java.lang.Class<java.util.HashSet> r3 = java.util.HashSet.class
            goto L31
        L28:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L31
            goto L10
        L31:
            java.lang.Object r1 = r3.newInstance()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            java.util.Collection r3 = r4.values()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
        L3f:
            boolean r4 = r3.hasNext()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            if (r4 == 0) goto L64
            java.lang.Object r4 = r3.next()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            org.picocontainer.ComponentAdapter r4 = (org.picocontainer.ComponentAdapter) r4     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            if (r6 == 0) goto L58
            java.lang.Object r0 = r4.getComponentKey()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            if (r0 != r5) goto L3f
            goto L58
        L54:
            r1 = move-exception
            goto L65
        L56:
            r1 = move-exception
            goto L6b
        L58:
            java.lang.Object r4 = r4.getComponentKey()     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            java.lang.Object r4 = r2.getComponent(r4)     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            r1.add(r4)     // Catch: java.lang.IllegalAccessException -> L54 java.lang.InstantiationException -> L56
            goto L3f
        L64:
            return r1
        L65:
            org.picocontainer.PicoCompositionException r2 = new org.picocontainer.PicoCompositionException
            r2.<init>(r1)
            throw r2
        L6b:
            org.picocontainer.PicoCompositionException r2 = new org.picocontainer.PicoCompositionException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.picocontainer.parameters.CollectionComponentParameter.getCollectionInstance(org.picocontainer.PicoContainer, java.lang.Class, java.util.Map, org.picocontainer.NameBinding, boolean):java.util.Collection");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map getMapInstance(PicoContainer picoContainer, Class cls, Map map) {
        if (cls.isInterface()) {
            if (SortedMap.class.isAssignableFrom(cls)) {
                cls = TreeMap.class;
            } else if (Map.class.isAssignableFrom(cls)) {
                cls = HashMap.class;
            }
        }
        try {
            Map map2 = (Map) cls.newInstance();
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object key = ((Map.Entry) it.next()).getKey();
                map2.put(key, picoContainer.getComponent(key));
            }
            return map2;
        } catch (IllegalAccessException e) {
            throw new PicoCompositionException(e);
        } catch (InstantiationException e2) {
            throw new PicoCompositionException(e2);
        }
    }
}
