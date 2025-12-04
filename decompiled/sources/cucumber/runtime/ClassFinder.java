package cucumber.runtime;

import java.net.URI;
import java.util.Collection;

/* loaded from: classes5.dex */
public interface ClassFinder {
    <T> Collection<Class<? extends T>> getDescendants(Class<T> cls, URI uri);

    <T> Class<? extends T> loadClass(String str) throws ClassNotFoundException;
}
