package com.urbanairship.util;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
final class AutoRefreshingDataProvider$updates$2$2$1 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ AutoRefreshingDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoRefreshingDataProvider$updates$2$2$1(AutoRefreshingDataProvider autoRefreshingDataProvider, Continuation continuation) {
        super(3, continuation);
        this.this$0 = autoRefreshingDataProvider;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Result) obj).getValue(), obj2, (Continuation) obj3);
    }

    public final Object invoke(Object obj, Object obj2, Continuation continuation) {
        AutoRefreshingDataProvider$updates$2$2$1 autoRefreshingDataProvider$updates$2$2$1 = new AutoRefreshingDataProvider$updates$2$2$1(this.this$0, continuation);
        autoRefreshingDataProvider$updates$2$2$1.L$0 = Result.m2967boximpl(obj);
        autoRefreshingDataProvider$updates$2$2$1.L$1 = obj2;
        return autoRefreshingDataProvider$updates$2$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Object value = ((Result) this.L$0).getValue();
        Object obj2 = this.L$1;
        AutoRefreshingDataProvider autoRefreshingDataProvider = this.this$0;
        Throwable thM2971exceptionOrNullimpl = Result.m2971exceptionOrNullimpl(value);
        if (thM2971exceptionOrNullimpl == null) {
            return Result.m2967boximpl(Result.m2968constructorimpl(autoRefreshingDataProvider.onApplyOverrides(value, obj2)));
        }
        return Result.m2967boximpl(Result.m2968constructorimpl(ResultKt.createFailure(thM2971exceptionOrNullimpl)));
    }
}
