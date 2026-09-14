package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
final class FlowKt__TransformKt$runningFold$1$1 implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef $accumulator;
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ FlowCollector $this_flow;

    FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        FlowKt__TransformKt$runningFold$1$1$emit$1 flowKt__TransformKt$runningFold$1$1$emit$1;
        FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1;
        Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) {
            flowKt__TransformKt$runningFold$1$1$emit$1 = (FlowKt__TransformKt$runningFold$1$1$emit$1) continuation;
            int i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningFold$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, continuation);
            }
        } else {
            flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, continuation);
        }
        Object obj2 = flowKt__TransformKt$runningFold$1$1$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$runningFold$1$1$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Ref.ObjectRef objectRef2 = this.$accumulator;
            Function3 function3 = this.$operation;
            T t2 = objectRef2.element;
            flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = this;
            flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = objectRef2;
            flowKt__TransformKt$runningFold$1$1$emit$1.label = 1;
            Object objInvoke = function3.invoke(t2, obj, flowKt__TransformKt$runningFold$1$1$emit$1);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowKt__TransformKt$runningFold$1$1 = this;
            objectRef = objectRef2;
            t = objInvoke;
        } else {
            if (i2 == 1) {
                objectRef = (Ref.ObjectRef) flowKt__TransformKt$runningFold$1$1$emit$1.L$1;
                flowKt__TransformKt$runningFold$1$1 = (FlowKt__TransformKt$runningFold$1$1) flowKt__TransformKt$runningFold$1$1$emit$1.L$0;
                ResultKt.throwOnFailure(obj2);
                t = obj2;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
        objectRef.element = t;
        FlowCollector flowCollector = flowKt__TransformKt$runningFold$1$1.$this_flow;
        T t3 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
        if (flowCollector.emit(t3, flowKt__TransformKt$runningFold$1$1$emit$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
