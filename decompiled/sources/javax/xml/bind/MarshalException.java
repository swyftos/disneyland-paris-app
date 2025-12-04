package javax.xml.bind;

/* loaded from: classes5.dex */
public class MarshalException extends JAXBException {
    public MarshalException(String str) {
        this(str, null, null);
    }

    public MarshalException(String str, String str2) {
        this(str, str2, null);
    }

    public MarshalException(Throwable th) {
        this(null, null, th);
    }

    public MarshalException(String str, Throwable th) {
        this(str, null, th);
    }

    public MarshalException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
