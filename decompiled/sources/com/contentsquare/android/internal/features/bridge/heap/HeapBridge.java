package com.contentsquare.android.internal.features.bridge.heap;

import android.app.Activity;
import android.webkit.WebView;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.HeapInterface;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.C0636b5;
import com.contentsquare.android.sdk.C0676f5;
import com.contentsquare.android.sdk.C0710j;
import com.contentsquare.android.sdk.C0822u2;
import com.contentsquare.android.sdk.C0866z0;
import com.contentsquare.android.sdk.E1;
import com.contentsquare.android.sdk.J0;
import com.contentsquare.android.sdk.M0;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.S8;
import com.contentsquare.android.sdk.W1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u0016J2\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J(\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J \u0010)\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u0016\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lcom/contentsquare/android/internal/features/bridge/heap/HeapBridge;", "", "()V", "heapInterface", "Lcom/contentsquare/android/internal/features/bridge/heap/HeapExternalInterface;", "isHeapRegistered", "", "()Z", "isInForeground", "lastSavedHeapMetadata", "Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;", "getLastSavedHeapMetadata", "()Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;", "setLastSavedHeapMetadata", "(Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "sessionTimeout", "", "getSessionTimeout", "()I", "extendOrCreateSession", "extendOrCreateSession$library_release", "onScreenViewEvent", "", "title", "", "timestamp", "", "customVariables", "", "isHeapPageView", "optIn", "applicationModule", "Lcom/contentsquare/android/internal/features/initialize/CsApplicationModule;", "contentsquareModule", "Lcom/contentsquare/android/internal/features/initialize/ContentsquareModule;", "csRuntime", "Lcom/contentsquare/android/internal/features/initialize/CsRuntimeModule;", "coreModule", "Lcom/contentsquare/android/core/CoreModule;", "optOut", "registerHeap", "heapExternalInterface", "send", "screenName", "sendHeapSessionStart", "heapMetadata", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeapBridge {

    @Nullable
    private static HeapExternalInterface heapInterface;

    @Nullable
    private static HeapInterface.HeapMetadata lastSavedHeapMetadata;

    @NotNull
    public static final HeapBridge INSTANCE = new HeapBridge();

    @NotNull
    private static final Logger logger = new Logger("HeapBridge");

    private HeapBridge() {
    }

    private final void optIn(CsApplicationModule applicationModule, ContentsquareModule contentsquareModule, CsRuntimeModule csRuntime, CoreModule coreModule) {
        Activity activity;
        M4 runTime = csRuntime.getRunTime();
        Intrinsics.checkNotNullExpressionValue(runTime, "csRuntime.runTime");
        coreModule.getPreferencesStore().putBoolean(PreferencesKey.IS_OPT_OUT, false);
        coreModule.getPreferencesStore().putBoolean(PreferencesKey.FORGET_ME, false);
        applicationModule.getUserIdRestoreHelper().a();
        if (CsRuntimeModule.getInstance() != null && (activity = contentsquareModule.getLiveActivityProvider().a.get()) != null) {
            J0 csActivityCallbacks = csRuntime.getCsActivityCallbacks();
            csActivityCallbacks.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            J0.a(activity, csActivityCallbacks.r, csActivityCallbacks.d);
        }
        applicationModule.getSdkManager().a();
        S8.a.getClass();
        Iterator<Map.Entry<WebView, M0>> it = S8.g.entrySet().iterator();
        while (it.hasNext()) {
            M0 value = it.next().getValue();
            if (value.a()) {
                value.g.a();
            }
        }
        String strA = runTime.a();
        if (strA != null) {
            logger.i("Opt-in successful. User ID: ".concat(strA));
        } else {
            logger.i("Opt-in failed.");
        }
    }

    private final void optOut(CsApplicationModule applicationModule, CoreModule coreModule, CsRuntimeModule csRuntime) {
        M4 runTime = csRuntime.getRunTime();
        Intrinsics.checkNotNullExpressionValue(runTime, "csRuntime.runTime");
        C0676f5.b.clear();
        coreModule.getPreferencesStore().putBoolean(PreferencesKey.IS_OPT_OUT, true);
        W1 w1 = runTime.b;
        w1.getClass();
        Logger logger2 = W1.f;
        logger2.d("GdprController, flushForHeap");
        w1.e.removeGdprKeys();
        w1.c.a.remove(PreferencesKey.SCHEDULED_APP_HIDE_EVENT, PreferencesKey.LAST_EVENT_TIMESTAMP, PreferencesKey.IS_HIDE_EVENT_PENDING);
        logger2.i("Wiped preferences.");
        w1.e.putLong(PreferencesKey.SCREEN_TIMESTAMP, 0L);
        w1.d.e.a();
        logger.i("Opting out");
        applicationModule.getSdkManager().a();
        S8.a.getClass();
        Iterator<Map.Entry<WebView, M0>> it = S8.g.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$0(String screenName, long j, M4 m4) {
        Intrinsics.checkNotNullParameter(screenName, "$screenName");
        C0676f5.a(new C0636b5(screenName, null, true, Long.valueOf(j), 2));
    }

    @Nullable
    public final HeapInterface.HeapMetadata extendOrCreateSession$library_release() {
        HeapExternalInterface heapExternalInterface = heapInterface;
        if (heapExternalInterface != null) {
            return heapExternalInterface.extendOrCreateSession();
        }
        return null;
    }

    @Nullable
    public final HeapInterface.HeapMetadata getLastSavedHeapMetadata() {
        return lastSavedHeapMetadata;
    }

    public final int getSessionTimeout() {
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || (configuration = companion.getConfiguration()) == null || (projectConfig = configuration.getProjectConfig()) == null) {
            return 0;
        }
        return projectConfig.getSessionTimeout();
    }

    public final boolean isHeapRegistered() {
        return heapInterface != null;
    }

    public final boolean isInForeground() {
        return ProcessLifecycleOwner.INSTANCE.get().getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED);
    }

    public final void onScreenViewEvent(@NotNull String title, long timestamp, @NotNull Map<String, String> customVariables, boolean isHeapPageView) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        HeapExternalInterface heapExternalInterface = heapInterface;
        if (heapExternalInterface != null) {
            heapExternalInterface.onContentsquareScreenView(title, timestamp, customVariables, isHeapPageView);
        }
    }

    public final void registerHeap(@Nullable HeapExternalInterface heapExternalInterface) {
        heapInterface = heapExternalInterface;
    }

    public final void send(@NotNull final String screenName, final long timestamp) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        C0866z0.a.a(false, new Consumer() { // from class: com.contentsquare.android.internal.features.bridge.heap.HeapBridge$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                HeapBridge.send$lambda$0(screenName, timestamp, (M4) obj);
            }
        });
    }

    public final void sendHeapSessionStart(@NotNull HeapInterface.HeapMetadata heapMetadata) {
        ContentsquareModule contentsquareModule;
        CsRuntimeModule csRuntimeModule;
        CoreModule companion;
        Intrinsics.checkNotNullParameter(heapMetadata, "heapMetadata");
        HeapInterface.HeapMetadata heapMetadata2 = lastSavedHeapMetadata;
        boolean z = false;
        boolean z2 = heapMetadata2 != null && heapMetadata2.getUserId() == heapMetadata.getUserId();
        HeapInterface.HeapMetadata heapMetadata3 = lastSavedHeapMetadata;
        boolean z3 = heapMetadata3 != null && heapMetadata3.getSessionId() == heapMetadata.getSessionId();
        lastSavedHeapMetadata = heapMetadata;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null || (contentsquareModule = ContentsquareModule.getInstance()) == null || (csRuntimeModule = CsRuntimeModule.getInstance()) == null || (companion = CoreModule.INSTANCE.getInstance()) == null || csRuntimeModule.getRunTime().a() == null) {
            return;
        }
        if (!z2) {
            optOut(csApplicationModule, companion, csRuntimeModule);
            optIn(csApplicationModule, contentsquareModule, csRuntimeModule, companion);
        }
        E1 eventsBuildersFactory = csApplicationModule.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "applicationModule.eventsBuildersFactory");
        C0710j analyticsPipeline = csApplicationModule.getAnalyticsPipeline();
        Intrinsics.checkNotNullExpressionValue(analyticsPipeline, "applicationModule.analyticsPipeline");
        C0822u2.a aVar = (C0822u2.a) E1.a(eventsBuildersFactory, -2);
        if (!z3 && z2) {
            z = true;
        }
        aVar.k = z;
        analyticsPipeline.a(aVar);
    }

    public final void setLastSavedHeapMetadata(@Nullable HeapInterface.HeapMetadata heapMetadata) {
        lastSavedHeapMetadata = heapMetadata;
    }
}
