package com.contentsquare.android.sdk;

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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F4 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RegularSnapshotCaptureUseCase$capture$2", m1845f = "RegularSnapshotCaptureUseCase.kt", m1846i = {1}, m1847l = {14, 16}, m1848m = "invokeSuspend", m1849n = {"throwable"}, m1850s = {"L$2"})
public final class C2491F4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

    /* JADX INFO: renamed from: a */
    public C2501G4 f1610a;

    /* JADX INFO: renamed from: b */
    public Throwable f1611b;

    /* JADX INFO: renamed from: c */
    public int f1612c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f1613d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2501G4 f1614e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2491F4(C2501G4 c2501g4, Continuation<? super C2491F4> continuation) {
        super(2, continuation);
        this.f1614e = c2501g4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2491F4 c2491f4 = new C2491F4(this.f1614e, continuation);
        c2491f4.f1613d = obj;
        return c2491f4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        C2491F4 c2491f4 = new C2491F4(this.f1614e, continuation);
        c2491f4.f1613d = coroutineScope;
        return c2491f4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM5277constructorimpl;
        C2501G4 c2501g4;
        Object obj2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1612c;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = this.f1611b;
                    c2501g4 = this.f1610a;
                    obj2 = this.f1613d;
                    ResultKt.throwOnFailure(obj);
                }
                c2501g4.f1652a.m1087a(th);
                objM5277constructorimpl = obj2;
                return Result.m5276boximpl(objM5277constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
            C2501G4 c2501g5 = this.f1614e;
            Result.Companion companion = Result.INSTANCE;
            C2481E4 c2481e4 = c2501g5.f1652a;
            AbstractC2727d6.c cVar = AbstractC2727d6.c.f2510a;
            this.f1612c = 1;
            if (c2481e4.m1086a(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objM5277constructorimpl = Result.m5277constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th2));
        }
        c2501g4 = this.f1614e;
        Throwable thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5277constructorimpl);
        if (thM5280exceptionOrNullimpl != null) {
            this.f1613d = objM5277constructorimpl;
            this.f1610a = c2501g4;
            this.f1611b = thM5280exceptionOrNullimpl;
            this.f1612c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM5277constructorimpl;
            th = thM5280exceptionOrNullimpl;
            c2501g4.f1652a.m1087a(th);
            objM5277constructorimpl = obj2;
        }
        return Result.m5276boximpl(objM5277constructorimpl);
    }
}
