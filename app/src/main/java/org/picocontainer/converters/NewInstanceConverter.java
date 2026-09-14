package org.picocontainer.converters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class NewInstanceConverter implements Converter<Object> {

    /* JADX INFO: renamed from: c */
    private Constructor f4946c;

    public NewInstanceConverter(Class<?> cls) {
        try {
            this.f4946c = cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    @Override // org.picocontainer.converters.Converter
    public Object convert(String str) {
        Constructor constructor = this.f4946c;
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
