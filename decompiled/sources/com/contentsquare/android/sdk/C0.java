package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.performance.CpuCollector$dataFlow$1", f = "CpuCollector.kt", i = {0, 1}, l = {68, EACTags.DISPLAY_IMAGE}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nCpuCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector$dataFlow$1\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,127:1\n329#2:128\n*S KotlinDebug\n*F\n+ 1 CpuCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/CpuCollector$dataFlow$1\n*L\n67#1:128\n*E\n"})
/* loaded from: classes2.dex */
public final class C0 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ E0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0(E0 e0, Continuation<? super C0> continuation) {
        super(2, continuation);
        this.c = e0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C0 c0 = new C0(this.c, continuation);
        c0.b = obj;
        return c0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        C0 c0 = new C0(this.c, continuation);
        c0.b = flowCollector;
        return c0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:9|10|17|48|18|51|19|(2:21|(1:23))|26|27|28|38|(1:40)(1:41)|42|(1:44)(1:45)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
    
        com.contentsquare.android.sdk.Q2.a((com.contentsquare.android.core.features.logging.Logger) r6.d.getValue(), "failed to read " + r6.a + " => " + kotlin.ExceptionsKt.stackTraceToString(r0), r0);
        r0 = (java.lang.String[]) r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[Catch: all -> 0x007f, TryCatch #2 {all -> 0x007f, blocks: (B:19:0x005d, B:21:0x0063, B:23:0x0069, B:26:0x0082), top: B:51:0x005d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x013e -> B:12:0x0030). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
