package org.apache.commons.lang3.builder;

import java.io.Serializable;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class DiffBuilder$$ExternalSyntheticLambda20 implements DiffBuilder.SerializableSupplier, Serializable {
    public final /* synthetic */ byte[] f$0;

    public /* synthetic */ DiffBuilder$$ExternalSyntheticLambda20(byte[] bArr) {
        this.f$0 = bArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return ArrayUtils.toObject(this.f$0);
    }
}
