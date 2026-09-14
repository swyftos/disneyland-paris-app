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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$flushTelemetryService$1", m1845f = "TelemetryManager.kt", m1846i = {}, m1847l = {252}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2778i7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public int f2749a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2768h7 f2750b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2778i7(C2768h7 c2768h7, Continuation<? super C2778i7> continuation) {
        super(2, continuation);
        this.f2750b = c2768h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2778i7(this.f2750b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2778i7(this.f2750b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2749a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2768h7 c2768h7 = this.f2750b;
                this.f2749a = 1;
                if (C2768h7.m1144a(c2768h7, "forced", this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            C2848p7 c2848p7 = this.f2750b.f2701a;
            c2848p7.f3008a.clear();
            c2848p7.f3009b.clear();
            c2848p7.f3010c = new JSONObject();
            c2848p7.f3011d = new JSONObject();
            c2848p7.f3012e = new JSONObject();
            c2848p7.f3013f = new JSONObject();
            this.f2750b.f2709i.m827d("Flush & stop Telemetry service");
        } catch (Exception e) {
            C2599Q2.m1011a(this.f2750b.f2709i, "Failed to process report when flush Telemetry service", e);
        }
        return Unit.INSTANCE;
    }
}
