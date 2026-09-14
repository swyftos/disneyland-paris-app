package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda0 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ Object[] f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda0(Object[] objArr) {
        this.f$0 = objArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return DiffBuilder.lambda$append$dbd51caa$1(this.f$0);
    }
}
