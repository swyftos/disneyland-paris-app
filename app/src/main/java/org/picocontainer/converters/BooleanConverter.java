package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class BooleanConverter implements Converter {
    BooleanConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Boolean convert(String str) {
        return Boolean.valueOf(str);
    }
}
