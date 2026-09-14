package com.amazonaws.services.p017s3.model.lifecycle;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LifecycleFilterPredicate implements Serializable {
    public abstract void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor);
}
