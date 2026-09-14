package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.k */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$emitJSONObject$1", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {115}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2790k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f2791a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f2792b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ JSONObject f2793c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2790k(C2780j c2780j, JSONObject jSONObject, Continuation<? super C2790k> continuation) {
        super(2, continuation);
        this.f2792b = c2780j;
        this.f2793c = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2790k(this.f2792b, this.f2793c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2790k(this.f2792b, this.f2793c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2791a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow<JSONObject> mutableSharedFlow = this.f2792b.f2757f;
            JSONObject jSONObject = this.f2793c;
            this.f2791a = 1;
            if (mutableSharedFlow.emit(jSONObject, this) == coroutine_suspended) {
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
