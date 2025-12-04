package org.picocontainer.converters;

/* loaded from: classes6.dex */
class DoubleConverter implements Converter {
    DoubleConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Double convert(String str) {
        return Double.valueOf(str);
    }
}
