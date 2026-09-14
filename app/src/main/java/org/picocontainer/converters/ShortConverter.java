package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class ShortConverter implements Converter {
    ShortConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Short convert(String str) {
        return Short.valueOf(str);
    }
}
