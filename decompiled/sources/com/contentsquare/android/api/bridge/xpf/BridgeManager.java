package com.contentsquare.android.api.bridge.xpf;

import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.sdk.C0644c3;
import com.contentsquare.android.sdk.C0848x0;
import com.contentsquare.android.sdk.M0;
import com.contentsquare.android.sdk.S8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nJ\b\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J!\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\u0006\u0010+\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\b\u0010,\u001a\u00020\u0016H\u0002J\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0016J\u0006\u00100\u001a\u00020\u0016J)\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\b\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\u0016H\u0002J\u0006\u00106\u001a\u00020\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0010H\u0002J\u0006\u00109\u001a\u00020\u0016J\b\u0010:\u001a\u00020\u0016H\u0002J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010AJ\u000e\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006C"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/BridgeManager;", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "configuration", "Lcom/contentsquare/android/core/features/config/Configuration;", "preferencesStore", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "(Lcom/contentsquare/android/core/features/config/Configuration;Lcom/contentsquare/android/core/features/preferences/PreferencesStore;)V", "bridgeConfig", "Lcom/contentsquare/android/api/bridge/xpf/BridgeConfig;", "isCsInAppEnabled", "", "Ljava/lang/Boolean;", "isSessionReplayEnabled", "isSessionReplayMaskingEnabled", "registeredExternalBridges", "", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeInterface;", "getRegisteredExternalBridges$annotations", "()V", "getRegisteredExternalBridges", "()Ljava/util/List;", "configureBridge", "", "externalBridge", "enableSessionReplay", "enable", "getBridgeConfig", "getCsInAppState", "fromPreferenceStore", "getCurrentApiErrorEnabledState", "getCurrentCrashReportingEnabledState", "getCurrentSDKState", "Lcom/contentsquare/android/api/bridge/xpf/SDKState;", "isOptIn", "isTracking", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/contentsquare/android/api/bridge/xpf/SDKState;", "getCurrentSessionReplayMaskingState", "getUpdatedBridgeConfig", "getWebViewHandleDataAssetFeatureFlag", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag;", "projectConfig", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "handleConfigurationForWebViews", "isFlutterRegistered", "notifyExternalBridgesOnInAppFeatureEnable", "notifyForgetMe", "notifyOptIn", "notifyOptOut", "notifyResumeTracking", "notifySdkStateChanges", "type", "Lcom/contentsquare/android/api/bridge/xpf/SDKStateChangeType;", "(Lcom/contentsquare/android/api/bridge/xpf/SDKStateChangeType;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "notifySessionReplayMaskingConfigurationChanged", "notifyStart", "notifyStartSdkOnBridge", "bridge", "notifyStopTracking", "onConfigurationChanged", "onPreferenceChanged", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "registerExternalBridge", "setSessionReplayCapture", "capture", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeSessionReplayCapture;", "unregisterExternalBridge", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBridgeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BridgeManager.kt\ncom/contentsquare/android/api/bridge/xpf/BridgeManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 5 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n*L\n1#1,330:1\n1747#2,3:331\n1855#2,2:337\n288#2,2:339\n800#2,11:342\n800#2,11:354\n1855#2,2:365\n1855#2,2:367\n1855#2,2:369\n1#3:334\n113#4:335\n113#4:336\n63#5:341\n63#5:353\n*S KotlinDebug\n*F\n+ 1 BridgeManager.kt\ncom/contentsquare/android/api/bridge/xpf/BridgeManager\n*L\n58#1:331,3\n129#1:337,2\n135#1:339,2\n155#1:342,11\n165#1:354,11\n198#1:365,2\n211#1:367,2\n260#1:369,2\n93#1:335\n128#1:336\n155#1:341\n165#1:353\n*E\n"})
/* loaded from: classes2.dex */
public final class BridgeManager implements PreferencesStore.PreferencesStoreListener {

    @Nullable
    private BridgeConfig bridgeConfig;

    @NotNull
    private final Configuration configuration;

    @Nullable
    private Boolean isCsInAppEnabled;

    @Nullable
    private Boolean isSessionReplayEnabled;

    @Nullable
    private Boolean isSessionReplayMaskingEnabled;

    @NotNull
    private final PreferencesStore preferencesStore;

    @NotNull
    private final List<ExternalBridgeInterface> registeredExternalBridges;

    public BridgeManager(@NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.configuration = configuration;
        this.preferencesStore = preferencesStore;
        preferencesStore.registerOnChangedListener(this);
        handleConfigurationForWebViews();
        this.registeredExternalBridges = new ArrayList();
    }

    private final void configureBridge(ExternalBridgeInterface externalBridge) {
        BridgeConfig bridgeConfig = getBridgeConfig();
        Json.Companion companion = Json.INSTANCE;
        companion.getSerializersModule();
        externalBridge.updateBridgeConfig(companion.encodeToString(BridgeConfig.INSTANCE.serializer(), bridgeConfig));
        boolean csInAppState = getCsInAppState(false);
        Boolean boolValueOf = Boolean.valueOf(csInAppState);
        externalBridge.notifyCsInAppEnabled(csInAppState);
        this.isCsInAppEnabled = boolValueOf;
    }

