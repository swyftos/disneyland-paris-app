package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes4.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
