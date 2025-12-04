package com.urbanairship.iam.assets;

import com.urbanairship.UALog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes5.dex */
final class AssetCacheManager$cacheAsset$task$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ List $assets;
    final /* synthetic */ String $identifier;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AssetCacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetCacheManager$cacheAsset$task$1(AssetCacheManager assetCacheManager, String str, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = assetCacheManager;
        this.$identifier = str;
        this.$assets = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AssetCacheManager$cacheAsset$task$1 assetCacheManager$cacheAsset$task$1 = new AssetCacheManager$cacheAsset$task$1(this.this$0, this.$identifier, this.$assets, continuation);
        assetCacheManager$cacheAsset$task$1.L$0 = obj;
        return assetCacheManager$cacheAsset$task$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AssetCacheManager$cacheAsset$task$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        DefaultAirshipCachedAssets defaultAirshipCachedAssets;
        final long j;
        Object objM2968constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            long jCurrentTimeMillis = System.currentTimeMillis();
            defaultAirshipCachedAssets = new DefaultAirshipCachedAssets(this.this$0.fileManager.ensureCacheDirectory(this.$identifier), this.this$0.fileManager);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$assets, defaultAirshipCachedAssets, this.this$0, this.$identifier, null);
            this.L$0 = coroutineScope;
            this.L$1 = defaultAirshipCachedAssets;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jCurrentTimeMillis;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = this.J$0;
            defaultAirshipCachedAssets = (DefaultAirshipCachedAssets) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            j = j2;
        }
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        final String str = this.$identifier;
        final List list = this.$assets;
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$task$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Inapp message " + str + ": " + list.size() + " in " + (jCurrentTimeMillis2 - j) + "ms";
            }
        }, 1, null);
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            objM2968constructorimpl = Result.m2968constructorimpl(defaultAirshipCachedAssets);
        } else {
            Result.Companion companion = Result.INSTANCE;
            objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(new CancellationException()));
        }
        return Result.m2967boximpl(objM2968constructorimpl);
    }

    /* renamed from: com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$task$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $assets;
        final /* synthetic */ DefaultAirshipCachedAssets $cache;
        final /* synthetic */ String $identifier;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AssetCacheManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, DefaultAirshipCachedAssets defaultAirshipCachedAssets, AssetCacheManager assetCacheManager, String str, Continuation continuation) {
            super(2, continuation);
            this.$assets = list;
            this.$cache = defaultAirshipCachedAssets;
            this.this$0 = assetCacheManager;
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$assets, this.$cache, this.this$0, this.$identifier, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Set set = CollectionsKt.toSet(this.$assets);
                DefaultAirshipCachedAssets defaultAirshipCachedAssets = this.$cache;
                AssetCacheManager assetCacheManager = this.this$0;
                String str = this.$identifier;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AssetCacheManager$cacheAsset$task$1$1$1$1(defaultAirshipCachedAssets, (String) it.next(), assetCacheManager, str, null), 3, null));
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }
}
