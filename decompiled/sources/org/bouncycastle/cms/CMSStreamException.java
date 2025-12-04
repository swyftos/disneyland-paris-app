package org.bouncycastle.cms;

import java.io.IOException;

/* loaded from: classes6.dex */
public class CMSStreamException extends IOException {
    private final Throwable underlying;

    CMSStreamException(String str, Throwable th) {
        super(str);
        this.underlying = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlying;
    }
}
