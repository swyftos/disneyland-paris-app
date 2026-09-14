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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.a1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2692a1<T> {

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Logger f2357f = new Logger("DeferredResult");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2652V6 f2358a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f2359b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ArrayBlockingQueue<a<T>> f2360c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ReentrantLock f2361d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Condition f2362e;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.a1$a */
    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.a1$a$a, reason: collision with other inner class name */
        public static final class C8142a<T> extends a<T> {

            /* JADX INFO: renamed from: a */
            @NotNull
            public final String f2363a;

            public C8142a(@NotNull String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.f2363a = message;
            }
        }

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.a1$a$b */
        public static final class b<T> extends a<T> {

            /* JADX INFO: renamed from: a */
            public final T f2364a;

            public b(T t) {
                this.f2364a = t;
            }
        }
    }

    public C2692a1() {
        C2652V6 systemClockInstantiable = new C2652V6();
        Logger logger = f2357f;
        Intrinsics.checkNotNullParameter(systemClockInstantiable, "systemClockInstantiable");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f2358a = systemClockInstantiable;
        this.f2359b = logger;
        this.f2360c = new ArrayBlockingQueue<>(1, true);
        ReentrantLock reentrantLock = new ReentrantLock(true);
        this.f2361d = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "lock.newCondition()");
        this.f2362e = conditionNewCondition;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1081a() {
        T t;
        this.f2361d.lock();
        try {
            this.f2358a.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime + 1000;
            while (this.f2360c.peek() == null && jElapsedRealtime <= j) {
                try {
                    this.f2362e.await(j - jElapsedRealtime, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    this.f2359b.m830e(e, "await has been interrupted");
                }
                this.f2358a.getClass();
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            a<T> aVarPeek = this.f2360c.peek();
            if (aVarPeek instanceof a.b) {
                t = ((a.b) aVarPeek).f2364a;
            } else {
                if (aVarPeek instanceof a.C8142a) {
                    this.f2359b.m834w(((a.C8142a) aVarPeek).f2363a);
                } else {
                    if (aVarPeek != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.f2359b.m834w("Operation timed out: no result has been set within 1000ms");
                }
                t = null;
            }
            this.f2361d.unlock();
            return t;
        } catch (Throwable th) {
            this.f2361d.unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1083a(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f2361d.lock();
        try {
            if (this.f2360c.offer(new a.C8142a(message))) {
                this.f2362e.signal();
            }
        } finally {
            this.f2361d.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1082a(T t) {
        this.f2361d.lock();
        try {
            if (this.f2360c.offer(new a.b(t))) {
                this.f2362e.signal();
            }
        } finally {
            this.f2361d.unlock();
        }
    }
}
