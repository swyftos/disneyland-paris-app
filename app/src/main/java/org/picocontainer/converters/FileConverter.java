package org.picocontainer.converters;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
class FileConverter implements Converter {
    FileConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public File convert(String str) {
        return new File(str);
    }
}
