package cucumber.runtime.io;

import java.net.URI;

/* loaded from: classes5.dex */
public class ClasspathResourceLoader implements ResourceLoader {
    private final ClassLoader classLoader;

    public ClasspathResourceLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override // cucumber.runtime.io.ResourceLoader
    public Iterable<Resource> resources(URI uri, String str) {
        return new ClasspathResourceIterable(this.classLoader, uri, str);
    }
}
