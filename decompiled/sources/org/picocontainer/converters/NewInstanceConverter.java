package org.picocontainer.converters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
public class NewInstanceConverter implements Converter<Object> {
    private Constructor c;

    public NewInstanceConverter(Class<?> cls) {
        try {
            this.c = cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    @Override // org.picocontainer.converters.Converter
    public Object convert(String str) {
        Constructor constructor = this.c;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(str);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }
}
