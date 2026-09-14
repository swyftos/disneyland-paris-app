package cucumber.runtime.p101io;

import java.io.File;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
class FileResourceLoader implements ResourceLoader {
    FileResourceLoader() {
    }

    @Override // cucumber.runtime.p101io.ResourceLoader
    public Iterable resources(URI uri, String str) {
        if (!"file".equals(uri.getScheme())) {
            throw new IllegalArgumentException("path must have file scheme " + uri);
        }
        File file = new File(uri.getSchemeSpecificPart());
        if (file.isAbsolute()) {
            return new FileResourceIterable(file, file, str);
        }
        return new FileResourceIterable(new File(""), file, str);
    }
}
