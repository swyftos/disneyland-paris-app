package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes6.dex */
public class CMSException extends Exception {

    /* JADX INFO: renamed from: e */
    Exception f4127e;

    public CMSException(String str) {
        super(str);
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f4127e = exc;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4127e;
    }

    public Exception getUnderlyingException() {
        return this.f4127e;
    }
}
