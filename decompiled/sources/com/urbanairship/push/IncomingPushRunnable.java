package com.urbanairship.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.urbanairship.Autopilot;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.analytics.PushArrivedEvent;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.notifications.NotificationArguments;
import com.urbanairship.push.notifications.NotificationChannelCompat;
import com.urbanairship.push.notifications.NotificationProvider;
import com.urbanairship.push.notifications.NotificationResult;
import com.urbanairship.util.Checks;
import com.urbanairship.util.PendingIntentCompat;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes5.dex */
class IncomingPushRunnable implements Runnable {
    private final ActivityMonitor activityMonitor;
    private final Context context;
    private final boolean isLongRunning;
    private final boolean isProcessed;
    private final JobDispatcher jobDispatcher;
    private final PushMessage message;
    private final NotificationManagerCompat notificationManager;
    private final String providerClass;

    private IncomingPushRunnable(Builder builder) {
        Context context = builder.context;
        this.context = context;
        this.message = builder.message;
        this.providerClass = builder.providerClass;
        this.isLongRunning = builder.isLongRunning;
        this.isProcessed = builder.isProcessed;
        this.notificationManager = builder.notificationManager == null ? NotificationManagerCompat.from(context) : builder.notificationManager;
        this.jobDispatcher = builder.jobDispatcher == null ? JobDispatcher.shared(context) : builder.jobDispatcher;
        this.activityMonitor = builder.activityMonitor == null ? GlobalActivityMonitor.shared(context) : builder.activityMonitor;
    }

    @Override // java.lang.Runnable
    public void run() {
        Autopilot.automaticTakeOff(this.context);
        UAirship uAirshipWaitForTakeOff = UAirship.waitForTakeOff(this.isLongRunning ? 10000L : 5000L);
        if (uAirshipWaitForTakeOff == null) {
            UALog.e("Unable to process push, Airship is not ready. Make sure takeOff is called by either using autopilot or by calling takeOff in the application's onCreate method.", new Object[0]);
            return;
        }
        if (!this.message.isAccengagePush() && !this.message.isAirshipPush()) {
            UALog.d("Ignoring push: %s", this.message);
        } else if (checkProvider(uAirshipWaitForTakeOff, this.providerClass)) {
            if (this.isProcessed) {
                postProcessPush(uAirshipWaitForTakeOff);
            } else {
                processPush(uAirshipWaitForTakeOff);
            }
        }
    }

    private void processPush(UAirship uAirship) {
        UALog.i("Processing push: %s", this.message);
        if (!uAirship.getPushManager().isPushEnabled()) {
            UALog.d("Push disabled, ignoring message", new Object[0]);
            return;
        }
        if (!uAirship.getPushManager().isUniqueCanonicalId(this.message.getCanonicalPushId())) {
            UALog.d("Received a duplicate push with canonical ID: %s", this.message.getCanonicalPushId());
            return;
        }
        if (this.message.isExpired()) {
            UALog.d("Received expired push message, ignoring.", new Object[0]);
            return;
        }
        if (this.message.isPing() || this.message.isRemoteDataUpdate()) {
            UALog.v("Received internal push.", new Object[0]);
            uAirship.getAnalytics().addEvent(new PushArrivedEvent(this.message));
            uAirship.getPushManager().onPushReceived(this.message, false);
        } else {
            runActions();
            uAirship.getPushManager().setLastReceivedMetadata(this.message.getMetadata());
            postProcessPush(uAirship);
        }
    }

