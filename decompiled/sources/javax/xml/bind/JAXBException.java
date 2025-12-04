package javax.xml.bind;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes5.dex */
public class JAXBException extends Exception {
    static final long serialVersionUID = -5621384651494307979L;
    private String errorCode;
    private volatile Throwable linkedException;

    public JAXBException(String str) {
        this(str, null, null);
    }

    public JAXBException(String str, String str2) {
        this(str, str2, null);
    }

    public JAXBException(Throwable th) {
        this(null, null, th);
    }

    public JAXBException(String str, Throwable th) {
        this(str, null, th);
    }

    public JAXBException(String str, String str2, Throwable th) {
        super(str);
        this.errorCode = str2;
        this.linkedException = th;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Throwable getLinkedException() {
        return this.linkedException;
    }

    public void setLinkedException(Throwable th) {
        this.linkedException = th;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.linkedException == null) {
            return super.toString();
        }
        return super.toString() + "\n - with linked exception:\n[" + this.linkedException.toString() + "]";
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.linkedException;
    }
}
