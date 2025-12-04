package cucumber.runtime.io;

import cucumber.runtime.ClassFinder;
import io.cucumber.core.model.Classpath;
import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class ResourceLoaderClassFinder implements ClassFinder {
    private final ClassLoader classLoader;
    private final ResourceLoader resourceLoader;

    public ResourceLoaderClassFinder(ResourceLoader resourceLoader, ClassLoader classLoader) {
        this.resourceLoader = resourceLoader;
        this.classLoader = classLoader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cucumber.runtime.ClassFinder
    public <T> Collection<Class<? extends T>> getDescendants(Class<T> cls, URI uri) {
        HashSet hashSet = new HashSet();
        Iterator<Resource> it = this.resourceLoader.resources(uri, ".class").iterator();
        while (it.hasNext()) {
            try {
                Class<? extends T> clsLoadClass = loadClass(getClassName(it.next().getPath()));
                if (clsLoadClass != null && !cls.equals(clsLoadClass) && cls.isAssignableFrom(clsLoadClass)) {
                    hashSet.add(clsLoadClass.asSubclass(cls));
                }
            } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            }
        }
        return hashSet;
    }

    private static String getClassName(URI uri) {
        return Classpath.resourceName(uri).substring(0, r2.length() - 6).replace('/', '.');
    }

    @Override // cucumber.runtime.ClassFinder
    public <T> Class<? extends T> loadClass(String str) throws ClassNotFoundException {
        return (Class<? extends T>) this.classLoader.loadClass(str);
    }
}
