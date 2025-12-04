package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
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

@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0770p implements Flow<AbstractC0660e.a<?>> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ C0710j b;

    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n54#2:223\n75#3:224\n*E\n"})
    /* renamed from: com.contentsquare.android.sdk.p$a */
    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector a;
        public final /* synthetic */ C0710j b;

        @DebugMetadata(c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$map$3$2", f = "AnalyticsPipeline.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        /* renamed from: com.contentsquare.android.sdk.p$a$a, reason: collision with other inner class name */
        public static final class C0054a extends ContinuationImpl {
            public /* synthetic */ Object a;
            public int b;

            public C0054a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector, C0710j c0710j) {
            this.a = flowCollector;
            this.b = c0710j;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.contentsquare.android.sdk.C0770p.a.C0054a
                if (r0 == 0) goto L13
                r0 = r6
                com.contentsquare.android.sdk.p$a$a r0 = (com.contentsquare.android.sdk.C0770p.a.C0054a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                com.contentsquare.android.sdk.p$a$a r0 = new com.contentsquare.android.sdk.p$a$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r6)
                goto L58
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                com.contentsquare.android.sdk.e$a r5 = (com.contentsquare.android.sdk.AbstractC0660e.a) r5
                com.contentsquare.android.sdk.j r4 = r4.b
                r4.getClass()
                com.contentsquare.android.sdk.B5 r2 = r4.h     // Catch: java.lang.Throwable -> L46
                if (r2 == 0) goto L4e
                com.contentsquare.android.sdk.e$a r4 = r2.a(r5)     // Catch: java.lang.Throwable -> L46
                goto L4f
            L46:
                r5 = move-exception
                com.contentsquare.android.core.features.logging.Logger r4 = r4.b
                java.lang.String r2 = "Pipeline processing of an action event builder failed!"
                r4.e(r5, r2)
            L4e:
                r4 = 0
            L4f:
                r0.b = r3
                java.lang.Object r4 = r6.emit(r4, r0)
                if (r4 != r1) goto L58
                return r1
            L58:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0770p.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public C0770p(Flow flow, C0710j c0710j) {
        this.a = flow;
        this.b = c0710j;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super AbstractC0660e.a<?>> flowCollector, @NotNull Continuation continuation) {
        Object objCollect = this.a.collect(new a(flowCollector, this.b), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
