package com.allegion.analytics;

import com.allegion.analytics.config.AlAppCenterAnalyticsConfig;
import com.allegion.analytics.tracker.AlAppCenterEventTracker;
import com.allegion.analytics.tracker.AlCompositeEventTracker;
import com.allegion.analytics.tracker.AlLoggingEventTracker;
import com.allegion.analytics.tracker.IAlEventTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0000J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\u0000J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/allegion/analytics/AlAppCenterAnalytics;", "Lcom/allegion/analytics/IAlAnalyticsProvider;", "config", "Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;", "(Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;)V", "compositeEventTracker", "Lcom/allegion/analytics/tracker/AlCompositeEventTracker;", "addAppCenterEventTracker", "addEventTracker", "eventTracker", "Lcom/allegion/analytics/tracker/IAlEventTracker;", "addLoggingEventTracker", "track", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAppCenterAnalytics implements IAlAnalyticsProvider {
    private final AlCompositeEventTracker compositeEventTracker;
    private final AlAppCenterAnalyticsConfig config;

    public AlAppCenterAnalytics(@NotNull AlAppCenterAnalyticsConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.config = config;
        this.compositeEventTracker = new AlCompositeEventTracker();
    }

    @NotNull
    public final AlAppCenterAnalytics addLoggingEventTracker() {
        addEventTracker((IAlEventTracker) AlLoggingEventTracker.INSTANCE.instance(this.config));
        return this;
    }

    @Override // com.allegion.analytics.IAlAnalyticsProvider
    @NotNull
    public AlAppCenterAnalytics addEventTracker(@NotNull IAlEventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        this.compositeEventTracker.add(eventTracker);
        return this;
    }

    @Override // com.allegion.analytics.IAlAnalyticsProvider
    @NotNull
    public IAlEventTracker track() {
        return this.compositeEventTracker;
    }

    @NotNull
    public final AlAppCenterAnalytics addAppCenterEventTracker() {
        addEventTracker((IAlEventTracker) AlAppCenterEventTracker.INSTANCE.instance(this.config));
        return this;
    }
}
