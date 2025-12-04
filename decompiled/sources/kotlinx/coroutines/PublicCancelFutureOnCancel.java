package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
final class PublicCancelFutureOnCancel implements CancelHandler {
    private final Future future;

    public PublicCancelFutureOnCancel(Future future) {
        this.future = future;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(Throwable th) {
        if (th != null) {
            this.future.cancel(false);
        }
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.future + AbstractJsonLexerKt.END_LIST;
    }
}
