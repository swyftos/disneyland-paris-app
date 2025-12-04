package com.amazonaws.metrics;

/* loaded from: classes2.dex */
public abstract class SimpleMetricType implements MetricType {
    @Override // com.amazonaws.metrics.MetricType
    public abstract String name();

    public final int hashCode() {
        return name().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MetricType) {
            return name().equals(((MetricType) obj).name());
        }
        return false;
    }

    public final String toString() {
        return name();
    }
}
