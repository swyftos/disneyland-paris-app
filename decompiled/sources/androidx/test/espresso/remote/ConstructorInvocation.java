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

/* loaded from: classes2.dex */
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
        Constructor<?> constructor;
        ConstructorKey constructorKey = new ConstructorKey(this.clazz, this.parameterTypes);
        Constructor<?> constructor2 = null;
        try {
            try {
                try {
                    constructor = (Constructor) constructorCache.getIfPresent(constructorKey);
                } catch (IllegalAccessException e) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e);
                } catch (InstantiationException e2) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot create instance of %s", this.clazz.getName()), e2);
                } catch (NoSuchMethodException e3) {
                    throw new RemoteProtocolException(String.format(Locale.ROOT, "No constructor found for clazz: %s. Available constructors: %s", this.clazz.getName(), Arrays.asList(this.clazz.getConstructors())), e3);
                }
            } catch (SecurityException e4) {
                e = e4;
            } catch (InvocationTargetException e5) {
                e = e5;
            }
            try {
                if (constructor == null) {
                    LogUtil.logDebug("ConstructorInvocation", "Cache miss for constructor: %s(%s). Loading into cache.", this.clazz.getSimpleName(), Arrays.toString(objArr));
                    if (this.annotationClass != null) {
                        Constructor<?>[] declaredConstructors = this.clazz.getDeclaredConstructors();
                        int length = declaredConstructors.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Constructor<?> constructor3 = declaredConstructors[i];
                            if (constructor3.isAnnotationPresent(this.annotationClass)) {
                                constructor = constructor3;
                                break;
                            }
                            i++;
                        }
                    }
                    if (constructor == null) {
                        constructor = this.clazz.getConstructor(this.parameterTypes);
                    }
                    Preconditions.checkState(constructor != null, "No constructor found for annotation: %s, or parameter types: %s", this.annotationClass, Arrays.asList(this.parameterTypes));
                    constructorCache.put(constructorKey, constructor);
                } else {
                    LogUtil.logDebug("ConstructorInvocation", "Cache hit for constructor: %s(%s).", this.clazz.getSimpleName(), Arrays.toString(objArr));
                }
                constructor.setAccessible(true);
                Object objNewInstance = constructor.newInstance(objArr);
                LogUtil.logDebug("ConstructorInvocation", "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(objArr));
                return objNewInstance;
            } catch (SecurityException e6) {
                e = e6;
                constructor2 = constructor;
                throw new RemoteProtocolException(String.format(Locale.ROOT, "Constructor not accessible: %s", constructor2.getName()), e);
            } catch (InvocationTargetException e7) {
                e = e7;
                constructor2 = constructor;
                throw new RemoteProtocolException(String.format(Locale.ROOT, "Cannot invoke constructor %s with constructorParams [%s] on clazz %s", constructor2, Arrays.toString(objArr), this.clazz.getName()), e);
            }
        } catch (Throwable th) {
            LogUtil.logDebug("ConstructorInvocation", "%s(%s)", this.clazz.getSimpleName(), Arrays.toString(objArr));
            throw th;
        }
    }
}
