package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class SharedByteBuffer implements Closeable {
    private final Object mCloseLock;
    private boolean mClosed;
    private final Pair mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;
    private final AtomicInteger mSharedRefCount;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeInternal();
    }

    @NonNull
    public ByteBuffer get() {
        ByteBuffer byteBuffer;
        synchronized (this.mCloseLock) {
            checkNotClosed("get()");
            byteBuffer = this.mSharedByteBuffer;
        }
        return byteBuffer;
    }

    private void checkNotClosed(String str) {
        if (this.mClosed) {
            throw new IllegalStateException("Cannot call " + str + " on a closed SharedByteBuffer.");
        }
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this)));
    }

    protected void finalize() throws Throwable {
        try {
            if (closeInternal()) {
                Logger.w("SharedByteBuffer", String.format(Locale.US, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [%s]", toString()));
            }
        } finally {
            super.finalize();
        }
    }

    private boolean closeInternal() {
        synchronized (this.mCloseLock) {
            try {
                if (this.mClosed) {
                    return false;
                }
                this.mClosed = true;
                int iDecrementAndGet = this.mSharedRefCount.decrementAndGet();
                if (Logger.isDebugEnabled("SharedByteBuffer")) {
                    if (iDecrementAndGet < 0) {
                        throw new AssertionError("Invalid ref count. close() should never produce a ref count below 0");
                    }
                    Logger.d("SharedByteBuffer", String.format(Locale.US, "Ref count decremented: %d [%s]", Integer.valueOf(iDecrementAndGet), toString()));
                }
                if (iDecrementAndGet == 0) {
                    if (Logger.isDebugEnabled("SharedByteBuffer")) {
                        Logger.d("SharedByteBuffer", String.format(Locale.US, "Final reference released. Running final close action. [%s]", toString()));
                    }
                    try {
                        ((Executor) Preconditions.checkNotNull((Executor) this.mFinalCloseAction.first)).execute((Runnable) Preconditions.checkNotNull((Runnable) this.mFinalCloseAction.second));
                    } catch (RejectedExecutionException e) {
                        Logger.e("SharedByteBuffer", String.format(Locale.US, "Unable to execute final close action. [%s]", toString()), e);
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
