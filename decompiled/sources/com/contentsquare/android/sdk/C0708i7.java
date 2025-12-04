package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$flushTelemetryService$1", f = "TelemetryManager.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.contentsquare.android.sdk.i7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0708i7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ C0698h7 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0708i7(C0698h7 c0698h7, Continuation<? super C0708i7> continuation) {
        super(2, continuation);
        this.b = c0698h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C0708i7(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C0708i7(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0698h7 c0698h7 = this.b;
                this.a = 1;
                if (C0698h7.a(c0698h7, "forced", this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            C0778p7 c0778p7 = this.b.a;
            c0778p7.a.clear();
            c0778p7.b.clear();
            c0778p7.c = new JSONObject();
            c0778p7.d = new JSONObject();
            c0778p7.e = new JSONObject();
            c0778p7.f = new JSONObject();
            this.b.i.d("Flush & stop Telemetry service");
        } catch (Exception e) {
            Q2.a(this.b.i, "Failed to process report when flush Telemetry service", e);
        }
        return Unit.INSTANCE;
    }
}
