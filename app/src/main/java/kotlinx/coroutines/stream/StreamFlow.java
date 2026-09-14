package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes6.dex */
final class StreamFlow implements Flow {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile = 0;
    private final Stream stream;

    /* JADX INFO: renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1 */
    static final class C74471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C74471(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlow.this.collect(null, this);
        }
    }

    public StreamFlow(Stream stream) {
        this.stream = stream;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0060 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:22:0x005a, B:24:0x0060), top: B:37:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[LOOP:0: B:37:0x005a->B:46:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        C74471 c74471;
        StreamFlow streamFlow;
        Throwable th;
        Iterator it;
        FlowCollector flowCollector2;
        Object next;
        if (continuation instanceof C74471) {
            c74471 = (C74471) continuation;
            int i = c74471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c74471.label = i - Integer.MIN_VALUE;
            } else {
                c74471 = new C74471(continuation);
            }
        } else {
            c74471 = new C74471(continuation);
        }
        Object obj = c74471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c74471.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!consumed$volatile$FU.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once");
            }
            try {
                streamFlow = this;
                it = this.stream.iterator();
                flowCollector2 = flowCollector;
                while (it.hasNext()) {
                    next = it.next();
                    c74471.L$0 = streamFlow;
                    c74471.L$1 = flowCollector2;
                    c74471.L$2 = it;
                    c74471.label = 1;
                    if (flowCollector2.emit(next, c74471) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                streamFlow.stream.close();
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                streamFlow = this;
                th = th2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c74471.L$2;
            FlowCollector flowCollector3 = (FlowCollector) c74471.L$1;
            StreamFlow streamFlow2 = (StreamFlow) c74471.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector3;
                streamFlow = streamFlow2;
                while (it.hasNext()) {
                    try {
                        next = it.next();
                        c74471.L$0 = streamFlow;
                        c74471.L$1 = flowCollector2;
                        c74471.L$2 = it;
                        c74471.label = 1;
                        if (flowCollector2.emit(next, c74471) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                streamFlow.stream.close();
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                streamFlow = streamFlow2;
            }
        }
        streamFlow.stream.close();
        throw th;
    }
}
