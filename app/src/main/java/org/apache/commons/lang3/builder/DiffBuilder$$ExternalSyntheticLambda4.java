package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda4 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ double f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda4(double d) {
        this.f$0 = d;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Double.valueOf(this.f$0);
    }
}
