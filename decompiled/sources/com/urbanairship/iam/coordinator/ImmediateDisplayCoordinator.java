package com.urbanairship.iam.coordinator;

import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.iam.InAppMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/coordinator/ImmediateDisplayCoordinator;", "Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "(Lcom/urbanairship/app/ActivityMonitor;)V", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "messageFinishedDisplaying", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "messageWillDisplay", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImmediateDisplayCoordinator implements DisplayCoordinator {
    private final StateFlow isReady;

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    public void messageFinishedDisplaying(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    public void messageWillDisplay(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public ImmediateDisplayCoordinator(@NotNull ActivityMonitor activityMonitor) {
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        this.isReady = activityMonitor.getForegroundState();
    }

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    @NotNull
    public StateFlow<Boolean> isReady() {
        return this.isReady;
    }
}
