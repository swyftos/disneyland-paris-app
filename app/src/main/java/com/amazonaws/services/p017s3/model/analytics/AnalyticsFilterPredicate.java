package com.amazonaws.services.p017s3.model.analytics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
