package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
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
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPublicUsageAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublicUsageAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/PublicUsageAgent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n1#2:133\n1855#3,2:134\n*S KotlinDebug\n*F\n+ 1 PublicUsageAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/PublicUsageAgent\n*L\n72#1:134,2\n*E\n"})
public final class C2745f4 implements InterfaceC2698a7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2738e7 f2614a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2748f7 f2615b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final PreferencesStore f2616c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final CoroutineScope f2617d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public Job f2618e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final LinkedHashMap f2619f;

    /* JADX INFO: renamed from: g */
    public boolean f2620g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final EnumC2760h f2621h;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f4$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", m1845f = "PublicUsageAgent.kt", m1846i = {0}, m1847l = {EACTags.DISPLAY_IMAGE, 71}, m1848m = "collect", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2745f4 f2622a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2623b;

        /* JADX INFO: renamed from: d */
        public int f2625d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2623b = obj;
            this.f2625d |= Integer.MIN_VALUE;
            return C2745f4.this.mo893b(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f4$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent$reset$1", m1845f = "PublicUsageAgent.kt", m1846i = {}, m1847l = {EACTags.ANSWER_TO_RESET}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2626a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2745f4.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2745f4.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2626a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2748f7 c2748f7 = C2745f4.this.f2615b;
                this.f2626a = 1;
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f4$c */
    public /* synthetic */ class c extends AdaptedFunctionReference implements Function2<InterfaceC2421a, Continuation<? super Unit>, Object>, SuspendFunction {
        public c(InterfaceC2698a7 interfaceC2698a7) {
            super(2, interfaceC2698a7, C2745f4.class, "store", "store(Lcom/contentsquare/android/internal/core/telemetry/event/TelemetryEvent;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InterfaceC2421a interfaceC2421a, Continuation<? super Unit> continuation) {
            InterfaceC2421a interfaceC2421a2 = interfaceC2421a;
            C2745f4 c2745f4 = (C2745f4) this.receiver;
            InterfaceC2421a interfaceC2421a3 = (InterfaceC2421a) c2745f4.f2619f.get(interfaceC2421a2.getKey());
            LinkedHashMap linkedHashMap = c2745f4.f2619f;
            if (interfaceC2421a3 != null) {
                linkedHashMap.put(interfaceC2421a2.getKey(), interfaceC2421a3.mo839a(interfaceC2421a2));
            } else {
                linkedHashMap.put(interfaceC2421a2.getKey(), interfaceC2421a2);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f4$d */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", m1845f = "PublicUsageAgent.kt", m1846i = {0}, m1847l = {91}, m1848m = "stop", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2745f4 f2628a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f2629b;

        /* JADX INFO: renamed from: d */
        public int f2631d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2629b = obj;
            this.f2631d |= Integer.MIN_VALUE;
            return C2745f4.this.mo891a(this);
        }
    }

    public C2745f4() {
        throw null;
    }

    public C2745f4(C2738e7 eventCollector, C2748f7 eventStorage, PreferencesStore preferencesStore) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(eventCollector, "eventCollector");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f2614a = eventCollector;
        this.f2615b = eventStorage;
        this.f2616c = preferencesStore;
        this.f2617d = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.f2619f = new LinkedHashMap();
        this.f2621h = EnumC2760h.API_USAGE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo890a() {
        return this.f2620g ? 1 : 2;
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
            int i = aVar.f2625d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f2625d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objMo1132a = aVar.f2623b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f2625d;
        if (i2 != 0) {
            if (i2 == 1) {
                this = aVar.f2622a;
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
        if (this.f2620g) {
            aVar.f2622a = this;
            aVar.f2625d = 1;
            if (mo891a(aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        C2748f7 c2748f7 = this.f2615b;
        aVar.f2622a = null;
        aVar.f2625d = 2;
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
        this.f2619f.clear();
        BuildersKt__Builders_commonKt.launch$default(this.f2617d, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    public final void start() {
        if (this.f2620g || !C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_PUBLIC_USAGE)) {
            return;
        }
        PreferencesStore preferencesStore = this.f2616c;
        PreferencesKey preferencesKey = PreferencesKey.TELEMETRY_PUBLIC_USAGE_RATE;
        int iNextInt = preferencesStore.getInt(preferencesKey, -1);
        if (iNextInt == -1) {
            iNextInt = Random.INSTANCE.nextInt(100);
            this.f2616c.putInt(preferencesKey, iNextInt);
        }
        if (iNextInt < 0 || iNextInt >= 11) {
            return;
        }
        this.f2618e = FlowKt.launchIn(FlowKt.onEach(this.f2614a.m1124a(), new c(this)), this.f2617d);
        this.f2620g = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object mo891a(@NotNull Continuation<? super Unit> continuation) {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.f2631d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.f2631d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.f2629b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.f2631d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f2620g) {
                Job job = this.f2618e;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                dVar.f2628a = this;
                dVar.f2631d = 1;
                if (m1127c(dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = dVar.f2628a;
        ResultKt.throwOnFailure(obj);
        this.f2620g = false;
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final EnumC2760h mo892b() {
        return this.f2621h;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: c */
    public final Object m1127c(Continuation<? super Unit> continuation) {
        C2755g4 c2755g4;
        if (continuation instanceof C2755g4) {
            c2755g4 = (C2755g4) continuation;
            int i = c2755g4.f2668d;
            if ((i & Integer.MIN_VALUE) != 0) {
                c2755g4.f2668d = i - Integer.MIN_VALUE;
            } else {
                c2755g4 = new C2755g4(this, continuation);
            }
        } else {
            c2755g4 = new C2755g4(this, continuation);
        }
        Object obj = c2755g4.f2666b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c2755g4.f2668d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f2619f.isEmpty()) {
                return Unit.INSTANCE;
            }
            C2748f7 c2748f7 = this.f2615b;
            List<? extends InterfaceC2421a> list = CollectionsKt.toList(this.f2619f.values());
            c2755g4.f2665a = this;
            c2755g4.f2668d = 1;
            if (c2748f7.mo1130a(list, c2755g4) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = c2755g4.f2665a;
            ResultKt.throwOnFailure(obj);
        }
        this.f2619f.clear();
        return Unit.INSTANCE;
    }
}
