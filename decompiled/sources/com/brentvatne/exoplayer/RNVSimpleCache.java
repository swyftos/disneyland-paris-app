package com.brentvatne.exoplayer;

import android.content.Context;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/brentvatne/exoplayer/RNVSimpleCache;", "", "<init>", "()V", "simpleCache", "Landroidx/media3/datasource/cache/SimpleCache;", "setSimpleCache", "", "context", "Landroid/content/Context;", "cacheSize", "", "getCacheFactory", "Landroidx/media3/datasource/DataSource$Factory;", "factory", "Landroidx/media3/datasource/HttpDataSource$Factory;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RNVSimpleCache {

    @NotNull
    public static final RNVSimpleCache INSTANCE = new RNVSimpleCache();
    private static SimpleCache simpleCache;

    private RNVSimpleCache() {
    }

    public final void setSimpleCache(@NotNull Context context, int cacheSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (simpleCache != null || cacheSize <= 0) {
            return;
        }
        long j = 1024;
        simpleCache = new SimpleCache(new File(context.getCacheDir(), "RNVCache"), new LeastRecentlyUsedCacheEvictor(cacheSize * j * j), new StandaloneDatabaseProvider(context));
    }

    @NotNull
    public final DataSource.Factory getCacheFactory(@NotNull HttpDataSource.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (simpleCache == null) {
            return factory;
        }
        CacheDataSource.Factory factory2 = new CacheDataSource.Factory();
        SimpleCache simpleCache2 = simpleCache;
        Intrinsics.checkNotNull(simpleCache2);
        CacheDataSource.Factory upstreamDataSourceFactory = factory2.setCache(simpleCache2).setUpstreamDataSourceFactory(factory);
        Intrinsics.checkNotNullExpressionValue(upstreamDataSourceFactory, "setUpstreamDataSourceFactory(...)");
        return upstreamDataSourceFactory;
    }
}
