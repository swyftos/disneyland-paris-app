package coil3.network.okhttp.internal;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
final class ContinuationCallback implements Callback, Function1 {
    private final Call call;
    private final CancellableContinuation continuation;

    public ContinuationCallback(Call call, CancellableContinuation cancellableContinuation) {
        this.call = call;
        this.continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.continuation.resumeWith(Result.m5277constructorimpl(response));
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (call.getCanceled()) {
            return;
        }
        CancellableContinuation cancellableContinuation = this.continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m5277constructorimpl(ResultKt.createFailure(iOException)));
    }

    public void invoke(Throwable th) {
        try {
            this.call.cancel();
        } catch (Throwable unused) {
        }
    }
}
