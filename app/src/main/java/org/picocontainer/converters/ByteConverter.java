package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class ByteConverter implements Converter {
    ByteConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Byte convert(String str) {
        return Byte.valueOf(str);
    }
}
