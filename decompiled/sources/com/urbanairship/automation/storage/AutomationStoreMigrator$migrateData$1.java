package com.urbanairship.automation.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AutomationStoreMigrator$migrateData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationStoreMigrator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationStoreMigrator$migrateData$1(AutomationStoreMigrator automationStoreMigrator, Continuation continuation) {
        super(continuation);
        this.this$0 = automationStoreMigrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.migrateData$urbanairship_automation_release(this);
    }
}
