package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SynchronousExecutor implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
