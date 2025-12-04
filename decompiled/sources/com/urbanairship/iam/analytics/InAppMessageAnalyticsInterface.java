package com.urbanairship.iam.analytics;

import com.dlp.BluetoothManager;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.iam.analytics.events.InAppEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "", "customEventContext", "Lcom/urbanairship/iam/analytics/InAppCustomEventContext;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "recordEvent", "", "event", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "layoutContext", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InAppMessageAnalyticsInterface {
    @NotNull
    InAppCustomEventContext customEventContext(@Nullable LayoutData state);

    void recordEvent(@NotNull InAppEvent event, @Nullable LayoutData layoutContext);
}
