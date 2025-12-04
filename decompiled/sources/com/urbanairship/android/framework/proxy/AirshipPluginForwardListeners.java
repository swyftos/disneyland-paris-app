package com.urbanairship.android.framework.proxy;

import com.urbanairship.actions.DeepLinkListener;
import com.urbanairship.push.NotificationListener;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message = "Use AirshipPluginExtensions instead.")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginForwardListeners;", "", "()V", "deepLinkListener", "Lcom/urbanairship/actions/DeepLinkListener;", "getDeepLinkListener", "()Lcom/urbanairship/actions/DeepLinkListener;", "setDeepLinkListener", "(Lcom/urbanairship/actions/DeepLinkListener;)V", "notificationListener", "Lcom/urbanairship/push/NotificationListener;", "getNotificationListener", "()Lcom/urbanairship/push/NotificationListener;", "setNotificationListener", "(Lcom/urbanairship/push/NotificationListener;)V", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AirshipPluginForwardListeners {

    @NotNull
    public static final AirshipPluginForwardListeners INSTANCE = new AirshipPluginForwardListeners();
    private static DeepLinkListener deepLinkListener;
    private static NotificationListener notificationListener;

    private AirshipPluginForwardListeners() {
    }

    @Nullable
    public final DeepLinkListener getDeepLinkListener() {
        return deepLinkListener;
    }

    public final void setDeepLinkListener(@Nullable DeepLinkListener deepLinkListener2) {
        deepLinkListener = deepLinkListener2;
    }

    @Nullable
    public final NotificationListener getNotificationListener() {
        return notificationListener;
    }

    public final void setNotificationListener(@Nullable NotificationListener notificationListener2) {
        notificationListener = notificationListener2;
    }
}
