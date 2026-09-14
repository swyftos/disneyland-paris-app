package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes6.dex */
abstract /* synthetic */ class FlowKt__CollectionKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 */
    static final class C73411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.toCollection(null, null, this);
        }
    }

    public static final Object toList(Flow flow, List list, Continuation continuation) {
        return FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, continuation);
    }

    public static final Object toSet(Flow flow, Set set, Continuation continuation) {
        return FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object toCollection(Flow flow, final Collection collection, Continuation continuation) {
        C73411 c73411;
        if (continuation instanceof C73411) {
            c73411 = (C73411) continuation;
            int i = c73411.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73411.label = i - Integer.MIN_VALUE;
            } else {
                c73411 = new C73411(continuation);
            }
        } else {
            c73411 = new C73411(continuation);
        }
        Object obj = c73411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73411.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection2 = (Collection) c73411.L$0;
            ResultKt.throwOnFailure(obj);
            return collection2;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CollectionKt.toCollection.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj2, Continuation continuation2) {
                collection.add(obj2);
                return Unit.INSTANCE;
            }
        };
        c73411.L$0 = collection;
        c73411.label = 1;
        return flow.collect(flowCollector, c73411) == coroutine_suspended ? coroutine_suspended : collection;
    }
}
