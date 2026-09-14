package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class LongConverter implements Converter {
    LongConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Long convert(String str) {
        return Long.valueOf(str);
    }
}
