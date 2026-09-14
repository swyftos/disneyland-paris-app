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
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2512H5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Application f1682a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final a f1683b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final PreferencesStore f1684c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2472D5 f1685d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2815m4 f1686e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final BuildInformation f1687f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2581O4 f1688g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Logger f1689h;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.H5$a */
    public static final class a {
    }

    public C2512H5(@NotNull Application application, @NotNull PreferencesStore preferencesStore, @NotNull C2472D5 configuration) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        a sessionReplayNonStatic = new a();
        C2815m4 randomGenerator = new C2815m4();
        BuildInformation buildInformation = new BuildInformation(application);
        C2581O4 samplingModeTracker = new C2581O4();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sessionReplayNonStatic, "sessionReplayNonStatic");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(samplingModeTracker, "samplingModeTracker");
        this.f1682a = application;
        this.f1683b = sessionReplayNonStatic;
        this.f1684c = preferencesStore;
        this.f1685d = configuration;
        this.f1686e = randomGenerator;
        this.f1687f = buildInformation;
        this.f1688g = samplingModeTracker;
        this.f1689h = new Logger("SessionReplayRulesCoordinator");
    }

    /* JADX INFO: renamed from: a */
    public final void m932a(boolean z, boolean z2, boolean z3) {
        int i;
        String str;
        C2508H1 c2508h1;
        List listListOf;
        this.f1689h.m827d("Starting evaluate with canRestartSessionReplay = " + z + " and newSession = " + z2 + "and isLowMemoryTriggered = " + z3);
        EnumC2551L4 enumC2551L4 = EnumC2551L4.EVALUATE;
        Intrinsics.checkNotNullParameter(enumC2551L4, "<this>");
        EnumC2551L4 enumC2551L4M943a = C2522I5.m943a(enumC2551L4, "LowMemoryRule", new C2863r2(z3));
        PreferencesStore preferenceStore = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a2 = C2522I5.m943a(enumC2551L4M943a, "FirstScreenViewRule", new C2823n2(preferenceStore));
        PreferencesStore preferenceStore2 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a2, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore2, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a3 = C2522I5.m943a(enumC2551L4M943a2, "FirstScreenViewAfterPauseRule", new C2813m2(preferenceStore2));
        PreferencesStore preferenceStore3 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a3, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore3, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a4 = C2522I5.m943a(enumC2551L4M943a3, "ForceStartRule", new C2843p2(preferenceStore3));
        C2472D5 configuration = this.f1685d;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a4, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        EnumC2551L4 enumC2551L4M943a5 = C2522I5.m943a(enumC2551L4M943a4, "WaitingForConfigurationRule", new C2919w8(configuration));
        PreferencesStore preferenceStore4 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a5, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore4, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a6 = C2522I5.m943a(enumC2551L4M943a5, "TrackingEnableRule", new C2883t2(preferenceStore4));
        PreferencesStore preferenceStore5 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a6, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore5, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a7 = C2522I5.m943a(enumC2551L4M943a6, "ForgetMeRule", new C2853q2(preferenceStore5));
        PreferencesStore preferenceStore6 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a7, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore6, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a8 = C2522I5.m943a(enumC2551L4M943a7, "PauseTrackingRule", new C2873s2(preferenceStore6));
        PreferencesStore preferenceStore7 = this.f1684c;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a8, "<this>");
        Intrinsics.checkNotNullParameter(preferenceStore7, "preferenceStore");
        EnumC2551L4 enumC2551L4M943a9 = C2522I5.m943a(enumC2551L4M943a8, "ForceStartRule", new C2833o2(preferenceStore7));
        C2472D5 configuration2 = this.f1685d;
        BuildInformation buildInformation = this.f1687f;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a9, "<this>");
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        EnumC2551L4 enumC2551L4M943a10 = C2522I5.m943a(enumC2551L4M943a9, "BlockedAppRule", new C2741f0(configuration2, buildInformation));
        C2472D5 configuration3 = this.f1685d;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a10, "<this>");
        Intrinsics.checkNotNullParameter(configuration3, "configuration");
        EnumC2551L4 enumC2551L4M943a11 = C2522I5.m943a(enumC2551L4M943a10, "FeatureFlagRule", new C2558M1(configuration3));
        Intrinsics.checkNotNullParameter(enumC2551L4M943a11, "<this>");
        EnumC2551L4 enumC2551L4M943a12 = C2522I5.m943a(enumC2551L4M943a11, "CanRestartRule", new C2803l2(z));
        C2472D5 configuration4 = this.f1685d;
        PreferencesStore preferenceStore8 = this.f1684c;
        C2815m4 randomGenerator = this.f1686e;
        C2581O4 samplingModeTracker = this.f1688g;
        Logger logger = C2835o4.f2938a;
        Intrinsics.checkNotNullParameter(enumC2551L4M943a12, "<this>");
        Intrinsics.checkNotNullParameter(configuration4, "configuration");
        Intrinsics.checkNotNullParameter(preferenceStore8, "preferenceStore");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(samplingModeTracker, "samplingModeTracker");
        int iOrdinal = C2522I5.m943a(enumC2551L4M943a12, "RecordingRateRule", new C2825n4(preferenceStore8, configuration4, randomGenerator, samplingModeTracker, z2)).ordinal();
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
        Logger logger2 = this.f1689h;
        int iM1254a = C2949z8.m1254a(i);
        if (iM1254a == 0) {
            str = "start the session replay";
        } else if (iM1254a == 1) {
            str = "stop the session replay";
        } else {
            if (iM1254a != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "do nothing";
        }
        logger2.m827d("Evaluation done, will ".concat(str));
        if (i != 1) {
            if (i == 2) {
                this.f1688g.f1944a = EnumC2571N4.RANDOM_SAMPLING;
                this.f1683b.getClass();
                C2462C5 c2462c5 = C2462C5.f1468k;
                C2462C5.a.m886a();
                return;
            }
            return;
        }
        a aVar = this.f1683b;
        Application application = this.f1682a;
        EnumC2571N4 samplingMode = this.f1688g.f1944a;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        C2462C5 c2462c6 = C2462C5.f1468k;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        if (C2462C5.f1472o == null) {
            C2462C5.f1470m.m829e("SessionReplay.init need to be called before start.");
            return;
        }
        try {
            if (C2462C5.f1468k == null) {
                ContentsquareModule contentsquareModule = ContentsquareModule.getInstance(application);
                Intrinsics.checkNotNullExpressionValue(contentsquareModule, "getInstance(application)");
                CoreModule coreModuleSafeInstance = CoreModule.INSTANCE.safeInstance(application);
                SystemInstantiable systemInstantiable = new SystemInstantiable();
                C2502G5 sessionReplayProperties = contentsquareModule.getSessionReplayProperties();
                Intrinsics.checkNotNullExpressionValue(sessionReplayProperties, "csModule.sessionReplayProperties");
                C2787j6 c2787j6 = new C2787j6(systemInstantiable, sessionReplayProperties);
                C2508H1 c2508h2 = new C2508H1();
                C2834o3 c2834o3 = new C2834o3(c2508h2);
                C2449B2 c2449b2 = new C2449B2(c2508h2);
                C2636U0 c2636u0 = new C2636U0(c2508h2);
                C2525I8 c2525i8 = new C2525I8(c2508h2);
                C2617S1 c2617s1 = new C2617S1(c2508h2);
                C2455B8 c2455b8 = new C2455B8(c2508h2);
                C2472D5 c2472d5 = C2462C5.f1472o;
                Intrinsics.checkNotNull(c2472d5);
                C2842p1 c2842p1 = new C2842p1(c2508h2, systemInstantiable, c2472d5);
                C2472D5 c2472d6 = C2462C5.f1472o;
                Intrinsics.checkNotNull(c2472d6);
                C2892u1 c2892u1 = new C2892u1(c2508h2, systemInstantiable, c2472d6);
                BridgeManager bridgeManager = CsApplicationModule.getInstance(application).getBridgeManager();
                Intrinsics.checkNotNullExpressionValue(bridgeManager, "getInstance(application).bridgeManager");
                C2928x7 c2928x7 = new C2928x7(systemInstantiable, new Handler(Looper.getMainLooper()), 50L);
                C2841p0 captureTouchEvent = contentsquareModule.getCaptureTouchEvent();
                Intrinsics.checkNotNullExpressionValue(captureTouchEvent, "csModule.captureTouchEvent");
                RunnableC2464C7 runnableC2464C7 = new RunnableC2464C7(application, systemInstantiable, c2928x7, captureTouchEvent, new C2474D7(coreModuleSafeInstance.getDeviceInfo()), c2508h2);
                InterfaceC2859q8 c2588p1 = bridgeManager.isFlutterRegistered() ? new C2588P1(bridgeManager) : new C2799k8(coreModuleSafeInstance.getDeviceInfo());
                if (bridgeManager.isFlutterRegistered()) {
                    listListOf = CollectionsKt.listOf((Object[]) new InterfaceC2612R6[]{c2588p1, runnableC2464C7});
                    c2508h1 = c2508h2;
                } else {
                    C2841p0 captureTouchEvent2 = contentsquareModule.getCaptureTouchEvent();
                    Intrinsics.checkNotNullExpressionValue(captureTouchEvent2, "csModule.captureTouchEvent");
                    c2508h1 = c2508h2;
                    listListOf = CollectionsKt.listOf((Object[]) new InterfaceC2612R6[]{c2588p1, runnableC2464C7, new C2693a2(application, captureTouchEvent2, c2508h1)});
                }
                List list = listListOf;
                DeviceInfo deviceInfo = coreModuleSafeInstance.getDeviceInfo();
                ViewTreeObserverOnPreDrawListenerC2904v3 viewTreeObserverOnPreDrawListenerC2904v3 = new ViewTreeObserverOnPreDrawListenerC2904v3();
                C2684Z2 c2684z2 = C2462C5.f1469l;
                C2559M2 liveActivityProvider = contentsquareModule.getLiveActivityProvider();
                Intrinsics.checkNotNullExpressionValue(liveActivityProvider, "csModule.liveActivityProvider");
                String absolutePath = application.getApplicationContext().getFilesDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "application.applicationC…ext.filesDir.absolutePath");
                C2645V c2645v = new C2645V(absolutePath);
                C2472D5 c2472d7 = C2462C5.f1472o;
                Intrinsics.checkNotNull(c2472d7);
                SessionReplayProcessor sessionReplayProcessorM885a = C2462C5.a.m885a(samplingMode, c2508h1, deviceInfo, application, viewTreeObserverOnPreDrawListenerC2904v3, c2684z2, liveActivityProvider, c2645v, c2787j6, c2472d7, list, bridgeManager, c2588p1);
                C2502G5 sessionReplayProperties2 = contentsquareModule.getSessionReplayProperties();
                Intrinsics.checkNotNullExpressionValue(sessionReplayProperties2, "csModule.sessionReplayProperties");
                C2462C5.f1468k = new C2462C5(c2834o3, c2449b2, c2636u0, c2525i8, c2455b8, c2617s1, c2842p1, c2892u1, new C2787j6(systemInstantiable, sessionReplayProperties2), sessionReplayProcessorM885a);
                sessionReplayProcessorM885a.startProcess(z2);
                Logger logger3 = C2462C5.f1470m;
                logger3.m831i("Session Replay is starting");
                C2462C5 c2462c7 = C2462C5.f1468k;
                Intrinsics.checkNotNull(c2462c7);
                String strM1164a = c2462c7.f1481i.m1164a();
                Consumer<String> consumer = C2462C5.f1471n;
                if (consumer != null) {
                    consumer.accept(strM1164a);
                }
                logger3.m831i("SessionReplay link updated: " + strM1164a);
            }
            C2462C5.f1470m.m827d("Session Replay already started.");
        } catch (Exception e) {
            C2599Q2.m1011a(C2462C5.f1470m, "Something went wrong, Session Replay couldn't be started.", e);
        }
    }
}
