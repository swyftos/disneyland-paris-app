package javax.xml.bind;

import java.io.PrintStream;

/* loaded from: classes5.dex */
public class TypeConstraintException extends RuntimeException {
    static final long serialVersionUID = -3059799699420143848L;
    private String errorCode;
    private volatile Throwable linkedException;

    public TypeConstraintException(String str) {
        this(str, null, null);
    }

    public TypeConstraintException(String str, String str2) {
        this(str, str2, null);
    }

    public TypeConstraintException(Throwable th) {
        this(null, null, th);
    }

    public TypeConstraintException(String str, Throwable th) {
        this(str, null, th);
    }

    public TypeConstraintException(String str, String str2, Throwable th) {
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
        if (this.linkedException != null) {
            this.linkedException.printStackTrace(printStream);
            printStream.println("--------------- linked to ------------------");
        }
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }
}
