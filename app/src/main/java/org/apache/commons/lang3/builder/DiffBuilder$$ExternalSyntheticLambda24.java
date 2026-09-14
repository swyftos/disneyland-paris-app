package org.apache.commons.lang3.builder;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda24 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ byte f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda24(byte b) {
        this.f$0 = b;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Byte.valueOf(this.f$0);
    }
}
