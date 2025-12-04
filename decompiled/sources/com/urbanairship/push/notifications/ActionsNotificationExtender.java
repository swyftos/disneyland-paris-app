package com.urbanairship.push.notifications;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.urbanairship.UAirship;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class ActionsNotificationExtender implements NotificationCompat.Extender {
    private final NotificationArguments arguments;
    private final Context context;

    public ActionsNotificationExtender(@NonNull Context context, @NonNull NotificationArguments notificationArguments) {
        this.context = context.getApplicationContext();
        this.arguments = notificationArguments;
    }

    @Override // androidx.core.app.NotificationCompat.Extender
    @NonNull
    public NotificationCompat.Builder extend(@NonNull NotificationCompat.Builder builder) {
        NotificationActionButtonGroup notificationActionGroup = UAirship.shared().getPushManager().getNotificationActionGroup(this.arguments.getMessage().getInteractiveNotificationType());
        if (notificationActionGroup == null) {
            return builder;
        }
        Context context = this.context;
        NotificationArguments notificationArguments = this.arguments;
        Iterator it = notificationActionGroup.createAndroidActions(context, notificationArguments, notificationArguments.getMessage().getInteractiveActionsPayload()).iterator();
        while (it.hasNext()) {
            builder.addAction((NotificationCompat.Action) it.next());
        }
        return builder;
    }
}
