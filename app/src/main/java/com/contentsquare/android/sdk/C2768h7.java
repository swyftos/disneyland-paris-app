package com.contentsquare.android.sdk;

import android.app.Application;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.offline.DownloadService;
import com.contentsquare.android.api.Currencies;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.internal.core.telemetry.event.AppLifeCycleEvent;
import com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1;
import com.contentsquare.android.sdk.C2486F;
import com.contentsquare.android.sdk.C2599Q2;
import com.contentsquare.android.sdk.C2768h7;
import com.contentsquare.android.sdk.C2808l7;
import com.contentsquare.android.sdk.InterfaceC2629T3;
import com.contentsquare.android.sdk.InterfaceC2698a7;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n766#2:281\n857#2,2:282\n1855#2,2:284\n1855#2,2:286\n1855#2,2:288\n1855#2,2:290\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager\n*L\n213#1:279,2\n219#1:281\n219#1:282,2\n219#1:284,2\n263#1:286,2\n267#1:288,2\n271#1:290,2\n*E\n"})
public final class C2768h7 implements PreferencesStore.PreferencesStoreListener {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2848p7 f2701a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final LifecycleOwner f2702b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2808l7 f2703c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2738e7 f2704d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2738e7 f2705e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2444A7 f2706f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2486F f2707g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final C2533J6 f2708h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final Logger f2709i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final ArrayList f2710j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final ArrayList f2711k;

    /* JADX INFO: renamed from: l */
    public long f2712l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Long f2713m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final CoroutineScope f2714n;

    /* JADX INFO: renamed from: o */
    public boolean f2715o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public final TelemetryManager$lifecycleObserver$1 f2716p;

    /* JADX INFO: renamed from: q */
    @NotNull
    public int f2717q;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h7$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f2718a;

