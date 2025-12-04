package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ForwardingSet;
import java.util.Set;

/* loaded from: classes4.dex */
final class InvalidatableSet extends ForwardingSet {
    private final Set delegate;
    private final Supplier errorMessage;
    private final Supplier validator;

    public static final InvalidatableSet of(Set set, Supplier supplier, Supplier supplier2) {
        return new InvalidatableSet((Set) Preconditions.checkNotNull(set), (Supplier) Preconditions.checkNotNull(supplier), (Supplier) Preconditions.checkNotNull(supplier2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Set delegate() {
        validate();
        return this.delegate;
    }

    private InvalidatableSet(Set set, Supplier supplier, Supplier supplier2) {
        this.delegate = set;
        this.validator = supplier;
        this.errorMessage = supplier2;
    }

    @Override // com.google.common.collect.ForwardingSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.delegate.hashCode();
    }

    private void validate() {
        if (!((Boolean) this.validator.get()).booleanValue()) {
            throw new IllegalStateException((String) this.errorMessage.get());
        }
    }
}
