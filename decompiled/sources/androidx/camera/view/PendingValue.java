package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* loaded from: classes.dex */
class PendingValue {
    private Pair mCompleterAndValue;

    PendingValue() {
    }

    ListenableFuture setValue(final Object obj) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.PendingValue$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.lambda$setValue$0(obj, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object lambda$setValue$0(Object obj, CallbackToFutureAdapter.Completer completer) {
        Pair pair = this.mCompleterAndValue;
        if (pair != null) {
            CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) pair.first;
            Objects.requireNonNull(completer2);
            completer2.setCancelled();
        }
        this.mCompleterAndValue = new Pair(completer, obj);
        return "PendingValue " + obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void propagateIfHasValue(Function function) {
        Threads.checkMainThread();
        Pair pair = this.mCompleterAndValue;
        if (pair != null) {
            ListenableFuture listenableFuture = (ListenableFuture) function.apply(pair.second);
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.mCompleterAndValue.first;
            Objects.requireNonNull(completer);
            Futures.propagate(listenableFuture, completer);
            this.mCompleterAndValue = null;
        }
    }
}
