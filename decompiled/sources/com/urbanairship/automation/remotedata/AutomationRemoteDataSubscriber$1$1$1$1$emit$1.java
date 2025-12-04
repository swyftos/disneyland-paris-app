package com.urbanairship.automation.remotedata;

import com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AutomationRemoteDataSubscriber$1$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationRemoteDataSubscriber.AnonymousClass1.C01391.C01401.C01411 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationRemoteDataSubscriber$1$1$1$1$emit$1(AutomationRemoteDataSubscriber.AnonymousClass1.C01391.C01401.C01411 c01411, Continuation continuation) {
        super(continuation);
        this.this$0 = c01411;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((InAppRemoteData) null, (Continuation) this);
    }
}
