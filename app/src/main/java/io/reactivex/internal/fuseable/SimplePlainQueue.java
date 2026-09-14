package io.reactivex.internal.fuseable;

import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    T poll();
}
