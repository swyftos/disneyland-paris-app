package cucumber.runtime.io;

import java.net.URI;
import java.util.Iterator;

/* loaded from: classes5.dex */
public interface ResourceIteratorFactory {
    Iterator<Resource> createIterator(URI uri, String str, String str2);

    boolean isFactoryFor(URI uri);
}
