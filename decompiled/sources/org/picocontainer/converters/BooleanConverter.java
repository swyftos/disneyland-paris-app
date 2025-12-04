package org.picocontainer.converters;

/* loaded from: classes6.dex */
class BooleanConverter implements Converter {
    BooleanConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Boolean convert(String str) {
        return Boolean.valueOf(str);
    }
}
