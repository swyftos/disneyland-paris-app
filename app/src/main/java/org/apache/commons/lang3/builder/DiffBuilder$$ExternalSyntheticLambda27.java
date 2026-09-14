package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda27 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda27(Object obj) {
        this.f$0 = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return DiffBuilder.lambda$append$9e3d8e65$1(this.f$0);
    }
}
