package com.urbanairship.push;

import com.urbanairship.permission.PermissionPromptFallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"pushNotificationStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/push/PushNotificationStatus;", "Lcom/urbanairship/push/PushManager;", "getPushNotificationStatusFlow", "(Lcom/urbanairship/push/PushManager;)Lkotlinx/coroutines/flow/StateFlow;", "enableUserNotifications", "", "promptFallback", "Lcom/urbanairship/permission/PermissionPromptFallback;", "(Lcom/urbanairship/push/PushManager;Lcom/urbanairship/permission/PermissionPromptFallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "-PushManagerExtensions")
/* renamed from: com.urbanairship.push.-PushManagerExtensions, reason: invalid class name */
/* loaded from: classes5.dex */
public final class PushManagerExtensions {

    /* renamed from: com.urbanairship.push.-PushManagerExtensions$enableUserNotifications$1, reason: invalid class name */
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
            return PushManagerExtensions.enableUserNotifications(null, null, this);
        }
    }

    @NotNull
    public static final StateFlow<PushNotificationStatus> getPushNotificationStatusFlow(@NotNull PushManager pushManager) {
        Intrinsics.checkNotNullParameter(pushManager, "<this>");
        return pushManager.getStatusObserver().getPushNotificationStatusFlow();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object enableUserNotifications(@org.jetbrains.annotations.NotNull com.urbanairship.push.PushManager r9, @org.jetbrains.annotations.NotNull com.urbanairship.permission.PermissionPromptFallback r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            boolean r0 = r11 instanceof com.urbanairship.push.PushManagerExtensions.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.urbanairship.push.-PushManagerExtensions$enableUserNotifications$1 r0 = (com.urbanairship.push.PushManagerExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.urbanairship.push.-PushManagerExtensions$enableUserNotifications$1 r0 = new com.urbanairship.push.-PushManagerExtensions$enableUserNotifications$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r8 = 1
            if (r1 == 0) goto L37
            if (r1 != r8) goto L2f
            java.lang.Object r9 = r5.L$0
            com.urbanairship.push.PushManager r9 = (com.urbanairship.push.PushManager) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L58
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.PreferenceDataStore r11 = r9.getPreferenceDataStore()
            java.lang.String r1 = "com.urbanairship.push.USER_NOTIFICATIONS_ENABLED"
            r11.put(r1, r8)
            com.urbanairship.permission.PermissionsManager r1 = r9.getPermissionsManager()
            com.urbanairship.permission.Permission r2 = com.urbanairship.permission.Permission.DISPLAY_NOTIFICATIONS
            r5.L$0 = r9
            r5.label = r8
            r3 = 0
            r6 = 2
            r7 = 0
            r4 = r10
            java.lang.Object r11 = com.urbanairship.permission.PermissionsManager.suspendingRequestPermission$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L58
            return r0
        L58:
            com.urbanairship.permission.PermissionRequestResult r11 = (com.urbanairship.permission.PermissionRequestResult) r11
            r9.updateStatusObserver()
            com.urbanairship.permission.PermissionStatus r9 = r11.getPermissionStatus()
            com.urbanairship.permission.PermissionStatus r10 = com.urbanairship.permission.PermissionStatus.GRANTED
            if (r9 != r10) goto L66
            goto L67
        L66:
            r8 = 0
        L67:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.PushManagerExtensions.enableUserNotifications(com.urbanairship.push.PushManager, com.urbanairship.permission.PermissionPromptFallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object enableUserNotifications$default(PushManager pushManager, PermissionPromptFallback permissionPromptFallback, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionPromptFallback = PermissionPromptFallback.None.INSTANCE;
        }
        return enableUserNotifications(pushManager, permissionPromptFallback, continuation);
    }
}
