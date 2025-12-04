package com.allegion.analytics;

import com.allegion.analytics.config.AlAppCenterAnalyticsConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/allegion/analytics/AlAnalytics;", "", "()V", "initialize", "", "config", "Lcom/allegion/analytics/AlAnalyticsConfig;", "Lcom/allegion/analytics/AlAppCenterAnalytics;", "Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAnalytics {
    public static final AlAnalytics INSTANCE = new AlAnalytics();

    private AlAnalytics() {
    }

    @JvmStatic
    @NotNull
    public static final AlAppCenterAnalytics initialize(@NotNull AlAppCenterAnalyticsConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        return new AlAppCenterAnalytics(config);
    }

    @JvmStatic
    public static final void initialize(@NotNull AlAnalyticsConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        AlAnalyticsLogging.initialize(config);
    }
}
