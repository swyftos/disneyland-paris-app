package com.urbanairship.automation.engine;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class AutomationPreparer$prepareInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationPreparer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationPreparer$prepareInfo$1(AutomationPreparer automationPreparer, Continuation continuation) {
        super(continuation);
        this.this$0 = automationPreparer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5048prepareInfoyxL6bBk = this.this$0.m5048prepareInfoyxL6bBk(null, null, null, null, this);
        return objM5048prepareInfoyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5048prepareInfoyxL6bBk : Result.m5276boximpl(objM5048prepareInfoyxL6bBk);
    }
}
