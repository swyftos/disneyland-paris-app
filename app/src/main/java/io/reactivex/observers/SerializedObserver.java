package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {
    final boolean delayError;
    volatile boolean done;
    final Observer downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList queue;
    Disposable upstream;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z) {
        this.downstream = observer;
        this.delayError = z;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        if (this.done) {
            return;
        }
        if (t == null) {
            this.upstream.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.done) {
                    return;
                }
                if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = this.queue;
                    if (appendOnlyLinkedArrayList2 == null) {
                        appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.queue = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                    appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                    return;
                }
                this.emitting = true;
                this.downstream.onNext(t);
                emitLoop();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.done) {
                    if (this.emitting) {
                        this.done = true;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = this.queue;
                        if (appendOnlyLinkedArrayList2 == null) {
                            appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                            this.queue = appendOnlyLinkedArrayList3;
                            appendOnlyLinkedArrayList = appendOnlyLinkedArrayList3;
                        }
                        appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                        Object objError = NotificationLite.error(th);
                        if (this.delayError) {
                            appendOnlyLinkedArrayList.add(objError);
                        } else {
                            appendOnlyLinkedArrayList.setFirst(objError);
                        }
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public void onComplete() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        if (this.done) {
            return;
        }
        synchronized (this) {
            try {
                if (this.done) {
                    return;
                }
                if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = this.queue;
                    if (appendOnlyLinkedArrayList2 == null) {
                        appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList3 = new AppendOnlyLinkedArrayList(4);
                        this.queue = appendOnlyLinkedArrayList3;
                        appendOnlyLinkedArrayList = appendOnlyLinkedArrayList3;
                    }
                    appendOnlyLinkedArrayList = appendOnlyLinkedArrayList2;
                    appendOnlyLinkedArrayList.add(NotificationLite.complete());
                    return;
                }
                this.done = true;
                this.emitting = true;
                this.downstream.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void emitLoop() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!appendOnlyLinkedArrayList.accept(this.downstream));
    }
}
