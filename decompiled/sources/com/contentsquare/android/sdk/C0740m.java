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
/* renamed from: com.contentsquare.android.sdk.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0740m implements Flow<AbstractC0660e.a<?>> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ C0710j b;

    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n1#1,222:1\n22#2:223\n23#2:225\n70#3:224\n*E\n"})
    /* renamed from: com.contentsquare.android.sdk.m$a */
    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector a;
        public final /* synthetic */ C0710j b;

        @DebugMetadata(c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$special$$inlined$filter$1$2", f = "AnalyticsPipeline.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        /* renamed from: com.contentsquare.android.sdk.m$a$a, reason: collision with other inner class name */
        public static final class C0048a extends ContinuationImpl {
            public /* synthetic */ Object a;
            public int b;

            public C0048a(Continuation continuation) {
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
        public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.contentsquare.android.sdk.C0740m.a.C0048a
                if (r0 == 0) goto L13
                r0 = r8
                com.contentsquare.android.sdk.m$a$a r0 = (com.contentsquare.android.sdk.C0740m.a.C0048a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                com.contentsquare.android.sdk.m$a$a r0 = new com.contentsquare.android.sdk.m$a$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r8)
                goto L64
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlinx.coroutines.flow.FlowCollector r8 = r6.a
                r2 = r7
                com.contentsquare.android.sdk.e$a r2 = (com.contentsquare.android.sdk.AbstractC0660e.a) r2
                com.contentsquare.android.sdk.j r6 = r6.b
                r6.getClass()
                java.lang.String r4 = "builder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
                com.contentsquare.android.sdk.y2 r4 = r6.a
                com.contentsquare.android.sdk.x5 r4 = (com.contentsquare.android.sdk.C0853x5) r4
                boolean r4 = r4.f
                r5 = 0
                if (r4 == 0) goto L59
                int r2 = r2.a
                if (r2 == 0) goto L52
                r2 = r3
                goto L56
            L52:
                boolean r2 = r6.i
                r6.i = r5
            L56:
                if (r2 == 0) goto L59
                r5 = r3
            L59:
                if (r5 == 0) goto L64
                r0.b = r3
                java.lang.Object r6 = r8.emit(r7, r0)
                if (r6 != r1) goto L64
                return r1
            L64:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0740m.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public C0740m(Flow flow, C0710j c0710j) {
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
