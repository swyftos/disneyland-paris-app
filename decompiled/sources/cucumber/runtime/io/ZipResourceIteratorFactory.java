package cucumber.runtime.io;

import cucumber.runtime.CucumberException;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;

/* loaded from: classes5.dex */
class ZipResourceIteratorFactory implements ResourceIteratorFactory {
    ZipResourceIteratorFactory() {
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public boolean isFactoryFor(URI uri) {
        return uri.getSchemeSpecificPart().contains("!/");
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public Iterator createIterator(URI uri, String str, String str2) {
        try {
            return new ZipResourceIterator(Helpers.jarFilePath(uri), str, str2);
        } catch (IOException e) {
            throw new CucumberException(e);
        }
    }
}
