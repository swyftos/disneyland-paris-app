package com.amazonaws.services.p017s3.model.metrics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MetricsFilterPredicate implements Serializable {
    public abstract void accept(MetricsPredicateVisitor metricsPredicateVisitor);
}
