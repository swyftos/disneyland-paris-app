package org.apache.commons.lang3.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils$$ExternalSyntheticLambda0;
import org.apache.commons.lang3.Streams$ArrayCollector$$ExternalSyntheticLambda2;
import org.apache.commons.lang3.Streams$ArrayCollector$$ExternalSyntheticLambda3;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailablePredicate;

/* JADX INFO: loaded from: classes6.dex */
public class Streams {

    public static class ArrayCollector<E> implements Collector<E, List<E>, E[]> {
        private static final Set characteristics = Collections.emptySet();
        private final Class elementType;

        public ArrayCollector(Class<E> cls) {
            Objects.requireNonNull(cls, "elementType");
            this.elementType = cls;
        }

        @Override // java.util.stream.Collector
        public BiConsumer<List<E>, E> accumulator() {
            return new Streams$ArrayCollector$$ExternalSyntheticLambda2();
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return characteristics;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<List<E>> combiner() {
            return new BinaryOperator() { // from class: org.apache.commons.lang3.stream.Streams$ArrayCollector$$ExternalSyntheticLambda1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Streams.ArrayCollector.lambda$combiner$0((List) obj, (List) obj2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$combiner$0(List list, List list2) {
            list.addAll(list2);
            return list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object[] lambda$finisher$0(List list) {
            return list.toArray(ArrayUtils.newInstance(this.elementType, list.size()));
        }

        @Override // java.util.stream.Collector
        public Function<List<E>, E[]> finisher() {
            return new Function() { // from class: org.apache.commons.lang3.stream.Streams$ArrayCollector$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$finisher$0((List) obj);
                }
            };
        }

        @Override // java.util.stream.Collector
        public Supplier<List<E>> supplier() {
            return new Streams$ArrayCollector$$ExternalSyntheticLambda3();
        }
    }

    private static final class EnumerationSpliterator extends Spliterators.AbstractSpliterator {
        private final Enumeration enumeration;

        protected EnumerationSpliterator(long j, int i, Enumeration enumeration) {
            super(j, i);
            Objects.requireNonNull(enumeration, "enumeration");
            this.enumeration = enumeration;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            while (this.enumeration.hasMoreElements()) {
                next(consumer);
            }
        }

        private boolean next(Consumer consumer) {
            consumer.accept(this.enumeration.nextElement());
            return true;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer consumer) {
            return this.enumeration.hasMoreElements() && next(consumer);
        }
    }

    public static class FailableStream<T> {
        private Stream stream;
        private boolean terminated;

        public FailableStream(Stream<T> stream) {
            this.stream = stream;
        }

        public boolean allMatch(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            return stream().allMatch(Failable.asPredicate(failablePredicate));
        }

        public boolean anyMatch(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            return stream().anyMatch(Failable.asPredicate(failablePredicate));
        }

        protected void assertNotTerminated() {
            if (this.terminated) {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        public <A, R> R collect(Collector<? super T, A, R> collector) {
            makeTerminated();
            return (R) stream().collect(collector);
        }

        public <A, R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer2) {
            makeTerminated();
            return (R) stream().collect(supplier, biConsumer, biConsumer2);
        }

        public FailableStream<T> filter(FailablePredicate<T, ?> failablePredicate) {
            assertNotTerminated();
            this.stream = this.stream.filter(Failable.asPredicate(failablePredicate));
            return this;
        }

        public void forEach(FailableConsumer<T, ?> failableConsumer) {
            makeTerminated();
            stream().forEach(Failable.asConsumer(failableConsumer));
        }

        protected void makeTerminated() {
            assertNotTerminated();
            this.terminated = true;
        }

        public <R> FailableStream<R> map(FailableFunction<T, R, ?> failableFunction) {
            assertNotTerminated();
            return new FailableStream<>(this.stream.map(Failable.asFunction(failableFunction)));
        }

        public T reduce(T t, BinaryOperator<T> binaryOperator) {
            makeTerminated();
            return stream().reduce(t, binaryOperator);
        }

        public Stream<T> stream() {
            return this.stream;
        }
    }

    public static <T> FailableStream<T> failableStream(Collection<T> collection) {
        return failableStream(m1969of((Collection) collection));
    }

    public static <T> FailableStream<T> failableStream(Stream<T> stream) {
        return new FailableStream<>(stream);
    }

    public static <T> FailableStream<T> failableStream(T t) {
        return failableStream(streamOf(t));
    }

    @SafeVarargs
    public static <T> FailableStream<T> failableStream(T... tArr) {
        return failableStream(m1973of(tArr));
    }

    public static <E> Stream<E> instancesOf(Class<? super E> cls, Collection<? super E> collection) {
        return instancesOf(cls, m1969of((Collection) collection));
    }

    private static Stream instancesOf(final Class cls, Stream stream) {
        Stream streamM1972of = m1972of(stream);
        Objects.requireNonNull(cls);
        return streamM1972of.filter(new Predicate() { // from class: org.apache.commons.lang3.stream.Streams$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance(obj);
            }
        });
    }

    public static <E> Stream<E> nonNull(Collection<E> collection) {
        return m1969of((Collection) collection).filter(new ObjectUtils$$ExternalSyntheticLambda0());
    }

    public static <E> Stream<E> nonNull(E e) {
        return nonNull(streamOf(e));
    }

    @SafeVarargs
    public static <E> Stream<E> nonNull(E... eArr) {
        return nonNull(m1973of(eArr));
    }

    public static <E> Stream<E> nonNull(Stream<E> stream) {
        return m1972of(stream).filter(new ObjectUtils$$ExternalSyntheticLambda0());
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m1969of(Collection<E> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m1970of(Enumeration<E> enumeration) {
        return StreamSupport.stream(new EnumerationSpliterator(Long.MAX_VALUE, 16, enumeration), false);
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m1968of(Iterable<E> iterable) {
        return iterable == null ? Stream.empty() : StreamSupport.stream(iterable.spliterator(), false);
    }

    /* JADX INFO: renamed from: of */
    public static <E> Stream<E> m1971of(Iterator<E> it) {
        return it == null ? Stream.empty() : StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 16), false);
    }

    /* JADX INFO: renamed from: of */
    private static Stream m1972of(Stream stream) {
        return stream == null ? Stream.empty() : stream;
    }

    @SafeVarargs
    /* JADX INFO: renamed from: of */
    public static <T> Stream<T> m1973of(T... tArr) {
        return tArr == null ? Stream.empty() : Stream.of((Object[]) tArr);
    }

    @Deprecated
    public static <E> FailableStream<E> stream(Collection<E> collection) {
        return failableStream((Collection) collection);
    }

    @Deprecated
    public static <T> FailableStream<T> stream(Stream<T> stream) {
        return failableStream((Stream) stream);
    }

    private static Stream streamOf(Object obj) {
        return obj == null ? Stream.empty() : Stream.of(obj);
    }

    public static <T> Collector<T, List<T>, T[]> toArray(Class<T> cls) {
        return new ArrayCollector(cls);
    }

    @Deprecated
    public Streams() {
    }
}
