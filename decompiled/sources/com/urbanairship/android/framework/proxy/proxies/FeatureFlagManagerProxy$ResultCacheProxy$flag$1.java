package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
final class FeatureFlagManagerProxy$ResultCacheProxy$flag$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManagerProxy.ResultCacheProxy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManagerProxy$ResultCacheProxy$flag$1(FeatureFlagManagerProxy.ResultCacheProxy resultCacheProxy, Continuation continuation) {
        super(continuation);
        this.this$0 = resultCacheProxy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.flag(null, this);
    }
}
