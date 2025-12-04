package com.urbanairship.liveupdate;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler;", "Lcom/urbanairship/liveupdate/NotificationLiveUpdateHandler;", "onUpdate", "", "context", "Landroid/content/Context;", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "resultCallback", "Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler$LiveUpdateResultCallback;", "LiveUpdateResultCallback", "NotificationResult", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CallbackLiveUpdateNotificationHandler extends NotificationLiveUpdateHandler {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler$LiveUpdateResultCallback;", "", "cancel", "", "ok", "Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler$NotificationResult;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface LiveUpdateResultCallback {
        void cancel();

        @Nullable
        NotificationResult ok(@NotNull NotificationCompat.Builder builder);
    }

    void onUpdate(@NotNull Context context, @NotNull LiveUpdateEvent event, @NotNull LiveUpdate update, @NotNull LiveUpdateResultCallback resultCallback);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/liveupdate/CallbackLiveUpdateNotificationHandler$NotificationResult;", "", "notificationTag", "", "notificationId", "", TransferService.INTENT_KEY_NOTIFICATION, "Landroid/app/Notification;", "(Ljava/lang/String;ILandroid/app/Notification;)V", "getNotification", "()Landroid/app/Notification;", "getNotificationId", "()I", "getNotificationTag", "()Ljava/lang/String;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotificationResult {
        private final Notification notification;
        private final int notificationId;
        private final String notificationTag;

        public NotificationResult(@NotNull String notificationTag, int i, @NotNull Notification notification) {
            Intrinsics.checkNotNullParameter(notificationTag, "notificationTag");
            Intrinsics.checkNotNullParameter(notification, "notification");
            this.notificationTag = notificationTag;
            this.notificationId = i;
            this.notification = notification;
        }

        @NotNull
        public final String getNotificationTag() {
            return this.notificationTag;
        }

        public final int getNotificationId() {
            return this.notificationId;
        }

        @NotNull
        public final Notification getNotification() {
            return this.notification;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(NotificationResult.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.liveupdate.CallbackLiveUpdateNotificationHandler.NotificationResult");
            NotificationResult notificationResult = (NotificationResult) other;
            return Intrinsics.areEqual(this.notificationTag, notificationResult.notificationTag) && this.notificationId == notificationResult.notificationId && Intrinsics.areEqual(this.notification, notificationResult.notification);
        }

        public int hashCode() {
            return Objects.hash(this.notificationTag, Integer.valueOf(this.notificationId), this.notification);
        }
    }
}
