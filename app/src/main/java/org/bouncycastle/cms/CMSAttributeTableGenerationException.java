package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes6.dex */
public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* JADX INFO: renamed from: e */
    Exception f4126e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f4126e = exc;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException, java.lang.Throwable
    public Throwable getCause() {
        return this.f4126e;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException
    public Exception getUnderlyingException() {
        return this.f4126e;
    }
}
