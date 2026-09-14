package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda34 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ double[] f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda34(double[] dArr) {
        this.f$0 = dArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return ArrayUtils.toObject(this.f$0);
    }
}
