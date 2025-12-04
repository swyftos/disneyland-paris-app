package com.contentsquare.android.sdk;

import android.os.Debug;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.l4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0735l4 implements Q3<Float> {

    @NotNull
    public final Debug.MemoryInfo a = new Debug.MemoryInfo();

    @NotNull
    public final Flow<Float> b = FlowKt.flow(new a(null));

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.performance.RamCollector$dataFlow$1", f = "RamCollector.kt", i = {0, 1}, l = {30, 31}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nRamCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RamCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/RamCollector$dataFlow$1\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,59:1\n329#2:60\n*S KotlinDebug\n*F\n+ 1 RamCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/RamCollector$dataFlow$1\n*L\n29#1:60\n*E\n"})
    /* renamed from: com.contentsquare.android.sdk.l4$a */
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = C0735l4.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
            a aVar = C0735l4.this.new a(continuation);
            aVar.b = flowCollector;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0057 -> B:11:0x002e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r6.b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L2e
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                java.lang.Object r1 = r6.b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L45
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.b
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            L2e:
                kotlin.coroutines.CoroutineContext r7 = r6.get$context()
                boolean r7 = kotlinx.coroutines.JobKt.isActive(r7)
                if (r7 == 0) goto L5a
                r6.b = r1
                r6.a = r3
                r4 = 300(0x12c, double:1.48E-321)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                if (r7 != r0) goto L45
                return r0
            L45:
                com.contentsquare.android.sdk.l4 r7 = com.contentsquare.android.sdk.C0735l4.this
                float r7 = com.contentsquare.android.sdk.C0735l4.a(r7)
                java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
                r6.b = r1
                r6.a = r2
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L2e
                return r0
            L5a:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0735l4.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final float a(C0735l4 c0735l4) {
        Debug.getMemoryInfo(c0735l4.a);
        return c0735l4.a.getTotalPss() / 1000;
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final String getName() {
        return "total_memory";
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final Flow<Float> a() {
        return this.b;
    }
}
