package org.picocontainer.converters;

/* loaded from: classes6.dex */
class ShortConverter implements Converter {
    ShortConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Short convert(String str) {
        return Short.valueOf(str);
    }
}
