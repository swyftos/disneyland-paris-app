package gherkin.deps.com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public abstract class UnsafeAllocator {
    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    public static UnsafeAllocator create() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls.getMethod("allocateInstance", Class.class);
                    return new UnsafeAllocator() { // from class: gherkin.deps.com.google.gson.internal.UnsafeAllocator.1
                        @Override // gherkin.deps.com.google.gson.internal.UnsafeAllocator
                        public Object newInstance(Class cls2) {
                            return method.invoke(obj, cls2);
                        }
                    };
                } catch (Exception unused) {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: gherkin.deps.com.google.gson.internal.UnsafeAllocator.2
                        @Override // gherkin.deps.com.google.gson.internal.UnsafeAllocator
                        public Object newInstance(Class cls2) {
                            return declaredMethod2.invoke(null, cls2, Integer.valueOf(iIntValue));
                        }
                    };
                }
            } catch (Exception unused2) {
                final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new UnsafeAllocator() { // from class: gherkin.deps.com.google.gson.internal.UnsafeAllocator.3
                    @Override // gherkin.deps.com.google.gson.internal.UnsafeAllocator
                    public Object newInstance(Class cls2) {
                        return declaredMethod3.invoke(null, cls2, Object.class);
                    }
                };
            }
        } catch (Exception unused3) {
            return new UnsafeAllocator() { // from class: gherkin.deps.com.google.gson.internal.UnsafeAllocator.4
                @Override // gherkin.deps.com.google.gson.internal.UnsafeAllocator
                public Object newInstance(Class cls2) {
                    throw new UnsupportedOperationException("Cannot allocate " + cls2);
                }
            };
        }
    }
}
