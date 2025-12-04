package javax.xml.bind;

import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.beans.Introspector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* loaded from: classes5.dex */
public final class JAXB {
    private static volatile WeakReference cache;

    private static final class Cache {
        final JAXBContext context;
        final Class type;

        public Cache(Class cls) {
            this.type = cls;
            this.context = JAXBContext.newInstance((Class<?>[]) new Class[]{cls});
        }
    }

    private static JAXBContext getContext(Class cls) {
        Cache cache2;
        WeakReference weakReference = cache;
        if (weakReference != null && (cache2 = (Cache) weakReference.get()) != null && cache2.type == cls) {
            return cache2.context;
        }
        Cache cache3 = new Cache(cls);
        cache = new WeakReference(cache3);
        return cache3.context;
    }

    public static <T> T unmarshal(File file, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(new StreamSource(file), cls).getValue();
        } catch (JAXBException e) {
            throw new DataBindingException(e);
        }
    }

    public static <T> T unmarshal(URL url, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(url), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(URI uri, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(uri), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(String str, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(str), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(InputStream inputStream, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(inputStream), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(Reader reader, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(reader), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    public static <T> T unmarshal(Source source, Class<T> cls) {
        try {
            return getContext(cls).createUnmarshaller().unmarshal(toSource(source), cls).getValue();
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    private static Source toSource(Object obj) throws MalformedURLException {
        Object file;
        if (obj == null) {
            throw new IllegalArgumentException("no XML is given");
        }
        if (obj instanceof String) {
            try {
                file = new URI((String) obj);
            } catch (URISyntaxException unused) {
                file = new File((String) obj);
            }
            obj = file;
        }
        if (obj instanceof File) {
            return new StreamSource((File) obj);
        }
        if (obj instanceof URI) {
            obj = ((URI) obj).toURL();
        }
        if (obj instanceof URL) {
            return new StreamSource(((URL) obj).toExternalForm());
        }
        if (obj instanceof InputStream) {
            return new StreamSource((InputStream) obj);
        }
        if (obj instanceof Reader) {
            return new StreamSource((Reader) obj);
        }
        if (obj instanceof Source) {
            return (Source) obj;
        }
        throw new IllegalArgumentException("I don't understand how to handle " + obj.getClass());
    }

    public static void marshal(Object obj, File file) {
        _marshal(obj, file);
    }

    public static void marshal(Object obj, URL url) {
        _marshal(obj, url);
    }

    public static void marshal(Object obj, URI uri) {
        _marshal(obj, uri);
    }

    public static void marshal(Object obj, String str) {
        _marshal(obj, str);
    }

    public static void marshal(Object obj, OutputStream outputStream) {
        _marshal(obj, outputStream);
    }

    public static void marshal(Object obj, Writer writer) {
        _marshal(obj, writer);
    }

    public static void marshal(Object obj, Result result) {
        _marshal(obj, result);
    }

    private static void _marshal(Object obj, Object obj2) {
        JAXBContext context;
        try {
            if (obj instanceof JAXBElement) {
                context = getContext(((JAXBElement) obj).getDeclaredType());
            } else {
                Class<?> cls = obj.getClass();
                XmlRootElement xmlRootElement = (XmlRootElement) cls.getAnnotation(XmlRootElement.class);
                JAXBContext context2 = getContext(cls);
                if (xmlRootElement == null) {
                    obj = new JAXBElement(new QName(inferName(cls)), cls, obj);
                }
                context = context2;
            }
            Marshaller marshallerCreateMarshaller = context.createMarshaller();
            marshallerCreateMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshallerCreateMarshaller.marshal(obj, toResult(obj2));
        } catch (IOException e) {
            throw new DataBindingException(e);
        } catch (JAXBException e2) {
            throw new DataBindingException(e2);
        }
    }

    private static String inferName(Class cls) {
        return Introspector.decapitalize(cls.getSimpleName());
    }

    private static Result toResult(Object obj) throws IOException {
        Object file;
        if (obj == null) {
            throw new IllegalArgumentException("no XML is given");
        }
        if (obj instanceof String) {
            try {
                file = new URI((String) obj);
            } catch (URISyntaxException unused) {
                file = new File((String) obj);
            }
            obj = file;
        }
        if (obj instanceof File) {
            return new StreamResult((File) obj);
        }
        if (obj instanceof URI) {
            obj = ((URI) obj).toURL();
        }
        if (obj instanceof URL) {
            URLConnection uRLConnectionOpenConnection = ((URL) obj).openConnection();
            uRLConnectionOpenConnection.setDoOutput(true);
            uRLConnectionOpenConnection.setDoInput(false);
            InstrumentationCallbacks.requestAboutToBeSent(uRLConnectionOpenConnection);
            try {
                uRLConnectionOpenConnection.connect();
                InstrumentationCallbacks.requestSent(uRLConnectionOpenConnection);
                InstrumentationCallbacks.requestAboutToBeSent(uRLConnectionOpenConnection);
                try {
                    OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
                    InstrumentationCallbacks.requestSent(uRLConnectionOpenConnection);
                    return new StreamResult(outputStream);
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(uRLConnectionOpenConnection, e);
                    throw e;
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(uRLConnectionOpenConnection, e2);
                throw e2;
            }
        }
        if (obj instanceof OutputStream) {
            return new StreamResult((OutputStream) obj);
        }
        if (obj instanceof Writer) {
            return new StreamResult((Writer) obj);
        }
        if (obj instanceof Result) {
            return (Result) obj;
        }
        throw new IllegalArgumentException("I don't understand how to handle " + obj.getClass());
    }
}
