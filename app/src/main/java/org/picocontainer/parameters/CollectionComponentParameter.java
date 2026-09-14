package org.picocontainer.parameters;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* JADX INFO: loaded from: classes5.dex */
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
    public void verify(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
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
    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    public Collection getCollectionInstance(PicoContainer picoContainer, Class cls, Map map, NameBinding nameBinding, boolean z) {
        if (cls.isInterface()) {
            if (List.class.isAssignableFrom(cls)) {
                cls = ArrayList.class;
            } else if (SortedSet.class.isAssignableFrom(cls)) {
                cls = TreeSet.class;
            } else if (Set.class.isAssignableFrom(cls)) {
                cls = HashSet.class;
            } else if (Collection.class.isAssignableFrom(cls)) {
                cls = ArrayList.class;
            }
        }
        try {
            Collection collection = (Collection) cls.newInstance();
            for (ComponentAdapter componentAdapter : map.values()) {
                if (!z || componentAdapter.getComponentKey() == nameBinding) {
                    collection.add(picoContainer.getComponent(componentAdapter.getComponentKey()));
                }
            }
            return collection;
        } catch (IllegalAccessException e) {
            throw new PicoCompositionException(e);
        } catch (InstantiationException e2) {
            throw new PicoCompositionException(e2);
        }
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
