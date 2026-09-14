package com.amazonaws.services.p017s3.model.analytics;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class AnalyticsNAryOperator extends AnalyticsFilterPredicate {
    private final List operands;

    public AnalyticsNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
