package com.contentsquare.android.sdk;

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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E3 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$captureScrollViewSnapshot$1", m1845f = "OverlayViewModel.kt", m1846i = {}, m1847l = {193}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2480E3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f1546a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2510H3 f1547b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AbstractC2916w5.b f1548c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2480E3(C2510H3 c2510h3, AbstractC2916w5.b bVar, Continuation<? super C2480E3> continuation) {
        super(2, continuation);
        this.f1547b = c2510h3;
        this.f1548c = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2480E3(this.f1547b, this.f1548c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2480E3(this.f1547b, this.f1548c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1546a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2836o5 c2836o5 = this.f1547b.f1663b;
            AbstractC2916w5.b bVar = this.f1548c;
            this.f1546a = 1;
            c2836o5.getClass();
            Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C2826n5(c2836o5, bVar, null), this);
            if (objWithContext != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
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
