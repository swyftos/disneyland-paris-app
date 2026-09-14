package expo.modules.fetch;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class NativeResponse$state$3 extends SuspendLambda implements Function2 {
    final /* synthetic */ ResponseState $value;
    int label;
    final /* synthetic */ NativeResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeResponse$state$3(NativeResponse nativeResponse, ResponseState responseState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = nativeResponse;
        this.$value = responseState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NativeResponse$state$3(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NativeResponse$state$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = this.this$0.stateChangeOnceListeners;
            final ResponseState responseState = this.$value;
            CollectionsKt.removeAll(list, new Function1() { // from class: expo.modules.fetch.NativeResponse$state$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(NativeResponse$state$3.invokeSuspend$lambda$0(responseState, (Function1) obj2));
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(ResponseState responseState, Function1 function1) {
        return ((Boolean) function1.invoke(responseState)).booleanValue();
    }
}