    private void postProcessPush(UAirship uAirship) {
        NotificationResult notificationResultCancel;
        if (!uAirship.getPushManager().isOptIn()) {
            UALog.i("User notifications opted out. Unable to display notification for message: %s", this.message);
            postProcessPushFinished(uAirship, this.message, false);
            return;
        }
        if (this.activityMonitor.getIsAppForegrounded()) {
            if (!this.message.isForegroundDisplayable()) {
                UALog.i("Push message flagged as not able to be displayed in the foreground: %s", this.message);
                postProcessPushFinished(uAirship, this.message, false);
                return;
            }
            Predicate<PushMessage> foregroundNotificationDisplayPredicate = uAirship.getPushManager().getForegroundNotificationDisplayPredicate();
            if (foregroundNotificationDisplayPredicate != null && !foregroundNotificationDisplayPredicate.apply(this.message)) {
                UALog.i("Foreground notification display predicate prevented the display of message: %s", this.message);
                postProcessPushFinished(uAirship, this.message, false);
                return;
            }
        }
        NotificationProvider notificationProvider = getNotificationProvider(uAirship);
        if (notificationProvider == null) {
            UALog.e("NotificationProvider is null. Unable to display notification for message: %s", this.message);
            postProcessPushFinished(uAirship, this.message, false);
            return;
        }
        try {
            NotificationArguments notificationArgumentsOnCreateNotificationArguments = notificationProvider.onCreateNotificationArguments(this.context, this.message);
            if (!this.isLongRunning && notificationArgumentsOnCreateNotificationArguments.getRequiresLongRunningTask()) {
                UALog.d("Push requires a long running task. Scheduled for a later time: %s", this.message);
                reschedulePush(this.message);
                return;
            }
            try {
                notificationResultCancel = notificationProvider.onCreateNotification(this.context, notificationArgumentsOnCreateNotificationArguments);
            } catch (Exception e) {
                UALog.e(e, "Cancelling notification display to create and display notification.", new Object[0]);
                notificationResultCancel = NotificationResult.cancel();
            }
            UALog.d("Received result status %s for push message: %s", Integer.valueOf(notificationResultCancel.getStatus()), this.message);
            int status = notificationResultCancel.getStatus();
            if (status != 0) {
                if (status == 1) {
                    UALog.d("Scheduling notification to be retried for a later time: %s", this.message);
                    reschedulePush(this.message);
                    return;
                } else {
                    if (status != 2) {
                        return;
                    }
                    postProcessPushFinished(uAirship, this.message, false);
                    return;
                }
            }
            Notification notification = notificationResultCancel.getNotification();
            Checks.checkNotNull(notification, "Invalid notification result. Missing notification.");
            if (getNotificationChannel(uAirship, notification, notificationArgumentsOnCreateNotificationArguments) == null) {
                UALog.e("Missing required notification channel. Notification will most likely not display.", new Object[0]);
            }
            notificationProvider.onNotificationCreated(this.context, notification, notificationArgumentsOnCreateNotificationArguments);
            boolean zPostNotification = postNotification(notification, notificationArgumentsOnCreateNotificationArguments);
            postProcessPushFinished(uAirship, this.message, zPostNotification);
            if (zPostNotification) {
                uAirship.getPushManager().onNotificationPosted(this.message, notificationArgumentsOnCreateNotificationArguments.getNotificationId(), notificationArgumentsOnCreateNotificationArguments.getNotificationTag());
            }
        } catch (Exception e2) {
            UALog.e(e2, "Failed to generate notification arguments for message. Skipping.", new Object[0]);
            postProcessPushFinished(uAirship, this.message, false);
        }
    }

    private void postProcessPushFinished(UAirship uAirship, PushMessage pushMessage, boolean z) {
        uAirship.getAnalytics().addEvent(new PushArrivedEvent(pushMessage));
        uAirship.getPushManager().onPushReceived(pushMessage, z);
    }

    private NotificationProvider getNotificationProvider(UAirship uAirship) {
        if (this.message.isAirshipPush()) {
            return uAirship.getPushManager().getNotificationProvider();
        }
        return null;
    }

    private NotificationChannelCompat getNotificationChannel(UAirship uAirship, Notification notification, NotificationArguments notificationArguments) {
        String channelId = NotificationCompat.getChannelId(notification);
        if (channelId != null) {
            return uAirship.getPushManager().getNotificationChannelRegistry().getNotificationChannelSync(channelId);
        }
        return null;
    }

