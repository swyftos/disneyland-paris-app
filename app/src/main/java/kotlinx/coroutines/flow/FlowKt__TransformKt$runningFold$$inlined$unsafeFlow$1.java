package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m1836d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,108:1\n102#2,7:109\n*E\n"})
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 implements Flow<Object> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", m1845f = "Transform.kt", m1846i = {0, 0, 0}, m1847l = {PublicKeyAlgorithmTags.EXPERIMENTAL_11, 111}, m1848m = "collect", m1849n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, m1850s = {"L$0", "L$1", "L$2"})
    public static final class C74091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C74091(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = function3;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
        C74091 c74091;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C74091) {
            c74091 = (C74091) continuation;
            int i = c74091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c74091.label = i - Integer.MIN_VALUE;
            } else {
                c74091 = new C74091(continuation);
            }
        } else {
            c74091 = new C74091(continuation);
        }
        Object obj = c74091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c74091.label;
        if (i2 != 0) {
            if (i2 == 1) {
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) c74091.L$2;
                flowCollector = (FlowCollector) c74091.L$1;
                FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) c74091.L$0;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef2;
                this = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        objectRef = new Ref.ObjectRef();
        ?? r2 = this.$initial$inlined;
        objectRef.element = r2;
        c74091.L$0 = this;
        c74091.L$1 = flowCollector;
        c74091.L$2 = objectRef;
        c74091.label = 1;
        if (flowCollector.emit(r2, c74091) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Flow flow = this.$this_runningFold$inlined;
        FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1 = new FlowKt__TransformKt$runningFold$1$1(objectRef, this.$operation$inlined, flowCollector);
        c74091.L$0 = null;
        c74091.L$1 = null;
        c74091.L$2 = null;
        c74091.label = 2;
        if (flow.collect(flowKt__TransformKt$runningFold$1$1, c74091) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
