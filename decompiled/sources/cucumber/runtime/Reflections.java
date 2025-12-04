package cucumber.runtime;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Reflections {
    private final ClassFinder classFinder;

    public Reflections(ClassFinder classFinder) {
        this.classFinder = classFinder;
    }

    public <T> T instantiateExactlyOneSubclass(Class<T> cls, List<URI> list, Class[] clsArr, Object[] objArr, T t) {
        Collection<? extends T> collectionInstantiateSubclasses = instantiateSubclasses(cls, list, clsArr, objArr);
        if (collectionInstantiateSubclasses.size() == 1) {
            return collectionInstantiateSubclasses.iterator().next();
        }
        if (!collectionInstantiateSubclasses.isEmpty()) {
            throw new TooManyInstancesException(collectionInstantiateSubclasses);
        }
        if (t != null) {
            return t;
        }
        throw new NoInstancesException(cls);
    }

    public <T> Collection<? extends T> instantiateSubclasses(Class<T> cls, List<URI> list, Class[] clsArr, Object[] objArr) {
        HashSet hashSet = new HashSet();
        Iterator<URI> it = list.iterator();
        while (it.hasNext()) {
            for (Class<? extends T> cls2 : this.classFinder.getDescendants(cls, it.next())) {
                if (Utils.isInstantiable(cls2)) {
                    hashSet.add(newInstance(clsArr, objArr, cls2));
                }
            }
        }
        return hashSet;
    }

    public <T> T newInstance(Class[] clsArr, Object[] objArr, Class<? extends T> cls) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<? extends T> constructor = cls.getConstructor(clsArr);
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                throw new CucumberException(String.format("Failed to instantiate %s with %s", constructor.toGenericString(), Arrays.asList(objArr)), e);
            }
        } catch (NoSuchMethodException e2) {
            throw new CucumberException(e2);
        }
    }
}
