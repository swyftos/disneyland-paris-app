package com.urbanairship.automation;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ExecutionWindowProcessor$sleep$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExecutionWindowProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExecutionWindowProcessor$sleep$1(ExecutionWindowProcessor executionWindowProcessor, Continuation continuation) {
        super(continuation);
        this.this$0 = executionWindowProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m2782sleepVtjQ1oo(0L, this);
    }
}
