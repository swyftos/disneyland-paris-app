package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: loaded from: classes6.dex */
final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ FlowCollector $downStream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.$downStream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, continuation);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m5972invokeWpGqRn0(((ChannelResult) obj).getHolder(), (Continuation) obj2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m5972invokeWpGqRn0(Object obj, Continuation continuation) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.m5940boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object holder;
        Object obj2;
        Throwable thM5944exceptionOrNullimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            holder = ((ChannelResult) this.L$0).getHolder();
            FlowCollector flowCollector = this.$downStream;
            if (!(holder instanceof ChannelResult.Failed)) {
                this.L$0 = holder;
                this.label = 1;
                if (flowCollector.emit(holder, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = holder;
            }
            if (holder instanceof ChannelResult.Closed) {
                return Boxing.boxBoolean(true);
            }
            thM5944exceptionOrNullimpl = ChannelResult.m5944exceptionOrNullimpl(holder);
            if (thM5944exceptionOrNullimpl == null) {
                throw thM5944exceptionOrNullimpl;
            }
            return Boxing.boxBoolean(false);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = this.L$0;
        ResultKt.throwOnFailure(obj);
        holder = obj2;
        if (holder instanceof ChannelResult.Closed) {
            return Boxing.boxBoolean(true);
        }
        thM5944exceptionOrNullimpl = ChannelResult.m5944exceptionOrNullimpl(holder);
        if (thM5944exceptionOrNullimpl == null) {
            throw thM5944exceptionOrNullimpl;
        }
        return Boxing.boxBoolean(false);
    }
}
