package com.amazonaws.internal;

import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SdkFilterOutputStream extends FilterOutputStream implements MetricAware {
    public SdkFilterOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.amazonaws.internal.MetricAware
    public boolean isMetricActivated() {
        Closeable closeable = ((FilterOutputStream) this).out;
        if (closeable instanceof MetricAware) {
            return ((MetricAware) closeable).isMetricActivated();
        }
        return false;
    }
}
