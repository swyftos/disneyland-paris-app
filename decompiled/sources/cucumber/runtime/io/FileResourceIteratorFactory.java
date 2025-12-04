package cucumber.runtime.io;

import java.io.File;
import java.net.URI;
import java.util.Iterator;

/* loaded from: classes5.dex */
class FileResourceIteratorFactory implements ResourceIteratorFactory {
    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public boolean isFactoryFor(URI uri) {
        return true;
    }

    FileResourceIteratorFactory() {
    }

    @Override // cucumber.runtime.io.ResourceIteratorFactory
    public Iterator createIterator(URI uri, String str, String str2) {
        File file = new File(uri);
        return FileResourceIterator.createClasspathFileResourceIterator(new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - str.length())), file, str2);
    }
}
