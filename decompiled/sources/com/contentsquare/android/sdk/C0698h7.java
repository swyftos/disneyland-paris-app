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
import com.contentsquare.android.internal.core.telemetry.event.CustomEvent;
import com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1;
import com.contentsquare.android.sdk.C0698h7;
import com.contentsquare.android.sdk.C0738l7;
import com.contentsquare.android.sdk.F;
import com.contentsquare.android.sdk.InterfaceC0628a7;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.android.sdk.T3;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ResultKt;
import kotlin.Unit;
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
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n766#2:281\n857#2,2:282\n1855#2,2:284\n1855#2,2:286\n1855#2,2:288\n1855#2,2:290\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager\n*L\n213#1:279,2\n219#1:281\n219#1:282,2\n219#1:284,2\n263#1:286,2\n267#1:288,2\n271#1:290,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.h7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0698h7 implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final C0778p7 a;

    @NotNull
    public final LifecycleOwner b;

    @NotNull
    public final C0738l7 c;

    @NotNull
    public final C0668e7 d;

    @NotNull
    public final C0668e7 e;

    @NotNull
    public final A7 f;

    @NotNull
    public final F g;

    @NotNull
    public final J6 h;

    @NotNull
    public final Logger i;

    @NotNull
    public final ArrayList j;

    @NotNull
    public final ArrayList k;
    public long l;

    @Nullable
    public Long m;

    @NotNull
    public final CoroutineScope n;
    public boolean o;

    @NotNull
    public final TelemetryManager$lifecycleObserver$1 p;

    @NotNull
    public int q;

    /* renamed from: com.contentsquare.android.sdk.h7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

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
            a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1] */
    public C0698h7(Application application, PreferencesStore preferencesStore, LifecycleOwner lifecycleOwner, C0738l7 telemetryPolicy, J6 staticCollector, DeviceInfo deviceInfo, Configuration configuration) {
        C0778p7 telemetryReportProcessor = new C0778p7();
        C0668e7 customEventCollector = new C0668e7();
        C0668e7 apiUsageCollector = new C0668e7();
        A7 timeCollector = new A7();
        F appLifeCycleEventCollector = new F(0);
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
        this.a = telemetryReportProcessor;
        this.b = lifecycleOwner;
        this.c = telemetryPolicy;
        this.d = customEventCollector;
        this.e = apiUsageCollector;
        this.f = timeCollector;
        this.g = appLifeCycleEventCollector;
        this.h = staticCollector;
        this.i = new Logger("TelemetryManager");
        this.j = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.l = System.currentTimeMillis();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.n = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        this.o = true;
        this.p = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1

            @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager$lifecycleObserver$1$onStop$1", f = "TelemetryManager.kt", i = {}, l = {80, Currencies.BZD}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$lifecycleObserver$1$onStop$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1855#2,2:279\n*S KotlinDebug\n*F\n+ 1 TelemetryManager.kt\ncom/contentsquare/android/internal/core/telemetry/processing/TelemetryManager$lifecycleObserver$1$onStop$1\n*L\n79#1:279,2\n*E\n"})
            public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public Iterator a;
                public int b;
                public final /* synthetic */ C0698h7 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(C0698h7 c0698h7, Continuation<? super a> continuation) {
                    super(2, continuation);
                    this.c = c0698h7;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new a(this.c, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return new a(this.c, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Iterator it;
                    String str;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.b;
                    try {
                    } catch (Throwable th) {
                        Q2.a(this.c.i, "Telemetry onStop life cycle event failed", th);
                    }
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        it = this.c.j.iterator();
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            C0738l7 c0738l7 = this.c.c;
                            c0738l7.a.putBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, true);
                            c0738l7.a.putLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, System.currentTimeMillis());
                            c0738l7.a.putLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, c0738l7.b.getBuildInformation().getApplicationVersionCode());
                            return Unit.INSTANCE;
                        }
                        it = this.a;
                        ResultKt.throwOnFailure(obj);
                    }
                    while (it.hasNext()) {
                        InterfaceC0628a7 interfaceC0628a7 = (InterfaceC0628a7) it.next();
                        this.a = it;
                        this.b = 1;
                        if (interfaceC0628a7.a(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (((T3) this.c.c.c.getValue()).b()) {
                        switch (((T3) this.c.c.c.getValue()).a()) {
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
                        C0698h7 c0698h7 = this.c;
                        this.a = null;
                        this.b = 2;
                        if (C0698h7.a(c0698h7, str, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        C0738l7 c0738l72 = this.c.c;
                        c0738l72.a.putBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, true);
                        c0738l72.a.putLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, System.currentTimeMillis());
                        c0738l72.a.putLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, c0738l72.b.getBuildInformation().getApplicationVersionCode());
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onCreate(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                try {
                    F f = this.a.g;
                    f.getClass();
                    f.a(new AppLifeCycleEvent(ViewProps.START, 1L));
                } catch (Throwable th) {
                    Q2.a(this.a.i, "Telemetry onCreate life cycle event failed", th);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStart(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                try {
                    C0698h7 c0698h7 = this.a;
                    if (c0698h7.o) {
                        c0698h7.o = false;
                        return;
                    }
                    c0698h7.a();
                    F f = this.a.g;
                    f.c = f.a.invoke().longValue();
                    f.a(new AppLifeCycleEvent(DownloadService.KEY_FOREGROUND, 1L));
                } catch (Throwable th) {
                    Q2.a(this.a.i, "Telemetry onStart life cycle event failed", th);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                F f = this.a.g;
                f.a(new AppLifeCycleEvent(TypedValues.TransitionType.S_DURATION, f.a.invoke().longValue() - f.c));
                f.a(new AppLifeCycleEvent(AppStateModule.APP_STATE_BACKGROUND, 1L));
                C0698h7 c0698h7 = this.a;
                BuildersKt__Builders_commonKt.launch$default(c0698h7.n, null, null, new a(c0698h7, null), 3, null);
            }
        };
        this.q = 2;
        try {
            preferencesStore.registerOnChangedListener(this);
            a(new K6(staticCollector));
            a(new C0744m3(new C0754n3(HttpConnection.INSTANCE.getResponseFlow()), preferencesStore));
            a(new C0648c7(customEventCollector, new C0678f7(fileStorageUtil, application, SchedulerSupport.CUSTOM)));
            a(new C0864y7(timeCollector, new C0817t7(application, fileStorageUtil)));
            a(new D(appLifeCycleEventCollector, new C0678f7(fileStorageUtil, application, "life_cycle")));
            a(new C0675f4(apiUsageCollector, new C0678f7(fileStorageUtil, application, "api_usage"), preferencesStore));
            C0638b7 subscriber = new C0638b7(httpConnection, deviceInfo, configuration);
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            if (arrayList.contains(subscriber)) {
                return;
            }
            arrayList.add(subscriber);
        } catch (Throwable th) {
            Q2.a(this.i, "Failed to initialize Telemetry service", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145 A[LOOP:4: B:47:0x013f->B:49:0x0145, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017d A[LOOP:5: B:51:0x0177->B:53:0x017d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0195 A[LOOP:6: B:55:0x018f->B:57:0x0195, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(com.contentsquare.android.sdk.C0698h7 r13, java.lang.String r14, kotlin.coroutines.Continuation r15) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0698h7.a(com.contentsquare.android.sdk.h7, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b() {
        if (this.q == 2) {
            this.q = 1;
            this.l = System.currentTimeMillis();
            this.m = null;
            this.i.d("Telemetry service started");
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                ((InterfaceC0628a7) it.next()).start();
            }
            this.b.getLifecycle().addObserver(this.p);
            return;
        }
        ArrayList arrayList = this.j;
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (((InterfaceC0628a7) next).a() == 2) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((InterfaceC0628a7) it3.next()).start();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = a.a[key.ordinal()];
        if (i == 1 || i == 2) {
            a();
        }
    }

    public final <T> void a(@NotNull String key, @NotNull T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.d.a(new CustomEvent(key, value.toString()));
    }

    public final void a() {
        try {
            if (((T3) this.c.d.getValue()).b()) {
                b();
            } else {
                this.m = Long.valueOf(System.currentTimeMillis());
                this.q = 2;
                C0778p7 c0778p7 = this.a;
                c0778p7.a.clear();
                c0778p7.b.clear();
                c0778p7.c = new JSONObject();
                c0778p7.d = new JSONObject();
                c0778p7.e = new JSONObject();
                c0778p7.f = new JSONObject();
                BuildersKt__Builders_commonKt.launch$default(this.n, null, null, new C0728k7(this, null), 3, null);
                this.i.d("Telemetry service stopped");
            }
        } catch (Throwable th) {
            Q2.a(this.i, "Failed to start Telemetry service", th);
        }
    }

    public final void a(@NotNull InterfaceC0628a7 collectorAgent) {
        Intrinsics.checkNotNullParameter(collectorAgent, "collectorAgent");
        if (this.j.contains(collectorAgent)) {
            return;
        }
        this.j.add(collectorAgent);
    }
}
