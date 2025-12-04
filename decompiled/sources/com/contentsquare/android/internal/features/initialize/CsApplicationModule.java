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
import com.contentsquare.android.sdk.A1;
import com.contentsquare.android.sdk.A5;
import com.contentsquare.android.sdk.B6;
import com.contentsquare.android.sdk.C0644c3;
import com.contentsquare.android.sdk.C0663e2;
import com.contentsquare.android.sdk.C0683g2;
import com.contentsquare.android.sdk.C0710j;
import com.contentsquare.android.sdk.C0723k2;
import com.contentsquare.android.sdk.C0853x5;
import com.contentsquare.android.sdk.C0858y1;
import com.contentsquare.android.sdk.C0867z1;
import com.contentsquare.android.sdk.C0868z2;
import com.contentsquare.android.sdk.C0872z6;
import com.contentsquare.android.sdk.E1;
import com.contentsquare.android.sdk.F7;
import com.contentsquare.android.sdk.G1;
import com.contentsquare.android.sdk.I1;
import com.contentsquare.android.sdk.InterfaceC0665e4;
import com.contentsquare.android.sdk.InterfaceC0832v2;
import com.contentsquare.android.sdk.K;
import com.contentsquare.android.sdk.K7;
import com.contentsquare.android.sdk.L5;
import com.contentsquare.android.sdk.M6;
import com.contentsquare.android.sdk.M7;
import com.contentsquare.android.sdk.O2;
import com.contentsquare.android.sdk.P2;
import com.contentsquare.android.sdk.Q1;
import com.contentsquare.android.sdk.S6;
import com.contentsquare.android.sdk.Y1;
import com.contentsquare.android.sdk.v8;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class CsApplicationModule {

    @Nullable
    @VisibleForTesting
    public static CsApplicationModule sCsApplicationModule;

    @NonNull
    @VisibleForTesting
    public static Logger sLogger = new Logger("CsApplicationModule");
    public final Application a;
    public final C0868z2 b;
    public final L5 c;
    public final SystemInstantiable d;
    public final v8 e;
    public final S6 f;
    public final ThreadExecutor g;
    public final I1 h;
    public final ExecutorService i;
    public final C0853x5 j;
    public final K7 k;
    public final M7 l;
    public final A5 m;
    public final C0723k2 n;
    public final E1 o;
    public final G1 p;
    public final O2 q;
    public final M6 r;
    public final BridgeManager s;
    public final K t;
    public final C0683g2 u;
    public final C0710j v;

    public CsApplicationModule(@NonNull Application application) {
        this.a = application;
        CoreModule coreModuleSafeInstance = CoreModule.safeInstance(application);
        this.d = new SystemInstantiable();
        this.e = new v8();
        this.f = new S6(application);
        this.g = new ThreadExecutor();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.i = executorServiceNewSingleThreadExecutor;
        PreferencesStore preferencesStore = coreModuleSafeInstance.getPreferencesStore();
        I1 i1 = new I1(preferencesStore);
        this.h = i1;
        C0868z2 c0868z2 = new C0868z2(preferencesStore, new Logger("InSampleIntervalValidator"));
        this.b = c0868z2;
        L5 l5 = new L5(preferencesStore);
        this.c = l5;
        C0853x5 c0853x5 = new C0853x5(coreModuleSafeInstance.getConfiguration(), c0868z2, preferencesStore);
        this.j = c0853x5;
        K7 k7 = new K7(preferencesStore);
        this.k = k7;
        M7 m7 = new M7(preferencesStore, k7);
        this.l = m7;
        C0710j c0710j = new C0710j(c0853x5);
        this.v = c0710j;
        A5 a5 = new A5(l5, m7, c0710j, coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getDeviceInfo().getBuildInformation(), i1, preferencesStore);
        this.m = a5;
        E1 e1 = new E1(coreModuleSafeInstance.getDeviceInfo(), a5, m7, coreModuleSafeInstance.getConfiguration());
        this.o = e1;
        F7 f7 = new F7(Q1.f);
        C0683g2 c0683g2 = new C0683g2();
        this.u = c0683g2;
        C0723k2 c0723k2 = new C0723k2(new C0663e2(f7, application, new Y1(application, f7, new SystemInstantiable(), new InterfaceC0665e4() { // from class: com.contentsquare.android.internal.features.initialize.CsApplicationModule$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.sdk.InterfaceC0665e4
            public final Object get() {
                return C0644c3.a();
            }
        }), e1, c0710j, c0683g2), ContentsquareModule.getInstance(application).getCaptureTouchEvent());
        this.n = c0723k2;
        e1.e = c0723k2;
        this.p = new G1(new C0867z1(application.getApplicationContext(), a5, m7), e1, executorServiceNewSingleThreadExecutor, c0710j, coreModuleSafeInstance.getConfiguration(), preferencesStore, new C0858y1(), new A1(coreModuleSafeInstance.getConfiguration()));
        this.q = new O2(new HttpConnection(), new P2(application.getApplicationContext(), new FileStorageUtil()));
        this.r = new M6(new B6(coreModuleSafeInstance.getConfiguration()), new SrmKeysCache(new FileStorageUtil(), application.getApplicationContext().getFilesDir().getAbsolutePath()), new C0872z6(new FileStorageUtil(), application.getApplicationContext().getFilesDir().getAbsolutePath()), coreModuleSafeInstance.getConfiguration(), coreModuleSafeInstance.getDeviceInfo().getBuildInformation());
        this.s = new BridgeManager(coreModuleSafeInstance.getConfiguration(), preferencesStore);
        this.t = new K();
    }

    @Nullable
    public static CsApplicationModule getInstance() {
        return sCsApplicationModule;
    }

    @NonNull
    public C0710j getAnalyticsPipeline() {
        return this.v;
    }

    @NonNull
    public Application getApplication() {
        return this.a;
    }

    @NonNull
    public BridgeManager getBridgeManager() {
        return this.s;
    }

    @NonNull
    public E1 getEventsBuildersFactory() {
        return this.o;
    }

    @NonNull
    public G1 getEventsProcessor() {
        return this.p;
    }

    @NonNull
    public I1 getEventsStatusPrefsHelper() {
        return this.h;
    }

    @NonNull
    public C0683g2 getGestureStorage() {
        return this.u;
    }

    @NonNull
    public InterfaceC0832v2 getGesturesInterceptor() {
        return this.n;
    }

    @NonNull
    public C0868z2 getInSampleIntervalValidator() {
        return this.b;
    }

    public O2 getLogProcessor() {
        return this.q;
    }

    @NonNull
    public C0853x5 getSdkManager() {
        return this.j;
    }

    @NonNull
    public A5 getSession() {
        return this.m;
    }

    @NonNull
    public L5 getSessionRestoreHelper() {
        return this.c;
    }

    @NonNull
    public ExecutorService getSingletonThreadExecutorService() {
        return this.i;
    }

    @NonNull
    public M6 getStaticResourceManager() {
        return this.r;
    }

    @NonNull
    public S6 getStorageCleaner() {
        return this.f;
    }

    @NonNull
    public SystemInstantiable getSystem() {
        return this.d;
    }

    @NonNull
    public ThreadExecutor getThreadExecutor() {
        return this.g;
    }

    @NonNull
    public K7 getUserConfigurationHelper() {
        return this.k;
    }

    @NonNull
    public M7 getUserIdRestoreHelper() {
        return this.l;
    }

    @NonNull
    public v8 getViewUtil() {
        return this.e;
    }

    @NonNull
    public K getWebViewAssetCache() {
        return this.t;
    }

    @NonNull
    public static CsApplicationModule getInstance(@NonNull Application application) {
        if (sCsApplicationModule == null) {
            sCsApplicationModule = new CsApplicationModule(application);
            sLogger.d("CsApplicationModule singleton is now initialized.");
        }
        return sCsApplicationModule;
    }
}
