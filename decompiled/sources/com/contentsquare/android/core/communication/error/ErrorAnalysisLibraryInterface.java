package com.contentsquare.android.core.communication.error;

import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.analysis.CrashWrapped;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.disney.id.android.OneIDRecoveryContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u000278J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH&J\b\u0010\u001a\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H&JN\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u000101H&J'\u00102\u001a\u00020\u0013\"\b\b\u0000\u00103*\u00020\u00012\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u0002H3H&¢\u0006\u0002\u00106R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00069"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "", "configuration", "Lcom/contentsquare/android/core/features/config/Configuration;", "getConfiguration", "()Lcom/contentsquare/android/core/features/config/Configuration;", "screenViewTracker", "Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "getScreenViewTracker", "()Lcom/contentsquare/android/core/communication/ScreenViewTracker;", OneIDRecoveryContext.SESSION_ID, "", "getSessionId", "()Ljava/lang/Integer;", "userId", "", "getUserId", "()Ljava/lang/String;", "collectApiCall", "", "apiName", "getPendingCrashFiles", "", "isFeatureEnabled", "", "featureFlag", "isLogVisualizerEnabled", "logCrash", "crashData", "", "registerConfigurationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$ConfigurationChangedListener;", "saveCrashToDisk", "crash", "Lcom/contentsquare/android/core/communication/error/analysis/CrashWrapped;", "sendCrashToSessionReplay", "sendNetworkEventToAnalytics", "networkEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "sendNetworkMetricToSessionReplay", "storeLogEvent", "logLevel", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$LogLevel;", "description", "errorType", "errorMessage", "stacktrace", "additional", "", "telemetryCollect", ExifInterface.GPS_DIRECTION_TRUE, "name", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "ConfigurationChangedListener", "LogLevel", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ErrorAnalysisLibraryInterface {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$ConfigurationChangedListener;", "", "onConfigurationChanged", "", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ConfigurationChangedListener {
        void onConfigurationChanged(PreferencesKey key);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void storeLogEvent$default(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, LogLevel logLevel, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: storeLogEvent");
            }
            errorAnalysisLibraryInterface.storeLogEvent(logLevel, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? null : map);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$LogLevel;", "", "(Ljava/lang/String;I)V", "WARN", "ERROR", "CRITICAL", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LogLevel {
        WARN,
        ERROR,
        CRITICAL
    }

    void collectApiCall(String apiName);

    @Nullable
    Configuration getConfiguration();

    @NotNull
    List<String> getPendingCrashFiles();

    @Nullable
    ScreenViewTracker getScreenViewTracker();

    @Nullable
    Integer getSessionId();

    @Nullable
    String getUserId();

    boolean isFeatureEnabled(String featureFlag);

    boolean isLogVisualizerEnabled();

    void logCrash(byte[] crashData);

    void registerConfigurationChangedListener(ConfigurationChangedListener listener);

    void saveCrashToDisk(CrashWrapped crash);

    void sendCrashToSessionReplay(CrashWrapped crash);

    void sendNetworkEventToAnalytics(NetworkEvent networkEvent);

    void sendNetworkMetricToSessionReplay(NetworkEvent networkEvent);

    void storeLogEvent(LogLevel logLevel, String description, String errorType, String errorMessage, String stacktrace, Map<String, ? extends Object> additional);

    <T> void telemetryCollect(String name, T value);
}
