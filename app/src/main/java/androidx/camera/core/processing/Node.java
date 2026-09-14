package androidx.camera.core.processing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface Node<I, O> {
    void release();

    @NonNull
    @MainThread
    O transform(@NonNull I i);
}
