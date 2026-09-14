package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
final class SubscribedSharedFlow implements SharedFlow {
    private final Function2 action;
    private final SharedFlow sharedFlow;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 */
    static final class C74301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C74301(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscribedSharedFlow.this.collect(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List getReplayCache() {
        return this.sharedFlow.getReplayCache();
    }

    public SubscribedSharedFlow(SharedFlow sharedFlow, Function2 function2) {
        this.sharedFlow = sharedFlow;
        this.action = function2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        C74301 c74301;
        if (continuation instanceof C74301) {
            c74301 = (C74301) continuation;
            int i = c74301.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c74301.label = i - Integer.MIN_VALUE;
            } else {
                c74301 = new C74301(continuation);
            }
        } else {
            c74301 = new C74301(continuation);
        }
        Object obj = c74301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c74301.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow sharedFlow = this.sharedFlow;
            SubscribedFlowCollector subscribedFlowCollector = new SubscribedFlowCollector(flowCollector, this.action);
            c74301.label = 1;
            if (sharedFlow.collect(subscribedFlowCollector, c74301) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
