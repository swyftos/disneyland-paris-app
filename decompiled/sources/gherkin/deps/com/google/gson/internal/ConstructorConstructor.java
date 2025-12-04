package gherkin.deps.com.google.gson.internal;

import gherkin.deps.com.google.gson.InstanceCreator;
import gherkin.deps.com.google.gson.JsonIOException;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes5.dex */
public final class ConstructorConstructor {
    private final Map instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) throws NoSuchMethodException, SecurityException {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator instanceCreator = (InstanceCreator) this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.1
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator instanceCreator2 = (InstanceCreator) this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.2
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return objectConstructorNewDefaultImplementationConstructor != null ? objectConstructorNewDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
    }

    private ObjectConstructor newDefaultConstructor(Class cls) throws NoSuchMethodException, SecurityException {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.3
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private ObjectConstructor newDefaultImplementationConstructor(final Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.4
                    @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.5
                    @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        Type type2 = type;
                        if (type2 instanceof ParameterizedType) {
                            Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof Class) {
                                return EnumSet.noneOf((Class) type3);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.6
                    @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.7
                    @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new LinkedList();
                    }
                };
            }
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.8
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.9
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return new TreeMap();
                }
            };
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.10
                @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return new LinkedHashMap();
                }
            };
        }
        return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.11
            @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
            public Object construct() {
                return new LinkedTreeMap();
            }
        };
    }

    private ObjectConstructor newUnsafeAllocator(final Type type, final Class cls) {
        return new ObjectConstructor() { // from class: gherkin.deps.com.google.gson.internal.ConstructorConstructor.12
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            @Override // gherkin.deps.com.google.gson.internal.ObjectConstructor
            public Object construct() {
                try {
                    return this.unsafeAllocator.newInstance(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
