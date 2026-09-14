package com.amazonaws.services.p017s3.model.metrics;

/* JADX INFO: loaded from: classes2.dex */
public interface MetricsPredicateVisitor {
    void visit(MetricsAndOperator metricsAndOperator);

    void visit(MetricsPrefixPredicate metricsPrefixPredicate);

    void visit(MetricsTagPredicate metricsTagPredicate);
}
