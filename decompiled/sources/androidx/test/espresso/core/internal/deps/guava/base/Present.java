package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final Object reference;

    Present(Object obj) {
        this.reference = obj;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Set asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object get() {
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object orNull() {
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public String toString() {
        String strValueOf = String.valueOf(this.reference);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Optional transform(Function function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.base.Optional
    public Object or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }
}
