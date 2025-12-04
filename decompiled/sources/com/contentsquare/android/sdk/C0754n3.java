package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.http.HttpResponse;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
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

@SourceDebugExtension({"SMAP\nNetworkCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,32:1\n53#2:33\n55#2:37\n50#3:34\n55#3:36\n107#4:35\n*S KotlinDebug\n*F\n+ 1 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n*L\n19#1:33\n19#1:37\n19#1:34\n19#1:36\n19#1:35\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.n3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0754n3 implements Q3<C0774p3> {

    @NotNull
    public final a a;

    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    /* renamed from: com.contentsquare.android.sdk.n3$a */
    public static final class a implements Flow<C0774p3> {
        public final /* synthetic */ Flow a;
        public final /* synthetic */ C0754n3 b;

        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n*L\n1#1,222:1\n54#2:223\n19#3:224\n*E\n"})
        /* renamed from: com.contentsquare.android.sdk.n3$a$a, reason: collision with other inner class name */
        public static final class C0051a<T> implements FlowCollector {
            public final /* synthetic */ FlowCollector a;
            public final /* synthetic */ C0754n3 b;

            @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.performance.NetworkCollector$special$$inlined$map$1$2", f = "NetworkCollector.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            /* renamed from: com.contentsquare.android.sdk.n3$a$a$a, reason: collision with other inner class name */
            public static final class C0052a extends ContinuationImpl {
                public /* synthetic */ Object a;
                public int b;

                public C0052a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return C0051a.this.emit(null, this);
                }
            }

            public C0051a(FlowCollector flowCollector, C0754n3 c0754n3) {
                this.a = flowCollector;
                this.b = c0754n3;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r13) {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof com.contentsquare.android.sdk.C0754n3.a.C0051a.C0052a
                    if (r0 == 0) goto L13
                    r0 = r13
                    com.contentsquare.android.sdk.n3$a$a$a r0 = (com.contentsquare.android.sdk.C0754n3.a.C0051a.C0052a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    com.contentsquare.android.sdk.n3$a$a$a r0 = new com.contentsquare.android.sdk.n3$a$a$a
                    r0.<init>(r13)
                L18:
                    java.lang.Object r13 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r13)
                    goto L62
                L29:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L31:
                    kotlin.ResultKt.throwOnFailure(r13)
                    kotlinx.coroutines.flow.FlowCollector r13 = r11.a
                    com.contentsquare.android.core.features.http.HttpResponse r12 = (com.contentsquare.android.core.features.http.HttpResponse) r12
                    com.contentsquare.android.sdk.n3 r11 = r11.b
                    r11.getClass()
                    com.contentsquare.android.sdk.p3 r11 = new com.contentsquare.android.sdk.p3
                    java.lang.String r5 = r12.getEndpoint()
                    long r6 = r12.getDataSentBytes()
                    long r8 = r12.getDataReceivedBytes()
                    java.lang.Throwable r12 = r12.getException()
                    if (r12 == 0) goto L53
                    r10 = r3
                    goto L55
                L53:
                    r12 = 0
                    r10 = r12
                L55:
                    r4 = r11
                    r4.<init>(r5, r6, r8, r10)
                    r0.b = r3
                    java.lang.Object r11 = r13.emit(r11, r0)
                    if (r11 != r1) goto L62
                    return r1
                L62:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0754n3.a.C0051a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public a(Flow flow, C0754n3 c0754n3) {
            this.a = flow;
            this.b = c0754n3;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @Nullable
        public final Object collect(@NotNull FlowCollector<? super C0774p3> flowCollector, @NotNull Continuation continuation) {
            Object objCollect = this.a.collect(new C0051a(flowCollector, this.b), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public C0754n3(@NotNull Flow<HttpResponse> networkFlow) {
        Intrinsics.checkNotNullParameter(networkFlow, "networkFlow");
        this.a = new a(networkFlow, this);
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final Flow<C0774p3> a() {
        return this.a;
    }

    @Override // com.contentsquare.android.sdk.Q3
    @NotNull
    public final String getName() {
        return TCEventPropertiesNames.TCN_NETWORK;
    }
}
