package cucumber.runtime.p101io;

import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public class ClasspathResourceLoader implements ResourceLoader {
    private final ClassLoader classLoader;

    public ClasspathResourceLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override // cucumber.runtime.p101io.ResourceLoader
    public Iterable<Resource> resources(URI uri, String str) {
        return new ClasspathResourceIterable(this.classLoader, uri, str);
    }
}
