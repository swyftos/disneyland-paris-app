package com.contentsquare.android.internal.core.telemetry;

import android.app.Application;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.internal.core.telemetry.event.ApiUsageEvent;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.sdk.AbstractC2878s7;
import com.contentsquare.android.sdk.C2444A7;
import com.contentsquare.android.sdk.C2477E0;
import com.contentsquare.android.sdk.C2533J6;
import com.contentsquare.android.sdk.C2580O3;
import com.contentsquare.android.sdk.C2702b1;
import com.contentsquare.android.sdk.C2758g7;
import com.contentsquare.android.sdk.C2768h7;
import com.contentsquare.android.sdk.C2778i7;
import com.contentsquare.android.sdk.C2805l4;
import com.contentsquare.android.sdk.C2808l7;
import com.contentsquare.android.sdk.C2818m7;
import com.contentsquare.android.sdk.C2858q7;
import com.contentsquare.android.sdk.InterfaceC2698a7;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u0006\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J#\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010/R!\u00104\u001a\b\u0012\u0004\u0012\u0002010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010/R(\u00106\u001a\u0002058\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b6\u00107\u0012\u0004\b<\u0010\u0003\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010>\u001a\u0004\u0018\u00010=8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, m1836d2 = {"Lcom/contentsquare/android/internal/core/telemetry/Telemetry;", "", "<init>", "()V", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "init", "(Landroid/app/Application;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "value", "collect$library_release", "(Ljava/lang/String;Ljava/lang/Object;)V", "collect", "key", "startMeasureTime", "(Ljava/lang/String;)V", "stopMeasureTime", "Lkotlin/Function0;", "block", "measureExecutionTime", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "apiName", "collectApiCall", "(Ljava/lang/String;)Lkotlin/Unit;", "startPerformance", "stopPerformance", "notifyPAisStarted$library_release", "notifyPAisStarted", "Landroid/app/Application;", "Lcom/contentsquare/android/core/utils/FileStorageUtil;", "fileStorageUtil$delegate", "Lkotlin/Lazy;", "getFileStorageUtil", "()Lcom/contentsquare/android/core/utils/FileStorageUtil;", "fileStorageUtil", "Lcom/contentsquare/android/sdk/J6;", "staticCollector$delegate", "getStaticCollector", "()Lcom/contentsquare/android/sdk/J6;", "staticCollector", "", "Lcom/contentsquare/android/sdk/a7;", "agents$delegate", "getAgents", "()Ljava/util/List;", "agents", "Lcom/contentsquare/android/sdk/s7;", "subscribers$delegate", "getSubscribers", "subscribers", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner$library_release", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner$library_release", "(Landroidx/lifecycle/LifecycleOwner;)V", "getLifecycleOwner$library_release$annotations", "Lcom/contentsquare/android/sdk/h7;", "telemetryManager", "Lcom/contentsquare/android/sdk/h7;", "getTelemetryManager$library_release", "()Lcom/contentsquare/android/sdk/h7;", "setTelemetryManager$library_release", "(Lcom/contentsquare/android/sdk/h7;)V", "Lcom/contentsquare/android/core/CoreModule;", "getCoreModule", "()Lcom/contentsquare/android/core/CoreModule;", "coreModule", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTelemetry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Telemetry.kt\ncom/contentsquare/android/internal/core/telemetry/Telemetry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1855#2,2:205\n1855#2,2:207\n*S KotlinDebug\n*F\n+ 1 Telemetry.kt\ncom/contentsquare/android/internal/core/telemetry/Telemetry\n*L\n162#1:205,2\n166#1:207,2\n*E\n"})
public final class Telemetry {
    private static Application application;

    @Nullable
    private static C2768h7 telemetryManager;

    @NotNull
    public static final Telemetry INSTANCE = new Telemetry();

    /* JADX INFO: renamed from: fileStorageUtil$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy fileStorageUtil = LazyKt.lazy(C2414b.f1261a);

    /* JADX INFO: renamed from: staticCollector$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy staticCollector = LazyKt.lazy(C2415c.f1262a);

    /* JADX INFO: renamed from: agents$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy agents = LazyKt.lazy(C2413a.f1260a);

    /* JADX INFO: renamed from: subscribers$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy subscribers = LazyKt.lazy(C2416d.f1263a);

    @NotNull
    private static LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.INSTANCE.get();

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.Telemetry$a */
    public static final class C2413a extends Lambda implements Function0<List<? extends C2580O3>> {

        /* JADX INFO: renamed from: a */
        public static final C2413a f1260a = new C2413a();

