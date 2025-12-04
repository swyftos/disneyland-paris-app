package com.urbanairship.android.framework.proxy;

import android.content.Context;
import ch.qos.logback.core.joran.action.Action;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UAirship;
import com.urbanairship.actions.DeepLinkListener;
import com.urbanairship.android.framework.proxy.AirshipPluginOverride;
import com.urbanairship.android.framework.proxy.events.ChannelCreatedEvent;
import com.urbanairship.android.framework.proxy.events.DeepLinkEvent;
import com.urbanairship.android.framework.proxy.events.DisplayMessageCenterEvent;
import com.urbanairship.android.framework.proxy.events.DisplayPreferenceCenterEvent;
import com.urbanairship.android.framework.proxy.events.EventEmitter;
import com.urbanairship.android.framework.proxy.events.MessageCenterUpdatedEvent;
import com.urbanairship.android.framework.proxy.events.NotificationResponseEvent;
import com.urbanairship.android.framework.proxy.events.PushReceivedEvent;
import com.urbanairship.android.framework.proxy.events.PushTokenReceivedEvent;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.channel.AirshipChannelListener;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.InboxListener;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.push.NotificationActionButtonInfo;
import com.urbanairship.push.NotificationInfo;
import com.urbanairship.push.NotificationListener;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.PushTokenListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b+\u0010\"J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u0010\u001eJ\u000f\u00100\u001a\u00020\u0019H\u0016¢\u0006\u0004\b0\u00101R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00102R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010<\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\f\u0012\u0004\b;\u00101\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipListener;", "Lcom/urbanairship/messagecenter/MessageCenter$OnShowMessageCenterListener;", "Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "Lcom/urbanairship/push/PushListener;", "Lcom/urbanairship/push/PushTokenListener;", "Lcom/urbanairship/push/NotificationListener;", "Lcom/urbanairship/actions/DeepLinkListener;", "Lcom/urbanairship/channel/AirshipChannelListener;", "Lcom/urbanairship/messagecenter/InboxListener;", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "proxyStore", "Lcom/urbanairship/android/framework/proxy/events/EventEmitter;", "eventEmitter", "<init>", "(Lcom/urbanairship/android/framework/proxy/ProxyStore;Lcom/urbanairship/android/framework/proxy/events/EventEmitter;)V", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "onShowMessageCenter", "(Ljava/lang/String;)Z", "preferenceCenterId", "onOpenPreferenceCenter", "Lcom/urbanairship/push/PushMessage;", "message", "notificationPosted", "", "onPushReceived", "(Lcom/urbanairship/push/PushMessage;Z)V", "token", "onPushTokenUpdated", "(Ljava/lang/String;)V", "Lcom/urbanairship/push/NotificationInfo;", "notificationInfo", "onNotificationPosted", "(Lcom/urbanairship/push/NotificationInfo;)V", "onNotificationOpened", "(Lcom/urbanairship/push/NotificationInfo;)Z", "Lcom/urbanairship/push/NotificationActionButtonInfo;", "notificationActionButtonInfo", "onNotificationForegroundAction", "(Lcom/urbanairship/push/NotificationInfo;Lcom/urbanairship/push/NotificationActionButtonInfo;)Z", "onNotificationBackgroundAction", "(Lcom/urbanairship/push/NotificationInfo;Lcom/urbanairship/push/NotificationActionButtonInfo;)V", "onNotificationDismissed", "deepLink", "onDeepLink", "channelId", "onChannelCreated", "onInboxUpdated", "()V", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "Lcom/urbanairship/android/framework/proxy/events/EventEmitter;", "Lkotlinx/coroutines/CoroutineScope;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "isAppForegrounded", "()Z", "getForwardNotificationListener", "()Lcom/urbanairship/push/NotificationListener;", "getForwardNotificationListener$annotations", "forwardNotificationListener", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AirshipListener implements MessageCenter.OnShowMessageCenterListener, PreferenceCenter.OnOpenListener, PushListener, PushTokenListener, NotificationListener, DeepLinkListener, AirshipChannelListener, InboxListener {
    private final EventEmitter eventEmitter;
    private final ProxyStore proxyStore;
    private final CoroutineScope scope;

    public AirshipListener(@NotNull ProxyStore proxyStore, @NotNull EventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        this.proxyStore = proxyStore;
        this.eventEmitter = eventEmitter;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    private final boolean isAppForegrounded() {
        GlobalActivityMonitor.Companion companion = GlobalActivityMonitor.INSTANCE;
        Context applicationContext = UAirship.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return companion.shared(applicationContext).getIsAppForegrounded();
    }

    private final NotificationListener getForwardNotificationListener() {
        NotificationListener forwardNotificationListener = AirshipPluginExtensions.INSTANCE.getForwardNotificationListener();
        return forwardNotificationListener == null ? AirshipPluginForwardListeners.INSTANCE.getNotificationListener() : forwardNotificationListener;
    }

    @Override // com.urbanairship.messagecenter.MessageCenter.OnShowMessageCenterListener
    public boolean onShowMessageCenter(@Nullable String messageId) {
        if (this.proxyStore.isAutoLaunchMessageCenterEnabled()) {
            return false;
        }
        EventEmitter.addEvent$default(this.eventEmitter, new DisplayMessageCenterEvent(messageId), false, 2, null);
        return true;
    }

    @Override // com.urbanairship.preferencecenter.PreferenceCenter.OnOpenListener
    public boolean onOpenPreferenceCenter(@NotNull String preferenceCenterId) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        if (this.proxyStore.isAutoLaunchPreferenceCenterEnabled(preferenceCenterId)) {
            return false;
        }
        EventEmitter.addEvent$default(this.eventEmitter, new DisplayPreferenceCenterEvent(preferenceCenterId), false, 2, null);
        return true;
    }

    @Override // com.urbanairship.push.PushListener
    public void onPushReceived(@NotNull PushMessage message, boolean notificationPosted) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (notificationPosted) {
            return;
        }
        EventEmitter.addEvent$default(this.eventEmitter, new PushReceivedEvent(message, isAppForegrounded()), false, 2, null);
    }

    @Override // com.urbanairship.push.PushTokenListener
    public void onPushTokenUpdated(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        EventEmitter.addEvent$default(this.eventEmitter, new PushTokenReceivedEvent(token), false, 2, null);
    }

    @Override // com.urbanairship.push.NotificationListener
    public void onNotificationPosted(@NotNull NotificationInfo notificationInfo) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        EventEmitter.addEvent$default(this.eventEmitter, new PushReceivedEvent(notificationInfo, isAppForegrounded()), false, 2, null);
        NotificationListener forwardNotificationListener = getForwardNotificationListener();
        if (forwardNotificationListener != null) {
            forwardNotificationListener.onNotificationPosted(notificationInfo);
        }
    }

    @Override // com.urbanairship.push.NotificationListener
    public boolean onNotificationOpened(@NotNull NotificationInfo notificationInfo) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        EventEmitter.addEvent$default(this.eventEmitter, new NotificationResponseEvent(notificationInfo, null), false, 2, null);
        NotificationListener forwardNotificationListener = getForwardNotificationListener();
        if (forwardNotificationListener != null) {
            return forwardNotificationListener.onNotificationOpened(notificationInfo);
        }
        return false;
    }

    @Override // com.urbanairship.push.NotificationListener
    public boolean onNotificationForegroundAction(@NotNull NotificationInfo notificationInfo, @NotNull NotificationActionButtonInfo notificationActionButtonInfo) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        Intrinsics.checkNotNullParameter(notificationActionButtonInfo, "notificationActionButtonInfo");
        EventEmitter.addEvent$default(this.eventEmitter, new NotificationResponseEvent(notificationInfo, notificationActionButtonInfo), false, 2, null);
        NotificationListener forwardNotificationListener = getForwardNotificationListener();
        if (forwardNotificationListener != null) {
            return forwardNotificationListener.onNotificationForegroundAction(notificationInfo, notificationActionButtonInfo);
        }
        return false;
    }

    @Override // com.urbanairship.push.NotificationListener
    public void onNotificationBackgroundAction(@NotNull NotificationInfo notificationInfo, @NotNull NotificationActionButtonInfo notificationActionButtonInfo) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        Intrinsics.checkNotNullParameter(notificationActionButtonInfo, "notificationActionButtonInfo");
        EventEmitter.addEvent$default(this.eventEmitter, new NotificationResponseEvent(notificationInfo, notificationActionButtonInfo), false, 2, null);
        NotificationListener forwardNotificationListener = getForwardNotificationListener();
        if (forwardNotificationListener != null) {
            forwardNotificationListener.onNotificationBackgroundAction(notificationInfo, notificationActionButtonInfo);
        }
    }

    @Override // com.urbanairship.push.NotificationListener
    public void onNotificationDismissed(@NotNull NotificationInfo notificationInfo) {
        Intrinsics.checkNotNullParameter(notificationInfo, "notificationInfo");
        NotificationListener forwardNotificationListener = getForwardNotificationListener();
        if (forwardNotificationListener != null) {
            forwardNotificationListener.onNotificationDismissed(notificationInfo);
        }
    }

    @Override // com.urbanairship.actions.DeepLinkListener
    public boolean onDeepLink(@NotNull String deepLink) {
        DeepLinkListener deepLinkListener;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Function1<String, AirshipPluginOverride<Unit>> onDeepLink = AirshipPluginExtensions.INSTANCE.getOnDeepLink();
        AirshipPluginOverride<Unit> airshipPluginOverrideInvoke = onDeepLink != null ? onDeepLink.invoke(deepLink) : null;
        if (airshipPluginOverrideInvoke == null && (deepLinkListener = AirshipPluginForwardListeners.INSTANCE.getDeepLinkListener()) != null && deepLinkListener.onDeepLink(deepLink)) {
            ProxyLogger.debug("Deeplink handling for " + deepLink + " overridden by deprecated forward delegate", new Object[0]);
            return true;
        }
        if (airshipPluginOverrideInvoke instanceof AirshipPluginOverride.Override) {
            ProxyLogger.debug("Deeplink handling for " + deepLink + " overridden by plugin extension", new Object[0]);
        } else if ((airshipPluginOverrideInvoke instanceof AirshipPluginOverride.UseDefault) || airshipPluginOverrideInvoke == null) {
            EventEmitter.addEvent$default(this.eventEmitter, new DeepLinkEvent(deepLink), false, 2, null);
        }
        return true;
    }

    @Override // com.urbanairship.channel.AirshipChannelListener
    public void onChannelCreated(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        EventEmitter.addEvent$default(this.eventEmitter, new ChannelCreatedEvent(channelId), false, 2, null);
    }

    /* renamed from: com.urbanairship.android.framework.proxy.AirshipListener$onInboxUpdated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int I$0;
        Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipListener.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            EventEmitter eventEmitter;
            Object unreadCount;
            int i;
            EventEmitter eventEmitter2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                eventEmitter = AirshipListener.this.eventEmitter;
                Inbox inbox = MessageCenter.INSTANCE.shared().getInbox();
                this.L$0 = eventEmitter;
                this.label = 1;
                unreadCount = inbox.getUnreadCount(this);
                if (unreadCount == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.I$0;
                    eventEmitter2 = (EventEmitter) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    eventEmitter2.addEvent(new MessageCenterUpdatedEvent(i, ((Number) obj).intValue()), true);
                    return Unit.INSTANCE;
                }
                EventEmitter eventEmitter3 = (EventEmitter) this.L$0;
                ResultKt.throwOnFailure(obj);
                unreadCount = obj;
                eventEmitter = eventEmitter3;
            }
            int iIntValue = ((Number) unreadCount).intValue();
            Inbox inbox2 = MessageCenter.INSTANCE.shared().getInbox();
            this.L$0 = eventEmitter;
            this.I$0 = iIntValue;
            this.label = 2;
            Object count = inbox2.getCount(this);
            if (count == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = iIntValue;
            EventEmitter eventEmitter4 = eventEmitter;
            obj = count;
            eventEmitter2 = eventEmitter4;
            eventEmitter2.addEvent(new MessageCenterUpdatedEvent(i, ((Number) obj).intValue()), true);
            return Unit.INSTANCE;
        }
    }

    @Override // com.urbanairship.messagecenter.InboxListener
    public void onInboxUpdated() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }
}
