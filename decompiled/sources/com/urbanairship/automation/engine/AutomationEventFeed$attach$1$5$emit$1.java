package com.urbanairship.automation.engine;

import com.urbanairship.automation.engine.AutomationEventFeed$attach$1;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AutomationEventFeed$attach$1$5$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationEventFeed$attach$1.AnonymousClass5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEventFeed$attach$1$5$emit$1(AutomationEventFeed$attach$1.AnonymousClass5 anonymousClass5, Continuation continuation) {
        super(continuation);
        this.this$0 = anonymousClass5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((List) null, (Continuation) this);
    }
}
