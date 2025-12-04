package com.contentsquare.android.sdk;

import com.contentsquare.android.api.Currencies;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$terminateTelemetryService$1", f = "TelemetryManager.kt", i = {}, l = {Currencies.ERN}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$terminateTelemetryService$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$terminateTelemetryService$1\n*L\n231#1:279,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0728k7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Iterator a;
    public int b;
    public final /* synthetic */ C0698h7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0728k7(C0698h7 c0698h7, Continuation<? super C0728k7> continuation) {
        super(2, continuation);
        this.c = c0698h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C0728k7(this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C0728k7(this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.c.j.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = this.a;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                InterfaceC0628a7 interfaceC0628a7 = (InterfaceC0628a7) it.next();
                this.a = it;
                this.b = 1;
                if (interfaceC0628a7.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception e) {
            Q2.a(this.c.i, "Failed to stop agent when terminate Telemetry service", e);
        }
        return Unit.INSTANCE;
    }
}
