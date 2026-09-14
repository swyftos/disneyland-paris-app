package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda30 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ int f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda30(int i) {
        this.f$0 = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0);
    }
}
