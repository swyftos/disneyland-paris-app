package com.allegion.analytics.config;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", "", "appSecretKey", "", "getAppSecretKey", "()Ljava/lang/String;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "trackCrashes", "", "getTrackCrashes", "()Z", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlAppCenterAnalyticsConfig {
    @NotNull
    String getAppSecretKey();

    @NotNull
    Application getApplication();

    boolean getTrackCrashes();
}
