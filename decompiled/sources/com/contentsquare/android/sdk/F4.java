package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0657d6;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RegularSnapshotCaptureUseCase$capture$2", f = "RegularSnapshotCaptureUseCase.kt", i = {1}, l = {14, 16}, m = "invokeSuspend", n = {"throwable"}, s = {"L$2"})
/* loaded from: classes2.dex */
public final class F4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public G4 a;
    public Throwable b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ G4 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F4(G4 g4, Continuation<? super F4> continuation) {
        super(2, continuation);
        this.e = g4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        F4 f4 = new F4(this.e, continuation);
        f4.d = obj;
        return f4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        F4 f4 = new F4(this.e, continuation);
        f4.d = coroutineScope;
        return f4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM2968constructorimpl;
        G4 g4;
        Object obj2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(th2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            G4 g42 = this.e;
            Result.Companion companion2 = Result.INSTANCE;
            E4 e4 = g42.a;
            AbstractC0657d6.c cVar = AbstractC0657d6.c.a;
            this.c = 1;
            if (e4.a(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = this.b;
                g4 = this.a;
                obj2 = this.d;
                ResultKt.throwOnFailure(obj);
                g4.a.a(th);
                objM2968constructorimpl = obj2;
                return Result.m2967boximpl(objM2968constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
        }
        objM2968constructorimpl = Result.m2968constructorimpl(Unit.INSTANCE);
        g4 = this.e;
        Throwable thM2971exceptionOrNullimpl = Result.m2971exceptionOrNullimpl(objM2968constructorimpl);
        if (thM2971exceptionOrNullimpl != null) {
            this.d = objM2968constructorimpl;
            this.a = g4;
            this.b = thM2971exceptionOrNullimpl;
            this.c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM2968constructorimpl;
            th = thM2971exceptionOrNullimpl;
            g4.a.a(th);
            objM2968constructorimpl = obj2;
        }
        return Result.m2967boximpl(objM2968constructorimpl);
    }
}
