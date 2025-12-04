package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.util.LinkedHashMap;
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

@SourceDebugExtension({"SMAP\nPublicUsageAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublicUsageAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/PublicUsageAgent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n1#2:133\n1855#3,2:134\n*S KotlinDebug\n*F\n+ 1 PublicUsageAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/PublicUsageAgent\n*L\n72#1:134,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.f4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0675f4 implements InterfaceC0628a7 {

    @NotNull
    public final C0668e7 a;

    @NotNull
    public final C0678f7 b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final CoroutineScope d;

    @Nullable
    public Job e;

    @NotNull
    public final LinkedHashMap f;
    public boolean g;

    @NotNull
    public final EnumC0690h h;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", f = "PublicUsageAgent.kt", i = {0}, l = {EACTags.DISPLAY_IMAGE, 71}, m = "collect", n = {"this"}, s = {"L$0"})
    /* renamed from: com.contentsquare.android.sdk.f4$a */
    public static final class a extends ContinuationImpl {
        public C0675f4 a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C0675f4.this.b(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent$reset$1", f = "PublicUsageAgent.kt", i = {}, l = {EACTags.ANSWER_TO_RESET}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.f4$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C0675f4.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C0675f4.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0678f7 c0678f7 = C0675f4.this.b;
                this.a = 1;
                if (c0678f7.clear() == coroutine_suspended) {
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

    /* renamed from: com.contentsquare.android.sdk.f4$c */
    public /* synthetic */ class c extends AdaptedFunctionReference implements Function2<com.contentsquare.android.internal.core.telemetry.event.a, Continuation<? super Unit>, Object>, SuspendFunction {
        public c(InterfaceC0628a7 interfaceC0628a7) {
            super(2, interfaceC0628a7, C0675f4.class, "store", "store(Lcom/contentsquare/android/internal/core/telemetry/event/TelemetryEvent;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(com.contentsquare.android.internal.core.telemetry.event.a aVar, Continuation<? super Unit> continuation) {
            com.contentsquare.android.internal.core.telemetry.event.a aVar2 = aVar;
            C0675f4 c0675f4 = (C0675f4) this.receiver;
            com.contentsquare.android.internal.core.telemetry.event.a aVar3 = (com.contentsquare.android.internal.core.telemetry.event.a) c0675f4.f.get(aVar2.getKey());
            LinkedHashMap linkedHashMap = c0675f4.f;
            if (aVar3 != null) {
                linkedHashMap.put(aVar2.getKey(), aVar3.a(aVar2));
            } else {
                linkedHashMap.put(aVar2.getKey(), aVar2);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", f = "PublicUsageAgent.kt", i = {0}, l = {91}, m = "stop", n = {"this"}, s = {"L$0"})
    /* renamed from: com.contentsquare.android.sdk.f4$d */
    public static final class d extends ContinuationImpl {
        public C0675f4 a;
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
            return C0675f4.this.a(this);
        }
    }

    public C0675f4() {
        throw null;
    }

    public C0675f4(C0668e7 eventCollector, C0678f7 eventStorage, PreferencesStore preferencesStore) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(eventCollector, "eventCollector");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.a = eventCollector;
        this.b = eventStorage;
        this.c = preferencesStore;
        this.d = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.f = new LinkedHashMap();
        this.h = EnumC0690h.API_USAGE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.g ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[LOOP:0: B:25:0x0065->B:27:0x006b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super org.json.JSONObject> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.contentsquare.android.sdk.C0675f4.a
            if (r0 == 0) goto L13
            r0 = r6
            com.contentsquare.android.sdk.f4$a r0 = (com.contentsquare.android.sdk.C0675f4.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.f4$a r0 = new com.contentsquare.android.sdk.f4$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            com.contentsquare.android.sdk.f4 r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.g
            if (r6 == 0) goto L4c
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            com.contentsquare.android.sdk.f7 r5 = r5.b
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L5a
            return r1
        L5a:
            java.util.List r6 = (java.util.List) r6
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L75
            java.lang.Object r0 = r6.next()
            com.contentsquare.android.internal.core.telemetry.event.a r0 = (com.contentsquare.android.internal.core.telemetry.event.a) r0
            r0.a(r5)
            goto L65
        L75:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0675f4.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
        this.f.clear();
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() {
        if (this.g || !C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_PUBLIC_USAGE)) {
            return;
        }
        PreferencesStore preferencesStore = this.c;
        PreferencesKey preferencesKey = PreferencesKey.TELEMETRY_PUBLIC_USAGE_RATE;
        int iNextInt = preferencesStore.getInt(preferencesKey, -1);
        if (iNextInt == -1) {
            iNextInt = Random.INSTANCE.nextInt(100);
            this.c.putInt(preferencesKey, iNextInt);
        }
        if (iNextInt < 0 || iNextInt >= 11) {
            return;
        }
        this.e = FlowKt.launchIn(FlowKt.onEach(this.a.a(), new c(this)), this.d);
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
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.C0675f4.d
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.f4$d r0 = (com.contentsquare.android.sdk.C0675f4.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.f4$d r0 = new com.contentsquare.android.sdk.f4$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.contentsquare.android.sdk.f4 r4 = r0.a
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
            if (r5 == 0) goto L50
            kotlinx.coroutines.Job r5 = r4.e
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
        L50:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0675f4.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.C0685g4
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.g4 r0 = (com.contentsquare.android.sdk.C0685g4) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.g4 r0 = new com.contentsquare.android.sdk.g4
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.contentsquare.android.sdk.f4 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L58
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.LinkedHashMap r5 = r4.f
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L41
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L41:
            com.contentsquare.android.sdk.f7 r5 = r4.b
            java.util.LinkedHashMap r2 = r4.f
            java.util.Collection r2 = r2.values()
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.a(r2, r0)
            if (r5 != r1) goto L58
            return r1
        L58:
            java.util.LinkedHashMap r4 = r4.f
            r4.clear()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0675f4.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
