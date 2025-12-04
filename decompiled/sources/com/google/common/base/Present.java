package com.google.common.base;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
final class Present extends Optional {
    private static final long serialVersionUID = 0;
    private final Object reference;

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    Present(Object obj) {
        this.reference = obj;
    }

    @Override // com.google.common.base.Optional
    public Object get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Object or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Object orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Set asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public Optional transform(Function function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
