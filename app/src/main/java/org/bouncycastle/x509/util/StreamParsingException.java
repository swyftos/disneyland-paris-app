package org.bouncycastle.x509.util;

/* JADX INFO: loaded from: classes6.dex */
public class StreamParsingException extends Exception {

    /* JADX INFO: renamed from: _e */
    Throwable f4943_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f4943_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4943_e;
    }
}
