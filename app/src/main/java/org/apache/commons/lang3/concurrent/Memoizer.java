package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Memoizer<I, O> implements Computable<I, O> {
    private final ConcurrentMap cache;
    private final Function mappingFunction;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this((Computable) computable, false);
    }

    public Memoizer(final Computable<I, O> computable, boolean z) {
        this.cache = new ConcurrentHashMap();
        this.recalculate = z;
        this.mappingFunction = new Function() { // from class: org.apache.commons.lang3.concurrent.Memoizer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Memoizer.lambda$new$0(computable, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Future lambda$new$0(final Computable computable, final Object obj) {
        return FutureTasks.run(new Callable() { // from class: org.apache.commons.lang3.concurrent.Memoizer$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return computable.compute(obj);
            }
        });
    }

    public Memoizer(Function<I, O> function) {
        this((Function) function, false);
    }

    public Memoizer(final Function<I, O> function, boolean z) {
        this.cache = new ConcurrentHashMap();
        this.recalculate = z;
        this.mappingFunction = new Function() { // from class: org.apache.commons.lang3.concurrent.Memoizer$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Memoizer.lambda$new$2(function, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Future lambda$new$2(final Function function, final Object obj) {
        return FutureTasks.run(new Callable() { // from class: org.apache.commons.lang3.concurrent.Memoizer$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return function.apply(obj);
            }
        });
    }

    @Override // org.apache.commons.lang3.concurrent.Computable
    public O compute(I i) throws InterruptedException {
        while (true) {
            Future future = (Future) this.cache.computeIfAbsent(i, this.mappingFunction);
            try {
                return (O) future.get();
            } catch (CancellationException unused) {
                this.cache.remove(i, future);
            } catch (ExecutionException e) {
                if (this.recalculate) {
                    this.cache.remove(i, future);
                }
                throw this.launderException(e.getCause());
            }
        }
    }

    private RuntimeException launderException(Throwable th) {
        throw new IllegalStateException("Unchecked exception", ExceptionUtils.throwUnchecked(th));
    }
}
