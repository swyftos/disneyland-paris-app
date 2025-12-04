package javax.xml.bind;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class JAXBContext {
    public static final String JAXB_CONTEXT_FACTORY = "javax.xml.bind.JAXBContextFactory";

    public abstract Marshaller createMarshaller() throws JAXBException;

    public abstract Unmarshaller createUnmarshaller() throws JAXBException;

    @Deprecated
    public abstract Validator createValidator() throws JAXBException;

    protected JAXBContext() {
    }

    public static JAXBContext newInstance(String str) throws JAXBException {
        return newInstance(str, getContextClassLoader());
    }

    public static JAXBContext newInstance(String str, ClassLoader classLoader) throws JAXBException {
        return newInstance(str, classLoader, Collections.emptyMap());
    }

    public static JAXBContext newInstance(String str, ClassLoader classLoader, Map<String, ?> map) throws JAXBException {
        return ContextFinder.find(JAXB_CONTEXT_FACTORY, str, classLoader, map);
    }

    public static JAXBContext newInstance(Class<?>... clsArr) throws JAXBException {
        return newInstance(clsArr, (Map<String, ?>) Collections.emptyMap());
    }

    public static JAXBContext newInstance(Class<?>[] clsArr, Map<String, ?> map) throws JAXBException {
        if (clsArr == null) {
            throw new IllegalArgumentException();
        }
        for (int length = clsArr.length - 1; length >= 0; length--) {
            if (clsArr[length] == null) {
                throw new IllegalArgumentException();
            }
        }
        return ContextFinder.find(clsArr, map);
    }

    public <T> Binder<T> createBinder(Class<T> cls) {
        throw new UnsupportedOperationException();
    }

    public Binder<Node> createBinder() {
        return createBinder(Node.class);
    }

    public JAXBIntrospector createJAXBIntrospector() {
        throw new UnsupportedOperationException();
    }

    public void generateSchema(SchemaOutputResolver schemaOutputResolver) throws IOException {
        throw new UnsupportedOperationException();
    }

    private static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.xml.bind.JAXBContext.1
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }
}