        static {
            int[] iArr = new int[PreferencesKey.values().length];
            try {
                iArr[PreferencesKey.RAW_CONFIGURATION_AS_JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesKey.FORGET_ME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2718a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1] */
    public C2768h7(Application application, PreferencesStore preferencesStore, LifecycleOwner lifecycleOwner, C2808l7 telemetryPolicy, C2533J6 staticCollector, DeviceInfo deviceInfo, Configuration configuration) {
        C2848p7 telemetryReportProcessor = new C2848p7();
        C2738e7 customEventCollector = new C2738e7();
        C2738e7 apiUsageCollector = new C2738e7();
        C2444A7 timeCollector = new C2444A7();
        C2486F appLifeCycleEventCollector = new C2486F(0);
        HttpConnection httpConnection = new HttpConnection();
        FileStorageUtil fileStorageUtil = new FileStorageUtil();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(telemetryReportProcessor, "telemetryReportProcessor");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(telemetryPolicy, "telemetryPolicy");
        Intrinsics.checkNotNullParameter(customEventCollector, "customEventCollector");
        Intrinsics.checkNotNullParameter(apiUsageCollector, "apiUsageCollector");
        Intrinsics.checkNotNullParameter(timeCollector, "timeCollector");
        Intrinsics.checkNotNullParameter(appLifeCycleEventCollector, "appLifeCycleEventCollector");
        Intrinsics.checkNotNullParameter(staticCollector, "staticCollector");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        this.f2701a = telemetryReportProcessor;
        this.f2702b = lifecycleOwner;
        this.f2703c = telemetryPolicy;
        this.f2704d = customEventCollector;
        this.f2705e = apiUsageCollector;
        this.f2706f = timeCollector;
        this.f2707g = appLifeCycleEventCollector;
        this.f2708h = staticCollector;
        this.f2709i = new Logger("TelemetryManager");
        this.f2710j = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f2711k = arrayList;
        this.f2712l = System.currentTimeMillis();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f2714n = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        this.f2715o = true;
        this.f2716p = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1

            /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1$a */
            @DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1$onStop$1", m1845f = "TelemetryManager.kt", m1846i = {}, m1847l = {80, Currencies.BZD}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
            @SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$lifecycleObserver$1$onStop$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$lifecycleObserver$1$onStop$1\n*L\n79#1:279,2\n*E\n"})
            public static final class C2422a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a */
                public Iterator f1283a;

                /* JADX INFO: renamed from: b */
                public int f1284b;

                /* JADX INFO: renamed from: c */
                public final /* synthetic */ C2768h7 f1285c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C2422a(C2768h7 c2768h7, Continuation<? super C2422a> continuation) {
                    super(2, continuation);
                    this.f1285c = c2768h7;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C2422a(this.f1285c, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return new C2422a(this.f1285c, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Iterator it;
                    String str;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f1284b;
                    try {
                        if (i != 0) {
                            if (i == 1) {
                                it = this.f1283a;
                                ResultKt.throwOnFailure(obj);
                            } else {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            C2808l7 c2808l7 = this.f1285c.f2703c;
                            c2808l7.f2857a.putBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, true);
                            c2808l7.f2857a.putLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, System.currentTimeMillis());
                            c2808l7.f2857a.putLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, c2808l7.f2858b.getBuildInformation().getApplicationVersionCode());
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        it = this.f1285c.f2710j.iterator();
                        while (it.hasNext()) {
                            InterfaceC2698a7 interfaceC2698a7 = (InterfaceC2698a7) it.next();
                            this.f1283a = it;
                            this.f1284b = 1;
                            if (interfaceC2698a7.mo891a(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (((InterfaceC2629T3) this.f1285c.f2703c.f2859c.getValue()).mo934b()) {
                            switch (((InterfaceC2629T3) this.f1285c.f2703c.f2859c.getValue()).mo933a()) {
                                case 1:
                                    str = "install";
                                    break;
                                case 2:
                                    str = "update";
                                    break;
                                case 3:
                                    str = "fortnightly";
                                    break;
                                case 4:
                                    str = "forced";
                                    break;
                                case 5:
                                    str = "config";
                                    break;
                                case 6:
                                    str = "rejected";
                                    break;
                                default:
                                    throw null;
                            }
                            C2768h7 c2768h7 = this.f1285c;
                            this.f1283a = null;
                            this.f1284b = 2;
                            if (C2768h7.m1144a(c2768h7, str, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            C2808l7 c2808l8 = this.f1285c.f2703c;
                            c2808l8.f2857a.putBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, true);
                            c2808l8.f2857a.putLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, System.currentTimeMillis());
                            c2808l8.f2857a.putLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, c2808l8.f2858b.getBuildInformation().getApplicationVersionCode());
                        }
                    } catch (Throwable th) {
                        C2599Q2.m1011a(this.f1285c.f2709i, "Telemetry onStop life cycle event failed", th);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onCreate(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                try {
                    C2486F c2486f = this.f1282a.f2707g;
                    c2486f.getClass();
                    c2486f.m914a(new AppLifeCycleEvent(ViewProps.START, 1L));
                } catch (Throwable th) {
                    C2599Q2.m1011a(this.f1282a.f2709i, "Telemetry onCreate life cycle event failed", th);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStart(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                try {
                    C2768h7 c2768h7 = this.f1282a;
                    if (c2768h7.f2715o) {
                        c2768h7.f2715o = false;
                        return;
                    }
                    c2768h7.m1145a();
                    C2486F c2486f = this.f1282a.f2707g;
                    c2486f.f1567c = c2486f.f1565a.invoke().longValue();
                    c2486f.m914a(new AppLifeCycleEvent(DownloadService.KEY_FOREGROUND, 1L));
                } catch (Throwable th) {
                    C2599Q2.m1011a(this.f1282a.f2709i, "Telemetry onStart life cycle event failed", th);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                C2486F c2486f = this.f1282a.f2707g;
                c2486f.m914a(new AppLifeCycleEvent(TypedValues.TransitionType.S_DURATION, c2486f.f1565a.invoke().longValue() - c2486f.f1567c));
                c2486f.m914a(new AppLifeCycleEvent(AppStateModule.APP_STATE_BACKGROUND, 1L));
                C2768h7 c2768h7 = this.f1282a;
                BuildersKt__Builders_commonKt.launch$default(c2768h7.f2714n, null, null, new C2422a(c2768h7, null), 3, null);
            }
        };
        this.f2717q = 2;
        try {
            preferencesStore.registerOnChangedListener(this);
            m1146a(new C2543K6(staticCollector));
            m1146a(new C2814m3(new C2824n3(HttpConnection.INSTANCE.getResponseFlow()), preferencesStore));
            m1146a(new C2718c7(customEventCollector, new C2748f7(fileStorageUtil, application, SchedulerSupport.CUSTOM)));
            m1146a(new C2938y7(timeCollector, new C2888t7(application, fileStorageUtil)));
            m1146a(new C2466D(appLifeCycleEventCollector, new C2748f7(fileStorageUtil, application, "life_cycle")));
            m1146a(new C2745f4(apiUsageCollector, new C2748f7(fileStorageUtil, application, "api_usage"), preferencesStore));
            C2708b7 subscriber = new C2708b7(httpConnection, deviceInfo, configuration);
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            if (arrayList.contains(subscriber)) {
                return;
            }
            arrayList.add(subscriber);
        } catch (Throwable th) {
            C2599Q2.m1011a(this.f2709i, "Failed to initialize Telemetry service", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1 A[LOOP:1: B:34:0x00cb->B:36:0x00d1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x0106  */
    /* JADX WARN: Code duplicated, block: B:44:0x0119 A[LOOP:3: B:42:0x0113->B:44:0x0119, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x0145 A[LOOP:4: B:47:0x013f->B:49:0x0145, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x017e A[LOOP:5: B:51:0x0178->B:53:0x017e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x0196 A[LOOP:6: B:55:0x0190->B:57:0x0196, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX INFO: renamed from: a */
    public static final Object m1144a(C2768h7 c2768h7, String str, Continuation continuation) throws JSONException {
        C2788j7 c2788j7;
        C2768h7 c2768h8;
        Iterator it;
        String str2;
        String str3;
        Long l;
        long jCurrentTimeMillis;
        C2828n7 c2828n7;
        C2848p7 c2848p7;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList arrayList;
        JSONObject jSONObject3;
        ArrayList arrayList2;
        Iterator<String> itKeys;
        Iterator it2;
        Iterator it3;
        Iterator<String> itKeys2;
        Iterator<String> itKeys3;
        c2768h7.getClass();
        if (continuation instanceof C2788j7) {
            c2788j7 = (C2788j7) continuation;
            int i = c2788j7.f2789f;
            if ((i & Integer.MIN_VALUE) != 0) {
                c2788j7.f2789f = i - Integer.MIN_VALUE;
            } else {
                c2788j7 = new C2788j7(c2768h7, continuation);
            }
        } else {
            c2788j7 = new C2788j7(c2768h7, continuation);
        }
        Object obj = c2788j7.f2787d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c2788j7.f2789f;
        if (i2 != 0) {
            if (i2 == 1) {
                it = c2788j7.f2786c;
                String str4 = c2788j7.f2785b;
                C2768h7 c2768h9 = c2788j7.f2784a;
                ResultKt.throwOnFailure(obj);
                str2 = str4;
                c2768h8 = c2768h9;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str5 = c2788j7.f2785b;
                c2768h8 = c2788j7.f2784a;
                ResultKt.throwOnFailure(obj);
                str3 = str5;
            }
            l = c2768h8.f2713m;
            if (l != null) {
                jCurrentTimeMillis = l.longValue();
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            c2848p7 = c2768h8.f2701a;
            c2848p7.getClass();
            jSONObject = new JSONObject();
            jSONObject2 = new JSONObject();
            ArrayList<JSONObject> arrayList3 = c2848p7.f3008a;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (JSONObject jSONObject4 : arrayList3) {
                itKeys3 = jSONObject4.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys3, "event.keys()");
                while (itKeys3.hasNext()) {
                    String next = itKeys3.next();
                    jSONObject2.put(next, jSONObject4.get(next));
                }
                arrayList.add(Unit.INSTANCE);
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put(CustomEvent.PROPERTIES, jSONObject2);
            jSONObject3 = new JSONObject();
            ArrayList<JSONObject> arrayList4 = c2848p7.f3009b;
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (JSONObject jSONObject5 : arrayList4) {
                itKeys2 = jSONObject5.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys2, "event.keys()");
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject3.put(next2, jSONObject5.get(next2));
                }
                arrayList2.add(Unit.INSTANCE);
            }
            Unit unit2 = Unit.INSTANCE;
            jSONObject.put("performance", jSONObject3);
            itKeys = c2848p7.f3010c.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "networkEvent.keys()");
            while (itKeys.hasNext()) {
                String next3 = itKeys.next();
                jSONObject.put(next3, c2848p7.f3010c.get(next3));
            }
            jSONObject.put("time", c2848p7.f3011d);
            jSONObject.put(TCEventPropertiesNames.TCL_LIFECYCLE, c2848p7.f3012e);
            jSONObject.put("public", c2848p7.f3013f);
            c2828n7 = new C2828n7(jSONObject, c2768h8.f2712l, jCurrentTimeMillis, str3);
            it2 = c2768h8.f2711k.iterator();
            while (it2.hasNext()) {
                ((AbstractC2878s7) it2.next()).mo1099b(c2828n7);
            }
            c2768h8.f2712l = jCurrentTimeMillis;
            it3 = c2768h8.f2710j.iterator();
            while (it3.hasNext()) {
                ((InterfaceC2698a7) it3.next()).mo894c();
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        c2768h8 = c2768h7;
        it = c2768h7.f2710j.iterator();
        str2 = str;
        while (it.hasNext()) {
            InterfaceC2698a7 interfaceC2698a7 = (InterfaceC2698a7) it.next();
            c2788j7.f2784a = c2768h8;
            c2788j7.f2785b = str2;
            c2788j7.f2786c = it;
            c2788j7.f2789f = 1;
            if (interfaceC2698a7.mo891a(c2788j7) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        C2848p7 c2848p8 = c2768h8.f2701a;
        ArrayList arrayList5 = c2768h8.f2710j;
        c2788j7.f2784a = c2768h8;
        c2788j7.f2785b = str2;
        c2788j7.f2786c = null;
        c2788j7.f2789f = 2;
        if (c2848p8.m1193a(arrayList5, c2788j7) == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        l = c2768h8.f2713m;
        if (l != null) {
            jCurrentTimeMillis = l.longValue();
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        c2848p7 = c2768h8.f2701a;
        c2848p7.getClass();
        jSONObject = new JSONObject();
        jSONObject2 = new JSONObject();
        ArrayList<JSONObject> arrayList6 = c2848p7.f3008a;
        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        while (r4.hasNext()) {
            itKeys3 = jSONObject4.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys3, "event.keys()");
            while (itKeys3.hasNext()) {
                String next4 = itKeys3.next();
                jSONObject2.put(next4, jSONObject4.get(next4));
            }
            arrayList.add(Unit.INSTANCE);
        }
        Unit unit3 = Unit.INSTANCE;
        jSONObject.put(CustomEvent.PROPERTIES, jSONObject2);
        jSONObject3 = new JSONObject();
        ArrayList<JSONObject> arrayList7 = c2848p7.f3009b;
        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        while (r4.hasNext()) {
            itKeys2 = jSONObject5.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys2, "event.keys()");
            while (itKeys2.hasNext()) {
                String next5 = itKeys2.next();
                jSONObject3.put(next5, jSONObject5.get(next5));
            }
            arrayList2.add(Unit.INSTANCE);
        }
        Unit unit4 = Unit.INSTANCE;
        jSONObject.put("performance", jSONObject3);
        itKeys = c2848p7.f3010c.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "networkEvent.keys()");
        while (itKeys.hasNext()) {
            String next6 = itKeys.next();
            jSONObject.put(next6, c2848p7.f3010c.get(next6));
        }
        jSONObject.put("time", c2848p7.f3011d);
        jSONObject.put(TCEventPropertiesNames.TCL_LIFECYCLE, c2848p7.f3012e);
        jSONObject.put("public", c2848p7.f3013f);
        c2828n7 = new C2828n7(jSONObject, c2768h8.f2712l, jCurrentTimeMillis, str3);
        it2 = c2768h8.f2711k.iterator();
        while (it2.hasNext()) {
            ((AbstractC2878s7) it2.next()).mo1099b(c2828n7);
        }
        c2768h8.f2712l = jCurrentTimeMillis;
        it3 = c2768h8.f2710j.iterator();
        while (it3.hasNext()) {
            ((InterfaceC2698a7) it3.next()).mo894c();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: b */
    public final void m1148b() {
        if (this.f2717q == 2) {
            this.f2717q = 1;
            this.f2712l = System.currentTimeMillis();
            this.f2713m = null;
            this.f2709i.m827d("Telemetry service started");
            Iterator it = this.f2710j.iterator();
            while (it.hasNext()) {
                ((InterfaceC2698a7) it.next()).start();
            }
            this.f2702b.getLifecycle().addObserver(this.f2716p);
            return;
        }
        ArrayList arrayList = this.f2710j;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((InterfaceC2698a7) obj).mo890a() == 2) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((InterfaceC2698a7) it2.next()).start();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = a.f2718a[key.ordinal()];
        if (i == 1 || i == 2) {
            m1145a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final <T> void m1147a(@NotNull String key, @NotNull T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f2704d.m1125a(new com.contentsquare.android.internal.core.telemetry.event.CustomEvent(key, value.toString()));
    }

    /* JADX INFO: renamed from: a */
    public final void m1145a() {
        try {
            if (((InterfaceC2629T3) this.f2703c.f2860d.getValue()).mo934b()) {
                m1148b();
            } else {
                this.f2713m = Long.valueOf(System.currentTimeMillis());
                this.f2717q = 2;
                C2848p7 c2848p7 = this.f2701a;
                c2848p7.f3008a.clear();
                c2848p7.f3009b.clear();
                c2848p7.f3010c = new JSONObject();
                c2848p7.f3011d = new JSONObject();
                c2848p7.f3012e = new JSONObject();
                c2848p7.f3013f = new JSONObject();
                BuildersKt__Builders_commonKt.launch$default(this.f2714n, null, null, new C2798k7(this, null), 3, null);
                this.f2709i.m827d("Telemetry service stopped");
            }
        } catch (Throwable th) {
            C2599Q2.m1011a(this.f2709i, "Failed to start Telemetry service", th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1146a(@NotNull InterfaceC2698a7 collectorAgent) {
        Intrinsics.checkNotNullParameter(collectorAgent, "collectorAgent");
        if (this.f2710j.contains(collectorAgent)) {
            return;
        }
        this.f2710j.add(collectorAgent);
    }
}
