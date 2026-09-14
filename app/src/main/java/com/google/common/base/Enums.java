package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
@J2ktIncompatible
@GwtIncompatible
public final class Enums {
    private static final Map enumConstantCache = new WeakHashMap();

    @GwtIncompatible
    public static Field getField(Enum<?> r1) {
        try {
            return r1.getDeclaringClass().getDeclaredField(r1.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        return Platform.getEnumIfPresent(cls, str);
    }

    private static Map populateCache(Class cls) {
        HashMap map = new HashMap();
        for (Enum r2 : EnumSet.allOf(cls)) {
            map.put(r2.name(), new WeakReference(r2));
        }
        enumConstantCache.put(cls, map);
        return map;
    }

    static Map getEnumConstants(Class cls) {
        Map mapPopulateCache;
        Map map = enumConstantCache;
        synchronized (map) {
            try {
                mapPopulateCache = (Map) map.get(cls);
                if (mapPopulateCache == null) {
                    mapPopulateCache = populateCache(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mapPopulateCache;
    }

    @GwtIncompatible
    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new StringConverter(cls);
    }

    private static final class StringConverter extends Converter implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class enumClass;

        StringConverter(Class cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Enum doForward(String str) {
            return Enum.valueOf(this.enumClass, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Enum r1) {
            return r1.name();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) obj).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }
}
