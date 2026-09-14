package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
abstract /* synthetic */ class ChannelsKt__ChannelsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2 */
    static final class C72752 extends SuspendLambda implements Function2 {
        final /* synthetic */ Object $element;
        final /* synthetic */ SendChannel $this_trySendBlocking;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72752(SendChannel sendChannel, Object obj, Continuation continuation) {
            super(2, continuation);
            this.$this_trySendBlocking = sendChannel;
            this.$element = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C72752 c72752 = new C72752(this.$this_trySendBlocking, this.$element, continuation);
            c72752.L$0 = obj;
            return c72752;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C72752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM5277constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SendChannel sendChannel = this.$this_trySendBlocking;
                    Object obj2 = this.$element;
                    Result.Companion companion = Result.INSTANCE;
                    this.label = 1;
                    if (sendChannel.send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM5277constructorimpl = Result.m5277constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th));
            }
            return ChannelResult.m5940boximpl(Result.m5283isSuccessimpl(objM5277constructorimpl) ? ChannelResult.INSTANCE.m5955successJP2dKIU(Unit.INSTANCE) : ChannelResult.INSTANCE.m5953closedJP2dKIU(Result.m5280exceptionOrNullimpl(objM5277constructorimpl)));
        }
    }

    public static final Object trySendBlocking(SendChannel sendChannel, Object obj) {
        Object objMo5925trySendJP2dKIU = sendChannel.mo5925trySendJP2dKIU(obj);
        if (objMo5925trySendJP2dKIU instanceof ChannelResult.Failed) {
            return ((ChannelResult) BuildersKt__BuildersKt.runBlocking$default(null, new C72752(sendChannel, obj, null), 1, null)).getHolder();
        }
        return ChannelResult.INSTANCE.m5955successJP2dKIU(Unit.INSTANCE);
    }

    public static final /* synthetic */ void sendBlocking(SendChannel sendChannel, Object obj) {
        if (ChannelResult.m5950isSuccessimpl(sendChannel.mo5925trySendJP2dKIU(obj))) {
            return;
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new C72741(sendChannel, obj, null), 1, null);
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1 */
    static final class C72741 extends SuspendLambda implements Function2 {
        final /* synthetic */ Object $element;
        final /* synthetic */ SendChannel $this_sendBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72741(SendChannel sendChannel, Object obj, Continuation continuation) {
            super(2, continuation);
            this.$this_sendBlocking = sendChannel;
            this.$element = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C72741(this.$this_sendBlocking, this.$element, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C72741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel sendChannel = this.$this_sendBlocking;
                Object obj2 = this.$element;
                this.label = 1;
                if (sendChannel.send(obj2, this) == coroutine_suspended) {
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
    }
}
