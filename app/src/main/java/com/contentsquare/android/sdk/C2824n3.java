package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.http.HttpResponse;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nNetworkCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,32:1\n53#2:33\n55#2:37\n50#3:34\n55#3:36\n107#4:35\n*S KotlinDebug\n*F\n+ 1 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n*L\n19#1:33\n19#1:37\n19#1:34\n19#1:36\n19#1:35\n*E\n"})
public final class C2824n3 implements InterfaceC2600Q3<C2844p3> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final a f2902a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.n3$a */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class a implements Flow<C2844p3> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Flow f2903a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2824n3 f2904b;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.n3$a$a, reason: collision with other inner class name */
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 NetworkCollector.kt\ncom/contentsquare/android/internal/core/telemetry/performance/NetworkCollector\n*L\n1#1,222:1\n54#2:223\n19#3:224\n*E\n"})
        public static final class C8147a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ FlowCollector f2905a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ C2824n3 f2906b;

            /* JADX INFO: renamed from: com.contentsquare.android.sdk.n3$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.performance.NetworkCollector$special$$inlined$map$1$2", m1845f = "NetworkCollector.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            public static final class C8148a extends ContinuationImpl {

                /* JADX INFO: renamed from: a */
                public /* synthetic */ Object f2907a;

                /* JADX INFO: renamed from: b */
                public int f2908b;

                public C8148a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f2907a = obj;
                    this.f2908b |= Integer.MIN_VALUE;
                    return C8147a.this.emit(null, this);
                }
            }

            public C8147a(FlowCollector flowCollector, C2824n3 c2824n3) {
                this.f2905a = flowCollector;
                this.f2906b = c2824n3;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public final Object emit(Object obj, @NotNull Continuation continuation) {
                C8148a c8148a;
                if (continuation instanceof C8148a) {
                    c8148a = (C8148a) continuation;
                    int i = c8148a.f2908b;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c8148a.f2908b = i - Integer.MIN_VALUE;
                    } else {
                        c8148a = new C8148a(continuation);
                    }
                } else {
                    c8148a = new C8148a(continuation);
                }
                Object obj2 = c8148a.f2907a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c8148a.f2908b;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    FlowCollector flowCollector = this.f2905a;
                    HttpResponse httpResponse = (HttpResponse) obj;
                    this.f2906b.getClass();
                    C2844p3 c2844p3 = new C2844p3(httpResponse.getEndpoint(), httpResponse.getDataSentBytes(), httpResponse.getDataReceivedBytes(), httpResponse.getException() != null);
                    c8148a.f2908b = 1;
                    if (flowCollector.emit(c2844p3, c8148a) == coroutine_suspended) {
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

        public a(Flow flow, C2824n3 c2824n3) {
            this.f2903a = flow;
            this.f2904b = c2824n3;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @Nullable
        public final Object collect(@NotNull FlowCollector<? super C2844p3> flowCollector, @NotNull Continuation continuation) {
            Object objCollect = this.f2903a.collect(new C8147a(flowCollector, this.f2904b), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public C2824n3(@NotNull Flow<HttpResponse> networkFlow) {
        Intrinsics.checkNotNullParameter(networkFlow, "networkFlow");
        this.f2902a = new a(networkFlow, this);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2600Q3
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Flow<C2844p3> mo900a() {
        return this.f2902a;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2600Q3
    @NotNull
    public final String getName() {
        return TCEventPropertiesNames.TCN_NETWORK;
    }
}
