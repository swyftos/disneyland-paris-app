package com.urbanairship.liveupdate.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.urbanairship.UALog;
import com.urbanairship.liveupdate.LiveUpdateManager;
import com.urbanairship.push.PushManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateNotificationReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver\n+ 2 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiverKt\n*L\n1#1,77:1\n70#2,7:78\n*S KotlinDebug\n*F\n+ 1 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver\n*L\n39#1:78,7\n*E\n"})
public final class LiveUpdateNotificationReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Code duplicated, block: B:21:0x0099  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0099, please report this as an issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Object parcelableExtra;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("activity_name");
        if (stringExtra == null) {
            UALog.m1744e("Received Live Update notification broadcast without a name!", new Object[0]);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            UALog.m1754w("Received unknown Live Update broadcast: " + intent.getAction(), new Object[0]);
        } else {
            int iHashCode = action.hashCode();
            if (iHashCode != -423302951) {
                if (iHashCode == 1335746081 && action.equals("com.urbanairship.liveupdate.NOTIFICATION_DISMISSED")) {
                    LiveUpdateManager.end$default(LiveUpdateManager.INSTANCE.shared(), stringExtra, null, 0L, null, 14, null);
                    UALog.m1751v("Ended live updates for: " + stringExtra, new Object[0]);
                } else {
                    UALog.m1754w("Received unknown Live Update broadcast: " + intent.getAction(), new Object[0]);
                }
            } else if (action.equals("com.urbanairship.liveupdate.NOTIFICATION_TIMEOUT")) {
                LiveUpdateManager.Companion companion = LiveUpdateManager.INSTANCE;
                LiveUpdateManager.end$default(companion.shared(), stringExtra, null, 0L, null, 14, null);
                companion.shared().cancel$urbanairship_live_update_release(stringExtra);
                UALog.m1751v("Timed out live updates for: " + stringExtra, new Object[0]);
            } else {
                UALog.m1754w("Received unknown Live Update broadcast: " + intent.getAction(), new Object[0]);
            }
        }
        if (Build.VERSION.SDK_INT > 33) {
            parcelableExtra = intent.getParcelableExtra(PushManager.EXTRA_NOTIFICATION_DELETE_INTENT, PendingIntent.class);
        } else {
            Object parcelableExtra2 = intent.getParcelableExtra(PushManager.EXTRA_NOTIFICATION_DELETE_INTENT);
            if (!(parcelableExtra2 instanceof PendingIntent)) {
                parcelableExtra2 = null;
            }
            parcelableExtra = (PendingIntent) parcelableExtra2;
        }
        PendingIntent pendingIntent = (PendingIntent) parcelableExtra;
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                UALog.m1741d("Failed to send notification's deleteIntent, already canceled.", new Object[0]);
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver$Companion;", "", "()V", "ACTION_NOTIFICATION_DISMISSED", "", "ACTION_NOTIFICATION_TIMEOUT", "EXTRA_ACTIVITY_NAME", "deleteIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "name", "deleteIntent$urbanairship_live_update_release", "timeoutCompatIntent", "timeoutCompatIntent$urbanairship_live_update_release", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Intent deleteIntent$urbanairship_live_update_release(@NotNull Context context, @NotNull String name) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intent intentAddCategory = new Intent(context, (Class<?>) LiveUpdateNotificationReceiver.class).setAction("com.urbanairship.liveupdate.NOTIFICATION_DISMISSED").putExtra("activity_name", name).addCategory(name);
            Intrinsics.checkNotNullExpressionValue(intentAddCategory, "addCategory(...)");
            return intentAddCategory;
        }

        @NotNull
        public final Intent timeoutCompatIntent$urbanairship_live_update_release(@NotNull Context context, @NotNull String name) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intent intentAddCategory = new Intent(context, (Class<?>) LiveUpdateNotificationReceiver.class).setAction("com.urbanairship.liveupdate.NOTIFICATION_TIMEOUT").putExtra("activity_name", name).addCategory(name);
            Intrinsics.checkNotNullExpressionValue(intentAddCategory, "addCategory(...)");
            return intentAddCategory;
        }
    }
}
