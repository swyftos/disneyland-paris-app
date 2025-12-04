package com.urbanairship.android.framework.proxy.proxies;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.urbanairship.android.framework.proxy.BaseNotificationProvider;
import com.urbanairship.android.framework.proxy.NotificationConfig;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.android.framework.proxy.Utils;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.permission.PermissionPromptFallback;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushManagerExtensions;
import com.urbanairship.push.PushMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u00020\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086@¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e0#H\u0007J\u000e\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u000fH\u0007J\u0006\u0010*\u001a\u00020\u0015J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020.J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/PushProxy;", "", "context", "Landroid/content/Context;", "store", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "permissionsManagerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/permission/PermissionsManager;", "pushProvider", "Lcom/urbanairship/push/PushManager;", "(Landroid/content/Context;Lcom/urbanairship/android/framework/proxy/ProxyStore;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "foregroundNotificationDisplayPredicate", "Lcom/urbanairship/android/framework/proxy/proxies/SuspendingPredicate;", "", "", "getForegroundNotificationDisplayPredicate", "()Lcom/urbanairship/android/framework/proxy/proxies/SuspendingPredicate;", "setForegroundNotificationDisplayPredicate", "(Lcom/urbanairship/android/framework/proxy/proxies/SuspendingPredicate;)V", "enabled", "", "isForegroundNotificationsEnabled", "()Z", "setForegroundNotificationsEnabled", "(Z)V", "clearNotification", "", "identifier", "clearNotifications", "enableUserPushNotifications", "args", "Lcom/urbanairship/android/framework/proxy/proxies/EnableUserNotificationsArgs;", "(Lcom/urbanairship/android/framework/proxy/proxies/EnableUserNotificationsArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveNotifications", "", "getNotificationStatus", "Lcom/urbanairship/android/framework/proxy/NotificationStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegistrationToken", "isNotificationChannelEnabled", "channelId", "isUserNotificationsEnabled", "setNotificationConfig", "config", "Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "Lcom/urbanairship/json/JsonValue;", "setUserNotificationsEnabled", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPushProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PushProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/PushProxy\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n37#2,2:156\n11383#3,9:158\n13309#3:167\n13310#3:169\n11392#3:170\n1#4:168\n*S KotlinDebug\n*F\n+ 1 PushProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/PushProxy\n*L\n96#1:156,2\n120#1:158,9\n120#1:167\n120#1:169\n120#1:170\n120#1:168\n*E\n"})
/* loaded from: classes2.dex */
public final class PushProxy {
    private final Context context;
    private SuspendingPredicate foregroundNotificationDisplayPredicate;
    private final Function0 permissionsManagerProvider;
    private final Function0 pushProvider;
    private final ProxyStore store;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.PushProxy$getNotificationStatus$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushProxy.this.getNotificationStatus(this);
        }
    }

    public PushProxy(@NotNull Context context, @NotNull ProxyStore store, @NotNull Function0<PermissionsManager> permissionsManagerProvider, @NotNull Function0<? extends PushManager> pushProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(permissionsManagerProvider, "permissionsManagerProvider");
        Intrinsics.checkNotNullParameter(pushProvider, "pushProvider");
        this.context = context;
        this.store = store;
        this.permissionsManagerProvider = permissionsManagerProvider;
        this.pushProvider = pushProvider;
    }

    @Nullable
    public final SuspendingPredicate<Map<String, Object>> getForegroundNotificationDisplayPredicate() {
        return this.foregroundNotificationDisplayPredicate;
    }

    public final void setForegroundNotificationDisplayPredicate(@Nullable SuspendingPredicate<Map<String, Object>> suspendingPredicate) {
        this.foregroundNotificationDisplayPredicate = suspendingPredicate;
    }

    public final boolean isForegroundNotificationsEnabled() {
        return this.store.isForegroundNotificationsEnabled();
    }

    public final void setForegroundNotificationsEnabled(boolean z) {
        this.store.setForegroundNotificationsEnabled(z);
    }

    public final void setNotificationConfig(@NotNull JsonValue config) {
        Intrinsics.checkNotNullParameter(config, "config");
        JsonMap jsonMapOptMap = config.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        setNotificationConfig(new NotificationConfig(jsonMapOptMap));
    }

    public final void setNotificationConfig(@NotNull NotificationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.store.setNotificationConfig(config);
    }

    public final void setUserNotificationsEnabled(boolean enabled) {
        ((PushManager) this.pushProvider.invoke()).setUserNotificationsEnabled(enabled);
    }

    public static /* synthetic */ Object enableUserPushNotifications$default(PushProxy pushProxy, EnableUserNotificationsArgs enableUserNotificationsArgs, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            enableUserNotificationsArgs = null;
        }
        return pushProxy.enableUserPushNotifications(enableUserNotificationsArgs, continuation);
    }

    @Nullable
    public final Object enableUserPushNotifications(@Nullable EnableUserNotificationsArgs enableUserNotificationsArgs, @NotNull Continuation<? super Boolean> continuation) {
        PermissionPromptFallback fallback;
        PushManager pushManager = (PushManager) this.pushProvider.invoke();
        if (enableUserNotificationsArgs == null || (fallback = enableUserNotificationsArgs.getFallback()) == null) {
            fallback = PermissionPromptFallback.None.INSTANCE;
        }
        return PushManagerExtensions.enableUserNotifications(pushManager, fallback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getNotificationStatus(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.android.framework.proxy.NotificationStatus> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.android.framework.proxy.proxies.PushProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.android.framework.proxy.proxies.PushProxy$getNotificationStatus$1 r0 = (com.urbanairship.android.framework.proxy.proxies.PushProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.PushProxy$getNotificationStatus$1 r0 = new com.urbanairship.android.framework.proxy.proxies.PushProxy$getNotificationStatus$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.urbanairship.android.framework.proxy.proxies.PushProxy r4 = (com.urbanairship.android.framework.proxy.proxies.PushProxy) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4d
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.functions.Function0 r5 = r4.permissionsManagerProvider
            java.lang.Object r5 = r5.invoke()
            com.urbanairship.permission.PermissionsManager r5 = (com.urbanairship.permission.PermissionsManager) r5
            com.urbanairship.permission.Permission r2 = com.urbanairship.permission.Permission.DISPLAY_NOTIFICATIONS
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.suspendingCheckPermissionStatus(r2, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            com.urbanairship.permission.PermissionStatus r5 = (com.urbanairship.permission.PermissionStatus) r5
            com.urbanairship.android.framework.proxy.NotificationStatus r0 = new com.urbanairship.android.framework.proxy.NotificationStatus
            kotlin.jvm.functions.Function0 r4 = r4.pushProvider
            java.lang.Object r4 = r4.invoke()
            com.urbanairship.push.PushManager r4 = (com.urbanairship.push.PushManager) r4
            com.urbanairship.push.PushNotificationStatus r4 = r4.getPushNotificationStatus()
            java.lang.String r5 = r5.getValue()
            r0.<init>(r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.PushProxy.getNotificationStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @RequiresApi(api = 26)
    public final boolean isNotificationChannelEnabled(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Object systemService = this.context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = ((NotificationManager) systemService).getNotificationChannel(channelId);
        return (notificationChannel == null || notificationChannel.getImportance() == 0) ? false : true;
    }

    @Nullable
    public final String getRegistrationToken() {
        return ((PushManager) this.pushProvider.invoke()).getPushToken();
    }

    public final boolean isUserNotificationsEnabled() {
        return ((PushManager) this.pushProvider.invoke()).getUserNotificationsEnabled();
    }

    public final void clearNotifications() {
        NotificationManagerCompat.from(this.context).cancelAll();
    }

    public final void clearNotification(@NotNull String identifier) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (identifier.length() == 0) {
            ProxyLogger.error("Invalid identifier: " + identifier, new Object[0]);
            return;
        }
        String[] strArr = (String[]) new Regex(":").split(identifier, 2).toArray(new String[0]);
        if (strArr.length == 0) {
            ProxyLogger.error("Invalid identifier: " + identifier, new Object[0]);
            return;
        }
        try {
            NotificationManagerCompat.from(this.context).cancel(strArr.length == 2 ? strArr[1] : null, Integer.parseInt(strArr[0]));
        } catch (NumberFormatException unused) {
            ProxyLogger.error("Invalid identifier: " + identifier, new Object[0]);
        }
    }

    @RequiresApi(api = 23)
    @NotNull
    public final List<Map<String, Object>> getActiveNotifications() {
        Object systemService = this.context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            int id = statusBarNotification.getId();
            String tag = statusBarNotification.getTag();
            Bundle bundle = statusBarNotification.getNotification().extras.getBundle(BaseNotificationProvider.PUSH_MESSAGE_BUNDLE_EXTRA);
            Map<String, Object> mapNotificationMap = bundle != null ? Utils.INSTANCE.notificationMap(new PushMessage(bundle), Integer.valueOf(id), tag) : null;
            if (mapNotificationMap != null) {
                arrayList.add(mapNotificationMap);
            }
        }
        return arrayList;
    }
}
