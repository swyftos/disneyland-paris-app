package com.contentsquare.android.internal.features.initialize;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.core.utils.ThreadExecutor;
import com.contentsquare.android.internal.features.srm.SrmKeysCache;
import com.contentsquare.android.sdk.C2438A1;
import com.contentsquare.android.sdk.C2442A5;
import com.contentsquare.android.sdk.C2453B6;
import com.contentsquare.android.sdk.C2478E1;
import com.contentsquare.android.sdk.C2494F7;
import com.contentsquare.android.sdk.C2498G1;
import com.contentsquare.android.sdk.C2518I1;
import com.contentsquare.android.sdk.C2536K;
import com.contentsquare.android.sdk.C2544K7;
import com.contentsquare.android.sdk.C2552L5;
import com.contentsquare.android.sdk.C2563M6;
import com.contentsquare.android.sdk.C2564M7;
import com.contentsquare.android.sdk.C2579O2;
import com.contentsquare.android.sdk.C2589P2;
import com.contentsquare.android.sdk.C2598Q1;
import com.contentsquare.android.sdk.C2622S6;
import com.contentsquare.android.sdk.C2674Y1;
import com.contentsquare.android.sdk.C2714c3;
import com.contentsquare.android.sdk.C2733e2;
import com.contentsquare.android.sdk.C2753g2;
import com.contentsquare.android.sdk.C2780j;
import com.contentsquare.android.sdk.C2793k2;
import com.contentsquare.android.sdk.C2909v8;
import com.contentsquare.android.sdk.C2926x5;
import com.contentsquare.android.sdk.C2932y1;
import com.contentsquare.android.sdk.C2942z1;
import com.contentsquare.android.sdk.C2943z2;
import com.contentsquare.android.sdk.C2947z6;
import com.contentsquare.android.sdk.InterfaceC2735e4;
import com.contentsquare.android.sdk.InterfaceC2903v2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class CsApplicationModule {

    @Nullable
    @VisibleForTesting
    public static CsApplicationModule sCsApplicationModule;

    @NonNull
    @VisibleForTesting
    public static Logger sLogger = new Logger("CsApplicationModule");

    /* JADX INFO: renamed from: a */
    public final Application f1290a;

    /* JADX INFO: renamed from: b */
    public final C2943z2 f1291b;

    /* JADX INFO: renamed from: c */
    public final C2552L5 f1292c;

    /* JADX INFO: renamed from: d */
    public final SystemInstantiable f1293d;

    /* JADX INFO: renamed from: e */
    public final C2909v8 f1294e;

    /* JADX INFO: renamed from: f */
    public final C2622S6 f1295f;

    /* JADX INFO: renamed from: g */
    public final ThreadExecutor f1296g;

    /* JADX INFO: renamed from: h */
    public final C2518I1 f1297h;

    /* JADX INFO: renamed from: i */
    public final ExecutorService f1298i;

    /* JADX INFO: renamed from: j */
    public final C2926x5 f1299j;

    /* JADX INFO: renamed from: k */
    public final C2544K7 f1300k;

    /* JADX INFO: renamed from: l */
    public final C2564M7 f1301l;

    /* JADX INFO: renamed from: m */
    public final C2442A5 f1302m;

    /* JADX INFO: renamed from: n */
    public final C2793k2 f1303n;

    /* JADX INFO: renamed from: o */
    public final C2478E1 f1304o;

    /* JADX INFO: renamed from: p */
    public final C2498G1 f1305p;

    /* JADX INFO: renamed from: q */
    public final C2579O2 f1306q;

    /* JADX INFO: renamed from: r */
    public final C2563M6 f1307r;

    /* JADX INFO: renamed from: s */
    public final BridgeManager f1308s;

    /* JADX INFO: renamed from: t */
    public final C2536K f1309t;

    /* JADX INFO: renamed from: u */
    public final C2753g2 f1310u;

    /* JADX INFO: renamed from: v */
    public final C2780j f1311v;

    public CsApplicationModule(@NonNull Application application) {
        this.f1290a = application;
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(application);
        this.f1293d = new SystemInstantiable();
        this.f1294e = new C2909v8();
        this.f1295f = new C2622S6(application);
        this.f1296g = new ThreadExecutor();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f1298i = executorServiceNewSingleThreadExecutor;
        PreferencesStore preferencesStore = coreModuleSafeInstance.getPreferencesStore();
        C2518I1 c2518i1 = new C2518I1(preferencesStore);
        this.f1297h = c2518i1;
        C2943z2 c2943z2 = new C2943z2(preferencesStore, new Logger("InSampleIntervalValidator"));
        this.f1291b = c2943z2;
        C2552L5 c2552l5 = new C2552L5(preferencesStore);
        this.f1292c = c2552l5;
        C2926x5 c2926x5 = new C2926x5(coreModuleSafeInstance.getConfiguration(), c2943z2, preferencesStore);
        this.f1299j = c2926x5;
        C2544K7 c2544k7 = new C2544K7(preferencesStore);
        this.f1300k = c2544k7;
        C2564M7 c2564m7 = new C2564M7(preferencesStore, c2544k7);
        this.f1301l = c2564m7;
        C2780j c2780j = new C2780j(c2926x5);
        this.f1311v = c2780j;
        C2442A5 c2442a5 = new C2442A5(c2552l5, c2564m7, c2780j, coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getDeviceInfo().getBuildInformation(), c2518i1, preferencesStore);
        this.f1302m = c2442a5;
        C2478E1 c2478e1 = new C2478E1(coreModuleSafeInstance.getDeviceInfo(), c2442a5, c2564m7, coreModuleSafeInstance.getConfiguration());
        this.f1304o = c2478e1;
        C2494F7 c2494f7 = new C2494F7(C2598Q1.f1993f);
        C2753g2 c2753g2 = new C2753g2();
        this.f1310u = c2753g2;
        C2793k2 c2793k2 = new C2793k2(new C2733e2(c2494f7, application, new C2674Y1(application, c2494f7, new SystemInstantiable(), new InterfaceC2735e4() { // from class: com.contentsquare.android.internal.features.initialize.CsApplicationModule$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.sdk.InterfaceC2735e4
            public final Object get() {
                return C2714c3.m1108a();
            }
        }), c2478e1, c2780j, c2753g2), ContentsquareModule.getInstance(application).getCaptureTouchEvent());
        this.f1303n = c2793k2;
        c2478e1.f1543e = c2793k2;
        this.f1305p = new C2498G1(new C2942z1(application.getApplicationContext(), c2442a5, c2564m7), c2478e1, executorServiceNewSingleThreadExecutor, c2780j, coreModuleSafeInstance.getConfiguration(), preferencesStore, new C2932y1(), new C2438A1(coreModuleSafeInstance.getConfiguration()));
        this.f1306q = new C2579O2(new HttpConnection(), new C2589P2(application.getApplicationContext(), new FileStorageUtil()));
        this.f1307r = new C2563M6(new C2453B6(coreModuleSafeInstance.getConfiguration()), new SrmKeysCache(new FileStorageUtil(), application.getApplicationContext().getFilesDir().getAbsolutePath()), new C2947z6(new FileStorageUtil(), application.getApplicationContext().getFilesDir().getAbsolutePath()), coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getDeviceInfo().getBuildInformation());
        this.f1308s = new BridgeManager(coreModuleSafeInstance.getConfiguration(), preferencesStore);
        this.f1309t = new C2536K();
    }

    @Nullable
    public static CsApplicationModule getInstance() {
        return sCsApplicationModule;
    }

    @NonNull
    public C2780j getAnalyticsPipeline() {
        return this.f1311v;
    }

    @NonNull
    public Application getApplication() {
        return this.f1290a;
    }

    @NonNull
    public BridgeManager getBridgeManager() {
        return this.f1308s;
    }

    @NonNull
    public C2478E1 getEventsBuildersFactory() {
        return this.f1304o;
    }

    @NonNull
    public C2498G1 getEventsProcessor() {
        return this.f1305p;
    }

    @NonNull
    public C2518I1 getEventsStatusPrefsHelper() {
        return this.f1297h;
    }

    @NonNull
    public C2753g2 getGestureStorage() {
        return this.f1310u;
    }

    @NonNull
    public InterfaceC2903v2 getGesturesInterceptor() {
        return this.f1303n;
    }

    @NonNull
    public C2943z2 getInSampleIntervalValidator() {
        return this.f1291b;
    }

    public C2579O2 getLogProcessor() {
        return this.f1306q;
    }

    @NonNull
    public C2926x5 getSdkManager() {
        return this.f1299j;
    }

    @NonNull
    public C2442A5 getSession() {
        return this.f1302m;
    }

    @NonNull
    public C2552L5 getSessionRestoreHelper() {
        return this.f1292c;
    }

    @NonNull
    public ExecutorService getSingletonThreadExecutorService() {
        return this.f1298i;
    }

    @NonNull
    public C2563M6 getStaticResourceManager() {
        return this.f1307r;
    }

    @NonNull
    public C2622S6 getStorageCleaner() {
        return this.f1295f;
    }

    @NonNull
    public SystemInstantiable getSystem() {
        return this.f1293d;
    }

    @NonNull
    public ThreadExecutor getThreadExecutor() {
        return this.f1296g;
    }

    @NonNull
    public C2544K7 getUserConfigurationHelper() {
        return this.f1300k;
    }

    @NonNull
    public C2564M7 getUserIdRestoreHelper() {
        return this.f1301l;
    }

    @NonNull
    public C2909v8 getViewUtil() {
        return this.f1294e;
    }

    @NonNull
    public C2536K getWebViewAssetCache() {
        return this.f1309t;
    }

    @NonNull
    public static CsApplicationModule getInstance(@NonNull Application application) {
        if (sCsApplicationModule == null) {
            sCsApplicationModule = new CsApplicationModule(application);
            sLogger.m827d("CsApplicationModule singleton is now initialized.");
        }
        return sCsApplicationModule;
    }
}
