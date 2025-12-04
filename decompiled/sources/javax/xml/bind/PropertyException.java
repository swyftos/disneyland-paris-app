package javax.xml.bind;

/* loaded from: classes5.dex */
public class PropertyException extends JAXBException {
    public PropertyException(String str) {
        super(str);
    }

    public PropertyException(String str, String str2) {
        super(str, str2);
    }

    public PropertyException(Throwable th) {
        super(th);
    }

    public PropertyException(String str, Throwable th) {
        super(str, th);
    }

    public PropertyException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public PropertyException(String str, Object obj) {
        super(Messages.format("PropertyException.NameValue", str, obj.toString()));
    }
}
