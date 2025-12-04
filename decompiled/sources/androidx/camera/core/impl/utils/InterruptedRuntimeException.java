package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class InterruptedRuntimeException extends RuntimeException {
    public InterruptedRuntimeException() {
    }

    public InterruptedRuntimeException(@NonNull String str) {
        super(str);
    }

    public InterruptedRuntimeException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }

    public InterruptedRuntimeException(@NonNull Throwable th) {
        super(th);
    }
}
