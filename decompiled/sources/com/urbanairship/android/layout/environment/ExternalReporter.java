package com.urbanairship.android.layout.environment;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.android.layout.ThomasListenerInterface;
import com.urbanairship.android.layout.event.ReportingEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/environment/ExternalReporter;", "Lcom/urbanairship/android/layout/environment/Reporter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "(Lcom/urbanairship/android/layout/ThomasListenerInterface;)V", "getListener", "()Lcom/urbanairship/android/layout/ThomasListenerInterface;", "onVisibilityChanged", "", "isVisible", "", "isForegrounded", "report", "event", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExternalReporter implements Reporter {
    private final ThomasListenerInterface listener;

    public ExternalReporter(@NotNull ThomasListenerInterface listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @NotNull
    public final ThomasListenerInterface getListener() {
        return this.listener;
    }

    @Override // com.urbanairship.android.layout.environment.Reporter
    public void report(@NotNull ReportingEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.listener.onReportingEvent(event);
        if (event instanceof ReportingEvent.Dismiss) {
            ReportingEvent.Dismiss dismiss = (ReportingEvent.Dismiss) event;
            ReportingEvent.DismissData data = dismiss.getData();
            if (data instanceof ReportingEvent.DismissData.ButtonTapped) {
                this.listener.onDismiss(((ReportingEvent.DismissData.ButtonTapped) dismiss.getData()).getCancel());
            } else if (Intrinsics.areEqual(data, ReportingEvent.DismissData.TimedOut.INSTANCE)) {
                this.listener.onDismiss(false);
            } else if (Intrinsics.areEqual(data, ReportingEvent.DismissData.UserDismissed.INSTANCE)) {
                this.listener.onDismiss(true);
            }
        }
    }

    @Override // com.urbanairship.android.layout.environment.Reporter
    public void onVisibilityChanged(boolean isVisible, boolean isForegrounded) {
        this.listener.onVisibilityChanged(isVisible, isForegrounded);
    }
}
