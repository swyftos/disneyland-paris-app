package com.contentsquare.android.internal.features.initialize;

import android.app.Application;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.contentsquare.android.analytics.internal.features.clientmode.manager.ClientModeManagerImpl;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.ConfigurationRefresher;
import com.contentsquare.android.core.features.config.network.ConfigDownloaderFactory;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.Debouncer;
import com.contentsquare.android.sdk.C2478E1;
import com.contentsquare.android.sdk.C2518I1;
import com.contentsquare.android.sdk.C2527J0;
import com.contentsquare.android.sdk.C2537K0;
import com.contentsquare.android.sdk.C2549L2;
import com.contentsquare.android.sdk.C2550L3;
import com.contentsquare.android.sdk.C2559M2;
import com.contentsquare.android.sdk.C2561M4;
import com.contentsquare.android.sdk.C2656W1;
import com.contentsquare.android.sdk.C2677Y4;
import com.contentsquare.android.sdk.C2746f5;
import com.contentsquare.android.sdk.C2766h5;
import com.contentsquare.android.sdk.C2780j;
import com.contentsquare.android.sdk.C2906v5;
import com.contentsquare.android.sdk.ComponentCallbacksC2547L0;
import com.contentsquare.android.sdk.InterfaceC2903v2;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC2896u5;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes2.dex */
public class CsRuntimeModule {

    @Nullable
    @VisibleForTesting
    public static CsRuntimeModule sCsRuntimeModule;

    /* JADX INFO: renamed from: a */
    public final C2550L3 f1312a;

    /* JADX INFO: renamed from: b */
    public final C2549L2 f1313b;

    /* JADX INFO: renamed from: c */
    public final C2527J0 f1314c;

    /* JADX INFO: renamed from: d */
    public final C2766h5 f1315d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C2561M4 f1316e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ConfigurationRefresher f1317f;

    public CsRuntimeModule(@NonNull Application application) {
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance(application);
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(application);
        C2550L3 c2550l3 = new C2550L3(application, csApplicationModule.getViewUtil());
        this.f1312a = c2550l3;
        ComponentCallbacksC2547L0 componentCallbacksC2547L0 = new ComponentCallbacksC2547L0(csApplicationModule.getSdkManager(), application, new DisplayMetrics());
        C2677Y4 listener = new C2677Y4(csApplicationModule.getEventsBuildersFactory(), csApplicationModule.getAnalyticsPipeline(), coreModuleSafeInstance.getDeviceInfo());
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!componentCallbacksC2547L0.f1805d.contains(listener)) {
            componentCallbacksC2547L0.f1805d.add(listener);
        }
        C2549L2 legacyComponentsHolder = new C2549L2(application, csApplicationModule.getEventsStatusPrefsHelper(), csApplicationModule.getAnalyticsPipeline(), coreModuleSafeInstance.getConfiguration(), csApplicationModule.getEventsProcessor(), componentCallbacksC2547L0, coreModuleSafeInstance.getPreferencesStore());
        this.f1313b = legacyComponentsHolder;
        ContentsquareModule contentsquareModule = ContentsquareModule.getInstance(application);
        C2780j analyticsPipeline = csApplicationModule.getAnalyticsPipeline();
        C2746f5 screenViewEventsHandler = C2746f5.f2632a;
        C2766h5 screenViewHandler = new C2766h5(c2550l3, analyticsPipeline, csApplicationModule.getEventsBuildersFactory(), csApplicationModule.getGesturesInterceptor(), contentsquareModule.getLiveActivityProvider(), coreModuleSafeInstance.getPreferencesStore());
        this.f1315d = screenViewHandler;
        Logger logger = C2537K0.f1765e;
        C2537K0 c2537k0M958a = C2537K0.a.m958a(application);
        C2518I1 eventsStatusPrefsHelper = csApplicationModule.getEventsStatusPrefsHelper();
        C2780j analyticsPipeline2 = csApplicationModule.getAnalyticsPipeline();
        c2537k0M958a.f1769c.getClass();
        List notToBeTrackedActivityFilters = Collections.singletonList(new ClientModeManagerImpl.C2363a());
        C2478E1 eventsBuildersFactory = csApplicationModule.getEventsBuildersFactory();
        InterfaceC2903v2 gesturesInterceptor = csApplicationModule.getGesturesInterceptor();
        C2559M2 liveActivityProvider = contentsquareModule.getLiveActivityProvider();
        DeviceInfo deviceInfo = coreModuleSafeInstance.getDeviceInfo();
        Intrinsics.checkNotNullParameter(legacyComponentsHolder, "legacyComponentsHolder");
        Intrinsics.checkNotNullParameter(eventsStatusPrefsHelper, "eventsStatusPrefsHelper");
        Intrinsics.checkNotNullParameter(analyticsPipeline2, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(notToBeTrackedActivityFilters, "notToBeTrackedActivityFilters");
        Intrinsics.checkNotNullParameter(screenViewEventsHandler, "screenViewEventsHandler");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(gesturesInterceptor, "gesturesInterceptor");
        Intrinsics.checkNotNullParameter(screenViewHandler, "screenViewHandler");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f1314c = new C2527J0(legacyComponentsHolder, eventsStatusPrefsHelper, analyticsPipeline2, notToBeTrackedActivityFilters, eventsBuildersFactory, gesturesInterceptor, screenViewHandler, liveActivityProvider, deviceInfo, new ViewTreeObserverOnGlobalLayoutListenerC2896u5(new C2906v5(new Debouncer(250L, CoroutineScopeKt.MainScope()))));
        C2561M4 c2561m4 = new C2561M4(legacyComponentsHolder, new C2656W1(application, csApplicationModule.getStorageCleaner(), csApplicationModule.getUserConfigurationHelper(), csApplicationModule.getEventsStatusPrefsHelper(), legacyComponentsHolder), csApplicationModule.getSdkManager());
        this.f1316e = c2561m4;
        this.f1317f = new ConfigurationRefresher(ProcessLifecycleOwner.get(), application, new ConfigDownloaderFactory(), c2561m4.m986a(), coreModuleSafeInstance.getConfiguration());
    }

    @Nullable
    public static CsRuntimeModule getInstance() {
        return sCsRuntimeModule;
    }

    public ConfigurationRefresher getConfigurationRefresher() {
        return this.f1317f;
    }

    @NonNull
    public C2527J0 getCsActivityCallbacks() {
        return this.f1314c;
    }

    @NonNull
    public C2549L2 getLegacyComponentsHolder() {
        return this.f1313b;
    }

    @NonNull
    public C2550L3 getPathGenerator() {
        return this.f1312a;
    }

    @NonNull
    public C2561M4 getRunTime() {
        return this.f1316e;
    }

    public C2766h5 getScreenViewHandler() {
        return this.f1315d;
    }

    @NonNull
    public static CsRuntimeModule getInstance(@NonNull Application application) {
        if (sCsRuntimeModule == null) {
            sCsRuntimeModule = new CsRuntimeModule(application);
        }
        return sCsRuntimeModule;
    }
}
