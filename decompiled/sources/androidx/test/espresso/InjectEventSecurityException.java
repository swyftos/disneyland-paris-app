package androidx.test.espresso;

import androidx.test.internal.platform.util.TestOutputEmitter;

/* loaded from: classes2.dex */
public final class InjectEventSecurityException extends androidx.test.platform.ui.InjectEventSecurityException implements EspressoException {
    public InjectEventSecurityException(String str) {
        super(str);
        dumpThreads();
    }

    private void dumpThreads() {
        TestOutputEmitter.dumpThreadStates("ThreadState-InjectEventSecurityException.txt");
    }

    public InjectEventSecurityException(String str, Throwable th) {
        super(str, th);
        dumpThreads();
    }

    public InjectEventSecurityException(Throwable th) {
        super(th);
        dumpThreads();
    }
}
