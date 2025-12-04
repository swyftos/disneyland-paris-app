package com.urbanairship.iam.legacy;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.UALog;
import com.urbanairship.iam.legacy.LegacyInAppMessageUpdate;
import com.urbanairship.json.JsonException;
import com.urbanairship.push.InternalNotificationListener;
import com.urbanairship.push.NotificationActionButtonInfo;
import com.urbanairship.push.NotificationInfo;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* loaded from: classes5.dex */
final class LegacyInAppMessageUpdate$Companion$updates$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ PushManager $pushManager;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyInAppMessageUpdate$Companion$updates$1(PushManager pushManager, Continuation continuation) {
        super(2, continuation);
        this.$pushManager = pushManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LegacyInAppMessageUpdate$Companion$updates$1 legacyInAppMessageUpdate$Companion$updates$1 = new LegacyInAppMessageUpdate$Companion$updates$1(this.$pushManager, continuation);
        legacyInAppMessageUpdate$Companion$updates$1.L$0 = obj;
        return legacyInAppMessageUpdate$Companion$updates$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((LegacyInAppMessageUpdate$Companion$updates$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final InternalNotificationListener internalNotificationListener = new InternalNotificationListener() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1$$ExternalSyntheticLambda0
                @Override // com.urbanairship.push.InternalNotificationListener
                public final void onNotificationResponse(NotificationInfo notificationInfo, NotificationActionButtonInfo notificationActionButtonInfo) {
                    LegacyInAppMessageUpdate$Companion$updates$1.invokeSuspend$lambda$1(producerScope, notificationInfo, notificationActionButtonInfo);
                }
            };
            final PushListener pushListener = new PushListener() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1$$ExternalSyntheticLambda1
                @Override // com.urbanairship.push.PushListener
                public final void onPushReceived(PushMessage pushMessage, boolean z) {
                    LegacyInAppMessageUpdate$Companion$updates$1.invokeSuspend$lambda$3(producerScope, pushMessage, z);
                }
            };
            this.$pushManager.addInternalNotificationListener(internalNotificationListener);
            this.$pushManager.addInternalPushListener(pushListener);
            final PushManager pushManager = this.$pushManager;
            Function0 function0 = new Function0() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2894invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2894invoke() {
                    pushManager.removeInternalNotificationListener(internalNotificationListener);
                    pushManager.removePushListener(pushListener);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(ProducerScope producerScope, NotificationInfo notificationInfo, NotificationActionButtonInfo notificationActionButtonInfo) {
        String sendId = notificationInfo.getMessage().getSendId();
        if (sendId != null) {
            producerScope.mo3620trySendJP2dKIU(new LegacyInAppMessageUpdate.DirectOpen(sendId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, com.urbanairship.iam.legacy.LegacyInAppMessage] */
    public static final void invokeSuspend$lambda$3(ProducerScope producerScope, PushMessage pushMessage, boolean z) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            objectRef.element = LegacyInAppMessage.INSTANCE.fromPush(pushMessage);
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1$pushListener$1$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "LegacyInAppMessageManager - Unable to create in-app message from push payload";
                }
            });
        } catch (IllegalArgumentException e2) {
            UALog.e(e2, new Function0() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1$pushListener$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "LegacyInAppMessageManager - Unable to create in-app message from push payload";
                }
            });
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessageUpdate$Companion$updates$1$pushListener$1$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Received a Push with an in-app message " + objectRef.element + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }
        }, 1, null);
        LegacyInAppMessage legacyInAppMessage = (LegacyInAppMessage) objectRef.element;
        if (legacyInAppMessage != null) {
            producerScope.mo3620trySendJP2dKIU(new LegacyInAppMessageUpdate.NewMessage(legacyInAppMessage));
        }
    }
}
