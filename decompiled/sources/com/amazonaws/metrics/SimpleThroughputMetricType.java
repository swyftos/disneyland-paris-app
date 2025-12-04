package com.amazonaws.metrics;

/* loaded from: classes2.dex */
public class SimpleThroughputMetricType extends SimpleServiceMetricType implements ThroughputMetricType {
    private final ServiceMetricType byteCountMetricType;

    public SimpleThroughputMetricType(String str, String str2, String str3) {
        super(str, str2);
        this.byteCountMetricType = new SimpleServiceMetricType(str3, str2);
    }

    @Override // com.amazonaws.metrics.ThroughputMetricType
    public ServiceMetricType getByteCountMetricType() {
        return this.byteCountMetricType;
    }
}
