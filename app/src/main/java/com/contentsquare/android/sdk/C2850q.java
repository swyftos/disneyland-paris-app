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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class C2850q implements Flow<AbstractC2730e> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Flow f3014a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f3015b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.q$a */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n54#2:223\n77#3:224\n*E\n"})
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ FlowCollector f3016a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2780j f3017b;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.q$a$a, reason: collision with other inner class name */
        @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$map$4$2", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        public static final class C8151a extends ContinuationImpl {

            /* JADX INFO: renamed from: a */
            public /* synthetic */ Object f3018a;

            /* JADX INFO: renamed from: b */
            public int f3019b;

            public C8151a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f3018a = obj;
                this.f3019b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector, C2780j c2780j) {
            this.f3016a = flowCollector;
            this.f3017b = c2780j;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public final Object emit(Object obj, @NotNull Continuation continuation) {
            C8151a c8151a;
            AbstractC2730e abstractC2730eMo857a;
            if (continuation instanceof C8151a) {
                c8151a = (C8151a) continuation;
                int i = c8151a.f3019b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c8151a.f3019b = i - Integer.MIN_VALUE;
                } else {
                    c8151a = new C8151a(continuation);
                }
            } else {
                c8151a = new C8151a(continuation);
            }
            Object obj2 = c8151a.f3018a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c8151a.f3019b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector flowCollector = this.f3016a;
                AbstractC2730e.a aVar = (AbstractC2730e.a) obj;
                C2780j c2780j = this.f3017b;
                c2780j.getClass();
                try {
                    abstractC2730eMo857a = aVar.mo857a();
                } catch (Throwable th) {
                    c2780j.f2753b.m830e(th, "Pipeline processing of an action event builder failed!");
                    abstractC2730eMo857a = null;
                }
                c8151a.f3019b = 1;
                if (flowCollector.emit(abstractC2730eMo857a, c8151a) == coroutine_suspended) {
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

    public C2850q(Flow flow, C2780j c2780j) {
        this.f3014a = flow;
        this.f3015b = c2780j;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super AbstractC2730e> flowCollector, @NotNull Continuation continuation) {
        Object objCollect = this.f3014a.collect(new a(flowCollector, this.f3015b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
