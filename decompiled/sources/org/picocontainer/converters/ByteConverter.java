package org.picocontainer.converters;

/* loaded from: classes6.dex */
class ByteConverter implements Converter {
    ByteConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Byte convert(String str) {
        return Byte.valueOf(str);
    }
}
