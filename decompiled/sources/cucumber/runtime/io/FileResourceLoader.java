package cucumber.runtime.io;

import java.io.File;
import java.net.URI;

/* loaded from: classes5.dex */
class FileResourceLoader implements ResourceLoader {
    FileResourceLoader() {
    }

    @Override // cucumber.runtime.io.ResourceLoader
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
