package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class StreamParsingException extends Exception {

    /* JADX INFO: renamed from: _e */
    Throwable f4941_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f4941_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4941_e;
    }
}
