package androidx.test.services.events;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class TestEventException extends Exception {
    public TestEventException(@NonNull String str) {
        super(str);
    }

    public TestEventException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }
}
