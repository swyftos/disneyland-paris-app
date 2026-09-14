package com.contentsquare.android.sdk;

import com.contentsquare.android.api.Currencies;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G3 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$resumeSnapshot$1", m1845f = "OverlayViewModel.kt", m1846i = {}, m1847l = {Currencies.CNY}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2500G3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f1650a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2510H3 f1651b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2500G3(C2510H3 c2510h3, Continuation<? super C2500G3> continuation) {
        super(2, continuation);
        this.f1651b = c2510h3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2500G3(this.f1651b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2500G3(this.f1651b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0043  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objWithContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1650a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2836o5 c2836o5 = this.f1651b.f1663b;
            this.f1650a = 1;
            c2836o5.f2941c.f2295a.set(false);
            C2836o5.d dVar = c2836o5.f2943e;
            if (dVar != null) {
                c2836o5.f2943e = null;
                objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C2846p5(dVar, null), this);
                if (objWithContext != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objWithContext = Unit.INSTANCE;
                }
            } else {
                objWithContext = Unit.INSTANCE;
            }
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
