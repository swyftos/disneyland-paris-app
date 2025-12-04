package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableInternalHelper {

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
        public Publisher apply(Object obj) {
            return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.itemDelay.apply(obj), "The itemDelay returned a null Publisher"), 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
        }
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    static final class SubscriberOnNext implements Consumer {
        final Subscriber subscriber;

        SubscriberOnNext(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.subscriber.onNext(obj);
        }
    }

    static final class SubscriberOnError implements Consumer {
        final Subscriber subscriber;

        SubscriberOnError(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.subscriber.onError(th);
        }
    }

    static final class SubscriberOnComplete implements Action {
        final Subscriber subscriber;

        SubscriberOnComplete(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            this.subscriber.onComplete();
        }
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
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
        public Publisher apply(Object obj) {
            return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, obj));
        }
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    static final class FlatMapIntoIterable implements Function {
        private final Function mapper;

        FlatMapIntoIterable(Function function) {
            this.mapper = function;
        }

        @Override // io.reactivex.functions.Function
        public Publisher apply(Object obj) {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable) {
        return new ReplayCallable(flowable);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i) {
        return new BufferedReplayCallable(flowable, i);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(flowable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(flowable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    static final class ZipIterableFunction implements Function {
        private final Function zipper;

        ZipIterableFunction(Function function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public Publisher apply(List list) {
            return Flowable.zipIterable(list, this.zipper, false, Flowable.bufferSize());
        }
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    static final class ReplayCallable implements Callable {
        private final Flowable parent;

        ReplayCallable(Flowable flowable) {
            this.parent = flowable;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            return this.parent.replay();
        }
    }

    static final class BufferedReplayCallable implements Callable {
        private final int bufferSize;
        private final Flowable parent;

        BufferedReplayCallable(Flowable flowable, int i) {
            this.parent = flowable;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    static final class BufferedTimedReplay implements Callable {
        private final int bufferSize;
        private final Flowable parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplay(Flowable flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = flowable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    static final class TimedReplay implements Callable {
        private final Flowable parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplay(Flowable flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = flowable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
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
        public Publisher apply(Flowable flowable) {
            return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(flowable), "The selector returned a null Publisher")).observeOn(this.scheduler);
        }
    }
}
