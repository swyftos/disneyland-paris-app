package com.allegion.analytics;

import com.allegion.analytics.tracker.IAlEventTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/allegion/analytics/IAlAnalyticsProvider;", "", "addEventTracker", "eventTracker", "Lcom/allegion/analytics/tracker/IAlEventTracker;", "track", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlAnalyticsProvider {
    @NotNull
    IAlAnalyticsProvider addEventTracker(@NotNull IAlEventTracker eventTracker);

    @NotNull
    IAlEventTracker track();
}
