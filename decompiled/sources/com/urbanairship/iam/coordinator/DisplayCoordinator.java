package com.urbanairship.iam.coordinator;

import androidx.annotation.MainThread;
import com.urbanairship.iam.InAppMessage;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", "", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "messageFinishedDisplaying", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "messageWillDisplay", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DisplayCoordinator {
    @NotNull
    StateFlow<Boolean> isReady();

    @MainThread
    void messageFinishedDisplaying(@NotNull InAppMessage message);

    @MainThread
    void messageWillDisplay(@NotNull InAppMessage message);
}
