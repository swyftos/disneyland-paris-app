package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
