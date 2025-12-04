package cucumber.runtime.io;

import cucumber.runtime.CucumberException;
import io.cucumber.core.model.Classpath;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes5.dex */
class ClasspathResourceIterable implements Iterable {
    private final ClassLoader classLoader;
    private final String path;
    private final ResourceIteratorFactory resourceIteratorFactory = new DelegatingResourceIteratorFactory(new ZipThenFileResourceIteratorFactory());
    private final String suffix;

    ClasspathResourceIterable(ClassLoader classLoader, URI uri, String str) {
        this.classLoader = classLoader;
        this.path = Classpath.resourceName(uri);
        this.suffix = str;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() throws IOException {
        try {
            FlatteningIterator flatteningIterator = new FlatteningIterator();
            Enumeration<URL> resources = this.classLoader.getResources(this.path);
            while (resources.hasMoreElements()) {
                flatteningIterator.push(this.resourceIteratorFactory.createIterator(resources.nextElement().toURI(), this.path, this.suffix));
            }
            return flatteningIterator;
        } catch (IOException | URISyntaxException e) {
            throw new CucumberException(e);
        }
    }
}
