package com.urbanairship.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.PendingResult;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.analytics.InteractiveNotificationEvent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
class NotificationIntentProcessor {
    private final NotificationActionButtonInfo actionButtonInfo;
    private final UAirship airship;
    private final Context context;
    private final Executor executor;
    private final Intent intent;
    private final NotificationInfo notificationInfo;

    NotificationIntentProcessor(Context context, Intent intent) {
        this(UAirship.shared(), context, intent, AirshipExecutors.threadPoolExecutor());
    }

    NotificationIntentProcessor(UAirship uAirship, Context context, Intent intent, Executor executor) {
        this.airship = uAirship;
        this.executor = executor;
        this.intent = intent;
        this.context = context;
        this.notificationInfo = NotificationInfo.fromIntent(intent);
        this.actionButtonInfo = NotificationActionButtonInfo.fromIntent(intent);
    }

    PendingResult process() {
        final PendingResult pendingResult = new PendingResult();
        if (this.intent.getAction() == null || this.notificationInfo == null) {
            UALog.e("NotificationIntentProcessor - invalid intent %s", this.intent);
            pendingResult.setResult(Boolean.FALSE);
            return pendingResult;
        }
        UALog.v("Processing intent: %s", this.intent.getAction());
        String action = this.intent.getAction();
        action.hashCode();
        if (action.equals(PushManager.ACTION_NOTIFICATION_DISMISSED)) {
            onNotificationDismissed();
            pendingResult.setResult(Boolean.TRUE);
        } else if (action.equals(PushManager.ACTION_NOTIFICATION_RESPONSE)) {
            onNotificationResponse(new Runnable() { // from class: com.urbanairship.push.NotificationIntentProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    pendingResult.setResult(Boolean.TRUE);
                }
            });
        } else {
            UALog.e("NotificationIntentProcessor - Invalid intent action: %s", this.intent.getAction());
            pendingResult.setResult(Boolean.FALSE);
        }
        return pendingResult;
    }

    private void onNotificationResponse(Runnable runnable) throws PendingIntent.CanceledException {
        UALog.i("Notification response: %s, %s", this.notificationInfo, this.actionButtonInfo);
        NotificationActionButtonInfo notificationActionButtonInfo = this.actionButtonInfo;
        if (notificationActionButtonInfo == null || notificationActionButtonInfo.isForeground()) {
            this.airship.getAnalytics().setConversionSendId(this.notificationInfo.getMessage().getSendId());
            this.airship.getAnalytics().setConversionMetadata(this.notificationInfo.getMessage().getMetadata());
        }
        NotificationListener notificationListener = this.airship.getPushManager().getNotificationListener();
        NotificationActionButtonInfo notificationActionButtonInfo2 = this.actionButtonInfo;
        if (notificationActionButtonInfo2 != null) {
            this.airship.getAnalytics().addEvent(new InteractiveNotificationEvent(this.notificationInfo, notificationActionButtonInfo2));
            NotificationManagerCompat.from(this.context).cancel(this.notificationInfo.getNotificationTag(), this.notificationInfo.getNotificationId());
            if (this.actionButtonInfo.isForeground()) {
                if (notificationListener == null || !notificationListener.onNotificationForegroundAction(this.notificationInfo, this.actionButtonInfo)) {
                    launchApplication();
                }
            } else if (notificationListener != null) {
                notificationListener.onNotificationBackgroundAction(this.notificationInfo, this.actionButtonInfo);
            }
        } else if (notificationListener == null || !notificationListener.onNotificationOpened(this.notificationInfo)) {
            launchApplication();
        }
        Iterator<InternalNotificationListener> it = this.airship.getPushManager().getInternalNotificationListeners().iterator();
        while (it.hasNext()) {
            it.next().onNotificationResponse(this.notificationInfo, this.actionButtonInfo);
        }
        runNotificationResponseActions(runnable);
    }

    private void onNotificationDismissed() throws PendingIntent.CanceledException {
        PendingIntent pendingIntent;
        UALog.i("Notification dismissed: %s", this.notificationInfo);
        if (this.intent.getExtras() != null && (pendingIntent = (PendingIntent) this.intent.getExtras().get(PushManager.EXTRA_NOTIFICATION_DELETE_INTENT)) != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                UALog.d("Failed to send notification's deleteIntent, already canceled.", new Object[0]);
            }
        }
        NotificationListener notificationListener = this.airship.getPushManager().getNotificationListener();
        if (notificationListener != null) {
            notificationListener.onNotificationDismissed(this.notificationInfo);
        }
    }

    private void launchApplication() throws PendingIntent.CanceledException {
        PendingIntent pendingIntent;
        if (this.intent.getExtras() != null && (pendingIntent = (PendingIntent) this.intent.getExtras().get(PushManager.EXTRA_NOTIFICATION_CONTENT_INTENT)) != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                UALog.d("Failed to send notification's contentIntent, already canceled.", new Object[0]);
            }
        } else if (this.airship.getAirshipConfigOptions().autoLaunchApplication) {
            Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(UAirship.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(805306368);
                launchIntentForPackage.putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, this.notificationInfo.getMessage().getPushBundle());
                launchIntentForPackage.setPackage(null);
                UALog.i("Starting application's launch intent.", new Object[0]);
                this.context.startActivity(launchIntentForPackage);
                return;
            }
            UALog.i("Unable to launch application. Launch intent is unavailable.", new Object[0]);
        }
    }

    private void runNotificationResponseActions(Runnable runnable) {
        Map<String, ActionValue> actions;
        int i;
        Bundle bundle = new Bundle();
        bundle.putParcelable(ActionArguments.PUSH_MESSAGE_METADATA, this.notificationInfo.getMessage());
        if (this.actionButtonInfo != null) {
            String stringExtra = this.intent.getStringExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD);
            if (UAStringUtil.isEmpty(stringExtra)) {
                actions = null;
                i = 0;
            } else {
                actions = parseActionValues(stringExtra);
                if (this.actionButtonInfo.getRemoteInput() != null) {
                    bundle.putBundle(ActionArguments.REMOTE_INPUT_METADATA, this.actionButtonInfo.getRemoteInput());
                }
                i = this.actionButtonInfo.isForeground() ? 4 : 5;
            }
        } else {
            actions = this.notificationInfo.getMessage().getActions();
            i = 2;
        }
        if (actions == null || actions.isEmpty()) {
            runnable.run();
        } else {
            runActions(actions, i, bundle, runnable);
        }
    }

    private void runActions(final Map map, final int i, final Bundle bundle, final Runnable runnable) {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.push.NotificationIntentProcessor.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                final CountDownLatch countDownLatch = new CountDownLatch(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    ActionRunRequest.createRequest((String) entry.getKey()).setMetadata(bundle).setSituation(i).setValue((ActionValue) entry.getValue()).run(new ActionCompletionCallback() { // from class: com.urbanairship.push.NotificationIntentProcessor.2.1
                        @Override // com.urbanairship.actions.ActionCompletionCallback
                        public void onFinish(ActionArguments actionArguments, ActionResult actionResult) {
                            countDownLatch.countDown();
                        }
                    });
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    UALog.e(e, "Failed to wait for actions", new Object[0]);
                    Thread.currentThread().interrupt();
                }
                runnable.run();
            }
        });
    }

    private Map parseActionValues(String str) {
        HashMap map = new HashMap();
        try {
            JsonMap map2 = JsonValue.parseString(str).getMap();
            if (map2 != null) {
                Iterator<Map.Entry<String, JsonValue>> it = map2.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, JsonValue> next = it.next();
                    map.put(next.getKey(), new ActionValue(next.getValue()));
                }
            }
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse actions for push.", new Object[0]);
        }
        return map;
    }
}
