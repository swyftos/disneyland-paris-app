package com.facebook.react.runtime;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Objects;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
class BridgelessAtomicRef<T> {
    private volatile String failureMessage;

    @Nullable
    T mInitialValue;

    @Nullable
    volatile T mValue;
    private volatile State state;

    interface Provider<T> {
        T get();
    }

    enum State {
        Init,
        Creating,
        Success,
        Failure
    }

    public BridgelessAtomicRef(@Nullable T t) {
        this.mValue = t;
        this.mInitialValue = t;
        this.state = State.Init;
        this.failureMessage = "";
    }

    public BridgelessAtomicRef() {
        this(null);
    }

    @SuppressLint({"CatchGeneralException"})
    public T getOrCreate(Provider<T> provider) {
        boolean z;
        T t;
        T t2;
        synchronized (this) {
            try {
                State state = this.state;
                State state2 = State.Success;
                if (state == state2) {
                    return get();
                }
                if (this.state == State.Failure) {
                    throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.failureMessage);
                }
                State state3 = this.state;
                State state4 = State.Creating;
                boolean z2 = false;
                if (state3 != state4) {
                    this.state = state4;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    try {
                        this.mValue = provider.get();
                        synchronized (this) {
                            this.state = state2;
                            notifyAll();
                            t = get();
                        }
                        return t;
                    } catch (RuntimeException e) {
                        synchronized (this) {
                            this.state = State.Failure;
                            this.failureMessage = Objects.toString(e.getMessage(), "null");
                            notifyAll();
                            throw new RuntimeException("BridgelessAtomicRef: Failed to create object.", e);
                        }
                    }
                }
                synchronized (this) {
                    while (this.state == State.Creating) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    if (this.state == State.Failure) {
                        throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.failureMessage);
                    }
                    t2 = get();
                }
                return t2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized T getAndReset() {
        T t;
        t = get();
        reset();
        return t;
    }

    public synchronized void reset() {
        this.mValue = this.mInitialValue;
        this.state = State.Init;
        this.failureMessage = "";
    }

    public synchronized T get() {
        return (T) Assertions.assertNotNull(this.mValue);
    }

    @Nullable
    public synchronized T getNullable() {
        return this.mValue;
    }
}
