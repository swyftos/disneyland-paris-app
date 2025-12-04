package androidx.camera.core;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class InitializationException extends Exception {
    public InitializationException(@Nullable String str) {
        super(str);
    }

    public InitializationException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public InitializationException(@Nullable Throwable th) {
        super(th);
    }
}
