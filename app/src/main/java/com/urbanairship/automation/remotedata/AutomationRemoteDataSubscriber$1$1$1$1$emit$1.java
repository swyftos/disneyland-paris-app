package com.urbanairship.automation.remotedata;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class AutomationRemoteDataSubscriber$1$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationRemoteDataSubscriber.C51271.AnonymousClass1.C81651.C81661 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationRemoteDataSubscriber$1$1$1$1$emit$1(AutomationRemoteDataSubscriber.C51271.AnonymousClass1.C81651.C81661 c81661, Continuation continuation) {
        super(continuation);
        this.this$0 = c81661;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((InAppRemoteData) null, (Continuation) this);
    }
}
