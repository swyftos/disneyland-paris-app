package kotlinx.coroutines.flow;

import ch.qos.logback.core.net.SyslogConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes6.dex */
abstract /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 */
    static final class C73761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C73761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 */
    static final class C73773 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C73773(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 */
    static final class C73791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C73791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 */
    static final class C73803 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C73803(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 */
    static final class C73811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73811(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 */
    static final class C73831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73831(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 */
    static final class C73851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73851(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 */
    static final class C73871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73871(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 */
    static final class C73891 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C73891(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 */
    static final class C73911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C73911(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object reduce(Flow flow, Function3 function3, Continuation continuation) {
        C73871 c73871;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73871) {
            c73871 = (C73871) continuation;
            int i = c73871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73871.label = i - Integer.MIN_VALUE;
            } else {
                c73871 = new C73871(continuation);
            }
        } else {
            c73871 = new C73871(continuation);
        }
        Object obj = c73871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73871.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            C73882 c73882 = new C73882(objectRef2, function3);
            c73871.L$0 = objectRef2;
            c73871.label = 1;
            if (flow.collect(c73882, c73871) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c73871.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2 */
    static final class C73882 implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef $accumulator;
        final /* synthetic */ Function3 $operation;

        C73882(Ref.ObjectRef objectRef, Function3 function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            Ref.ObjectRef objectRef;
            Object obj2;
            Ref.ObjectRef objectRef2;
            T t;
            if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
                int i = flowKt__ReduceKt$reduce$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
            }
            Object obj3 = flowKt__ReduceKt$reduce$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$reduce$2$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj3);
                objectRef = this.$accumulator;
                T t2 = objectRef.element;
                if (t2 != NullSurrogateKt.NULL) {
                    Function3 function3 = this.$operation;
                    flowKt__ReduceKt$reduce$2$emit$1.L$0 = objectRef;
                    flowKt__ReduceKt$reduce$2$emit$1.label = 1;
                    Object objInvoke = function3.invoke(t2, obj, flowKt__ReduceKt$reduce$2$emit$1);
                    if (objInvoke == coroutine_suspended) {
                        t = obj;
                        return coroutine_suspended;
                    }
                    t = obj;
                    obj2 = objInvoke;
                    objectRef2 = objectRef;
                }
                t = obj;
                objectRef.element = t;
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.L$0;
            ResultKt.throwOnFailure(obj3);
            obj2 = obj3;
            objectRef = objectRef2;
            t = obj2;
            t = obj;
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object fold(Flow flow, Object obj, Function3 function3, Continuation continuation) {
        C73811 c73811;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73811) {
            c73811 = (C73811) continuation;
            int i = c73811.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73811.label = i - Integer.MIN_VALUE;
            } else {
                c73811 = new C73811(continuation);
            }
        } else {
            c73811 = new C73811(continuation);
        }
        Object obj2 = c73811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73811.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = obj;
            C73822 c73822 = new C73822(objectRef2, function3);
            c73811.L$0 = objectRef2;
            c73811.label = 1;
            if (flow.collect(c73822, c73811) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c73811.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
    public static final class C73822<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef $accumulator;
        final /* synthetic */ Function3 $operation;

        public C73822(Ref.ObjectRef<Object> objectRef, Function3<Object, ? super T, ? super Continuation<Object>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            Ref.ObjectRef objectRef;
            if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
                int i = flowKt__ReduceKt$fold$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            }
            T t2 = (T) flowKt__ReduceKt$fold$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$fold$2$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(t2);
                Ref.ObjectRef objectRef2 = this.$accumulator;
                Function3 function3 = this.$operation;
                T t3 = objectRef2.element;
                flowKt__ReduceKt$fold$2$emit$1.L$0 = objectRef2;
                flowKt__ReduceKt$fold$2$emit$1.label = 1;
                Object objInvoke = function3.invoke(t3, t, flowKt__ReduceKt$fold$2$emit$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t2 = (T) objInvoke;
                objectRef = objectRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$1.L$0;
                ResultKt.throwOnFailure(t2);
            }
            objectRef.element = t2;
            return Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
            InlineMarker.mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            InlineMarker.mark(5);
            Ref.ObjectRef objectRef = this.$accumulator;
            objectRef.element = (T) this.$operation.invoke(objectRef.element, t, continuation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object single(Flow flow, Continuation continuation) {
        C73891 c73891;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73891) {
            c73891 = (C73891) continuation;
            int i = c73891.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73891.label = i - Integer.MIN_VALUE;
            } else {
                c73891 = new C73891(continuation);
            }
        } else {
            c73891 = new C73891(continuation);
        }
        Object obj = c73891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73891.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj2, Continuation continuation2) {
                    Ref.ObjectRef objectRef3 = objectRef2;
                    if (objectRef3.element != NullSurrogateKt.NULL) {
                        throw new IllegalArgumentException("Flow has more than one element");
                    }
                    objectRef3.element = obj2;
                    return Unit.INSTANCE;
                }
            };
            c73891.L$0 = objectRef2;
            c73891.label = 1;
            if (flow.collect(flowCollector, c73891) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c73891.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object singleOrNull(Flow flow, Continuation continuation) {
        C73911 c73911;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<Object> flowCollector;
        if (continuation instanceof C73911) {
            c73911 = (C73911) continuation;
            int i = c73911.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73911.label = i - Integer.MIN_VALUE;
            } else {
                c73911 = new C73911(continuation);
            }
        } else {
            c73911 = new C73911(continuation);
        }
        Object obj = c73911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73911.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowCollector<Object> flowCollector2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlinx.coroutines.internal.Symbol] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Object obj2, Continuation<? super Unit> continuation2) {
                    Ref.ObjectRef objectRef3 = objectRef2;
                    T t = objectRef3.element;
                    ?? r1 = NullSurrogateKt.NULL;
                    if (t == r1) {
                        objectRef3.element = obj2;
                        return Unit.INSTANCE;
                    }
                    objectRef3.element = r1;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c73911.L$0 = objectRef2;
                c73911.L$1 = flowCollector2;
                c73911.label = 1;
                if (flow.collect(flowCollector2, c73911) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c73911.L$1;
            objectRef = (Ref.ObjectRef) c73911.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
            return null;
        }
        return t;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object first(Flow flow, Continuation continuation) {
        C73761 c73761;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<Object> flowCollector;
        if (continuation instanceof C73761) {
            c73761 = (C73761) continuation;
            int i = c73761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73761.label = i - Integer.MIN_VALUE;
            } else {
                c73761 = new C73761(continuation);
            }
        } else {
            c73761 = new C73761(continuation);
        }
        Object obj = c73761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73761.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowCollector<Object> flowCollector2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Object obj2, Continuation<? super Unit> continuation2) {
                    objectRef2.element = obj2;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c73761.L$0 = objectRef2;
                c73761.L$1 = flowCollector2;
                c73761.label = 1;
                if (flow.collect(flowCollector2, c73761) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) c73761.L$1;
            objectRef = (Ref.ObjectRef) c73761.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object first(Flow flow, Function2 function2, Continuation continuation) {
        C73773 c73773;
        Function2 function3;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        if (continuation instanceof C73773) {
            c73773 = (C73773) continuation;
            int i = c73773.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73773.label = i - Integer.MIN_VALUE;
            } else {
                c73773 = new C73773(continuation);
            }
        } else {
            c73773 = new C73773(continuation);
        }
        Object obj = c73773.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73773.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$3 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(function2, objectRef2);
            try {
                c73773.L$0 = function2;
                c73773.L$1 = objectRef2;
                c73773.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                c73773.label = 1;
                if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$3, c73773) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function2;
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                function3 = function2;
                objectRef = objectRef2;
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) c73773.L$2;
            objectRef = (Ref.ObjectRef) c73773.L$1;
            function3 = (Function2) c73773.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
            }
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object firstOrNull(Flow flow, Continuation continuation) {
        C73791 c73791;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<Object> flowCollector;
        if (continuation instanceof C73791) {
            c73791 = (C73791) continuation;
            int i = c73791.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73791.label = i - Integer.MIN_VALUE;
            } else {
                c73791 = new C73791(continuation);
            }
        } else {
            c73791 = new C73791(continuation);
        }
        Object obj = c73791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73791.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowCollector<Object> flowCollector2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Object obj2, Continuation<? super Unit> continuation2) {
                    objectRef2.element = obj2;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c73791.L$0 = objectRef2;
                c73791.L$1 = flowCollector2;
                c73791.label = 1;
                if (flow.collect(flowCollector2, c73791) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c73791.L$1;
            objectRef = (Ref.ObjectRef) c73791.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object firstOrNull(Flow flow, Function2 function2, Continuation continuation) {
        C73803 c73803;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
        if (continuation instanceof C73803) {
            c73803 = (C73803) continuation;
            int i = c73803.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73803.label = i - Integer.MIN_VALUE;
            } else {
                c73803 = new C73803(continuation);
            }
        } else {
            c73803 = new C73803(continuation);
        }
        Object obj = c73803.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73803.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(function2, objectRef2);
            try {
                c73803.L$0 = objectRef2;
                c73803.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3;
                c73803.label = 1;
                if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3, c73803) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c73803.L$1;
            objectRef = (Ref.ObjectRef) c73803.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
            }
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final Object last(Flow flow, Continuation continuation) {
        C73831 c73831;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73831) {
            c73831 = (C73831) continuation;
            int i = c73831.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73831.label = i - Integer.MIN_VALUE;
            } else {
                c73831 = new C73831(continuation);
            }
        } else {
            c73831 = new C73831(continuation);
        }
        Object obj = c73831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73831.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = NullSurrogateKt.NULL;
            FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj2, Continuation continuation2) {
                    objectRef2.element = obj2;
                    return Unit.INSTANCE;
                }
            };
            c73831.L$0 = objectRef2;
            c73831.label = 1;
            if (flow.collect(flowCollector, c73831) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c73831.L$0;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object lastOrNull(Flow flow, Continuation continuation) {
        C73851 c73851;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73851) {
            c73851 = (C73851) continuation;
            int i = c73851.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73851.label = i - Integer.MIN_VALUE;
            } else {
                c73851 = new C73851(continuation);
            }
        } else {
            c73851 = new C73851(continuation);
        }
        Object obj = c73851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73851.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj2, Continuation continuation2) {
                    objectRef2.element = obj2;
                    return Unit.INSTANCE;
                }
            };
            c73851.L$0 = objectRef2;
            c73851.label = 1;
            if (flow.collect(flowCollector, c73851) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c73851.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }
}
