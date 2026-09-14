package org.apache.commons.lang3.stream;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes6.dex */
public final class LangCollectors {
    private static final Set CH_NOID = Collections.emptySet();

    private static final class SimpleCollector implements Collector {
        private final BiConsumer accumulator;
        private final Set characteristics;
        private final BinaryOperator combiner;
        private final Function finisher;
        private final Supplier supplier;

        private SimpleCollector(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
            this.supplier = supplier;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.finisher = function;
            this.characteristics = set;
        }

        @Override // java.util.stream.Collector
        public BiConsumer accumulator() {
            return this.accumulator;
        }

        @Override // java.util.stream.Collector
        public Set characteristics() {
            return this.characteristics;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator combiner() {
            return this.combiner;
        }

        @Override // java.util.stream.Collector
        public Function finisher() {
            return this.finisher;
        }

        @Override // java.util.stream.Collector
        public Supplier supplier() {
            return this.supplier;
        }
    }

    @SafeVarargs
    public static <T, R, A> R collect(Collector<? super T, A, R> collector, T... tArr) {
        return (R) Streams.m1973of(tArr).collect(collector);
    }

    public static Collector<Object, ?, String> joining() {
        return new SimpleCollector(new Supplier() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new StringBuilder();
            }
        }, new BiConsumer() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringBuilder) obj).append(obj2);
            }
        }, new BinaryOperator() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                StringBuilder sb = (StringBuilder) obj;
                sb.append((CharSequence) obj2);
                return sb;
            }
        }, new Function() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringBuilder) obj).toString();
            }
        }, CH_NOID);
    }

    public static Collector<Object, ?, String> joining(CharSequence charSequence) {
        return joining(charSequence, "", "");
    }

    public static Collector<Object, ?, String> joining(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return joining(charSequence, charSequence2, charSequence3, new ReflectionToStringBuilder$$ExternalSyntheticLambda0());
    }

    public static Collector<Object, ?, String> joining(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final Function<Object, String> function) {
        return new SimpleCollector(new Supplier() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return LangCollectors.lambda$joining$0(charSequence, charSequence2, charSequence3);
            }
        }, new BiConsumer() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                LangCollectors.lambda$joining$1(function, (StringJoiner) obj, obj2);
            }
        }, new BinaryOperator() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((StringJoiner) obj).merge((StringJoiner) obj2);
            }
        }, new Function() { // from class: org.apache.commons.lang3.stream.LangCollectors$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringJoiner) obj).toString();
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StringJoiner lambda$joining$0(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$joining$1(Function function, StringJoiner stringJoiner, Object obj) {
        stringJoiner.add((CharSequence) function.apply(obj));
    }
}
