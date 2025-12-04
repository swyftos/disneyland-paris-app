package javax.xml.bind;

/* loaded from: classes5.dex */
public class UnmarshalException extends JAXBException {
    public UnmarshalException(String str) {
        this(str, null, null);
    }

    public UnmarshalException(String str, String str2) {
        this(str, str2, null);
    }

    public UnmarshalException(Throwable th) {
        this(null, null, th);
    }

    public UnmarshalException(String str, Throwable th) {
        this(str, null, th);
    }

    public UnmarshalException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
