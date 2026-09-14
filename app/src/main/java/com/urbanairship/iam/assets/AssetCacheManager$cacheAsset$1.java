package com.urbanairship.iam.assets;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class AssetCacheManager$cacheAsset$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetCacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetCacheManager$cacheAsset$1(AssetCacheManager assetCacheManager, Continuation continuation) {
        super(continuation);
        this.this$0 = assetCacheManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5133cacheAsset0E7RQCE = this.this$0.m5133cacheAsset0E7RQCE(null, null, this);
        return objM5133cacheAsset0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5133cacheAsset0E7RQCE : Result.m5276boximpl(objM5133cacheAsset0E7RQCE);
    }
}
