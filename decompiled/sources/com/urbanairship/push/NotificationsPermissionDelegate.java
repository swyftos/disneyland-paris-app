package com.urbanairship.push;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.SimpleActivityListener;
import com.urbanairship.permission.PermissionDelegate;
import com.urbanairship.permission.PermissionRequestResult;
import com.urbanairship.permission.PermissionStatus;
import com.urbanairship.permission.PermissionsActivity;
import com.urbanairship.push.AirshipNotificationManager;
import com.urbanairship.push.notifications.NotificationChannelRegistry;

/* loaded from: classes5.dex */
class NotificationsPermissionDelegate implements PermissionDelegate {
    private final ActivityMonitor activityMonitor;
    private final NotificationChannelRegistry channelRegistry;
    private final PreferenceDataStore dataStore;
    private final String defaultChannelId;
    private final AirshipNotificationManager notificationManager;
    private final PermissionRequestDelegate permissionRequestDelegate;

    interface PermissionRequestDelegate {
        void requestPermissions(Context context, String str, Consumer consumer);
    }

    NotificationsPermissionDelegate(String str, PreferenceDataStore preferenceDataStore, AirshipNotificationManager airshipNotificationManager, NotificationChannelRegistry notificationChannelRegistry, ActivityMonitor activityMonitor) {
        this(str, preferenceDataStore, airshipNotificationManager, notificationChannelRegistry, activityMonitor, new PermissionRequestDelegate() { // from class: com.urbanairship.push.NotificationsPermissionDelegate$$ExternalSyntheticLambda0
            @Override // com.urbanairship.push.NotificationsPermissionDelegate.PermissionRequestDelegate
            public final void requestPermissions(Context context, String str2, Consumer consumer) {
                PermissionsActivity.requestPermission(context, str2, consumer);
            }
        });
    }

    NotificationsPermissionDelegate(String str, PreferenceDataStore preferenceDataStore, AirshipNotificationManager airshipNotificationManager, NotificationChannelRegistry notificationChannelRegistry, ActivityMonitor activityMonitor, PermissionRequestDelegate permissionRequestDelegate) {
        this.defaultChannelId = str;
        this.dataStore = preferenceDataStore;
        this.notificationManager = airshipNotificationManager;
        this.channelRegistry = notificationChannelRegistry;
        this.activityMonitor = activityMonitor;
        this.permissionRequestDelegate = permissionRequestDelegate;
    }

    @Override // com.urbanairship.permission.PermissionDelegate
    public void checkPermissionStatus(Context context, Consumer consumer) {
        PermissionStatus permissionStatus;
        if (this.notificationManager.areNotificationsEnabled()) {
            permissionStatus = PermissionStatus.GRANTED;
        } else {
            int i = AnonymousClass2.$SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport[this.notificationManager.getPromptSupport().ordinal()];
            if ((i != 1 && i != 2) || this.dataStore.getBoolean("NotificationsPermissionDelegate.prompted", false)) {
                permissionStatus = PermissionStatus.DENIED;
            } else {
                permissionStatus = PermissionStatus.NOT_DETERMINED;
            }
        }
        consumer.accept(permissionStatus);
    }

    /* renamed from: com.urbanairship.push.NotificationsPermissionDelegate$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport;

        static {
            int[] iArr = new int[AirshipNotificationManager.PromptSupport.values().length];
            $SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport = iArr;
            try {
                iArr[AirshipNotificationManager.PromptSupport.COMPAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport[AirshipNotificationManager.PromptSupport.SUPPORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport[AirshipNotificationManager.PromptSupport.NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.urbanairship.permission.PermissionDelegate
    public void requestPermission(Context context, final Consumer consumer) {
        if (this.notificationManager.areNotificationsEnabled()) {
            consumer.accept(PermissionRequestResult.granted());
            return;
        }
        int i = AnonymousClass2.$SwitchMap$com$urbanairship$push$AirshipNotificationManager$PromptSupport[this.notificationManager.getPromptSupport().ordinal()];
        if (i == 1) {
            this.dataStore.put("NotificationsPermissionDelegate.prompted", true);
            if (!this.notificationManager.areChannelsCreated()) {
                this.channelRegistry.getNotificationChannel(this.defaultChannelId);
                this.activityMonitor.addActivityListener(new SimpleActivityListener() { // from class: com.urbanairship.push.NotificationsPermissionDelegate.1
                    @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        if (NotificationsPermissionDelegate.this.notificationManager.areNotificationsEnabled()) {
                            consumer.accept(PermissionRequestResult.granted());
                        } else {
                            consumer.accept(PermissionRequestResult.denied(false));
                        }
                        NotificationsPermissionDelegate.this.activityMonitor.removeActivityListener(this);
                    }
                });
                return;
            } else {
                consumer.accept(PermissionRequestResult.denied(true));
                return;
            }
        }
        if (i == 2) {
            this.dataStore.put("NotificationsPermissionDelegate.prompted", true);
            this.permissionRequestDelegate.requestPermissions(context, "android.permission.POST_NOTIFICATIONS", consumer);
        } else {
            if (i != 3) {
                return;
            }
            consumer.accept(PermissionRequestResult.denied(true));
        }
    }
}
