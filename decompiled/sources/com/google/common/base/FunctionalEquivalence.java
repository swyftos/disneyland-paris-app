package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class FunctionalEquivalence extends Equivalence implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function function;
    private final Equivalence resultEquivalence;

    FunctionalEquivalence(Function function, Equivalence equivalence) {
        this.function = (Function) Preconditions.checkNotNull(function);
        this.resultEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(Object obj, Object obj2) {
        return this.resultEquivalence.equivalent(this.function.apply(obj), this.function.apply(obj2));
    }

    @Override // com.google.common.base.Equivalence
    protected int doHash(Object obj) {
        return this.resultEquivalence.hash(this.function.apply(obj));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
