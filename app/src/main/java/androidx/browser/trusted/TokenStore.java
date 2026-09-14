package androidx.browser.trusted;

import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public interface TokenStore {
    @Nullable
    @BinderThread
    Token load();

    @WorkerThread
    void store(@Nullable Token token);
}
