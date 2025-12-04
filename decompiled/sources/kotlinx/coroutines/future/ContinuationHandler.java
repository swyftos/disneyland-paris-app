package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
final class ContinuationHandler implements BiFunction {

    @JvmField
    @Nullable
    public volatile Continuation<Object> cont;

    public ContinuationHandler(Continuation continuation) {
        this.cont = continuation;
    }

    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        apply(obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public void apply(Object obj, Throwable th) {
        Throwable cause;
        Continuation<Object> continuation = this.cont;
        if (continuation == null) {
            return;
        }
        if (th == null) {
            continuation.resumeWith(Result.m2968constructorimpl(obj));
            return;
        }
        CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th = cause;
        }
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(th)));
    }
}
