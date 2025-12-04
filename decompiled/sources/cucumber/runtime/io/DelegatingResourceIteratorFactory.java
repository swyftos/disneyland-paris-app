package cucumber.runtime.io;

import cucumber.runtime.CucumberException;
import java.net.URI;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: classes5.dex */
class DelegatingResourceIteratorFactory implements ResourceIteratorFactory {
    private final Iterable delegates = ServiceLoader.load(ResourceIteratorFactory.class);
    private final ResourceIteratorFactory fallbackResourceIteratorFactory;

    DelegatingResourceIteratorFactory(ResourceIteratorFactory resourceIteratorFactory) {
        this.fallbackResourceIteratorFactory = resourceIteratorFactory;
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public boolean isFactoryFor(URI uri) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            if (((ResourceIteratorFactory) it.next()).isFactoryFor(uri)) {
                return true;
            }
        }
        return this.fallbackResourceIteratorFactory.isFactoryFor(uri);
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public Iterator createIterator(URI uri, String str, String str2) {
        for (ResourceIteratorFactory resourceIteratorFactory : this.delegates) {
            if (resourceIteratorFactory.isFactoryFor(uri)) {
                return resourceIteratorFactory.createIterator(uri, str, str2);
            }
        }
        if (this.fallbackResourceIteratorFactory.isFactoryFor(uri)) {
            return this.fallbackResourceIteratorFactory.createIterator(uri, str, str2);
        }
        throw new CucumberException("Fallback factory cannot handle URL: " + uri);
    }
}
