package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda14 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda14(boolean z) {
        this.f$0 = z;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Boolean.valueOf(this.f$0);
    }
}
