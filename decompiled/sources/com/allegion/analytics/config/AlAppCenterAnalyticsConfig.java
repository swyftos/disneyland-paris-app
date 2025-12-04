package com.allegion.analytics.config;

import android.app.Application;
import android.content.Context;
import androidx.media3.common.MimeTypes;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;", "Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "appSecretKey", "", "trackCrashes", "", "(Landroid/app/Application;Ljava/lang/String;Z)V", "getAppSecretKey", "()Ljava/lang/String;", "getApplication", "()Landroid/app/Application;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getTrackCrashes", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class AlAppCenterAnalyticsConfig implements IAlAppCenterAnalyticsConfig {

    @NotNull
    private final String appSecretKey;

    @NotNull
    private final Application application;
    private final boolean trackCrashes;

    public static /* synthetic */ AlAppCenterAnalyticsConfig copy$default(AlAppCenterAnalyticsConfig alAppCenterAnalyticsConfig, Application application, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            application = alAppCenterAnalyticsConfig.getApplication();
        }
        if ((i & 2) != 0) {
            str = alAppCenterAnalyticsConfig.getAppSecretKey();
        }
        if ((i & 4) != 0) {
            z = alAppCenterAnalyticsConfig.getTrackCrashes();
        }
        return alAppCenterAnalyticsConfig.copy(application, str, z);
    }

    @NotNull
    public final Application component1() {
        return getApplication();
    }

    @NotNull
    public final String component2() {
        return getAppSecretKey();
    }

    public final boolean component3() {
        return getTrackCrashes();
    }

    @NotNull
    public final AlAppCenterAnalyticsConfig copy(@NotNull Application application, @NotNull String appSecretKey, boolean trackCrashes) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(appSecretKey, "appSecretKey");
        return new AlAppCenterAnalyticsConfig(application, appSecretKey, trackCrashes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlAppCenterAnalyticsConfig)) {
            return false;
        }
        AlAppCenterAnalyticsConfig alAppCenterAnalyticsConfig = (AlAppCenterAnalyticsConfig) other;
        return Intrinsics.areEqual(getApplication(), alAppCenterAnalyticsConfig.getApplication()) && Intrinsics.areEqual(getAppSecretKey(), alAppCenterAnalyticsConfig.getAppSecretKey()) && getTrackCrashes() == alAppCenterAnalyticsConfig.getTrackCrashes();
    }

    public int hashCode() {
        Application application = getApplication();
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        String appSecretKey = getAppSecretKey();
        int iHashCode2 = (iHashCode + (appSecretKey != null ? appSecretKey.hashCode() : 0)) * 31;
        boolean trackCrashes = getTrackCrashes();
        int i = trackCrashes;
        if (trackCrashes) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "AlAppCenterAnalyticsConfig(application=" + getApplication() + ", appSecretKey=" + getAppSecretKey() + ", trackCrashes=" + getTrackCrashes() + ")";
    }

    public AlAppCenterAnalyticsConfig(@NotNull Application application, @NotNull String appSecretKey, boolean z) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(appSecretKey, "appSecretKey");
        this.application = application;
        this.appSecretKey = appSecretKey;
        this.trackCrashes = z;
    }

    @Override // com.allegion.analytics.config.IAlAppCenterAnalyticsConfig
    @NotNull
    public Application getApplication() {
        return this.application;
    }

    @Override // com.allegion.analytics.config.IAlAppCenterAnalyticsConfig
    @NotNull
    public String getAppSecretKey() {
        return this.appSecretKey;
    }

    public /* synthetic */ AlAppCenterAnalyticsConfig(Application application, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, (i & 4) != 0 ? true : z);
    }

    @Override // com.allegion.analytics.config.IAlAppCenterAnalyticsConfig
    public boolean getTrackCrashes() {
        return this.trackCrashes;
    }

    @NotNull
    public final Context getContext() {
        Context applicationContext = getApplication().getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "application.applicationContext");
        return applicationContext;
    }
}
