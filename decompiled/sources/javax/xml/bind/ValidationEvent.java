package javax.xml.bind;

/* loaded from: classes5.dex */
public interface ValidationEvent {
    public static final int ERROR = 1;
    public static final int FATAL_ERROR = 2;
    public static final int WARNING = 0;

    Throwable getLinkedException();

    ValidationEventLocator getLocator();

    String getMessage();

    int getSeverity();
}
