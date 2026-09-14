package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.compose.ComposePageScroller;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B3 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$captureComposeSnapshot$1", m1845f = "OverlayViewModel.kt", m1846i = {}, m1847l = {187}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2450B3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f1437a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2510H3 f1438b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ComposePageScroller f1439c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2450B3(C2510H3 c2510h3, ComposePageScroller composePageScroller, Continuation<? super C2450B3> continuation) {
        super(2, continuation);
        this.f1438b = c2510h3;
        this.f1439c = composePageScroller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2450B3(this.f1438b, this.f1439c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2450B3(this.f1438b, this.f1439c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f1437a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2680Y7 c2680y7 = this.f1438b.f1665d;
            ComposePageScroller composePageScroller = this.f1439c;
            this.f1437a = 1;
            c2680y7.getClass();
            Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C2671X7(composePageScroller, c2680y7, null), this);
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
