package com.urbanairship.iam.assets;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:7:0x0026, B:39:0x00d2, B:41:0x00d6, B:42:0x00e4, B:43:0x0102), top: B:49:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:7:0x0026, B:39:0x00d2, B:41:0x00d6, B:42:0x00e4, B:43:0x0102), top: B:49:0x0026 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$task$1$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
