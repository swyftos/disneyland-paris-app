package javax.xml.bind;

/* loaded from: classes5.dex */
public class ValidationException extends JAXBException {
    public ValidationException(String str) {
        this(str, null, null);
    }

    public ValidationException(String str, String str2) {
        this(str, str2, null);
    }

    public ValidationException(Throwable th) {
        this(null, null, th);
    }

    public ValidationException(String str, Throwable th) {
        this(str, null, th);
    }

    public ValidationException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
