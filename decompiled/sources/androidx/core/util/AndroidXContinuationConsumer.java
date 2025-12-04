package androidx.core.util;

import ch.qos.logback.core.CoreConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
final class AndroidXContinuationConsumer extends AtomicBoolean implements Consumer {
    private final Continuation continuation;

    public AndroidXContinuationConsumer(Continuation continuation) {
        super(false);
        this.continuation = continuation;
    }

    @Override // androidx.core.util.Consumer
    public void accept(Object obj) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m2968constructorimpl(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
