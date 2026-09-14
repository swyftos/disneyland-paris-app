package org.apache.commons.lang3;

import java.io.IOException;
import java.util.Iterator;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.UncheckedException;
import org.apache.commons.lang3.function.FailableBiConsumer;

/* JADX INFO: loaded from: classes6.dex */
public final class AppendableJoiner<T> {
    private final FailableBiConsumer appender;
    private final CharSequence delimiter;
    private final CharSequence prefix;
    private final CharSequence suffix;

    public static final class Builder<T> implements Supplier<AppendableJoiner<T>> {
        private FailableBiConsumer appender;
        private CharSequence delimiter;
        private CharSequence prefix;
        private CharSequence suffix;

        Builder() {
        }

        @Override // java.util.function.Supplier
        public AppendableJoiner<T> get() {
            return new AppendableJoiner<>(this.prefix, this.suffix, this.delimiter, this.appender);
        }

        public Builder<T> setDelimiter(CharSequence charSequence) {
            this.delimiter = charSequence;
            return this;
        }

        public Builder<T> setElementAppender(FailableBiConsumer<Appendable, T, IOException> failableBiConsumer) {
            this.appender = failableBiConsumer;
            return this;
        }

        public Builder<T> setPrefix(CharSequence charSequence) {
            this.prefix = charSequence;
            return this;
        }

        public Builder<T> setSuffix(CharSequence charSequence) {
            this.suffix = charSequence;
            return this;
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    static Appendable joinA(Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer, Object... objArr) {
        return joinArray(appendable, charSequence, charSequence2, charSequence3, failableBiConsumer, objArr);
    }

    private static Appendable joinArray(Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer, Object[] objArr) throws Throwable {
        appendable.append(charSequence);
        if (objArr != null) {
            if (objArr.length > 0) {
                failableBiConsumer.accept(appendable, objArr[0]);
            }
            for (int i = 1; i < objArr.length; i++) {
                appendable.append(charSequence3);
                failableBiConsumer.accept(appendable, objArr[i]);
            }
        }
        appendable.append(charSequence2);
        return appendable;
    }

    static StringBuilder joinI(StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer, Iterable iterable) {
        try {
            return (StringBuilder) joinIterable(sb, charSequence, charSequence2, charSequence3, failableBiConsumer, iterable);
        } catch (IOException e) {
            throw new UncheckedException(e);
        }
    }

    private static Appendable joinIterable(Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer, Iterable iterable) throws Throwable {
        appendable.append(charSequence);
        if (iterable != null) {
            Iterator<T> it = iterable.iterator();
            if (it.hasNext()) {
                failableBiConsumer.accept(appendable, it.next());
            }
            while (it.hasNext()) {
                appendable.append(charSequence3);
                failableBiConsumer.accept(appendable, it.next());
            }
        }
        appendable.append(charSequence2);
        return appendable;
    }

    static StringBuilder joinSB(StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer, Object... objArr) {
        try {
            return (StringBuilder) joinArray(sb, charSequence, charSequence2, charSequence3, failableBiConsumer, objArr);
        } catch (IOException e) {
            throw new UncheckedException(e);
        }
    }

    private static CharSequence nonNull(CharSequence charSequence) {
        return charSequence != null ? charSequence : "";
    }

    private AppendableJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, FailableBiConsumer failableBiConsumer) {
        this.prefix = nonNull(charSequence);
        this.suffix = nonNull(charSequence2);
        this.delimiter = nonNull(charSequence3);
        this.appender = failableBiConsumer == null ? new FailableBiConsumer() { // from class: org.apache.commons.lang3.AppendableJoiner$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj, Object obj2) throws IOException {
                AppendableJoiner.lambda$new$0((Appendable) obj, obj2);
            }
        } : failableBiConsumer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Appendable appendable, Object obj) throws IOException {
        appendable.append(String.valueOf(obj));
    }

    public StringBuilder join(StringBuilder sb, Iterable<T> iterable) {
        return joinI(sb, this.prefix, this.suffix, this.delimiter, this.appender, iterable);
    }

    public StringBuilder join(StringBuilder sb, T... tArr) {
        return joinSB(sb, this.prefix, this.suffix, this.delimiter, this.appender, tArr);
    }

    public <A extends Appendable> A joinA(A a2, Iterable<T> iterable) throws IOException {
        return (A) joinIterable(a2, this.prefix, this.suffix, this.delimiter, this.appender, iterable);
    }

    public <A extends Appendable> A joinA(A a2, T... tArr) throws IOException {
        return (A) joinA(a2, this.prefix, this.suffix, this.delimiter, this.appender, tArr);
    }
}
