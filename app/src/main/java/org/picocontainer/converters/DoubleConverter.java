package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class DoubleConverter implements Converter {
    DoubleConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Double convert(String str) {
        return Double.valueOf(str);
    }
}
