package com.contentsquare.android.error.analysis.internal;

import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.CrashWrapped;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.error.analysis.internal.crash.CrashUtils;
import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.A5;
import com.contentsquare.android.sdk.C0793r3;
import com.contentsquare.android.sdk.C0803s3;
import com.contentsquare.android.sdk.C0848x0;
import com.contentsquare.android.sdk.C0853x5;
import com.contentsquare.android.sdk.C5;
import com.contentsquare.android.sdk.E1;
import com.contentsquare.android.sdk.G0;
import com.contentsquare.android.sdk.L2;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.M7;
import com.disney.id.android.OneIDRecoveryContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016JF\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00152\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0016J'\u0010=\u001a\u00020\u0019\"\b\b\u0000\u0010>*\u00020<2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u0002H>H\u0016¢\u0006\u0002\u0010AR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006B"}, d2 = {"Lcom/contentsquare/android/error/analysis/internal/ErrorAnalysisLibraryInterfaceImpl;", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "()V", "configuration", "Lcom/contentsquare/android/core/features/config/Configuration;", "getConfiguration", "()Lcom/contentsquare/android/core/features/config/Configuration;", "configurationListeners", "", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$ConfigurationChangedListener;", "lazyScreenViewTracker", "Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "screenViewTracker", "getScreenViewTracker", "()Lcom/contentsquare/android/core/communication/ScreenViewTracker;", OneIDRecoveryContext.SESSION_ID, "", "getSessionId", "()Ljava/lang/Integer;", "userId", "", "getUserId", "()Ljava/lang/String;", "collectApiCall", "", "apiName", "getPendingCrashFiles", "", "isFeatureEnabled", "", "featureFlag", "isFlagEnabled", "flag", "isLogVisualizerEnabled", "logCrash", "crashData", "", "onPreferenceChanged", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "registerConfigurationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "saveCrashToDisk", "crash", "Lcom/contentsquare/android/core/communication/error/analysis/CrashWrapped;", "sendCrashToSessionReplay", "sendNetworkEventToAnalytics", "networkEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "sendNetworkMetricToSessionReplay", "storeLogEvent", "logLevel", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$LogLevel;", "description", "errorType", "errorMessage", "stacktrace", "additional", "", "", "telemetryCollect", ExifInterface.GPS_DIRECTION_TRUE, "name", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nErrorAnalysisLibraryInterfaceImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorAnalysisLibraryInterfaceImpl.kt\ncom/contentsquare/android/error/analysis/internal/ErrorAnalysisLibraryInterfaceImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,183:1\n1855#2,2:184\n*S KotlinDebug\n*F\n+ 1 ErrorAnalysisLibraryInterfaceImpl.kt\ncom/contentsquare/android/error/analysis/internal/ErrorAnalysisLibraryInterfaceImpl\n*L\n146#1:184,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ErrorAnalysisLibraryInterfaceImpl implements ErrorAnalysisLibraryInterface, PreferencesStore.PreferencesStoreListener {

    @NotNull
    private final List<ErrorAnalysisLibraryInterface.ConfigurationChangedListener> configurationListeners = new ArrayList();

    @Nullable
    private ScreenViewTracker lazyScreenViewTracker;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorAnalysisLibraryInterface.LogLevel.values().length];
            try {
                iArr[ErrorAnalysisLibraryInterface.LogLevel.WARN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorAnalysisLibraryInterface.LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorAnalysisLibraryInterface.LogLevel.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ErrorAnalysisLibraryInterfaceImpl() {
        PreferencesStore preferencesStore;
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || (preferencesStore = companion.getPreferencesStore()) == null) {
            return;
        }
        preferencesStore.registerOnChangedListener(this);
    }

    private final boolean isFlagEnabled(String flag) {
        return C0848x0.a(CoreModule.INSTANCE.getInstance(), flag);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void collectApiCall(@NotNull String apiName) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Telemetry.INSTANCE.collectApiCall(apiName);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    @Nullable
    public Configuration getConfiguration() {
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion != null) {
            return companion.getConfiguration();
        }
        return null;
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    @NotNull
    public List<String> getPendingCrashFiles() {
        return CrashUtils.INSTANCE.getPendingCrashFiles();
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    @Nullable
    public ScreenViewTracker getScreenViewTracker() {
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        PreferencesStore preferencesStore = companion != null ? companion.getPreferencesStore() : null;
        if (this.lazyScreenViewTracker == null && preferencesStore != null) {
            this.lazyScreenViewTracker = new ScreenViewTracker(preferencesStore);
        }
        return this.lazyScreenViewTracker;
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    @Nullable
    public Integer getSessionId() {
        A5 session;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null || (session = csApplicationModule.getSession()) == null) {
            return null;
        }
        return Integer.valueOf(session.k);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    @Nullable
    public String getUserId() {
        M7 userIdRestoreHelper;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null || (userIdRestoreHelper = csApplicationModule.getUserIdRestoreHelper()) == null) {
            return null;
        }
        return userIdRestoreHelper.a();
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public boolean isFeatureEnabled(@NotNull String featureFlag) {
        C0853x5 sdkManager;
        Intrinsics.checkNotNullParameter(featureFlag, "featureFlag");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null || (sdkManager = csApplicationModule.getSdkManager()) == null || !sdkManager.f) {
            return false;
        }
        return isFlagEnabled(featureFlag);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public boolean isLogVisualizerEnabled() {
        PreferencesStore preferencesStore;
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || (preferencesStore = companion.getPreferencesStore()) == null) {
            return false;
        }
        return preferencesStore.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void logCrash(@NotNull byte[] crashData) {
        Intrinsics.checkNotNullParameter(crashData, "crashData");
        CrashUtils.INSTANCE.logCrash(crashData);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        for (ErrorAnalysisLibraryInterface.ConfigurationChangedListener configurationChangedListener : this.configurationListeners) {
            if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON || key == PreferencesKey.TRACKING_ENABLE) {
                configurationChangedListener.onConfigurationChanged(key);
            }
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void registerConfigurationChangedListener(@NotNull ErrorAnalysisLibraryInterface.ConfigurationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.configurationListeners.add(listener);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void saveCrashToDisk(@NotNull CrashWrapped crash) {
        Intrinsics.checkNotNullParameter(crash, "crash");
        CrashUtils.INSTANCE.saveCrashToDisk(crash.getData());
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void sendCrashToSessionReplay(@NotNull CrashWrapped crash) {
        Intrinsics.checkNotNullParameter(crash, "crash");
        C5 c5 = C5.k;
        if (c5 != null) {
            long timestamp = crash.getTimestamp();
            long crashId = crash.getData().getCrashId();
            long relativeTime = crash.getData().getRelativeTime();
            String errorSource = crash.getData().getContext().getErrorSource();
            Intrinsics.checkNotNullExpressionValue(errorSource, "crash.data.context.errorSource");
            G0 event = new G0(timestamp, crashId, relativeTime, errorSource);
            Intrinsics.checkNotNullParameter(event, "event");
            c5.j.addCrashAndSaveToDisk(event);
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void sendNetworkEventToAnalytics(@NotNull NetworkEvent networkEvent) {
        M4 runTime;
        Intrinsics.checkNotNullParameter(networkEvent, "networkEvent");
        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
        if (csRuntimeModule == null || (runTime = csRuntimeModule.getRunTime()) == null) {
            return;
        }
        L2 l2 = runTime.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(networkEvent, "event");
        E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C0793r3.a aVar = (C0793r3.a) E1.a(eventsBuildersFactory, 21);
        aVar.l = networkEvent.getHttpMethod();
        aVar.k = networkEvent.getUrl();
        aVar.o = networkEvent.getStatusCode();
        aVar.m = networkEvent.getRequestTime();
        aVar.n = networkEvent.getResponseTime();
        aVar.p = networkEvent.getSource();
        aVar.q = networkEvent.getMatchingBodyContents();
        aVar.r = networkEvent.getPlainResponseBodyAttributes();
        l2.c.a(aVar);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void sendNetworkMetricToSessionReplay(@NotNull NetworkEvent networkEvent) {
        Intrinsics.checkNotNullParameter(networkEvent, "networkEvent");
        C5 c5 = C5.k;
        if (c5 != null) {
            C0803s3 event = new C0803s3(networkEvent);
            Intrinsics.checkNotNullParameter(event, "event");
            c5.a.a(event);
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public void storeLogEvent(@NotNull ErrorAnalysisLibraryInterface.LogLevel logLevel, @NotNull String description, @NotNull String errorType, @NotNull String errorMessage, @NotNull String stacktrace, @Nullable Map<String, ? extends Object> additional) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        int i = WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()];
        if (i == 1) {
            LogMonitor.INSTANCE.warn(description, additional);
        } else if (i == 2) {
            LogMonitor.INSTANCE.error(description, errorType, errorMessage, stacktrace, additional);
        } else {
            if (i != 3) {
                return;
            }
            LogMonitor.INSTANCE.crash(description, stacktrace, additional);
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface
    public <T> void telemetryCollect(@NotNull String name, @NotNull T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Telemetry.INSTANCE.collect$library_release(name, value);
    }
}
