package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nAnalyticsPipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,247:1\n21#2:248\n23#2:252\n53#2:253\n55#2:257\n53#2:258\n55#2:262\n53#2:263\n55#2:267\n53#2:268\n55#2:272\n53#2:273\n55#2:277\n53#2:278\n55#2:282\n50#3:249\n55#3:251\n50#3:254\n55#3:256\n50#3:259\n55#3:261\n50#3:264\n55#3:266\n50#3:269\n55#3:271\n50#3:274\n55#3:276\n50#3:279\n55#3:281\n107#4:250\n107#4:255\n107#4:260\n107#4:265\n107#4:270\n107#4:275\n107#4:280\n*S KotlinDebug\n*F\n+ 1 AnalyticsPipeline.kt\ncom/contentsquare/android/analytics/internal/pipeline/AnalyticsPipeline\n*L\n70#1:248\n70#1:252\n71#1:253\n71#1:257\n73#1:258\n73#1:262\n75#1:263\n75#1:267\n77#1:268\n77#1:272\n79#1:273\n79#1:277\n82#1:278\n82#1:282\n70#1:249\n70#1:251\n71#1:254\n71#1:256\n73#1:259\n73#1:261\n75#1:264\n75#1:266\n77#1:269\n77#1:271\n79#1:274\n79#1:276\n82#1:279\n82#1:281\n70#1:250\n71#1:255\n73#1:260\n75#1:265\n77#1:270\n79#1:275\n82#1:280\n*E\n"})
public final class C2780j {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final InterfaceC2933y2 f2752a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f2753b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final CoroutineScope f2754c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Channel<AbstractC2730e.a<?>> f2755d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Flow<JSONObject> f2756e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final MutableSharedFlow<JSONObject> f2757f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public Job f2758g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public InterfaceC2452B5 f2759h;

    /* JADX INFO: renamed from: i */
    public boolean f2760i;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.j$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.pipeline.AnalyticsPipeline$emitActionEventBuilder$1", m1845f = "AnalyticsPipeline.kt", m1846i = {}, m1847l = {108}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2761a;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ AbstractC2730e.a<?> f2763c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2730e.a<?> aVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f2763c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2780j.this.new a(this.f2763c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2780j.this.new a(this.f2763c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2761a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel<AbstractC2730e.a<?>> channel = C2780j.this.f2755d;
                AbstractC2730e.a<?> aVar = this.f2763c;
                this.f2761a = 1;
                if (channel.send(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public C2780j(@NotNull C2926x5 trackingState) {
        Intrinsics.checkNotNullParameter(trackingState, "trackingState");
        CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault().limitedParallelism(1);
        Intrinsics.checkNotNullParameter(trackingState, "trackingState");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.f2752a = trackingState;
        this.f2753b = new Logger("AnalyticsPipeline");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcher));
        this.f2754c = CoroutineScope;
        Channel<AbstractC2730e.a<?>> channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f2755d = channelChannel$default;
        this.f2756e = FlowKt.filterNotNull(new C2870s(FlowKt.flowOn(FlowKt.filterNotNull(new C2860r(FlowKt.filterNotNull(new C2850q(FlowKt.filterNotNull(new C2840p(FlowKt.filterNotNull(new C2830o(FlowKt.filterNotNull(new C2820n(new C2810m(FlowKt.receiveAsFlow(channelChannel$default), this), this)), this)), this)), this)), this)), Dispatchers.getMain().getImmediate()), this));
        this.f2757f = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f2760i = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C2770i(this, null), 3, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m1159a(@NotNull AbstractC2730e.a<?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        BuildersKt__Builders_commonKt.launch$default(this.f2754c, Dispatchers.getMain().getImmediate(), null, new a(builder, null), 2, null);
    }
}