        public C2413a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends C2580O3> invoke() {
            C2477E0 c2477e0 = new C2477E0();
            Telemetry telemetry = Telemetry.INSTANCE;
            FileStorageUtil fileStorageUtil = telemetry.getFileStorageUtil();
            Application application = Telemetry.application;
            Application application2 = null;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
                application = null;
            }
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
            C2580O3 c2580o3 = new C2580O3(c2477e0, new C2858q7(fileStorageUtil, applicationContext, "cpu"));
            C2805l4 c2805l4 = new C2805l4();
            FileStorageUtil fileStorageUtil2 = telemetry.getFileStorageUtil();
            Application application3 = Telemetry.application;
            if (application3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application3;
            }
            Context applicationContext2 = application2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "application.applicationContext");
            return CollectionsKt.listOf((Object[]) new C2580O3[]{c2580o3, new C2580O3(c2805l4, new C2858q7(fileStorageUtil2, applicationContext2, "ram"))});
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.Telemetry$b */
    public static final class C2414b extends Lambda implements Function0<FileStorageUtil> {

        /* JADX INFO: renamed from: a */
        public static final C2414b f1261a = new C2414b();

        public C2414b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final FileStorageUtil invoke() {
            return new FileStorageUtil();
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.Telemetry$c */
    public static final class C2415c extends Lambda implements Function0<C2533J6> {

        /* JADX INFO: renamed from: a */
        public static final C2415c f1262a = new C2415c();

        public C2415c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2533J6 invoke() {
            Telemetry telemetry = Telemetry.INSTANCE;
            DeviceInfo deviceInfo = telemetry.getCoreModule().getDeviceInfo();
            JsonConfig.ProjectConfiguration projectConfig = telemetry.getCoreModule().getConfiguration().getProjectConfig();
            Application application = Telemetry.application;
            Application application2 = null;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
                application = null;
            }
            ClassLoader classLoader = application.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "application.classLoader");
            C2702b1 c2702b1 = new C2702b1(classLoader);
            Application application3 = Telemetry.application;
            if (application3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application3;
            }
            return new C2533J6(deviceInfo, projectConfig, c2702b1, application2);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.Telemetry$d */
    public static final class C2416d extends Lambda implements Function0<List<? extends AbstractC2878s7>> {

        /* JADX INFO: renamed from: a */
        public static final C2416d f1263a = new C2416d();

        public C2416d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC2878s7> invoke() {
            Telemetry telemetry = Telemetry.INSTANCE;
            return CollectionsKt.listOf((Object[]) new AbstractC2878s7[]{new C2818m7(telemetry.getCoreModule().getDeviceInfo(), telemetry.getCoreModule().getConfiguration()), new C2758g7(telemetry.getCoreModule().getDeviceInfo(), telemetry.getCoreModule().getConfiguration())});
        }
    }

    private Telemetry() {
    }

    private final List<InterfaceC2698a7> getAgents() {
        return (List) agents.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreModule getCoreModule() {
        CoreModule.Companion companion = CoreModule.INSTANCE;
        Application application2 = application;
        if (application2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            application2 = null;
        }
        return companion.safeInstance(application2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileStorageUtil getFileStorageUtil() {
        return (FileStorageUtil) fileStorageUtil.getValue();
    }

    @VisibleForTesting
    public static /* synthetic */ void getLifecycleOwner$library_release$annotations() {
    }

    private final C2533J6 getStaticCollector() {
        return (C2533J6) staticCollector.getValue();
    }

    private final List<AbstractC2878s7> getSubscribers() {
        return (List) subscribers.getValue();
    }

    public final <T> void collect$library_release(@NotNull String name, @NotNull T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.m1147a("custom." + name, value);
        }
    }

    @Nullable
    public final Unit collectApiCall(@NotNull String apiName) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(apiName, "name");
        telemetryManager$library_release.f2705e.m1125a(new ApiUsageEvent(apiName, 1L));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LifecycleOwner getLifecycleOwner$library_release() {
        return lifecycleOwner;
    }

    @Nullable
    public final C2768h7 getTelemetryManager$library_release() {
        C2768h7 c2768h7;
        C2768h7 c2768h8 = telemetryManager;
        if (c2768h8 != null) {
            return c2768h8;
        }
        Application application2 = application;
        if (application2 != null) {
            c2768h7 = new C2768h7(application2, getCoreModule().getPreferencesStore(), ProcessLifecycleOwner.INSTANCE.get(), new C2808l7(getCoreModule().getPreferencesStore(), getCoreModule().getDeviceInfo()), getStaticCollector(), getCoreModule().getDeviceInfo(), getCoreModule().getConfiguration());
        } else {
            c2768h7 = null;
        }
        telemetryManager = c2768h7;
        return c2768h7;
    }

    @JvmName(name = "init")
    public final void init(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.m1145a();
        }
    }

    public final void measureExecutionTime(@NotNull String key, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(block, "block");
            C2444A7 c2444a7 = telemetryManager$library_release.f2706f;
            c2444a7.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(block, "block");
            C2444A7.m866a(c2444a7, key);
            block.invoke();
            C2444A7.m867b(c2444a7, key);
        }
    }

    public final void notifyPAisStarted$library_release(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.m1148b();
        }
        C2768h7 telemetryManager$library_release2 = getTelemetryManager$library_release();
        if (telemetryManager$library_release2 != null) {
            Boolean value = Boolean.TRUE;
            Intrinsics.checkNotNullParameter("is_heap_started", "key");
            Intrinsics.checkNotNullParameter(value, "value");
            C2533J6 c2533j6 = telemetryManager$library_release2.f2708h;
            c2533j6.getClass();
            Intrinsics.checkNotNullParameter("is_heap_started", "key");
            Intrinsics.checkNotNullParameter(value, "value");
            c2533j6.f1762e.put("is_heap_started", value);
        }
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.core.telemetry.Telemetry$notifyPAisStarted$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                if (ContentsquareModule.getInstance() == null) {
                    Telemetry telemetry = Telemetry.INSTANCE;
                    PreferencesStore preferencesStore = telemetry.getCoreModule().getPreferencesStore();
                    PreferencesKey preferencesKey = PreferencesKey.TELEMETRY_IS_FORCED_REPORT_SENT;
                    if (!preferencesStore.getBoolean(preferencesKey, false)) {
                        C2768h7 telemetryManager$library_release3 = telemetry.getTelemetryManager$library_release();
                        if (telemetryManager$library_release3 != null && telemetryManager$library_release3.f2717q != 2) {
                            telemetryManager$library_release3.f2717q = 2;
                            BuildersKt__Builders_commonKt.launch$default(telemetryManager$library_release3.f2714n, null, null, new C2778i7(telemetryManager$library_release3, null), 3, null);
                        }
                        telemetry.getCoreModule().getPreferencesStore().putBoolean(preferencesKey, true);
                    }
                }
                Telemetry.INSTANCE.getLifecycleOwner$library_release().getLifecycle().removeObserver(this);
            }
        });
    }

    public final void setLifecycleOwner$library_release(@NotNull LifecycleOwner lifecycleOwner2) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<set-?>");
        lifecycleOwner = lifecycleOwner2;
    }

    public final void setTelemetryManager$library_release(@Nullable C2768h7 c2768h7) {
        telemetryManager = c2768h7;
    }

    public final void startMeasureTime(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            C2444A7.m866a(telemetryManager$library_release.f2706f, key);
        }
    }

    public final void startPerformance(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        PreferencesStore preferencesStore = getCoreModule().getPreferencesStore();
        preferencesStore.putInt(PreferencesKey.TELEMETRY_NETWORK_MONITORING_RATE, 1);
        preferencesStore.putInt(PreferencesKey.TELEMETRY_PUBLIC_USAGE_RATE, 1);
        for (InterfaceC2698a7 interfaceC2698a7 : getAgents()) {
            interfaceC2698a7.mo894c();
            C2768h7 telemetryManager$library_release = INSTANCE.getTelemetryManager$library_release();
            if (telemetryManager$library_release != null) {
                telemetryManager$library_release.m1146a(interfaceC2698a7);
            }
        }
        for (AbstractC2878s7 subscriber : getSubscribers()) {
            C2768h7 telemetryManager$library_release2 = INSTANCE.getTelemetryManager$library_release();
            if (telemetryManager$library_release2 != null) {
                Intrinsics.checkNotNullParameter(subscriber, "subscriber");
                if (!telemetryManager$library_release2.f2711k.contains(subscriber)) {
                    telemetryManager$library_release2.f2711k.add(subscriber);
                }
            }
        }
        C2768h7 telemetryManager$library_release3 = getTelemetryManager$library_release();
        if (telemetryManager$library_release3 != null) {
            telemetryManager$library_release3.m1148b();
        }
    }

    public final void stopMeasureTime(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            C2444A7.m867b(telemetryManager$library_release.f2706f, key);
        }
    }

    public final void stopPerformance() {
        C2768h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release == null || telemetryManager$library_release.f2717q == 2) {
            return;
        }
        telemetryManager$library_release.f2717q = 2;
        BuildersKt__Builders_commonKt.launch$default(telemetryManager$library_release.f2714n, null, null, new C2778i7(telemetryManager$library_release, null), 3, null);
    }
}
