package com.urbanairship.featureflag;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.featureflag.FeatureFlagsModuleFactory;
import com.urbanairship.remotedata.RemoteData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagsModuleFactoryImpl;", "Lcom/urbanairship/modules/featureflag/FeatureFlagsModuleFactory;", "()V", "airshipVersion", "", "getAirshipVersion", "()Ljava/lang/String;", "packageVersion", "getPackageVersion", "build", "Lcom/urbanairship/modules/Module;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "cache", "Lcom/urbanairship/cache/AirshipCache;", "resolver", "Lcom/urbanairship/deferred/DeferredResolver;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class FeatureFlagsModuleFactoryImpl implements FeatureFlagsModuleFactory {

    @NotNull
    private final String airshipVersion = "19.9.1";

    @NotNull
    private final String packageVersion = com.urbanairship.BuildConfig.SDK_VERSION;

    @Override // com.urbanairship.modules.featureflag.FeatureFlagsModuleFactory
    @NotNull
    public Module build(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull RemoteData remoteData, @NotNull Analytics analytics, @NotNull AirshipCache cache, @NotNull DeferredResolver resolver, @NotNull PrivacyManager privacyManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Module moduleSingleComponent = Module.singleComponent(new FeatureFlagManager(applicationContext, dataStore, new AudienceEvaluator(cache), new FeatureFlagRemoteDataAccess(remoteData, null, 2, null), null, new FlagDeferredResolver(cache, resolver, null, null, 12, null), new FeatureFlagAnalytics(analytics), privacyManager, new FeatureFlagResultCache(cache), 16, null), 0);
        Intrinsics.checkNotNullExpressionValue(moduleSingleComponent, "singleComponent(...)");
        return moduleSingleComponent;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getAirshipVersion() {
        return this.airshipVersion;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getPackageVersion() {
        return this.packageVersion;
    }
}