    private boolean postNotification(Notification notification, NotificationArguments notificationArguments) {
        String notificationTag = notificationArguments.getNotificationTag();
        int notificationId = notificationArguments.getNotificationId();
        Intent intentPutExtra = new Intent(this.context, (Class<?>) NotificationProxyActivity.class).setAction(PushManager.ACTION_NOTIFICATION_RESPONSE).addCategory(UUID.randomUUID().toString()).putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, notificationArguments.getMessage().getPushBundle()).addFlags(268435456).putExtra(PushManager.EXTRA_NOTIFICATION_ID, notificationArguments.getNotificationId()).putExtra(PushManager.EXTRA_NOTIFICATION_TAG, notificationArguments.getNotificationTag());
        PendingIntent pendingIntent = notification.contentIntent;
        if (pendingIntent != null) {
            intentPutExtra.putExtra(PushManager.EXTRA_NOTIFICATION_CONTENT_INTENT, pendingIntent);
        }
        Intent intentPutExtra2 = new Intent(this.context, (Class<?>) NotificationProxyReceiver.class).setAction(PushManager.ACTION_NOTIFICATION_DISMISSED).addCategory(UUID.randomUUID().toString()).putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, notificationArguments.getMessage().getPushBundle()).putExtra(PushManager.EXTRA_NOTIFICATION_ID, notificationArguments.getNotificationId()).putExtra(PushManager.EXTRA_NOTIFICATION_TAG, notificationArguments.getNotificationTag());
        PendingIntent pendingIntent2 = notification.deleteIntent;
        if (pendingIntent2 != null) {
            intentPutExtra2.putExtra(PushManager.EXTRA_NOTIFICATION_DELETE_INTENT, pendingIntent2);
        }
        notification.contentIntent = PendingIntentCompat.getActivity(this.context, 0, intentPutExtra, 0);
        notification.deleteIntent = PendingIntentCompat.getBroadcast(this.context, 0, intentPutExtra2, 0);
        UALog.i("Posting notification: %s id: %s tag: %s", notification, Integer.valueOf(notificationId), notificationTag);
        try {
            this.notificationManager.notify(notificationTag, notificationId, notification);
            return true;
        } catch (Exception e) {
            UALog.e(e, "Failed to post notification.", new Object[0]);
            return false;
        }
    }

    private void runActions() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ActionArguments.PUSH_MESSAGE_METADATA, this.message);
        for (Map.Entry<String, ActionValue> entry : this.message.getActions().entrySet()) {
            ActionRunRequest.createRequest(entry.getKey()).setMetadata(bundle).setValue(entry.getValue()).setSituation(1).run();
        }
    }

    private boolean checkProvider(UAirship uAirship, String str) {
        PushProvider pushProvider = uAirship.getPushManager().getPushProvider();
        if (pushProvider == null || !pushProvider.getClass().toString().equals(str)) {
            UALog.e("Received message callback from unexpected provider %s. Ignoring.", str);
            return false;
        }
        if (!pushProvider.isAvailable(this.context)) {
            UALog.e("Received message callback when provider is unavailable. Ignoring.", new Object[0]);
            return false;
        }
        if (uAirship.getPushManager().isPushAvailable() && uAirship.getPushManager().isPushEnabled()) {
            return true;
        }
        UALog.e("Received message when push is disabled. Ignoring.", new Object[0]);
        return false;
    }

    private void reschedulePush(PushMessage pushMessage) {
        this.jobDispatcher.dispatch(JobInfo.newBuilder().setAction(PushManager.ACTION_DISPLAY_NOTIFICATION).setConflictStrategy(1).setAirshipComponent(PushManager.class).setExtras(JsonMap.newBuilder().putOpt("EXTRA_PUSH", pushMessage).put("EXTRA_PROVIDER_CLASS", this.providerClass).build()).build());
    }

    static class Builder {
        private ActivityMonitor activityMonitor;
        private final Context context;
        private boolean isLongRunning;
        private boolean isProcessed;
        private JobDispatcher jobDispatcher;
        private PushMessage message;
        private NotificationManagerCompat notificationManager;
        private String providerClass;

        Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        Builder setMessage(PushMessage pushMessage) {
            this.message = pushMessage;
            return this;
        }

        Builder setProviderClass(String str) {
            this.providerClass = str;
            return this;
        }

        Builder setLongRunning(boolean z) {
            this.isLongRunning = z;
            return this;
        }

        Builder setProcessed(boolean z) {
            this.isProcessed = z;
            return this;
        }

        IncomingPushRunnable build() {
            Checks.checkNotNull(this.providerClass, "Provider class missing");
            Checks.checkNotNull(this.message, "Push Message missing");
            return new IncomingPushRunnable(this);
        }
    }
}
