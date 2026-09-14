package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface ResourceReleaser<T> {
    void release(T t);
}
