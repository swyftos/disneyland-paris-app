package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KClass;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2580O3 implements InterfaceC2698a7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final InterfaceC2600Q3<Float> f1919a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final InterfaceC2868r7<StatisticRecord> f1920b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final CoroutineScope f1921c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public Job f1922d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final ArrayList f1923e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Lazy f1924f;

    /* JADX INFO: renamed from: g */
    public boolean f1925g;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", m1845f = "PerformanceAgent.kt", m1846i = {0, 1}, m1847l = {72, EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m1848m = "collect", m1849n = {"this", "this"}, m1850s = {"L$0", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2580O3 f1926a;

        /* JADX INFO: renamed from: b */
        public JSONObject f1927b;

        /* JADX INFO: renamed from: c */
        public String f1928c;

        /* JADX INFO: renamed from: d */
        public /* synthetic */ Object f1929d;

        /* JADX INFO: renamed from: f */
        public int f1931f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1929d = obj;
            this.f1931f |= Integer.MIN_VALUE;
            return C2580O3.this.mo893b(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent$reset$1", m1845f = "PerformanceAgent.kt", m1846i = {}, m1847l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f1932a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2580O3.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2580O3.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1932a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC2868r7<StatisticRecord> interfaceC2868r7 = C2580O3.this.f1920b;
                this.f1932a = 1;
                if (interfaceC2868r7.clear() == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$c */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent$start$1", m1845f = "PerformanceAgent.kt", m1846i = {}, m1847l = {63}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f1934a;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$c$a */
        public /* synthetic */ class a extends AdaptedFunctionReference implements Function2<Float, Continuation<? super Unit>, Object>, SuspendFunction {
            public a(InterfaceC2698a7 interfaceC2698a7) {
                super(2, interfaceC2698a7, C2580O3.class, "store", "store(F)V", 4);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Float f, Continuation<? super Unit> continuation) {
                float fFloatValue = f.floatValue();
                C2580O3 c2580o3 = (C2580O3) this.receiver;
                if (fFloatValue == BitmapDescriptorFactory.HUE_RED) {
                    c2580o3.getClass();
                } else if (c2580o3.f1923e.size() < 300) {
                    c2580o3.f1923e.add(Float.valueOf(fFloatValue));
                } else {
                    c2580o3.f1923e.set(Random.INSTANCE.nextInt(c2580o3.f1923e.size() - 1), Float.valueOf(fFloatValue));
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
            return C2580O3.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C2580O3.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1934a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnEach = FlowKt.onEach(C2580O3.this.f1919a.mo900a(), new a(C2580O3.this));
                this.f1934a = 1;
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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$d */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", m1845f = "PerformanceAgent.kt", m1846i = {0}, m1847l = {95}, m1848m = "stop", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2580O3 f1936a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f1937b;

        /* JADX INFO: renamed from: d */
        public int f1939d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1937b = obj;
            this.f1939d |= Integer.MIN_VALUE;
            return C2580O3.this.mo891a(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.O3$e */
    @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PerformanceAgent", m1845f = "PerformanceAgent.kt", m1846i = {0}, m1847l = {SyslogConstants.LOG_CLOCK}, m1848m = "storeOnDisk", m1849n = {"this"}, m1850s = {"L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2580O3 f1940a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f1941b;

        /* JADX INFO: renamed from: d */
        public int f1943d;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1941b = obj;
            this.f1943d |= Integer.MIN_VALUE;
            return C2580O3.this.m997c(this);
        }
    }

    public C2580O3() {
        throw null;
    }

    public C2580O3(InterfaceC2600Q3 performanceCollector, C2858q7 storage) {
        CoroutineDispatcher dispatcher = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(performanceCollector, "performanceCollector");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.f1919a = performanceCollector;
        this.f1920b = storage;
        this.f1921c = CoroutineScopeKt.CoroutineScope(dispatcher);
        this.f1923e = new ArrayList();
        this.f1924f = LazyKt.lazy(C2590P3.f1961a);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo890a() {
        return this.f1925g ? 1 : 2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: b */
    public final Object mo893b(@NotNull Continuation<? super JSONObject> continuation) throws JSONException {
        a aVar;
        JSONObject jSONObject;
        C2580O3 c2580o3;
        String str;
        StatisticRecord statisticRecord;
        JSONObject jSONObject2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f1931f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f1931f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f1929d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f1931f;
        if (i2 != 0) {
            if (i2 == 1) {
                this = aVar.f1926a;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = aVar.f1928c;
                jSONObject = aVar.f1927b;
                c2580o3 = aVar.f1926a;
                ResultKt.throwOnFailure(obj);
            }
            statisticRecord = (StatisticRecord) obj;
            if (statisticRecord != null) {
                jSONObject2 = new JSONObject();
                jSONObject2.put("median", statisticRecord.f1273a);
                jSONObject2.put("min", Float.valueOf(statisticRecord.f1274b));
                jSONObject2.put("p10", Float.valueOf(statisticRecord.f1275c));
                jSONObject2.put("count", statisticRecord.f1276d);
                jSONObject2.put("avg", statisticRecord.f1277e);
                jSONObject2.put("p90", Float.valueOf(statisticRecord.f1278f));
                jSONObject2.put("max", Float.valueOf(statisticRecord.f1279g));
            } else {
                jSONObject2 = null;
            }
            JSONObject collected = jSONObject.put(str, jSONObject2);
            ((Logger) c2580o3.f1924f.getValue()).m827d(c2580o3.f1919a.getName() + " insight collected : " + collected);
            Intrinsics.checkNotNullExpressionValue(collected, "collected");
            return collected;
        }
        ResultKt.throwOnFailure(obj);
        if (this.f1925g) {
            aVar.f1926a = this;
            aVar.f1931f = 1;
            if (mo891a(aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        String name = this.f1919a.getName();
        InterfaceC2868r7<StatisticRecord> interfaceC2868r7 = this.f1920b;
        aVar.f1926a = this;
        aVar.f1927b = jSONObject3;
        aVar.f1928c = name;
        aVar.f1931f = 2;
        Object objMo1132a = interfaceC2868r7.mo1132a(aVar);
        if (objMo1132a == coroutine_suspended) {
            return coroutine_suspended;
        }
        jSONObject = jSONObject3;
        obj = objMo1132a;
        c2580o3 = this;
        str = name;
        statisticRecord = (StatisticRecord) obj;
        if (statisticRecord != null) {
            jSONObject2 = new JSONObject();
            jSONObject2.put("median", statisticRecord.f1273a);
            jSONObject2.put("min", Float.valueOf(statisticRecord.f1274b));
            jSONObject2.put("p10", Float.valueOf(statisticRecord.f1275c));
            jSONObject2.put("count", statisticRecord.f1276d);
            jSONObject2.put("avg", statisticRecord.f1277e);
            jSONObject2.put("p90", Float.valueOf(statisticRecord.f1278f));
            jSONObject2.put("max", Float.valueOf(statisticRecord.f1279g));
        } else {
            jSONObject2 = null;
        }
        JSONObject collected2 = jSONObject.put(str, jSONObject2);
        ((Logger) c2580o3.f1924f.getValue()).m827d(c2580o3.f1919a.getName() + " insight collected : " + collected2);
        Intrinsics.checkNotNullExpressionValue(collected2, "collected");
        return collected2;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    /* JADX INFO: renamed from: c */
    public final void mo894c() {
        this.f1923e.clear();
        BuildersKt__Builders_commonKt.launch$default(this.f1921c, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    public final void start() {
        if (this.f1925g) {
            return;
        }
        ((Logger) this.f1924f.getValue()).m827d("Start collecting " + this.f1919a.getName() + " usage");
        this.f1922d = BuildersKt__Builders_commonKt.launch$default(this.f1921c, null, null, new c(null), 3, null);
        this.f1925g = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object mo891a(@NotNull Continuation<? super Unit> continuation) {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.f1939d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.f1939d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.f1937b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.f1939d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f1925g) {
                Job job = this.f1922d;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                dVar.f1936a = this;
                dVar.f1939d = 1;
                if (m997c(dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = dVar.f1936a;
        ResultKt.throwOnFailure(obj);
        this.f1925g = false;
        ((Logger) this.f1924f.getValue()).m827d("Stop collecting " + this.f1919a.getName() + " usage");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: c */
    public final Object m997c(Continuation<? super Unit> continuation) {
        e eVar;
        StatisticRecord statisticRecord;
        double dDoubleValue;
        Object obj;
        double d2;
        ArrayList arrayList;
        InterfaceC2868r7<StatisticRecord> interfaceC2868r7;
        Object obj2;
        e eVar2;
        double dDoubleValue2;
        Number numberValueOf;
        Number numberValueOf2;
        ArrayList arrayList2;
        double d3;
        float f;
        float f2;
        int i;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        Number numberValueOf3;
        Number numberValueOf4;
        C2580O3 c2580o3 = this;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.f1943d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.f1943d = i2 - Integer.MIN_VALUE;
            } else {
                eVar = c2580o3.new e(continuation);
            }
        } else {
            eVar = c2580o3.new e(continuation);
        }
        Object obj3 = eVar.f1941b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = eVar.f1943d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            if (c2580o3.f1923e.isEmpty()) {
                return Unit.INSTANCE;
            }
            InterfaceC2868r7<StatisticRecord> interfaceC2868r8 = c2580o3.f1920b;
            StatisticRecord.C2420a c2420a = StatisticRecord.Companion;
            ArrayList values = c2580o3.f1923e;
            c2420a.getClass();
            Intrinsics.checkNotNullParameter(values, "values");
            if (values.isEmpty()) {
                statisticRecord = new StatisticRecord(0);
                interfaceC2868r7 = interfaceC2868r8;
                obj2 = coroutine_suspended;
            } else {
                int size = values.size();
                List listSorted = CollectionsKt.sorted(values);
                if (size == 0) {
                    d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                } else {
                    if (size == 1) {
                        obj = values.get(0);
                    } else {
                        int i4 = size % 2;
                        int i5 = size / 2;
                        if (i4 == 1) {
                            obj = listSorted.get(i5);
                        } else {
                            dDoubleValue = (((Number) listSorted.get(i5 - 1)).doubleValue() + ((Number) listSorted.get(i5)).doubleValue()) / ((double) 2);
                        }
                        d2 = dDoubleValue;
                    }
                    dDoubleValue = ((Number) obj).doubleValue();
                    d2 = dDoubleValue;
                }
                Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) values);
                float fFloatValue = fMinOrNull != null ? fMinOrNull.floatValue() : BitmapDescriptorFactory.HUE_RED;
                if (values.isEmpty()) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Float.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        interfaceC2868r7 = interfaceC2868r8;
                        eVar2 = eVar;
                        obj2 = coroutine_suspended;
                        arrayList = values;
                        dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        numberValueOf2 = Integer.valueOf((int) dDoubleValue2);
                        numberValueOf = (Float) numberValueOf2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        interfaceC2868r7 = interfaceC2868r8;
                        eVar2 = eVar;
                        obj2 = coroutine_suspended;
                        arrayList = values;
                        dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        numberValueOf2 = Long.valueOf((long) dDoubleValue2);
                        numberValueOf = (Float) numberValueOf2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        interfaceC2868r7 = interfaceC2868r8;
                        eVar2 = eVar;
                        obj2 = coroutine_suspended;
                        arrayList = values;
                        dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        numberValueOf = Float.valueOf((float) dDoubleValue2);
                    } else {
                        Class cls = Double.TYPE;
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                            interfaceC2868r7 = interfaceC2868r8;
                            eVar2 = eVar;
                            obj2 = coroutine_suspended;
                            arrayList = values;
                            dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            numberValueOf2 = Double.valueOf(dDoubleValue2);
                            numberValueOf = (Float) numberValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            interfaceC2868r7 = interfaceC2868r8;
                            eVar2 = eVar;
                            obj2 = coroutine_suspended;
                            arrayList = values;
                            dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            numberValueOf2 = Short.valueOf((short) dDoubleValue2);
                            numberValueOf = (Float) numberValueOf2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls).getSimpleName());
                            }
                            interfaceC2868r7 = interfaceC2868r8;
                            eVar2 = eVar;
                            obj2 = coroutine_suspended;
                            arrayList = values;
                            dDoubleValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            numberValueOf2 = Byte.valueOf((byte) dDoubleValue2);
                            numberValueOf = (Float) numberValueOf2;
                        }
                    }
                } else if (values.size() == 1) {
                    numberValueOf = (Number) values.get(0);
                    interfaceC2868r7 = interfaceC2868r8;
                    eVar2 = eVar;
                    obj2 = coroutine_suspended;
                    arrayList = values;
                } else {
                    List listSorted2 = CollectionsKt.sorted(values);
                    int size2 = listSorted2.size();
                    arrayList = values;
                    double d10 = (((double) (size2 + 1)) * 10.0d) / ((double) 100);
                    int iFloor = (int) Math.floor(d10);
                    interfaceC2868r7 = interfaceC2868r8;
                    double d11 = d10 - ((double) iFloor);
                    if (d10 < 1.0d) {
                        numberValueOf = (Number) listSorted2.get(0);
                        eVar2 = eVar;
                        obj2 = coroutine_suspended;
                    } else {
                        obj2 = coroutine_suspended;
                        eVar2 = eVar;
                        if (d10 >= size2) {
                            numberValueOf = (Number) listSorted2.get(size2 - 1);
                        } else {
                            double dDoubleValue3 = ((Number) listSorted2.get(iFloor - 1)).doubleValue();
                            dDoubleValue2 = ((((Number) listSorted2.get(iFloor)).doubleValue() - dDoubleValue3) * d11) + dDoubleValue3;
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Float.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numberValueOf2 = Integer.valueOf((int) dDoubleValue2);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numberValueOf2 = Long.valueOf((long) dDoubleValue2);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numberValueOf = Float.valueOf((float) dDoubleValue2);
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
                            numberValueOf = (Float) numberValueOf2;
                        }
                    }
                }
                float fFloatValue2 = numberValueOf.floatValue();
                int size3 = arrayList.size();
                double dAverageOfFloat = CollectionsKt.averageOfFloat(arrayList);
                if (arrayList.isEmpty()) {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Float.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        i = size3;
                        d3 = dAverageOfFloat;
                        f2 = fFloatValue;
                        arrayList2 = arrayList;
                        d9 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        f = fFloatValue2;
                        numberValueOf4 = Integer.valueOf((int) d9);
                        numberValueOf3 = (Float) numberValueOf4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        i = size3;
                        d3 = dAverageOfFloat;
                        f2 = fFloatValue;
                        arrayList2 = arrayList;
                        d8 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        f = fFloatValue2;
                        numberValueOf4 = Long.valueOf((long) d8);
                        numberValueOf3 = (Float) numberValueOf4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        i = size3;
                        d3 = dAverageOfFloat;
                        f2 = fFloatValue;
                        arrayList2 = arrayList;
                        d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        f = fFloatValue2;
                        numberValueOf3 = Float.valueOf((float) d7);
                    } else {
                        Class cls3 = Double.TYPE;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                            i = size3;
                            d3 = dAverageOfFloat;
                            f2 = fFloatValue;
                            arrayList2 = arrayList;
                            d6 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            f = fFloatValue2;
                            numberValueOf4 = Double.valueOf(d6);
                            numberValueOf3 = (Float) numberValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            i = size3;
                            d3 = dAverageOfFloat;
                            f2 = fFloatValue;
                            arrayList2 = arrayList;
                            d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            f = fFloatValue2;
                            numberValueOf4 = Short.valueOf((short) d5);
                            numberValueOf3 = (Float) numberValueOf4;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls3).getSimpleName());
                            }
                            i = size3;
                            d3 = dAverageOfFloat;
                            f2 = fFloatValue;
                            arrayList2 = arrayList;
                            d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
                            f = fFloatValue2;
                            numberValueOf4 = Byte.valueOf((byte) d4);
                            numberValueOf3 = (Float) numberValueOf4;
                        }
                    }
                } else if (arrayList.size() == 1) {
                    arrayList2 = arrayList;
                    numberValueOf3 = (Number) arrayList2.get(0);
                    i = size3;
                    d3 = dAverageOfFloat;
                    f2 = fFloatValue;
                    f = fFloatValue2;
                } else {
                    arrayList2 = arrayList;
                    List listSorted3 = CollectionsKt.sorted(arrayList2);
                    int size4 = listSorted3.size();
                    d3 = dAverageOfFloat;
                    double d12 = (((double) (size4 + 1)) * 90.0d) / ((double) 100);
                    int iFloor2 = (int) Math.floor(d12);
                    f = fFloatValue2;
                    double d13 = d12 - ((double) iFloor2);
                    if (d12 < 1.0d) {
                        numberValueOf3 = (Number) listSorted3.get(0);
                        f2 = fFloatValue;
                        i = size3;
                    } else {
                        f2 = fFloatValue;
                        i = size3;
                        if (d12 >= size4) {
                            numberValueOf3 = (Number) listSorted3.get(size4 - 1);
                        } else {
                            double dDoubleValue4 = ((Number) listSorted3.get(iFloor2 - 1)).doubleValue();
                            double dDoubleValue5 = ((((Number) listSorted3.get(iFloor2)).doubleValue() - dDoubleValue4) * d13) + dDoubleValue4;
                            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Float.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                d9 = dDoubleValue5;
                                numberValueOf4 = Integer.valueOf((int) d9);
                                numberValueOf3 = (Float) numberValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                d8 = dDoubleValue5;
                                numberValueOf4 = Long.valueOf((long) d8);
                                numberValueOf3 = (Float) numberValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                d7 = dDoubleValue5;
                                numberValueOf3 = Float.valueOf((float) d7);
                            } else {
                                Class cls4 = Double.TYPE;
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                                    d6 = dDoubleValue5;
                                    numberValueOf4 = Double.valueOf(d6);
                                    numberValueOf3 = (Float) numberValueOf4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    d5 = dDoubleValue5;
                                    numberValueOf4 = Short.valueOf((short) d5);
                                    numberValueOf3 = (Float) numberValueOf4;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                        throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls4).getSimpleName());
                                    }
                                    d4 = dDoubleValue5;
                                    numberValueOf4 = Byte.valueOf((byte) d4);
                                    numberValueOf3 = (Float) numberValueOf4;
                                }
                            }
                        }
                    }
                }
                float fFloatValue3 = numberValueOf3.floatValue();
                Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) arrayList2);
                statisticRecord = new StatisticRecord(d2, f2, f, i, d3, fFloatValue3, fMaxOrNull != null ? fMaxOrNull.floatValue() : BitmapDescriptorFactory.HUE_RED);
                c2580o3 = this;
                eVar = eVar2;
            }
            eVar.f1940a = c2580o3;
            eVar.f1943d = 1;
            Object objMo1130a = interfaceC2868r7.mo1130a(statisticRecord, eVar);
            Object obj4 = obj2;
            if (objMo1130a == obj4) {
                return obj4;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c2580o3 = eVar.f1940a;
            ResultKt.throwOnFailure(obj3);
        }
        c2580o3.f1923e.clear();
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2698a7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final EnumC2760h mo892b() {
        return EnumC2760h.PERFORMANCE;
    }
}
