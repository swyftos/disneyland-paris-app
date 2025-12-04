package androidx.media3.session;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaNotification;

/* loaded from: classes.dex */
final class DefaultActionFactory implements MediaNotification.ActionFactory {
    private int customActionPendingIntentRequestCode = 0;
    private final Service service;

    private int toKeyCode(long j) {
        if (j == 8 || j == 9) {
            return 87;
        }
        if (j == 6 || j == 7) {
            return 88;
        }
        if (j == 3) {
            return 86;
        }
        if (j == 12) {
            return 90;
        }
        if (j == 11) {
            return 89;
        }
        return j == 1 ? 85 : 0;
    }

    public static KeyEvent getKeyEvent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        return (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
    }

    public DefaultActionFactory(Service service) {
        this.service = service;
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createMediaAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, int i) {
        return new NotificationCompat.Action(iconCompat, charSequence, createMediaActionPendingIntent(mediaSession, i));
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createCustomAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, String str, Bundle bundle) {
        return new NotificationCompat.Action(iconCompat, charSequence, createCustomActionPendingIntent(mediaSession, str, bundle));
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createCustomActionFromCustomCommandButton(MediaSession mediaSession, CommandButton commandButton) {
        SessionCommand sessionCommand = commandButton.sessionCommand;
        Assertions.checkArgument(sessionCommand != null && sessionCommand.commandCode == 0);
        SessionCommand sessionCommand2 = (SessionCommand) Assertions.checkNotNull(commandButton.sessionCommand);
        return new NotificationCompat.Action(IconCompat.createWithResource(this.service, commandButton.iconResId), commandButton.displayName, createCustomActionPendingIntent(mediaSession, sessionCommand2.customAction, sessionCommand2.customExtras));
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public PendingIntent createMediaActionPendingIntent(MediaSession mediaSession, long j) {
        int keyCode = toKeyCode(j);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(mediaSession.getImpl().getUri());
        Service service = this.service;
        intent.setComponent(new ComponentName(service, service.getClass()));
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, keyCode));
        int i = Util.SDK_INT;
        if (i < 26 || j != 1 || mediaSession.getPlayer().getPlayWhenReady()) {
            return PendingIntent.getService(this.service, keyCode, intent, i >= 23 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0);
        }
        return Api26.createForegroundServicePendingIntent(this.service, keyCode, intent);
    }

    private PendingIntent createCustomActionPendingIntent(MediaSession mediaSession, String str, Bundle bundle) {
        Intent intent = new Intent("androidx.media3.session.CUSTOM_NOTIFICATION_ACTION");
        intent.setData(mediaSession.getImpl().getUri());
        Service service = this.service;
        intent.setComponent(new ComponentName(service, service.getClass()));
        intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION", str);
        intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS", bundle);
        Service service2 = this.service;
        int i = this.customActionPendingIntentRequestCode + 1;
        this.customActionPendingIntentRequestCode = i;
        return PendingIntent.getService(service2, i, intent, (Util.SDK_INT >= 23 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0) | C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    public boolean isMediaAction(Intent intent) {
        return "android.intent.action.MEDIA_BUTTON".equals(intent.getAction());
    }

    public boolean isCustomAction(Intent intent) {
        return "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent.getAction());
    }

    public String getCustomAction(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Bundle getCustomActionExtras(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS") : null;
        return obj instanceof Bundle ? (Bundle) obj : Bundle.EMPTY;
    }

    private static final class Api26 {
        public static PendingIntent createForegroundServicePendingIntent(Service service, int i, Intent intent) {
            return PendingIntent.getForegroundService(service, i, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        }
    }
}
