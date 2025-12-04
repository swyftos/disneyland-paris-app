package com.urbanairship.audience;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AudienceOverridesProvider$contactOverrides$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudienceOverridesProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudienceOverridesProvider$contactOverrides$1(AudienceOverridesProvider audienceOverridesProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = audienceOverridesProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.contactOverrides$urbanairship_core_release(null, this);
    }
}
