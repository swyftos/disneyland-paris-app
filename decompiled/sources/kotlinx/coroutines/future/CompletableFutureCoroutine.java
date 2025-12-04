package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

/* loaded from: classes6.dex */
final class CompletableFutureCoroutine extends AbstractCoroutine implements BiFunction {
    private final CompletableFuture future;

    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        apply(obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public CompletableFutureCoroutine(CoroutineContext coroutineContext, CompletableFuture completableFuture) {
        super(coroutineContext, true, true);
        this.future = completableFuture;
    }

    public void apply(Object obj, Throwable th) {
        Job.DefaultImpls.cancel$default((Job) this, (CancellationException) null, 1, (Object) null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCompleted(Object obj) {
        this.future.complete(obj);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable th, boolean z) {
        this.future.completeExceptionally(th);
    }
}
