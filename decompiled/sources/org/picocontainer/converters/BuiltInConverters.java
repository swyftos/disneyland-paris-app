package org.picocontainer.converters;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.picocontainer.Converters;

/* loaded from: classes6.dex */
public class BuiltInConverters implements Converters, Serializable {
    private final Map converters = new HashMap();

    public BuiltInConverters() {
        addBuiltInConverters();
    }

    protected void addBuiltInConverters() {
        addMultiTypeConverter(new IntegerConverter(), Integer.class, Integer.TYPE);
        addMultiTypeConverter(new DoubleConverter(), Double.class, Double.TYPE);
        addMultiTypeConverter(new BooleanConverter(), Boolean.class, Boolean.TYPE);
        addMultiTypeConverter(new LongConverter(), Long.class, Long.TYPE);
        addMultiTypeConverter(new FloatConverter(), Float.class, Float.TYPE);
        addMultiTypeConverter(new CharacterConverter(), Character.class, Character.TYPE);
        addMultiTypeConverter(new ByteConverter(), Byte.class, Byte.TYPE);
        addMultiTypeConverter(new ShortConverter(), Short.class, Short.TYPE);
        addConverter(new FileConverter(), File.class);
        addConverter(new UrlConverter(), URL.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addMultiTypeConverter(Converter converter, Class... clsArr) {
        for (Class cls : clsArr) {
            addConverter(converter, cls);
        }
    }

    protected void addConverter(Converter<?> converter, Class<?> cls) {
        this.converters.put(cls, converter);
    }

    @Override // org.picocontainer.Converters
    public boolean canConvert(Type type) {
        return this.converters.containsKey(type);
    }

    @Override // org.picocontainer.Converters
    public Object convert(String str, Type type) {
        Converter converter = (Converter) this.converters.get(type);
        if (converter == null) {
            return null;
        }
        return converter.convert(str);
    }
}
