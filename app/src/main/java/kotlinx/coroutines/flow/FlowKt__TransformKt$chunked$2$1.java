package kotlinx.coroutines.flow;

import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
final class FlowKt__TransformKt$chunked$2$1 implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef $result;
    final /* synthetic */ int $size;
    final /* synthetic */ FlowCollector $this_flow;

    FlowKt__TransformKt$chunked$2$1(Ref.ObjectRef objectRef, int i, FlowCollector flowCollector) {
        this.$result = objectRef;
        this.$size = i;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v6, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        FlowKt__TransformKt$chunked$2$1$emit$1 flowKt__TransformKt$chunked$2$1$emit$1;
        ?? r6;
        if (continuation instanceof FlowKt__TransformKt$chunked$2$1$emit$1) {
            flowKt__TransformKt$chunked$2$1$emit$1 = (FlowKt__TransformKt$chunked$2$1$emit$1) continuation;
            int i = flowKt__TransformKt$chunked$2$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$chunked$2$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$chunked$2$1$emit$1 = new FlowKt__TransformKt$chunked$2$1$emit$1(this, continuation);
            }
        } else {
            flowKt__TransformKt$chunked$2$1$emit$1 = new FlowKt__TransformKt$chunked$2$1$emit$1(this, continuation);
        }
        Object obj2 = flowKt__TransformKt$chunked$2$1$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$chunked$2$1$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            ArrayList arrayList = (ArrayList) this.$result.element;
            if (arrayList == null) {
                r6 = arrayList;
                ?? arrayList2 = new ArrayList(this.$size);
                this.$result.element = arrayList2;
                r6 = arrayList2;
            }
            r6 = arrayList;
            r6.add(obj);
            if (r6.size() == this.$size) {
                FlowCollector flowCollector = this.$this_flow;
                flowKt__TransformKt$chunked$2$1$emit$1.L$0 = this;
                flowKt__TransformKt$chunked$2$1$emit$1.label = 1;
                if (flowCollector.emit(r6, flowKt__TransformKt$chunked$2$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (FlowKt__TransformKt$chunked$2$1) flowKt__TransformKt$chunked$2$1$emit$1.L$0;
        ResultKt.throwOnFailure(obj2);
        this.$result.element = null;
        return Unit.INSTANCE;
    }
}
