package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda6 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ float f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda6(float f) {
        this.f$0 = f;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Float.valueOf(this.f$0);
    }
}
