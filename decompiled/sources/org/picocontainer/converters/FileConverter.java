package org.picocontainer.converters;

import java.io.File;

/* loaded from: classes6.dex */
class FileConverter implements Converter {
    FileConverter() {
    }

    @Override // org.picocontainer.converters.Converter
    public File convert(String str) {
        return new File(str);
    }
}
