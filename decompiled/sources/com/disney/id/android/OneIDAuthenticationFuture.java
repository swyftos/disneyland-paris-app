package com.disney.id.android;

import androidx.core.os.CancellationSignal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/disney/id/android/OneIDAuthenticationFuture;", "Ljava/util/concurrent/Future;", "Ljavax/crypto/Cipher;", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/core/os/CancellationSignal;)V", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "enabledCipher", "cancel", "", "mayInterruptIfRunning", "complete", "", "cipher", "get", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "isCancelled", "isDone", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDAuthenticationFuture implements Future<Cipher> {
    private final CancellationSignal cancellationSignal;
    private final CountDownLatch countDownLatch;
    private Cipher enabledCipher;

    public OneIDAuthenticationFuture(@NotNull CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        this.cancellationSignal = cancellationSignal;
        this.countDownLatch = new CountDownLatch(1);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (isDone() || isCancelled()) {
            return false;
        }
        this.cancellationSignal.cancel();
        this.countDownLatch.countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancellationSignal.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.countDownLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public Cipher get() throws ExecutionException, InterruptedException {
        this.countDownLatch.await();
        return this.enabledCipher;
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public Cipher get(long timeout, @NotNull TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.countDownLatch.await(timeout, unit);
        return this.enabledCipher;
    }

    public final void complete(@Nullable Cipher cipher) {
        this.enabledCipher = cipher;
        this.countDownLatch.countDown();
    }
}
