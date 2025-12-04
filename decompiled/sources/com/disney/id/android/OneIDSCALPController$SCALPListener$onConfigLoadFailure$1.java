package com.disney.id.android;

import com.disney.id.android.OneIDSCALPController;
import com.disney.id.android.SCALPController;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneIDSCALPController$SCALPListener$onConfigLoadFailure$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ OneIDSCALPController.SCALPListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneIDSCALPController$SCALPListener$onConfigLoadFailure$1(OneIDSCALPController.SCALPListener sCALPListener, Continuation continuation) {
        super(2, continuation);
        this.this$0 = sCALPListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneIDSCALPController$SCALPListener$onConfigLoadFailure$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneIDSCALPController$SCALPListener$onConfigLoadFailure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getController().setLoaded(SCALPController.SiteConfigDownloadStatus.FailedToDownload);
        return Unit.INSTANCE;
    }
}
