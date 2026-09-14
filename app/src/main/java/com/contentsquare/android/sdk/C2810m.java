package com.contentsquare.android.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.m */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class C2810m implements Flow<AbstractC2730e.a<?>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Flow f2865a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f2866b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.m$a */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n22#2:223\n23#2:225\n70#3:224\n*E\n"})
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ FlowCollector f2867a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2780j f2868b;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.m$a$a, reason: collision with other inner class name */
        @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$filter$1$2", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        public static final class C8144a extends ContinuationImpl {

            /* JADX INFO: renamed from: a */
            public /* synthetic */ Object f2869a;

            /* JADX INFO: renamed from: b */
            public int f2870b;

            public C8144a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f2869a = obj;
                this.f2870b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector, C2780j c2780j) {
            this.f2867a = flowCollector;
            this.f2868b = c2780j;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public final Object emit(Object obj, @NotNull Continuation continuation) {
            C8144a c8144a;
            boolean z;
            if (continuation instanceof C8144a) {
                c8144a = (C8144a) continuation;
                int i = c8144a.f2870b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c8144a.f2870b = i - Integer.MIN_VALUE;
                } else {
                    c8144a = new C8144a(continuation);
                }
            } else {
                c8144a = new C8144a(continuation);
            }
            Object obj2 = c8144a.f2869a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c8144a.f2870b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector flowCollector = this.f2867a;
                AbstractC2730e.a builder = (AbstractC2730e.a) obj;
                C2780j c2780j = this.f2868b;
                c2780j.getClass();
                Intrinsics.checkNotNullParameter(builder, "builder");
                boolean z2 = false;
                if (((C2926x5) c2780j.f2752a).f3234f) {
                    if (builder.f2557a != 0) {
                        z = true;
                    } else {
                        z = c2780j.f2760i;
                        c2780j.f2760i = false;
                    }
                    if (z) {
                        z2 = true;
                    }
                }
                if (z2) {
                    c8144a.f2870b = 1;
                    if (flowCollector.emit(obj, c8144a) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public C2810m(Flow flow, C2780j c2780j) {
        this.f2865a = flow;
        this.f2866b = c2780j;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super AbstractC2730e.a<?>> flowCollector, @NotNull Continuation continuation) {
        Object objCollect = this.f2865a.collect(new a(flowCollector, this.f2866b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
