package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes6.dex */
final class FlowKt__TransformKt$runningReduce$1$1 implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef $accumulator;
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ FlowCollector $this_flow;

    FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        Ref.ObjectRef objectRef;
        FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$1;
        Ref.ObjectRef objectRef2;
        T t;
        FlowCollector flowCollector;
        T t2;
        if (continuation instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) continuation;
            int i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
            }
        } else {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
        }
        Object obj2 = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            objectRef = this.$accumulator;
            T t3 = objectRef.element;
            if (t3 != NullSurrogateKt.NULL) {
                Function3 function3 = this.$operation;
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = this;
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = objectRef;
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = 1;
                Object objInvoke = function3.invoke(t3, obj, flowKt__TransformKt$runningReduce$1$1$emit$1);
                if (objInvoke == coroutine_suspended) {
                    t = obj;
                    return coroutine_suspended;
                }
                t = obj;
                flowKt__TransformKt$runningReduce$1$1 = this;
                objectRef2 = objectRef;
                obj2 = objInvoke;
            }
            t = obj;
            objectRef.element = t;
            flowCollector = this.$this_flow;
            t2 = this.$accumulator.element;
            flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
            flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
            flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
            if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            objectRef2 = (Ref.ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$1.L$1;
            flowKt__TransformKt$runningReduce$1$1 = (FlowKt__TransformKt$runningReduce$1$1) flowKt__TransformKt$runningReduce$1$1$emit$1.L$0;
            ResultKt.throwOnFailure(obj2);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj2);
        }
        return Unit.INSTANCE;
        Object obj3 = obj2;
        objectRef = objectRef2;
        this = flowKt__TransformKt$runningReduce$1$1;
        t = obj3;
        t = obj;
        objectRef.element = t;
        flowCollector = this.$this_flow;
        t2 = this.$accumulator.element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
        if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
