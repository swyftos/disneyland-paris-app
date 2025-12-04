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
import com.contentsquare.android.sdk.A7;
import com.contentsquare.android.sdk.AbstractC0807s7;
import com.contentsquare.android.sdk.C0632b1;
import com.contentsquare.android.sdk.C0688g7;
import com.contentsquare.android.sdk.C0698h7;
import com.contentsquare.android.sdk.C0708i7;
import com.contentsquare.android.sdk.C0735l4;
import com.contentsquare.android.sdk.C0738l7;
import com.contentsquare.android.sdk.C0748m7;
import com.contentsquare.android.sdk.C0788q7;
import com.contentsquare.android.sdk.E0;
import com.contentsquare.android.sdk.InterfaceC0628a7;
import com.contentsquare.android.sdk.J6;
import com.contentsquare.android.sdk.O3;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u0006\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J#\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010/R!\u00104\u001a\b\u0012\u0004\u0012\u0002010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010/R(\u00106\u001a\u0002058\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b6\u00107\u0012\u0004\b<\u0010\u0003\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010>\u001a\u0004\u0018\u00010=8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/contentsquare/android/internal/core/telemetry/Telemetry;", "", "<init>", "()V", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "init", "(Landroid/app/Application;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "value", "collect$library_release", "(Ljava/lang/String;Ljava/lang/Object;)V", "collect", "key", "startMeasureTime", "(Ljava/lang/String;)V", "stopMeasureTime", "Lkotlin/Function0;", "block", "measureExecutionTime", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "apiName", "collectApiCall", "(Ljava/lang/String;)Lkotlin/Unit;", "startPerformance", "stopPerformance", "notifyPAisStarted$library_release", "notifyPAisStarted", "Landroid/app/Application;", "Lcom/contentsquare/android/core/utils/FileStorageUtil;", "fileStorageUtil$delegate", "Lkotlin/Lazy;", "getFileStorageUtil", "()Lcom/contentsquare/android/core/utils/FileStorageUtil;", "fileStorageUtil", "Lcom/contentsquare/android/sdk/J6;", "staticCollector$delegate", "getStaticCollector", "()Lcom/contentsquare/android/sdk/J6;", "staticCollector", "", "Lcom/contentsquare/android/sdk/a7;", "agents$delegate", "getAgents", "()Ljava/util/List;", "agents", "Lcom/contentsquare/android/sdk/s7;", "subscribers$delegate", "getSubscribers", "subscribers", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner$library_release", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner$library_release", "(Landroidx/lifecycle/LifecycleOwner;)V", "getLifecycleOwner$library_release$annotations", "Lcom/contentsquare/android/sdk/h7;", "telemetryManager", "Lcom/contentsquare/android/sdk/h7;", "getTelemetryManager$library_release", "()Lcom/contentsquare/android/sdk/h7;", "setTelemetryManager$library_release", "(Lcom/contentsquare/android/sdk/h7;)V", "Lcom/contentsquare/android/core/CoreModule;", "getCoreModule", "()Lcom/contentsquare/android/core/CoreModule;", "coreModule", "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTelemetry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Telemetry.kt\ncom/contentsquare/android/internal/core/telemetry/Telemetry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1855#2,2:205\n1855#2,2:207\n*S KotlinDebug\n*F\n+ 1 Telemetry.kt\ncom/contentsquare/android/internal/core/telemetry/Telemetry\n*L\n162#1:205,2\n166#1:207,2\n*E\n"})
/* loaded from: classes2.dex */
public final class Telemetry {
    private static Application application;

    @Nullable
    private static C0698h7 telemetryManager;

    @NotNull
    public static final Telemetry INSTANCE = new Telemetry();

