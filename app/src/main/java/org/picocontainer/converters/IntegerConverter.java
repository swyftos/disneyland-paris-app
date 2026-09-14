package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class IntegerConverter implements Converter {
    IntegerConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Integer convert(String str) {
        return Integer.valueOf(str);
    }
}
