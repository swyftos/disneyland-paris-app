package com.allegion.analytics;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/allegion/analytics/AlAnalyticsConfig;", "Lcom/allegion/analytics/IAlAnalyticsConfig;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "appSecretKey", "", "trackCrashes", "", "enableDistribute", "(Landroid/app/Application;Ljava/lang/String;ZZ)V", "getAppSecretKey", "()Ljava/lang/String;", "getApplication", "()Landroid/app/Application;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getEnableDistribute", "()Z", "getTrackCrashes", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class AlAnalyticsConfig implements IAlAnalyticsConfig {

    @NotNull
    private final String appSecretKey;

    @NotNull
    private final Application application;
    private final boolean enableDistribute;
    private final boolean trackCrashes;

    public static /* synthetic */ AlAnalyticsConfig copy$default(AlAnalyticsConfig alAnalyticsConfig, Application application, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = alAnalyticsConfig.getApplication();
        }
        if ((i & 2) != 0) {
            str = alAnalyticsConfig.getAppSecretKey();
        }
        if ((i & 4) != 0) {
            z = alAnalyticsConfig.getTrackCrashes();
        }
        if ((i & 8) != 0) {
            z2 = alAnalyticsConfig.getEnableDistribute();
        }
        return alAnalyticsConfig.copy(application, str, z, z2);
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

    public final boolean component4() {
        return getEnableDistribute();
    }

    @NotNull
    public final AlAnalyticsConfig copy(@NotNull Application application, @NotNull String appSecretKey, boolean trackCrashes, boolean enableDistribute) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(appSecretKey, "appSecretKey");
        return new AlAnalyticsConfig(application, appSecretKey, trackCrashes, enableDistribute);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlAnalyticsConfig)) {
            return false;
        }
        AlAnalyticsConfig alAnalyticsConfig = (AlAnalyticsConfig) other;
        return Intrinsics.areEqual(getApplication(), alAnalyticsConfig.getApplication()) && Intrinsics.areEqual(getAppSecretKey(), alAnalyticsConfig.getAppSecretKey()) && getTrackCrashes() == alAnalyticsConfig.getTrackCrashes() && getEnableDistribute() == alAnalyticsConfig.getEnableDistribute();
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
        int i2 = (iHashCode2 + i) * 31;
        boolean enableDistribute = getEnableDistribute();
        return i2 + (enableDistribute ? 1 : enableDistribute);
    }

    @NotNull
    public String toString() {
        return "AlAnalyticsConfig(application=" + getApplication() + ", appSecretKey=" + getAppSecretKey() + ", trackCrashes=" + getTrackCrashes() + ", enableDistribute=" + getEnableDistribute() + ")";
    }

    public AlAnalyticsConfig(@NotNull Application application, @NotNull String appSecretKey, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(appSecretKey, "appSecretKey");
        this.application = application;
        this.appSecretKey = appSecretKey;
        this.trackCrashes = z;
        this.enableDistribute = z2;
    }

    @Override // com.allegion.analytics.IAlAnalyticsConfig
    @NotNull
    public Application getApplication() {
        return this.application;
    }

    @Override // com.allegion.analytics.IAlAnalyticsConfig
    @NotNull
    public String getAppSecretKey() {
        return this.appSecretKey;
    }

    @Override // com.allegion.analytics.IAlAnalyticsConfig
    public boolean getTrackCrashes() {
        return this.trackCrashes;
    }

    public /* synthetic */ AlAnalyticsConfig(Application application, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2);
    }

    @Override // com.allegion.analytics.IAlAnalyticsConfig
    public boolean getEnableDistribute() {
        return this.enableDistribute;
    }

    @NotNull
    public final Context getContext() {
        Context applicationContext = getApplication().getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "application.applicationContext");
        return applicationContext;
    }
}
