package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: classes2.dex */
abstract class LifecycleNAryOperator extends LifecycleFilterPredicate {
    private final List operands;

    public LifecycleNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
