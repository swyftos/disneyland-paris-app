package com.urbanairship.preferencecenter.util;

import com.urbanairship.preferencecenter.util.FlowExtensionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FlowExtensionsKt$scanConcat$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowExtensionsKt.AnonymousClass1.C01611 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtensionsKt$scanConcat$1$1$emit$1(FlowExtensionsKt.AnonymousClass1.C01611 c01611, Continuation continuation) {
        super(continuation);
        this.this$0 = c01611;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
