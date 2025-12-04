package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* loaded from: classes6.dex */
final class LazyBroadcastCoroutine extends BroadcastCoroutine {
    private final Continuation continuation;

    public LazyBroadcastCoroutine(CoroutineContext coroutineContext, BroadcastChannel broadcastChannel, Function2 function2) {
        super(coroutineContext, broadcastChannel, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.channels.BroadcastCoroutine, kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel openSubscription() {
        ReceiveChannel receiveChannelOpenSubscription = get_channel().openSubscription();
        start();
        return receiveChannelOpenSubscription;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable((Continuation<? super Unit>) this.continuation, this);
    }
}
