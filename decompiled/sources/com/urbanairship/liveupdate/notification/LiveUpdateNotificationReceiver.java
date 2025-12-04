package com.urbanairship.liveupdate.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateNotificationReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver\n+ 2 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiverKt\n*L\n1#1,77:1\n70#2,7:78\n*S KotlinDebug\n*F\n+ 1 LiveUpdateNotificationReceiver.kt\ncom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver\n*L\n39#1:78,7\n*E\n"})
/* loaded from: classes5.dex */
public final class LiveUpdateNotificationReceiver extends BroadcastReceiver {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull android.content.Intent r11) throws android.app.PendingIntent.CanceledException {
        /*
            r9 = this;
            java.lang.String r9 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            java.lang.String r9 = "activity_name"
            java.lang.String r9 = r11.getStringExtra(r9)
            r10 = 0
            if (r9 != 0) goto L1b
            java.lang.String r9 = "Received Live Update notification broadcast without a name!"
            java.lang.Object[] r10 = new java.lang.Object[r10]
            com.urbanairship.UALog.e(r9, r10)
            return
        L1b:
            java.lang.String r0 = r11.getAction()
            if (r0 == 0) goto L99
            int r1 = r0.hashCode()
            r2 = -423302951(0xffffffffe6c4e8d9, float:-4.6493956E23)
            if (r1 == r2) goto L61
            r2 = 1335746081(0x4f9dde21, float:5.2971607E9)
            if (r1 == r2) goto L30
            goto L99
        L30:
            java.lang.String r1 = "com.urbanairship.liveupdate.NOTIFICATION_DISMISSED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
            goto L99
        L39:
            com.urbanairship.liveupdate.LiveUpdateManager$Companion r0 = com.urbanairship.liveupdate.LiveUpdateManager.INSTANCE
            com.urbanairship.liveupdate.LiveUpdateManager r0 = r0.shared()
            r6 = 14
            r7 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r1 = r9
            com.urbanairship.liveupdate.LiveUpdateManager.end$default(r0, r1, r2, r3, r5, r6, r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ended live updates for: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r10]
            com.urbanairship.UALog.v(r9, r0)
            goto Lb3
        L61:
            java.lang.String r1 = "com.urbanairship.liveupdate.NOTIFICATION_TIMEOUT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L6a
            goto L99
        L6a:
            com.urbanairship.liveupdate.LiveUpdateManager$Companion r8 = com.urbanairship.liveupdate.LiveUpdateManager.INSTANCE
            com.urbanairship.liveupdate.LiveUpdateManager r0 = r8.shared()
            r6 = 14
            r7 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r1 = r9
            com.urbanairship.liveupdate.LiveUpdateManager.end$default(r0, r1, r2, r3, r5, r6, r7)
            com.urbanairship.liveupdate.LiveUpdateManager r0 = r8.shared()
            r0.cancel$urbanairship_live_update_release(r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Timed out live updates for: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r10]
            com.urbanairship.UALog.v(r9, r0)
            goto Lb3
        L99:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Received unknown Live Update broadcast: "
            r9.append(r0)
            java.lang.String r0 = r11.getAction()
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r0 = new java.lang.Object[r10]
            com.urbanairship.UALog.w(r9, r0)
        Lb3:
            int r9 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            java.lang.String r1 = "com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT"
            if (r9 <= r0) goto Lc2
            java.lang.Class<android.app.PendingIntent> r9 = android.app.PendingIntent.class
            java.lang.Object r9 = com.urbanairship.liveupdate.notification.LiveUpdateNotificationReceiver$$ExternalSyntheticApiModelOutline0.m(r11, r1, r9)
            goto Lcd
        Lc2:
            android.os.Parcelable r9 = r11.getParcelableExtra(r1)
            boolean r11 = r9 instanceof android.app.PendingIntent
            if (r11 != 0) goto Lcb
            r9 = 0
        Lcb:
            android.app.PendingIntent r9 = (android.app.PendingIntent) r9
        Lcd:
            android.app.PendingIntent r9 = (android.app.PendingIntent) r9
            if (r9 == 0) goto Ldc
            r9.send()     // Catch: android.app.PendingIntent.CanceledException -> Ld5
            goto Ldc
        Ld5:
            java.lang.String r9 = "Failed to send notification's deleteIntent, already canceled."
            java.lang.Object[] r10 = new java.lang.Object[r10]
            com.urbanairship.UALog.d(r9, r10)
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.notification.LiveUpdateNotificationReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdateNotificationReceiver$Companion;", "", "()V", "ACTION_NOTIFICATION_DISMISSED", "", "ACTION_NOTIFICATION_TIMEOUT", "EXTRA_ACTIVITY_NAME", "deleteIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "name", "deleteIntent$urbanairship_live_update_release", "timeoutCompatIntent", "timeoutCompatIntent$urbanairship_live_update_release", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
