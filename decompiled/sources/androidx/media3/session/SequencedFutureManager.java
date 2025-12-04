package androidx.media3.session;

import android.os.Handler;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SequencedFutureManager {
    private boolean isReleased;
    private int nextSequenceNumber;
    private Runnable pendingLazyReleaseCallback;
    private Handler releaseCallbackHandler;
    private final Object lock = new Object();
    private final ArrayMap seqToFutureMap = new ArrayMap();

    public int obtainNextSequenceNumber() {
        int i;
        synchronized (this.lock) {
            i = this.nextSequenceNumber;
            this.nextSequenceNumber = i + 1;
        }
        return i;
    }

    public SequencedFuture createSequencedFuture(Object obj) {
        SequencedFuture sequencedFutureCreate;
        synchronized (this.lock) {
            try {
                int iObtainNextSequenceNumber = obtainNextSequenceNumber();
                sequencedFutureCreate = SequencedFuture.create(iObtainNextSequenceNumber, obj);
                if (this.isReleased) {
                    sequencedFutureCreate.setWithTheValueOfResultWhenClosed();
                } else {
                    this.seqToFutureMap.put(Integer.valueOf(iObtainNextSequenceNumber), sequencedFutureCreate);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sequencedFutureCreate;
    }

    public void setFutureResult(int i, Object obj) {
        synchronized (this.lock) {
            try {
                SequencedFuture sequencedFuture = (SequencedFuture) this.seqToFutureMap.remove(Integer.valueOf(i));
                if (sequencedFuture != null) {
                    if (sequencedFuture.getResultWhenClosed().getClass() == obj.getClass()) {
                        sequencedFuture.set(obj);
                    } else {
                        Log.w("SequencedFutureManager", "Type mismatch, expected " + sequencedFuture.getResultWhenClosed().getClass() + ", but was " + obj.getClass());
                    }
                }
                if (this.pendingLazyReleaseCallback != null && this.seqToFutureMap.isEmpty()) {
                    release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void release() {
        ArrayList arrayList;
        synchronized (this.lock) {
            try {
                this.isReleased = true;
                arrayList = new ArrayList(this.seqToFutureMap.values());
                this.seqToFutureMap.clear();
                if (this.pendingLazyReleaseCallback != null) {
                    ((Handler) Assertions.checkNotNull(this.releaseCallbackHandler)).post(this.pendingLazyReleaseCallback);
                    this.pendingLazyReleaseCallback = null;
                    this.releaseCallbackHandler = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).setWithTheValueOfResultWhenClosed();
        }
    }

    public void lazyRelease(long j, Runnable runnable) {
        synchronized (this.lock) {
            try {
                Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper();
                this.releaseCallbackHandler = handlerCreateHandlerForCurrentLooper;
                this.pendingLazyReleaseCallback = runnable;
                if (this.seqToFutureMap.isEmpty()) {
                    release();
                } else {
                    handlerCreateHandlerForCurrentLooper.postDelayed(new Runnable() { // from class: androidx.media3.session.SequencedFutureManager$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.release();
                        }
                    }, j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final class SequencedFuture<T> extends AbstractFuture<T> {
        private final Object resultWhenClosed;
        private final int sequenceNumber;

        private SequencedFuture(int i, Object obj) {
            this.sequenceNumber = i;
            this.resultWhenClosed = obj;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(T t) {
            return super.set(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setWithTheValueOfResultWhenClosed() {
            set(this.resultWhenClosed);
        }

        public int getSequenceNumber() {
            return this.sequenceNumber;
        }

        public T getResultWhenClosed() {
            return (T) this.resultWhenClosed;
        }

        public static <T> SequencedFuture<T> create(int i, T t) {
            return new SequencedFuture<>(i, t);
        }
    }
}
