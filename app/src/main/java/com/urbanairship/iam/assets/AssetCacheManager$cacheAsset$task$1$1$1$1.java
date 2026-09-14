package com.urbanairship.iam.assets;

import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: loaded from: classes5.dex */
final class AssetCacheManager$cacheAsset$task$1$1$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $asset;
    final /* synthetic */ DefaultAirshipCachedAssets $cache;
    final /* synthetic */ String $identifier;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ AssetCacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetCacheManager$cacheAsset$task$1$1$1$1(DefaultAirshipCachedAssets defaultAirshipCachedAssets, String str, AssetCacheManager assetCacheManager, String str2, Continuation continuation) {
        super(2, continuation);
        this.$cache = defaultAirshipCachedAssets;
        this.$asset = str;
        this.this$0 = assetCacheManager;
        this.$identifier = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AssetCacheManager$cacheAsset$task$1$1$1$1 assetCacheManager$cacheAsset$task$1$1$1$1 = new AssetCacheManager$cacheAsset$task$1$1$1$1(this.$cache, this.$asset, this.this$0, this.$identifier, continuation);
        assetCacheManager$cacheAsset$task$1$1$1$1.L$0 = obj;
        return assetCacheManager$cacheAsset$task$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AssetCacheManager$cacheAsset$task$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d6 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:7:0x0026, B:39:0x00d2, B:41:0x00d6, B:42:0x00e4, B:43:0x0102), top: B:49:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e4 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:7:0x0026, B:39:0x00d2, B:41:0x00d6, B:42:0x00e4, B:43:0x0102), top: B:49:0x0026 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x00e4, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Semaphore downloadSemaphore;
        String str;
        AssetCacheManager assetCacheManager;
        DefaultAirshipCachedAssets defaultAirshipCachedAssets;
        String str2;
        Throwable th;
        Semaphore semaphore;
        AssetCacheManager assetCacheManager2;
        String str3;
        DefaultAirshipCachedAssets defaultAirshipCachedAssets2;
        Uri uri;
        Uri uri2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                if (CoroutineScopeKt.isActive(coroutineScope) && !this.$cache.isCached(this.$asset)) {
                    downloadSemaphore = this.this$0.getDownloadSemaphore();
                    DefaultAirshipCachedAssets defaultAirshipCachedAssets3 = this.$cache;
                    str = this.$asset;
                    AssetCacheManager assetCacheManager3 = this.this$0;
                    String str4 = this.$identifier;
                    this.L$0 = coroutineScope;
                    this.L$1 = downloadSemaphore;
                    this.L$2 = defaultAirshipCachedAssets3;
                    this.L$3 = str;
                    this.L$4 = assetCacheManager3;
                    this.L$5 = str4;
                    this.label = 1;
                    if (downloadSemaphore.acquire(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    assetCacheManager = assetCacheManager3;
                    defaultAirshipCachedAssets = defaultAirshipCachedAssets3;
                    str2 = str4;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uri = (Uri) this.L$5;
                str2 = (String) this.L$4;
                assetCacheManager2 = (AssetCacheManager) this.L$3;
                str3 = (String) this.L$2;
                defaultAirshipCachedAssets2 = (DefaultAirshipCachedAssets) this.L$1;
                semaphore = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    uri2 = (Uri) obj;
                    if (uri2 != null) {
                        assetCacheManager2.fileManager.moveAsset(uri2, uri);
                        defaultAirshipCachedAssets2.generateAndStoreMetadata$urbanairship_automation_release(str3);
                        Unit unit = Unit.INSTANCE;
                        downloadSemaphore = semaphore;
                        downloadSemaphore.release();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("Failed to download asset for " + str2 + "! " + str3);
                } catch (Throwable th2) {
                    th = th2;
                    semaphore.release();
                    throw th;
                }
            }
            str2 = (String) this.L$5;
            assetCacheManager = (AssetCacheManager) this.L$4;
            str = (String) this.L$3;
            defaultAirshipCachedAssets = (DefaultAirshipCachedAssets) this.L$2;
            Semaphore semaphore2 = (Semaphore) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            downloadSemaphore = semaphore2;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                Uri uriCacheUri = defaultAirshipCachedAssets.cacheUri(str);
                if (uriCacheUri != null) {
                    AssetDownloader assetDownloader = assetCacheManager.downloader;
                    Uri uri3 = Uri.parse(str);
                    this.L$0 = downloadSemaphore;
                    this.L$1 = defaultAirshipCachedAssets;
                    this.L$2 = str;
                    this.L$3 = assetCacheManager;
                    this.L$4 = str2;
                    this.L$5 = uriCacheUri;
                    this.label = 2;
                    Object objDownloadAsset = assetDownloader.downloadAsset(uri3, this);
                    if (objDownloadAsset == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    assetCacheManager2 = assetCacheManager;
                    str3 = str;
                    defaultAirshipCachedAssets2 = defaultAirshipCachedAssets;
                    uri = uriCacheUri;
                    Semaphore semaphore3 = downloadSemaphore;
                    obj = objDownloadAsset;
                    semaphore = semaphore3;
                    uri2 = (Uri) obj;
                    if (uri2 != null) {
                        assetCacheManager2.fileManager.moveAsset(uri2, uri);
                        defaultAirshipCachedAssets2.generateAndStoreMetadata$urbanairship_automation_release(str3);
                        Unit unit2 = Unit.INSTANCE;
                        downloadSemaphore = semaphore;
                    } else {
                        throw new IllegalStateException("Failed to download asset for " + str2 + "! " + str3);
                    }
                }
                downloadSemaphore.release();
                return Unit.INSTANCE;
            }
            Unit unit3 = Unit.INSTANCE;
            downloadSemaphore.release();
            return unit3;
        } catch (Throwable th3) {
            Semaphore semaphore4 = downloadSemaphore;
            th = th3;
            semaphore = semaphore4;
            semaphore.release();
            throw th;
        }
    }
}
