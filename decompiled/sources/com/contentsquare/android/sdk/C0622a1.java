package com.contentsquare.android.sdk;

import android.os.SystemClock;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.a1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0622a1<T> {

    @NotNull
    public static final Logger f = new Logger("DeferredResult");

    @NotNull
    public final V6 a;

    @NotNull
    public final Logger b;

    @NotNull
    public final ArrayBlockingQueue<a<T>> c;

    @NotNull
    public final ReentrantLock d;

    @NotNull
    public final Condition e;

    /* renamed from: com.contentsquare.android.sdk.a1$a */
    public static abstract class a<T> {

        /* renamed from: com.contentsquare.android.sdk.a1$a$a, reason: collision with other inner class name */
        public static final class C0046a<T> extends a<T> {

            @NotNull
            public final String a;

            public C0046a(@NotNull String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.a = message;
            }
        }

        /* renamed from: com.contentsquare.android.sdk.a1$a$b */
        public static final class b<T> extends a<T> {
            public final T a;

            public b(T t) {
                this.a = t;
            }
        }
    }

    public C0622a1() {
        V6 systemClockInstantiable = new V6();
        Logger logger = f;
        Intrinsics.checkNotNullParameter(systemClockInstantiable, "systemClockInstantiable");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = systemClockInstantiable;
        this.b = logger;
        this.c = new ArrayBlockingQueue<>(1, true);
        ReentrantLock reentrantLock = new ReentrantLock(true);
        this.d = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "lock.newCondition()");
        this.e = conditionNewCondition;
    }

    @Nullable
    public final Object a() {
        T t;
        this.d.lock();
        try {
            this.a.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime + 1000;
            while (this.c.peek() == null && jElapsedRealtime <= j) {
                try {
                    this.e.await(j - jElapsedRealtime, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    this.b.e(e, "await has been interrupted");
                }
                this.a.getClass();
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            a<T> aVarPeek = this.c.peek();
            if (aVarPeek instanceof a.b) {
                t = ((a.b) aVarPeek).a;
            } else {
                if (aVarPeek instanceof a.C0046a) {
                    this.b.w(((a.C0046a) aVarPeek).a);
                } else {
                    if (aVarPeek != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.b.w("Operation timed out: no result has been set within 1000ms");
                }
                t = null;
            }
            return t;
        } finally {
            this.d.unlock();
        }
    }

    public final void a(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.d.lock();
        try {
            if (this.c.offer(new a.C0046a(message))) {
                this.e.signal();
            }
        } finally {
            this.d.unlock();
        }
    }

    public final void a(T t) {
        this.d.lock();
        try {
            if (this.c.offer(new a.b(t))) {
                this.e.signal();
            }
        } finally {
            this.d.unlock();
        }
    }
}
