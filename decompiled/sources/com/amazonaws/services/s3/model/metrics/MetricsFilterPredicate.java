package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class MetricsFilterPredicate implements Serializable {
    public abstract void accept(MetricsPredicateVisitor metricsPredicateVisitor);
}
