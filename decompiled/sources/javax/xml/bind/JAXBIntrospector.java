package javax.xml.bind;

import javax.xml.namespace.QName;

/* loaded from: classes5.dex */
public abstract class JAXBIntrospector {
    public abstract QName getElementName(Object obj);

    public abstract boolean isElement(Object obj);

    public static Object getValue(Object obj) {
        return obj instanceof JAXBElement ? ((JAXBElement) obj).getValue() : obj;
    }
}
