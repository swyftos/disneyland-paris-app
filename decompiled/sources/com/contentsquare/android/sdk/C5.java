package com.contentsquare.android.sdk;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.core.util.Consumer;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@MainThread
/* loaded from: classes2.dex */
public final class C5 {

    @Nullable
    public static C5 k;

    @NotNull
    public static final Z2 l;

    @NotNull
    public static final Logger m;

    @Nullable
    public static Consumer<String> n;

    @Nullable
    public static D5 o;

    @NotNull
    public final C0764o3 a;

    @NotNull
    public final B2 b;

    @NotNull
    public final U0 c;

    @NotNull
    public final I8 d;

    @NotNull
    public final B8 e;

    @NotNull
    public final S1 f;

    @NotNull
    public final C0772p1 g;

    @NotNull
    public final C0821u1 h;

    @NotNull
    public final C0717j6 i;

    @NotNull
    public final SessionReplayProcessor j;

    public static final class a {
        public static void a(@NotNull Application application, @NotNull CoreModule module) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(module, "module");
            D5 d5 = new D5(module.getPreferencesStore(), module.getConfiguration(), new BuildInformation(application));
            C5 c5 = C5.k;
            new J5(application, module.getPreferencesStore(), new H5(application, module.getPreferencesStore(), d5));
            C5.o = d5;
        }

        public static SessionReplayProcessor a(N4 n4, H1 h1, DeviceInfo deviceInfo, Application application, ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3, Z2 z2, M2 m2, V v, C0717j6 c0717j6, D5 d5, List list, BridgeManager bridgeManager, InterfaceC0789q8 interfaceC0789q8) {
            CoreModule coreModuleSafeInstance = CoreModule.INSTANCE.safeInstance(application);
            C0695h4 c0695h4 = new C0695h4(deviceInfo, h1);
            I i = new I(h1);
            return new SessionReplayProcessor(application, d5, n4, z2, deviceInfo, viewTreeObserverOnPreDrawListenerC0833v3, m2, ProcessLifecycleOwner.INSTANCE.get(), new C0715j4(coreModuleSafeInstance.getPreferencesStore(), coreModuleSafeInstance.getConfiguration(), deviceInfo, c0695h4), new U(v), h1, list, interfaceC0789q8, new I6(h1, coreModuleSafeInstance.getPreferencesStore()), i, new P5(coreModuleSafeInstance.getPreferencesStore()), null, null, null, c0717j6, null, null, null, null, null, null, bridgeManager, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -67698688, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
        }

        @JvmStatic
        @MainThread
        public static void a() {
            try {
                C5 c5 = C5.k;
                if (c5 != null) {
                    c5.j.stopProcess();
                    C5.k = null;
                    C5.m.i("Session Replay stopped");
                }
            } catch (Exception e) {
                Q2.a(C5.m, "Something went wrong. Session Replay couldn't be stopped.", e);
            }
        }
    }

    static {
        PreferencesStore preferencesStore;
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || (preferencesStore = companion.getPreferencesStore()) == null) {
            throw new IllegalStateException("PreferencesStore should not be null!");
        }
        l = new Z2(preferencesStore);
        m = new Logger("SessionReplay");
    }

    public C5(@NotNull C0764o3 networkEventPublisher, @NotNull B2 jsErrorEventPublisher, @NotNull U0 customErrorEventPublisher, @NotNull I8 webViewEventPublisher, @NotNull B8 webViewAssetHashesPublisher, @NotNull S1 flutterSrEventPublisher, @NotNull C0772p1 etrScreenEventPublisher, @NotNull C0821u1 etrSessionEventPublisher, @NotNull C0717j6 srQuickLink, @NotNull SessionReplayProcessor sessionReplayProcessor) {
        Intrinsics.checkNotNullParameter(networkEventPublisher, "networkEventPublisher");
        Intrinsics.checkNotNullParameter(jsErrorEventPublisher, "jsErrorEventPublisher");
        Intrinsics.checkNotNullParameter(customErrorEventPublisher, "customErrorEventPublisher");
        Intrinsics.checkNotNullParameter(webViewEventPublisher, "webViewEventPublisher");
        Intrinsics.checkNotNullParameter(webViewAssetHashesPublisher, "webViewAssetHashesPublisher");
        Intrinsics.checkNotNullParameter(flutterSrEventPublisher, "flutterSrEventPublisher");
        Intrinsics.checkNotNullParameter(etrScreenEventPublisher, "etrScreenEventPublisher");
        Intrinsics.checkNotNullParameter(etrSessionEventPublisher, "etrSessionEventPublisher");
        Intrinsics.checkNotNullParameter(srQuickLink, "srQuickLink");
        Intrinsics.checkNotNullParameter(sessionReplayProcessor, "sessionReplayProcessor");
        this.a = networkEventPublisher;
        this.b = jsErrorEventPublisher;
        this.c = customErrorEventPublisher;
        this.d = webViewEventPublisher;
        this.e = webViewAssetHashesPublisher;
        this.f = flutterSrEventPublisher;
        this.g = etrScreenEventPublisher;
        this.h = etrSessionEventPublisher;
        this.i = srQuickLink;
        this.j = sessionReplayProcessor;
    }
}
