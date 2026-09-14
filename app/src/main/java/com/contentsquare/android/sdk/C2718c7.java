package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.core.telemetry.event.InterfaceC2421a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTelemetryEventAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryEventAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TelemetryEventAgent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1#2:101\n1855#3,2:102\n*S KotlinDebug\n*F\n+ 1 TelemetryEventAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TelemetryEventAgent\n*L\n60#1:102,2\n*E\n"})
public final class C2718c7 implements InterfaceC2698a7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2738e7 f2459a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2748f7 f2460b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final EnumC2760h f2461c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final CoroutineScope f2462d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public Job f2463e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final LinkedHashMap f2464f;

    /* JADX INFO: renamed from: g */
    public boolean f2465g;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c7$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TelemetryEventAgent", m1845f = "TelemetryEventAgent.kt", m1846i = {0}, m1847l = {57, EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m1848m = "collect", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2718c7 f2466a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2467b;

        /* JADX INFO: renamed from: d */
        public int f2469d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2467b = obj;
            this.f2469d |= Integer.MIN_VALUE;
            return C2718c7.this.mo893b(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c7$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TelemetryEventAgent$reset$1", m1845f = "TelemetryEventAgent.kt", m1846i = {}, m1847l = {EACTags.DISPLAY_IMAGE}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2470a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2718c7.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2718c7.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2470a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2748f7 c2748f7 = C2718c7.this.f2460b;
                this.f2470a = 1;
                if (c2748f7.clear() == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c7$c */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TelemetryEventAgent$start$1", m1845f = "TelemetryEventAgent.kt", m1846i = {}, m1847l = {48}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2472a;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.c7$c$a */
        public /* synthetic */ class a extends AdaptedFunctionReference implements Function2<InterfaceC2421a, Continuation<? super Unit>, Object>, SuspendFunction {
            public a(InterfaceC2698a7 interfaceC2698a7) {
                super(2, interfaceC2698a7, C2718c7.class, "store", "store(Lcom/contentsquare/android/internal/core/telemetry/event/TelemetryEvent;)V", 4);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(InterfaceC2421a interfaceC2421a, Continuation<? super Unit> continuation) {
                InterfaceC2421a interfaceC2421a2 = interfaceC2421a;
                C2718c7 c2718c7 = (C2718c7) this.receiver;
                InterfaceC2421a interfaceC2421a3 = (InterfaceC2421a) c2718c7.f2464f.get(interfaceC2421a2.getKey());
                LinkedHashMap linkedHashMap = c2718c7.f2464f;
                if (interfaceC2421a3 != null) {
                    linkedHashMap.put(interfaceC2421a2.getKey(), interfaceC2421a3.mo839a(interfaceC2421a2));
                } else {
                    linkedHashMap.put(interfaceC2421a2.getKey(), interfaceC2421a2);
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
            return C2718c7.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2718c7.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2472a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnEach = FlowKt.onEach(C2718c7.this.f2459a.m1124a(), new a(C2718c7.this));
                this.f2472a = 1;
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c7$d */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TelemetryEventAgent", m1845f = "TelemetryEventAgent.kt", m1846i = {0}, m1847l = {79}, m1848m = "stop", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2718c7 f2474a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2475b;

        /* JADX INFO: renamed from: d */
        public int f2477d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2475b = obj;
            this.f2477d |= Integer.MIN_VALUE;
            return C2718c7.this.mo891a(this);
        }
    }

    public C2718c7() {
        throw null;
    }

    public C2718c7(C2738e7 eventCollector, C2748f7 eventStorage) {
        EnumC2760h agentType = EnumC2760h.CUSTOM_EVENT;
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(eventCollector, "eventCollector");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(agentType, "agentType");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f2459a = eventCollector;
        this.f2460b = eventStorage;
        this.f2461c = agentType;
        this.f2462d = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.f2464f = new LinkedHashMap();
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo890a() {
        return this.f2465g ? 1 : 2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006b A[LOOP:0: B:25:0x0065->B:27:0x006b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: b */
    public final Object mo893b(@NotNull Continuation<? super JSONObject> continuation) {
        a aVar;
        JSONObject jSONObject;
        Iterator it;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f2469d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f2469d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objMo1132a = aVar.f2467b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f2469d;
        if (i2 != 0) {
            if (i2 == 1) {
                this = aVar.f2466a;
                ResultKt.throwOnFailure(objMo1132a);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo1132a);
            }
            jSONObject = new JSONObject();
            it = ((List) objMo1132a).iterator();
            while (it.hasNext()) {
                ((InterfaceC2421a) it.next()).mo840a(jSONObject);
            }
            return jSONObject;
        }
        ResultKt.throwOnFailure(objMo1132a);
        if (this.f2465g) {
            aVar.f2466a = this;
            aVar.f2469d = 1;
            if (mo891a(aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        C2748f7 c2748f7 = this.f2460b;
        aVar.f2466a = null;
        aVar.f2469d = 2;
        objMo1132a = c2748f7.mo1132a(aVar);
        if (objMo1132a == coroutine_suspended) {
            return coroutine_suspended;
        }
        jSONObject = new JSONObject();
        it = ((List) objMo1132a).iterator();
        while (it.hasNext()) {
            ((InterfaceC2421a) it.next()).mo840a(jSONObject);
        }
        return jSONObject;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    /* JADX INFO: renamed from: c */
    public final void mo894c() {
        this.f2464f.clear();
        BuildersKt__Builders_commonKt.launch$default(this.f2462d, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    public final void start() {
        if (this.f2465g) {
            return;
        }
        this.f2463e = BuildersKt__Builders_commonKt.launch$default(this.f2462d, null, null, new c(null), 3, null);
        this.f2465g = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object mo891a(@NotNull Continuation<? super Unit> continuation) {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.f2477d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.f2477d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.f2475b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.f2477d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f2465g) {
                Job job = this.f2463e;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                dVar.f2474a = this;
                dVar.f2477d = 1;
                if (m1112c(dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = dVar.f2474a;
        ResultKt.throwOnFailure(obj);
        this.f2465g = false;
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final EnumC2760h mo892b() {
        return this.f2461c;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: c */
    public final Object m1112c(Continuation<? super Unit> continuation) {
        C2728d7 c2728d7;
        if (continuation instanceof C2728d7) {
            c2728d7 = (C2728d7) continuation;
            int i = c2728d7.f2529d;
            if ((i & Integer.MIN_VALUE) != 0) {
                c2728d7.f2529d = i - Integer.MIN_VALUE;
            } else {
                c2728d7 = new C2728d7(this, continuation);
            }
        } else {
            c2728d7 = new C2728d7(this, continuation);
        }
        Object obj = c2728d7.f2527b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c2728d7.f2529d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f2464f.isEmpty()) {
                return Unit.INSTANCE;
            }
            C2748f7 c2748f7 = this.f2460b;
            List<? extends InterfaceC2421a> list = CollectionsKt.toList(this.f2464f.values());
            c2728d7.f2526a = this;
            c2728d7.f2529d = 1;
            if (c2748f7.mo1130a(list, c2728d7) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = c2728d7.f2526a;
            ResultKt.throwOnFailure(obj);
        }
        this.f2464f.clear();
        return Unit.INSTANCE;
    }
}