    private final BridgeConfig getBridgeConfig() {
        BridgeConfig bridgeConfig = this.bridgeConfig;
        if (bridgeConfig != null) {
            return bridgeConfig;
        }
        BridgeConfig updatedBridgeConfig = getUpdatedBridgeConfig();
        this.bridgeConfig = updatedBridgeConfig;
        return updatedBridgeConfig;
    }

    private final boolean getCsInAppState(boolean fromPreferenceStore) {
        Boolean bool = this.isCsInAppEnabled;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (!fromPreferenceStore) {
                return zBooleanValue;
            }
        }
        return this.preferencesStore.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false);
    }

    private final boolean getCurrentApiErrorEnabledState() {
        ArrayList arrayList = C0644c3.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ErrorAnalysisInterface) {
                arrayList2.add(next);
            }
        }
        ErrorAnalysisInterface errorAnalysisInterface = (ErrorAnalysisInterface) CollectionsKt.firstOrNull((List) arrayList2);
        if (errorAnalysisInterface != null) {
            return errorAnalysisInterface.isApiErrorEnabled();
        }
        return false;
    }

    private final boolean getCurrentCrashReportingEnabledState() {
        ArrayList arrayList = C0644c3.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ErrorAnalysisInterface) {
                arrayList2.add(next);
            }
        }
        ErrorAnalysisInterface errorAnalysisInterface = (ErrorAnalysisInterface) CollectionsKt.firstOrNull((List) arrayList2);
        if (errorAnalysisInterface != null) {
            return errorAnalysisInterface.isCrashReportingEnabled();
        }
        return false;
    }

    private final SDKState getCurrentSDKState(Boolean isOptIn, Boolean isTracking) {
        boolean zBooleanValue;
        if (isOptIn != null) {
            zBooleanValue = isOptIn.booleanValue();
        } else {
            zBooleanValue = (this.preferencesStore.getBoolean(PreferencesKey.IS_OPT_OUT, false) || this.preferencesStore.getBoolean(PreferencesKey.FORGET_ME, false)) ? false : true;
        }
        return new SDKState(zBooleanValue, isTracking != null ? isTracking.booleanValue() : this.preferencesStore.getBoolean(PreferencesKey.TRACKING_ENABLE, false));
    }

    private final boolean getCurrentSessionReplayMaskingState() {
        return this.preferencesStore.getBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, true);
    }

    @VisibleForTesting
    public static /* synthetic */ void getRegisteredExternalBridges$annotations() {
    }

    private final BridgeConfig getUpdatedBridgeConfig() {
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.WebView webView;
        boolean currentApiErrorEnabledState = getCurrentApiErrorEnabledState();
        boolean currentCrashReportingEnabledState = getCurrentCrashReportingEnabledState();
        JsonConfig.ProjectConfiguration projectConfig = this.configuration.getProjectConfig();
        List<JsonConfig.FeatureFlag> featureFlags = projectConfig != null ? projectConfig.getFeatureFlags() : null;
        if (featureFlags == null) {
            featureFlags = CollectionsKt.emptyList();
        }
        List<JsonConfig.FeatureFlag> list = featureFlags;
        JsonConfig.ProjectConfiguration projectConfig2 = this.configuration.getProjectConfig();
        String tagId = (projectConfig2 == null || (webView = projectConfig2.getWebView()) == null) ? null : webView.getTagId();
        JsonConfig.ProjectConfiguration projectConfig3 = this.configuration.getProjectConfig();
        return new BridgeConfig(currentCrashReportingEnabledState, currentApiErrorEnabledState, tagId, list, (projectConfig3 == null || (sessionReplay = projectConfig3.getSessionReplay()) == null) ? null : sessionReplay.getMaskingRules());
    }

    private final JsonConfig.FeatureFlag getWebViewHandleDataAssetFeatureFlag(JsonConfig.ProjectConfiguration projectConfig) {
        Object next;
        Iterator<T> it = projectConfig.getFeatureFlags().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((JsonConfig.FeatureFlag) next).getName(), JsonConfigFeatureFlagNames.WEBVIEW_HANDLE_DATA_ASSET)) {
                break;
            }
        }
        return (JsonConfig.FeatureFlag) next;
    }

    private final void handleConfigurationForWebViews() {
        JsonConfig.FeatureFlag featureFlag;
        JsonConfig.ProjectConfiguration projectConfig = this.configuration.getProjectConfig();
        if (projectConfig == null || (featureFlag = getWebViewHandleDataAssetFeatureFlag(projectConfig)) == null) {
            return;
        }
        S8.a.getClass();
        Intrinsics.checkNotNullParameter(featureFlag, "featureFlag");
        boolean zA = C0848x0.a(CoreModule.INSTANCE.getInstance(), featureFlag.getName());
        if (S8.f != zA) {
            S8.f = zA;
            Iterator<Map.Entry<WebView, M0>> it = S8.g.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().g.b = zA;
            }
            S8.a();
        }
    }

    private final void notifyExternalBridgesOnInAppFeatureEnable() {
        boolean csInAppState = getCsInAppState(true);
        if (Intrinsics.areEqual(Boolean.valueOf(csInAppState), this.isCsInAppEnabled)) {
            return;
        }
        this.isCsInAppEnabled = Boolean.valueOf(csInAppState);
        Iterator<T> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            ((ExternalBridgeInterface) it.next()).notifyCsInAppEnabled(csInAppState);
        }
    }

    private final void notifySdkStateChanges(SDKStateChangeType type, Boolean isOptIn, Boolean isTracking) {
        SDKState currentSDKState = getCurrentSDKState(isOptIn, isTracking);
        Iterator<T> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            ((ExternalBridgeInterface) it.next()).notifySDKStateChanges(type, currentSDKState);
        }
    }

    private final void notifySessionReplayMaskingConfigurationChanged() {
        boolean currentSessionReplayMaskingState = getCurrentSessionReplayMaskingState();
        if (Intrinsics.areEqual(Boolean.valueOf(currentSessionReplayMaskingState), this.isSessionReplayMaskingEnabled)) {
            return;
        }
        this.isSessionReplayMaskingEnabled = Boolean.valueOf(currentSessionReplayMaskingState);
        Iterator<T> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            ((ExternalBridgeInterface) it.next()).notifySrMaskingHasChanged(currentSessionReplayMaskingState);
        }
    }

    private final void notifyStartSdkOnBridge(ExternalBridgeInterface bridge) {
        bridge.notifySDKStateChanges(SDKStateChangeType.START, getCurrentSDKState(null, null));
    }

    private final void onConfigurationChanged() {
        BridgeConfig updatedBridgeConfig = getUpdatedBridgeConfig();
        this.bridgeConfig = updatedBridgeConfig;
        Json.Companion companion = Json.INSTANCE;
        companion.getSerializersModule();
        String strEncodeToString = companion.encodeToString(BridgeConfig.INSTANCE.serializer(), updatedBridgeConfig);
        Iterator<T> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            ((ExternalBridgeInterface) it.next()).updateBridgeConfig(strEncodeToString);
        }
    }

    public final void enableSessionReplay(boolean enable) {
        Iterator<ExternalBridgeInterface> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            it.next().notifySessionReplayEnabled(enable);
        }
        this.isSessionReplayEnabled = Boolean.valueOf(enable);
        S8.a.getClass();
        ((Logger) S8.b.getValue()).d("enableSessionReplay " + enable);
        for (M0 m0 : S8.g.values()) {
            if (!enable) {
                m0.g.d();
            } else if (m0.a()) {
                m0.g.b();
            }
        }
    }

    @NotNull
    public final List<ExternalBridgeInterface> getRegisteredExternalBridges() {
        return this.registeredExternalBridges;
    }

    public final boolean isFlutterRegistered() {
        List<ExternalBridgeInterface> list = this.registeredExternalBridges;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ExternalBridgeInterface) it.next()).getBridgeType() == ExternalBridgeType.FLUTTER) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSessionReplayEnabled() {
        Boolean bool = this.isSessionReplayEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void notifyForgetMe() {
        notifyOptOut();
    }

    public final void notifyOptIn() {
        notifySdkStateChanges(SDKStateChangeType.OPT_IN, Boolean.TRUE, null);
    }

    public final void notifyOptOut() {
        notifySdkStateChanges(SDKStateChangeType.OPT_OUT, Boolean.FALSE, null);
    }

    public final void notifyResumeTracking() {
        notifySdkStateChanges(SDKStateChangeType.TRACKING_RESUME, null, Boolean.TRUE);
    }

    public final void notifyStart() {
        notifySdkStateChanges(SDKStateChangeType.START, null, null);
    }

    public final void notifyStopTracking() {
        notifySdkStateChanges(SDKStateChangeType.TRACKING_STOP, null, Boolean.FALSE);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            onConfigurationChanged();
            handleConfigurationForWebViews();
        }
        if (key == PreferencesKey.CLIENT_MODE_ACTIVATION_STATE) {
            notifyExternalBridgesOnInAppFeatureEnable();
        }
        if (key == PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING) {
            notifySessionReplayMaskingConfigurationChanged();
        }
    }

    public final void registerExternalBridge(@NotNull ExternalBridgeInterface externalBridge) {
        Intrinsics.checkNotNullParameter(externalBridge, "externalBridge");
        if (this.registeredExternalBridges.contains(externalBridge)) {
            return;
        }
        this.registeredExternalBridges.add(externalBridge);
        configureBridge(externalBridge);
        notifyStartSdkOnBridge(externalBridge);
    }

    public final void setSessionReplayCapture(@Nullable ExternalBridgeSessionReplayCapture capture) {
        Iterator<ExternalBridgeInterface> it = this.registeredExternalBridges.iterator();
        while (it.hasNext()) {
            it.next().setSessionReplayCapture(capture);
        }
    }

    public final void unregisterExternalBridge(@NotNull ExternalBridgeInterface externalBridge) {
        Intrinsics.checkNotNullParameter(externalBridge, "externalBridge");
        this.registeredExternalBridges.remove(externalBridge);
    }
}
