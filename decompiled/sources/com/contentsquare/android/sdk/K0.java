package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.WindowManager;
import androidx.core.util.Predicate;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.contentsquare.android.analytics.internal.features.clientmode.manager.ClientModeManagerImpl;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.ThreadExecutor;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.Z4;
import java.util.HashSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class K0 {

    @NotNull
    public static final Logger e = new Logger("CsClientModeModule");

    @Nullable
    public static K0 f;

    @NotNull
    public final com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a a;

    @NotNull
    public final C0724k3 b;

    @NotNull
    public final ClientModeManagerImpl c;

    @NotNull
    public final H3 d;

    public static final class a {
        @JvmStatic
        @NotNull
        public static K0 a(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (K0.f == null) {
                K0.f = new K0(application);
                K0.e.d("CsClientModeModule singleton is now initialized.");
            }
            K0 k0 = K0.f;
            Intrinsics.checkNotNull(k0);
            return k0;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<ComposeInterface> {
        public b(C0627a6 c0627a6) {
            super(0, c0627a6, C0627a6.class, "get", "get()Lcom/contentsquare/android/core/communication/compose/ComposeInterface;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ComposeInterface invoke() {
            ((C0627a6) this.receiver).getClass();
            return (ComposeInterface) C0644c3.c.getValue();
        }
    }

    public K0(Application application) {
        ContentsquareModule contentsquareModule = ContentsquareModule.getInstance(application);
        Intrinsics.checkNotNullExpressionValue(contentsquareModule, "getInstance(application)");
        CoreModule coreModuleSafeInstance = CoreModule.INSTANCE.safeInstance(application);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Z4.c.a);
        Object systemService = application.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        M2 liveActivityProvider = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider, "csModule.liveActivityProvider");
        com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar = new com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a(MutableStateFlow, application, (WindowManager) systemService, liveActivityProvider);
        this.a = aVar;
        C0724k3 c0724k3 = new C0724k3(application, aVar, coreModuleSafeInstance.getPreferencesStore(), new C0682g1());
        this.b = c0724k3;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance(application);
        Intrinsics.checkNotNullExpressionValue(csApplicationModule, "getInstance(application)");
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.INSTANCE.get();
        M2 liveActivityProvider2 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider2, "csModule.liveActivityProvider");
        this.c = new ClientModeManagerImpl(c0724k3, application, lifecycleOwner, liveActivityProvider2);
        I3 i3 = new I3(new J3());
        K webViewAssetCache = csApplicationModule.getWebViewAssetCache();
        Intrinsics.checkNotNullExpressionValue(webViewAssetCache, "csAppModule.webViewAssetCache");
        K1 k1 = new K1(i3, new D8(webViewAssetCache));
        DeviceInfo deviceInfo = coreModuleSafeInstance.getDeviceInfo();
        ThreadExecutor threadExecutor = csApplicationModule.getThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(threadExecutor, "csAppModule.threadExecutor");
        Z0 z0 = new Z0(deviceInfo, new S4(threadExecutor, MutableStateFlow, coreModuleSafeInstance.getPreferencesStore(), new R4(coreModuleSafeInstance.getDeviceInfo())), coreModuleSafeInstance.getPreferencesStore(), coreModuleSafeInstance.getConfiguration());
        C0627a6 c0627a6 = new C0627a6();
        T2 t2 = new T2();
        HashSet<Class<? extends Activity>> hashSet = Q1.a;
        H7 h7 = new H7(c0627a6);
        H7 h72 = new H7(t2);
        C0830v0 c0830v0 = new C0830v0(c0627a6);
        C0830v0 c0830v02 = new C0830v0(t2);
        M2 liveActivityProvider3 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider3, "csModule.liveActivityProvider");
        X4 x4 = new X4(k1, MutableStateFlow, h7, new C0669e8(liveActivityProvider3));
        InterfaceC0832v2 gesturesInterceptor = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor, "csAppModule.gesturesInterceptor");
        E4 e4 = new E4(x4, MutableStateFlow, z0, gesturesInterceptor, c0830v0);
        C0667e6 c0667e6 = new C0667e6();
        Y2 y2 = new Y2();
        X2 x2 = new X2(y2);
        C0726k5 c0726k5 = new C0726k5();
        Z7 z7 = new Z7();
        M2 liveActivityProvider4 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider4, "csModule.liveActivityProvider");
        C0669e8 c0669e8 = new C0669e8(liveActivityProvider4);
        InterfaceC0832v2 gesturesInterceptor2 = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor2, "csAppModule.gesturesInterceptor");
        C0766o5 c0766o5 = new C0766o5(new C0659d8(MutableStateFlow, x2, k1, h72, c0669e8, z0, gesturesInterceptor2, c0726k5, z7, c0830v02), new C0828u8(), y2);
        M2 liveActivityProvider5 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider5, "csModule.liveActivityProvider");
        C0669e8 c0669e82 = new C0669e8(liveActivityProvider5);
        InterfaceC0832v2 gesturesInterceptor3 = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor3, "csAppModule.gesturesInterceptor");
        C0834v4 c0834v4 = new C0834v4(new C0629a8(MutableStateFlow, k1, h72, c0669e82, z0, gesturesInterceptor3, c0830v02, new C0635b4(), new C0634b3()), new C4(), c0667e6, coreModuleSafeInstance.getPreferencesStore());
        M2 liveActivityProvider6 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider6, "csModule.liveActivityProvider");
        C0669e8 c0669e83 = new C0669e8(liveActivityProvider6);
        InterfaceC0832v2 gesturesInterceptor4 = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor4, "csAppModule.gesturesInterceptor");
        W7 w7 = new W7(MutableStateFlow, k1, h72, c0669e83, z0, gesturesInterceptor4, c0830v02, c0726k5, z7);
        M2 liveActivityProvider7 = contentsquareModule.getLiveActivityProvider();
        Intrinsics.checkNotNullExpressionValue(liveActivityProvider7, "csModule.liveActivityProvider");
        C0669e8 c0669e84 = new C0669e8(liveActivityProvider7);
        InterfaceC0832v2 gesturesInterceptor5 = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor5, "csAppModule.gesturesInterceptor");
        Q7 q7 = new Q7(MutableStateFlow, k1, h72, c0669e84, z0, gesturesInterceptor5, new C0635b4(), new C0634b3(), t2);
        Y7 y7 = new Y7(w7, c0667e6);
        T7 t7 = new T7(q7, c0667e6, coreModuleSafeInstance.getPreferencesStore());
        b bVar = new b(c0627a6);
        C0683g2 gestureStorage = csApplicationModule.getGestureStorage();
        Intrinsics.checkNotNullExpressionValue(gestureStorage, "csAppModule.gestureStorage");
        C0647c6 c0647c6 = new C0647c6(bVar, gestureStorage, new F7(new Predicate() { // from class: com.contentsquare.android.sdk.K0$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return K0.a((View) obj);
            }
        }));
        G4 g4 = new G4(e4);
        InterfaceC0832v2 gesturesInterceptor6 = csApplicationModule.getGesturesInterceptor();
        Intrinsics.checkNotNullExpressionValue(gesturesInterceptor6, "csAppModule.gesturesInterceptor");
        this.d = new H3(g4, c0766o5, c0834v4, y7, t7, gesturesInterceptor6, c0647c6, c0724k3, MutableStateFlow, c0667e6);
    }

    public static final boolean a(View view) {
        return false;
    }
}
