package kotlinx.coroutines.flow;

import ch.qos.logback.core.net.SyslogConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m1836d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n153#2,12:109\n165#2:122\n1#3:121\n*E\n"})
public final class FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1 implements Flow<List<Object>> {
    final /* synthetic */ int $size$inlined;
    final /* synthetic */ Flow $this_chunked$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1", m1845f = "Transform.kt", m1846i = {0, 0}, m1847l = {PublicKeyAlgorithmTags.EXPERIMENTAL_11, SyslogConstants.LOG_CLOCK}, m1848m = "collect", m1849n = {"$this$chunked_u24lambda_u2413", "result"}, m1850s = {"L$0", "L$1"})
    public static final class C73951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C73951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1(Flow flow, int i) {
        this.$this_chunked$inlined = flow;
        this.$size$inlined = i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super List<Object>> flowCollector, Continuation<? super Unit> continuation) {
        C73951 c73951;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C73951) {
            c73951 = (C73951) continuation;
            int i = c73951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73951.label = i - Integer.MIN_VALUE;
            } else {
                c73951 = new C73951(continuation);
            }
        } else {
            c73951 = new C73951(continuation);
        }
        Object obj = c73951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73951.label;
        if (i2 != 0) {
            if (i2 == 1) {
                objectRef = (Ref.ObjectRef) c73951.L$1;
                flowCollector = (FlowCollector) c73951.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Flow flow = this.$this_chunked$inlined;
        FlowKt__TransformKt$chunked$2$1 flowKt__TransformKt$chunked$2$1 = new FlowKt__TransformKt$chunked$2$1(objectRef2, this.$size$inlined, flowCollector);
        c73951.L$0 = flowCollector;
        c73951.L$1 = objectRef2;
        c73951.label = 1;
        if (flow.collect(flowKt__TransformKt$chunked$2$1, c73951) == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef = objectRef2;
        ArrayList arrayList = (ArrayList) objectRef.element;
        if (arrayList != null) {
            c73951.L$0 = null;
            c73951.L$1 = null;
            c73951.label = 2;
            if (flowCollector.emit(arrayList, c73951) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
