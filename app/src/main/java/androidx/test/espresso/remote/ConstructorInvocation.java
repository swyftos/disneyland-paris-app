package androidx.test.espresso.remote;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.cache.Cache;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.internal.util.LogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class ConstructorInvocation {
    private static final Cache constructorCache = CacheBuilder.newBuilder().maximumSize(256).build();
    private final Class annotationClass;
    private final Class clazz;
    private final Class[] parameterTypes;

    public ConstructorInvocation(Class<?> cls, Class<? extends Annotation> cls2, Class<?>... clsArr) {
        this.clazz = (Class) Preconditions.checkNotNull(cls, "clazz cannot be null!");
        this.annotationClass = cls2;
        this.parameterTypes = clsArr;
    }

    public Object invokeConstructor(Object... objArr) {
        return invokeConstructorExplosively(objArr);
    }

    private static final class ConstructorKey {
        private final Class[] parameterTypes;
        private final Class type;

        public ConstructorKey(Class cls, Class[] clsArr) {
            this.type = cls;
            this.parameterTypes = clsArr;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + Arrays.hashCode(this.parameterTypes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ConstructorKey.class != obj.getClass()) {
                return false;
            }
            ConstructorKey constructorKey = (ConstructorKey) obj;
            if (this.type.equals(constructorKey.type)) {
                return Arrays.equals(this.parameterTypes, constructorKey.parameterTypes);
            }
            return false;
        }
    }

    private Object invokeConstructorExplosively(Object... objArr) {
        ConstructorKey constructorKey = new ConstructorKey(this.clazz, this.parameterTypes);
        Constructor<?> constructor = null;
        try {
            try {
                try {
                    Constructor<?> constructor2 = (Constructor) constructorCache.getIfPresent(constructorKey);
                    try {
                        if (constructor2 == null) {
                            LogUtil.logDebug("ConstructorInvocation", "Cache miss for constructor: %s(%s). Loading into cache.", this.clazz.getSimpleName(), Arrays.toString(objArr));
                            if (this.annotationClass != null) {
                                for (Constructor<?> constructor3 : this.clazz.getDeclaredConstructors()) {
                                    if (constructor3.isAnnotationPresent(this.annotationClass)) {
                                        constructor2 = constructor3;
                                        break;
                                    }
                                }
                            }
                            if (constructor2 == null) {
                                constructor2 = this.clazz.getConstructor(this.parameterTypes);
                            }
                            Preconditions.checkState(constructor2 != null, "No constructor found for annotation: %s, or parameter types: %s", this.annotationClass, Arrays.asList(this.parameterTypes));
                            constructorCache.put(constructorKey, constructor2);
                        } else {
                            LogUtil.logDebug("ConstructorInvocation", "Cache hit for constructor: %s(%s).", this.clazz.getSimpleName(), Arrays.toString(objArr));
                        }
                        constructor2.setAccessible(true);
                        Object objNewInstance = constructor2.newInstance(objArr);
                        LogUtil.logDebug("ConstructorInvocation", "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(objArr));
                        return objNewInstance;
                    } catch (SecurityException e) {
                        e = e;
                        constructor = constructor2;
                        throw new RemoteProtocolException(String.format(Locale.ROOT, "Constructor not accessible: %s", constructor.getName()), e);
                    } catch (InvocationTargetException e2) {
                        e = e2;
                        constructor = constructor2;
                        throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot invoke constructor %s with constructorParams [%s] on clazz %s", constructor, Arrays.toString(objArr), this.clazz.getName()), e);
                    }
                } catch (IllegalAccessException e3) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e3);
                } catch (InstantiationException e4) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e4);
                } catch (NoSuchMethodException e5) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "No constructor found for clazz: %s. Available constructors: %s", this.clazz.getName(), Arrays.asList(this.clazz.getConstructors())), e5);
                }
            } catch (SecurityException e6) {
                e = e6;
            } catch (InvocationTargetException e7) {
                e = e7;
            }
        } catch (Throwable th) {
            LogUtil.logDebug("ConstructorInvocation", "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(objArr));
            throw th;
        }
    }
}
