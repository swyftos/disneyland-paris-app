package com.contentsquare.android.core.utils;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u001a\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/contentsquare/android/core/utils/UriBuilder;", "", "()V", "ANALYTICS_ENDPOINT_VERSION", "", "ANALYTICS_EVENT_ENDPOINT", "CONFIG_ENDPOINT_EXTENSION", "DC_MONITOR_LOG_ANDROID", "DC_MONITOR_LOG_SDK_METRIC", "DC_MONITOR_PRODUCTION_ENDPOINT", "DC_MONITOR_QA_ENDPOINT", "DC_MONITOR_STAGING_ENDPOINT", "SCREENGRAPH_VERSION", "projectConfigUrl", "getProjectConfigUrl$annotations", "getProjectConfigUrl", "()Ljava/lang/String;", "setProjectConfigUrl", "(Ljava/lang/String;)V", "buildEventsUrl", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "buildLogMonitorUrl", "buildType", "buildLogSdkMetricUrl", "isQA", "", "buildProjectConfigUrl", "appId", "buildScreengraphUrl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UriBuilder {

    @NotNull
    public static final String ANALYTICS_ENDPOINT_VERSION = "v2";

    @NotNull
    public static final String ANALYTICS_EVENT_ENDPOINT = "events";

    @NotNull
    public static final String CONFIG_ENDPOINT_EXTENSION = ".json";

    @NotNull
    public static final String DC_MONITOR_LOG_ANDROID = "/log/android";

    @NotNull
    public static final String DC_MONITOR_LOG_SDK_METRIC = "/log/sdkmetric";

    @NotNull
    public static final String DC_MONITOR_PRODUCTION_ENDPOINT = "https://l.contentsquare.net";

    @NotNull
    public static final String DC_MONITOR_QA_ENDPOINT = "https://qa-mock-server.contentsquare.net";

    @NotNull
    public static final String DC_MONITOR_STAGING_ENDPOINT = "https://dc-monitor-staging-eu-west-1.csq.io";

    @NotNull
    public static final String SCREENGRAPH_VERSION = "v2";

    @NotNull
    public static final UriBuilder INSTANCE = new UriBuilder();

    @NotNull
    private static String projectConfigUrl = "https://mobile-production.content-square.net/android/config/v2/";

    private UriBuilder() {
    }

    @JvmStatic
    @NotNull
    public static final String buildEventsUrl(String endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return endpoint + "/mobile/v2/events";
    }

    @JvmStatic
    @NotNull
    public static final String buildLogMonitorUrl(String buildType) {
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        return !Intrinsics.areEqual(buildType, "release") ? "https://dc-monitor-staging-eu-west-1.csq.io/log/android" : "https://l.contentsquare.net/log/android";
    }

    public static /* synthetic */ String buildLogSdkMetricUrl$default(UriBuilder uriBuilder, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "release";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return uriBuilder.buildLogSdkMetricUrl(str, z);
    }

    @JvmStatic
    @NotNull
    public static final String buildProjectConfigUrl(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return projectConfigUrl + appId + ".json";
    }

    @VisibleForTesting
    public static /* synthetic */ void getProjectConfigUrl$annotations() {
    }

    @NotNull
    public final String buildLogSdkMetricUrl(String buildType, boolean isQA) {
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        return isQA ? "https://qa-mock-server.contentsquare.net/log/sdkmetric" : !Intrinsics.areEqual(buildType, "release") ? "https://dc-monitor-staging-eu-west-1.csq.io/log/sdkmetric" : "https://l.contentsquare.net/log/sdkmetric";
    }

    @NotNull
    public final String buildScreengraphUrl(String endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return endpoint + "/snapshots/v2/snapshot";
    }

    @NotNull
    public final String getProjectConfigUrl() {
        return projectConfigUrl;
    }

    public final void setProjectConfigUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        projectConfigUrl = str;
    }
}
