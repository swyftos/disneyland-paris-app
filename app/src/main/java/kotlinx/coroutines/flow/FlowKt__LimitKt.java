package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;

/* JADX INFO: loaded from: classes6.dex */
abstract /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 */
    static final class C73621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73621(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.collectWhile(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object emitAbort$FlowKt__LimitKt(FlowCollector flowCollector, Object obj, Object obj2, Continuation continuation) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        if (continuation instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuation;
            int i = flowKt__LimitKt$emitAbort$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
            }
        } else {
            flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
        }
        Object obj3 = flowKt__LimitKt$emitAbort$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__LimitKt$emitAbort$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            flowKt__LimitKt$emitAbort$1.L$0 = obj2;
            flowKt__LimitKt$emitAbort$1.label = 1;
            if (flowCollector.emit(obj, flowKt__LimitKt$emitAbort$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = flowKt__LimitKt$emitAbort$1.L$0;
            ResultKt.throwOnFailure(obj3);
        }
        throw new AbortFlowException(obj2);
    }

    public static final Flow drop(final Flow flow, final int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
        }
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                Object objCollect = flow.collect(new FlowKt__LimitKt$drop$2$1(new Ref.IntRef(), i, flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    public static final Flow dropWhile(final Flow flow, final Function2 function2) {
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                Object objCollect = flow.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref.BooleanRef(), flowCollector, function2), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    public static final Flow take(Flow flow, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " should be positive").toString());
        }
        return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i);
    }

    public static final Flow takeWhile(Flow flow, Function2 function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, function2);
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1 */
    static final class C73661 extends SuspendLambda implements Function2 {
        final /* synthetic */ Flow $this_transformWhile;
        final /* synthetic */ Function3 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C73661(Flow flow, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.$this_transformWhile = flow;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C73661 c73661 = new C73661(this.$this_transformWhile, this.$transform, continuation);
            c73661.L$0 = obj;
            return c73661;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C73661) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C7367xdf1aa1b6 c7367xdf1aa1b6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow flow = this.$this_transformWhile;
                C7367xdf1aa1b6 c7367xdf1aa1b7 = new C7367xdf1aa1b6(this.$transform, flowCollector);
                try {
                    this.L$0 = c7367xdf1aa1b7;
                    this.label = 1;
                    if (flow.collect(c7367xdf1aa1b7, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (AbortFlowException e) {
                    e = e;
                    c7367xdf1aa1b6 = c7367xdf1aa1b7;
                    FlowExceptions_commonKt.checkOwnership(e, c7367xdf1aa1b6);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c7367xdf1aa1b6 = (C7367xdf1aa1b6) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e2) {
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, c7367xdf1aa1b6);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Flow transformWhile(Flow flow, Function3 function3) {
        return FlowKt.flow(new C73661(flow, function3, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object collectWhile(Flow flow, Function2 function2, Continuation continuation) {
        C73621 c73621;
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        if (continuation instanceof C73621) {
            c73621 = (C73621) continuation;
            int i = c73621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73621.label = i - Integer.MIN_VALUE;
            } else {
                c73621 = new C73621(continuation);
            }
        } else {
            c73621 = new C73621(continuation);
        }
        Object obj = c73621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$2 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
            try {
                c73621.L$0 = flowKt__LimitKt$collectWhile$collector$2;
                c73621.label = 1;
                if (flow.collect(flowKt__LimitKt$collectWhile$collector$2, c73621) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e) {
                e = e;
                flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$2;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__LimitKt$collectWhile$collector$1 = (FlowKt__LimitKt$collectWhile$collector$1) c73621.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e2) {
                e = e2;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
            }
        }
        return Unit.INSTANCE;
    }
}