    /* renamed from: fileStorageUtil$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy fileStorageUtil = LazyKt.lazy(b.a);

    /* renamed from: staticCollector$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy staticCollector = LazyKt.lazy(c.a);

    /* renamed from: agents$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy agents = LazyKt.lazy(a.a);

    /* renamed from: subscribers$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy subscribers = LazyKt.lazy(d.a);

    @NotNull
    private static LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.INSTANCE.get();

    public static final class a extends Lambda implements Function0<List<? extends O3>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends O3> invoke() {
            E0 e0 = new E0();
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
            O3 o3 = new O3(e0, new C0788q7(fileStorageUtil, applicationContext, "cpu"));
            C0735l4 c0735l4 = new C0735l4();
            FileStorageUtil fileStorageUtil2 = telemetry.getFileStorageUtil();
            Application application3 = Telemetry.application;
            if (application3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application3;
            }
            Context applicationContext2 = application2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "application.applicationContext");
            return CollectionsKt.listOf((Object[]) new O3[]{o3, new O3(c0735l4, new C0788q7(fileStorageUtil2, applicationContext2, "ram"))});
        }
    }

    public static final class b extends Lambda implements Function0<FileStorageUtil> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final FileStorageUtil invoke() {
            return new FileStorageUtil();
        }
    }

    public static final class c extends Lambda implements Function0<J6> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final J6 invoke() {
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
            C0632b1 c0632b1 = new C0632b1(classLoader);
            Application application3 = Telemetry.application;
            if (application3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application3;
            }
            return new J6(deviceInfo, projectConfig, c0632b1, application2);
        }
    }

    public static final class d extends Lambda implements Function0<List<? extends AbstractC0807s7>> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AbstractC0807s7> invoke() {
            Telemetry telemetry = Telemetry.INSTANCE;
            return CollectionsKt.listOf((Object[]) new AbstractC0807s7[]{new C0748m7(telemetry.getCoreModule().getDeviceInfo(), telemetry.getCoreModule().getConfiguration()), new C0688g7(telemetry.getCoreModule().getDeviceInfo(), telemetry.getCoreModule().getConfiguration())});
        }
    }

    private Telemetry() {
    }

    private final List<InterfaceC0628a7> getAgents() {
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

    private final J6 getStaticCollector() {
        return (J6) staticCollector.getValue();
    }

    private final List<AbstractC0807s7> getSubscribers() {
        return (List) subscribers.getValue();
    }

    public final <T> void collect$library_release(@NotNull String name, @NotNull T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("custom." + name, value);
        }
    }

    @Nullable
    public final Unit collectApiCall(@NotNull String apiName) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(apiName, "name");
        telemetryManager$library_release.e.a(new ApiUsageEvent(apiName, 1L));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LifecycleOwner getLifecycleOwner$library_release() {
        return lifecycleOwner;
    }

    @Nullable
    public final C0698h7 getTelemetryManager$library_release() {
        C0698h7 c0698h7;
        C0698h7 c0698h72 = telemetryManager;
        if (c0698h72 != null) {
            return c0698h72;
        }
        Application application2 = application;
        if (application2 != null) {
            c0698h7 = new C0698h7(application2, getCoreModule().getPreferencesStore(), ProcessLifecycleOwner.INSTANCE.get(), new C0738l7(getCoreModule().getPreferencesStore(), getCoreModule().getDeviceInfo()), getStaticCollector(), getCoreModule().getDeviceInfo(), getCoreModule().getConfiguration());
        } else {
            c0698h7 = null;
        }
        telemetryManager = c0698h7;
        return c0698h7;
    }

    @JvmName(name = "init")
    public final void init(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a();
        }
    }

    public final void measureExecutionTime(@NotNull String key, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(block, "block");
            A7 a7 = telemetryManager$library_release.f;
            a7.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(block, "block");
            A7.a(a7, key);
            block.invoke();
            A7.b(a7, key);
        }
    }

    public final void notifyPAisStarted$library_release(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.b();
        }
        C0698h7 telemetryManager$library_release2 = getTelemetryManager$library_release();
        if (telemetryManager$library_release2 != null) {
            Boolean value = Boolean.TRUE;
            Intrinsics.checkNotNullParameter("is_heap_started", "key");
            Intrinsics.checkNotNullParameter(value, "value");
            J6 j6 = telemetryManager$library_release2.h;
            j6.getClass();
            Intrinsics.checkNotNullParameter("is_heap_started", "key");
            Intrinsics.checkNotNullParameter(value, "value");
            j6.e.put("is_heap_started", value);
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
                        C0698h7 telemetryManager$library_release3 = telemetry.getTelemetryManager$library_release();
                        if (telemetryManager$library_release3 != null && telemetryManager$library_release3.q != 2) {
                            telemetryManager$library_release3.q = 2;
                            BuildersKt__Builders_commonKt.launch$default(telemetryManager$library_release3.n, null, null, new C0708i7(telemetryManager$library_release3, null), 3, null);
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

    public final void setTelemetryManager$library_release(@Nullable C0698h7 c0698h7) {
        telemetryManager = c0698h7;
    }

    public final void startMeasureTime(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            A7.a(telemetryManager$library_release.f, key);
        }
    }

    public final void startPerformance(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        PreferencesStore preferencesStore = getCoreModule().getPreferencesStore();
        preferencesStore.putInt(PreferencesKey.TELEMETRY_NETWORK_MONITORING_RATE, 1);
        preferencesStore.putInt(PreferencesKey.TELEMETRY_PUBLIC_USAGE_RATE, 1);
        for (InterfaceC0628a7 interfaceC0628a7 : getAgents()) {
            interfaceC0628a7.c();
            C0698h7 telemetryManager$library_release = INSTANCE.getTelemetryManager$library_release();
            if (telemetryManager$library_release != null) {
                telemetryManager$library_release.a(interfaceC0628a7);
            }
        }
        for (AbstractC0807s7 subscriber : getSubscribers()) {
            C0698h7 telemetryManager$library_release2 = INSTANCE.getTelemetryManager$library_release();
            if (telemetryManager$library_release2 != null) {
                Intrinsics.checkNotNullParameter(subscriber, "subscriber");
                if (!telemetryManager$library_release2.k.contains(subscriber)) {
                    telemetryManager$library_release2.k.add(subscriber);
                }
            }
        }
        C0698h7 telemetryManager$library_release3 = getTelemetryManager$library_release();
        if (telemetryManager$library_release3 != null) {
            telemetryManager$library_release3.b();
        }
    }

    public final void stopMeasureTime(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            A7.b(telemetryManager$library_release.f, key);
        }
    }

    public final void stopPerformance() {
        C0698h7 telemetryManager$library_release = getTelemetryManager$library_release();
        if (telemetryManager$library_release == null || telemetryManager$library_release.q == 2) {
            return;
        }
        telemetryManager$library_release.q = 2;
        BuildersKt__Builders_commonKt.launch$default(telemetryManager$library_release.n, null, null, new C0708i7(telemetryManager$library_release, null), 3, null);
    }
}
