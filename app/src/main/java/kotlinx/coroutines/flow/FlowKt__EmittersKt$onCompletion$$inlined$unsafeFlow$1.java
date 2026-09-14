package kotlinx.coroutines.flow;

import com.contentsquare.android.api.Currencies;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m1836d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,108:1\n143#2,13:109\n156#2,6:123\n326#3:122\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n155#1:122\n*E\n"})
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<Object> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m1845f = "Emitters.kt", m1846i = {0, 0, 1, 2}, m1847l = {PublicKeyAlgorithmTags.EXPERIMENTAL_11, 117, Currencies.CAD}, m1848m = "collect", m1849n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, m1850s = {"L$0", "L$1", "L$0", "L$0"})
    public static final class C73511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C73511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        C73511 c73511;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        if (continuation instanceof C73511) {
            c73511 = (C73511) continuation;
            int i = c73511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c73511.label = i - Integer.MIN_VALUE;
            } else {
                c73511 = new C73511(continuation);
            }
        } else {
            c73511 = new C73511(continuation);
        }
        Object obj = c73511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c73511.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = this.$this_onCompletion$inlined;
                    c73511.L$0 = this;
                    c73511.L$1 = flowCollector;
                    c73511.label = 1;
                    if (flow.collect(flowCollector, c73511) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Throwable th = (Throwable) c73511.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th;
                        }
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        safeCollector2 = (SafeCollector) c73511.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            safeCollector2.releaseIntercepted();
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            safeCollector2.releaseIntercepted();
                            throw th;
                        }
                    }
                    flowCollector = (FlowCollector) c73511.L$1;
                    this = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c73511.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Function3 function3 = this.$action$inlined;
                c73511.L$0 = safeCollector;
                c73511.L$1 = null;
                c73511.label = 3;
                InlineMarker.mark(6);
                Object objInvoke = function3.invoke(safeCollector, null, c73511);
                InlineMarker.mark(7);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                throw th;
            }
            safeCollector = new SafeCollector(flowCollector, c73511.getContext());
        } catch (Throwable th4) {
            FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
            ThrowingCollector throwingCollector = new ThrowingCollector(th4);
            Function3 function4 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            c73511.L$0 = th4;
            c73511.L$1 = null;
            c73511.label = 2;
            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function4, th4, c73511) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th4;
        }
    }
}
