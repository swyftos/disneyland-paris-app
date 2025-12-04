package com.urbanairship.push.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.text.HtmlCompat;
import com.urbanairship.push.NotificationProxyActivity;
import com.urbanairship.push.NotificationProxyReceiver;
import com.urbanairship.push.PushManager;
import com.urbanairship.util.PendingIntentCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes5.dex */
public class NotificationActionButton {
    private final String description;
    private final Bundle extras;
    private final int iconId;
    private final String id;
    private final boolean isForegroundAction;
    private final String label;
    private final int labelId;
    private final List remoteInputs;

    private NotificationActionButton(Builder builder, Bundle bundle) {
        this.id = builder.buttonId;
        this.labelId = builder.labelId;
        this.label = builder.label;
        this.iconId = builder.iconId;
        this.description = builder.description;
        this.isForegroundAction = builder.isForegroundAction;
        this.remoteInputs = builder.remoteInputs;
        this.extras = bundle;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @Nullable
    public String getLabel(@NonNull Context context) {
        String str = this.label;
        if (str != null) {
            return str;
        }
        int i = this.labelId;
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }

    @DrawableRes
    public int getIcon() {
        return this.iconId;
    }

    public boolean isForegroundAction() {
        return this.isForegroundAction;
    }

    @NonNull
    public Bundle getExtras() {
        return new Bundle(this.extras);
    }

    @Nullable
    public List<LocalizableRemoteInput> getRemoteInputs() {
        if (this.remoteInputs == null) {
            return null;
        }
        return new ArrayList(this.remoteInputs);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NotificationCompat.Action createAndroidNotificationAction(@NonNull Context context, @Nullable String str, @NonNull NotificationArguments notificationArguments) {
        PendingIntent broadcast;
        String label = getLabel(context);
        if (label == null) {
            label = "";
        }
        String str2 = this.description;
        if (str2 == null) {
            str2 = label;
        }
        Intent intentPutExtra = new Intent(PushManager.ACTION_NOTIFICATION_RESPONSE).addCategory(UUID.randomUUID().toString()).putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, notificationArguments.getMessage().getPushBundle()).putExtra(PushManager.EXTRA_NOTIFICATION_ID, notificationArguments.getNotificationId()).putExtra(PushManager.EXTRA_NOTIFICATION_TAG, notificationArguments.getNotificationTag()).putExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_ID, this.id).putExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD, str).putExtra(PushManager.EXTRA_NOTIFICATION_BUTTON_FOREGROUND, this.isForegroundAction).putExtra(PushManager.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION, str2);
        int i = this.remoteInputs == null ? 0 : PendingIntentCompat.FLAG_MUTABLE;
        if (this.isForegroundAction) {
            intentPutExtra.setClass(context, NotificationProxyActivity.class);
            broadcast = PendingIntentCompat.getActivity(context, 0, intentPutExtra, i);
        } else {
            intentPutExtra.setClass(context, NotificationProxyReceiver.class);
            broadcast = PendingIntentCompat.getBroadcast(context, 0, intentPutExtra, i);
        }
        NotificationCompat.Action.Builder builderAddExtras = new NotificationCompat.Action.Builder(this.iconId, HtmlCompat.fromHtml(label, 0), broadcast).addExtras(this.extras);
        List list = this.remoteInputs;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                builderAddExtras.addRemoteInput(((LocalizableRemoteInput) it.next()).createRemoteInput(context));
            }
        }
        return builderAddExtras.build();
    }

    @NonNull
    public static Builder newBuilder(@NonNull String str) {
        return new Builder(str);
    }

    public static class Builder {
        private final String buttonId;
        private String description;
        private List extenders;
        private String label;
        private List remoteInputs;
        private int labelId = 0;
        private int iconId = 0;
        private boolean isForegroundAction = true;

        public Builder(@NonNull String str) {
            this.buttonId = str;
        }

        @NonNull
        public Builder setLabel(@StringRes int i) {
            this.labelId = i;
            this.label = null;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable String str) {
            this.labelId = 0;
            this.label = str;
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.description = str;
            return this;
        }

        @NonNull
        public Builder setIcon(@DrawableRes int i) {
            this.iconId = i;
            return this;
        }

        @NonNull
        public Builder setPerformsInForeground(boolean z) {
            this.isForegroundAction = z;
            return this;
        }

        @NonNull
        public Builder addRemoteInput(@NonNull LocalizableRemoteInput localizableRemoteInput) {
            if (this.remoteInputs == null) {
                this.remoteInputs = new ArrayList();
            }
            this.remoteInputs.add(localizableRemoteInput);
            return this;
        }

        @NonNull
        public Builder extend(@NonNull NotificationCompat.Action.Extender extender) {
            if (this.extenders == null) {
                this.extenders = new ArrayList();
            }
            this.extenders.add(extender);
            return this;
        }

        @NonNull
        public NotificationActionButton build() {
            Bundle bundle;
            if (this.extenders != null) {
                NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(this.iconId, (CharSequence) null, (PendingIntent) null);
                Iterator it = this.extenders.iterator();
                while (it.hasNext()) {
                    builder.extend((NotificationCompat.Action.Extender) it.next());
                }
                bundle = builder.build().getExtras();
            } else {
                bundle = new Bundle();
            }
            return new NotificationActionButton(this, bundle);
        }
    }
}
