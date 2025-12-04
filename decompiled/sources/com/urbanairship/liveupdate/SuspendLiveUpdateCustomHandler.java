package com.urbanairship.liveupdate;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/liveupdate/SuspendLiveUpdateCustomHandler;", "Lcom/urbanairship/liveupdate/CustomLiveUpdateHandler;", "onUpdate", "Lcom/urbanairship/liveupdate/LiveUpdateResult;", "", "context", "Landroid/content/Context;", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Landroid/content/Context;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Lcom/urbanairship/liveupdate/LiveUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SuspendLiveUpdateCustomHandler extends CustomLiveUpdateHandler {
    @Nullable
    Object onUpdate(@NotNull Context context, @NotNull LiveUpdateEvent liveUpdateEvent, @NotNull LiveUpdate liveUpdate, @NotNull Continuation<? super LiveUpdateResult> continuation);
}
