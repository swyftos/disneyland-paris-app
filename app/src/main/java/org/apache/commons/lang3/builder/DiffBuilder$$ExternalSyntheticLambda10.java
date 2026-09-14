package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda10 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ char f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda10(char c) {
        this.f$0 = c;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Character.valueOf(this.f$0);
    }
}
