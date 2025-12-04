package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture delegate;

        protected SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingListenableFuture, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }

    protected ForwardingListenableFuture() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    protected abstract ListenableFuture<? extends V> delegate();

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Future delegate() {
        throw null;
    }
}
