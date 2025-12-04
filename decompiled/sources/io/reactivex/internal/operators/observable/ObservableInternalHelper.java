package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableInternalHelper {

    static final class SimpleGenerator implements BiFunction {
        final Consumer consumer;

        SimpleGenerator(Consumer consumer) {
            this.consumer = consumer;
        }

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Emitter emitter) throws Exception {
            this.consumer.accept(emitter);
            return obj;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    static final class SimpleBiGenerator implements BiFunction {
        final BiConsumer consumer;

        SimpleBiGenerator(BiConsumer biConsumer) {
            this.consumer = biConsumer;
        }

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Emitter emitter) throws Exception {
            this.consumer.accept(obj, emitter);
            return obj;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    static final class ItemDelayFunction implements Function {
        final Function itemDelay;

        ItemDelayFunction(Function function) {
            this.itemDelay = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource apply(Object obj) {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(obj), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
        }
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    static final class ObserverOnNext implements Consumer {
        final Observer observer;

        ObserverOnNext(Observer observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.observer.onNext(obj);
        }
    }

    static final class ObserverOnError implements Consumer {
        final Observer observer;

        ObserverOnError(Observer observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.observer.onError(th);
        }
    }

    static final class ObserverOnComplete implements Action {
        final Observer observer;

        ObserverOnComplete(Observer observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            this.observer.onComplete();
        }
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    static final class FlatMapWithCombinerInner implements Function {
        private final BiFunction combiner;
        private final Object t;

        FlatMapWithCombinerInner(BiFunction biFunction, Object obj) {
            this.combiner = biFunction;
            this.t = obj;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.combiner.apply(this.t, obj);
        }
    }

    static final class FlatMapWithCombinerOuter implements Function {
        private final BiFunction combiner;
        private final Function mapper;

        FlatMapWithCombinerOuter(BiFunction biFunction, Function function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource apply(Object obj) {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, obj));
        }
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    static final class FlatMapIntoIterable implements Function {
        private final Function mapper;

        FlatMapIntoIterable(Function function) {
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource apply(Object obj) {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i) {
        return new BufferedReplayCallable(observable, i);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    static final class ZipIterableFunction implements Function {
        private final Function zipper;

        ZipIterableFunction(Function function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource apply(List list) {
            return Observable.zipIterable(list, this.zipper, false, Observable.bufferSize());
        }
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    static final class ReplayCallable implements Callable {
        private final Observable parent;

        ReplayCallable(Observable observable) {
            this.parent = observable;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            return this.parent.replay();
        }
    }

    static final class BufferedReplayCallable implements Callable {
        private final int bufferSize;
        private final Observable parent;

        BufferedReplayCallable(Observable observable, int i) {
            this.parent = observable;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    static final class BufferedTimedReplayCallable implements Callable {
        private final int bufferSize;
        private final Observable parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplayCallable(Observable observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = observable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    static final class TimedReplayCallable implements Callable {
        private final Observable parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplayCallable(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = observable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    static final class ReplayFunction implements Function {
        private final Scheduler scheduler;
        private final Function selector;

        ReplayFunction(Function function, Scheduler scheduler) {
            this.selector = function;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource apply(Observable observable) {
            return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }
}
