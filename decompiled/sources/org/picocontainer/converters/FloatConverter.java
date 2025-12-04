package org.picocontainer.converters;

/* loaded from: classes6.dex */
class FloatConverter implements Converter {
    FloatConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Float convert(String str) {
        return Float.valueOf(str);
    }
}
