package com.urbanairship.iam;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "", "isMessageReadyToDisplay", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "scheduleId", "", "messageFinishedDisplaying", "", "messageWillDisplay", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InAppMessageDisplayDelegate {
    @MainThread
    boolean isMessageReadyToDisplay(@NotNull InAppMessage message, @NotNull String scheduleId);

    @MainThread
    void messageFinishedDisplaying(@NotNull InAppMessage message, @NotNull String scheduleId);

    @MainThread
    void messageWillDisplay(@NotNull InAppMessage message, @NotNull String scheduleId);
}
