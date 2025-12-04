package com.urbanairship.messagecenter;

import com.urbanairship.UALog;
import com.urbanairship.push.PushMessage;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class MessageCenter$pushListener$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ PushMessage $message;
    int I$0;
    int label;
    final /* synthetic */ MessageCenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MessageCenter$pushListener$1$1(PushMessage pushMessage, MessageCenter messageCenter, Continuation continuation) {
        super(2, continuation);
        this.$message = pushMessage;
        this.this$0 = messageCenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MessageCenter$pushListener$1$1(this.$message, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MessageCenter$pushListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String richPushMessageId = this.$message.getRichPushMessageId();
            i = ((richPushMessageId == null || richPushMessageId.length() == 0) ? 1 : 0) ^ 1;
            Inbox inbox = this.this$0.getInbox();
            String richPushMessageId2 = this.$message.getRichPushMessageId();
            this.I$0 = i;
            this.label = 1;
            obj = inbox.getMessage(richPushMessageId2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
        }
        boolean z = obj != null;
        if (i != 0 && !z) {
            UALog.d("Received a Rich Push.", new Object[0]);
            Inbox inbox2 = this.this$0.getInbox();
            this.label = 2;
            if (inbox2.fetchMessages(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
