package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes4.dex */
@GwtCompatible
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i) throws Exception;
}
