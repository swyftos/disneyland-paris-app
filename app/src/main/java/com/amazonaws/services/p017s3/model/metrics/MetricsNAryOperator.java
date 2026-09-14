package com.amazonaws.services.p017s3.model.metrics;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class MetricsNAryOperator extends MetricsFilterPredicate {
    private final List operands;

    public MetricsNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
