package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class FloatConverter implements Converter {
    FloatConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Float convert(String str) {
        return Float.valueOf(str);
    }
}
