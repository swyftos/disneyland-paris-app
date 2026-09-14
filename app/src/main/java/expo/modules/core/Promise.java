package expo.modules.core;

import expo.modules.core.interfaces.CodedThrowable;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "AsyncFunction will crash when called. Use expo.modules.kotlin.Promise instead")
public interface Promise {
    public static final String UNKNOWN_ERROR = "E_UNKNOWN_ERROR";

    void reject(String str, String str2, Throwable th);

    void resolve(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    default void reject(Throwable th) {
        if (th instanceof CodedThrowable) {
            CodedThrowable codedThrowable = (CodedThrowable) th;
            reject(codedThrowable.getCode(), codedThrowable.getMessage(), th);
        } else {
            reject(UNKNOWN_ERROR, th);
        }
    }

    default void reject(String str, String str2) {
        reject(str, str2, null);
    }

    default void reject(String str, Throwable th) {
        reject(str, th.getMessage(), th);
    }
}
