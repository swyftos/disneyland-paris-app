package cucumber.runtime.io;

import io.cucumber.core.model.Classpath;
import java.net.URI;

/* loaded from: classes5.dex */
public class MultiLoader implements ResourceLoader {
    private final ClasspathResourceLoader classpath;
    private final FileResourceLoader fs = new FileResourceLoader();

    public MultiLoader(ClassLoader classLoader) {
        this.classpath = new ClasspathResourceLoader(classLoader);
    }

    @Override // cucumber.runtime.io.ResourceLoader
    public Iterable<Resource> resources(URI uri, String str) {
        if (Classpath.CLASSPATH_SCHEME.equals(uri.getScheme())) {
            return this.classpath.resources(uri, str);
        }
        if ("file".equals(uri.getScheme())) {
            return this.fs.resources(uri, str);
        }
        throw new IllegalArgumentException("Unsupported scheme: " + uri);
    }
}
