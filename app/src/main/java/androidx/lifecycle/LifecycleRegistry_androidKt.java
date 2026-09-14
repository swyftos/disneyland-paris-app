package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001¨\u0006\u0002"}, m1836d2 = {"isMainThread", "", "lifecycle-runtime_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class LifecycleRegistry_androidKt {
    @SuppressLint({"RestrictedApi"})
    public static final boolean isMainThread() {
        return ArchTaskExecutor.getInstance().isMainThread();
    }
}
