package androidx.test.platform.ui;

import androidx.test.platform.TestFrameworkException;

/* loaded from: classes2.dex */
public class InjectEventSecurityException extends Exception implements TestFrameworkException {
    public InjectEventSecurityException(String str) {
        super(str);
    }

    public InjectEventSecurityException(Throwable th) {
        super(th);
    }

    public InjectEventSecurityException(String str, Throwable th) {
        super(str, th);
    }
}
