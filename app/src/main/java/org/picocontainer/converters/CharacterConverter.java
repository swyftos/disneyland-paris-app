package org.picocontainer.converters;

/* JADX INFO: loaded from: classes5.dex */
class CharacterConverter implements Converter {
    CharacterConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public Character convert(String str) {
        return Character.valueOf(str.charAt(0));
    }
}
