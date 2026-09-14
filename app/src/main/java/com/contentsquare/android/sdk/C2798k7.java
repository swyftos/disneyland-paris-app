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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.k7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$terminateTelemetryService$1", m1845f = "TelemetryManager.kt", m1846i = {}, m1847l = {Currencies.ERN}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
@SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$terminateTelemetryService$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$terminateTelemetryService$1\n*L\n231#1:279,2\n*E\n"})
public final class C2798k7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public Iterator f2832a;

    /* JADX INFO: renamed from: b */
    public int f2833b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2768h7 f2834c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2798k7(C2768h7 c2768h7, Continuation<? super C2798k7> continuation) {
        super(2, continuation);
        this.f2834c = c2768h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2798k7(this.f2834c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2798k7(this.f2834c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2833b;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.f2834c.f2710j.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = this.f2832a;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                InterfaceC2698a7 interfaceC2698a7 = (InterfaceC2698a7) it.next();
                this.f2832a = it;
                this.f2833b = 1;
                if (interfaceC2698a7.mo891a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception e) {
            C2599Q2.m1011a(this.f2834c.f2709i, "Failed to stop agent when terminate Telemetry service", e);
        }
        return Unit.INSTANCE;
    }
}
