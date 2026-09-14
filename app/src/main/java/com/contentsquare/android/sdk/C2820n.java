package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class C2820n implements Flow<AbstractC2730e.a<?>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Flow f2890a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f2891b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.n$a */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n54#2:223\n71#3:224\n*E\n"})
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ FlowCollector f2892a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2780j f2893b;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.n$a$a, reason: collision with other inner class name */
        @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$map$1$2", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        public static final class C8146a extends ContinuationImpl {

            /* JADX INFO: renamed from: a */
            public /* synthetic */ Object f2894a;

            /* JADX INFO: renamed from: b */
            public int f2895b;

            public C8146a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f2894a = obj;
                this.f2895b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector, C2780j c2780j) {
            this.f2892a = flowCollector;
            this.f2893b = c2780j;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public final Object emit(Object obj, @NotNull Continuation continuation) {
            C8146a c8146a;
            AbstractC2730e.a<?> aVarMo861c;
            if (continuation instanceof C8146a) {
                c8146a = (C8146a) continuation;
                int i = c8146a.f2895b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c8146a.f2895b = i - Integer.MIN_VALUE;
                } else {
                    c8146a = new C8146a(continuation);
                }
            } else {
                c8146a = new C8146a(continuation);
            }
            Object obj2 = c8146a.f2894a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c8146a.f2895b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector flowCollector = this.f2892a;
                AbstractC2730e.a<?> aVar = (AbstractC2730e.a) obj;
                C2780j c2780j = this.f2893b;
                c2780j.getClass();
                try {
                    InterfaceC2452B5 interfaceC2452B5 = c2780j.f2759h;
                    aVarMo861c = interfaceC2452B5 != null ? interfaceC2452B5.mo861c(aVar) : null;
                } catch (Throwable th) {
                    c2780j.f2753b.m830e(th, "Pipeline processing of an action event builder failed!");
                }
                c8146a.f2895b = 1;
                if (flowCollector.emit(aVarMo861c, c8146a) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
    }

    public C2820n(C2810m c2810m, C2780j c2780j) {
        this.f2890a = c2810m;
        this.f2891b = c2780j;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super AbstractC2730e.a<?>> flowCollector, @NotNull Continuation continuation) {
        Object objCollect = this.f2890a.collect(new a(flowCollector, this.f2891b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
