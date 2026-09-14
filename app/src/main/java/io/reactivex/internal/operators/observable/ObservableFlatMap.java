package io.reactivex.internal.operators.observable;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream {
    final int bufferSize;
    final boolean delayErrors;
    final Function mapper;
    final int maxConcurrency;

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeObserver(observer, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    static final class MergeObserver extends AtomicInteger implements Disposable, Observer {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function mapper;
        final int maxConcurrency;
        final AtomicReference observers;
        volatile SimplePlainQueue queue;
        Queue sources;
        long uniqueId;
        Disposable upstream;
        int wip;
        static final InnerObserver[] EMPTY = new InnerObserver[0];
        static final InnerObserver[] CANCELLED = new InnerObserver[0];

        MergeObserver(Observer observer, Function function, boolean z, int i, int i2) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference(EMPTY);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (this.done) {
                return;
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i = this.wip;
                            if (i == this.maxConcurrency) {
                                this.sources.offer(observableSource);
                                return;
                            }
                            this.wip = i + 1;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                subscribeInner(observableSource);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        void subscribeInner(ObservableSource observableSource) {
            boolean z;
            while (observableSource instanceof Callable) {
                if (!tryEmitScalar((Callable) observableSource) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        observableSource = (ObservableSource) this.sources.poll();
                        if (observableSource == null) {
                            z = true;
                            this.wip--;
                        } else {
                            z = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    drain();
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver innerObserver = new InnerObserver(this, j);
            if (addInner(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        boolean addInner(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m87m(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        void removeInner(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerObserverArr[i] == innerObserver) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m87m(this.observers, innerObserverArr, innerObserverArr2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean tryEmitScalar(Callable callable) {
            SimplePlainQueue spscArrayQueue;
            try {
                Object objCall = callable.call();
                if (objCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(objCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue simplePlainQueue = this.queue;
                    SimplePlainQueue simplePlainQueue2 = simplePlainQueue;
                    if (simplePlainQueue == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            spscArrayQueue = new SpscLinkedArrayQueue(this.bufferSize);
                        } else {
                            spscArrayQueue = new SpscArrayQueue(this.maxConcurrency);
                        }
                        this.queue = spscArrayQueue;
                        simplePlainQueue2 = spscArrayQueue;
                    }
                    if (!simplePlainQueue2.offer(objCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.errors.addThrowable(th);
                drain();
                return true;
            }
        }

        void tryEmit(Object obj, InnerObserver innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue spscLinkedArrayQueue = innerObserver.queue;
                if (spscLinkedArrayQueue == null) {
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.bufferSize);
                    innerObserver.queue = spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue.offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable thTerminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (thTerminate = this.errors.terminate()) == null || thTerminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(thTerminate);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code duplicated, block: B:121:0x00ea A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:134:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:85:0x00f1 A[PHI: r4
  0x00f1: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:72:0x00d0, B:84:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            int size;
            boolean z;
            Observer observer = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                SimplePlainQueue simplePlainQueue = this.queue;
                if (simplePlainQueue != null) {
                    while (!checkTerminate()) {
                        Object objPoll = simplePlainQueue.poll();
                        if (objPoll != null) {
                            observer.onNext(objPoll);
                        }
                    }
                    return;
                }
                boolean z2 = this.done;
                SimplePlainQueue simplePlainQueue2 = this.queue;
                InnerObserver[] innerObserverArr = (InnerObserver[]) this.observers.get();
                int length = innerObserverArr.length;
                int i = 0;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        size = this.sources.size();
                    }
                } else {
                    size = 0;
                }
                if (z2 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && size == 0)) {
                    Throwable thTerminate = this.errors.terminate();
                    if (thTerminate != ExceptionHelper.TERMINATED) {
                        if (thTerminate == null) {
                            observer.onComplete();
                            return;
                        } else {
                            observer.onError(thTerminate);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j = this.lastId;
                    int i2 = this.lastIndex;
                    if (length <= i2 || innerObserverArr[i2].f3887id != j) {
                        if (length <= i2) {
                            i2 = 0;
                        }
                        for (int i3 = 0; i3 < length && innerObserverArr[i2].f3887id != j; i3++) {
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                        }
                        this.lastIndex = i2;
                        this.lastId = innerObserverArr[i2].f3887id;
                    }
                    int i4 = 0;
                    for (int i5 = 0; i5 < length; i5++) {
                        if (checkTerminate()) {
                            return;
                        }
                        InnerObserver innerObserver = innerObserverArr[i2];
                        SimpleQueue simpleQueue = innerObserver.queue;
                        if (simpleQueue != null) {
                            do {
                                try {
                                    Object objPoll2 = simpleQueue.poll();
                                    if (objPoll2 != null) {
                                        observer.onNext(objPoll2);
                                    } else {
                                        z = innerObserver.done;
                                        SimpleQueue simpleQueue2 = innerObserver.queue;
                                        if (z && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                            removeInner(innerObserver);
                                            if (checkTerminate()) {
                                                return;
                                            } else {
                                                i4++;
                                            }
                                        }
                                        i2++;
                                        if (i2 == length) {
                                            i2 = 0;
                                        }
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    innerObserver.dispose();
                                    this.errors.addThrowable(th);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    removeInner(innerObserver);
                                    i4++;
                                    i2++;
                                    if (i2 == length) {
                                    }
                                }
                            } while (!checkTerminate());
                            return;
                        }
                        z = innerObserver.done;
                        SimpleQueue simpleQueue3 = innerObserver.queue;
                        if (z) {
                            removeInner(innerObserver);
                            if (checkTerminate()) {
                                return;
                            } else {
                                i4++;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                    }
                    this.lastIndex = i2;
                    this.lastId = innerObserverArr[i2].f3887id;
                    i = i4;
                }
                if (i != 0) {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        while (true) {
                            int i6 = i - 1;
                            if (i != 0) {
                                synchronized (this) {
                                    try {
                                        ObservableSource observableSource = (ObservableSource) this.sources.poll();
                                        if (observableSource == null) {
                                            this.wip--;
                                        } else {
                                            subscribeInner(observableSource);
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                i = i6;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            Throwable thTerminate = this.errors.terminate();
            if (thTerminate != ExceptionHelper.TERMINATED) {
                this.downstream.onError(thTerminate);
            }
            return true;
        }

        boolean disposeAll() {
            InnerObserver[] innerObserverArr;
            this.upstream.dispose();
            InnerObserver[] innerObserverArr2 = (InnerObserver[]) this.observers.get();
            InnerObserver[] innerObserverArr3 = CANCELLED;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.observers.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver innerObserver : innerObserverArr) {
                innerObserver.dispose();
            }
            return true;
        }
    }

    static final class InnerObserver extends AtomicReference implements Observer {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* JADX INFO: renamed from: id */
        final long f3887id;
        final MergeObserver parent;
        volatile SimpleQueue queue;

        InnerObserver(MergeObserver mergeObserver, long j) {
            this.f3887id = j;
            this.parent = mergeObserver;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int iRequestFusion = queueDisposable.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = queueDisposable;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(obj, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.parent.errors.addThrowable(th)) {
                MergeObserver mergeObserver = this.parent;
                if (!mergeObserver.delayErrors) {
                    mergeObserver.disposeAll();
                }
                this.done = true;
                this.parent.drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
