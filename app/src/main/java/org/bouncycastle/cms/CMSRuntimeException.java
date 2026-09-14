package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes6.dex */
public class CMSRuntimeException extends RuntimeException {

    /* JADX INFO: renamed from: e */
    Exception f4128e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f4128e = exc;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4128e;
    }

    public Exception getUnderlyingException() {
        return this.f4128e;
    }
}
