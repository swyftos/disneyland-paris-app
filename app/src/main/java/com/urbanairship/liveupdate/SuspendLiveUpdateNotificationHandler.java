package com.urbanairship.liveupdate;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.facebook.react.animated.InterpolationAnimatedNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e*\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0004¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/liveupdate/SuspendLiveUpdateNotificationHandler;", "Lcom/urbanairship/liveupdate/NotificationLiveUpdateHandler;", "()V", "onUpdate", "Lcom/urbanairship/liveupdate/LiveUpdateResult;", "Landroidx/core/app/NotificationCompat$Builder;", "context", "Landroid/content/Context;", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Landroid/content/Context;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Lcom/urbanairship/liveupdate/LiveUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/liveupdate/LiveUpdateResult$Ok;", "callback", "Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class SuspendLiveUpdateNotificationHandler implements NotificationLiveUpdateHandler {
    @Nullable
    public abstract Object onUpdate(@NotNull Context context, @NotNull LiveUpdateEvent liveUpdateEvent, @NotNull LiveUpdate liveUpdate, @NotNull Continuation<? super LiveUpdateResult<? extends NotificationCompat.Builder>> continuation);

    @NotNull
    protected final LiveUpdateResult.C5412Ok<NotificationCompat.Builder> extend(@NotNull LiveUpdateResult.C5412Ok<NotificationCompat.Builder> c5412Ok, @NotNull LiveUpdateResult.NotificationExtender callback) {
        Intrinsics.checkNotNullParameter(c5412Ok, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        c5412Ok.setExtender$urbanairship_live_update_release(callback);
        return c5412Ok;
    }
}
