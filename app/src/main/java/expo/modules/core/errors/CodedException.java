package expo.modules.core.errors;

import expo.modules.core.interfaces.CodedThrowable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CodedException extends Exception implements CodedThrowable {
    public CodedException(String str) {
        super(str);
    }

    public CodedException(Throwable th) {
        super(th);
    }

    public CodedException(String str, Throwable th) {
        super(str, th);
    }

    @Override // expo.modules.core.interfaces.CodedThrowable
    public String getCode() {
        return "ERR_UNSPECIFIED_ANDROID_EXCEPTION";
    }
}
