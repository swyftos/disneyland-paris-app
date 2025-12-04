package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0002\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005R\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000bR'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"com/facebook/imagepipeline/core/DiskCachesStoreFactory$diskCachesStore$2$1", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "mainFileCache", "Lcom/facebook/cache/disk/FileCache;", "getMainFileCache", "()Lcom/facebook/cache/disk/FileCache;", "mainFileCache$delegate", "Lkotlin/Lazy;", "mainBufferedDiskCache", "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "getMainBufferedDiskCache", "()Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "mainBufferedDiskCache$delegate", "smallImageFileCache", "getSmallImageFileCache", "smallImageFileCache$delegate", "smallImageBufferedDiskCache", "getSmallImageBufferedDiskCache", "smallImageBufferedDiskCache$delegate", "dynamicFileCaches", "", "", "getDynamicFileCaches", "()Ljava/util/Map;", "dynamicFileCaches$delegate", "dynamicBufferedDiskCaches", "Lcom/facebook/common/internal/ImmutableMap;", "getDynamicBufferedDiskCaches", "()Lcom/facebook/common/internal/ImmutableMap;", "dynamicBufferedDiskCaches$delegate", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiskCachesStoreFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskCachesStoreFactory.kt\ncom/facebook/imagepipeline/core/DiskCachesStoreFactory$diskCachesStore$2$1\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n462#2:102\n412#2:103\n462#2:109\n412#2:110\n1246#3,4:104\n1246#3,4:111\n1#4:108\n*S KotlinDebug\n*F\n+ 1 DiskCachesStoreFactory.kt\ncom/facebook/imagepipeline/core/DiskCachesStoreFactory$diskCachesStore$2$1\n*L\n79#1:102\n79#1:103\n86#1:109\n86#1:110\n79#1:104,4\n86#1:111,4\n*E\n"})
/* loaded from: classes3.dex */
public final class DiskCachesStoreFactory$diskCachesStore$2$1 implements DiskCachesStore {

    /* renamed from: dynamicBufferedDiskCaches$delegate, reason: from kotlin metadata */
    private final Lazy dynamicBufferedDiskCaches;

    /* renamed from: dynamicFileCaches$delegate, reason: from kotlin metadata */
    private final Lazy dynamicFileCaches;

    /* renamed from: mainBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final Lazy mainBufferedDiskCache;

    /* renamed from: mainFileCache$delegate, reason: from kotlin metadata */
    private final Lazy mainFileCache;

    /* renamed from: smallImageBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final Lazy smallImageBufferedDiskCache;

    /* renamed from: smallImageFileCache$delegate, reason: from kotlin metadata */
    private final Lazy smallImageFileCache;

    DiskCachesStoreFactory$diskCachesStore$2$1(final DiskCachesStoreFactory diskCachesStoreFactory) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.mainFileCache = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.mainFileCache_delegate$lambda$0(diskCachesStoreFactory);
            }
        });
        this.mainBufferedDiskCache = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.mainBufferedDiskCache_delegate$lambda$1(this.f$0, diskCachesStoreFactory);
            }
        });
        this.smallImageFileCache = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.smallImageFileCache_delegate$lambda$2(diskCachesStoreFactory);
            }
        });
        this.smallImageBufferedDiskCache = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.smallImageBufferedDiskCache_delegate$lambda$3(this.f$0, diskCachesStoreFactory);
            }
        });
        this.dynamicFileCaches = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicFileCaches_delegate$lambda$7(diskCachesStoreFactory, this);
            }
        });
        this.dynamicBufferedDiskCaches = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicBufferedDiskCaches_delegate$lambda$9(this.f$0, diskCachesStoreFactory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileCache mainFileCache_delegate$lambda$0(DiskCachesStoreFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.mainDiskCacheConfig);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public FileCache getMainFileCache() {
        return (FileCache) this.mainFileCache.getValue();
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getMainBufferedDiskCache() {
        return (BufferedDiskCache) this.mainBufferedDiskCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BufferedDiskCache mainBufferedDiskCache_delegate$lambda$1(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        FileCache mainFileCache = this$0.getMainFileCache();
        PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
        Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
        Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new BufferedDiskCache(mainFileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public FileCache getSmallImageFileCache() {
        return (FileCache) this.smallImageFileCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileCache smallImageFileCache_delegate$lambda$2(DiskCachesStoreFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.smallImageDiskCacheConfig);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getSmallImageBufferedDiskCache() {
        return (BufferedDiskCache) this.smallImageBufferedDiskCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BufferedDiskCache smallImageBufferedDiskCache_delegate$lambda$3(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        FileCache smallImageFileCache = this$0.getSmallImageFileCache();
        PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
        Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
        Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new BufferedDiskCache(smallImageFileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public Map<String, FileCache> getDynamicFileCaches() {
        return (Map) this.dynamicFileCaches.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map dynamicFileCaches_delegate$lambda$7(DiskCachesStoreFactory this$0, DiskCachesStoreFactory$diskCachesStore$2$1 this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Map map = this$0.dynamicDiskCacheConfigMap;
        if (map == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), this$0.fileCacheFactory.get((DiskCacheConfig) entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public ImmutableMap<String, BufferedDiskCache> getDynamicBufferedDiskCaches() {
        Object value = this.dynamicBufferedDiskCaches.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImmutableMap) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImmutableMap dynamicBufferedDiskCaches_delegate$lambda$9(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Map<String, FileCache> dynamicFileCaches = this$0.getDynamicFileCaches();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(dynamicFileCaches.size()));
        Iterator<T> it = dynamicFileCaches.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            FileCache fileCache = (FileCache) entry.getValue();
            PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
            Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
            PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
            Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
            Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
            Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
            Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
            Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
            linkedHashMap.put(key, new BufferedDiskCache(fileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker));
        }
        return ImmutableMap.copyOf((Map) linkedHashMap);
    }
}
