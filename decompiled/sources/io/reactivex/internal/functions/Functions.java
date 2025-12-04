package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class Functions {
    static final Function IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer EMPTY_CONSUMER = new EmptyConsumer();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    static final Predicate ALWAYS_TRUE = new TruePredicate();
    static final Predicate ALWAYS_FALSE = new FalsePredicate();
    static final Callable NULL_SUPPLIER = new NullCallable();
    static final Comparator NATURAL_COMPARATOR = new NaturalObjectComparator();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.requireNonNull(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.requireNonNull(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.requireNonNull(function6, "f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.requireNonNull(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.requireNonNull(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.requireNonNull(function9, "f is null");
        return new Array9Func(function9);
    }

    public static <T> Function<T, T> identity() {
        return IDENTITY;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return EMPTY_CONSUMER;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return ALWAYS_TRUE;
    }

    public static <T> Predicate<T> alwaysFalse() {
        return ALWAYS_FALSE;
    }

    public static <T> Callable<T> nullSupplier() {
        return NULL_SUPPLIER;
    }

    public static <T> Comparator<T> naturalOrder() {
        return NATURAL_COMPARATOR;
    }

    static final class FutureAction implements Action {
        final Future future;

        FutureAction(Future future) {
            this.future = future;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws ExecutionException, InterruptedException {
            this.future.get();
        }
    }

    public static Action futureAction(Future<?> future) {
        return new FutureAction(future);
    }

    static final class JustValue implements Callable, Function {
        final Object value;

        JustValue(Object obj) {
            this.value = obj;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.value;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.value;
        }
    }

    public static <T> Callable<T> justCallable(T t) {
        return new JustValue(t);
    }

    public static <T, U> Function<T, U> justFunction(U u) {
        return new JustValue(u);
    }

    static final class CastToClass implements Function {
        final Class clazz;

        CastToClass(Class cls) {
            this.clazz = cls;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.clazz.cast(obj);
        }
    }

    public static <T, U> Function<T, U> castFunction(Class<U> cls) {
        return new CastToClass(cls);
    }

    static final class ArrayListCapacityCallable implements Callable {
        final int capacity;

        ArrayListCapacityCallable(int i) {
            this.capacity = i;
        }

        @Override // java.util.concurrent.Callable
        public List call() {
            return new ArrayList(this.capacity);
        }
    }

    public static <T> Callable<List<T>> createArrayList(int i) {
        return new ArrayListCapacityCallable(i);
    }

    static final class EqualsPredicate implements Predicate {
        final Object value;

        EqualsPredicate(Object obj) {
            this.value = obj;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return ObjectHelper.equals(obj, this.value);
        }
    }

    public static <T> Predicate<T> equalsWith(T t) {
        return new EqualsPredicate(t);
    }

    enum HashSetCallable implements Callable {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set call() {
            return new HashSet();
        }
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    static final class NotificationOnNext implements Consumer {
        final Consumer onNotification;

        NotificationOnNext(Consumer consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
            this.onNotification.accept(Notification.createOnNext(obj));
        }
    }

    static final class NotificationOnError implements Consumer {
        final Consumer onNotification;

        NotificationOnError(Consumer consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.onNotification.accept(Notification.createOnError(th));
        }
    }

    static final class NotificationOnComplete implements Action {
        final Consumer onNotification;

        NotificationOnComplete(Consumer consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.onNotification.accept(Notification.createOnComplete());
        }
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    static final class ActionConsumer implements Consumer {
        final Action action;

        ActionConsumer(Action action) {
            this.action = action;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
            this.action.run();
        }
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new ActionConsumer(action);
    }

    static final class ClassFilter implements Predicate {
        final Class clazz;

        ClassFilter(Class cls) {
            this.clazz = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.clazz.isInstance(obj);
        }
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new ClassFilter(cls);
    }

    static final class BooleanSupplierPredicateReverse implements Predicate {
        final BooleanSupplier supplier;

        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.supplier = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return !this.supplier.getAsBoolean();
        }
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    static final class TimestampFunction implements Function {
        final Scheduler scheduler;
        final TimeUnit unit;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public Timed apply(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    static final class ToMapKeySelector implements BiConsumer {
        private final Function keySelector;

        ToMapKeySelector(Function function) {
            this.keySelector = function;
        }

        @Override // io.reactivex.functions.BiConsumer
        public void accept(Map map, Object obj) {
            map.put(this.keySelector.apply(obj), obj);
        }
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    static final class ToMapKeyValueSelector implements BiConsumer {
        private final Function keySelector;
        private final Function valueSelector;

        ToMapKeyValueSelector(Function function, Function function2) {
            this.valueSelector = function;
            this.keySelector = function2;
        }

        @Override // io.reactivex.functions.BiConsumer
        public void accept(Map map, Object obj) {
            map.put(this.keySelector.apply(obj), this.valueSelector.apply(obj));
        }
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    static final class ToMultimapKeyValueSelector implements BiConsumer {
        private final Function collectionFactory;
        private final Function keySelector;
        private final Function valueSelector;

        ToMultimapKeyValueSelector(Function function, Function function2, Function function3) {
            this.collectionFactory = function;
            this.valueSelector = function2;
            this.keySelector = function3;
        }

        @Override // io.reactivex.functions.BiConsumer
        public void accept(Map map, Object obj) throws Exception {
            Object objApply = this.keySelector.apply(obj);
            Collection collection = (Collection) map.get(objApply);
            if (collection == null) {
                collection = (Collection) this.collectionFactory.apply(objApply);
                map.put(objApply, collection);
            }
            collection.add(this.valueSelector.apply(obj));
        }
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    enum NaturalComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    static final class ListSorter implements Function {
        final Comparator comparator;

        ListSorter(Comparator comparator) {
            this.comparator = comparator;
        }

        @Override // io.reactivex.functions.Function
        public List apply(List list) {
            Collections.sort(list, this.comparator);
            return list;
        }
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    static final class Array2Func implements Function {
        final BiFunction f;

        Array2Func(BiFunction biFunction) {
            this.f = biFunction;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1]);
        }
    }

    static final class Array3Func implements Function {
        final Function3 f;

        Array3Func(Function3 function3) {
            this.f = function3;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2]);
        }
    }

    static final class Array4Func implements Function {
        final Function4 f;

        Array4Func(Function4 function4) {
            this.f = function4;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
    }

    static final class Array5Func implements Function {
        private final Function5 f;

        Array5Func(Function5 function5) {
            this.f = function5;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
    }

    static final class Array6Func implements Function {
        final Function6 f;

        Array6Func(Function6 function6) {
            this.f = function6;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
    }

    static final class Array7Func implements Function {
        final Function7 f;

        Array7Func(Function7 function7) {
            this.f = function7;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
    }

    static final class Array8Func implements Function {
        final Function8 f;

        Array8Func(Function8 function8) {
            this.f = function8;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
    }

    static final class Array9Func implements Function {
        final Function9 f;

        Array9Func(Function9 function9) {
            this.f = function9;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
    }

    static final class Identity implements Function {
        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        Identity() {
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        EmptyRunnable() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        EmptyAction() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class EmptyConsumer implements Consumer {
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        EmptyConsumer() {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class ErrorConsumer implements Consumer {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    static final class OnErrorMissingConsumer implements Consumer {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        @Override // io.reactivex.functions.LongConsumer
        public void accept(long j) {
        }

        EmptyLongConsumer() {
        }
    }

    static final class TruePredicate implements Predicate {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }

        TruePredicate() {
        }
    }

    static final class FalsePredicate implements Predicate {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }

        FalsePredicate() {
        }
    }

    static final class NullCallable implements Callable {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    static final class NaturalObjectComparator implements Comparator {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class MaxRequestSubscription implements Consumer {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static <T> Consumer<T> boundedConsumer(int i) {
        return new BoundedConsumer(i);
    }

    public static class BoundedConsumer implements Consumer<Subscription> {
        final int bufferSize;

        BoundedConsumer(int i) {
            this.bufferSize = i;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(this.bufferSize);
        }
    }
}
