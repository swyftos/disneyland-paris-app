package androidx.test.espresso.util;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import java.util.Set;

/* loaded from: classes2.dex */
public final class EspressoOptional<T> {
    private final Optional delegate;

    private EspressoOptional(Optional optional) {
        this.delegate = optional;
    }

    public static <T> EspressoOptional<T> absent() {
        return new EspressoOptional<>(Optional.absent());
    }

    public static <T> EspressoOptional<T> fromNullable(T t) {
        return new EspressoOptional<>(Optional.fromNullable(t));
    }

    public static <T> EspressoOptional<T> of(T t) {
        return new EspressoOptional<>(Optional.of(t));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        return Optional.presentInstances(iterable);
    }

    public Set<T> asSet() {
        return this.delegate.asSet();
    }

    public boolean equals(Object obj) {
        if (obj instanceof EspressoOptional) {
            return ((EspressoOptional) obj).delegate.equals(this.delegate);
        }
        return false;
    }

    public T get() {
        return (T) this.delegate.get();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public boolean isPresent() {
        return this.delegate.isPresent();
    }

    public Optional<T> or(Optional<? extends T> optional) {
        return this.delegate.or((Optional) optional);
    }

    public T orNull() {
        return (T) this.delegate.orNull();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public <V> Optional<V> transform(Function<? super T, V> function) {
        return this.delegate.transform(function);
    }

    public T or(Supplier<? extends T> supplier) {
        return (T) this.delegate.or((Supplier) supplier);
    }

    public T or(T t) {
        return (T) this.delegate.or((Optional) t);
    }
}
