package com.contentsquare.android.sdk;

import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class O3 implements InterfaceC0628a7 {

    @NotNull
    public final Q3<Float> a;

    @NotNull
    public final InterfaceC0797r7<StatisticRecord> b;

    @NotNull
    public final CoroutineScope c;

    @Nullable
    public Job d;

    @NotNull
    public final ArrayList e;

    @NotNull
    public final Lazy f;
    public boolean g;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", f = "PerformanceAgent.kt", i = {0, 1}, l = {72, EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m = "collect", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class a extends ContinuationImpl {
        public O3 a;
        public JSONObject b;
        public String c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return O3.this.b(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent$reset$1", f = "PerformanceAgent.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return O3.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return O3.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0797r7<StatisticRecord> interfaceC0797r7 = O3.this.b;
                this.a = 1;
                if (interfaceC0797r7.clear() == coroutine_suspended) {
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

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent$start$1", f = "PerformanceAgent.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public /* synthetic */ class a extends AdaptedFunctionReference implements Function2<Float, Continuation<? super Unit>, Object>, SuspendFunction {
            public a(InterfaceC0628a7 interfaceC0628a7) {
                super(2, interfaceC0628a7, O3.class, "store", "store(F)V", 4);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Float f, Continuation<? super Unit> continuation) {
                float fFloatValue = f.floatValue();
                O3 o3 = (O3) this.receiver;
                if (fFloatValue == BitmapDescriptorFactory.HUE_RED) {
                    o3.getClass();
                } else if (o3.e.size() < 300) {
                    o3.e.add(Float.valueOf(fFloatValue));
                } else {
                    o3.e.set(Random.INSTANCE.nextInt(o3.e.size() - 1), Float.valueOf(fFloatValue));
                }
                return Unit.INSTANCE;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return O3.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return O3.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnEach = FlowKt.onEach(O3.this.a.a(), new a(O3.this));
                this.a = 1;
                if (FlowKt.collect(flowOnEach, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", f = "PerformanceAgent.kt", i = {0}, l = {95}, m = "stop", n = {"this"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {
        public O3 a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return O3.this.a(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", f = "PerformanceAgent.kt", i = {0}, l = {SyslogConstants.LOG_CLOCK}, m = "storeOnDisk", n = {"this"}, s = {"L$0"})
    public static final class e extends ContinuationImpl {
        public O3 a;
        public /* synthetic */ Object b;
        public int d;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return O3.this.c(this);
        }
    }

    public O3() {
        throw null;
    }

    public O3(Q3 performanceCollector, C0788q7 storage) {
        CoroutineDispatcher dispatcher = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(performanceCollector, "performanceCollector");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.a = performanceCollector;
        this.b = storage;
        this.c = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.e = new ArrayList();
        this.f = LazyKt.lazy(P3.a);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.g ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super org.json.JSONObject> r7) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.O3.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
        this.e.clear();
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() {
        if (this.g) {
            return;
        }
        ((Logger) this.f.getValue()).d("Start collecting " + this.a.getName() + " usage");
        this.d = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new c(null), 3, null);
        this.g = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.O3.d
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.O3$d r0 = (com.contentsquare.android.sdk.O3.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.O3$d r0 = new com.contentsquare.android.sdk.O3$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.contentsquare.android.sdk.O3 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4d
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.g
            if (r5 == 0) goto L74
            kotlinx.coroutines.Job r5 = r4.d
            if (r5 == 0) goto L42
            r2 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r5, r2, r3, r2)
        L42:
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r4.c(r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            r5 = 0
            r4.g = r5
            kotlin.Lazy r5 = r4.f
            java.lang.Object r5 = r5.getValue()
            com.contentsquare.android.core.features.logging.Logger r5 = (com.contentsquare.android.core.features.logging.Logger) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Stop collecting "
            r0.<init>(r1)
            com.contentsquare.android.sdk.Q3<java.lang.Float> r4 = r4.a
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = " usage"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.d(r4)
        L74:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.O3.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instructions count: 1169
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.O3.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return EnumC0690h.PERFORMANCE;
    }
}
