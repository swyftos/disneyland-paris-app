package com.urbanairship.android.framework.proxy;

import com.urbanairship.push.NotificationListener;
import com.urbanairship.push.PushMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR=\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R@\u0010\u0015\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginExtensions;", "", "()V", "forwardNotificationListener", "Lcom/urbanairship/push/NotificationListener;", "getForwardNotificationListener", "()Lcom/urbanairship/push/NotificationListener;", "setForwardNotificationListener", "(Lcom/urbanairship/push/NotificationListener;)V", "onDeepLink", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deepLink", "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride;", "", "getOnDeepLink", "()Lkotlin/jvm/functions/Function1;", "setOnDeepLink", "(Lkotlin/jvm/functions/Function1;)V", "onShouldDisplayForegroundNotification", "Lkotlin/Function2;", "Lcom/urbanairship/push/PushMessage;", "Lkotlin/coroutines/Continuation;", "", "getOnShouldDisplayForegroundNotification", "()Lkotlin/jvm/functions/Function2;", "setOnShouldDisplayForegroundNotification", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AirshipPluginExtensions {

    @NotNull
    public static final AirshipPluginExtensions INSTANCE = new AirshipPluginExtensions();
    private static NotificationListener forwardNotificationListener;
    private static Function1 onDeepLink;
    private static Function2 onShouldDisplayForegroundNotification;

    private AirshipPluginExtensions() {
    }

    @Nullable
    public final Function1<String, AirshipPluginOverride<Unit>> getOnDeepLink() {
        return onDeepLink;
    }

    public final void setOnDeepLink(@Nullable Function1<? super String, ? extends AirshipPluginOverride<Unit>> function1) {
        onDeepLink = function1;
    }

    @Nullable
    public final Function2<PushMessage, Continuation<? super AirshipPluginOverride<Boolean>>, Object> getOnShouldDisplayForegroundNotification() {
        return onShouldDisplayForegroundNotification;
    }

    public final void setOnShouldDisplayForegroundNotification(@Nullable Function2<? super PushMessage, ? super Continuation<? super AirshipPluginOverride<Boolean>>, ? extends Object> function2) {
        onShouldDisplayForegroundNotification = function2;
    }

    @Nullable
    public final NotificationListener getForwardNotificationListener() {
        return forwardNotificationListener;
    }

    public final void setForwardNotificationListener(@Nullable NotificationListener notificationListener) {
        forwardNotificationListener = notificationListener;
    }
}
