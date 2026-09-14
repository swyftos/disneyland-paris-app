package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$1", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {101}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2770i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f2728a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f2729b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2770i(C2780j c2780j, Continuation<? super C2770i> continuation) {
        super(2, continuation);
        this.f2729b = c2780j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2770i(this.f2729b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2770i(this.f2729b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2728a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2780j c2780j = this.f2729b;
            Flow<JSONObject> flow = c2780j.f2756e;
            MutableSharedFlow<JSONObject> mutableSharedFlow = c2780j.f2757f;
            this.f2728a = 1;
            if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
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
