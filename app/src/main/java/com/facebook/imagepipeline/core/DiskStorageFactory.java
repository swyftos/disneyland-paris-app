package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1836d2 = {"Lcom/facebook/imagepipeline/core/DiskStorageFactory;", "", "get", "Lcom/facebook/cache/disk/DiskStorage;", "diskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "imagepipeline_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface DiskStorageFactory {
    @NotNull
    DiskStorage get(@NotNull DiskCacheConfig diskCacheConfig);
}
