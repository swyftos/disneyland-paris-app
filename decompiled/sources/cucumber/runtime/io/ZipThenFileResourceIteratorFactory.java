package cucumber.runtime.io;

import java.net.URI;
import java.util.Iterator;

/* loaded from: classes5.dex */
class ZipThenFileResourceIteratorFactory implements ResourceIteratorFactory {
    private final ResourceIteratorFactory zipResourceIteratorFactory = new ZipResourceIteratorFactory();
    private final ResourceIteratorFactory fileResourceIteratorFactory = new FileResourceIteratorFactory();

    ZipThenFileResourceIteratorFactory() {
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public boolean isFactoryFor(URI uri) {
        return this.zipResourceIteratorFactory.isFactoryFor(uri) || this.fileResourceIteratorFactory.isFactoryFor(uri);
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public Iterator createIterator(URI uri, String str, String str2) {
        if (this.zipResourceIteratorFactory.isFactoryFor(uri)) {
            return this.zipResourceIteratorFactory.createIterator(uri, str, str2);
        }
        return this.fileResourceIteratorFactory.createIterator(uri, str, str2);
    }
}
