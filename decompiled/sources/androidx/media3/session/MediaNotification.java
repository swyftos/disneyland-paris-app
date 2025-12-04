package androidx.media3.session;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;

/* loaded from: classes.dex */
public final class MediaNotification {
    public final Notification notification;

    @IntRange(from = 1)
    public final int notificationId;

    @UnstableApi
    public interface ActionFactory {
        NotificationCompat.Action createCustomAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, String str, Bundle bundle);

        NotificationCompat.Action createCustomActionFromCustomCommandButton(MediaSession mediaSession, CommandButton commandButton);

        NotificationCompat.Action createMediaAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, int i);

        PendingIntent createMediaActionPendingIntent(MediaSession mediaSession, long j);
    }

    @UnstableApi
    public interface Provider {

        public interface Callback {
            void onNotificationChanged(MediaNotification mediaNotification);
        }

        MediaNotification createNotification(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, ActionFactory actionFactory, Callback callback);

        boolean handleCustomCommand(MediaSession mediaSession, String str, Bundle bundle);
    }

    public MediaNotification(@IntRange(from = 1) int i, Notification notification) {
        this.notificationId = i;
        this.notification = (Notification) Assertions.checkNotNull(notification);
    }
}
