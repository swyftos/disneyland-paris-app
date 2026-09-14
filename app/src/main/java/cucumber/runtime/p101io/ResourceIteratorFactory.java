package cucumber.runtime.p101io;

import java.net.URI;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public interface ResourceIteratorFactory {
    Iterator<Resource> createIterator(URI uri, String str, String str2);

    boolean isFactoryFor(URI uri);
}
