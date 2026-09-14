package cucumber.runtime.p101io;

import io.cucumber.core.model.Classpath;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public class MultiLoader implements ResourceLoader {
    private final ClasspathResourceLoader classpath;

    /* JADX INFO: renamed from: fs */
    private final FileResourceLoader f3792fs = new FileResourceLoader();

    public MultiLoader(ClassLoader classLoader) {
        this.classpath = new ClasspathResourceLoader(classLoader);
    }

    @Override // cucumber.runtime.p101io.ResourceLoader
    public Iterable<Resource> resources(URI uri, String str) {
        if (Classpath.CLASSPATH_SCHEME.equals(uri.getScheme())) {
            return this.classpath.resources(uri, str);
        }
        if ("file".equals(uri.getScheme())) {
            return this.f3792fs.resources(uri, str);
        }
        throw new IllegalArgumentException("Unsupported scheme: " + uri);
    }
}
