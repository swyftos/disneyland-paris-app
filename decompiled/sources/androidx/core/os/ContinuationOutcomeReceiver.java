package androidx.core.os;

import android.os.OutcomeReceiver;
import ch.qos.logback.core.CoreConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver extends AtomicBoolean implements OutcomeReceiver {
    private final Continuation continuation;

    public ContinuationOutcomeReceiver(Continuation continuation) {
        super(false);
        this.continuation = continuation;
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m2968constructorimpl(obj));
        }
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            Continuation continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(th)));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
