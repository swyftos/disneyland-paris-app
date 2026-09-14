package kotlinx.coroutines.flow;

import com.contentsquare.android.api.Currencies;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m1836d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,130:1\n83#2,6:131\n*E\n"})
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 implements FlowCollector<Object> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ FlowCollector $this_flow$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", m1845f = "Limit.kt", m1846i = {0, 0, 1}, m1847l = {131, Currencies.CVE}, m1848m = "emit", m1849n = {"this", "value", "this"}, m1850s = {"L$0", "L$1", "L$0"})
    public static final class C73651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C73651(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.$predicate$inlined = function2;
        this.$this_flow$inlined = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation<? super Unit> continuation) {
        C73651 c73651;
        if (continuation instanceof C73651) {
            c73651 = (C73651) continuation;
            int i = c73651.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73651.label = i - Integer.MIN_VALUE;
            } else {
                c73651 = new C73651(continuation);
            }
        } else {
            c73651 = new C73651(continuation);
        }
        Object objInvoke = c73651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73651.label;
        boolean z = true;
        if (i2 != 0) {
            if (i2 == 1) {
                obj = c73651.L$1;
                this = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) c73651.L$0;
                ResultKt.throwOnFailure(objInvoke);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) c73651.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            if (z) {
                throw new AbortFlowException(this);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objInvoke);
        Function2 function2 = this.$predicate$inlined;
        c73651.L$0 = this;
        c73651.L$1 = obj;
        c73651.label = 1;
        InlineMarker.mark(6);
        objInvoke = function2.invoke(obj, c73651);
        InlineMarker.mark(7);
        if (objInvoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (((Boolean) objInvoke).booleanValue()) {
            FlowCollector flowCollector = this.$this_flow$inlined;
            c73651.L$0 = this;
            c73651.L$1 = null;
            c73651.label = 2;
            if (flowCollector.emit(obj, c73651) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            z = false;
        }
        if (z) {
            throw new AbortFlowException(this);
        }
        return Unit.INSTANCE;
    }
}
