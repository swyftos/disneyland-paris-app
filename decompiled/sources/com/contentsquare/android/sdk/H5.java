package com.contentsquare.android.sdk;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor;
import com.contentsquare.android.sdk.C5;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class H5 {

    @NotNull
    public final Application a;

    @NotNull
    public final a b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final D5 d;

    @NotNull
    public final C0745m4 e;

    @NotNull
    public final BuildInformation f;

    @NotNull
    public final O4 g;

    @NotNull
    public final Logger h;

    public static final class a {
    }

    public H5(@NotNull Application application, @NotNull PreferencesStore preferencesStore, @NotNull D5 configuration) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        a sessionReplayNonStatic = new a();
        C0745m4 randomGenerator = new C0745m4();
        BuildInformation buildInformation = new BuildInformation(application);
        O4 samplingModeTracker = new O4();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sessionReplayNonStatic, "sessionReplayNonStatic");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(samplingModeTracker, "samplingModeTracker");
        this.a = application;
        this.b = sessionReplayNonStatic;
        this.c = preferencesStore;
        this.d = configuration;
        this.e = randomGenerator;
        this.f = buildInformation;
        this.g = samplingModeTracker;
        this.h = new Logger("SessionReplayRulesCoordinator");
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        int i;
        String str;
        H1 h1;
        List listListOf;
        this.h.d("Starting evaluate with canRestartSessionReplay = " + z + " and newSession = " + z2 + "and isLowMemoryTriggered = " + z3);
        L4 l4 = L4.EVALUATE;
        Intrinsics.checkNotNullParameter(l4, "<this>");
        L4 l4A = I5.a(l4, "LowMemoryRule", new C0792r2(z3));
        PreferencesStore preferenceStore = this.c;
        Intrinsics.checkNotNullParameter(l4A, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        L4 l4A2 = I5.a(l4A, "FirstScreenViewRule", new C0753n2(preferenceStore));
        PreferencesStore preferenceStore2 = this.c;
        Intrinsics.checkNotNullParameter(l4A2, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore2, "preferenceStore");
        L4 l4A3 = I5.a(l4A2, "FirstScreenViewAfterPauseRule", new C0743m2(preferenceStore2));
        PreferencesStore preferenceStore3 = this.c;
        Intrinsics.checkNotNullParameter(l4A3, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore3, "preferenceStore");
        L4 l4A4 = I5.a(l4A3, "ForceStartRule", new C0773p2(preferenceStore3));
        D5 configuration = this.d;
        Intrinsics.checkNotNullParameter(l4A4, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        L4 l4A5 = I5.a(l4A4, "WaitingForConfigurationRule", new w8(configuration));
        PreferencesStore preferenceStore4 = this.c;
        Intrinsics.checkNotNullParameter(l4A5, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore4, "preferenceStore");
        L4 l4A6 = I5.a(l4A5, "TrackingEnableRule", new C0812t2(preferenceStore4));
        PreferencesStore preferenceStore5 = this.c;
        Intrinsics.checkNotNullParameter(l4A6, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore5, "preferenceStore");
        L4 l4A7 = I5.a(l4A6, "ForgetMeRule", new C0783q2(preferenceStore5));
        PreferencesStore preferenceStore6 = this.c;
        Intrinsics.checkNotNullParameter(l4A7, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore6, "preferenceStore");
        L4 l4A8 = I5.a(l4A7, "PauseTrackingRule", new C0802s2(preferenceStore6));
        PreferencesStore preferenceStore7 = this.c;
        Intrinsics.checkNotNullParameter(l4A8, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore7, "preferenceStore");
        L4 l4A9 = I5.a(l4A8, "ForceStartRule", new C0763o2(preferenceStore7));
        D5 configuration2 = this.d;
        BuildInformation buildInformation = this.f;
        Intrinsics.checkNotNullParameter(l4A9, "<this>");
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        L4 l4A10 = I5.a(l4A9, "BlockedAppRule", new C0671f0(configuration2, buildInformation));
        D5 configuration3 = this.d;
        Intrinsics.checkNotNullParameter(l4A10, "<this>");
        Intrinsics.checkNotNullParameter(configuration3, "configuration");
        L4 l4A11 = I5.a(l4A10, "FeatureFlagRule", new M1(configuration3));
        Intrinsics.checkNotNullParameter(l4A11, "<this>");
        L4 l4A12 = I5.a(l4A11, "CanRestartRule", new C0733l2(z));
        D5 configuration4 = this.d;
        PreferencesStore preferenceStore8 = this.c;
        C0745m4 randomGenerator = this.e;
        O4 samplingModeTracker = this.g;
        Logger logger = C0765o4.a;
        Intrinsics.checkNotNullParameter(l4A12, "<this>");
        Intrinsics.checkNotNullParameter(configuration4, "configuration");
        Intrinsics.checkNotNullParameter(preferenceStore8, "preferenceStore");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(samplingModeTracker, "samplingModeTracker");
        int iOrdinal = I5.a(l4A12, "RecordingRateRule", new C0755n4(preferenceStore8, configuration4, randomGenerator, samplingModeTracker, z2)).ordinal();
        if (iOrdinal == 0) {
            i = 1;
        } else if (iOrdinal == 1) {
            i = 2;
        } else {
            if (iOrdinal != 2 && iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 3;
        }
        Logger logger2 = this.h;
        int iA = z8.a(i);
        if (iA == 0) {
            str = "start the session replay";
        } else if (iA == 1) {
            str = "stop the session replay";
        } else {
            if (iA != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "do nothing";
        }
        logger2.d("Evaluation done, will ".concat(str));
        if (i != 1) {
            if (i == 2) {
                this.g.a = N4.RANDOM_SAMPLING;
                this.b.getClass();
                C5 c5 = C5.k;
                C5.a.a();
                return;
            }
            return;
        }
        a aVar = this.b;
        Application application = this.a;
        N4 samplingMode = this.g.a;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        C5 c52 = C5.k;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        if (C5.o == null) {
            C5.m.e("SessionReplay.init need to be called before start.");
            return;
        }
        try {
            if (C5.k == null) {
                ContentsquareModule contentsquareModule = ContentsquareModule.getInstance(application);
                Intrinsics.checkNotNullExpressionValue(contentsquareModule, "getInstance(application)");
                CoreModule coreModuleSafeInstance = CoreModule.INSTANCE.safeInstance(application);
                SystemInstantiable systemInstantiable = new SystemInstantiable();
                G5 sessionReplayProperties = contentsquareModule.getSessionReplayProperties();
                Intrinsics.checkNotNullExpressionValue(sessionReplayProperties, "csModule.sessionReplayProperties");
                C0717j6 c0717j6 = new C0717j6(systemInstantiable, sessionReplayProperties);
                H1 h12 = new H1();
                C0764o3 c0764o3 = new C0764o3(h12);
                B2 b2 = new B2(h12);
                U0 u0 = new U0(h12);
                I8 i8 = new I8(h12);
                S1 s1 = new S1(h12);
                B8 b8 = new B8(h12);
                D5 d5 = C5.o;
                Intrinsics.checkNotNull(d5);
                C0772p1 c0772p1 = new C0772p1(h12, systemInstantiable, d5);
                D5 d52 = C5.o;
                Intrinsics.checkNotNull(d52);
                C0821u1 c0821u1 = new C0821u1(h12, systemInstantiable, d52);
                BridgeManager bridgeManager = CsApplicationModule.getInstance(application).getBridgeManager();
                Intrinsics.checkNotNullExpressionValue(bridgeManager, "getInstance(application).bridgeManager");
                C0855x7 c0855x7 = new C0855x7(systemInstantiable, new Handler(Looper.getMainLooper()), 50L);
                C0771p0 captureTouchEvent = contentsquareModule.getCaptureTouchEvent();
                Intrinsics.checkNotNullExpressionValue(captureTouchEvent, "csModule.captureTouchEvent");
                C7 c7 = new C7(application, systemInstantiable, c0855x7, captureTouchEvent, new D7(coreModuleSafeInstance.getDeviceInfo()), h12);
                InterfaceC0789q8 p1 = bridgeManager.isFlutterRegistered() ? new P1(bridgeManager) : new C0729k8(coreModuleSafeInstance.getDeviceInfo());
                if (bridgeManager.isFlutterRegistered()) {
                    listListOf = CollectionsKt.listOf((Object[]) new R6[]{p1, c7});
                    h1 = h12;
                } else {
                    C0771p0 captureTouchEvent2 = contentsquareModule.getCaptureTouchEvent();
                    Intrinsics.checkNotNullExpressionValue(captureTouchEvent2, "csModule.captureTouchEvent");
                    h1 = h12;
                    listListOf = CollectionsKt.listOf((Object[]) new R6[]{p1, c7, new C0623a2(application, captureTouchEvent2, h1)});
                }
                List list = listListOf;
                DeviceInfo deviceInfo = coreModuleSafeInstance.getDeviceInfo();
                ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3 = new ViewTreeObserverOnPreDrawListenerC0833v3();
                Z2 z22 = C5.l;
                M2 liveActivityProvider = contentsquareModule.getLiveActivityProvider();
                Intrinsics.checkNotNullExpressionValue(liveActivityProvider, "csModule.liveActivityProvider");
                String absolutePath = application.getApplicationContext().getFilesDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "application.applicationC…ext.filesDir.absolutePath");
                V v = new V(absolutePath);
                D5 d53 = C5.o;
                Intrinsics.checkNotNull(d53);
                SessionReplayProcessor sessionReplayProcessorA = C5.a.a(samplingMode, h1, deviceInfo, application, viewTreeObserverOnPreDrawListenerC0833v3, z22, liveActivityProvider, v, c0717j6, d53, list, bridgeManager, p1);
                G5 sessionReplayProperties2 = contentsquareModule.getSessionReplayProperties();
                Intrinsics.checkNotNullExpressionValue(sessionReplayProperties2, "csModule.sessionReplayProperties");
                C5.k = new C5(c0764o3, b2, u0, i8, b8, s1, c0772p1, c0821u1, new C0717j6(systemInstantiable, sessionReplayProperties2), sessionReplayProcessorA);
                sessionReplayProcessorA.startProcess(z2);
                Logger logger3 = C5.m;
                logger3.i("Session Replay is starting");
                C5 c53 = C5.k;
                Intrinsics.checkNotNull(c53);
                String strA = c53.i.a();
                Consumer<String> consumer = C5.n;
                if (consumer != null) {
                    consumer.accept(strA);
                }
                logger3.i("SessionReplay link updated: " + strA);
            }
            C5.m.d("Session Replay already started.");
        } catch (Exception e) {
            Q2.a(C5.m, "Something went wrong, Session Replay couldn't be started.", e);
        }
    }
}
