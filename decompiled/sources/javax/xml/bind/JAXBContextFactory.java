package javax.xml.bind;

import java.util.Map;

/* loaded from: classes5.dex */
public interface JAXBContextFactory {
    JAXBContext createContext(String str, ClassLoader classLoader, Map<String, ?> map) throws JAXBException;

    JAXBContext createContext(Class<?>[] clsArr, Map<String, ?> map) throws JAXBException;
}
