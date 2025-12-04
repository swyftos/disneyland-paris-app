package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes4.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    private transient Converter reverse;

    @ForOverride
    protected abstract A doBackward(B b);

    @ForOverride
    protected abstract B doForward(A a);

    protected Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    @CheckForNull
    public final B convert(@CheckForNull A a) {
        return (B) correctedDoForward(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Object correctedDoForward(Object obj) {
        if (!this.handleNullAutomatically) {
            return unsafeDoForward(obj);
        }
        if (obj == 0) {
            return null;
        }
        return Preconditions.checkNotNull(doForward(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    Object correctedDoBackward(Object obj) {
        if (!this.handleNullAutomatically) {
            return unsafeDoBackward(obj);
        }
        if (obj == 0) {
            return null;
        }
        return Preconditions.checkNotNull(doBackward(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object unsafeDoForward(Object obj) {
        return doForward(NullnessCasts.uncheckedCastNullableTToT(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object unsafeDoBackward(Object obj) {
        return doBackward(NullnessCasts.uncheckedCastNullableTToT(obj));
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable() { // from class: com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return new Iterator() { // from class: com.google.common.base.Converter.1.1
                    private final Iterator fromIterator;

                    {
                        this.fromIterator = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Iterator
                    public Object next() {
                        return Converter.this.convert(this.fromIterator.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    private static final class ReverseConverter extends Converter implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter original;

        ReverseConverter(Converter converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        protected Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        Object correctedDoForward(Object obj) {
            return this.original.correctedDoBackward(obj);
        }

        @Override // com.google.common.base.Converter
        Object correctedDoBackward(Object obj) {
            return this.original.correctedDoForward(obj);
        }

        @Override // com.google.common.base.Converter
        public Converter reverse() {
            return this.original;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    Converter doAndThen(Converter converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    private static final class ConverterComposition extends Converter implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter first;
        final Converter second;

        ConverterComposition(Converter converter, Converter converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        protected Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        Object correctedDoForward(Object obj) {
            return this.second.correctedDoForward(this.first.correctedDoForward(obj));
        }

        @Override // com.google.common.base.Converter
        Object correctedDoBackward(Object obj) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(obj));
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    @Override // com.google.common.base.Function
    @InlineMe(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a) {
        return convert(a);
    }

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    private static final class FunctionBasedConverter extends Converter implements Serializable {
        private final Function backwardFunction;
        private final Function forwardFunction;

        private FunctionBasedConverter(Function function, Function function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        protected Object doForward(Object obj) {
            return this.forwardFunction.apply(obj);
        }

        @Override // com.google.common.base.Converter
        protected Object doBackward(Object obj) {
            return this.backwardFunction.apply(obj);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    public static <T> Converter<T, T> identity() {
        return (IdentityConverter) IdentityConverter.INSTANCE;
    }

    private static final class IdentityConverter extends Converter implements Serializable {
        static final Converter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Converter
        protected Object doBackward(Object obj) {
            return obj;
        }

        @Override // com.google.common.base.Converter
        protected Object doForward(Object obj) {
            return obj;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter reverse() {
            return this;
        }

        private IdentityConverter() {
        }

        @Override // com.google.common.base.Converter
        Converter doAndThen(Converter converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
