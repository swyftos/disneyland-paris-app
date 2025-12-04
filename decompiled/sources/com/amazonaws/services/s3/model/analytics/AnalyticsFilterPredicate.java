package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
