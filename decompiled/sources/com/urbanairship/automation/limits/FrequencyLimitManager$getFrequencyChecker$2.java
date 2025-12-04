package com.urbanairship.automation.limits;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class FrequencyLimitManager$getFrequencyChecker$2 extends SuspendLambda implements Function1 {
    final /* synthetic */ List $constraintIds;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FrequencyLimitManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrequencyLimitManager$getFrequencyChecker$2(FrequencyLimitManager frequencyLimitManager, List list, Continuation continuation) {
        super(1, continuation);
        this.this$0 = frequencyLimitManager;
        this.$constraintIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new FrequencyLimitManager$getFrequencyChecker$2(this.this$0, this.$constraintIds, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((FrequencyLimitManager$getFrequencyChecker$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cb -> B:32:0x00ce). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
