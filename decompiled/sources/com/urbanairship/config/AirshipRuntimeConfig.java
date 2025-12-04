package com.urbanairship.config;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.Provider;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.http.RequestSession;
import com.urbanairship.remoteconfig.RemoteAirshipConfig;
import com.urbanairship.remoteconfig.RemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@OpenForTesting
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u0000 82\u00020\u0001:\u000289B3\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bB3\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020$H\u0017J&\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u0001052\u0006\u0010\u000f\u001a\u00020\u0010H\u0012R\u000e\u0010\u000f\u001a\u00020\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\rX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0014¨\u0006:"}, d2 = {"Lcom/urbanairship/config/AirshipRuntimeConfig;", "", "configOptionsProvider", "Lcom/urbanairship/Provider;", "Lcom/urbanairship/AirshipConfigOptions;", "requestSession", "Lcom/urbanairship/http/RequestSession;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "platformProvider", "", "(Lcom/urbanairship/Provider;Lcom/urbanairship/http/RequestSession;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/Provider;)V", "configObserver", "Lcom/urbanairship/config/RemoteConfigObserver;", "(Lcom/urbanairship/Provider;Lcom/urbanairship/http/RequestSession;Lcom/urbanairship/config/RemoteConfigObserver;Lcom/urbanairship/Provider;)V", "allowUrlFallback", "", "analyticsUrl", "Lcom/urbanairship/config/UrlBuilder;", "getAnalyticsUrl", "()Lcom/urbanairship/config/UrlBuilder;", "getConfigObserver$urbanairship_core_release", "()Lcom/urbanairship/config/RemoteConfigObserver;", "configOptions", "getConfigOptions", "()Lcom/urbanairship/AirshipConfigOptions;", "deviceUrl", "getDeviceUrl", "isDeviceUrlAvailable", "()Z", "meteredUsageUrl", "getMeteredUsageUrl", DeferredApiClient.KEY_PLATFORM, "getPlatform", "()I", "remoteConfig", "Lcom/urbanairship/remoteconfig/RemoteConfig;", "getRemoteConfig", "()Lcom/urbanairship/remoteconfig/RemoteConfig;", "remoteDataUrl", "getRemoteDataUrl", "getRequestSession", "()Lcom/urbanairship/http/RequestSession;", "walletUrl", "getWalletUrl", "addConfigListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "removeRemoteConfigListener", "updateRemoteConfig", "config", "url", "", "remote", "fallback", "Companion", "ConfigChangeListener", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class AirshipRuntimeConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowUrlFallback;
    private final RemoteConfigObserver configObserver;
    private final Provider configOptionsProvider;
    private final Provider platformProvider;
    private final RequestSession requestSession;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "", "onConfigUpdated", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ConfigChangeListener {
        void onConfigUpdated();
    }

    public AirshipRuntimeConfig(@NotNull Provider<AirshipConfigOptions> configOptionsProvider, @NotNull RequestSession requestSession, @NotNull RemoteConfigObserver configObserver, @NotNull Provider<Integer> platformProvider) {
        Intrinsics.checkNotNullParameter(configOptionsProvider, "configOptionsProvider");
        Intrinsics.checkNotNullParameter(requestSession, "requestSession");
        Intrinsics.checkNotNullParameter(configObserver, "configObserver");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.configOptionsProvider = configOptionsProvider;
        this.requestSession = requestSession;
        this.configObserver = configObserver;
        this.platformProvider = platformProvider;
        this.allowUrlFallback = INSTANCE.determineUrlFallback(configOptionsProvider.get());
    }

    @NotNull
    public RequestSession getRequestSession() {
        return this.requestSession;
    }

    @NotNull
    /* renamed from: getConfigObserver$urbanairship_core_release, reason: from getter */
    public RemoteConfigObserver getConfigObserver() {
        return this.configObserver;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AirshipRuntimeConfig(@NotNull Provider<AirshipConfigOptions> configOptionsProvider, @NotNull RequestSession requestSession, @NotNull PreferenceDataStore dataStore, @NotNull Provider<Integer> platformProvider) {
        this(configOptionsProvider, requestSession, new RemoteConfigObserver(dataStore), platformProvider);
        Intrinsics.checkNotNullParameter(configOptionsProvider, "configOptionsProvider");
        Intrinsics.checkNotNullParameter(requestSession, "requestSession");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
    }

    public int getPlatform() {
        return ((Number) this.platformProvider.get()).intValue();
    }

    @NotNull
    public RemoteConfig getRemoteConfig() {
        return getConfigObserver().getRemoteConfig();
    }

    @NotNull
    public AirshipConfigOptions getConfigOptions() {
        return (AirshipConfigOptions) this.configOptionsProvider.get();
    }

    @NotNull
    public UrlBuilder getDeviceUrl() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        return new UrlBuilder(url(airshipConfig != null ? airshipConfig.getDeviceApiUrl() : null, getConfigOptions().deviceUrl, this.allowUrlFallback));
    }

    @NotNull
    public UrlBuilder getWalletUrl() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        return new UrlBuilder(url(airshipConfig != null ? airshipConfig.getWalletUrl() : null, getConfigOptions().walletUrl, this.allowUrlFallback));
    }

    @NotNull
    public UrlBuilder getAnalyticsUrl() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        return new UrlBuilder(url(airshipConfig != null ? airshipConfig.getAnalyticsUrl() : null, getConfigOptions().analyticsUrl, this.allowUrlFallback));
    }

    @NotNull
    public UrlBuilder getRemoteDataUrl() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        String remoteDataUrl = airshipConfig != null ? airshipConfig.getRemoteDataUrl() : null;
        String str = getConfigOptions().initialConfigUrl;
        if (str == null) {
            str = getConfigOptions().remoteDataUrl;
        }
        return new UrlBuilder(url(remoteDataUrl, str, true));
    }

    @NotNull
    public UrlBuilder getMeteredUsageUrl() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        return new UrlBuilder(url(airshipConfig != null ? airshipConfig.getMeteredUsageUrl() : null, null, false));
    }

    public boolean isDeviceUrlAvailable() {
        RemoteAirshipConfig airshipConfig = getRemoteConfig().getAirshipConfig();
        return url(airshipConfig != null ? airshipConfig.getDeviceApiUrl() : null, getConfigOptions().deviceUrl, this.allowUrlFallback) != null;
    }

    private String url(String remote, String fallback, boolean allowUrlFallback) {
        if (remote != null && remote.length() != 0) {
            return remote;
        }
        if (!allowUrlFallback || fallback == null || fallback.length() == 0) {
            return null;
        }
        return fallback;
    }

    public void addConfigListener(@NotNull ConfigChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getConfigObserver().addConfigListener(listener);
    }

    public void removeRemoteConfigListener(@NotNull ConfigChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getConfigObserver().removeRemoteConfigListener(listener);
    }

    @VisibleForTesting
    public void updateRemoteConfig(@NotNull RemoteConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        getConfigObserver().updateRemoteConfig(config);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/config/AirshipRuntimeConfig$Companion;", "", "()V", "determineUrlFallback", "", "configOptions", "Lcom/urbanairship/AirshipConfigOptions;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean determineUrlFallback(AirshipConfigOptions configOptions) {
            return (StringsKt.equals("huawei", Build.MANUFACTURER, true) || configOptions.requireInitialRemoteConfigEnabled || configOptions.initialConfigUrl != null) ? false : true;
        }
    }
}
