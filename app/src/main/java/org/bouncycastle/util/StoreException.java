package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class StoreException extends RuntimeException {

    /* JADX INFO: renamed from: _e */
    private Throwable f4940_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f4940_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4940_e;
    }
}
