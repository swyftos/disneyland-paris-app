package com.urbanairship.iam.legacy;

import com.urbanairship.iam.analytics.InAppEventData;
import com.urbanairship.iam.analytics.InAppEventMessageId;
import com.urbanairship.iam.analytics.InAppEventRecorderInterface;
import com.urbanairship.iam.analytics.InAppEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyAnalytics;", "", "eventRecorder", "Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;", "(Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;)V", "recordDirectOpenEvent", "", "scheduleID", "", "recordReplacedEvent", "replacementID", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LegacyAnalytics {
    private final InAppEventRecorderInterface eventRecorder;

    public LegacyAnalytics(@NotNull InAppEventRecorderInterface eventRecorder) {
        Intrinsics.checkNotNullParameter(eventRecorder, "eventRecorder");
        this.eventRecorder = eventRecorder;
    }

    public final void recordReplacedEvent(@NotNull String scheduleID, @NotNull String replacementID) {
        Intrinsics.checkNotNullParameter(scheduleID, "scheduleID");
        Intrinsics.checkNotNullParameter(replacementID, "replacementID");
        this.eventRecorder.recordEvent(new InAppEventData(LegacyResolutionEvent.Companion.replaced(replacementID), null, InAppEventSource.AIRSHIP, new InAppEventMessageId.Legacy(scheduleID), null));
    }

    public final void recordDirectOpenEvent(@NotNull String scheduleID) {
        Intrinsics.checkNotNullParameter(scheduleID, "scheduleID");
        this.eventRecorder.recordEvent(new InAppEventData(LegacyResolutionEvent.Companion.directOpen(), null, InAppEventSource.AIRSHIP, new InAppEventMessageId.Legacy(scheduleID), null));
    }
}
