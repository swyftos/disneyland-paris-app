package com.allegion.accesssdk.actions;

import android.app.Application;
import android.util.Pair;
import com.allegion.accesssdk.enums.AlSdkEnvironment;
import com.allegion.analytics.AlAnalytics;
import com.allegion.analytics.AlAppCenterAnalytics;
import com.allegion.analytics.config.AlAppCenterAnalyticsConfig;

/* loaded from: classes2.dex */
public class AlAnalyticsService implements IAlAnalyticsService {
    private AlAppCenterAnalytics analytics;

    AlAnalyticsService(Application application) {
        AlAppCenterAnalytics alAppCenterAnalyticsInitialize = AlAnalytics.initialize(new AlAppCenterAnalyticsConfig(application, AlSdkEnvironment.getCurrent().getAppCenterAppId(), AlSdkEnvironment.getCurrent().getTrackCrashes()));
        this.analytics = alAppCenterAnalyticsInitialize;
        alAppCenterAnalyticsInitialize.addAppCenterEventTracker();
        this.analytics.addLoggingEventTracker();
        this.analytics.track();
        trackEvent("SDK Configuration", "Initialize SDK", new Pair("App ID", application.getPackageName()));
    }

    @Override // com.allegion.accesssdk.actions.IAlAnalyticsService
    public void trackEvent(String str, String str2, Pair pair) {
        this.analytics.track().event(str, str2, pair);
    }

    @Override // com.allegion.accesssdk.actions.IAlAnalyticsService
    public void trackFail(String str, String str2, Pair pair) {
        this.analytics.track().failureEvent(str, str2, pair);
    }

    @Override // com.allegion.accesssdk.actions.IAlAnalyticsService
    public void trackSuccess(String str, String str2, Pair pair) {
        this.analytics.track().successEvent(str, str2, pair);
    }
}
