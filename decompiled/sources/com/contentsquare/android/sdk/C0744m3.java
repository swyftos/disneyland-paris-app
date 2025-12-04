package com.contentsquare.android.sdk;

import ch.qos.logback.classic.spi.CallerData;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.m3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0744m3 implements InterfaceC0628a7 {

    @NotNull
    public final Q3<C0774p3> a;

    @NotNull
    public final PreferencesStore b;

    @NotNull
    public final LinkedHashMap c;

    @NotNull
    public final CoroutineScope d;

    @Nullable
    public Job e;
    public boolean f;

    @NotNull
    public final Lazy g;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.NetworkAgent$start$1", f = "NetworkAgent.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.m3$a */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        /* renamed from: com.contentsquare.android.sdk.m3$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0049a extends AdaptedFunctionReference implements Function2<C0774p3, Continuation<? super Unit>, Object>, SuspendFunction {
            public C0049a(InterfaceC0628a7 interfaceC0628a7) {
                super(2, interfaceC0628a7, C0744m3.class, "store", "store(Lcom/contentsquare/android/internal/core/telemetry/event/NetworkMetric;)V", 4);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(C0774p3 c0774p3, Continuation<? super Unit> continuation) {
                C0774p3 c0774p32 = c0774p3;
                C0744m3 c0744m3 = (C0744m3) this.receiver;
                C0744m3.a(c0744m3.c, StringsKt.substringBefore$default(c0774p32.d, CallerData.NA, (String) null, 2, (Object) null) + ".upload", c0774p32.a);
                C0744m3.a(c0744m3.c, StringsKt.substringBefore$default(c0774p32.d, CallerData.NA, (String) null, 2, (Object) null) + ".download", c0774p32.b);
                if (c0774p32.c) {
                    C0744m3.a(c0744m3.c, StringsKt.substringBefore$default(c0774p32.d, CallerData.NA, (String) null, 2, (Object) null) + ".failure", 1L);
                } else {
                    C0744m3.a(c0744m3.c, StringsKt.substringBefore$default(c0774p32.d, CallerData.NA, (String) null, 2, (Object) null) + ".success", 1L);
                }
                return Unit.INSTANCE;
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C0744m3.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C0744m3.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnEach = FlowKt.onEach(C0744m3.this.a.a(), new C0049a(C0744m3.this));
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

    public C0744m3() {
        throw null;
    }

    public C0744m3(C0754n3 networkMetricProvider, PreferencesStore preferencesStore) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(networkMetricProvider, "networkMetricProvider");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.a = networkMetricProvider;
        this.b = preferencesStore;
        this.c = new LinkedHashMap();
        this.d = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.g = LazyKt.lazy(C0734l3.a);
    }

    public static void a(Map map, String str, long j) {
        if (j <= 0) {
            return;
        }
        Long l = (Long) map.get(str);
        map.put(str, Long.valueOf((l != null ? l.longValue() : 0L) + j));
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @Nullable
    public final Object b(@NotNull Continuation<? super JSONObject> continuation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String name = this.a.getName();
        LinkedHashMap linkedHashMap = this.c;
        Intrinsics.checkNotNull(linkedHashMap, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        JSONObject jSONObjectPut = jSONObject.put(name, new JSONObject(linkedHashMap));
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(network…ct(storage as Map<*, *>))");
        return jSONObjectPut;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
        if (this.f) {
            this.c.clear();
        }
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() {
        if (this.f || !C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_NETWORK)) {
            return;
        }
        PreferencesStore preferencesStore = this.b;
        PreferencesKey preferencesKey = PreferencesKey.TELEMETRY_NETWORK_MONITORING_RATE;
        int iNextInt = preferencesStore.getInt(preferencesKey, -1);
        if (iNextInt == -1) {
            iNextInt = Random.INSTANCE.nextInt(100);
            this.b.putInt(preferencesKey, iNextInt);
        }
        if (iNextInt < 0 || iNextInt >= 11) {
            return;
        }
        ((Logger) this.g.getValue()).d("Start collecting Network Metrics");
        this.e = BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(null), 3, null);
        this.f = true;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.f ? 1 : 2;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return EnumC0690h.NETWORK;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @Nullable
    public final Object a(@NotNull Continuation<? super Unit> continuation) {
        if (this.f) {
            Job job = this.e;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.f = false;
            ((Logger) this.g.getValue()).d("Stop collecting Network Metrics");
        }
        return Unit.INSTANCE;
    }
}
