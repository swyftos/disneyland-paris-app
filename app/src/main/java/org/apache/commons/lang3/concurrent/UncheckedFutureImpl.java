package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.exception.UncheckedInterruptedException;

/* JADX INFO: loaded from: classes6.dex */
final class UncheckedFutureImpl extends AbstractFutureProxy implements UncheckedFuture {
    UncheckedFutureImpl(Future future) {
        super(future);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractFutureProxy, java.util.concurrent.Future
    public Object get() {
        try {
            return super.get();
        } catch (InterruptedException e) {
            throw new UncheckedInterruptedException(e);
        } catch (ExecutionException e2) {
            throw new UncheckedExecutionException(e2);
        }
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractFutureProxy, java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        try {
            return super.get(j, timeUnit);
        } catch (InterruptedException e) {
            throw new UncheckedInterruptedException(e);
        } catch (ExecutionException e2) {
            throw new UncheckedExecutionException(e2);
        } catch (TimeoutException e3) {
            throw new UncheckedTimeoutException(e3);
        }
    }
}
