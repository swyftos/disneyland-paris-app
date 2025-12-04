package org.picocontainer.converters;

/* loaded from: classes6.dex */
class LongConverter implements Converter {
    LongConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Long convert(String str) {
        return Long.valueOf(str);
    }
}
