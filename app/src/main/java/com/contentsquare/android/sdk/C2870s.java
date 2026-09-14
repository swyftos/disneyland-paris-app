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
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class C2870s implements Flow<JSONObject> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Flow f3082a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2780j f3083b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.s$a */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n54#2:223\n82#3:224\n*E\n"})
    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ FlowCollector f3084a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2780j f3085b;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.s$a$a, reason: collision with other inner class name */
        @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$map$6$2", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        public static final class C8153a extends ContinuationImpl {

            /* JADX INFO: renamed from: a */
            public /* synthetic */ Object f3086a;

            /* JADX INFO: renamed from: b */
            public int f3087b;

            public C8153a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f3086a = obj;
                this.f3087b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector, C2780j c2780j) {
            this.f3084a = flowCollector;
            this.f3085b = c2780j;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public final Object emit(Object obj, @NotNull Continuation continuation) {
            C8153a c8153a;
            JSONObject jSONObjectM904b;
            if (continuation instanceof C8153a) {
                c8153a = (C8153a) continuation;
                int i = c8153a.f3087b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c8153a.f3087b = i - Integer.MIN_VALUE;
                } else {
                    c8153a = new C8153a(continuation);
                }
            } else {
                c8153a = new C8153a(continuation);
            }
            Object obj2 = c8153a.f3086a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c8153a.f3087b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector flowCollector = this.f3084a;
                AbstractC2730e abstractC2730e = (AbstractC2730e) obj;
                C2780j c2780j = this.f3085b;
                c2780j.getClass();
                try {
                    jSONObjectM904b = C2479E2.m904b(abstractC2730e);
                    if (jSONObjectM904b != null) {
                        abstractC2730e.mo856a();
                        c2780j.f2753b.m827d("Pushing event: [ " + jSONObjectM904b + " ] through the stream");
                    } else {
                        jSONObjectM904b = null;
                    }
                } catch (Throwable th) {
                    c2780j.f2753b.m830e(th, "Pipeline processing of an action event builder failed!");
                }
                c8153a.f3087b = 1;
                if (flowCollector.emit(jSONObjectM904b, c8153a) == coroutine_suspended) {
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

    public C2870s(Flow flow, C2780j c2780j) {
        this.f3082a = flow;
        this.f3083b = c2780j;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super JSONObject> flowCollector, @NotNull Continuation continuation) {
        Object objCollect = this.f3082a.collect(new a(flowCollector, this.f3083b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
