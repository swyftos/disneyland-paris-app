package cucumber.runtime.io;

import io.cucumber.core.model.Classpath;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
class ZipResource implements Resource {
    private final ZipEntry jarEntry;
    private final ZipFile jarFile;

    ZipResource(ZipFile zipFile, ZipEntry zipEntry) {
        this.jarFile = zipFile;
        this.jarEntry = zipEntry;
    }

    @Override // cucumber.runtime.io.Resource
    public URI getPath() {
        try {
            return new URI(Classpath.CLASSPATH_SCHEME, this.jarEntry.getName(), null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // cucumber.runtime.io.Resource
    public InputStream getInputStream() {
        return this.jarFile.getInputStream(this.jarEntry);
    }
}
