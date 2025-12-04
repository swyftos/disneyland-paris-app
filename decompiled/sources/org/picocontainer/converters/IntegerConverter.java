package org.picocontainer.converters;

/* loaded from: classes6.dex */
class IntegerConverter implements Converter {
    IntegerConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Integer convert(String str) {
        return Integer.valueOf(str);
    }
}
