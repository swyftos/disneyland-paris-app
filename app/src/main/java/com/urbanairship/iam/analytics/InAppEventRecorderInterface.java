package com.urbanairship.iam.analytics;

import com.urbanairship.meteredusage.MeteredUsageEventEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;", "", "recordEvent", "", "event", "Lcom/urbanairship/iam/analytics/InAppEventData;", "recordImpressionEvent", "Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface InAppEventRecorderInterface {
    void recordEvent(@NotNull InAppEventData event);

    void recordImpressionEvent(@NotNull MeteredUsageEventEntity event);
}
