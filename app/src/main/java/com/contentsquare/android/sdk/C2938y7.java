package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTimeAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TimeAgent\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,87:1\n215#2,2:88\n215#2,2:90\n*S KotlinDebug\n*F\n+ 1 TimeAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TimeAgent\n*L\n63#1:88,2\n77#1:90,2\n*E\n"})
public final class C2938y7 implements InterfaceC2698a7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2444A7 f3264a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2888t7 f3265b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f3266c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final CoroutineScope f3267d;

    /* JADX INFO: renamed from: e */
    public boolean f3268e;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.y7$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", m1845f = "TimeAgent.kt", m1846i = {0, 0, 1, 1}, m1847l = {60, PacketTags.EXPERIMENTAL_3}, m1848m = "collect", m1849n = {"this", "timeEventJson", "this", "timeEventJson"}, m1850s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2938y7 f3269a;

        /* JADX INFO: renamed from: b */
        public JSONObject f3270b;

        /* JADX INFO: renamed from: c */
        public /* synthetic */ Object f3271c;

        /* JADX INFO: renamed from: e */
        public int f3273e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f3271c = obj;
            this.f3273e |= Integer.MIN_VALUE;
            return C2938y7.this.mo893b(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.y7$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent$reset$1", m1845f = "TimeAgent.kt", m1846i = {}, m1847l = {EACTags.SEX}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f3274a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2938y7.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2938y7.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3274a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2888t7 c2888t7 = C2938y7.this.f3265b;
                this.f3274a = 1;
                if (c2888t7.clear() == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.y7$c */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", m1845f = "TimeAgent.kt", m1846i = {0}, m1847l = {45}, m1848m = "stop", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2938y7 f3276a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f3277b;

        /* JADX INFO: renamed from: d */
        public int f3279d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f3277b = obj;
            this.f3279d |= Integer.MIN_VALUE;
            return C2938y7.this.mo891a(this);
        }
    }

    public C2938y7(C2444A7 timeCollector, C2888t7 timeStorage) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(timeCollector, "timeCollector");
        Intrinsics.checkNotNullParameter(timeStorage, "timeStorage");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.f3264a = timeCollector;
        this.f3265b = timeStorage;
        this.f3266c = new Logger("TimeAgent");
        this.f3267d = CoroutineScopeKt.CoroutineScope(dispatcher);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo890a() {
        return this.f3268e ? 1 : 2;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: b */
    public final Object mo893b(@NotNull Continuation<? super JSONObject> continuation) {
        a aVar;
        JSONObject jSONObject;
        C2938y7 c2938y7;
        JSONObject jSONObject2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f3273e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f3273e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f3271c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f3273e;
        if (i2 != 0) {
            if (i2 == 1) {
                JSONObject jSONObject3 = aVar.f3270b;
                C2938y7 c2938y8 = aVar.f3269a;
                ResultKt.throwOnFailure(obj);
                jSONObject = jSONObject3;
                this = c2938y8;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject2 = aVar.f3270b;
                c2938y7 = aVar.f3269a;
                ResultKt.throwOnFailure(obj);
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    StatisticRecord statisticRecord = (StatisticRecord) entry.getValue();
                    statisticRecord.getClass();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("median", statisticRecord.f1273a);
                    jSONObject4.put("min", Float.valueOf(statisticRecord.f1274b));
                    jSONObject4.put("p10", Float.valueOf(statisticRecord.f1275c));
                    jSONObject4.put("count", statisticRecord.f1276d);
                    jSONObject4.put("avg", statisticRecord.f1277e);
                    jSONObject4.put("p90", Float.valueOf(statisticRecord.f1278f));
                    jSONObject4.put("max", Float.valueOf(statisticRecord.f1279g));
                    jSONObject2.put(str, jSONObject4);
                } catch (JSONException e) {
                    C2781j0.m1160a(e, new StringBuilder("Failed to create Telemetry time event JSONObject: "), c2938y7.f3266c, e);
                }
            }
            c2938y7.f3266c.m827d("Telemetry time measure collected: " + jSONObject2);
            return jSONObject2;
        }
        ResultKt.throwOnFailure(obj);
        jSONObject = new JSONObject();
        if (this.f3268e) {
            aVar.f3269a = this;
            aVar.f3270b = jSONObject;
            aVar.f3273e = 1;
            if (mo891a(aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        C2888t7 c2888t7 = this.f3265b;
        aVar.f3269a = this;
        aVar.f3270b = jSONObject;
        aVar.f3273e = 2;
        Object objMo1132a = c2888t7.mo1132a(aVar);
        if (objMo1132a == coroutine_suspended) {
            return coroutine_suspended;
        }
        c2938y7 = this;
        jSONObject2 = jSONObject;
        obj = objMo1132a;
        while (r9.hasNext()) {
            String str2 = (String) entry.getKey();
            StatisticRecord statisticRecord2 = (StatisticRecord) entry.getValue();
            statisticRecord2.getClass();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("median", statisticRecord2.f1273a);
            jSONObject5.put("min", Float.valueOf(statisticRecord2.f1274b));
            jSONObject5.put("p10", Float.valueOf(statisticRecord2.f1275c));
            jSONObject5.put("count", statisticRecord2.f1276d);
            jSONObject5.put("avg", statisticRecord2.f1277e);
            jSONObject5.put("p90", Float.valueOf(statisticRecord2.f1278f));
            jSONObject5.put("max", Float.valueOf(statisticRecord2.f1279g));
            jSONObject2.put(str2, jSONObject5);
        }
        c2938y7.f3266c.m827d("Telemetry time measure collected: " + jSONObject2);
        return jSONObject2;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    /* JADX INFO: renamed from: c */
    public final void mo894c() {
        this.f3264a.f1416c.clear();
        BuildersKt__Builders_commonKt.launch$default(this.f3267d, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    public final void start() {
        if (this.f3268e || !C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_TIME)) {
            return;
        }
        this.f3268e = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object mo891a(@NotNull Continuation<? super Unit> continuation) {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.f3279d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.f3279d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.f3277b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.f3279d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f3268e) {
                cVar.f3276a = this;
                cVar.f3279d = 1;
                if (m1237c(cVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = cVar.f3276a;
        ResultKt.throwOnFailure(obj);
        this.f3268e = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: c */
    public final Object m1237c(Continuation<? super Unit> continuation) {
        C2948z7 c2948z7;
        C2938y7 c2938y7;
        double dDoubleValue;
        Object obj;
        double d;
        List list;
        Object obj2;
        Iterator it;
        LinkedHashMap linkedHashMap;
        float f;
        double dDoubleValue2;
        Number numberValueOf;
        Number numberValueOf2;
        List list2;
        LinkedHashMap linkedHashMap2;
        double d2;
        Object obj3;
        double dDoubleValue3;
        Number numberValueOf3;
        Number numberValueOf4;
        StatisticRecord statisticRecord;
        Object obj4;
        LinkedHashMap linkedHashMap3;
        C2938y7 c2938y8 = this;
        if (continuation instanceof C2948z7) {
            c2948z7 = (C2948z7) continuation;
            int i = c2948z7.f3320d;
            if ((i & Integer.MIN_VALUE) != 0) {
                c2948z7.f3320d = i - Integer.MIN_VALUE;
            } else {
                c2948z7 = new C2948z7(c2938y8, continuation);
            }
        } else {
            c2948z7 = new C2948z7(c2938y8, continuation);
        }
        Object obj5 = c2948z7.f3318b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c2948z7.f3320d;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj5);
            if (!c2938y8.f3264a.f1416c.isEmpty()) {
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                Iterator it2 = c2938y8.f3264a.f1416c.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    Object key = entry.getKey();
                    StatisticRecord.C2420a c2420a = StatisticRecord.Companion;
                    List values = (List) entry.getValue();
                    c2420a.getClass();
                    Intrinsics.checkNotNullParameter(values, "values");
                    if (values.isEmpty()) {
                        statisticRecord = new StatisticRecord(0);
                        linkedHashMap3 = linkedHashMap4;
                        obj2 = coroutine_suspended;
                        it = it2;
                        obj4 = key;
                    } else {
                        int size = values.size();
                        List listSorted = CollectionsKt.sorted(values);
                        if (size == 0) {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        } else {
                            if (size == i3) {
                                obj = values.get(0);
                            } else {
                                int i4 = size % 2;
                                int i5 = size / 2;
                                if (i4 == i3) {
                                    obj = listSorted.get(i5);
                                } else {
                                    dDoubleValue = (((Number) listSorted.get(i5 - i3)).doubleValue() + ((Number) listSorted.get(i5)).doubleValue()) / ((double) 2);
                                }
                                d = dDoubleValue;
                            }
                            dDoubleValue = ((Number) obj).doubleValue();
                            d = dDoubleValue;
                        }
                        Long l = (Long) CollectionsKt.minOrNull((Iterable) values);
                        float fLongValue = l != null ? l.longValue() : BitmapDescriptorFactory.HUE_RED;
                        if (values.isEmpty()) {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                obj2 = coroutine_suspended;
                                it = it2;
                                list = values;
                                d = d;
                                dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                linkedHashMap = linkedHashMap4;
                                f = fLongValue;
                                numberValueOf2 = Integer.valueOf((int) dDoubleValue2);
                                numberValueOf = (Long) numberValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                obj2 = coroutine_suspended;
                                it = it2;
                                list = values;
                                d = d;
                                dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                linkedHashMap = linkedHashMap4;
                                f = fLongValue;
                                numberValueOf = Long.valueOf((long) dDoubleValue2);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                obj2 = coroutine_suspended;
                                it = it2;
                                list = values;
                                d = d;
                                dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                linkedHashMap = linkedHashMap4;
                                f = fLongValue;
                                numberValueOf2 = Float.valueOf((float) dDoubleValue2);
                                numberValueOf = (Long) numberValueOf2;
                            } else {
                                Class cls = Double.TYPE;
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                                    obj2 = coroutine_suspended;
                                    it = it2;
                                    list = values;
                                    d = d;
                                    dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    linkedHashMap = linkedHashMap4;
                                    f = fLongValue;
                                    numberValueOf2 = Double.valueOf(dDoubleValue2);
                                    numberValueOf = (Long) numberValueOf2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    obj2 = coroutine_suspended;
                                    it = it2;
                                    list = values;
                                    d = d;
                                    dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    linkedHashMap = linkedHashMap4;
                                    f = fLongValue;
                                    numberValueOf2 = Short.valueOf((short) dDoubleValue2);
                                    numberValueOf = (Long) numberValueOf2;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                        throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls).getSimpleName());
                                    }
                                    obj2 = coroutine_suspended;
                                    it = it2;
                                    list = values;
                                    d = d;
                                    dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    linkedHashMap = linkedHashMap4;
                                    f = fLongValue;
                                    numberValueOf2 = Byte.valueOf((byte) dDoubleValue2);
                                    numberValueOf = (Long) numberValueOf2;
                                }
                            }
                        } else {
                            if (values.size() == i3) {
                                numberValueOf = (Number) values.get(0);
                                obj2 = coroutine_suspended;
                                it = it2;
                                list = values;
                                linkedHashMap = linkedHashMap4;
                            } else {
                                List listSorted2 = CollectionsKt.sorted(values);
                                int size2 = listSorted2.size();
                                list = values;
                                obj2 = coroutine_suspended;
                                it = it2;
                                double d3 = (((double) (size2 + 1)) * 10.0d) / ((double) 100);
                                int iFloor = (int) Math.floor(d3);
                                linkedHashMap = linkedHashMap4;
                                double d4 = d3 - ((double) iFloor);
                                if (d3 < 1.0d) {
                                    numberValueOf = (Number) listSorted2.get(0);
                                } else {
                                    d = d;
                                    f = fLongValue;
                                    if (d3 >= size2) {
                                        numberValueOf = (Number) listSorted2.get(size2 - 1);
                                    } else {
                                        double dDoubleValue4 = ((Number) listSorted2.get(iFloor - 1)).doubleValue();
                                        dDoubleValue2 = ((((Number) listSorted2.get(iFloor)).doubleValue() - dDoubleValue4) * d4) + dDoubleValue4;
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                            numberValueOf2 = Integer.valueOf((int) dDoubleValue2);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                            numberValueOf = Long.valueOf((long) dDoubleValue2);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            numberValueOf2 = Float.valueOf((float) dDoubleValue2);
                                        } else {
                                            Class cls2 = Double.TYPE;
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                                                numberValueOf2 = Double.valueOf(dDoubleValue2);
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                numberValueOf2 = Short.valueOf((short) dDoubleValue2);
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                                    throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls2).getSimpleName());
                                                }
                                                numberValueOf2 = Byte.valueOf((byte) dDoubleValue2);
                                            }
                                        }
                                        numberValueOf = (Long) numberValueOf2;
                                    }
                                }
                            }
                            f = fLongValue;
                        }
                        float fLongValue2 = numberValueOf.longValue();
                        int size3 = list.size();
                        double dAverageOfLong = CollectionsKt.averageOfLong(list);
                        if (list.isEmpty()) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                linkedHashMap2 = linkedHashMap;
                                d2 = dAverageOfLong;
                                obj3 = key;
                                list2 = list;
                                dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                numberValueOf4 = Integer.valueOf((int) dDoubleValue3);
                                numberValueOf3 = (Long) numberValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                linkedHashMap2 = linkedHashMap;
                                d2 = dAverageOfLong;
                                obj3 = key;
                                list2 = list;
                                dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                numberValueOf3 = Long.valueOf((long) dDoubleValue3);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                linkedHashMap2 = linkedHashMap;
                                d2 = dAverageOfLong;
                                obj3 = key;
                                list2 = list;
                                dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                numberValueOf4 = Float.valueOf((float) dDoubleValue3);
                                numberValueOf3 = (Long) numberValueOf4;
                            } else {
                                Class cls3 = Double.TYPE;
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                                    linkedHashMap2 = linkedHashMap;
                                    d2 = dAverageOfLong;
                                    obj3 = key;
                                    list2 = list;
                                    dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    numberValueOf4 = Double.valueOf(dDoubleValue3);
                                    numberValueOf3 = (Long) numberValueOf4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    linkedHashMap2 = linkedHashMap;
                                    d2 = dAverageOfLong;
                                    obj3 = key;
                                    list2 = list;
                                    dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    numberValueOf4 = Short.valueOf((short) dDoubleValue3);
                                    numberValueOf3 = (Long) numberValueOf4;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                        throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls3).getSimpleName());
                                    }
                                    linkedHashMap2 = linkedHashMap;
                                    d2 = dAverageOfLong;
                                    obj3 = key;
                                    list2 = list;
                                    dDoubleValue3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    numberValueOf4 = Byte.valueOf((byte) dDoubleValue3);
                                    numberValueOf3 = (Long) numberValueOf4;
                                }
                            }
                        } else {
                            if (list.size() == 1) {
                                list2 = list;
                                numberValueOf3 = (Number) list2.get(0);
                                linkedHashMap2 = linkedHashMap;
                                d2 = dAverageOfLong;
                            } else {
                                list2 = list;
                                List listSorted3 = CollectionsKt.sorted(list2);
                                int size4 = listSorted3.size();
                                double d5 = (((double) (size4 + 1)) * 90.0d) / ((double) 100);
                                int iFloor2 = (int) Math.floor(d5);
                                linkedHashMap2 = linkedHashMap;
                                d2 = dAverageOfLong;
                                double d6 = d5 - ((double) iFloor2);
                                if (d5 < 1.0d) {
                                    numberValueOf3 = (Number) listSorted3.get(0);
                                } else {
                                    obj3 = key;
                                    if (d5 >= size4) {
                                        numberValueOf3 = (Number) listSorted3.get(size4 - 1);
                                    } else {
                                        double dDoubleValue5 = ((Number) listSorted3.get(iFloor2 - 1)).doubleValue();
                                        dDoubleValue3 = ((((Number) listSorted3.get(iFloor2)).doubleValue() - dDoubleValue5) * d6) + dDoubleValue5;
                                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                            numberValueOf4 = Integer.valueOf((int) dDoubleValue3);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                            numberValueOf3 = Long.valueOf((long) dDoubleValue3);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            numberValueOf4 = Float.valueOf((float) dDoubleValue3);
                                        } else {
                                            Class cls4 = Double.TYPE;
                                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                                                numberValueOf4 = Double.valueOf(dDoubleValue3);
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                numberValueOf4 = Short.valueOf((short) dDoubleValue3);
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                                    throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls4).getSimpleName());
                                                }
                                                numberValueOf4 = Byte.valueOf((byte) dDoubleValue3);
                                            }
                                        }
                                        numberValueOf3 = (Long) numberValueOf4;
                                    }
                                }
                            }
                            obj3 = key;
                        }
                        float fLongValue3 = numberValueOf3.longValue();
                        Long l2 = (Long) CollectionsKt.maxOrNull((Iterable) list2);
                        statisticRecord = new StatisticRecord(d, f, fLongValue2, size3, d2, fLongValue3, l2 != null ? l2.longValue() : BitmapDescriptorFactory.HUE_RED);
                        obj4 = obj3;
                        linkedHashMap3 = linkedHashMap2;
                    }
                    linkedHashMap3.put(obj4, statisticRecord);
                    linkedHashMap4 = linkedHashMap3;
                    coroutine_suspended = obj2;
                    it2 = it;
                    i3 = 1;
                    c2938y8 = this;
                }
                Object obj6 = coroutine_suspended;
                LinkedHashMap linkedHashMap5 = linkedHashMap4;
                C2938y7 c2938y9 = c2938y8;
                C2888t7 c2888t7 = c2938y9.f3265b;
                c2948z7.f3317a = c2938y9;
                c2948z7.f3320d = 1;
                if (c2888t7.mo1130a(linkedHashMap5, c2948z7) == obj6) {
                    return obj6;
                }
                c2938y7 = c2938y9;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c2938y7 = c2948z7.f3317a;
        ResultKt.throwOnFailure(obj5);
        c2938y7.f3264a.f1416c.clear();
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final EnumC2760h mo892b() {
        return EnumC2760h.TIME;
    }
}
