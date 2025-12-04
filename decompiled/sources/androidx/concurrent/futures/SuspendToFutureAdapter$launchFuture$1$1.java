package androidx.concurrent.futures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.Deferred;

/* loaded from: classes.dex */
/* synthetic */ class SuspendToFutureAdapter$launchFuture$1$1 extends FunctionReferenceImpl implements Function1, SuspendFunction {
    SuspendToFutureAdapter$launchFuture$1$1(Object obj) {
        super(1, obj, Deferred.class, "await", "await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((Deferred) this.receiver).await(continuation);
    }
}
