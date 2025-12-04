package com.urbanairship.android.framework.proxy;

import android.content.Context;
import com.urbanairship.push.PushMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes2.dex */
final class BaseAutopilot$onAirshipReady$3$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ PushMessage $message;
    final /* synthetic */ ProxyStore $proxyStore;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseAutopilot$onAirshipReady$3$1(PushMessage pushMessage, Context context, ProxyStore proxyStore, Continuation continuation) {
        super(2, continuation);
        this.$message = pushMessage;
        this.$context = context;
        this.$proxyStore = proxyStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseAutopilot$onAirshipReady$3$1(this.$message, this.$context, this.$proxyStore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseAutopilot$onAirshipReady$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L76
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L34
        L1e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.urbanairship.android.framework.proxy.AirshipPluginExtensions r10 = com.urbanairship.android.framework.proxy.AirshipPluginExtensions.INSTANCE
            kotlin.jvm.functions.Function2 r10 = r10.getOnShouldDisplayForegroundNotification()
            if (r10 == 0) goto L38
            com.urbanairship.push.PushMessage r1 = r9.$message
            r9.label = r3
            java.lang.Object r10 = r10.invoke(r1, r9)
            if (r10 != r0) goto L34
            return r0
        L34:
            com.urbanairship.android.framework.proxy.AirshipPluginOverride r10 = (com.urbanairship.android.framework.proxy.AirshipPluginOverride) r10
            if (r10 != 0) goto L3a
        L38:
            com.urbanairship.android.framework.proxy.AirshipPluginOverride$UseDefault r10 = com.urbanairship.android.framework.proxy.AirshipPluginOverride.UseDefault.INSTANCE
        L3a:
            boolean r1 = r10 instanceof com.urbanairship.android.framework.proxy.AirshipPluginOverride.Override
            if (r1 == 0) goto L4b
            com.urbanairship.android.framework.proxy.AirshipPluginOverride$Override r10 = (com.urbanairship.android.framework.proxy.AirshipPluginOverride.Override) r10
            java.lang.Object r9 = r10.getResult()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            goto L83
        L4b:
            boolean r10 = r10 instanceof com.urbanairship.android.framework.proxy.AirshipPluginOverride.UseDefault
            if (r10 == 0) goto L88
            com.urbanairship.android.framework.proxy.proxies.AirshipProxy$Companion r10 = com.urbanairship.android.framework.proxy.proxies.AirshipProxy.INSTANCE
            android.content.Context r1 = r9.$context
            com.urbanairship.android.framework.proxy.proxies.AirshipProxy r10 = r10.shared(r1)
            com.urbanairship.android.framework.proxy.proxies.PushProxy r10 = r10.getPush()
            com.urbanairship.android.framework.proxy.proxies.SuspendingPredicate r10 = r10.getForegroundNotificationDisplayPredicate()
            if (r10 == 0) goto L7d
            com.urbanairship.android.framework.proxy.Utils r3 = com.urbanairship.android.framework.proxy.Utils.INSTANCE
            com.urbanairship.push.PushMessage r4 = r9.$message
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.Map r1 = com.urbanairship.android.framework.proxy.Utils.notificationMap$default(r3, r4, r5, r6, r7, r8)
            r9.label = r2
            java.lang.Object r10 = r10.apply(r1, r9)
            if (r10 != r0) goto L76
            return r0
        L76:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r9 = r10.booleanValue()
            goto L83
        L7d:
            com.urbanairship.android.framework.proxy.ProxyStore r9 = r9.$proxyStore
            boolean r9 = r9.isForegroundNotificationsEnabled()
        L83:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r9
        L88:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.BaseAutopilot$onAirshipReady$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
