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
import com.contentsquare.android.sdk.C0676f5;
import com.contentsquare.android.sdk.C0696h5;
import com.contentsquare.android.sdk.C0710j;
import com.contentsquare.android.sdk.C0835v5;
import com.contentsquare.android.sdk.E1;
import com.contentsquare.android.sdk.I1;
import com.contentsquare.android.sdk.InterfaceC0832v2;
import com.contentsquare.android.sdk.J0;
import com.contentsquare.android.sdk.K0;
import com.contentsquare.android.sdk.L0;
import com.contentsquare.android.sdk.L2;
import com.contentsquare.android.sdk.L3;
import com.contentsquare.android.sdk.M2;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC0825u5;
import com.contentsquare.android.sdk.W1;
import com.contentsquare.android.sdk.Y4;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes2.dex */
public class CsRuntimeModule {

    @Nullable
    @VisibleForTesting
    public static CsRuntimeModule sCsRuntimeModule;
    public final L3 a;
    public final L2 b;
    public final J0 c;
    public final C0696h5 d;

    @NonNull
    public final M4 e;

    @NonNull
    public final ConfigurationRefresher f;

    public CsRuntimeModule(@NonNull Application application) {
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance(application);
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(application);
        L3 l3 = new L3(application, csApplicationModule.getViewUtil());
        this.a = l3;
        L0 l0 = new L0(csApplicationModule.getSdkManager(), application, new DisplayMetrics());
        Y4 listener = new Y4(csApplicationModule.getEventsBuildersFactory(), csApplicationModule.getAnalyticsPipeline(), coreModuleSafeInstance.getDeviceInfo());
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!l0.d.contains(listener)) {
            l0.d.add(listener);
        }
        L2 legacyComponentsHolder = new L2(application, csApplicationModule.getEventsStatusPrefsHelper(), csApplicationModule.getAnalyticsPipeline(), coreModuleSafeInstance.getConfiguration(), csApplicationModule.getEventsProcessor(), l0, coreModuleSafeInstance.getPreferencesStore());
        this.b = legacyComponentsHolder;
        ContentsquareModule contentsquareModule = ContentsquareModule.getInstance(application);
        C0710j analyticsPipeline = csApplicationModule.getAnalyticsPipeline();
        C0676f5 screenViewEventsHandler = C0676f5.a;
        C0696h5 screenViewHandler = new C0696h5(l3, analyticsPipeline, csApplicationModule.getEventsBuildersFactory(), csApplicationModule.getGesturesInterceptor(), contentsquareModule.getLiveActivityProvider(), coreModuleSafeInstance.getPreferencesStore());
        this.d = screenViewHandler;
        Logger logger = K0.e;
        K0 k0A = K0.a.a(application);
        I1 eventsStatusPrefsHelper = csApplicationModule.getEventsStatusPrefsHelper();
        C0710j analyticsPipeline2 = csApplicationModule.getAnalyticsPipeline();
        k0A.c.getClass();
        List notToBeTrackedActivityFilters = Collections.singletonList(new ClientModeManagerImpl.a());
        E1 eventsBuildersFactory = csApplicationModule.getEventsBuildersFactory();
        InterfaceC0832v2 gesturesInterceptor = csApplicationModule.getGesturesInterceptor();
        M2 liveActivityProvider = contentsquareModule.getLiveActivityProvider();
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
        this.c = new J0(legacyComponentsHolder, eventsStatusPrefsHelper, analyticsPipeline2, notToBeTrackedActivityFilters, eventsBuildersFactory, gesturesInterceptor, screenViewHandler, liveActivityProvider, deviceInfo, new ViewTreeObserverOnGlobalLayoutListenerC0825u5(new C0835v5(new Debouncer(250L, CoroutineScopeKt.MainScope()))));
        M4 m4 = new M4(legacyComponentsHolder, new W1(application, csApplicationModule.getStorageCleaner(), csApplicationModule.getUserConfigurationHelper(), csApplicationModule.getEventsStatusPrefsHelper(), legacyComponentsHolder), csApplicationModule.getSdkManager());
        this.e = m4;
        this.f = new ConfigurationRefresher(ProcessLifecycleOwner.get(), application, new ConfigDownloaderFactory(), m4.a(), coreModuleSafeInstance.getConfiguration());
    }

    @Nullable
    public static CsRuntimeModule getInstance() {
        return sCsRuntimeModule;
    }

    public ConfigurationRefresher getConfigurationRefresher() {
        return this.f;
    }

    @NonNull
    public J0 getCsActivityCallbacks() {
        return this.c;
    }

    @NonNull
    public L2 getLegacyComponentsHolder() {
        return this.b;
    }

    @NonNull
    public L3 getPathGenerator() {
        return this.a;
    }

    @NonNull
    public M4 getRunTime() {
        return this.e;
    }

    public C0696h5 getScreenViewHandler() {
        return this.d;
    }

    @NonNull
    public static CsRuntimeModule getInstance(@NonNull Application application) {
        if (sCsRuntimeModule == null) {
            sCsRuntimeModule = new CsRuntimeModule(application);
        }
        return sCsRuntimeModule;
    }
}
