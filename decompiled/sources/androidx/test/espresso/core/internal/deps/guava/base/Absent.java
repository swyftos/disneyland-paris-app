package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
final class Absent<T> extends Optional<T> {
    static final Absent INSTANCE = new Absent();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    static Optional withType() {
        return INSTANCE;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Set asSet() {
        return Collections.emptySet();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional or(Optional optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object orNull() {
        return null;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional transform(Function function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object or(Supplier supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object or(Object obj) {
        return Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
    }
}
